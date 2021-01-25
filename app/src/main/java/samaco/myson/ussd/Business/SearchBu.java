package samaco.myson.ussd.Business;


import android.content.Context;

import java.util.ArrayList;

import samaco.myson.ussd.DataAccess.SearchData;
import samaco.myson.ussd.Entities.MyGroupData;

public class SearchBu {

    public ArrayList<MyGroupData> SelectSearchData(Context context,String Title) {

        SearchData searchData=new SearchData();
        return searchData.SelectSearchData(context,Title);

    }
}
