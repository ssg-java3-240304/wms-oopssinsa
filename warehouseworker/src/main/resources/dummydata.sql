-- brand dummy table

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
ALTER TABLE account
ADD constraint fk_brand_id FOREIGN KEY (brand_id)
REFERENCES brand (id)
on update cascade
ON DELETE CASCADE;

-- brand를 수정/삭제하면 해당 브랜드 소속 account도 수정/삭제된다

-- 제약조건 확인
select
    *
from information_schema.table_constraints
where constraint_schema = 'osswmsdb';

-- 브랜드 id auto_increment값으로 설정
alter table brand
modify id bigint auto_increment;

alter table sub_location
modify id bigint auto_increment;

-- product에 brand_id 외래키 추가
ALTER TABLE product
ADD constraint fk_brand_id2 FOREIGN KEY (brand_id)
REFERENCES brand (id)
on update cascade;

-- section에 brand_id 외래키 추가
ALTER TABLE section
ADD constraint fk_brand_id3 FOREIGN KEY (brand_id)
REFERENCES brand (id)
on update cascade
on delete cascade;

alter table section
change id id char(1);

alter table sub_location
change section_id section_id char(1);

alter table sub_location
change id id varchar(4);

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
       (6001, '바지/청파지'),
       (9001, '악세서리');

insert into section (id, brand_id, current_capacity, max_capacity)
VALUES ('A', 1, 0, 4600),
       ('B', 6, 0, 3600),
       ('C', 2, 0, 5050),
       ('E', 3, 0, 2600),
       ('F', 7, 0, 720),
       ('G', 4, 0, 2950),
       ('H', 5, 0, 1310);
insert into section (id, current_capacity, max_capacity)
values ('D', 0, 1000);

insert into sub_location (section_id, category_id, current_capacity, max_capacity)
VALUES ('A', 1001, 0, 1000),
       ('A', 2001, 0, 800),
       ('A', 2002, 0, 800),
       ('A', 3001, 0, 500),
       ('A', 4001, 0, 1500),
       ('C', 1001, 0, 1200),
       ('C', 2001, 0, 900),
       ('C', 2002, 0, 900),
       ('C', 3001, 0, 450),
       ('C', 4001, 0, 1600),
       ('E', 1001, 0, 700),
       ('E', 5001, 0, 600),
       ('E', 5002, 0, 400),
       ('E', 6001, 0, 550),
       ('E', 3001, 0, 350),
       ('G', 1001, 0, 800),
       ('G', 5001, 0, 700),
       ('G', 5002, 0, 450),
       ('G', 6001, 0, 600),
       ('G', 3001, 0, 400),
       ('H', 1001 , 0, 900),
       ('H', 1002, 0, 650),
       ('H', 6001, 0, 700),
       ('H', 3001, 0, 450),
       ('H', 9001, 0, 500),
       ('B', 1001, 0, 850),
       ('B', 2001, 0, 700),
       ('B', 2002, 0, 700),
       ('B', 3001, 0, 350),
       ('B', 4001, 0, 1000),
       ('F', 1001, 0, 200),
       ('F', 5001, 0, 150),
       ('F', 5002, 0, 120),
       ('F', 6001, 0, 150),
       ('F', 3001, 0, 100);