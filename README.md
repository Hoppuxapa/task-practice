## HA
An application that helps in recruitment.

#### Technologies
+ Java 11 OpenJDK
+ Spring Boot 2.1.7.RELEASE
+ Gradle 5.x
+ MySQL 5.x

#### Installation
1\. Install MySQL DB;

2\. Clone project:
```
git clone https://github.com/Andersen-soft/ha_application.git
```
#### Build
You can build the application with by running:
```
./gradlew clean build
```

#### Run
You can launch the application with by running:
```
./gradlew bootRun
java -jar crm-application.jar --spring.profiles.active={profile} --server.port={port}  --spring.datasource.username={login} --spring.datasource
.password={password} --secret.key={secret_key}
```

##### Parameters
The parameters that you must specify to run the application:
+ spring.profiles.active - active profile of the application. Use a local profile for the development;
+ server.port - server port;
+ spring.datasource.username - username for connection to DB;
+ spring.datasource.password - password for connection to DB;
+ secret.key - the key used for signing and validation Client JWT tokens. It is necessary to generate a unique key for each stand with 2048 size and 
 HS512 algorithm.#   p r a c t i c e  
 #   p r a c t i c e  
 