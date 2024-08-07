# Lecture/ Guided Coding Examle

1. IO Serialization
2. Logging
3. Functional Programming
   1. Functional interface
   2. Lambda
   3. optional class
   4. method reference
   5. stream-api

---

# I/O


## Serialization

- the process of conversion java object into a static stream of bytes is called Serialization and the opposite is called deserialization.
- primitive data types, object references, arrays and strings are serializable.
- transient variables and static varibales are not serialized.
- sensitive information like passwords and large objects are declared transient for security and improved performance.


## File I/O

FileInputStream: reads raw byte streams from a file.
FileOutputStream: writes raw byte streams to a file.
FileReader:reads character streams from a file
BufferReader: reads text(lines) from a character stream. 
FileWriter: writes charater streams to a file
BufferedWriter: reads text(lines) from a character stream
PrintWriter: prints formated represntations of pbjects to a text-output stream.
Scanner: text scanner that can parse primitives and strings using regex.

# Logging

##  Logback

[logback classic maven dependecy](https://mvnrepository.com/artifact/ch.qos.logback/logback-classic)

### Logback Introduction

- logback is fast logging system.
- it is a successor of log4j
- logback requires slf4j

### Root

- specifies the root logging level

### Logging Levels

- TRACE: most detailed, used for tracing program execution. ex: flow of execution within loops or recursive calls.
- DEBUG: detailed info for debugging. ex: application state and behavior.
- INFO: informational messages. ex: events like startup, config details and major milestones.
- WARN: potentially harmful situations that might not immediately affect the application but could lead to errors. ex: deprecated api usage.
- ERROR: error events that might still allow the application to continue running. ex: runtime errors, and exceptions.

| level of request p | effective level q |       |      |      |       |     |
|--------------------|-------------------|-------|------|------|-------|-----|
|                    | TRACE             | DEBUG | INFO | WARN | ERROR | OFF |
| TRACE              | YES               | NO    | NO   | NO   | NO    | NO  |
| DEBUG              | YES               | YES   | NO   | NO   | NO    | NO  |
| INFO               | YES               | YES   | YES  | NO   | NO    | NO  |
| WARN               | YES               | YES   | YES  | YES  | NO    | NO  |
| ERROR              | YES               | YES   | YES  | YES  | YES   | NO  |


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