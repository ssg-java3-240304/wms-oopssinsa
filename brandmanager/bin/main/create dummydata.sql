select *
from section;

insert into brand
values (1, 'Nike', '2020-01-01', '2025-01-01'),
       (2, 'Adidas', '2020-02-01', '2025-02-01'),
       (3, 'Zara', '2020-03-01', '2025-03-01'),
       (4, 'H&M', '2020-04-01', '2025-04-01');

insert into account
VALUES ('user01', 1, '김철수', 'password123', 'BM'),
       ('user02', 2, '이영희', 'qwerty456', 'BM'),
       ('user03', 3, '박민수', 'abc123xyz', 'BM'),
       ('user04', 4, '최지우', 'mypassword789', 'BM');

insert into account (id, name, password, role)
values ('worker1', '홍길동', 'password654', 'WW'),
       ('worker2', '김영희', 'qwerty321', 'WW'),
       ('worker3', '이민수', 'xyz321abc', 'WW'),
       ('worker4', '박지훈', 'mypassword321', 'WW');

insert into category (id, name)
values (1001, '티셔츠'),
       (1002, '니트/스웨터'),
       (2001, '운동복 상의'),
       (2002, '운동복 하의'),
       (3001, '재킷/아우터'),
       (4001, '신발'),
       (5001, '블라우스/셔츠'),
       (5002, '원피스/스커트'),
       (6001, '바지/청바지'),
       (7001, '악세서리'),
       (9001, '가방');

insert into worker
values ('worker1', '홍길동', 'T'),
       ('worker2', '김영희', 'T'),
       ('worker3', '이민수', 'T'),
       ('worker4', '박지훈', 'F');

insert into product (id, brand_id, name, size, color, category_id, volume)
values
    ('SH001', 1, 'Nike Air Max 270', '8', 'White', 4001, 5),
    ('SH002', 1, 'Nike Air Max 270', '9', 'White', 4001, 5),
    ('SH003', 1, 'Nike Air Max 270', '10', 'White', 4001, 5),
    ('TS001', 2, 'Adidas Originals Trefoil Tee', 'S', 'Black', 1001, 1),
    ('TS002', 2, 'Adidas Originals Trefoil Tee', 'M', 'Black', 1001, 1),
    ('TS003', 2, 'Adidas Originals Trefoil Tee', 'L', 'Black', 1001, 1),
    ('JK001', 3, 'Zara Double-Breasted Coat', 'S', 'Black', 3001, 2),
    ('JK002', 3, 'Zara Double-Breasted Coat', 'M', 'Black', 3001, 2),
    ('JK003', 3, 'Zara Double-Breasted Coat', 'L', 'Black', 3001, 2),
    ('BG001', 4, 'H&M Canvas Backpack', 'One Size', 'Black',9001, 6),
    ('BG002', 4, 'H&M Canvas Backpack', 'One Size', 'Blue', 9001, 6),
    ('BG003', 4, 'H&M Canvas Backpack', 'One Size', 'Grey', 9001, 6);

INSERT INTO stock_detail (manufacture_date, product_id, quantity, date)
VALUES (230521, 'SH001', +200, 230525), -- 1 , A , 4001 , * 5
       (230621, 'TS002', +320, 230630), -- 2 , B , 1001 , * 1
       (230721, 'JK003', +500, 230801), -- 3 , C , 3001 , * 2
       (230823, 'BG003', +170, 230909); -- 4 , D , 9001, * 6

insert into section (id, brand_id, current_capacity, max_capacity)
VALUES ('A', 1, (select sum(current_capacity) from sub_location where section_id = 'A'), (select sum(max_capacity) from sub_location where section_id = 'A')),
       ('B', 2, (select sum(current_capacity) from sub_location where section_id = 'B'), (select sum(max_capacity) from sub_location where section_id = 'B')),
       ('C', 3, (select sum(current_capacity) from sub_location where section_id = 'C'), (select sum(max_capacity) from sub_location where section_id = 'C')),
       ('D', 4, (select sum(current_capacity) from sub_location where section_id = 'D'), (select sum(max_capacity) from sub_location where section_id = 'D'));

insert into sub_location (id, section_id, category_id, current_capacity, max_capacity)
VALUES (1, 'A', 1001, 1000, 1000),
       (2, 'A', 1002, 0, 1000),
       (3, 'A', 2001, 0, 1000),
       (4, 'A', 2002, 0, 1000),
       (5, 'A', 3001, 0, 1000),
       (6, 'A', 4001, 0, 1000),
       (7, 'A', 5001, 0, 1000),
       (8, 'A', 5002, 0, 1000),
       (9, 'A', 6001, 0, 1000),
       (10, 'A', 7001, 0, 1000),
       (11, 'A', 9001, 0, 1000),
       (12, 'B', 1001, 320, 500),
       (13, 'B', 1002, 0, 500),
       (14, 'B', 2001, 0, 500),
       (15, 'B', 2002, 0, 500),
       (16, 'B', 3001, 0, 500),
       (17, 'B', 4001, 0, 500),
       (18, 'B', 5001, 0, 500),
       (19, 'B', 5002, 0, 500),
       (20, 'B', 6001, 0, 500),
       (21, 'B', 7001, 0, 500),
       (22, 'B', 9001, 0, 500),
       (23, 'C', 1001, 0, 1020),
       (24, 'C', 1002, 0, 1020),
       (25, 'C', 2001, 0, 1020),
       (26, 'C', 2002, 0, 1020),
       (27, 'C', 3001, 1000, 1020),
       (28, 'C', 4001, 0, 1020),
       (29, 'C', 5001, 0, 1020),
       (30, 'C', 5002, 0, 1020),
       (31, 'C', 6001, 0, 1020),
       (32, 'C', 7001, 0, 1020),
       (33, 'C', 9001, 0, 1020),
       (34, 'D', 1001, 0, 2000),
       (35, 'D', 1002, 0, 2000),
       (36, 'D', 2001, 0, 2000),
       (37, 'D', 2002, 0, 2000),
       (38, 'D', 3001, 0, 2000),
       (39, 'D', 4001, 0, 2000),
       (40, 'D', 5001, 0, 2000),
       (41, 'D', 5002, 0, 2000),
       (42, 'D', 6001, 0, 2000),
       (43, 'D', 7001, 0, 2000),
       (44, 'D', 9001, 1020, 2000);

insert into stock (manufacture_date, product_id, section_id, location_id, quantity)
values
    (230521, 'SH001', 'A', 6, (select sum(quantity)
                                  from stock_detail
                                  where manufacture_date = 230521 and product_id = 'SH001'
                                  group by manufacture_date, product_id)),
    (230621, 'TS002', 'B', 12, (select sum(quantity)
                                from stock_detail
                                where manufacture_date = 230621 and product_id = 'TS002'
                                group by manufacture_date, product_id)),
    (230721, 'JK003', 'C', 27, (select sum(quantity)
                                from stock_detail
                                where manufacture_date = 230721 and product_id = 'JK003'
                                group by manufacture_date, product_id)),
    (230823, 'BG003', 'D', 44, (select sum(quantity)
                                from stock_detail
                                where manufacture_date = 230823 and product_id = 'BG003'
                                group by manufacture_date, product_id));

-- 재고내역을 합산한 값
select sum(quantity)
from stock_detail
where manufacture_date = 230521 and product_id = 'SH001'
group by manufacture_date, product_id;

insert into ib_detail (id, manufacture_date, product_id, login_id, quantity, completion_date, status)
VALUES (1240521, 240520, 'SH002', 'user01', 10, null, 'R'),
       (1240521, 240520, 'SH003', 'user01', 15, null, 'R'),
       (2240521, 240516, 'TS001', 'user02', 50, null, 'P'),
       (2240521, 240517, 'TS001', 'user02', 10, null, 'P'),
       (3240521, 240510, 'JK002', 'user03', 30, null, 'P');

insert into ib_worker (ib_id, manufacture_date, product_id, worker_id, location_id)
VALUES (2240521, 240516, 'TS001', 'worker1', (select id
                                              from sub_location
                                              where (section_id, category_id) =
                                                    (select s.id, p.category_id
                                                     from product p
                                                              left join section s on (s.brand_id = p.brand_id)
                                                     where p.id ='TS001'))),
       (2240521, 240517, 'TS001', 'worker2', (select id
                                              from sub_location
                                              where (section_id, category_id) =
                                                    (select s.id, p.category_id
                                                     from product p
                                                              left join section s on (s.brand_id = p.brand_id)
                                                     where p.id ='TS001'))),
       (3240521, 240510, 'JK002', 'worker3', (select id
                                              from sub_location
                                              where (section_id, category_id) =
                                                    (select s.id, p.category_id
                                                     from product p
                                                              left join section s on (s.brand_id = p.brand_id)
                                                     where p.id ='JK002')));

-- 상품의 아이디로 위치 찾는 쿼리
-- 섹션 - 브랜드아이디 와 연결
select id
from sub_location
where (section_id, category_id) =
      (select s.id, p.category_id
       from product p
                left join section s on (s.brand_id = p.brand_id)
       where p.id ='TS001');

insert into ob_detail (manufacture_date, ob_id, product_id, quantity, status, completion_date, tracking_number)
VALUES (230721, 3240521, 'JK003', 1, 'P', null, null);

insert into ob_worker (manufacture_date, ob_id, product_id, worker_id, location_id)
values (230721, 3240521, 'JK003', 'worker2', (select id
                                              from sub_location
                                              where (section_id, category_id) =
                                                    (select s.id, p.category_id
                                                     from product p
                                                              left join section s on (s.brand_id = p.brand_id)
                                                     where p.id ='JK003')));

select obw.*
from ob_detail obd
         left join ob_worker obw
                   on (obd.ob_id = obw.ob_id and obd.manufacture_date = obw.manufacture_date and obd.product_id = obw.product_id)
where obd.status = 'P'
  and obw.worker_id = 'worker2';

