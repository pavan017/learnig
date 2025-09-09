## Design key value store like mem cache

=> System is primary using for caching 
=> Higly efficient snd less memory 
=> the region we have the database because we wanted to reduce some load from database
and used to return frequent query to be served by this database 



#### Fuctional requirement

- you are able to put key and value in some space 
- Able to add put data and get data for a given key.




#### Non functional requirement
- Avaialibility 
- it Should be scalable
- Performant 


#### Desiogn

- first things come in our mind is hashmap 
- we know that hashmap is a limited keys which it can store 
- Cache policy comes in the picture which is LRU 
- Any time when cache is full and then we have to evacuate the least item which is used by system 
- We can use the stretegy pattern to impliment this.
- 