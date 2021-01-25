package samaco.myson.ussd;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import samaco.myson.ussd.Adapter.DetailsAdapter;
import samaco.myson.ussd.Business.AboutMeBu;
import samaco.myson.ussd.Common.ClassHelper;
import samaco.myson.ussd.Entities.MyGroupData;


public class FragmentAboutMe extends Fragment {

    private View myFragmentView;

    TextView TxvHeader;
    TextView TxtVersion;
    TextView Txt2;
    TextView Txt3;
    TextView Txt4;
    TextView Txt5;

    ListView Lst;
    ArrayList<String> DetailsItemList=new ArrayList<String>();
    ArrayList<MyGroupData> HeadTable=new ArrayList<MyGroupData>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myFragmentView = inflater.inflate(R.layout.fragmentaboutme, container, false);

        Lst=(ListView)myFragmentView.findViewById(R.id.LstVwDetails);

        AboutMeBu aboutMeBu =new AboutMeBu();
        HeadTable=aboutMeBu.SelectDetails(myFragmentView.getContext());

        for(MyGroupData object: HeadTable){

            DetailsItemList.add(object.getTitle());
        }

        DetailsAdapter adapter=new DetailsAdapter(myFragmentView.getContext(),DetailsItemList);
        Lst.setAdapter(adapter);


        try {

            Typeface TextFont = Typeface.createFromAsset(myFragmentView.getContext().getAssets(), "fonts/BJadidBd.ttf");
            Typeface TextFontYekan = Typeface.createFromAsset(myFragmentView.getContext().getAssets(), "fonts/BYekan.ttf");

            TxvHeader = (TextView) myFragmentView.findViewById(R.id.TxvHeader);

            TxtVersion = (TextView) myFragmentView.findViewById(R.id.TxtVersion);
            Txt2 = (TextView) myFragmentView.findViewById(R.id.Txt2);
            Txt3 = (TextView) myFragmentView.findViewById(R.id.Txt3);
            Txt4 = (TextView) myFragmentView.findViewById(R.id.Txt4);
            Txt5 = (TextView) myFragmentView.findViewById(R.id.Txt5);

            TxtVersion.setText("نسخه : "+ ClassHelper.getAppVersion());


            TxvHeader.setTypeface(TextFont);

            TxtVersion.setTypeface(TextFontYekan);
            Txt2.setTypeface(TextFontYekan);
            Txt3.setTypeface(TextFontYekan);
            Txt4.setTypeface(TextFontYekan);
            Txt5.setTypeface(TextFontYekan);
        }
        catch (Exception ex)
        {

        }

        Txt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    String shareBody = "";
                    Intent intent = new Intent(Intent.ACTION_SENDTO); // it's not ACTION_SEND
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_SUBJECT, "");
                    intent.putExtra(Intent.EXTRA_TEXT, shareBody);
                    intent.setData(Uri.parse("mailto:a.yaghoubi.samaco@gmail.com")); // or just "mailto:" for blank
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.
                    startActivity(intent);
                }
                catch (Exception ex)
                {

                }
            }
        });


        return  myFragmentView;
    }
}
