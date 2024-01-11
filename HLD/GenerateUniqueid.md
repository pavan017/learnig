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





