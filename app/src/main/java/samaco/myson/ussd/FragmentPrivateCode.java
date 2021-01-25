package samaco.myson.ussd;

import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import samaco.myson.ussd.Adapter.InterfaceAdapter;
import samaco.myson.ussd.Business.BuDetailsData;
import samaco.myson.ussd.Common.ClassHelper;
import samaco.myson.ussd.Entities.MyData;
import samaco.myson.ussd.Entities.TO;


public class FragmentPrivateCode extends Fragment {

    private View myFragmentView;
    String Head_id;
    ListView Lst;
    TextView TxvHeader;
    TextView MyText;
    ArrayList<String> DetailsItemList=new ArrayList<String>();
    ArrayList<String> DetailsItemList_No=new ArrayList<String>();
    ArrayList<String> ID_List=new ArrayList<String>();
    ArrayList<MyData> HeadTable=new ArrayList<MyData>();

    Button BtnNew;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myFragmentView = inflater.inflate(R.layout.fragmentprivatecode, container, false);

        TxvHeader=(TextView) myFragmentView.findViewById(R.id.TxvHeader);
        Lst=(ListView)myFragmentView.findViewById(R.id.LstVwDetails);

        BtnNew=(Button)myFragmentView.findViewById(R.id.BtnNew);

        Head_id= "5000";

        BuDetailsData buDetailsData=new BuDetailsData();
        HeadTable=buDetailsData.SelectDetails(myFragmentView.getContext(),Head_id);

        for(MyData object: HeadTable){

            DetailsItemList.add(object.getTitle());
            DetailsItemList_No.add(object.getSmsno());
            ID_List.add(object.getGroup_id());
        }

        InterfaceAdapter adapter=new InterfaceAdapter(myFragmentView.getContext(),DetailsItemList,DetailsItemList_No,ID_List);
        Lst.setAdapter(adapter);

        Typeface TextFont = Typeface.createFromAsset(myFragmentView.getContext().getAssets(), "fonts/BYekan.ttf");


        TxvHeader.setText("کدهای شخصی");

        TxvHeader.setTypeface(TextFont,Typeface.BOLD);
        BtnNew.setTypeface(TextFont);

        Lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ClassHelper.setPreviousPage("FragmentInterfacePage");

                TO.set_Title(HeadTable.get(position).getTitle().toString());
                TO.set_Smsno(HeadTable.get(position).getSmsno().toString());
                TO.set_Smsformat(HeadTable.get(position).getSmsformat().toString());
                TO.set_Smsdetails(HeadTable.get(position).getSmsdetails().toString());
                TO.set_Id(HeadTable.get(position).getId().toString());
                TO.set_Head_id(Head_id);

                Fragment detail = new FragmentFinalShow();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();

            }
        });


        BtnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClassHelper.setEditStatus("Insert");

                Fragment detail = new FragmentCodeEdit();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();

            }
        });

        return myFragmentView;
    }
}
