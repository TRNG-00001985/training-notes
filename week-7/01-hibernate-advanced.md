# Lecture/ Guided Coding Example

1. Hibernate
    - Caching
    - Connection Pooling
---


### Caching

`READ_ONLY`: Objects don’t change once inside the cache.

`NONSTRICT_READ_WRITE`: Objects change (eventually) after the corresponding database entry is updated; this guarantees eventual consistency.

`READ_WRITE`: Objects change (immediately) after the corresponding database entry is updated; this guarantees strong consistency by using "soft" locks.

`TRANSACTIONAL`: Objects change using distributed XA transactions, ensuring data integrity; this guarantees either total success or rolling back all changes. 


### Connection pooling