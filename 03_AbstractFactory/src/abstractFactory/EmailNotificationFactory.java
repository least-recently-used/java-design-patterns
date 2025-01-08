package abstractFactory;
import factory.*;
public class EmailNotificationFactory implements NotificationFactory {
    @Override
    public Notification createNotification(String recipient, String message) {
        return new EmailNotification(recipient, message);
    }
}