# Distributed Project
Welcome to the Decentralized Blog Application developed by Group 1, consisting of Banujan Sutheswaran, Mithusan Arulampalam, Tal Marianovski, Nathan Hacault, and Micheal Barrett.


## Overview
This project aims to ...


## Table of Contents
- [Installation](#installation)
- [Usage](#usage)
- [Features](#features)


## Installation
To get started with the app, follow these steps:


Open terminal and use git clone command to download the remote GitHub repository to your computer:
```
git clone https://github.com/Hacault14/DistributedProject.git
```
It will create a new folder with same name as GitHub repository "DistributedProject". All the project files and git data will be cloned into it. After cloning complete change directories into that new folder:
```
cd DistributedProject
```

## Usage
Here's how you can run the project:


To launch the application run this command (uses maven wrapper):
```
./mvnw clean spring-boot:run
```
Or using your installed maven version:
```
mvn clean spring-boot:run
```
<b>For interacting with application one can use <i>a browser</i></b>.
By default, application uses Tomcat which listening on port: 8080,
means you can reach it if run on a local machine by hitting URL http://localhost:8080.


## Features

### Decentralized Blogging
The application offers a decentralized platform for content creation and sharing. Users can create their blogs, publish posts, and share them within the network. Each user has control over their content without a centralized authority governing the publishing process.

### User Authentication
Users can sign up for accounts and log in securely. Authentication mechanisms ensure that each user's data remains private and accessible only to authorized individuals.

### Content Management
- **Create and Edit Posts**: Users can create new blog posts, edit existing ones, and customize their content with rich text formatting.
- **Delete Posts**: Capability to remove or archive posts as needed.

### Commenting and Interaction
Enabling a vibrant community, users can engage with blog posts through comments, reactions, and sharing. This fosters interaction and discussion among users.
