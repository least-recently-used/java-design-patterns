public class NotificationFactory {
    public Notification createNotification(String channel) {
        if (channel == null || channel.isEmpty()) {
            return null;
        }
        switch (channel) {
            case "EMAIL":
                return new EmailNotification();
            case "SMS":
                return new SMSNotification();
            case "PUSH":
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Unknown notification channel: " + channel);
        }
    }
}
