##Docker 

- when you have multiple env then it would be really deficult to replicate
- To solve this problem using docker container 
- we have to define all dependency which is required to run an application 
- these are very light waiting and each container have its own operating system
- when we are biuilding any real world application then we are mostly building custom image
  for according to your requirement. For example, for an application you required ubuntu,
  javan, mysql etc then you have to crate and images with these dependency and publish this
  image for future.


###Container 

- if you run 'docker run -it ubantu' then it try to fetch the images from local
  if it is already downloaed if not it will go to "hub.docker.com" and download
  images and run the container.
- hub.docker.com have publicaly available images. its like github for images 
- the container is isolated form the machine where it is running
- Container is just like empty machine which can run images using container resource.
- container are isolated and not share the data in between


###Images
- images are like operating system and container is the machine/env where these
  images can run 

  

### How container work internally 
- an image is running inside container and lessing incoming request to some port, and as we know
  that container are isolated so any request from browser will show not found until 
  we expose port number outside that container. We have to use following command for that
  "docker run -it -p 1025:1025 <images>"  which means that first port from machine will get expose to
  second port of the container.



### How to containerise nodejs application  
- we have to create "Dockerfile" under the application directory
- Docker file have all the configurattion which is required to run the application 




####Dockerfile Example
    From Ubantu
    Run apt-get update
    Run apt-get install -y curl 
    Run curl -sL https://deb.nodesource.com/setup_18.x | bash -
    Run apt-get upgrade -y 
    Run apt-get install -y nodejs
    Copy package.json package.json
    Copy package-lock.json package-lock.json
    Copy main.js main.js
    Run npm install 
    ENTRYPOINT ["node", "main.js"]


###Docker compose 
- when we are doing actual development then you might require to run multiple container
  for example you have to run postgres, redis and each have their port and configuration
- Docker compose is way to create/destroy multiple container.
- create docker-compose.yaml file and add configuration in this file


####docker-compose.yaml Example
    version '3.8'
    services:
        postgres_container:
            images: postgres # hub.docker.com
            ports: 
                -'5432:5432'
            enviournment:
                name=value
        redis _container:
            images: redis
            ports:
                - '6379:6379'
    

### Docker Networking 

- How docker container connected with internet. Docker stablished a bridge between host
  machine and container and all the container connected to internet using this bridge.
- The by default network is bridge
- we have other option for docker network on of them is host.
- The host option is not required exposing port. the application port is automatically
available in host machine
- if you choose none as docker network option then this container not having internet access
  at all
- You can also create custom docker network   

###Volume Mounting
- When you distroy container then it distroy all the file(memory) which you have
  created at the time of container
- To prevent this memory loss we have to mount docker volumes, which work as permanent
  volume for container
  

### Efficient caching
- Docker cached a command according to their appearence. and if there is any change it 
    will rerun all the command present after that command in docker file
- That's why the recommendation is to put all the commands at top which is very rarely
  change
  
###Docker multistage build 
- Suppose you required a compiler to just compile the code and create the build
and it not required to run the code. and suppose this is taking around 2.5 gb of space
then it increase the container size because of that compiler which is not required 
during running stage
- To get rid of this issue we can create multiple stage like build and running and defined
  dependency accordingly.
  



### Basic Commands

- docker run -it ubantu 
- docker exec -it <Image_name> bash
- docker container ls
- docker run -it -p 1025:1025 <images> => expose port from conatainer to runnning machine
- docker run -it -e key:value <images>  => pass env variable to docker container
- docker build -t <image_name> <path>=> build an images according to dockerfile command 
- docker compose up  => run all the container defined in docker-compose file
- docker network ls => it provide list of all kind of network available.
- docker run -it --network=host <image_name> => you can provide network mode

- docker network create -d bridge <network_name>
    - The advantage of creating own network is that you can create container under own 
    network and these container communicate with each other through container name.
- docker run -it -v <folder_path>:<container_path> <container_name>
    - here we are mounting host volume to container
    - suppose container distroyed then your data is still present in mounted volume
      at your host
    
###Reference
- https://www.youtube.com/watch?v=31k6AtW-b3Y




