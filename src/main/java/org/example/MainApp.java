package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        NotificationManager notificationManager = context.getBean(NotificationManager.class);
        notificationManager.notify("Hello, Dependency Injection with Spring!");
    }
}