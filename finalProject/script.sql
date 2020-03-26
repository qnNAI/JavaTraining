USE `workshopDB`;

-- -------------------------------------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS workshopDB.user (
                                    `id` INT NOT NULL UNIQUE AUTO_INCREMENT,
                                    `username` VARCHAR(45) NOT NULL,
                                    `password` VARCHAR(45) NOT NULL,
                                    `role` ENUM('0', '1') NOT NULL,
                                    `state` ENUM('0', '1') NOT NULL,
                                    `name` VARCHAR(45) NOT NULL,
                                    `surname` VARCHAR(45) NOT NULL,
                                    `patronymic` VARCHAR(45) NULL,
                                    `email` VARCHAR(45) NOT NULL,
                                    `phone` VARCHAR(45) NULL,
                                    PRIMARY KEY (`id`) );

CREATE UNIQUE INDEX  username_UNIQUE  ON workshopDB.user(username ASC) VISIBLE ;

-- -------------------------------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS workshopDB.product (
                                       `id` INT NOT NULL UNIQUE AUTO_INCREMENT,
                                       `name` VARCHAR(45) NOT NULL,
                                       `price` DOUBLE NOT NULL,
                                       `description` VARCHAR(45) NULL,
                                       `image_path` VARCHAR(45) NULL,
                                       PRIMARY KEY (`id`) );

-- -------------------------------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS workshopDB.localAddress (
                                            `id` INT NOT NULL UNIQUE AUTO_INCREMENT,
                                            `address` VARCHAR(45) NOT NULL,
                                            PRIMARY KEY (`id`) );

-- -------------------------------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------------------------------


CREATE TABLE IF NOT EXISTS workshopDB.obtainingMethod (
                                               `id` INT NOT NULL UNIQUE AUTO_INCREMENT,
                                               `method` VARCHAR(45) NOT NULL,
                                               PRIMARY KEY (`id`) );

CREATE UNIQUE INDEX method_UNIQUE ON workshopDB.obtainingMethod(method ASC) VISIBLE ;

-- -------------------------------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS workshopDB.order (
                                                `id` INT NOT NULL UNIQUE AUTO_INCREMENT,
                                                `name` VARCHAR(45) NOT NULL,
                                                `wishes` VARCHAR(255) NOT NULL,
                                                `user_id` INT NOT NULL,
                                                PRIMARY KEY (`id`, `user_id`) );

CREATE INDEX fk_order_user_idx ON workshopDB.order(user_id ASC) VISIBLE ;

ALTER TABLE workshopDB.order ADD CONSTRAINT fk_order_user
    FOREIGN KEY (user_id)
        REFERENCES user (id)
        ON DELETE CASCADE
        ON UPDATE CASCADE;

-- -------------------------------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS workshopDB.purchase (
                                        `id` INT NOT NULL,
                                        `product_id` INT NOT NULL,
                                        `user_id` INT NOT NULL,
                                        `finalPrice` DOUBLE NOT NULL,
                                        `address` VARCHAR(45) NULL,
                                        `localAddress_id` INT NULL,
                                        `date` DATETIME NOT NULL,
                                        `state` ENUM('добавлен', 'заказан', 'доставлен') NOT NULL,
                                        `obtainingMethod_id` INT NOT NULL,
                                        PRIMARY KEY (`id`, `product_id`, `user_id`, `obtainingMethod_id`) );

CREATE INDEX fk_purchase_product1_idx ON workshopDB.purchase(product_id ASC) VISIBLE;
CREATE INDEX fk_purchase_user1_idx ON workshopDB.purchase(user_id ASC) VISIBLE;
CREATE INDEX fk_purchase_localAddress1_idx ON workshopDB.purchase(localAddress_id ASC) VISIBLE;
CREATE INDEX fk_purchase_obtainingMethod1_idx ON workshopDB.purchase(obtainingMethod_id ASC) VISIBLE;

ALTER TABLE workshopDB.purchase
    ADD CONSTRAINT fk_purchase_product
        FOREIGN KEY (`product_id`)
            REFERENCES product (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    ADD CONSTRAINT fk_purchase_user
        FOREIGN KEY (`user_id`)
            REFERENCES user (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    ADD CONSTRAINT fk_purchase_localAddress
        FOREIGN KEY (`localAddress_id`)
            REFERENCES localAddress (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION ,
    ADD CONSTRAINT fk_purchase_obtainingMethod
        FOREIGN KEY (`obtainingMethod_id`)
            REFERENCES obtainingMethod (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE;

-- -------------------------------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS workshopDB.confirmedOrder (
                                              `id` INT NOT NULL,
                                              `order_id` INT NOT NULL,
                                              `state` ENUM('изготавливается', 'готов', 'доставлен') NOT NULL,
                                              `finalPrice` DOUBLE NOT NULL,
                                              `amount` INT NOT NULL,
                                              `address` VARCHAR(45) NULL,
                                              `localAddress_id` INT NULL,
                                              `date` DATETIME NOT NULL,
                                              `obtainingMethod_id` INT NOT NULL,
                                              PRIMARY KEY (`id`, `order_id`, `obtainingMethod_id`) );

CREATE INDEX fk_confirmedOrder_obtainingMethod1_idx ON workshopDB.confirmedOrder(obtainingMethod_id ASC) VISIBLE;
CREATE INDEX fk_confirmedOrder_localAddress1_idx ON workshopDB.confirmedOrder(localAddress_id ASC) VISIBLE;

ALTER TABLE workshopDB.confirmedOrder
    ADD CONSTRAINT fk_confirmedOrder_obtainingMethod
        FOREIGN KEY (`obtainingMethod_id`)
            REFERENCES obtainingMethod (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    ADD CONSTRAINT fk_confirmedOrder_order
        FOREIGN KEY (`order_id`)
            REFERENCES workshopDB.order (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    ADD CONSTRAINT fk_confirmedOrder_localAddress
        FOREIGN KEY (`localAddress_id`)
            REFERENCES localAddress (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION ;

-- -------------------------------------------------------------------------------------------------------

