-- select a.name as Employee from Employee a where a.salary > (select b.salary from employee b where a.managerId=b.id);

select a.name as Employee from Employee a join Employee b on a.managerId=b.id where a.salary>b.salary;