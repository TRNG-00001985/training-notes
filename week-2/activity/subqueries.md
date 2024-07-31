
### Employee Database Schema

**Employees**
| EmployeeID | EmployeeName | DepartmentID |
|------------|--------------|--------------|
| 1          | John         | 1            |
| 2          | Jane         | 2            |
| 3          | Mark         | 1            |
| 4          | Emily        | 3            |

**Departments**
| DepartmentID | DepartmentName |
|--------------|----------------|
| 1            | Sales          |
| 2            | HR             |
| 3            | IT             |
| 4            | Marketing      |

**Projects**
| ProjectID | ProjectName  | DepartmentID |
|-----------|--------------|--------------|
| 101       | Project A    | 1            |
| 102       | Project B    | 2            |
| 103       | Project C    | 3            |
| 104       | Project D    | 4            |
| 105       | Project E    | NULL         |

### Questions

1. Find the names of employees who work in the same department as 'John'
2. Find departments that have more than one employee
3. Find the projects that are not assigned to any department
4. Find the department with the maximum number of employees.
5. Find employees who are working on projects in the 'Sales' department.
6. Find the names of departments that do not have any projects.
7. Find employees who are not working on any project.
8. Find the department names and the number of employees in each department, only for departments with more than two employees.
9. Find the projects handled by employees in the 'IT' department.
10. Find the names of employees who do not work in the 'Marketing' department.