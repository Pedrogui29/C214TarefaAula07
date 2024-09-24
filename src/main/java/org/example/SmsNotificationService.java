package org.example;

public class SmsNotificationService extends NotificationService{
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending SMS notification: " + message);
    }
}
