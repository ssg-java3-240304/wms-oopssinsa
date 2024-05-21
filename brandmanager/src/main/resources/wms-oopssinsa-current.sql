# CREATE DATABASE wms_db;
# use osswmsdb;
DROP TABLE account; -- 1
DROP TABLE brand; -- 13
DROP TABLE category; -- 12
DROP TABLE ib_worker; -- 3
DROP TABLE ib_detail; #ib_detail테이블 삭제하려면 ib_worker 먼저 삭제 -- 4
DROP TABLE ob_worker; -- 5
DROP TABLE ob_detail; #ob_detail 테이블 삭제하려면 ob_workder 먼저 삭제 -- 6
DROP TABLE section; -- 11
DROP TABLE stock; -- 2
DROP TABLE product; # product테이블 삭제하려면 stock 먼저 삭제 -- 8
DROP TABLE stock_detail; -- 7
DROP TABLE sub_location; -- 9
DROP TABLE worker; -- 10
DROP TABLE ob_request;

CREATE TABLE `product` (
                           `id`	varchar(10)	NOT NULL,
                           `brand_id`	bigint	NOT NULL,
                           `name`	varchar(255)	NOT NULL,
                           `size`	varchar(10)	NOT NULL	DEFAULT 'F'	COMMENT 'F = Free, S = Small, M = Medium, L = Large,  XL =  Extra Large',
                           `color`	varchar(100)	NOT NULL	COMMENT '검정색 = black, 흰색 = white    etc',
                           `category`	varchar(100)	NOT NULL,
                           `volume`	int	NOT NULL
); -- F 를 'F' 로 변경

CREATE TABLE `ib_detail` (
                             `id`	bigint	NOT NULL	COMMENT 'id 타입 bigint로 통합',
                             `manufacture_id`	date	NOT NULL,
                             `product_id`	varchar(10)	NOT NULL,
                             `login_id`	varchar(20)	NOT NULL,
                             `quantity`	int	NOT NULL,
                             `ib_date`	date	NULL	DEFAULT (CURRENT_DATE()),
                             `completion_date`	date	NULL,
                             `status`	char(1)	NULL	DEFAULT 'R'	COMMENT '입고 완료 = S(sucess),  입고 요청 = R(request), 입고 진행 = P(progress), 입고 실패 = F(failure), 입고대기(waiting)'
); -- 수정 기존 ib_date 에서 cur_date() -> (CURRENT_DATE()) 변경

# CREATE TABLE ob_detail (
#                              `id`	bigint	NOT NULL,
#                              `manufacture_id`	date	NULL,
#                              `product_id`	varchar(10)	NOT NULL,
#                              `login_id`	varchar(20)	NOT NULL,
#                              `quantity`	int	NOT NULL,
#                              `recipient_name`	varchar(20)	NOT NULL,
#                              `address`	varchar(255)	NOT NULL,
#                              `ob_date`	date	NULL,
#                              `status`	char(1)	NULL	DEFAULT 'R'	COMMENT '출고 완료 = S(sucess),  출고 요청 = R(request), 출고 진행 = P(progress), 출고 실패 = F(failure), 출고대기(waiting)',
#                              `tracking_number`	int	NULL
# );
CREATE TABLE `ob_detail` (
                             `manufacture_date`	date	NOT NULL,
                             `ob_id`	bigint	NOT NULL,
                             `product_id`	varchar(10)	NOT NULL,
                             `quantity`	int	NOT NULL,
                             `status`	char(1)	NOT NULL	COMMENT '출고대기= W(waiting), 출고 진행 = P(progress),  출고 완료 = S(sucess),  출고 실패 = F(failure),',
                             `completion_date`	date	NULL,
                             `tracking_number`	int	NULL
);

CREATE TABLE `stock` (
                         `manufacture_id`	date	NOT NULL,
                         `product_id`	varchar(10)	NOT NULL,
                         `section_id`	char(1)	NOT NULL	COMMENT '카테고리명',
                         `location_id`	bigint	NOT NULL,
                         `quantity`	int	NOT NULL	COMMENT '재고 0이면 테이블에서 삭제'
);

CREATE TABLE `section` (
                           `id`	bigint	NOT NULL,
                           `brand_id`	bigint	NULL,
                           `current_capacity`	int	NULL	DEFAULT 0,
                           `max_capacity`	int	NOT NULL
);

CREATE TABLE `account` (
                           `id`	varchar(20)	NOT NULL,
                           `brand_id`	bigint	NULL,
                           `name`	varchar(10)	NOT NULL,
                           `password`	varchar(20)	NOT NULL	COMMENT '8자 이상(영문+숫자+특수문자  1개 이상 포함)',
                           `role`	char(2)	NOT NULL	COMMENT 'BM(brand manager), WM(warehouse manager), WW(warehouse worker)'
);

CREATE TABLE `brand` (
                         `id`	bigint	NOT NULL,
                         `name`	varchar(50)	NOT NULL,
                         `contract_date`	date	NOT NULL,
                         `expiration_date`	date	NOT NULL
);

CREATE TABLE `ib_worker` (
                             `ib_id`	bigint	NOT NULL	COMMENT '입출고id 타입 bigint로 통일',
                             `manufacture_id`	date	NOT NULL,
                             `product_id`	varchar(10)	NOT NULL,
                             `worker_id`	varchar(10)	NOT NULL,
                             `location_id`	bigint	NOT NULL
);

CREATE TABLE `sub_location` (
                                `id`	bigint	NOT NULL,
                                `section_id`	char(1)	NOT NULL,
                                `category_id`	bigint	NOT NULL,
                                `current_capacity`	int	NULL	DEFAULT 0,
                                `max_capacity`	int	NOT NULL	COMMENT '한 선반에 몇개가 들어가나요?'
);
-- catagory_id -> category_id로 변경 오타나있음 이미 테이블 만들어서 이름 수정으로 바꿈
-- ALTER TABLE `sub_location` CHANGE COLUMN `catagory_id` `category_id` bigint NOT NULL;


CREATE TABLE `category` (
                            `id`	bigint	NOT NULL,
                            `name`	varchar(50)	NOT NULL
);

CREATE TABLE `worker` (
                          `id`	varchar(10)	NOT NULL,
                          `name`	varchar(10)	NOT NULL,
                          `status`	char(1)	NOT NULL	COMMENT '배정 가능 = T(true), 배정 불가능 = F(false)'
);

CREATE TABLE `ob_worker` (
                             `id`	bigint	NOT NULL,
                             `manufacture_id`	date	NOT NULL,
                             `product_id`	varchar(10)	NOT NULL,
                             `worker_id`	varchar(10)	NOT NULL,
                             `location_id`	bigint	NOT NULL
);

CREATE TABLE `stock_detail` (
                                `manufacture_id`	date	NOT NULL,
                                `product_id`	varchar(10)	NOT NULL,
                                `quantity`	int	NOT NULL,
                                `date`	date	NOT NULL
);
CREATE TABLE `ob_request` (
                              `id`	bigint	NOT NULL,
                              `product_id`	varchar(10)	NOT NULL,
                              `login_id`	varchar(20)	NOT NULL,
                              `quantity`	int	NOT NULL,
                              `recipient_name`	varchar(20)	NOT NULL,
                              `address`	varchar(255)	NOT NULL,
                              `ob_date`	date	NULL	DEFAULT (CURRENT_DATE())
);

ALTER TABLE `ob_request` ADD CONSTRAINT `PK_OB_REQUEST` PRIMARY KEY (
                                                                     `id`,
                                                                     `product_id`
);

ALTER TABLE `ob_request` ADD CONSTRAINT `FK_product_TO_ob_request_1` FOREIGN KEY (
                                                                                  `product_id`
    )
    REFERENCES `product` (
                          `id`
        );

ALTER TABLE `product` ADD CONSTRAINT `PK_PRODUCT` PRIMARY KEY (
                                                               `id`
    );

ALTER TABLE `ib_detail` ADD CONSTRAINT `PK_IB_DETAIL` PRIMARY KEY (
                                                                   `id`,
                                                                   `manufacture_id`,
                                                                   `product_id`
    );

ALTER TABLE ob_detail ADD CONSTRAINT `PK_OB_DETAIL` PRIMARY KEY (
                                                                   `id`,
                                                                   `manufacture_id`,
                                                                   `product_id`
    );

ALTER TABLE `stock` ADD CONSTRAINT `PK_STOCK` PRIMARY KEY (
                                                           `manufacture_id`,
                                                           `product_id`
    );

ALTER TABLE `section` ADD CONSTRAINT `PK_SECTION` PRIMARY KEY (
                                                               `id`
    );

ALTER TABLE `account` ADD CONSTRAINT `PK_ACCOUNT` PRIMARY KEY (
                                                               `id`
    );

ALTER TABLE `brand` ADD CONSTRAINT `PK_BRAND` PRIMARY KEY (
                                                           `id`
    );

ALTER TABLE `ib_worker` ADD CONSTRAINT `PK_IB_WORKER` PRIMARY KEY (
                                                                   `ib_id`,
                                                                   `manufacture_id`,
                                                                   `product_id`
    );

ALTER TABLE `sub_location` ADD CONSTRAINT `PK_SUB_LOCATION` PRIMARY KEY (
                                                                         `id`
    );

ALTER TABLE `category` ADD CONSTRAINT `PK_CATEGORY` PRIMARY KEY (
                                                                 `id`
    );

ALTER TABLE `worker` ADD CONSTRAINT `PK_WORKER` PRIMARY KEY (
                                                             `id`
    );

ALTER TABLE `ob_worker` ADD CONSTRAINT `PK_OB_WORKER` PRIMARY KEY (
                                                                   `id`,
                                                                   `manufacture_id`,
                                                                   `product_id`
    );

# ALTER TABLE `stock_detail` ADD CONSTRAINT `PK_STOCK_DETAIL` PRIMARY KEY (
#                                                                          `manufacture_id`,
#                                                                          `product_id`
#     );

ALTER TABLE `ib_detail` ADD CONSTRAINT `FK_product_TO_ib_detail_1` FOREIGN KEY (
                                                                                `product_id`
    )
    REFERENCES `product` (
                          `id`
        );

ALTER TABLE ob_detail ADD CONSTRAINT `FK_product_TO_ob_detail_1` FOREIGN KEY (
                                                                                `product_id`
    )
    REFERENCES `product` (
                          `id`
        );

ALTER TABLE `stock` ADD CONSTRAINT `FK_product_TO_stock_1` FOREIGN KEY (
                                                                        `product_id`
    )
    REFERENCES `product` (
                          `id`
        );

ALTER TABLE `ib_worker` ADD CONSTRAINT `FK_ib_detail_TO_ib_worker_1` FOREIGN KEY (
                                                                                  `ib_id`
    )
    REFERENCES `ib_detail` (
                            `id`
        );


-- [HY000][1822] Failed to add the foreign key constraint. Missing index for constraint 'FK_ib_detail_TO_ib_worker_2' in the referenced table 'ib_detail'
-- 기존 sql문
#  ALTER TABLE `ib_worker` ADD CONSTRAINT `FK_ib_detail_TO_ib_worker_2` FOREIGN KEY (
# `manufacture_id`
# )
# REFERENCES `ib_detail` (
#     `manufacture_id`
# );
-- 변경된 sql문

ALTER TABLE `ib_worker` ADD CONSTRAINT `FK_ib_detail_TO_ib_worker_2` FOREIGN KEY (
                                                                                  `ib_id`, `manufacture_id`, `product_id`
    )
    REFERENCES `ib_detail` (
                            `id`, `manufacture_id`, `product_id`
        );


ALTER TABLE `ib_worker` ADD CONSTRAINT `FK_ib_detail_TO_ib_worker_3` FOREIGN KEY (
                                                                                  `product_id`
    )
    REFERENCES `ib_detail` (
                            `product_id`
        );

ALTER TABLE `ob_worker` ADD CONSTRAINT `FK_ob_detail_TO_ob_worker_1` FOREIGN KEY (
                                                                                  `id`
    )
    REFERENCES ob_detail (
                            `id`
        );

-- [HY000][1822] Failed to add the foreign key constraint. Missing index for constraint 'FK_ob_detail_TO_ob_worker_2' in the referenced table 'ob_detail'

ALTER TABLE `ob_detail` ADD INDEX `idx_ob_detail_manufacture_product` (`manufacture_id`, `product_id`); -- 추가

ALTER TABLE `ob_worker` ADD CONSTRAINT `FK_ob_detail_TO_ob_worker_2` FOREIGN KEY (
                                                                                  `manufacture_id`, `product_id`
    )
    REFERENCES `ob_detail` (
                            `manufacture_id`, `product_id`
        );




ALTER TABLE `ob_worker` ADD CONSTRAINT `FK_ob_detail_TO_ob_worker_3` FOREIGN KEY (
                                                                                  `product_id`
    )
    REFERENCES ob_detail (
                            `product_id`
        );

# ALTER TABLE `stock_detail` ADD CONSTRAINT `FK_product_TO_stock_detail_1` FOREIGN KEY (
#                                                                                       `product_id`
#     )
#     REFERENCES `product` (
#                           `id`
#         );

alter table stock
add expected_quantity int null default 0;

alter table section
add expected_capacity int null default 0;

alter table sub_location
add expected_capacity int null default 0;

alter table product
change category category_id bigint;

