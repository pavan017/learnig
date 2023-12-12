#SOLID Principles 

##Why it is really important 
- it encourage us to design more maintanable, understandable and flexible software
- It's very hard to maintain an application when they grow in size after a particular limit.
  we can reduce their complexity and save ourselves a lot of headaches further down the road.
  

## Single responsibility Principle 
    One class should be having only one responsibility. It should only have one reason to change
    A class with only having one responsibility will have fewer test case 
    Less functionality in a single class will have fewer dependency 
    its very easy to organise a class which is having single responsibility
## Open/Closes
    A class should be open for extension but close for modification. In doing so, we stop ourselve from modifying 
    exisiting code and cousing potential new bugs 
    

## Liskov Substitution
    Subtypes must be substitutable for their base types.
    if class A is a subtype of class B, we should be able to replace B with A without disrupting the behavior of our program.
    By Liskov Substitution principle we make sure a subtype is suitable for supertype


##Interface Segregation
    Larger interface should be split into smaller one,By doing so we can insure that implimenting classes only need to be concern about the methods that are of interest to them

## Dependency Inversion
    The principle of dependency inversion refers to the decoupling of software modules. This way, instead of high-level modules depending on low-level modules, both will depend on abstractions.

## Reference Document
- https://www.baeldung.com/solid-principles
- https://www.baeldung.com/java-liskov-substitution-principle
- https://leetcode.com/discuss/interview-question/object-oriented-design/4035362/Quick-revision-of-LSP-Interface-Segregation-and-DIP-(SOLID)
- https://leetcode.com/discuss/interview-question/object-oriented-design/4035264/Quick-revision-of-SRP-and-OCP-Principles-(SOLID)

