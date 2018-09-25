package com.suirtech.automation.testservice;

import com.github.javafaker.Faker;
import com.suirtech.automation.testservice.model.User;
import com.suirtech.automation.testservice.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TestServiceApplication {

    private static final Logger log = LoggerFactory.getLogger(TestServiceApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(TestServiceApplication.class, args);
    }


    @Bean
    public CommandLineRunner setup(UserRepository repository) {
        return (String... args) -> {
            repository.save(new User("testUser1", "password", "Sean", "Conery"));
            repository.save(new User("testUser2", "password", "Sean", "O Brien"));
            repository.save(new User("testUser3", "password", "Conor", "Murray"));
            repository.save(new User("testUser4", "password", "Steve", "Jobs"));
            repository.save(new User("testUser5", "password1", "Bad", "User"));

            Faker faker = new Faker();

            for(int i = 0; i < 1000; i++){
                repository.save(new User(faker.name().username(), faker.internet().password(), faker.name().firstName(), faker.name().lastName()));

            }

//            log.info("Customers found with findAll():");
//            log.info("-------------------------------");
//            for (User user : repository.findAll()) {
//                log.info(user.toString());
//            }
            log.info("");
            User u = repository.findByUserName("testUser4");

            log.info("user found with findByUserName(testUser4):");
            log.info("--------------------------------");
            log.info(u.toString());
            log.info("");

            log.info("User found with findByFirstName('sean'):");
            log.info("--------------------------------------------");
            repository.findByFirstName("sean").forEach(user -> {
                log.info(user.toString());
            });
            for (User user : repository.findByFirstName("Sean")) {
                log.info(user.toString());
            }
            log.info("");
        };
    }
}