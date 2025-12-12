-- 1. 메인 애플리케이션용 스키마 생성
CREATE DATABASE IF NOT EXISTS shopping_order CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- 2. 분석 또는 레거시 데이터용 스키마 생성
CREATE DATABASE IF NOT EXISTS shopping_payment CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- 3. 테스트/개발용 스키마 생성 (선택 사항)
CREATE DATABASE IF NOT EXISTS shopping_shipping CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;