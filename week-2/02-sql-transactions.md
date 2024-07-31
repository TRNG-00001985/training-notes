# Lecture/Guided Coding Example Plan

1. TCL

---

## TCL

**Transaction**: group of related statements executed as a single unit.

### ACID

#### Atomicity

- any number of SQL transactions can be executed as a single unit called Transaction.

#### Consistancy

- The change in the state of the database doesnt cause any effects or corruption of data.
- consistency is maintained using constrains, cascading effects, triggers etc.

#### Isolaion

- Transactions are executed idependently and in a controlled and ordered way.

#### Durability

- A successfull transaction (chnage made to the DB) is permanent, even if there are system failures. 


**Commit:** Permanently saves a transaction

**Rollback:** Restores the transaction to the last commited state

**Savepoint:** Temporarily saves a transaction so that you can rollback to it later.

### Isolation Levels


modes that can be set on a session that controlls the concurrent transactions.

- Read Uncommited: All transactions can read the uncommited data from the other transactions. leads to dirty reads.
  
- Read Commited: All transactions can read the commited data from other transactions. leads to phantom read.

- Repetable Read: Creates a snapshot at the begining of the transtaction. Both commited and uncommited data is not reflected. Default isolation level in InnoDB (storage engine for MySQL)

- Serializable: locks the other transaction when one transaction is in progress.

```sql
SET SESSION | GLOBAL transaction_isolation = 'READ-UNCOMMITTED';
```

or 

```sql
SET GLOBAL | SESSION TRANSACTION ISOLATION LEVEL [READ COMMITTED | READ UNCOMMITTED | REPEATABLE READ | SERIALIZABLE]
```

```
select @SESSION.transaction_isolation;
```

**SCOPE:**

**GLOBAL:** The statement applies globally for all subsequent sessions.

**SESSION:** The statement applies to all subsequent transactions performed within the current session.


**Reference**

1. [isolation levels](https://dev.mysql.com/doc/refman/8.4/en/set-transaction.html#set-transaction-isolation-level)



