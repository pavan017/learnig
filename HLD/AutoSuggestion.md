

## Usecases 

- For search engine it will auto complete the user query
- Suggest about the new task once you complete a task in perticuller order 



### Functional requirement 

- Response time should be as minimal as possible
- Auto suggestion is relevant or contextual
- The result should be sorted according to uses or popularity



### NFR 






### Solution

- In a normal scenario we can use TRIE data structure for this feature
- And the relevance is determined by the number of time that word is searched by user 

- For Example 
  - Dog => 9
  - Doll => 11
  - Dont => 21
  - Dart => 1
  - Dip => 5
                            D
                    a        i           o
                r            p        g    n  r
            t
  


