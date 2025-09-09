## Database Index (https://www.youtube.com/watch?v=3G293is403I)

- database is nothing but collection of record 
- all of these document need to be stored 
- How data store in disk is in a block 
- when disk IO is triggerd it reads the entire block on the disk where data is situated 
- Suppose your one record is 200Bytes and your block size is 600B 
- so it will find that block load in the memory and read the exact object from that block



### How index work 

- Suppose we are doing a query  on table without index
  - Suppose there is user table and i wanted to fetch user which have age is greater then 23 
    - It will iterate table row by row 
    - read the block in memory
    - check age>23
    - if yes add the record to output buffer 
    - if no discard
    - return the output buffer 
  - Here we need to lookup entire table which require lots of time to return the result for this query

- Index are very small referencial table 
- Suppose i wanted to add index on age column 
  - this reference table will have two columns 
    - {age, id}
    - this table is sorted on index key which is age in this example 
- lets do the same query on the same table with index 
  - iterate index 
  - check age=23 entries 
  - if yes put ids in buffer 
  - if no discard 
  - for all the relevant id in the buffer 
    - read the records from the disk 
    - add to an output buffer
  - return the output buffer
- Index is stored in B+ tree which is optimised to search index
- 