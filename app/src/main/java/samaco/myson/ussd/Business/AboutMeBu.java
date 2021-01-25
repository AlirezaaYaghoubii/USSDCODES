
package samaco.myson.ussd.Business;

import android.content.Context;

import java.util.ArrayList;

import samaco.myson.ussd.DataAccess.AboutMeData;
import samaco.myson.ussd.Entities.MyGroupData;

/**
 * Created by Alireza on 06/06/2015.
 */
public class AboutMeBu {

    public ArrayList<MyGroupData> SelectDetails(Context context) {

        AboutMeData aboutMeData=new AboutMeData();
        return aboutMeData.SelectData(context);

    }
}

