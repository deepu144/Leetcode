# Write your MySQL query statement below
select 
b.stock_name as stock_name ,
s.sell-b.buy as capital_gain_loss
from (
    select stock_name,operation, sum(price) as buy
    from Stocks
    where operation='Buy'
    group by stock_name,operation
) b 
JOIN (
    select stock_name,operation, sum(price) as sell
    from Stocks
    where operation='Sell'
    group by stock_name,operation
) s ON b.stock_name=s.stock_name