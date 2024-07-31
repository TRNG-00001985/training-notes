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

1. Retrieve the list of employees along with their department names where employees are associated with departments.
2. Retrieve all employees and their associated department names. If an employee does not belong to a department, show NULL.
3. Retrieve all departments and the names of employees in those departments. If a department does not have any employees, show NULL.
4. Retrieve all possible combinations of employees and projects.
5. Retrieve the list of employees whose department ID is greater than the department ID of their department
6. Retrieve the list of projects along with their department names, where the projects are associated with departments
7. Find employees who are not assigned to any department
8. Find departments that have no employees
9.  Find all departments along with the number of employees in each department
