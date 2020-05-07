use workshopDB;

CREATE TABLE IF NOT EXISTS workshopDB.user (
                                    `id` INT NOT NULL UNIQUE AUTO_INCREMENT,
                                    `login` VARCHAR(45) NOT NULL UNIQUE,
                                    `password` VARCHAR(45) NOT NULL,
                                    `role` ENUM('0', '1', '2') NOT NULL,
                                    `state` ENUM('0', '1') NOT NULL,
                                    `name` VARCHAR(45) NOT NULL,
                                    `surname` VARCHAR(45) NOT NULL,
                                    `patronymic` VARCHAR(45) NULL,
                                    `email` VARCHAR(45) NOT NULL,
                                    `phone` VARCHAR(45) NULL,
                                    PRIMARY KEY (`id`) );


CREATE TABLE IF NOT EXISTS workshopDB.product (
                                       `id` INT NOT NULL UNIQUE AUTO_INCREMENT,
                                       `user_id` INT NULL,
                                       `name` VARCHAR(45) NOT NULL,
                                       `price` DOUBLE NULL,
                                       `description` VARCHAR(45) NULL,
                                       `image_path` VARCHAR(45) NULL,
                                       PRIMARY KEY (`id`),
                                       FOREIGN KEY (user_id)
                                       REFERENCES user (id)
                                       ON DELETE CASCADE
                                       ON UPDATE CASCADE );


CREATE TABLE IF NOT EXISTS workshopDB.localAddress (
                                            `id` INT NOT NULL UNIQUE AUTO_INCREMENT,
                                            `address` VARCHAR(45) NOT NULL UNIQUE,
                                            PRIMARY KEY (`id`) );


/*CREATE TABLE IF NOT EXISTS workshopDB.order (
                                                `id` INT NOT NULL UNIQUE AUTO_INCREMENT,
                                                `name` VARCHAR(45) NOT NULL,
                                                `wishes` VARCHAR(255) NOT NULL,
                                                `user_id` INT NOT NULL,
                                                PRIMARY KEY (`id`, `user_id`),
                                                FOREIGN KEY (user_id)
                                                REFERENCES user (id)
                                                ON DELETE CASCADE
                                                ON UPDATE CASCADE ); */

/*ALTER TABLE workshopDB.order AUTO_INCREMENT=1000000;*/ /* start from 1 000 000 */


CREATE TABLE IF NOT EXISTS workshopDB.purchase (
                                        `id` INT NOT NULL UNIQUE AUTO_INCREMENT,
                                        `user_id` INT NOT NULL,
                                        `state` ENUM('добавлен', 'заказан', 'доставлен') NOT NULL,
                                        `address` VARCHAR(45) NULL,
                                        `localAddress_id` INT NULL,
                                        `date` DATE NOT NULL,
                                        `obtainingMethod` ENUM('доставка', 'самовывоз') NOT NULL,
                                        PRIMARY KEY (`id`, `user_id`) );

ALTER TABLE workshopDB.purchase
    ADD CONSTRAINT fk_purchase_user
        FOREIGN KEY (`user_id`)
            REFERENCES user (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    ADD CONSTRAINT fk_purchase_localAddress
        FOREIGN KEY (`localAddress_id`)
            REFERENCES localAddress (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;


CREATE TABLE IF NOT EXISTS workshopDB.productList (
                                                       `purchase_id` INT NOT NULL,
                                                       `product_id` INT NOT NULL,
                                                       `finalPrice` DOUBLE NOT NULL,
                                                       `amount` INT NOT NULL,
                                                       PRIMARY KEY (`purchase_id`, `product_id`) );

ALTER TABLE workshopDB.productList
    ADD CONSTRAINT  `fk_productList_product`
        FOREIGN KEY (`product_id`)
            REFERENCES `workshopDB`.`product` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    ADD CONSTRAINT `fk_productList_purchase`
        FOREIGN KEY (`purchase_id`)
            REFERENCES `workshopDB`.`purchase` (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE;



/*CREATE TABLE IF NOT EXISTS workshopDB.confirmedOrder (
                                              `id` INT NOT NULL AUTO_INCREMENT,
                                              `order_id` INT NOT NULL,
                                              `state` ENUM('изготавливается', 'готов', 'доставлен') NOT NULL,
                                              `finalPrice` DOUBLE NOT NULL,
                                              `amount` INT NOT NULL,
                                              `address` VARCHAR(45) NULL,
                                              `localAddress_id` INT NULL,
                                              `date` DATE NOT NULL,
                                              `obtainingMethod` ENUM('доставка', 'самовывоз') NOT NULL,
                                              PRIMARY KEY (`id`, `order_id`) );

ALTER TABLE workshopDB.confirmedOrder
    ADD CONSTRAINT fk_confirmedOrder_order
        FOREIGN KEY (`order_id`)
            REFERENCES workshopDB.order (`id`)
            ON DELETE CASCADE
            ON UPDATE CASCADE,
    ADD CONSTRAINT fk_confirmedOrder_localAddress
        FOREIGN KEY (`localAddress_id`)
            REFERENCES localAddress (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION ;*/




