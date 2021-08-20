概要
-------------------------

以下の要素を含む簡単な Spring Boot アプリケーションです。

* Spring Data JPA でメソッド名からクエリを自動生成
  - `existsByName()`, `deleteByName()`
* `RedirectAttributes` でリダイレクト先にパラメータを送信（Flash Scope）
* バリデーション実装
* `CommandLineRunner` を実装したコンポーネントで、Spring Boot 起動時に  
  DB 初期データを登録するコマンドライン処理を実行
* WebJars で Bootstrap, Bootstrap Icons, jQuery 導入

画面
-------------------------

### 初期表示
<img width="600" src="https://user-images.githubusercontent.com/59589496/130177822-5be043e7-cb86-46ed-b617-e1d4d116e473.png">  

### 商品登録
バリデーション（必須チェック）  
<img width="600" src="https://user-images.githubusercontent.com/59589496/130179894-3cb5e884-20c1-4b17-9369-79938f1521fc.png">  

バリデーション（存在チェック）  
<img width="600" src="https://user-images.githubusercontent.com/59589496/130180047-88b8ebbf-527e-492f-9be3-4d8913af0404.png">  

登録処理  
<img width="600" src="https://user-images.githubusercontent.com/59589496/130182301-152368a4-7b29-44c7-a2a9-f08ed100deca.png">  

### 商品削除
バリデーション（存在チェック）  
<img width="600" src="https://user-images.githubusercontent.com/59589496/130182559-5e776005-d70d-4427-a6f3-7d64271a98bd.png">  
<img width="600" src="https://user-images.githubusercontent.com/59589496/130182673-9cb6d972-0687-42e1-9417-dbd5f6542038.png">  

削除処理  
<img width="600" src="https://user-images.githubusercontent.com/59589496/130183064-2cfb62e1-3fdd-4a0a-b21f-a7a35a17bc4b.png">  

フォルダ構成
-------------------------

<img width="300" src="https://user-images.githubusercontent.com/59589496/130183534-d8370a8a-d88b-4de0-9446-954ec17d2fb3.png">  

依存関係
-------------------------

* Spring Boot DevTools
* Thymeleaf
* Spring Web
* Validation
* Spring Data JPA
* H2 Database
* Lombok
* WebJars
  - Bootstrap
  - Bootstrap Icons
  - jQuery
