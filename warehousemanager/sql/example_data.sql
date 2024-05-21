show databases;
use osswmsdb;
show tables;
select *
from product;

select *
from brand;
select *
from section;
select *
from category;
select *
from worker;
select *
from ib_detail;
select *
from sub_location;


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

select *
from product p
         join brand b on p.brand_id = b.id
         join section s on s.brand_id = b.id
         join sub_location sl on sl.section_id = s.id and p.category_id = sl.category_id
where p.id = 'TS001';

# select *, IF(sl.current_capacity+ sl.expected_capacity +  #{quantity}*p.volume<=sl.max_capacity, 'T', 'F') as ibAvailability
#              from
#              product p
#              join section s on s.brand_id = p.brand_id
#              join sub_location sl on sl.section_id = s.id and p.category_id = sl.category_id
#              where p.id = #{product_id};



select *,
       IF(sl.current_capacity +
          sl.expected_capacity + (select quantity
          from ib_detail
          where product_id='TS001')*p.volume<=sl.max_capacity, 'T', 'F') as ibAvailability,
       (sl.current_capacity +
       sl.expected_capacity + (select quantity
                               from ib_detail
                               where product_id='TS001')*p.volume) as value
          from
          product p
          join section s on s.brand_id = p.brand_id
          join sub_location sl on sl.section_id = s.id and p.category_id = sl.category_id
          where p.id = 'TS001';


SELECT *
FROM sub_location
WHERE category_id = 1001
  AND section_id = 'A';

(SELECT *
 FROM ob_request orq
 where not exists (select 1 from ob_detail where orq.product_id = product_id and orq.id = ob_id ))