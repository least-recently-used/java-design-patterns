package factory;
public class SMSNotification implements Notification {
    String msg;
    String rec;

    public SMSNotification(String rec, String msg){
        this.msg=msg;
        this.rec=rec;
    }
    @Override
    public void notifyUser() {
        System.out.println(rec+ " "+ msg);
    }
}
