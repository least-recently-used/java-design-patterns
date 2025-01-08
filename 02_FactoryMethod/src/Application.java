public class Application {
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();

        // Create an Email notification
        Notification emailNotification = factory.createNotification("EMAIL");
        emailNotification.notifyUser();

        // Create an SMS notification
        Notification smsNotification = factory.createNotification("SMS");
        smsNotification.notifyUser();

        // Create a Push notification
        Notification pushNotification = factory.createNotification("PUSH");
        pushNotification.notifyUser();
    }
}
