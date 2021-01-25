package samaco.myson.ussd;

import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import samaco.myson.ussd.Adapter.GroupListAdapter;
import samaco.myson.ussd.Adapter.InterfaceAdapter;
import samaco.myson.ussd.Business.BuDetailsData;
import samaco.myson.ussd.Business.BuGroupDetailsData;
import samaco.myson.ussd.Common.ClassHelper;
import samaco.myson.ussd.Entities.MyData;
import samaco.myson.ussd.Entities.MyGroupData;
import samaco.myson.ussd.Entities.TO;


public class FragmentGroupList extends Fragment {

    private View myFragmentView;

    String Head_id;
    String Group_Head_id;
    String Head_Title;
    ListView Lst;
    TextView TxvHeader;
    TextView MyText;
    ArrayList<String> DetailsItemList = new ArrayList<String>();
    ArrayList<String> DetailsItemList_No = new ArrayList<String>();
    ArrayList<String> ID_List = new ArrayList<String>();
    ArrayList<MyGroupData> HeadTable = new ArrayList<MyGroupData>();
    ArrayList<String> Group_ID_List=new ArrayList<String>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myFragmentView = inflater.inflate(R.layout.fragmentgrouplist, container, false);

        TxvHeader=(TextView) myFragmentView.findViewById(R.id.TxvHeader);
        Lst=(ListView)myFragmentView.findViewById(R.id.LstVwDetails);

        Group_Head_id= TO.get_Group_Head_id();
        Head_Title= TO.get_Group_Head_Title();


        //List_Fill();

        BuGroupDetailsData buGroupDetailsData =new BuGroupDetailsData();
        HeadTable=buGroupDetailsData.SelectGroupDetails(myFragmentView.getContext(), Group_Head_id);

        for(MyGroupData object: HeadTable){

            DetailsItemList.add(object.getTitle());
            ID_List.add(object.getId());
            Group_ID_List.add(object.getMain_Id());
        }



        GroupListAdapter adapter=new GroupListAdapter(myFragmentView.getContext(),DetailsItemList,Group_ID_List);
        Lst.setAdapter(adapter);

        Typeface TextFont = Typeface.createFromAsset(myFragmentView.getContext().getAssets(), "fonts/BYekan.ttf");



        TxvHeader.setTypeface(TextFont,Typeface.BOLD);

        TxvHeader.setText(Head_Title);

        Lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ClassHelper.setPreviousPage("FragmentGroupList");
                ClassHelper.setGroupPreviousPage("FragmentGroupList");

                TO.set_Head_id(Group_ID_List.get(position));
                TO.set_Head_Title(DetailsItemList.get(position));

                Fragment detail = new FragmentInterfacePage();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();

            }
        });


        return myFragmentView;
    }

    private void List_Fill() {

        if (Group_Head_id.equals("1")) {

            DetailsItemList.add("کدهای دستوری همراه اول");
            ID_List.add("1");

            DetailsItemList.add("اینترنت همراه اول (نوترینو)");
            ID_List.add("21");

        }//if (Group_Head_id.equals("1"))

        else if (Group_Head_id.equals("2")) {

            DetailsItemList.add("کدهای دستوری ایرانسل");
            ID_List.add("2");

            DetailsItemList.add("اینترنت ایرانسل");
            ID_List.add("22");

            DetailsItemList.add("بسته های ترکیبی ایرانسل");
            ID_List.add("23");

        }
        else if (Group_Head_id.equals("3")) {

            DetailsItemList.add("کدهای دستوری رایتل");
            ID_List.add("3");

        }

        else if (Group_Head_id.equals("4")) {

            DetailsItemList.add("شارژ گوشی موبایل");
            ID_List.add("201");

            DetailsItemList.add("پرداخت قبوض");
            ID_List.add("202");


            DetailsItemList.add("خیریه");
            ID_List.add("203");

            DetailsItemList.add("بسته اینترنت");
            ID_List.add("204");

            DetailsItemList.add("خرید");
            ID_List.add("205");

            DetailsItemList.add("متفرقه");
            ID_List.add("9");

        }

    }
}