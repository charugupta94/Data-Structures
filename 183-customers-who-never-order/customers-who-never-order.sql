# Write your MySQL query statement below
select customers.name as Customers from Customers left join orders on customers.id = orders.customerId where orders.customerId is null; 
