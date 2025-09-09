## Lock
- there is 2 kind of lock

### Optimistic Lock
- It is the strategy where you read the record take note of version number, timestamp or checksum and check that the version 
has not changed before you write the record 
- We have table contains [Id, Data, TimeStamp] suppose one thread comes in access the data
- And after updating the data it will check whether timestamp is same or not if same it will update the data and current timestamp for this record
- Suppose the timestamp is different then it means that some other thread make some changes in the data and this operation is invalid
- 


### Pessimistic Lock 
- Suppose we have a table [Id, Data, Timestamp]
- And we wanted update data for a given id then in this strategy we have to lock the entire row and then do the operation
- No other thread will be allowed to access this record until earlier thread finish this work.




### Use Cases 
- These lock will be used on the basis of use case 
  - Pessimistic lock is mostly used in databases
  - Optimistic lock can be used in updating wikipedia, article editing 
  - Editing article is takes so much time so it would be good to use optimistic lock

- In the distributed system there is lots of concurrency then pessimistic lock tense to holding up the resource 
- so no other thread is not allowed to access that resource 
- but in optimistic lock thread is not holding the resource 
- General rule of thumb to choose a lock is 
  - Few conflict => use optimistic lock 
  - More conflict => use pessimistic lock







### Reference 
https://vipulpachauri12.medium.com/distributed-locking-to-build-reliable-systems-fdac64545ea0
