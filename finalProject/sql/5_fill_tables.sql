INSERT INTO workshopdb.user (login, password, role, state, name, surname, patronymic, email, phone)
VALUES ("user1", "ee11cbb19052e40b07aac0ca060c23ee", '0', '0', "Вася", "Васильков", "Васильевич", "olkov@mail.ru", "+375 (33) 987-65-43"),
       ("user2", "ee11cbb19052e40b07aac0ca060c23ee", '0', '0', "Сидоров", "Сидор", "Сидорович", "sidor@mail.ru", "+375 (29) 135-79-13"),
       ("user3", "ee11cbb19052e40b07aac0ca060c23ee", '0', '0', "Петров", "Пётр", "Петрович", "petpet@mail.ru", "+375 (29) 246-80-24"),
       ("user4", "ee11cbb19052e40b07aac0ca060c23ee", '0', '0', "Иванов", "Иван", "Иванович", "ivanvan@mail.ru", "+375 (29) 129-38-47"),
       ("user5", "ee11cbb19052e40b07aac0ca060c23ee", '2', '0', "Александров", "Александр", "Александрович", "alexlex@mail.ru", "+375 (29) 567-12-89");
        /* password = user */

INSERT INTO workshopdb.product (user_id, name, price, description, image_path)
VALUES (NULL, "Медведь Пух", 10.5, "Плюшевый медведь Винни Пух", "img/vinni.jpg"),
       (NULL, "Рыбка золотая", 7.5, "Плюшевая золотая рыбка", "img/gold_fish.jpg"),
       (NULL, "Заяц Крош", 9, "Плюшевый заяц Крош", "img/crosh.jpg"),
       (NULL, "Тигр", 20, "Большой тигр с большими зубами", "img/tiger.png"),
       (NULL, "Бегемот", 5, "Плюшевый бегемот", "img/begemot.jpg"),
       (NULL, "Нюша", 10, "Плюшевый свинка Нюша", "img/nyusha.jpg"),
       (NULL, "Бараш", 8, "Плюшевый баран Бараш", "img/barash.jpg"),
       (NULL, "Кар Карыч", 10, "Плюшевый ворон Кар Карыч", "img/karkar.jpg");


INSERT INTO workshopdb.localaddress (address)
VALUES ("ул. Покровского, 13-3"),
       ("пр-т Будёного, 3А-43");


INSERT INTO workshopdb.purchase (user_id, state, localAddress_id, date, obtainingMethod)
VALUES (2, "заказан", 2, "2020-06-05", "самовывоз"),
       (3, "доставлен", 1, "2020-05-26", "самовывоз");

