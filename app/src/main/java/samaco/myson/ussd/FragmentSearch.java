package samaco.myson.ussd;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import samaco.myson.ussd.Adapter.SearchAdapter;
import samaco.myson.ussd.Business.SearchBu;
import samaco.myson.ussd.Common.ClassHelper;
import samaco.myson.ussd.Entities.MyGroupData;
import samaco.myson.ussd.Entities.TO;


public class FragmentSearch extends Fragment {

    private View myFragmentView;
    ListView Lst;

    ArrayList<String> DetailsItemList=new ArrayList<String>();
    ArrayList<String> DetailsItemList_No=new ArrayList<String>();
    ArrayList<String> ID_List=new ArrayList<String>();
    ArrayList<MyGroupData> HeadTable=new ArrayList<MyGroupData>();

    EditText TxtSearch;
    SearchAdapter adapter;
    SearchBu searchBu;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myFragmentView=inflater.inflate(R.layout.fragmentsearch, container, false);

        Lst=(ListView)myFragmentView.findViewById(R.id.LstVwDetails);
        TxtSearch=(EditText)myFragmentView.findViewById(R.id.TxtSearch);

        searchBu =new SearchBu();
        HeadTable=searchBu.SelectSearchData(myFragmentView.getContext(), "");

        Typeface TextFontYekan = Typeface.createFromAsset(myFragmentView.getContext().getAssets(), "fonts/BYekan.ttf");

        TxtSearch.setTypeface(TextFontYekan);

        if (!ClassHelper.getSearchData().equals(""))
        {
            searchBu =new SearchBu();
            HeadTable=searchBu.SelectSearchData(myFragmentView.getContext().getApplicationContext(), ClassHelper.getSearchData());

            DetailsItemList.clear();
            DetailsItemList_No.clear();
            ID_List.clear();

            for(MyGroupData object: HeadTable){

                DetailsItemList.add(object.getTitle());
                DetailsItemList_No.add(object.getSmsno());
                ID_List.add(object.getMain_Id());
            }


            adapter = new SearchAdapter(myFragmentView.getContext().getApplicationContext(), DetailsItemList, DetailsItemList_No,ID_List);
            Lst.setAdapter(adapter);

        }//if (!ClassHelper.getSearchData().equals(""))


        for(MyGroupData object: HeadTable){

            DetailsItemList.add(object.getTitle());
            DetailsItemList_No.add(object.getSmsno());
            ID_List.add(object.getMain_Id());
        }

        adapter=new SearchAdapter(myFragmentView.getContext(),DetailsItemList,DetailsItemList_No,ID_List);
        Lst.setAdapter(adapter);

        TxtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                searchBu =new SearchBu();
                HeadTable=searchBu.SelectSearchData(myFragmentView.getContext().getApplicationContext(), TxtSearch.getText().toString());

                DetailsItemList.clear();
                DetailsItemList_No.clear();
                ID_List.clear();

                for(MyGroupData object: HeadTable){

                    DetailsItemList.add(object.getTitle());
                    DetailsItemList_No.add(object.getSmsno());
                    ID_List.add(object.getMain_Id());
                }


                adapter = new SearchAdapter(myFragmentView.getContext().getApplicationContext(), DetailsItemList, DetailsItemList_No,ID_List);
                Lst.setAdapter(adapter);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        Lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                try
                {

                    ClassHelper.setPreviousPage("FragmentSearch");
                    ClassHelper.setSearchData(TxtSearch.getText().toString());

                    TO.set_Title(HeadTable.get(position).getTitle().toString());
                    TO.set_Smsno(HeadTable.get(position).getSmsno().toString());
                    TO.set_Smsformat(HeadTable.get(position).getSmsformat().toString());
                    TO.set_Smsdetails(HeadTable.get(position).getSmsdetails().toString());
                    TO.set_Id(HeadTable.get(position).getId().toString());
                    TO.set_Head_id(HeadTable.get(position).getMain_Id().toString());

                    Fragment detail = new FragmentFinalShow();
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();
                }
                catch (Exception ex)
                {

                }

            }
        });

        return myFragmentView;
    }

}
