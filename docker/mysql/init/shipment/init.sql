-- 1. 테스트/개발용 스키마 생성 (선택 사항)
CREATE DATABASE IF NOT EXISTS shopping_shipping CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

       -- 사용자 생성 및 권한 부여
CREATE USER 'shop_admin'@'%' IDENTIFIED BY 'user123#@!';

CREATE USER 'delivery_user'@'%' IDENTIFIED BY 'user123#@!';

-- 모든 DB에 대한 권한 부여 (또는 특정 DB만 지정 가능)
GRANT ALL PRIVILEGES ON shopping_shipping.* TO 'shop_admin'@'%';

GRANT ALL PRIVILEGES ON shopping_shipping.* TO 'delivery_user'@'%';

FLUSH PRIVILEGES;