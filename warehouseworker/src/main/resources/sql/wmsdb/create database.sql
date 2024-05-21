create database osswmsdb;
use osswmsdb;
CREATE TABLE `product`
(
    `id`          varchar(10)  NOT NULL,
    `brand_id`    bigint       NOT NULL,
    `category_id` bigint       NOT NULL,
    `name`        varchar(255) NOT NULL,
    `size`        varchar(10)  NOT NULL DEFAULT 'F' COMMENT 'F = Free, S = Small, M = Medium, L = Large,  XL =  Extra Large',
    `color`       varchar(100) NOT NULL COMMENT '검정색 = black, 흰색 = white    etc',
    `volume`      int          NOT NULL
);

CREATE TABLE `ib_detail`
(
    `id`               bigint      NOT NULL COMMENT 'id 타입 bigint로 통합',
    `manufacture_date` date        NOT NULL,
    `product_id`       varchar(10) NOT NULL,
    `login_id`         varchar(20) NOT NULL,
    `quantity`         int         NOT NULL,
    `ib_date`          date        NULL DEFAULT (CURRENT_DATE()),
    `completion_date`  date        NULL,
    `status`           char(1)     NULL DEFAULT 'R' COMMENT '입고 완료 = S(sucess),  입고 요청 = R(request), 입고 진행 = P(progress), 입고 실패 = F(failure), 입고대기= W(waiting)'
);

CREATE TABLE ob_detail
(
    `manufacture_date` date        NOT NULL,
    `ob_id`            bigint      NOT NULL,
    `product_id`       varchar(10) NOT NULL,
    `quantity`         int         NOT NULL,
    `status`           char(1)     NOT NULL COMMENT '출고대기= W(waiting), 출고 진행 = P(progress),  출고 완료 = S(sucess),  출고 실패 = F(failure),',
    `completion_date`  date        NULL,
    `tracking_number`  bigint      NULL
);

CREATE TABLE `stock`
(
    `manufacture_date`  date        NOT NULL,
    `product_id`        varchar(10) NOT NULL,
    `section_id`        char(1)     NULL,
    `location_id`       bigint      NOT NULL,
    `quantity`          int         NOT NULL COMMENT '재고 0이면 테이블에서 삭제',
    `expected_quantity` int         NULL DEFAULT 0
);

CREATE TABLE `section`
(
    `id`                char(1) NOT NULL,
    `brand_id`          bigint  NOT NULL,
    `current_capacity`  int     NULL DEFAULT 0,
    `expected_capacity` int     NULL DEFAULT 0,
    `max_capacity`      int     NOT NULL
);

CREATE TABLE `account`
(
    `id`       varchar(20) NOT NULL,
    `brand_id` bigint      NULL,
    `name`     varchar(10) NOT NULL,
    `password` varchar(20) NOT NULL COMMENT '8자 이상(영문+숫자+특수문자  1개 이상 포함)',
    `role`     char(2)     NOT NULL COMMENT 'BM(brand manager), WM(warehouse manager), WW(warehouse worker)'
);

CREATE TABLE `brand`
(
    `id`            bigint      NOT NULL,
    `name`          varchar(50) NOT NULL,
    `contract_date` date        NOT NULL,
    `expire_date`   date        NOT NULL
);

CREATE TABLE `ib_worker`
(
    `ib_id`            bigint      NOT NULL COMMENT 'id 타입 bigint로 통합',
    `manufacture_date` date        NOT NULL,
    `product_id`       varchar(10) NOT NULL,
    `worker_id`        varchar(20) NOT NULL
#     `location_id`      bigint      NULL
);

CREATE TABLE `sub_location`
(
    `id`                bigint  NOT NULL,
    `section_id`        char(1) NOT NULL,
    `category_id`       bigint  NOT NULL,
    `current_capacity`  int     NULL DEFAULT 0,
    `expected_capacity` int     NULL DEFAULT 0,
    `max_capacity`      int     NOT NULL COMMENT '한 선반에 몇개가 들어가나요?'
);

CREATE TABLE `category`
(
    `id`   bigint      NOT NULL,
    `name` varchar(50) NOT NULL
);

CREATE TABLE `worker`
(
    `id`     varchar(20) NOT NULL,
    `name`   varchar(10) NOT NULL,
    `status` char(1)     NOT NULL COMMENT '배정 가능 = T(true), 배정 불가능 = F(false)'
);

CREATE TABLE `ob_worker`
(
    `manufacture_date` date        NOT NULL,
    `ob_id`            bigint      NOT NULL,
    `product_id`       varchar(10) NOT NULL,
    `worker_id`        varchar(20) NOT NULL
#     `location_id`      bigint      NULL
);

CREATE TABLE `stock_detail`
(
    `manufacture_date` date        NOT NULL,
    `product_id`       varchar(10) NOT NULL,
    `quantity`         int         NOT NULL,
    `date`             date        NOT NULL
);

CREATE TABLE `ob_request`
(
    `id`             bigint       NOT NULL,
    `product_id`     varchar(10)  NOT NULL,
    `login_id`       varchar(20)  NOT NULL,
    `quantity`       int          NOT NULL,
    `recipient_name` varchar(20)  NOT NULL,
    `address`        varchar(255) NOT NULL,
    `ob_date`        date         NULL DEFAULT (CURRENT_DATE())
);

ALTER TABLE `product`
    ADD CONSTRAINT `PK_PRODUCT` PRIMARY KEY (
                                             `id`
        );

ALTER TABLE `ib_detail`
    ADD CONSTRAINT `PK_IB_DETAIL` PRIMARY KEY (
                                               `id`,
                                               `manufacture_date`,
                                               `product_id`
        );

ALTER TABLE ob_detail
    ADD CONSTRAINT `PK_OB_DETAIL` PRIMARY KEY (
                                               `manufacture_date`,
                                               `ob_id`,
                                               `product_id`
        );

ALTER TABLE `stock`
    ADD CONSTRAINT `PK_STOCK` PRIMARY KEY (
                                           `manufacture_date`,
                                           `product_id`
        );

ALTER TABLE `section`
    ADD CONSTRAINT `PK_SECTION` PRIMARY KEY (
                                             `id`
        );

ALTER TABLE `account`
    ADD CONSTRAINT `PK_ACCOUNT` PRIMARY KEY (
                                             `id`
        );

ALTER TABLE `brand`
    ADD CONSTRAINT `PK_BRAND` PRIMARY KEY (
                                           `id`
        );

ALTER TABLE `ib_worker`
    ADD CONSTRAINT `PK_IB_WORKER` PRIMARY KEY (
                                               `ib_id`,
                                               `manufacture_date`,
                                               `product_id`
        );

ALTER TABLE `sub_location`
    ADD CONSTRAINT `PK_SUB_LOCATION` PRIMARY KEY (
                                                  `id`
        );

ALTER TABLE `category`
    ADD CONSTRAINT `PK_CATEGORY` PRIMARY KEY (
                                              `id`
        );

ALTER TABLE `worker`
    ADD CONSTRAINT `PK_WORKER` PRIMARY KEY (
                                            `id`
        );

ALTER TABLE `ob_worker`
    ADD CONSTRAINT `PK_OB_WORKER` PRIMARY KEY (
                                               `manufacture_date`,
                                               `ob_id`,
                                               `product_id`
        );

# ALTER TABLE `stock_detail`
#     ADD CONSTRAINT `PK_STOCK_DETAIL` PRIMARY KEY (
#                                                   `manufacture_date`,
#                                                   `product_id`
#         );

ALTER TABLE `ob_request`
    ADD CONSTRAINT `PK_OB_REQUEST` PRIMARY KEY (
                                                `id`,
                                                `product_id`
        );


ALTER TABLE `ib_detail`
    ADD CONSTRAINT `FK_product_TO_ib_detail_1` FOREIGN KEY (
                                                            `product_id`
        )
        REFERENCES `product` (
                              `id`
            );
--
ALTER TABLE ob_detail
    ADD CONSTRAINT `FK_ob_request_TO_ob_detail_1` FOREIGN KEY (
                                                               `ob_id`
        )
        REFERENCES `ob_request` (
                                 `id`
            );
ALTER TABLE `ob_request`
    ADD INDEX (`product_id`);

ALTER TABLE ob_detail
    ADD CONSTRAINT `FK_ob_request_TO_ob_detail_2` FOREIGN KEY (
                                                               `product_id`
        )
        REFERENCES `ob_request` (
                                 `product_id`
            );

ALTER TABLE `stock`
    ADD CONSTRAINT `FK_product_TO_stock_1` FOREIGN KEY (
                                                        `product_id`
        )
        REFERENCES `product` (
                              `id`
            );

ALTER TABLE `ib_worker`
    ADD CONSTRAINT `FK_ib_detail_TO_ib_worker_1` FOREIGN KEY (
                                                              `ib_id`
        )
        REFERENCES `ib_detail` (
                                `id`
            );

ALTER TABLE `ib_worker`
    ADD INDEX (`manufacture_date`);
ALTER TABLE `ib_detail`
    ADD INDEX (`manufacture_date`);
ALTER TABLE `ib_worker`
    ADD CONSTRAINT `FK_ib_detail_TO_ib_worker_2` FOREIGN KEY (
                                                              `manufacture_date`
        )
        REFERENCES `ib_detail` (
                                `manufacture_date`
            );

ALTER TABLE `ib_worker`
    ADD CONSTRAINT `FK_ib_detail_TO_ib_worker_3` FOREIGN KEY (
                                                              `product_id`
        )
        REFERENCES `ib_detail` (
                                `product_id`
            );

ALTER TABLE `ob_worker`
    ADD CONSTRAINT `FK_ob_detail_TO_ob_worker_1` FOREIGN KEY (
                                                              `manufacture_date`
        )
        REFERENCES ob_detail (
                              `manufacture_date`
            );

ALTER TABLE `ob_worker`
    ADD CONSTRAINT `FK_ob_detail_TO_ob_worker_2` FOREIGN KEY (
                                                              `ob_id`
        )
        REFERENCES ob_detail (
                              `ob_id`
            );

ALTER TABLE `ob_worker`
    ADD CONSTRAINT `FK_ob_detail_TO_ob_worker_3` FOREIGN KEY (
                                                              `product_id`
        )
        REFERENCES `ob_detail` (
                                `product_id`
            );

ALTER TABLE `stock_detail`
    ADD CONSTRAINT `FK_product_TO_stock_detail_1` FOREIGN KEY (
                                                               `product_id`
        )
        REFERENCES `product` (
                              `id`
            );

ALTER TABLE `ob_request`
    ADD CONSTRAINT `FK_product_TO_ob_request_1` FOREIGN KEY (
                                                             `product_id`
        )
        REFERENCES `product` (
                              `id`
            );

ALTER TABLE `account`
    ADD CONSTRAINT `FK_brand_id` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`);

ALTER TABLE `ib_detail`
    ADD CONSTRAINT `FK_login_id` FOREIGN KEY (`login_id`) REFERENCES `account` (`id`);

ALTER TABLE `ib_worker`
    ADD CONSTRAINT `FK_worker_id` FOREIGN KEY (`worker_id`) REFERENCES `worker` (`id`);


ALTER TABLE `ob_request`
    ADD CONSTRAINT `FK_ob_request_login_id` FOREIGN KEY (`login_id`) REFERENCES `account` (`id`);

ALTER TABLE `worker`
    ADD CONSTRAINT `FK_worker_table_id` FOREIGN KEY (`id`) REFERENCES `account` (`id`);

ALTER TABLE `ob_worker`
    ADD CONSTRAINT `FK_ob_request_worker_id` FOREIGN KEY (`worker_id`) REFERENCES `account` (`id`);

ALTER TABLE `product`
    ADD CONSTRAINT `FK_product_table_brand_id` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`);

ALTER TABLE `product`
    ADD CONSTRAINT `FK_product_table_category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);
--
ALTER TABLE `section`
    ADD CONSTRAINT `FK_section_table_brand_id` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`);

ALTER TABLE `stock`
    ADD CONSTRAINT `FK_stock_table_sub_location_id` FOREIGN KEY (`location_id`) REFERENCES `sub_location` (`id`);

ALTER TABLE `sub_location`
    ADD CONSTRAINT `FK_sub_location_table_section_id` FOREIGN KEY (`section_id`) REFERENCES `section` (`id`);
--
ALTER TABLE `sub_location`
    ADD CONSTRAINT `FK_sub_location_table_category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

CREATE TABLE `tracking_number`
(
    `ob_id`  bigint NOT NULL primary key,
    `number` bigint NOT NULL
);