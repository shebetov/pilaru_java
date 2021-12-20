delete from accounts_user_roles;
delete from projects_projectmember;
delete from accounts_role;
delete from accounts_user;
delete from items_suppliercontact;
delete from items_supplier;
delete from items_product;
delete from items_producttoorder;
delete from orders_priceoffer;
delete from items_item;
delete from items_itemcategory;
delete from orders_orderstate;
delete from orders_order_states;
delete from orders_stage;
delete from orders_order;
delete from projects_projectrole;
delete from projects_project;



INSERT INTO public.accounts_role(id, name)
VALUES (1, 'ROLE_USER'), (2, 'ROLE_ADMIN');


insert into accounts_user(id, password, username)
values (1,'$2a$10$ujzjhWp2uwDtSk7pouW.YuC1cKifSQy6ysQ94pDdZaYbY828pxAcq','test');

insert into accounts_user_roles(user_id, roles_id)
values (1,1);


-- CREATE PROJECT
insert into projects_project(id, created_date, name)
values (1, 0, 'Тест');
insert into projects_projectrole(id, name)
values (1, 'Создатель');
insert into projects_projectmember(id, created_date, link_key, project_id, role_id, user_id)
values (1, 0, '12345', 1, 1, 1);

-- categories
insert into items_itemcategory(id, name)
values (1, 'Электротехнческие товары'),
       (2, 'крепеж, фурнитура'),
       (3, 'ЛКМ, пены, герметики'),
       (4, 'Строительные материалы'),
       (5, 'Интерьер отделка'),
       (6, 'Другое');

-- suppliers
insert into items_supplier(id, created_date, name) VALUES
    (1, 0, 'Сатурн'),
    (2, 0, 'Стройкомплект'),
    (3, 0, 'Дострой');
insert into items_suppliercontact(id, email, is_selected, supplier_id) values
    (1, 'flex210655@gmail.com', true, 1);
insert into items_suppliercontact(id, email, is_selected, supplier_id) values
    (2, 'flex210655@gmail.com', true, 2);
insert into items_suppliercontact(id, email, is_selected, supplier_id) values
    (3, 'flex210655@gmail.com', true, 3);


-- products & items
insert into items_product(id, created_date, name, unit_measurement, category_id)
values (1, 0, 'Кабель ВВГ-Пнг(A)-LS 3х2,5ок (N,РЕ)-0,66', 0, 1),
       (2, 0, 'Кабель ВВГнг(A)-LS 4х6ок (N)-0,66', 0, 1),
       (3, 0, 'Провод ПВС 2х0,75', 0, 1),

       (4, 0, 'Анкер клиновой WAM 12*100', 0, 2),
       (5, 0, 'Шуруп головка шестигранник "глухарь" DIN', 0, 2),
       (6, 0, 'гвоздь 4х100мм', 0, 2),

       (7, 0, 'Пена монтажная AXTON про 750мл', 0, 3),
       (8, 0, 'Герметик каучуковый для кровли PENOSIL бесцветный , 310 мл // 23672', 0, 3),
       (9, 0, 'Валик "Синтекс" плюс 270мм с рукояткой (Remocolor) (шт) фасадный', 0, 3),

       (10, 0, 'Цементно песчанная смесь в мешках 50 кг./25', 0, 4),
       (11, 0, 'Изоспан А ветро-влагозащитный мембрана 1,6*43,75м/70м2', 0, 4),
       (12, 0, 'КРЕПИКС Сетка стеклотканевая Фасад 1500 5х5мм (1х50м) (145гр/м2)', 0, 4),

       (13, 0, 'окно пвх 50х60, 1-ств.пов.прав', 0, 5),
       (14, 0, 'ПВХ EXPROF ProWin 3кам Белый СПД32 2150х1700', 0, 5),
       (15, 0, 'ПВХ EXPROF ProWin 3кам Белый СПД32 950х950', 0, 5),

       (16, 0, 'Канат Lanex полипропиленовые плетеный 12мм, 1 прядей с сердечником', 0, 6),
       (17, 0, 'Бур SDS PL 6*110мм', 0, 6),
       (18, 0, 'Емкать 90л платиск сибртех', 0, 6);

insert into items_item(id, created_date, name, product_id, supplier_id) values
    (1, 0, 'Кабель ВВГ-Пнг(A)-LS 3х2,5ок (N,РЕ)-0,66', 1, 1),
    (2, 0, 'Кабель ВВГ-Пнг(A)-LS 3х2,5ок (N,РЕ)-0,66', 1, 2),
    (3, 0, 'Кабель ВВГ-Пнг(A)-LS 3х2,5ок (N,РЕ)-0,66', 1, 3),
    (4, 0, 'Кабель ВВГнг(A)-LS 4х6ок (N)-0,66', 2, 1),
    (5, 0, 'Кабель ВВГнг(A)-LS 4х6ок (N)-0,66', 2, 2),
    (6, 0, 'Кабель ВВГнг(A)-LS 4х6ок (N)-0,66', 2, 3),
    (7, 0, 'Провод ПВС 2х0,75', 3, 3),
    (8, 0, 'Провод ПВС 2х0,75', 3, 1),
    (9, 0, 'Провод ПВС 2х0,75', 3, 3),

    (10, 0, 'Анкер клиновой WAM 12*100', 4, 1),
    (11, 0, 'Анкер клиновой WAM 12*100', 4, 2),
    (12, 0, 'Анкер клиновой WAM 12*100', 4, 3),
    (13, 0, 'Шуруп головка шестигранник "глухарь" DIN', 5, 1),
    (14, 0, 'Шуруп головка шестигранник "глухарь" DIN', 5, 2),
    (15, 0, 'Шуруп головка шестигранник "глухарь" DIN', 5, 3),
    (16, 0, 'гвоздь 4х100мм', 6, 3),
    (17, 0, 'гвоздь 4х100мм', 6, 1),
    (18, 0, 'гвоздь 4х100мм', 6, 3),

    (19, 0, 'Пена монтажная AXTON про 750мл', 7, 1),
    (20, 0, 'Пена монтажная AXTON про 750мл', 7, 2),
    (21, 0, 'Пена монтажная AXTON про 750мл', 7, 3),
    (22, 0, 'Герметик каучуковый для кровли PENOSIL бесцветный , 310 мл // 23672', 8, 1),
    (23, 0, 'Герметик каучуковый для кровли PENOSIL бесцветный , 310 мл // 23672', 8, 2),
    (24, 0, 'Герметик каучуковый для кровли PENOSIL бесцветный , 310 мл // 23672', 8, 3),
    (25, 0, 'Валик "Синтекс" плюс 270мм с рукояткой (Remocolor) (шт) фасадный', 9, 3),
    (26, 0, 'Валик "Синтекс" плюс 270мм с рукояткой (Remocolor) (шт) фасадный', 9, 1),
    (27, 0, 'Валик "Синтекс" плюс 270мм с рукояткой (Remocolor) (шт) фасадный', 9, 3),

    (28, 0, 'Цементно песчанная смесь в мешках 50 кг./25', 10, 1),
    (29, 0, 'Цементно песчанная смесь в мешках 50 кг./25', 10, 2),
    (30, 0, 'Цементно песчанная смесь в мешках 50 кг./25', 10, 3),
    (31, 0, 'Изоспан А ветро-влагозащитный мембрана 1,6*43,75м/70м2', 11, 1),
    (32, 0, 'Изоспан А ветро-влагозащитный мембрана 1,6*43,75м/70м2', 11, 2),
    (33, 0, 'Изоспан А ветро-влагозащитный мембрана 1,6*43,75м/70м2', 11, 3),
    (34, 0, 'КРЕПИКС Сетка стеклотканевая Фасад 1500 5х5мм (1х50м) (145гр/м2)', 12, 3),
    (35, 0, 'КРЕПИКС Сетка стеклотканевая Фасад 1500 5х5мм (1х50м) (145гр/м2)', 12, 1),
    (36, 0, 'КРЕПИКС Сетка стеклотканевая Фасад 1500 5х5мм (1х50м) (145гр/м2)', 12, 3),

    (37, 0, 'окно пвх 50х60, 1-ств.пов.прав', 13, 1),
    (38, 0, 'окно пвх 50х60, 1-ств.пов.прав', 13, 2),
    (39, 0, 'окно пвх 50х60, 1-ств.пов.прав', 13, 3),
    (40, 0, 'ПВХ EXPROF ProWin 3кам Белый СПД32 2150х1700', 14, 1),
    (41, 0, 'ПВХ EXPROF ProWin 3кам Белый СПД32 2150х1700', 14, 2),
    (42, 0, 'ПВХ EXPROF ProWin 3кам Белый СПД32 2150х1700', 14, 3),
    (43, 0, 'ПВХ EXPROF ProWin 3кам Белый СПД32 950х950', 15, 3),
    (44, 0, 'ПВХ EXPROF ProWin 3кам Белый СПД32 950х950', 15, 1),
    (45, 0, 'ПВХ EXPROF ProWin 3кам Белый СПД32 950х950', 15, 3),

    (46, 0, 'Канат Lanex полипропиленовые плетеный 12мм, 1 прядей с сердечником', 16, 1),
    (47, 0, 'Канат Lanex полипропиленовые плетеный 12мм, 1 прядей с сердечником', 16, 2),
    (48, 0, 'Канат Lanex полипропиленовые плетеный 12мм, 1 прядей с сердечником', 16, 3),
    (49, 0, 'Бур SDS PL 6*110мм', 17, 1),
    (50, 0, 'Бур SDS PL 6*110мм', 17, 2),
    (51, 0, 'Бур SDS PL 6*110мм', 17, 3),
    (52, 0, 'Емкать 90л платиск сибртех', 18, 3),
    (53, 0, 'Емкать 90л платиск сибртех', 18, 1),
    (54, 0, 'Емкать 90л платиск сибртех', 18, 3);


-- orders
insert into orders_orderstate(id, name) VALUES
    (1, 'Сборка'),
    (2, 'Запрос цен'),
    (3, 'Отправка запроса');

insert into orders_stage(id, name) VALUES
    (1, 'Фундамент'),
    (2, 'Коробка'),
    (3, 'Покраска');

insert into orders_order(id, created_date, project_id) VALUES
    (1, 0, 1);

insert into orders_order_states(order_id, states_id) VALUES
    (1, 1);

insert into orders_priceoffer(id, created_date, for_quantity, price_per_unit, item_id) VALUES
    (1, 0, 1, 25.2, 4),
    (2, 0, 1, 13.45, 12),
    (3, 0, 1, 3.45, 50);

insert into items_producttoorder(id, quantity, order_id, product_id, stage_id) values
    (1, 25, 1, 4, 1),
    (2, 1, 1, 11, 1),
    (3, 4, 1, 15, 1);
