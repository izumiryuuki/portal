package com.portal.z.common.domain.model;

import java.util.Date;

import lombok.Data;

@Data
public class Role {
    private String  role_id;     //ロールID
    private String  role_name;   //ロール名
    private String  biko;        //備考
    private String  insert_user; //作成者
    private Date    insert_date; //作成日時
    private String  update_user; //更新者
    private Date    update_date; //更新日時
}
