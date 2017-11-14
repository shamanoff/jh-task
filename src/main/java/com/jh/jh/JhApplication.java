package com.jh.jh;

import com.jh.jh.domain.Task;
import com.jh.jh.service.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class JhApplication {

    public static void main(String[] args) {
        SpringApplication.run(JhApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(TaskService taskService) {
        return args -> {
            taskService.save(new Task(1L, "Create APP", LocalDate.now(), true));
            taskService.save(new Task(2L, "Create Spring Boot APP", LocalDate.now().plus(1, ChronoUnit.DAYS), true));
        };
    }
}
