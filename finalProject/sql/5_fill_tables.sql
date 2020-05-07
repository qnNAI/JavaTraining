INSERT INTO workshopdb.user (login, password, role, state, name, surname, patronymic, email, phone)
VALUES ("user1", "ee11cbb19052e40b07aac0ca060c23ee", '0', '0', "Вася", "Васильков", "Васильевич", "olkov@mail.ru", "+375 (33) 987-65-43"),
       ("user2", "ee11cbb19052e40b07aac0ca060c23ee", '0', '0', "Сидоров", "Сидор", "Сидорович", "sidor@mail.ru", "+375 (29) 135-79-13"),
       ("user3", "ee11cbb19052e40b07aac0ca060c23ee", '0', '0', "Петров", "Пётр", "Петрович", "petpet@mail.ru", "+375 (29) 246-80-24"),
       ("user4", "ee11cbb19052e40b07aac0ca060c23ee", '0', '0', "Иванов", "Иван", "Иванович", "ivanvan@mail.ru", "+375 (29) 129-38-47"),
       ("user5", "ee11cbb19052e40b07aac0ca060c23ee", '2', '0', "Александров", "Александр", "Александрович", "alexlex@mail.ru", "+375 (29) 567-12-89");
        /* password = user */

INSERT INTO workshopdb.product (user_id, name, price, description, image_path)
VALUES (NULL, "Медведь Пух", 10.5, "Плюшевый медведь Винни Пух", "img/sakura2.jpg"),
       (NULL, "Рыбка золотая", 7.5, "Плюшевая золотая рыбка", "img/1111.png"),
       (NULL, "Заяц Крош", 9, "Плюшевый заяц Крош", "img/witcher.jpg"),
       (1, "Тигр", 20, "Большой тигр с большими зубами", NULL);

INSERT INTO workshopdb.localaddress (address)
VALUES ("ул. Покровского, 13-3"),
       ("пр-т Будёного, 3А-43");

/*INSERT INTO workshopdb.confirmedorder (order_id, state, finalPrice, amount, address, date, obtainingMethod)
VALUE (1, "изготавливается", 15.7, 1, "переул. Смирнова, 7", "2020-05-01", "доставка");

INSERT INTO workshopdb.confirmedorder (order_id, state, finalPrice, amount, localAddress_id, date, obtainingMethod)
VALUE (2, "изготавливается", 15.7, 1, 1, "2020-05-15", "самовывоз");*/

INSERT INTO workshopdb.purchase (user_id, state, localAddress_id, date, obtainingMethod)
VALUES (2, "заказан", 2, "2020-06-05", "самовывоз"),
       (3, "доставлен", 1, "2020-05-26", "самовывоз");

/*INSERT INTO workshopdb.productlist (purchase_id, item_id, finalPrice, amount)
VALUES (1, 2, 8, 3),
       (2, 1000001, 10.7, 1),
       (2, 3, 9, 2);*/