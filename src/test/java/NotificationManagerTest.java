import org.example.EmailNotificationService;
import org.example.NotificationManager;
import org.example.NotificationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

class NotificationManagerTest {

    @Test
    void testSendNotification() {
        // Mocking the service
        NotificationService mockService = mock(EmailNotificationService.class);

        // Injecting the dependency
        NotificationManager manager = new NotificationManager(mockService);

        // Call the method
        manager.notify("Hello!");

        // Verify the interaction
        verify(mockService).sendNotification("Hello!");
    }
}