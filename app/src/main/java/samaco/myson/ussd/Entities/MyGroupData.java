package samaco.myson.ussd.Entities;

/**
 * Created by Alireza on 06/13/2015.
 */
public class MyGroupData {

    private  String Id;
    private  String Main_Id;
    private  String Title;
    private  String smsno;

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

    private  String smsformat;
    private  String smsdetails;


    public String getSmsno() {
        return smsno;
    }

    public void setSmsno(String smsno) {
        this.smsno = smsno;
    }



    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getMain_Id() {
        return Main_Id;
    }

    public void setMain_Id(String main_Id) {
        Main_Id = main_Id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }



}
