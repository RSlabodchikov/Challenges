/* 
    https://www.hackerrank.com/domains/sql
    
    City
    +--------------+-------------+
    | Field        |   Type      |
    +--------------+-------------+
    | ID           | INTEGER     |
    | NAME         | VARCHAR(17) |
    | COUNTRYCODE  | VARCHAR(3)  |
    | DISTRICT     | VARCHAR(20) |
    | POPULATION   | NUMERIC     |
    +--------------+-------------+
    
    
    Station   
    +-------------+------------+
    | Field       |   Type     |
    +-------------+------------+
    | ID          | INTEGER    |
    | CITY        | VARCHAR(21)|
    | STATE       | VARCHAR(2) |
    | LAT_N       | NUMERIC    |
    | LONG_W      | NUMERIC    |
    +-------------+------------+
    
    Employee   
    +-------------+------------+
    | Field       |   Type     |
    +-------------+------------+
    | employee_id | INTEGER    |
    | name        | VARCHAR(55)|
    | months      | INTEGER    |
    | salary      | INTEGER    |
    +-------------+------------+
    
    Triangles   
    +-------------+------------+
    | Field       |   Type     |
    +-------------+------------+
    | A           | INTEGER    |
    | B           | INTEGER    |
    | C           | INTEGER    |
    +-------------+------------+

 */

select *
from CITY
where POPULATION > 100000
  and COUNTRYCODE = 'USA';

select *
from city c;

select *
from city c
where c.countrycode = 'JPN';


select s.city, s.state
from station s;

select count(*) - count(distinct (s.city))
from station s;

select distinct s.city
from station s
where REGEXP_LIKE(s.city, '^[aeiou]', 'i');

select s.city
from station s
where REGEXP_LIKE(s.city, '^[aeiou].*[aeiou]$', 'i');


select distinct s.city
from station s
where not REGEXP_LIKE(s.city, '*[aeiou]$', 'i');

select distinct s.city
from station s
where NOT REGEXP_LIKE(s.city, '^[aeiou].*', 'i')
  and NOT REGEXP_LIKE(s.city, '*[aeiou]$', 'i');

select count(*)
from city c
where c.population > 100000;

select avg(c.population)
from city c
where c.district = 'California';

select sum(c.population)
from city c
where c.district = 'California';

select avg(c.population)
from city c;


select e.name
from employee e
order by e.name;

select e.name
from employee e
where e.salary > 2000
  and e.months < 10
order by employee_id;


SELECT CASE
           WHEN a + b <= c or a + c <= b or b + c <= a THEN 'Not A Triangle'
           WHEN a = b and b = c THEN 'Equilateral'
           WHEN a = b or a = c or b = c THEN 'Isosceles'
           ELSE 'Scalene'
           END AS TriangleType
FROM triangles;

select o.name || '(' || SUBSTR(o.occupation, 1, 1) || ')'
from occupations o
order by o.name;
select 'There are a total of ' || (count(*)) || ' ' || LOWER(o.occupation) || 's.'
from occupations o
group by o.occupation
order by count(*), o.occupation;


select p.firstName, p.lastName, a.city, a.state
from Person p
         left join Address a
                   on a.personId = p.personId;

SELECT d.name AS Department, e.name AS Employee, e.salary AS Salary
FROM Department d
         LEFT JOIN Employee e
                   ON d.id = e.departmentId
WHERE (e.departmentId, e.salary) IN (
    SELECT departmentId, MAX(Salary) AS wage
    FROM Employee
    GROUP BY departmentId);

select c.name as Customers
from customers c
         left join orders o
                   on o.customerId = c.id
where o.id is null;

with salaries as (
    select e.departmentId,
           e.salary,
           row_number() over (
               partition by departmentId
               order by salary desc
               ) rn
    from Employee e
    group by departmentId, salary
)
select d.name AS Department, e.name AS Employee, e.salary
from Employee e
         left join Department d
                   on e.departmentId = d.id
where (e.salary, e.departmentId) in (
    select salary, departmentId
    from salaries s
    where s.rn <= 3
);

delete
from Person p
where (p.id, p.email) not in (
    select min(id), email
    from person
    group by email);

select w.id as Id from Weather w
where w.id > 1 and w.temperature > (LAG(w.temperature, 1, 0) OVER (order by temperature));



select id as "Id" from
    (
        select id, temperature,
               LAG(temperature, 1, 0) OVER (order by recordDate)   as prevTemperature,
               recordDate,
               LAG(recordDate, 1, null) OVER (order by recordDate) as prevDate
        from Weather w
    ) as w2
where temperature > prevTemperature and prevDate is not null and recordDate - prevDate = 1;



