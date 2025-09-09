### Distributed transaction 
- Transaction means is "all or nothing"
- In monolitic architecture db level transaction best fit for that scenario


- For microservice architecture 
  - whenever user place an order orchestrator call 2 different services 
    - customer wallet 
    - order management service

  - when customer place an order orchestrator makes 2 calls 
    - check balance deduct
    - create order
  - the solution instead of using 2 different databases use one database for both microservice 
  - It's not the right way to do that as each microservice has to have their own database
 
- Then distributed transaction comes into picture 
  - we can implement distributed transaction using following strategy
    - two phase commit 
      - there is 2 phase 
        - prepare
        - commit 
      - There is co-ordinator who takes care of two phase commit 
      - 
    - SAGA




### Two phase commit 

- run that scenario which as we discussed earlier place an order on amazon
  - co-ordinator creates a transaction id 
  - start prepare for wallet [prepare wallet] => it will lock the wallet 
  - start prepare for order [prepare order] => it will lock the order in inventory
  - once it get prepare acknowledge from both microservice
  - Coordinator make a call name commit wallet 
  - Coordinator make a call name commit order
  - waiting for response ok commit from both the microservices
- Coordinator will have timeout as if there is no response from service then coordinator will release the lock 
- Coordinator is handling all of these microservices which is single failure point
- As these dialogue is happening on http which is little bit slow
- And we are holding a lock at the prepare stage so what happen if the lock is held by some resource for longer duration



### Three Phase Commit 
- There is 3 phases in this distributed transaction
  - Can commit  => Coordinator will collect votes from all the participants
  - Pre Commit => in this step coordinator will tell the participant to lock the record which is relevant for this transaction
  - Do Commit => Finalize this step will commit update on respective participent database 


### Notes

- Those two patterns are working well with strong consistency but they are sync in nature 
- Due to sync nature they are taking lots of time 

### SAGA

- this pattern work in async manner 
- in this pattern series of microservice talking with each other using messaging queue 
- customer places an order => orderMS => Queue => customerWalletMS => rollbackOrderQueue => customerWalletRollbackMS
- when order place then orderMS created an event callerd order created and put into that queue
- customer wallet consume those event and detuct amount from customer wallet
- 

