## Kubernates 

- Suppose you have created an application and like to host this application
- You required server which is running 24*7 to host this application
- But there is lots of dependency which you have to install on the server to run this application 
- Means you have to install all the dependency to the machine and then run your application on the host machine
- Suppose you created an application which have following dependency 
  - redis version 6 
  - postgrace sql 




## How it works 

- when cloud native comes in picture then Aws and azure is handling the machine part just with some click 
- Suppose you are creating an app in your windows machine and wanted to deploy in cloud native linux machine
- A concept called vertualisation comes into the picture when you create Vm install the OS and code and other dependency 
- These Vm is very heavy as it have whole operating system in this. its not easy to deploy and not easy to scale
- The next step comes in containerisation 



#### Containerisation 
- its a kind of virtualisation but it does not have operating system layer
- We use host machine kernel so its kind of vertualisation but in light weight manner 
- It light weight and can be easily shared and scaled
- In containerisation we are creating an image from a template of our application
- It is guarentee that a image will give same behaviour irrespective of its running on different operating system


#### Container Orchestration 

- Is the process of automating the management of the containerised application which include
  - deployment 
  - scaling 
  - security 
- Its not an easy task and not possible to do this manually 
- Google created an in housse solution which called google borg which doing container orchestration
- 
- 