# Lecture/ Guided Coding Examle

1. IO Serialization
2. Functional Programming
   1. Functional interface
   2. Lambda
   3. optional class
   4. method reference
   5. stream-api
3. Logging

---

# I/O


## Serialization


## File I/O


# Logging


##  Logback

### Logback Introduction

- logback is fast logging system.
- it is a successor of log4j
- logback requires slf4j

### Root

- specifies the root logging level

    - TRACE
    - DEBUG
    - INFO
    - WARN
    - ERROR


### Apenders

- log events are written into appenders

1. console appender
2. file appender


### Encoders

- used to format log events


### MDC Implementation

- In a multi threaded application, additional context related to client could help with better categorization of logs. Mapped Diagnostic Contexts are used to add additonal info to log.

ex: user Id


**Reference**

[logback official docs](https://logback.qos.ch/manual/index.html)


# Functional Programming

## Anonymous function

## Functional Interfaces

## Lambdas

## Method References

## Optional Class

## Stream API