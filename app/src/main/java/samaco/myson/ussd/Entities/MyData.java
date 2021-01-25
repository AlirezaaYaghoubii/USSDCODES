package samaco.myson.ussd.Entities;

/**
 * Created by Alireza on 06/11/2015.
 */
public class MyData {

    private  String Id;
    private  String Title;
    private  String smsno;
    private  String smsformat;
    private  String smsdetails;
    private String group_id;


    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getSmsno() {
        return smsno;
    }

    public void setSmsno(String smsno) {
        this.smsno = smsno;
    }

    public String getSmsformat() {
        return smsformat;
    }

    public void setSmsformat(String smsformat) {
        this.smsformat = smsformat;
    }

    public String getSmsdetails() {
        return smsdetails;
    }

    public void setSmsdetails(String smsdetails) {
        this.smsdetails = smsdetails;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }


}
