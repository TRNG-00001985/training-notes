# Lecture/Guided Coding Example

1. Triggers

---

# Triggers

- A predefined action action that is executed everytime a specific event occurs.
- the event could be a DML command INSERT, UPDATE, DELETE .
- Triggers are usefull maintain the consistancy.



synatx

```sql
CREATE TRIGGER trigger_name [BEFORE | AFTER] [INSERT| DELETE | UPDATE]
FOR EACH ROE
// sql tatements
```

