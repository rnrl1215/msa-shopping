CREATE DATABASE IF NOT EXISTS shopping_payment CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;


CREATE USER 'shop_admin'@'%' IDENTIFIED BY 'user123#@!';

CREATE USER 'payment_user'@'%' IDENTIFIED BY 'user123#@!';

-- 모든 DB에 대한 권한 부여 (또는 특정 DB만 지정 가능)
GRANT ALL PRIVILEGES ON shopping_payment.* TO 'shop_admin'@'%';

GRANT ALL PRIVILEGES ON shopping_payment.* TO 'payment_user'@'%';

FLUSH PRIVILEGES;