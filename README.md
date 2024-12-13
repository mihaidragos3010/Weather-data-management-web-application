Student: Mihai Dragos-Andrei

Group: 342C5


# Theme 2 SCD

---

# Introduction

For this project, I used Spring Boot as the backend technology. For the database, I chose MS SQL (Microsoft SQL Server).


### **Server Implementation**

---
In this project, I implemented a backend server using Spring Boot technologies. The application architecture is based on the MVC pattern.  
I defined @Controller classes to manage the application's endpoints. For processing, I used @Service classes. Communication with the database is handled by @Repository classes.
The "*Dto" structures are used to define external structures, the ones used in communication with the client. Due to project constraints, I chose to return @Entity objects in some cases.
I implemented a global exception handler to catch exceptions throughout the server and return valid, user-friendly responses to the client.

## **Database Implementation**

---
For the database, I used MS SQL technologies. The database tables are created by the Spring server upon the first connection. The @Entity classes define the structure of the tables, constraints, and relationships between them. The password for the "sa" user was set during Docker container initialization.


  
### **Docker Container Definition**

---
#### For this project, I used a docker-compose file to define the containers. 

* It initializes a database using a pre-built image from DockerHub. 


* Data persistence in database is ensured by defining a volume managed by the Docker agent. 


* To initialize the Spring server, I used a Dockerfile based on a Maven image with Java 17, to which I added the server 
source code and the `pom.xml` file for dependency management. 


* For the server, a series of environment variables have been defined, which are then used for its configuration in 
the `application.yml` file. Each environment variable is followed by a default value. The default values were used for 
running the server locally and are only used if the environment variables are not defined.


* The environment variables for the database are used to define the admin username and password.


* The DNS technology provided by Docker is used in the server. When running a container, a variable "DATABASE_IP" is 
defined, which holds the name of the database service. For local execution, where Docker's DNS technology cannot be 
used, "localhost" is used instead.


* Both containers were added to a network named "global."

# Execution

#### To initialize the server and database containers:

    docker-compose up --build

#### To delete containers 
    
    docker-compose down --volumes
