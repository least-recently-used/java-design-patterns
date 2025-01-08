import abstractFactory.EmailNotificationFactory;
import abstractFactory.NotificationFactory;
import factory.Notification;

public class Application {
    public static void main(String[] args) {
        NotificationFactory factory = new EmailNotificationFactory();

        // Create an Email notification
        Notification notification= factory.createNotification("EMAIL", "email msg is here" );
        notification.notify();

        // Create an Email notification
        Notification notification1= factory.createNotification("Phone", "phone msg is here" );
        notification1.notify();

    }
}
