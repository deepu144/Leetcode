# Write your MySQL query statement below
select u.user_id as buyer_id ,
u.join_date,
coalesce(o.cnt,0) as orders_in_2019
from Users u 
LEFT JOIN (
    Select buyer_id,count(buyer_id) as cnt
    from Orders
    where order_date between '2019-01-01' AND '2019-12-31'
    group by buyer_id
) o ON u.user_id = o.buyer_id;
