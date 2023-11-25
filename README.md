# Distributed Project

## How to set up the application

Open terminal and use git clone command to download the remote GitHub repository to your computer:
```
git clone https://github.com/skarware/spring-boot-blog-app.git
```
It will create a new folder with same name as GitHub repository "spring-boot-blog-app". All the project files and git data will be cloned into it. After cloning complete change directories into that new folder:
```
cd spring-boot-blog-app
```

## How to use

To launch the application run this command (uses maven wrapper):
```
$ ./mvnw clean spring-boot:run
```
Or using your installed maven version:
```
$ mvn clean spring-boot:run
```
<b>For interacting with application one can use <i>a browser</i></b>.
By default, application uses Tomcat which listening on port: 8080,
means you can reach it if run on a local machine by hitting URL http://localhost:8080.
