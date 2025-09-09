### Why we need this 
- Suppose i have a cpu with 500gb hard disk in it so i can save only 500 GB.
- If wanted to store more than either we have to buy a more powerfull machine 
- Instead of that we can 
- Suppose there is some unusual event happened then we loss all the data 
- then there is a solution which is nothing but distributed file system 
- HDFS(Hadoop Distributed File System) is one of the distributed file system.
- There is 2 kind of node 
  - Name Node
    - It does not store data 
    - It act like master 
    - It have information about the where the data reside 
    - What is the size of data and how much is filled and how much is empty
    - 
  - Data Node 
    - these node have the actual data
    



### Flow

client => Name Node => [data_node_1, data_node_2, data_node_3]






