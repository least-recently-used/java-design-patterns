package factory;
public class EmailNotification implements Notification {
    String rec;
    String msg;
    public EmailNotification(String rec, String msg){
        this.rec=rec;
        this.msg=msg;
    }
    
    @Override
    public void notifyUser() {
        System.out.println(rec+ " "+ msg);
    }
}
