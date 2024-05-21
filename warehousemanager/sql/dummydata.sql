-- brand dummy table
# use wms_db;
insert into brand
values (1, 'Nike', '2020-01-01', '2025-01-01'),
       (2, 'Adidas', '2020-02-01', '2025-02-01'),
       (3, 'Zara', '2020-03-01', '2025-03-01'),
       (4, 'H&M', '2020-04-01', '2025-04-01'),
       (5, 'Uniqlo', '2020-05-01', '2025-05-01'),
       (6, 'Under Armour', '2020-06-01', '2025-06-01'),
       (7, 'Gucci', '2020-07-01', '2025-07-01');
#        (8, 'Prada', '2020-08-01', '2025-08-01'),
#        (9, 'Levi\'s', '2020-09-01', '2025-09-01'),
#        (10, 'Puma', '2020-10-01', '2025-10-01'),
#        (11, 'Burberry', '2020-11-01', '2025-11-01'),
#        (12, 'Versace', '2020-12-01', '2025-12-01'),
#        (13, 'Ralph Lauren', '2021-01-01', '2026-01-01'),
#        (14, 'Calvin Klein', '2021-02-01', '2026-02-01'),
#        (15, 'Tommy Hilfiger', '2021-03-01', '2026-03-01'),
#        (16, 'Lacoste', '2021-04-01', '2026-04-01'),
#        (17, 'New Balance', '2021-05-01', '2026-05-01'),
#        (18, 'Reebok', '2021-06-01', '2026-06-01'),
#        (19, 'Champion', '2021-07-01', '2026-07-01'),
#        (20, 'Columbia', '2021-08-01', '2026-08-01');

-- account dummy table
-- WM 계정
insert into account
VALUES ('user01', 1, '김철수', 'password123', 'WM'),
       ('user02', 3, '이영희', 'qwerty456', 'WM'),
       ('user03', 5, '박민수', 'abc123xyz', 'WM'),
       ('user04', 7, '최지우', 'mypassword789', 'WM'),
       ('user05', 2, '강호동', 'letmein123', 'WM'),
       ('user06', 4, '윤아름', 'iloveyou456', 'WM'),
       ('user07', 6, '오세훈', 'securepass789', 'WM');

#        ('user08', 9, '정수연', 'passw0rd!', 'WM'),
#        ('user09', 11, '한지민', '1234qwer', 'WM'),
#        ('user10', 8, '문유라', 'password@1', 'WM'),
#        ('user11', 10, '배수지', 'qwerty789', 'WM'),
#        ('user12', 12, '김태희', 'mypassword123', 'WM'),
#        ('user13', 14, '이준기', 'pass123word', 'WM'),
#        ('user14', 16, '박보영', '12345abcde', 'WM'),
#        ('user15', 18, '송중기', 'letmein789', 'WM'),
#        ('user16', 20, '장동건', '1234asdf', 'WM'),
#        ('user17', 13, '고소영', 'securepass123', 'WM'),
#        ('user18', 15, '원빈', 'iloveyou789', 'WM'),
#        ('user19', 17, '신민아', 'passw0rd456', 'WM'),
#        ('user20', 19, '전지현', 'mypassword456', 'WM');

-- WW 계정

insert into account (id, name, password, role)
values ('worker1', '홍길동', 'password654', 'WW'),
       ('worker2', '김영희', 'qwerty321', 'WW'),
       ('worker3', '이민수', 'xyz321abc', 'WW'),
       ('worker4', '박지훈', 'mypassword321', 'WW'),
       ('worker5', '최수정', 'passw0rd!321', 'WW'),
       ('worker6', '조한나', '5678qwer', 'WW'),
       ('worker7', '강민호', 'letmein456', 'WW'),
       ('worker8', '윤정희', 'iloveyou789', 'WW'),
       ('worker9', '오민지', 'securepass456', 'WW'),
       ('worker10', '문준영', 'password#1', 'WW'),
       ('worker11', '배지현', 'qwerty654', 'WW'),
       ('worker12', '김소희', 'mypassword654', 'WW'),
       ('worker13', '이재훈', 'pass321word', 'WW'),
       ('worker14', '박서준', '67890abcde', 'WW'),
       ('worker15', '송혜교', 'letmein1234', 'WW'),
       ('worker16', '장성호', '5678asdf', 'WW'),
       ('worker17', '고민수', 'securepass654', 'WW'),
       ('worker18', '원준희', 'iloveyou321', 'WW'),
       ('worker19', '신혜수', 'passw0rd789', 'WW'),
       ('worker20', '전민지', 'mypassword789', 'WW');

-- account에 외래키 추가
# ALTER TABLE account
# ADD constraint fk_brand_id FOREIGN KEY (brand_id)
# REFERENCES brand (id)
# on update cascade
# ON DELETE CASCADE;

-- brand를 수정/삭제하면 해당 브랜드 소속 account도 수정/삭제된다

-- 제약조건 확인
select
    *
from information_schema.table_constraints
where constraint_schema = 'osswmsdb';

-- 브랜드 id auto_increment값으로 설정
# alter table brand
# modify id bigint auto_increment;

alter table sub_location
modify id bigint auto_increment;

-- product에 brand_id 외래키 추가
# ALTER TABLE product
# ADD constraint fk_brand_id2 FOREIGN KEY (brand_id)
# REFERENCES brand (id)
# on update cascade;

-- section에 brand_id 외래키 추가
# ALTER TABLE section
# ADD constraint fk_brand_id3 FOREIGN KEY (brand_id)
# REFERENCES brand (id)
# on update cascade
# on delete cascade;

-- 구역ID 알파벳으로 하려고 바꿨습니다.
# alter table section
# change id id char(1);
# alter table sub_location
# change section_id section_id char(1);

# insert into category (id, name)
# VALUES (1001, '티셔츠'),
#        (1002, '셔츠/블라우스/원피스'),
#        (1003, '아우터(대)/패딩'),
#        (1004, '아우터(중/소)/재킷'),
#        (1005, '니트/스웨터/캐시미어'),
#        (1006, '후드/맨투맨'),
#        (2001, '수트/세트'),
#        (3001, '바지'),
#        (3002, '청바지'),
#        (3003, '스커트'),
#        (4001, '운동복(트레이닝복)상의'),
#        (4002, '운동복(트레이닝복)하의'),
#        (5001, '액세서리(벨트/장갑/목도리/스카프)'),
#        (5002, '액세서리(양말/스타킹)'),
#        (6001, '신발(운동화/샌들/부츠/슬리퍼)'),
#        (6002, '구두'),
#        (7001, '가방(백팩/토트백/크로스백'),
#        (7002, '가방(클러치/파우치)'),
#        (7003, '여행가방'),
#        (8001, '모자'),
#        (9001, '이너웨어/파자마/홈웨어'),
#        (9002, '수영복'),
#        (9003, '아동 의류');

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
       (7001, '악세서리');

# alter table section
# modify id char(1);

insert into section (id, brand_id, current_capacity, max_capacity)
VALUES ('A', 1, 0, 4600),
       ('B', 6, 0, 3600),
       ('C', 2, 0, 5050),
       ('E', 3, 0, 2600),
       ('F', 7, 0, 720),
       ('G', 4, 0, 2950),
       ('H', 5, 0, 3200);

alter table section
    modify brand_id bigint null;

insert into section (id, brand_id, current_capacity, max_capacity)
values ('D', null, 0, 1000);

delete
from sub_location
where 1;

select *
from sub_location;

insert into sub_location (id, section_id, category_id, current_capacity, max_capacity)
VALUES (1, 'A', 1001, (select sum(quantity)*1 from stock where location_id = 5 group by location_id), 1000);

# drop index `PRIMARY` on sub_location;
#
# drop index uq_section_id_category_id on sub_location;

# alter table sub_location
#     drop primary key;
#
# alter table sub_location
#     drop key uq_section_id_category_id;

SET foreign_key_checks = 0;
SET foreign_key_checks = 1;

delete
from sub_location
where id < 36;

select *
from stock;

insert into sub_location (id, section_id, category_id, current_capacity, max_capacity)
VALUES (36, 'A', 1001, (select sum(quantity)*1 from stock where location_id = 5 group by location_id), 1000),
       (37, 'A', 2001, (select sum(quantity)*0 from stock where location_id = 5 group by location_id), 800),
       (38, 'A', 2002, (select sum(quantity)*1 from stock where location_id = 5 group by location_id), 841),
       (39, 'A', 3001, (select sum(quantity)*2 from stock where location_id = 5 group by location_id), 1700),
       (40, 'A', 4001, (select sum(quantity)*5 from stock where location_id = 5 group by location_id), 5000),
       (41, 'C', 1001, (select sum(quantity)*1 from stock where location_id = 5 group by location_id), 1200),
       (42, 'C', 2001, (select sum(quantity)*0 from stock where location_id = 5 group by location_id), 900),
       (43, 'C', 2002, (select sum(quantity)*1 from stock where location_id = 5 group by location_id), 900),
       (44, 'C', 3001, (select sum(quantity)*2 from stock where location_id = 5 group by location_id), 1700),
       (45, 'C', 4001, (select sum(quantity)*5 from stock where location_id = 5 group by location_id), 4200),
       (46, 'E', 1001, (select sum(quantity)*1 from stock where location_id = 5 group by location_id), 1000),
       (47, 'E', 5001, (select sum(quantity)*0 from stock where location_id = 5 group by location_id), 600),
       (48, 'E', 5002, (select sum(quantity)*0 from stock where location_id = 5 group by location_id), 400),
       (49, 'E', 6001, (select sum(quantity)*2 from stock where location_id = 5 group by location_id), 1700),
       (50, 'E', 3001, (select sum(quantity)*2 from stock where location_id = 5 group by location_id), 1700),
       (51, 'G', 1001, (select sum(quantity)*1 from stock where location_id = 5 group by location_id), 850),
       (52, 'G', 5001, (select sum(quantity)*0 from stock where location_id = 5 group by location_id), 700),
       (53, 'G', 5002, (select sum(quantity)*0 from stock where location_id = 5 group by location_id), 450),
       (54, 'G', 9001, (select sum(quantity)*1 from stock where location_id = 5 group by location_id), 850),
       (55, 'G', 3001, (select sum(quantity)*2 from stock where location_id = 5 group by location_id), 1700),
       (56, 'H', 1001 , (select sum(quantity)*1 from stock where location_id = 5 group by location_id), 900),
       (57, 'H', 1002, (select sum(quantity)*0 from stock where location_id = 5 group by location_id), 1700),
       (58, 'H', 6001, (select sum(quantity)*2 from stock where location_id = 5 group by location_id), 1700),
       (59, 'H', 3001, (select sum(quantity)*2 from stock where location_id = 5 group by location_id), 3000),
       (60, 'H', 9001, (select sum(quantity)*6 from stock where location_id = 5 group by location_id), 5050),
       (61, 'B', 1001, (select sum(quantity)*1 from stock where location_id = 5 group by location_id), 850),
       (62, 'B', 2001, (select sum(quantity)*0 from stock where location_id = 5 group by location_id), 700),
       (63, 'B', 2002, (select sum(quantity)*1 from stock where location_id = 5 group by location_id), 900),
       (64, 'B', 3001, (select sum(quantity)*2 from stock where location_id = 5 group by location_id), 1700),
       (65, 'B', 4001, (select sum(quantity)*5 from stock where location_id = 5 group by location_id), 4500),
       (66, 'F', 1001, (select sum(quantity)*1 from stock where location_id = 5 group by location_id), 900),
       (67, 'F', 5001, (select sum(quantity)*0 from stock where location_id = 5 group by location_id), 150),
       (68, 'F', 5002, (select sum(quantity)*0 from stock where location_id = 5 group by location_id), 120),
       (69, 'F', 9001, (select sum(quantity)*1 from stock where location_id = 5 group by location_id), 900),
       (70, 'F', 3001, (select sum(quantity)*2 from stock where location_id = 5 group by location_id), 1800);

-- 자동값 설정했어요
# alter table sub_location
# modify id int auto_increment primary key ;

-- 구역-카테고리가 중복되지 않게 대체키 처리했습니다.
alter table sub_location
add constraint uq_section_id_category_id UNIQUE (section_id, category_id);

select *
from worker;

# alter table worker
# change id id varchar(10);

insert into worker
values ('worker1', '홍길동', 'T'),
       ('worker2', '김영희', 'T'),
       ('worker3', '이민수', 'T'),
       ('worker4', '박지훈', 'F'),
       ('worker5', '최수정', 'T'),
       ('worker6', '조한나', 'F'),
       ('worker7', '강민호', 'T'),
       ('worker8', '윤정희', 'T'),
       ('worker9', '오민지', 'T'),
       ('worker10', '문준영', 'F'),
       ('worker11', '배지현', 'T'),
       ('worker12', '김소희', 'T'),
       ('worker13', '이재훈', 'F'),
       ('worker14', '박서준', 'T'),
       ('worker15', '송혜교', 'T'),
       ('worker16', '장성호', 'T'),
       ('worker17', '고민수', 'F'),
       ('worker18', '원준희', 'T'),
       ('worker19', '신혜수', 'F'),
       ('worker20', '전민지', 'T');

select *
from product;

-- 상품 아이디 varchar로 변경
# alter table product
# change id id varchar(10) ;

insert into product (id, brand_id, name, size, color, category_id, volume)
values
    ('TS001', 2, 'Adidas Originals Trefoil Tee', 'S', 'Black', 1001, 1),
    ('TS002', 2, 'Adidas Originals Trefoil Tee', 'M', 'Black', 1001, 1),
    ('TS003', 2, 'Adidas Originals Trefoil Tee', 'L', 'Black', 1001, 1),
    ('TS004', 2, 'Adidas Originals Trefoil Tee', 'S', 'White', 1001, 1),
    ('TS005', 2, 'Adidas Originals Trefoil Tee', 'M', 'White', 1001, 1),
    ('TS006', 2, 'Adidas Originals Trefoil Tee', 'L', 'White', 1001, 1), -- 6
    ('TS010', 6, 'Under Armour Tech 2.0 Tee', 'S', 'Blue', 1001, 1),
    ('TS011', 6, 'Under Armour Tech 2.0 Tee', 'M', 'Blue', 1001, 1),
    ('TS012', 6, 'Under Armour Tech 2.0 Tee', 'L', 'Blue', 1001, 1), -- 3
    ('TS016', 4, 'H&M Basic Cotton Tee', 'S', 'Black', 1001, 1),
    ('TS017', 4, 'H&M Basic Cotton Tee', 'M', 'Black', 1001, 1),
    ('TS018', 4, 'H&M Basic Cotton Tee', 'L', 'Black', 1001, 1), -- 3
    ('TS019', 5,'Uniqlo U Crew Neck Short Sleeve Tee', 'S','White', 1001, 1),
    ('TS020', 5, 'Uniqlo U Crew Neck Short Sleeve Tee', 'M', 'White', 1001, 1),
    ('TS021', 5, 'Uniqlo U Crew Neck Short Sleeve Tee', 'L', 'White', 1001, 1), -- 3
    ('TS022', 3, 'Zara Printed T-Shirt', 'S', 'Purple', 1001, 1),
    ('TS023', 3, 'Zara Printed T-Shirt', 'M', 'Purple', 1001, 1),
    ('TS024', 3, 'Zara Printed T-Shirt', 'L', 'Purple', 1001, 1), -- 3
    ('TS026', 1, 'Nike Miler Running Top', 'M', 'Yellow', 1001, 1),
    ('TS027', 1, 'Nike Miler Running Top', 'L', 'Yellow', 1001, 1),
    ('TS028', 1, 'Nike SB Dry Tee', 'S', 'Grey', 1001, 1),
    ('TS029', 1, 'Nike SB Dry Tee', 'M', 'Grey', 1001, 1),
    ('TS030', 1, 'Nike SB Dry Tee', 'L', 'Grey', 1001, 1); -- 5

insert into product (id, brand_id, name, size, color, category_id, volume)
values -- 바지
       ('PA001', 1, 'Nike Sportswear Club Fleece Pants', 'S', 'Grey', 6001, 2),
       ('PA002', 1, 'Nike Sportswear Club Fleece Pants', 'M', 'Grey', 6001, 2),
       ('PA003', 1, 'Nike Sportswear Club Fleece Pants', 'L', 'Grey', 6001, 2),
       ('PA004', 2, 'Adidas Tiro 21 Training Pants', 'S', 'Black', 6001, 2),
       ('PA005', 2, 'Adidas Tiro 21 Training Pants', 'M', 'Black', 6001, 2),
       ('PA006', 2, 'Adidas Tiro 21 Training Pants', 'L', 'Black', 6001, 2),
-- 신발
       ('SH001', 1, 'Nike Air Max 270', '8', 'White', 4001, 5),
       ('SH002', 1, 'Nike Air Max 270', '9', 'White', 4001, 5),
       ('SH003', 1, 'Nike Air Max 270', '10', 'White', 4001, 5),
       ('SH004', 2, 'Adidas Ultraboost 21', '8', 'Black', 4001, 5),
       ('SH005', 2, 'Adidas Ultraboost 21', '9', 'Black', 4001, 5),
       ('SH006', 2, 'Adidas Ultraboost 21', '10', 'Black', 4001, 5),
-- 가방
       ('BG004', 1, 'Nike Brasilia Training Backpack', 'One Size', 'black', 9001, 6),
       ('BG005', 1, 'Nike Brasilia Training Backpack', 'One Size', 'black', 9001, 6),
       ('BG006', 1, 'Nike Brasilia Training Backpack', 'One Size', 'black', 9001, 6),
       ('BG007', 2, 'Adidas Classic 3-Stripes Backpack', 'One Size','black', 9001, 6),
       ('BG008', 2, 'Adidas Classic 3-Stripes Backpack', 'One Size','black', 9001, 6),
       ('BG009', 2, 'Adidas Classic 3-Stripes Backpack', 'One Size','black', 9001, 6),
-- Zara 재킷
       ('JK001', 3, 'Zara Double-Breasted Coat', 'S', 'Black', 3001, 2),
       ('JK002', 3, 'Zara Double-Breasted Coat', 'M', 'Black', 3001, 2),
       ('JK003', 3, 'Zara Double-Breasted Coat', 'L', 'Black', 3001, 2),
       ('JK004', 3, 'Zara Faux Leather Biker Jacket', 'S', 'Red', 3001, 2),
       ('JK005', 3, 'Zara Faux Leather Biker Jacket', 'M', 'Red', 3001, 2),
       ('JK006', 3, 'Zara Faux Leather Biker Jacket', 'L', 'Red', 3001, 2),
-- H&M 가방
       ('BG001', 4, 'H&M Canvas Backpack', 'One Size', 'Black',9001, 6),
       ('BG002', 4, 'H&M Canvas Backpack', 'One Size', 'Blue', 9001, 6),
       ('BG003', 4, 'H&M Canvas Backpack', 'One Size', 'Grey', 9001, 6),
-- Uniqlo 신발
       ('SH017', 5, 'Uniqlo Suede Slip-On Shoes', '8', 'Beige', 4001, 5),
       ('SH028', 5, 'Uniqlo Suede Slip-On Shoes', '9', 'Beige', 4001, 5),
       ('SH039', 5, 'Uniqlo Suede Slip-On Shoes', '10', 'Beige', 4001, 5),
       ('SH040', 5, 'Uniqlo High-Top Sneakers', '8', 'White', 4001, 5),
       ('SH051', 5, 'Uniqlo High-Top Sneakers', '9', 'White', 4001, 5),
       ('SH062', 5, 'Uniqlo High-Top Sneakers', '10', 'White', 4001, 5),
-- Under Armour 운동복
       ('UA001', 6, 'Under Armour HeatGear Leggings', 'S', 'Black', 2002, 1),
       ('UA002', 6, 'Under Armour HeatGear Leggings', 'M', 'Black', 2002, 1),
       ('UA003', 6, 'Under Armour HeatGear Leggings', 'L', 'Black', 2002, 1),
       ('UA004', 6, 'Under Armour Rival Fleece Joggers', 'S', 'Grey', 2002, 1),
       ('UA005', 6, 'Under Armour Rival Fleece Joggers', 'M', 'Grey', 2002, 1),
       ('UA006', 6, 'Under Armour Rival Fleece Joggers', 'L', 'Grey', 2002, 1)
-- Gucci 액세서리
       ('AC001', 7, 'Gucci GG Marmont Belt', 'S', 'Black', 9001, 1),
       ('AC002', 7, 'Gucci GG Marmont Belt', 'M', 'Black', 9001, 1),
       ('AC003', 7, 'Gucci GG Marmont Belt', 'L', 'Black', 9001, 1),
       ('AC004', 7, 'Gucci Square Frame Sunglasses', 'One Size', 'Gold', 9001, 1),
       ('AC005', 7, 'Gucci Square Frame Sunglasses', 'One Size', 'Silver', 9001, 1),
       ('AC006', 7, 'Gucci Square Frame Sunglasses', 'One Size', 'Black', 9001, 1);

select *
from product;

select brand_id, category_id, count(volume), sum(volume)
from product
group by brand_id, category_id
order by brand_id;

# insert into stock_detail (manufacture_id, product_id, quantity, date)
# values (231210, 'BG001', +20, 20231215);

# alter table stock_detail
# change product_date manufacture_id bigint;
#
# alter table stock
# change product_date manufacture_id bigint;

select *
from stock_detail;

# insert into ib_detail (id, manufacture_id, product_id, login_id, quantity, ib_date, status)
# VALUES (202405181, 240501, 'UA001', 'user07', 120, 20240518, 'R');

select *
from ib_detail;

select *
from stock_detail;

# alter table stock_detail
# drop primary key ;
#
# alter table stock_detail
# drop foreign key FK_product_TO_stock_detail_1;

delete
from stock_detail
where 1;
-- 상품 1: H&M Canvas Backpack (BG001)
INSERT INTO stock_detail (manufacture_date, product_id, quantity, date) VALUES
                                                                          (20231101, 'BG001', +100, 20231105),
                                                                          (20231101, 'BG001', -3, 20231115),
                                                                          (20231101, 'BG001', -2, 20231118),
                                                                          (20231101, 'BG001', -1, 20231125),
                                                                          (20231101, 'BG001', -4, 20231128),
                                                                          (20231101, 'BG001', -5, 20231205),
                                                                          (20231101, 'BG001', -6, 20231210);

-- 상품 2: Gucci GG Marmont Belt (AC001)
INSERT INTO stock_detail (manufacture_date, product_id, quantity, date) VALUES
                                                                          (20231001, 'AC001', +200, 20231003),
                                                                          (20231001, 'AC001', -10, 20231010),
                                                                          (20231001, 'AC001', -5, 20231015),
                                                                          (20231001, 'AC001', -2, 20231025),
                                                                          (20231001, 'AC001', -8, 20231101),
                                                                          (20231001, 'AC001', -12, 20231110);

-- 상품 3: Adidas Ultraboost 21 (SH004)
INSERT INTO stock_detail (manufacture_date, product_id, quantity, date) VALUES
                                                                          (20230901, 'SH004', +120, 20230905),
                                                                          (20230901, 'SH004', -15, 20230915),
                                                                          (20230901, 'SH004', -10, 20230920),
                                                                          (20230901, 'SH004', -5, 20230930),
                                                                          (20230901, 'SH004', -20, 20231010),
                                                                          (20230901, 'SH004', -18, 20231020);

-- 상품 4: Zara Double-Breasted Coat (JK001)
INSERT INTO stock_detail (manufacture_date, product_id, quantity, date) VALUES
                                                                          (20230801, 'JK001', +50, 20230805),
                                                                          (20230801, 'JK001', -5, 20230815),
                                                                          (20230801, 'JK001', -8, 20230820),
                                                                          (20230801, 'JK001', -2, 20230830),
                                                                          (20230801, 'JK001', -10, 20230910),
                                                                          (20230801, 'JK001', -6, 20230920);

# -- 상품 5: Nike Sportswear Club Fleece Pants (PA001)
# INSERT INTO stock_detail (manufacture_id, product_id, quantity, date) VALUES
#                                                                           (20230701, 'PA001', +100, 20230705),
#                                                                           (20230701, 'PA001', -7, 20230715),
#                                                                           (20230701, 'PA001', -3, 20230720),
#                                                                           (20230701, 'PA001', -4, 20230730),
#                                                                           (20230701, 'PA001', -5, 20230810),
#                                                                           (20230701, 'PA001', -8, 20230820);

-- 상품 6: Under Armour Tech 2.0 Tee (TS010)
INSERT INTO stock_detail (manufacture_date, product_id, quantity, date) VALUES
                                                                          (20230601, 'TS010', +200, 20230605),
                                                                          (20230601, 'TS010', -20, 20230615),
                                                                          (20230601, 'TS010', -10, 20230620),
                                                                          (20230601, 'TS010', -8, 20230630),
                                                                          (20230601, 'TS010', -5, 20230710),
                                                                          (20230601, 'TS010', -7, 20230720);

# -- 상품 7: Uniqlo Suede Slip-On Shoes (SH0017)
# INSERT INTO stock_detail (manufacture_id, product_id, quantity, date) VALUES
#                                                                           (20230501, 'SH017', +180, 20230505),
#                                                                           (20230501, 'SH017', -12, 20230515),
#                                                                           (20230501, 'SH017', -8, 20230520),
#                                                                           (20230501, 'SH017', -10, 20230530),
#                                                                           (20230501, 'SH017', -6, 20230610),
#                                                                           (20230501, 'SH017', -4, 20230620);

-- 상품 8: Nike Air Max 270 (SH001)
INSERT INTO stock_detail (manufacture_date, product_id, quantity, date) VALUES
                                                                          (20230401, 'SH001', +220, 20230405),
                                                                          (20230401, 'SH001', -14, 20230415),
                                                                          (20230401, 'SH001', -10, 20230420),
                                                                          (20230401, 'SH001', -12, 20230430),
                                                                          (20230401, 'SH001', -9, 20230510),
                                                                          (20230401, 'SH001', -7, 20230520);

# -- 상품 9: Uniqlo High-Top Sneakers (SH0040)
# INSERT INTO stock_detail (manufacture_id, product_id, quantity, date) VALUES
#                                                                           (20230301, 'SH040', +150, 20230305),
#                                                                           (20230301, 'SH040', -10, 20230315),
#                                                                           (20230301, 'SH040', -6, 20230320),
#                                                                           (20230301, 'SH040', -5, 20230330),
#                                                                           (20230301, 'SH040', -4, 20230410),
#                                                                           (20230301, 'SH040', -8, 20230420);

-- 상품 10: Zara Faux Leather Biker Jacket (JK004)
INSERT INTO stock_detail (manufacture_date, product_id, quantity, date) VALUES
                                                                          (20230201, 'JK004', +90, 20230205),
                                                                          (20230201, 'JK004', -5, 20230215),
                                                                          (20230201, 'JK004', -3, 20230220);

(select sum(quantity) from stock_detail where product_id = 'BG001' group by product_id);

delete from stock
where 1;

alter table stock
add section_id char(1);

insert into stock (manufacture_date, product_id, section_id, location_id, quantity)
VALUES (20231101, 'BG001', 'G', 19, (select sum(quantity) from stock_detail where product_id = 'BG001' group by product_id)),
       (20231001, 'AC001','F', 34, (select sum(quantity) from stock_detail where product_id = 'AC001' group by product_id)),
       (20230901, 'SH004','C', 10, (select sum(quantity) from stock_detail where product_id = 'SH004' group by product_id)),
       (20230801, 'JK001','E', 15, (select sum(quantity) from stock_detail where product_id = 'JK001' group by product_id)),
#        (20230701, 'PA001','A', 6001, (select sum(quantity) from stock_detail where product_id = 'PA001' group by product_id)),
       (20230601, 'TS010','B', 26, (select sum(quantity) from stock_detail where product_id = 'TS010' group by product_id)),
#        (20230501, 'SH017','H',4001, (select sum(quantity) from stock_detail where product_id = 'SH017' group by product_id)),
       (20230401, 'SH001','A', 5, (select sum(quantity) from stock_detail where product_id = 'SH001' group by product_id)),
#        (20230301, 'SH040','H', 4001, (select sum(quantity) from stock_detail where product_id = 'SH040' group by product_id)),
       (20230201, 'JK004','E', 15, (select sum(quantity) from stock_detail where product_id = 'JK004' group by product_id));

select product.brand_id, category_id, sum(volume * quantity)
from stock left join product on stock.product_id = product.id
group by product.brand_id, category_id;

select *
from product join account using (brand_id);

insert into ib_detail (id, manufacture_date, product_id, login_id, quantity, completion_date, status)
VALUES (1, 20240519, 'TS010', 'user07', 50, null, 'R');
insert into ib_detail (id, manufacture_date, product_id, login_id, quantity, completion_date, status)
VALUES (1, 20240519, 'TS001', 'user07', 100, null, 'R');
#        (1, 20240518, 'BG005', 'user01', 50, null, 'R'),
#        (2, 20240519, 'JK001', 'user02', 50, null, 'R');

insert into ib_detail (id, manufacture_date, product_id, login_id, quantity, completion_date, status)
VALUES (3, 20240517, 'JK001', 'user02', 100, null, 'P'); -- 3001
insert into ib_worker (ib_id, manufacture_date, product_id, worker_id, location_id)
VALUES (3, 20240517, 'JK001', 'worker1', 3001);
insert into ib_detail (id, manufacture_date, product_id, login_id, quantity, completion_date, status)
VALUES (3, 20240516, 'AC001', 'user04', 30, null, 'P'),
       (3, 20240516, 'BG009', 'user05', 32, null, 'P');
insert into ib_worker (ib_id, manufacture_date, product_id, worker_id, location_id)
VALUES (3, 20240516, 'AC001', 'worker1', 9001),
       (3, 20240516, 'BG009', 'worker1', 9001);

select ibw.*
from ib_detail ibd left join ib_worker ibw
                             on (ibd.id = ibw.ib_id and ibd.manufacture_date = ibw.manufacture_date and ibd.product_id = ibw.product_id)
where ibd.status = 'P'
  and worker_id = 'worker1';

update ib_detail
set completion_date = null, status = 'P'
where id = 3
  and product_id = 'JK001'
  and manufacture_date = 20240517;

select *
from stock_detail;

# insert into ob_detail (id, manufacture_id, product_id, login_id, quantity, recipient_name, address, ob_date, status, tracking_number)
# values (1, '20240501', 'SH001', )

select *
from ob_detail;