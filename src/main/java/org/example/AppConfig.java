package org.example;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example")
public class AppConfig {

    // Define a implementação a ser usada
    @Bean
    public NotificationService notificationService() {
        return new EmailNotificationService(); // Ou troque para SmsNotificationService
    }
}
