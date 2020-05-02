INSERT INTO workshopdb.user (login, password, role, state, name, surname, patronymic, email, phone)
VALUES ("user1", "ee11cbb19052e40b07aac0ca060c23ee", '0', '0', "Вася", "Васильков", "Васильевич", "olkov@mail.ru", "+375 (33) 987-65-43"),
       ("user2", "ee11cbb19052e40b07aac0ca060c23ee", '0', '0', "Сидоров", "Сидор", "Сидорович", "sidor@mail.ru", "+375 (29) 135-79-13"),
       ("user3", "ee11cbb19052e40b07aac0ca060c23ee", '0', '0', "Петров", "Пётр", "Петрович", "petpet@mail.ru", "+375 (29) 246-80-24"),
       ("user4", "ee11cbb19052e40b07aac0ca060c23ee", '0', '0', "Иванов", "Иван", "Иванович", "ivanvan@mail.ru", "+375 (29) 129-38-47"),
       ("user5", "ee11cbb19052e40b07aac0ca060c23ee", '2', '0', "Александров", "Александр", "Александрович", "alexlex@mail.ru", "+375 (29) 567-12-89");
        /* password = user */
INSERT INTO workshopdb.product (name, price, description, image_path)
VALUES ("Медведь Пух", 10.5, "Плюшевый медведь Винни Пух", "bear_pyh.jpg"),
       ("Рыбка золотая", 7.5, "Плюшевая золотая рыбка", "gold_fish.jpg"),
       ("Заяц Крош", 9, "Плюшевый заяц Крош", "crosh_hare.jpg");

INSERT INTO workshopdb.localaddress (address)
VALUES ("ул. Покровского, 13-3"),
       ("пр-т Будёного, 3А-43");

INSERT INTO workshopdb.`order` (name, wishes, user_id)
VALUES ("Медведь большой розовый", "Большие уши, чёрный нос, красное сердечко на груди", 2),
       ("Весёлый банан", "Жёлтый весёлый банан размером с локоть", 3);

INSERT INTO workshopdb.confirmedorder (order_id, state, finalPrice, amount, address, date, obtainingMethod)
VALUE (1, "изготавливается", 15.7, 1, "переул. Смирнова, 7", "2020-05-01", "доставка");

INSERT INTO workshopdb.confirmedorder (order_id, state, finalPrice, amount, localAddress_id, date, obtainingMethod)
VALUE (2, "изготавливается", 15.7, 1, 1, "2020-05-15", "самовывоз");

INSERT INTO workshopdb.purchase (user_id, state, localAddress_id, date, obtainingMethod)
VALUES (4, "заказана", 2, "2020-06-05", "самовывоз"),
       (5, "доставлена", 1, "2020-05-26", "самовывоз");

INSERT INTO workshopdb.productlist (purchase_id, product_id, finalPrice, amount)
VALUES (1, 2, 8, 3),
       (2, 1, 10.7, 1),
       (2, 3, 9, 2);