import org.example.EmailNotificationService;
import org.example.NotificationManager;
import org.example.NotificationService;
import org.example.SmsNotificationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class NotificationManagerTest {


    private NotificationService mockEmailService;
    private NotificationService mockSmsService;
    private NotificationManager manager;

    @BeforeEach
    void setup() {
        mockEmailService = mock(EmailNotificationService.class);
        mockSmsService = mock(SmsNotificationService.class);
        // Default to email service for these tests
        manager = new NotificationManager(mockEmailService);
    }

    @Test
    void testSendEmailNotification() {
        manager.notify("Email notification");
        verify(mockEmailService).sendNotification("Email notification");
    }

    @Test
    void testSendSmsNotification() {
        // Injecting the SMS service
        manager = new NotificationManager(mockSmsService);
        manager.notify("SMS notification");
        verify(mockSmsService).sendNotification("SMS notification");
    }

    @Test
    void testNoNotificationSent() {

        verify(mockEmailService, never()).sendNotification(anyString());
    }

    @Test
    void testExceptionInService() {
        // Simulating an exception thrown by the service
        doThrow(new RuntimeException("Service failure")).when(mockEmailService).sendNotification(anyString());

        try {
            manager.notify("Fail notification");
        } catch (Exception e) {
            // Test should catch the exception
            assert(e.getMessage().contains("Service failure"));
        }

        // Verify that the notification attempt was made
        verify(mockEmailService).sendNotification("Fail notification");
    }

    @Test
    void testMultipleNotifications() {
        // Testing multiple notifications sent
        manager.notify("Notification 1");
        manager.notify("Notification 2");
        verify(mockEmailService).sendNotification("Notification 1");
        verify(mockEmailService).sendNotification("Notification 2");
    }

    @Test
    void testEmptyNotificationMessage() {
        // teste de notificacao com mensagem vazia
        manager.notify("");
        verify(mockEmailService).sendNotification("");
    }

    @Test
    void testMultipleSmsNotifications() {
        // teste de varias notificacoes de sms
        manager = new NotificationManager(mockSmsService);
        manager.notify("SMS 1");
        manager.notify("SMS 2");
        verify(mockSmsService).sendNotification("SMS 1");
        verify(mockSmsService).sendNotification("SMS 2");
    }

    @Test
    void testServiceSelection() {
        // verifica se o notify() usa o service corretamente
        manager.notify("Checking service selection");
        verify(mockEmailService).sendNotification("Checking service selection");
        
        manager = new NotificationManager(mockSmsService);
        manager.notify("SMS Service Selected");
        verify(mockSmsService).sendNotification("SMS Service Selected");
    }

    @Test
    void testDuplicateNotification() {
        // teste para mensagens duplicadas
        manager.notify("Duplicate notification");
        manager.notify("Duplicate notification");
        verify(mockEmailService, times(2)).sendNotification("Duplicate notification");
    }

    @Test
    void testNotificationOrder() {
        // teste que verifica a ordem das notificacoes
        InOrder inOrder = inOrder(mockEmailService);
        manager.notify("First notification");
        manager.notify("Second notification");
        inOrder.verify(mockEmailService).sendNotification("First notification");
        inOrder.verify(mockEmailService).sendNotification("Second notification");
    }

    @Test
    void testNotificationWithSpecialCharacters() {
        // teste para notificacao com caracteres especiais
        String specialMessage = "Notificação com caracteres especiais: ç,ã,ê,û,!,ф,в,и,д,ж";
        manager.notify(specialMessage);
        verify(mockEmailService).sendNotification(specialMessage);
    }

    @Test
    void testNotificationWithLongMessage() {
        // teste para notificacao com mensagens muitos grandes
        String longMessage = "a".repeat(5000); // Mensagem longa de 5000 caracteres
        manager.notify(longMessage);
        verify(mockEmailService).sendNotification(longMessage);
    }

}