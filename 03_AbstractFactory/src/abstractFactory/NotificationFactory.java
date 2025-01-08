package abstractFactory;
import factory.Notification;
import factory.SMSNotification;

public interface NotificationFactory {
    Notification createNotification(String recipient, String message);
}


class SMSNotificationFactory implements NotificationFactory {
    @Override
    public Notification createNotification(String recipient, String message) {
        return new SMSNotification(recipient, message);
    }
}