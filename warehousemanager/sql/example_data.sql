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


select *
from ib_detail
where status = 'R';


select *
from sub_location
where  section_id in (
    select id
    from  section
    where brand_id  in (
        select brand_id
        from product
        where id  in (
            select product_id
            from ib_detail
            where status ='R' ))) and category_id in (
    select category
    from product
    where id in (
        select product_id
        from ib_detail  where status ='R' ));

