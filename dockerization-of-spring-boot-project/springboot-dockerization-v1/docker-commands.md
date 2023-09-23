# docker build commands

### build the image
    docker build --build-arg JAR_FILE=./target/springboot-dockerization-v1-1.jar -t jk/springboot-dockerization-v1 .

### check the image
    docker images

    REPOSITORY                              TAG          IMAGE ID       CREATED              SIZE
    jk/springboot-dockerization-v1          latest       9dd57495ff53   About a minute ago   140MB

### run the image, make sure 8080 port is not in use in localhost

     docker run -p 8080:8080 --name springboot-dockerization-v1-instance-1 jk/springboot-dockerization-v1

### access the app on localhost

    http://localhost:8080/springboot-dockerization-v1/rest/api/HELLO
    
    http://localhost:8080/springboot-dockerization-v1/actuator/env

### login to the app container

    docker exec -it springboot-dockerization-v1-instance-1 /bin/sh

### see the container logs

    docker logs springboot-dockerization-v1-instance-1

    docker logs --follow springboot-dockerization-v1-instance-1

#### exit from container
    
    exit

### stop the container

    docker stop springboot-dockerization-v1-instance-1

### remove the container

    docker rm springboot-dockerization-v1-instance-1





    
    

    

    


    