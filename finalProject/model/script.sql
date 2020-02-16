USE workshopDB

-- -----------------------------------------------------
 -- Table role
-- -----------------------------------------------------

IF NOT EXISTS (SELECT * FROM sys.tables where [name] = 'role' ) 
CREATE TABLE role (
  ID INT NOT NULL,
  name VARCHAR(45) UNIQUE NOT NULL,
  PRIMARY KEY (ID) )
  --UNIQUE INDEX 'name_UNIQUE' (name ASC) VISIBLE)

-- -----------------------------------------------------
  -- Table userState
-- -----------------------------------------------------

IF NOT EXISTS (SELECT * FROM sys.tables where [name] = 'userState' ) 
CREATE TABLE userState (
  ID INT NOT NULL,
  state VARCHAR(45) NOT NULL,
  PRIMARY KEY (ID) )
 -- UNIQUE INDEX `state_UNIQUE` (`state` ASC) VISIBLE)


-- -----------------------------------------------------
 -- Table basket
-- -----------------------------------------------------

IF NOT EXISTS (SELECT * FROM sys.tables where [name] = 'basket' ) 
CREATE TABLE `basket` (
  ID INT NOT NULL,
  PRIMARY KEY (ID) )


-- -----------------------------------------------------
 -- Table user
-- -----------------------------------------------------

IF NOT EXISTS (SELECT * FROM sys.tables where [name] = 'user' ) 
CREATE TABLE user (
  ID INT NOT NULL AUTO_INCREMENT,
  role_ID INT NOT NULL,
  `username` VARCHAR(64) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `name` VARCHAR(45) NULL,
  `surname` VARCHAR(45) NULL,
  `patronymic` VARCHAR(45) NULL,
  `email` VARCHAR(64) NOT NULL,
  `phone` VARCHAR(64) NULL,
  `userState_ID` INT NOT NULL,
  `basket_ID` INT NOT NULL,
  PRIMARY KEY (`ID`, `role_ID`, `userState_ID`, `basket_ID`),
  UNIQUE INDEX `КодЗаписи_UNIQUE` (`ID` ASC) VISIBLE,
  INDEX `fk_user_role_idx` (`role_ID` ASC) VISIBLE,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
  INDEX `fk_user_userState1_idx` (`userState_ID` ASC) VISIBLE,
  INDEX `fk_user_basket1_idx` (`basket_ID` ASC) VISIBLE,
  CONSTRAINT `fk_user_role`
    FOREIGN KEY (`role_ID`)
    REFERENCES `mydb`.`role` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_user_userState1`
    FOREIGN KEY (`userState_ID`)
    REFERENCES `mydb`.`userState` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_user_basket1`
    FOREIGN KEY (`basket_ID`)
    REFERENCES `mydb`.`basket` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `mydb`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`order` (
  `orderID` INT NOT NULL,
  `user_ID` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `wishes` TEXT NULL,
  PRIMARY KEY (`orderID`, `user_ID`),
  INDEX `fk_order_user1_idx` (`user_ID` ASC) VISIBLE,
  CONSTRAINT `fk_order_user1`
    FOREIGN KEY (`user_ID`)
    REFERENCES `mydb`.`user` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`productState`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`productState` (
  `ID` INT NOT NULL,
  `state` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `state_UNIQUE` (`state` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`product` (
  `ID` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `price` DOUBLE NULL,
  `description` TEXT NULL,
  `product_productStateID` INT NOT NULL,
  `basket_ID` INT NOT NULL,
  PRIMARY KEY (`ID`, `product_productStateID`, `basket_ID`),
  INDEX `fk_product_productState1_idx` (`product_productStateID` ASC) VISIBLE,
  INDEX `fk_product_basket1_idx` (`basket_ID` ASC) VISIBLE,
  CONSTRAINT `fk_product_productState1`
    FOREIGN KEY (`product_productStateID`)
    REFERENCES `mydb`.`productState` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_product_basket1`
    FOREIGN KEY (`basket_ID`)
    REFERENCES `mydb`.`basket` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`obtainingMethod`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`obtainingMethod` (
  `ID` INT NOT NULL,
  `method` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`paymentMethod`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`paymentMethod` (
  `ID` INT NOT NULL,
  `method` VARCHAR(127) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`purchase`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`purchase` (
  `ID` INT NOT NULL,
  `address` VARCHAR(255) NULL,
  `obtainingMethod_ID` INT NOT NULL,
  `paymentMethod_ID` INT NOT NULL,
  PRIMARY KEY (`ID`, `obtainingMethod_ID`, `paymentMethod_ID`),
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) VISIBLE,
  INDEX `fk_purchase_obtainingMethod1_idx` (`obtainingMethod_ID` ASC) VISIBLE,
  INDEX `fk_purchase_paymentMethod1_idx` (`paymentMethod_ID` ASC) VISIBLE,
  CONSTRAINT `fk_purchase_obtainingMethod1`
    FOREIGN KEY (`obtainingMethod_ID`)
    REFERENCES `mydb`.`obtainingMethod` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_purchase_paymentMethod1`
    FOREIGN KEY (`paymentMethod_ID`)
    REFERENCES `mydb`.`paymentMethod` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
