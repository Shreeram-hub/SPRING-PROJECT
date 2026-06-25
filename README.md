# 📌 Spring Boot & Data JPA: **掲示板アプリケーション（プロフェッショナルアーキテクチャ）**

![Java](https://img.shields.io/badge/Java-17+-red?logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?logo=springboot)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data-JPA-blue?logo=hibernate)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-Templates-success?logo=thymeleaf)
![MySQL](https://img.shields.io/badge/MySQL-Dockerized-blue?logo=mysql)
![Maven](https://img.shields.io/badge/Maven-Build-orange?logo=apachemaven)

---

## ⭐ プロフェッショナル概要

このリポジトリは、**Spring Boot 3 / Spring Data JPA / Thymeleaf** を用いて構築した  
**エンタープライズ品質のデータベース連携型 Web 掲示板アプリケーション**です。

**ポイント:**

- **拡張性の高いバックエンドアーキテクチャ**
- **JPA によるリレーショナルデータモデリング**
- **サーバーサイドバリデーションによる堅牢な入力チェック**
- **Thymeleaf による動的 UI レンダリング**
- **MVC + Service + Repository のレイヤード構造**

---

## 🚀 プロジェクト概要

このプロジェクトは、以下を特徴とする **掲示板システム** です。

- 正規化された **リレーショナルデータベース設計**
- **マスタテーブル** を用いたカテゴリ管理
- **CRUD + バリデーション** を備えた投稿機能
- カテゴリによる **検索・絞り込み**
- **カスタムバリデーション** によるビジネスルール適用
- **PRG パターン** を用いた安全なフォーム送信

---

## 🛠 使用技術 / スタック

| レイヤー       | 技術                             |
| -------------- | -------------------------------- |
| 言語           | **Java 17+**                     |
| フレームワーク | **Spring Boot 3**                |
| 永続化         | **Spring Data JPA**              |
| データベース   | **MySQL（Docker コンテナ）**     |
| テンプレート   | **Thymeleaf**                    |
| ビルド         | **Maven**                        |
| DB 管理        | **Navicat Premium Lite**         |

---

## 🧠 Spring Framework スキル一覧

### 🔹 アーキテクチャ / コア Spring

- **Controller → Service → Repository** のレイヤードアーキテクチャ
- **DI（依存性注入）** による疎結合設計
- 責務分離を意識したクリーンなコード構成

### 🔹 データ永続化（Spring Data JPA）

- `@Entity`, `@Id`, `@GeneratedValue` による **ORM マッピング**
- `@ManyToOne`, `@JoinColumn` による **リレーション構築**
- `JpaRepository` を用いた **CRUD 実装**
- メソッド名ベースの **クエリメソッド** による検索

### 🔹 Web / リクエスト処理

- `@GetMapping`, `@PostMapping`, `@PathVariable`, `@RequestParam`
- `@ModelAttribute` による **フォームデータバインド**
- **PRG（Post-Redirect-Get）パターン** の実装

### 🔹 バリデーション / セキュリティ

- `@NotBlank`, `@Size` などの **JSR-303 バリデーション**
- **カスタムアノテーション + ConstraintValidator**
- 禁止ワードチェックなどの **ビジネスルール実装**

### 🔹 フロントエンド（Thymeleaf）

- `th:if`, `th:unless`, `th:object`, `*{...}` による **動的テンプレート**
- `th:errors` による **エラーメッセージ表示**
- DB と連動した **プルダウン / 絞り込み UI**

---

## 🌟 主な機能

| 機能                         | 説明                                                                 |
| ---------------------------- | -------------------------------------------------------------------- |
| **リレーショナルデータ整合性** | マスタテーブル（ジャンル）と投稿テーブルの正規化されたリレーション構造 |
| **スマート保存処理**         | 主キーの有無で新規作成 / 更新を自動判定                             |
| **検索・絞り込み**           | カテゴリ（ジャンル）による投稿一覧のフィルタリング                   |
| **UI バリデーション**        | Thymeleaf + サーバーサイドバリデーションによるエラー表示             |
| **削除戦略**                 | 物理削除を実装しつつ、論理削除の設計も考慮                          |
| **動的 UI**                  | DB の状態と同期したプルダウン・検索条件 UI                           |

---

## 🧩 アーキテクチャ図

### 🏗 システム全体構成

```text
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
