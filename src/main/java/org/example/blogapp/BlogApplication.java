package org.example.blogapp;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

@SpringBootApplication
public class BlogApplication {

    public static void main(String[] args) { //starting springboot.
        SpringApplication.run(BlogApplication.class, args);
    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server SQLDatabaseServer() throws SQLException { //creating the database server
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");
    }
}
