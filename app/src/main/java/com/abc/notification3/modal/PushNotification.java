package com.abc.notification3.modal;

public class PushNotification {
    private  notificationdata data;
    private  String to;

    public PushNotification(notificationdata data, String to){
        this.data = data;
        this.to = to;

    }

    public notificationdata getData() {
        return data;
    }

    public void setData(notificationdata data) {
        this.data = data;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
