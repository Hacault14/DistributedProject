# Distributed Project
Welcome to the Decentralized Blog Application developed by Group 1, consisting of Banujan Sutheswaran, Mithusan Arulampalam, Tal Marianovski, Nathan Hacault, and Micheal Barrett.


### Key Objectives
- **Decentralized Content Creation**: Our application empowers users to create blogs and publish posts without the need for a centralized authority.
- **User Privacy and Control**: We prioritize user control over their content, ensuring that each user's data remains private and accessible only to authorized individuals.
- **Engagement and Interaction**: Foster a thriving community by facilitating interaction through comments and discussions on blog posts.


## Table of Contents
- [Installation](#installation)
- [Usage](#usage)
- [Features](#features)


## Installation
Before proceeding with the installation please ensure that you have at least Java 11 on your machine (if not using docker).  
To get started with the app, follow these steps:

Open the terminal and use the git clone command to download the remote GitHub repository to your computer:
```
git clone https://github.com/Hacault14/DistributedProject.git
```
It will create a new folder with the same name as the GitHub repository "DistributedProject". All the project files and git data will be cloned into it. After cloning complete the change directories into that new folder:
```
cd DistributedProject
```

## Usage
### Here's how you can run the project via an IDE or Terminal:
To launch the application run this command (uses maven wrapper):
```
./mvnw clean spring-boot:run
(windows) mvnw.cmd clean spring-boot:run
```
Or using your installed maven version:
```
mvn clean spring-boot:run
```  
By default, the application is listening on port: 8080, which you can reach URL http://localhost:8080. You can change this in the application.properties file.
### Here's how you can run the project via a Jar file:
To create the jar file use this command (uses maven wrapper):
```
./mvnw clean package
(windows) mvnw.cmd clean package
```
Or using your installed maven version:
```
mvn clean package
```  
This should create a Jar file in the target folder labeled "spring-boot-blog-app-0.0.1-SNAPSHOT.jar", or use the provided [file](/target/spring-boot-blog-app-0.0.1-SNAPSHOT.jar).

Then in the terminal run the following command in the folder where the jar is contained, and the application should run:
```
java -jar spring-boot-blog-app-0.0.1-SNAPSHOT.jar
```
To access the application use the following URL: http://localhost:8080. You can change this in the application.properties file.

### Here's how you can run the project via Docker:
Use the same process as above to generate a Jar file or use the provided [file](/target/spring-boot-blog-app-0.0.1-SNAPSHOT.jar).
Using the included docker file, run the following command:  
```
docker build -f Dockerfile -t blogApp .
```
Feel free to change the target name or use our own docker file, the process should be similar. 
After the container is built, run the docker container using the following command :
```
docker run -p 8080:8080 -t --name blogApp blogApp
```
To access the application use the following URL: http://localhost:8080. You can change this in the application.properties file, you would then need to change it in the Dockerfile as well as in the above command.

### To not use local host and instead your your IP (access application over the internet).
To use the application over the internet bar any port forwarding issues, it's quite simple.
In the application.properties file, add the following command, replacing <your_ip> with your device IP:
```
server.address=<your_ip>
```

## Features

### Decentralized Blogging
The application offers a decentralized platform for content creation and sharing. Users can create their blogs, publish posts, and share them within the network. Each user has control over their content without a centralized authority governing the publishing process.

### User Authentication
Users can sign up for accounts and log in securely. Authentication mechanisms ensure that each user's data remains private and accessible only to authorized individuals.

### Content Management
- **Create and Edit Posts**: Users can create new blog posts, edit existing ones, and customize their content with rich text formatting.
- **Attach Photos to Posts**: Users can attach photos to posts to enhance their posts
- **Delete Posts**: Capability to remove or archive posts as needed.

### Commenting and Interaction
Enabling a vibrant community, users can engage with blog posts through comments. This fosters interaction and discussion among users.


## Views
### Register
![register](https://github.com/Hacault14/DistributedProject/assets/115104826/8e33e5a0-401c-46b9-92dc-91f14924d646)

### Login
![login](https://github.com/Hacault14/DistributedProject/assets/115104826/3a02c7f8-8aad-4953-9899-ad47cc13a5d7)


### Homepage
![homePage](https://github.com/Hacault14/DistributedProject/assets/115104826/549ac1a8-2a00-4391-9f53-e67a2ea0cccc)

### New Post
![newPost](https://github.com/Hacault14/DistributedProject/assets/115104826/bf3513c4-3cfe-472a-a442-cd689a648281)

### View Post
![viewPost](https://github.com/Hacault14/DistributedProject/assets/115104826/0a0f0efb-e80d-4dd2-8dab-13d058feb3e5)

### Comment on Post
![comment](https://github.com/Hacault14/DistributedProject/assets/115104826/75c49554-e65f-49fa-9592-d857c38c8d63)

### Edit Post
![editPost](https://github.com/Hacault14/DistributedProject/assets/115104826/b805a29a-81ab-412a-b015-8ae6d8072d92)
