## Difference 
- Stateless server does not keep information on the state of its client
    - A typical example of od stateless application is a web application which serves static content.
    - Each request is independent of each other.
    - maintain soft state on behalf of the client for a limited time
    -
- On the other hand stateful server maintain persistent information about its client
    - For example a web application that require user authentication.
      When a user logged-in, the server restore the information about the users session such as the user id
      in its memory or database the server can then use this information to maintain user session state and
      provide personalise content
    - The server may also store other user specific data such as shopping cart item or language preferences. 



### Reference Document
- https://medium.com/@cfqbcgwkg/stateless-vs-stateful-servers-with-examples-6e37223c028f#:~:text=A%20stateless%20server%20does%20not,of%20information%20by%20the%20server.
