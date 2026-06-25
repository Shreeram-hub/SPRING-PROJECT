# SPRING-PROJECT
📌 Spring Boot & Data JPA: 掲示板アプリケーション（プロフェッショナルアーキテクチャ）
https://img.shields.io/badge/Java-17+-red?logo=java
https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot
https://img.shields.io/badge/Spring%20Data-JPA-blue?logo=hibernate
https://img.shields.io/badge/Thymeleaf-Templates-success?logo=thymeleaf
https://img.shields.io/badge/MySQL-Dockerized-blue?logo=mysql
https://img.shields.io/badge/Maven-Build-orange?logo=apachemaven

⭐ プロフェッショナル概要
このリポジトリは、Spring Boot 3 / Spring Data JPA / Thymeleaf を用いて構築した
エンタープライズ品質のデータベース連携型 Web アプリケーションです。

以下のような実務レベルのスキルを示しています：

拡張性の高いバックエンドアーキテクチャ設計

JPA を用いたリレーショナルデータモデリング

サーバーサイドバリデーションによる堅牢な入力チェック

Thymeleaf を使った動的 UI レンダリング

MVC + Service + Repository のクリーンなレイヤード構造

🚀 プロジェクト概要
本アプリケーションは、以下の機能を備えた フルスタック掲示板システムです：

正規化されたリレーショナルデータベース構造

マスタテーブルを用いた UI の動的生成

バリデーション付き CRUD 操作

カテゴリによる検索・絞り込み

カスタムバリデーションロジック

MVC + Service + Repository の明確な責務分離

🛠 Spring Framework で実装しているスキル
アーキテクチャ / Spring 基盤
Controller → Service → Repository のスケーラブルな MVC 構造

DI（依存性注入）による疎結合設計

責務分離を徹底したレイヤードアーキテクチャ

データ永続化（Spring Data JPA）
@Entity, @Id, @GeneratedValue を用いた ORM

@ManyToOne, @JoinColumn によるリレーション構築

JpaRepository による CRUD 実装

メソッド名ベースのクエリによる検索機能

Web / リクエスト処理
@GetMapping, @PostMapping, @PathVariable, @RequestParam

@ModelAttribute によるフォームデータバインド

PRG（Post-Redirect-Get）パターンの実装

バリデーション / セキュリティ
@NotBlank, @Size などの JSR-303 バリデーション

カスタムアノテーション + ConstraintValidator

禁止ワードチェックなどのビジネスルール実装

フロントエンド（Thymeleaf）
th:if, th:unless, th:object, *{...} を用いた動的テンプレート

th:errors によるエラーメッセージ表示

DB と連動したプルダウン・検索フィルタ

🌟 主な機能
機能	説明
リレーショナルデータ整合性	正規化されたマスタテーブル構造
スマート保存処理	ID の有無で新規/更新を自動判定
検索・絞り込み	カテゴリによるフィルタリング
UI バリデーション	Thymeleaf によるリアルタイムエラー表示
削除戦略	物理削除を実装（論理削除の知識も考慮）
動的 UI	DB と同期したプルダウン・検索条件


🧩 アーキテクチャ図
🏗 システム全体構成
コード
                ┌──────────────────────────┐
                │        Browser UI        │
                │     (Thymeleaf Views)    │
                └─────────────┬────────────┘
                              │
                              ▼
                ┌──────────────────────────┐
                │        Controller         │
                │  (HTTP リクエスト処理)    │
                └─────────────┬────────────┘
                              │
                              ▼
                ┌──────────────────────────┐
                │         Service           │
                │   (ビジネスロジック層)    │
                └─────────────┬────────────┘
                              │
                              ▼
                ┌──────────────────────────┐
                │       Repository          │
                │ (Spring Data JPA 層)      │
                └─────────────┬────────────┘
                              │
                              ▼
                ┌──────────────────────────┐
                │         Database          │
                │          MySQL            │
                └──────────────────────────┘
🔄 Spring MVC リクエストフロー
コード
[Browser] 
    │  HTTP Request
    ▼
[Controller] 
    │  Delegates
    ▼
[Service] 
    │  Calls
    ▼
[Repository] 
    │  Executes
    ▼
[Database]

<--- Response returns through the layers ---
🗄 ER 図（データベース構造）
コード
┌───────────────┐         ┌──────────────────┐
│  GenreEntity   │ 1     ∞ │   BoardEntity    │
├───────────────┤─────────┤──────────────────┤
│ id (PK)        │         │ id (PK)          │
│ name           │         │ title            │
└───────────────┘         │ content          │
                          │ genre_id (FK)    │
                          └──────────────────┘
💻 技術スタック
レイヤー	技術
言語	Java 17+
フレームワーク	Spring Boot 3
永続化	Spring Data JPA
DB	MySQL（Docker）
テンプレート	Thymeleaf
ビルド	Maven
DB 管理	Navicat Premium Lite


📂 フォルダ構成
コード
src/main/java/com/example/demo/
├── controller/
├── entity/
├── repository/
├── service/
└── validation/

src/main/resources/
├── templates/
├── static/css/
└── application.properties
📝 コード例
1. リレーションマッピング
java
@Entity
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private GenreEntity genre;
}
2. カスタムバリデーション
java
public class NoForbiddenWordValidator 
        implements ConstraintValidator<NoForbiddenWord, String> {

    private final List<String> forbiddenWords = List.of("forbidden1", "forbidden2");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null || value.isEmpty()) return true;
        return forbiddenWords.stream().noneMatch(value::contains);
    }
}
🏃 実行方法
MySQL の Docker コンテナを起動

application.properties を環境に合わせて設定

ビルド

コード
mvn clean install
アプリ起動

コード
./mvnw spring-boot:run
アクセス
http://localhost:8080/board

💼 このプロジェクトの価値
保守性：マスタテーブル + 動的 UI により変更に強い

安全性：サーバーサイドバリデーションで堅牢

実務品質：PRG パターン、レイヤード設計、JPA モデリング

拡張性：サービス層を中心としたスケーラブルな構造
