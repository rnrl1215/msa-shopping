-- 1. 메인 애플리케이션용 스키마 생성
CREATE DATABASE IF NOT EXISTS shopping_order CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

       -- 사용자 생성 및 권한 부여
CREATE USER 'shop_admin'@'%' IDENTIFIED BY 'user123#@!';

CREATE USER 'order_user'@'%' IDENTIFIED BY 'user123#@!';

-- 모든 DB에 대한 권한 부여 (또는 특정 DB만 지정 가능)
GRANT ALL PRIVILEGES ON shopping_order.* TO 'shop_admin'@'%';

GRANT ALL PRIVILEGES ON shopping_order.* TO 'order_user'@'%';

FLUSH PRIVILEGES;