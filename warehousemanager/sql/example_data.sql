show databases ;
use osswmsdb;
show tables;
select * from product;

select * from brand;
select * from section;
select * from category;
select * from worker;
select *
from ib_detail;
select * from sub_location;


select *
from ib_detail
where status = 'R';


# select *
# from sub_location
# where  section_id in (
#     select id
#     from  section
#     where brand_id  in (
#         select brand_id
#         from product
#         where id  in (
#             select product_id
#             from ib_detail
#             where status ='R' ))) and category_id in (
#     select category
#     from product
#     where id in (
#         select product_id
#         from ib_detail  where status ='R' ));

WITH relevant_product_ids AS (
    SELECT product_id
    FROM ib_detail
    WHERE status = 'R'
    ORDER BY id -- ib_detail의 행 순서를 유지하기 위해 id에 따라 정렬
),

     relevant_products AS (
         SELECT p.id AS product_id, p.brand_id, p.category
         FROM product p
                  JOIN relevant_product_ids rpi ON p.id = rpi.product_id
     ),

     relevant_sections AS (
         SELECT s.id AS section_id, rp.category AS section_category
         FROM section s
                  JOIN relevant_products rp ON s.brand_id = rp.brand_id
     ),

     final_results AS (
         SELECT
             rs.section_id AS relevant_section_id,
             rs.section_category AS relevant_section_category,
             sl.*
         FROM relevant_sections rs
                  LEFT JOIN sub_location sl ON rs.section_id = sl.section_id AND rs.section_category = sl.category_id
     )

SELECT *
FROM final_results;