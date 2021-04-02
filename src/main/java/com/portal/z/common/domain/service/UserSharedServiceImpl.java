package com.portal.z.common.domain.service;

import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portal.z.common.domain.model.Role;
import com.portal.z.common.domain.model.User;
import com.portal.z.common.domain.model.Userrole;
import com.portal.z.common.domain.repository.RoleMapper;
import com.portal.z.common.domain.repository.UserMapper;
import com.portal.z.common.domain.repository.UserroleMapper;
import com.portal.z.common.exception.ApplicationException;
import com.portal.z.common.domain.util.Constants;
import com.portal.z.common.domain.util.DateUtils;
import com.portal.z.common.domain.util.MassageUtils;

/**
 * ユーザマスタ用共通サービス
 *
 */
@Transactional
@Service
public class UserSharedServiceImpl implements UserSharedService {

    @Autowired
    private UserroleMapper userroleMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private EnvSharedService envSharedService;

    @Autowired
    private DateUtils dateUtils;

    // パスワード暗号化
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private MassageUtils massageUtils;

    public boolean insertOne(User user) {

        // 環境マスタに登録したロール名（一般ユーザ）のrole_idを取得する
        // 取得できない(取得結果がnull)の場合、処理を中止する
        Role role = roleMapper.selectRoleid(Constants.ROLE_NAME.ROLE_NAME_G.name());
        if (role == null) {
            String messageKey = "e.co.fw.3.001";
            throw new ApplicationException(messageKey,
                    massageUtils.getMsg(messageKey, new String[] { Constants.ROLE_NAME.ROLE_NAME_G.name() }));
        }

        // ユーザロールマスタinsert用変数
        Userrole userrole = new Userrole();
        userrole.setUser_id(user.getUser_id()); // ユーザーID
        userrole.setRole_id(role.getRole_id()); // ロールID

        // 登録実行
        try {
            boolean result_1 = userMapper.insertOne(user);
            boolean result_2 = userroleMapper.insertOne(userrole);

            // ユーザー登録結果の判定
            if (result_1 == true && result_2 == true) {
                return true;
            } else {
                return false;
            }

        } catch (DuplicateKeyException e) {
            // 一意制約エラーが発生した時はビジネス例外として返す。
            String messageKey = "e.co.fw.2.003";
            throw new ApplicationException(messageKey,
                    massageUtils.getMsg(messageKey, new String[] { user.getUser_id() }), e);
        }
    }

    public boolean deleteOne(String user_id) {

        // 削除実行
        boolean result_1 = userroleMapper.deleteOne(user_id);
        boolean result_2 = userMapper.deleteOne(user_id);

        if (result_1 == true && result_2 == true) {
            return true;
        } else {
            return false;
        }
    }

    public boolean updatePasswordDate(String userId, String password) throws ParseException {

        // パスワード有効期限月数の初期値
        int PASS_UPDATE_NXT = Constants.PASS_UPDATE_NXT;

        // 環境マスタに登録したパスワード有効期限月数を取得
        Integer env = envSharedService.selectIntOne("PASS_UPDATE_NXT");

        if (env != null) {
            PASS_UPDATE_NXT = env;
        }

        // パスワード有効期限を計算
        Date passwordUpdateDate = Date
                .valueOf(dateUtils.calcDate(LocalDateTime.now(), "MM", PASS_UPDATE_NXT).toLocalDate());

        // Userインスタンスの生成
        User user = new User();

        // フォームクラスをUserクラスに変換
        user.setUser_id(userId); // ユーザーID
        user.setPassword(password); // パスワード
        user.setPass_update(passwordUpdateDate); // パスワード有効期限
        user.setUpdate_user(userId); // 更新者はログインしようとしているユーザ

        // パスワード更新
        return userMapper.updatePassupdate(user);

    }
}
