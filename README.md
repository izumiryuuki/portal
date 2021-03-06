ポータルサイト
======================

## Overview  
社内で使うアプリケーションシステムです。

Note
-------
社内勉強会用に使います。

環境
-------
* git
  * Git for Windows (https://gitforwindows.org/)
  * TortoiseGit (https://tortoisegit.org/) (Language Packsも必要です）
* JDK
  * Adopt Open JDK 11  (https://adoptopenjdk.net/) 
* RDB  
  * PostgreSQL 12.4 (https://www.enterprisedb.com/downloads/postgres-postgresql-downloads)
* IDE
  * Spring Tool Suite 4.4.6.2 (https://spring.io/tools) ※Spring Tools 4 for Eclipseがお勧めです。  
* FrameWork
  * Spring
* RDBアクセス
  * JDBC、MyBatis 
* CSS
  * Bootstrap
* Build
  * Maven
* その他
  * Lombok (https://projectlombok.org/download)
  
【環境構築手順】  
１．GitHubアカウントを作成し、自PCにgitツールをインストールします。  
　　⇒参考（https://qiita.com/SkyLaptor/items/6347f38c8c010f4d5bd2  )  
　　※作業手順は公開鍵の登録まででOKです。  
２．JDKをインストールします。  
　　⇒参考（https://www.javadrive.jp/start/install/index6.html ）  
３．RDBをインストールします。  
　　⇒参考（https://eng-entrance.com/postgresql-download-install ）  
４．IDEをインストールします。  
　　⇒参考（https://techfun.cc/spring/windows-spring-install.html  )  
  　　日本語化（https://nobuzii.hatenablog.com/entry/2020/03/17/002607 )  
５．Lombokをインストールします。  
　　⇒参考（ https://qiita.com/r_saiki/items/82231ded1450f5ed5671 )  
６．自GitHubアカウントにStudyGroup202010アカウントのportalリポジトリをforkしてください。  
　　⇒参考（https://denno-sekai.com/github-fork/ ）  
７．自PCに作業用フォルダを作り、自GitHubアカウントにforkしたリポジトリをクローン（複製）してください。  
　　⇒参考（https://pasomaki.com/tortoisegit-clone/ ）  
　　【注意】クローンするのはmasterブランチではなくtopicブランチを使ってください。  
８．自PCにクローンしたリポジトリのenvironmentフォルダのSQLを使ってRDBにDBとTableを作成してください。  
　　※テストデータも追加してください。  
９．IDEにリポジトリをインポートしてコンパイルし、ブラウザから「http://localhost:8080/login」 を起動してください。  
　　⇒参考（https://bit.ly/3iTNHSk ）  
　　※インポートするときの「ルートディレクトリ」は、クローンした「portal」フォルダを指定してください。  

アプリケーション構成
-------
com   
 └ portal  
　　├ z  ・・・　全体の共通機能  
　　│　├ common  ・・・zの共通機能  
　　│　│　├ aspect  
　　│　│　├ config  
　　│　│　├ controller  
　　│　│　└ domain  
　　│　│　　├ model  
　　│　│　　├ repository  
　　│　│　　└ service  
　　│　└ 〇〇〇  ・・・zの個別機能（〇〇画面など）  
　　│　　　├ controller  
　　│　　　└ domain  
　　│　　　　　├ model  
　　│　　　　　├ repository  
　　│　　　　　└ service  
　　│  
　　├ a  ・・・アプリケーションＡ  
　　│　├ common  ・・・Ａの共通機能  
　　│　│　├ config  
　　│　│　├ controller  
　　│　│　└ domain  
　　│　└ 〇〇〇  ・・・Ａの個別機能  
　　│　　├ controller  
　　│　　└ domain  
　　│  
　　└ b  ・・・アプリケーションＢ     
 
References
-------
* こちらのサイトが参考になります。⇒　<https://terasolunaorg.github.io/guideline/5.6.0.RELEASE/ja/>  
* 書籍はこちら⇒【後悔しないための入門書】Spring解体新書（https://amzn.to/3jDEaQy)  
* ブランチ運用ルールはGitHubFlowにします。（https://engineer-life.dev/git-operation-rule/)  


Contributing
-------
１．システムを動かしてみて、不具合を見つけたり、追加したい機能が浮かんだら、イシューを追加してください。  
２．イシューの中から自分ができそうなものを選んで、自PCにクローンしたリポジトリに実装してみてください。   
３．実装してテストをしたら、プルリクエストを送ってください。レビューしてmasterブランチにマージします。  


Authors
----------
Copyright &copy; 〇〇〇
  
License
----------
Distributed under the [MIT License][mit].
 
[MIT]: http://www.opensource.org/licenses/mit-license.php
