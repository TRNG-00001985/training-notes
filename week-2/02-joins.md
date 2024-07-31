# Lecture/Guided Coding Example Plan

1. Joins
2. Subqueries

---
**Alias:** a temporory name for column or table. the column alias can be used with GROUP BY, ORDER BY or HAVING.

## Joins

**Inner Join:** returns common records in both the tabels.


**Outer Join:** 

- **Left Join**  returns all the records from the left table and the matched records from the right table. if there is no match, the result is NULL on the right table.


- **Right Join:** returns all the records from the right table and the matched records from the left table. if there is no match, the result is NULL on the left table.



- **Full Outer Join:** MySQL does'nt support  full outer join. An Union of left join and right join returns the similar result.


**Cross Join:** Cartisian product. retunrs all possible combinations between two tables. 


**Theta Join:** joins tabels based on comparision operator `=`, `<` `>`, `<=`, `>=`, `<>`.


**Equi Join:** joins tabels based on equlaity `=`.


## Sub Queries

- a select statemenet within another statemnt.



