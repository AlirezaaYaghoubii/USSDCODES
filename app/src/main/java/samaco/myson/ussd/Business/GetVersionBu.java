package samaco.myson.ussd.Business;

import android.content.Context;

import samaco.myson.ussd.DataAccess.GetVersionData;

public class GetVersionBu {

    public String GetCurrentVersion(Context context) {

        GetVersionData getVersionData=new GetVersionData();
        return  getVersionData.GetCurrentVersion(context);

    }

}
