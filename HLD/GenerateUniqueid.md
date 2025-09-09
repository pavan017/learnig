## What are the way to generate unique_id in a distributed env.

UUID 
MongoDb's ObjectId
=> generated id are 12bytes long which is taking lots of space 
=> Some uuid is completely random and have no natural sort


Twitter snowflake 
=> it create unique id in just 64 bits which is half of the space taken by UUID
=> it uses time as first component and reamin sortable 
=> Distributed system that can survive node dying 


=> it include additional moving part like zookeeper and snowflake server 



###Reference 
https://instagram-engineering.com/sharding-ids-at-instagram-1cf5a71e5a5c



Take 2 
===========


Use Cases 
============
- social media post have a unoque id 
- video on youtube 
- song on spotify 
- order id for e-commerce 
- comments on social media 
- Cash transaction for banking


#### Questions
- What should be the length of unique id
- Whether these id need to be generated in sorted order 
- 



#### Functional Requirement 
- System is able to generate unique id 
- System is able to generate unique id in a really fast manner 
- We are going to take example of generating post_id for post on instagram.
- You are able to identify a post through this unique id 
- 
=> 

#### Non Functional requirement 
- 800m user having instagram 
- 10% active user 80m 
- 1/1000 read/write ratio
- 80K write request per day 
- 80 request/sec
- Around 1000 unique id per second 




#### Naive Approach 1
- we can have a table in mysql and have a primarykey autoincrement which generate unique primary key id 
- but this is good for single server application 
- Suppose we have 3 server which is going to generate unique id then it will create a duplicate id 
- We can change the starting point to generate the unique id and the next id is previous + no of server
  - for example
    - s1 start with 1 => 4 => 7
    - s2 start with 2 => 5
    - s3 start with 3 
- That how we can generate a unique id but the problem here once we add and remove a server 
- At that movement we have to sync these server once again which required downtime 


#### Naive Approach 2
- As a practical scenario we are using uuid for unique id generation 
- UUID is 128 bit so you have lots combination possible to generate unique id 
- Its simple way to generate unique id 
- No coordination needed to b/w servers 
- Easy to scale and add/remove new node 
- But it have soe drawbacks 
  - Id generated are 128 bit long which required some space to store these id 
  - UUID are alphanumeric 
  - Suppose you wanted your id is only numeric then it is not possible in this 
  - if you want id sortable then this not possible

#### Approach 3 (Ticket server method)
-




#### Twitter snowflake

- here we divide our unique id in 4 parts 
  - timestamp - 41 bit 
  - datacenterId - 5 bit
  - machineId - 5 bit 
  - sequence number => 12 bit 

- It will give you unique id without any collision 
- It is fast 
- It will give you sortable ids 
- 

High level Component






