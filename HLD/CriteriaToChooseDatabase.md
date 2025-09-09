## Criteria to Choose database (https://www.youtube.com/watch?v=cODCpXtPHbQ)


### Cache 
- key value store 
- redis 
- mem cache 

### Blob storage 
- Suppose you are going to create amazon like where you are having various product 
- Sellers are uploading the images of that project 
- Suppose netflix where we are storing movies and other things 
- We are usually not going to query on these data 
- S3 + CDN 

### Text searching 
- when you have a use case of searching item on amazon like website 
- Elastic search
- Solar 
- Above two are implementation of apache lucine 
- These are not providing guirantee of data persistent there might be a possiblity of data loss
- you should not consider these as a primary data source 

### Metrix 
- If you want to store matrix populated by your application 
- Time series database is the best way to store matrix 
- You never do random update you always do sequence update in append only manner
- Bulk read query with time range 
- It is optimized for these kind of read and write use case 
- Influx db 


### Analytics
- datawere house which is large database where you dump all the data and provide various query to generate lots of report 
- these db should not be used for transactional system 
- hadoop

### SQL vs NOSQL 
- structure of the data 
    - If you have structured information
    - Which is not going to update very frequently
- ACID (Atomicity, Consistency, Isolation, Durability) 
  - if transaction is there in your use case then use SQL 

- mysql, postgrace, 


### NOSQL

- If you don't have structure data 
- For example catalog system 
  - like milk {quantity, expirydate}
  - like refrigirator{size, brand}
- when we have to store different stuructured data and query is also in different rangeas 
  - Document db 
  - mongodb, couchdb


- if you have ever increasing data and you have to execute certain kind of query 
  - for exapmle user driver continiusly sharing the location 
  - most probable query is find all the location of driver whose driver location is driverid
  - columnar Db
    - casandra
    - hbase





### Example 
  - Order Management System 
    - In this case you required acid property as transaction is involved here 
    - But the order is ever increasing in nature so which falls under colum db category 
    - In this case we are going to use combination of these 2 databse 
    - Like until order is not delevard we keep that order in sql and once it deliver then we dump this on column db 




    

