# Write your MySQL query statement below
select u.name, coalesce(r.dis,0) "travelled_distance"
from Users u 
left join (
    select user_id, sum(distance) "dis"
    from Rides
    group by user_id
) r on u.id=r.user_id
order by r.dis DESC, u.name ASC;