### Transactions and lock 

- Transaction is a unit of work 
- that you want to treat as whole either complete or nothing 
- Suppose i wanted to send 10 rs  from a to b
  - Transactions looks like as below
    - withdraw
    - deposit
    - deduct_comission


- Suppose there is some error or failure in some steps then it will revert everything which has happened earlier
- If there is no error after completing all the steps then db will commit the transaction


- What happen when there are concurrent operation happening on same account during the same time




### Advantage of transaction
- Reliable unit of work 
- Allow correct recovery from failures
- Keeps data consistent
- Isolation from the concurrent access 


### Write Ahead lock 

- We are using write ahead lock it means that raw is locked and until transaction is not completed it will not update anything in the table 
- Once transaction complete then it will update the record as a single unit of work.
- 