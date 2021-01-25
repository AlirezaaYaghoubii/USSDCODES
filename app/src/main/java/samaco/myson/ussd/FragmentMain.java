package samaco.myson.ussd;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import samaco.myson.ussd.Common.ClassHelper;
import samaco.myson.ussd.Entities.TO;


public class FragmentMain extends Fragment {

    private View myFragmentView;

    TextView TxvSearch;
    TextView TxvMyFavorite;

    TextView TxvPrivateCode;
    TextView TxvMCI;

    TextView TxvIranCell;
    TextView TxvRitel;

    TextView TxvOrgan;
    TextView TxvBimeh;

    TextView TxvBank;
    TextView TxvCompany;

    TextView TxvAction;
    TextView TxvComment;


    TextView TxvApplist;
    TextView TxvAboutMe;


    LinearLayout LayerSearch;
    LinearLayout LayerAboutMe;
    LinearLayout LayerOrganization;

    LinearLayout LayerAppList;
    LinearLayout LayerAction;
    LinearLayout LayerInsertComment;
    LinearLayout LayerBank;
    LinearLayout LayerCompany;
    LinearLayout LayerBimeh;

    LinearLayout LayerMyFavorite;
    LinearLayout LayerPrivateCode;
    LinearLayout LayerMCI;
    LinearLayout LayerIranCell;
    LinearLayout LayerRitel;



    Typeface TextFont;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        myFragmentView=inflater.inflate(R.layout.fragmentmain, container, false);

        ClassHelper.setPreviousPage("");

        TextFont=Typeface.createFromAsset(myFragmentView.getContext().getAssets(),"fonts/BYekan.ttf");

        TxvSearch=(TextView) myFragmentView.findViewById(R.id.TxvSearch);
        TxvMyFavorite=(TextView) myFragmentView.findViewById(R.id.TxvMyFavorite);

        TxvPrivateCode=(TextView) myFragmentView.findViewById(R.id.TxvPrivateCode);
        TxvMCI=(TextView) myFragmentView.findViewById(R.id.TxvMCI);

        TxvIranCell=(TextView) myFragmentView.findViewById(R.id.TxvIranCell);
        TxvRitel=(TextView) myFragmentView.findViewById(R.id.TxvRitel);


        TxvOrgan=(TextView) myFragmentView.findViewById(R.id.TxvOrgan);
        TxvBimeh=(TextView) myFragmentView.findViewById(R.id.TxvBimeh);


        TxvBank=(TextView) myFragmentView.findViewById(R.id.TxvBank);
        TxvCompany=(TextView) myFragmentView.findViewById(R.id.TxvCompany);

        TxvAction=(TextView) myFragmentView.findViewById(R.id.TxvAction);
        TxvComment=(TextView) myFragmentView.findViewById(R.id.TxvComment);

        TxvApplist=(TextView) myFragmentView.findViewById(R.id.TxvApplist);
        TxvAboutMe=(TextView) myFragmentView.findViewById(R.id.TxvAboutMe);


        LayerSearch=(LinearLayout) myFragmentView.findViewById(R.id.LayerSearch);
        LayerAboutMe=(LinearLayout) myFragmentView.findViewById(R.id.LayerAboutMe);
        LayerOrganization=(LinearLayout) myFragmentView.findViewById(R.id.LayerOrganization);


        LayerAppList=(LinearLayout) myFragmentView.findViewById(R.id.LayerAppList);
        LayerAction=(LinearLayout) myFragmentView.findViewById(R.id.LayerAction);
        LayerBank=(LinearLayout) myFragmentView.findViewById(R.id.LayerBank);
        LayerInsertComment=(LinearLayout) myFragmentView.findViewById(R.id.LayerInsertComment);


        LayerCompany=(LinearLayout) myFragmentView.findViewById(R.id.LayerCompany);
        LayerBimeh=(LinearLayout) myFragmentView.findViewById(R.id.LayerBimeh);
        LayerMyFavorite=(LinearLayout) myFragmentView.findViewById(R.id.LayerMyFavorite);
        LayerPrivateCode=(LinearLayout) myFragmentView.findViewById(R.id.LayerPrivateCode);

        LayerMCI=(LinearLayout) myFragmentView.findViewById(R.id.LayerMCI);
        LayerIranCell=(LinearLayout) myFragmentView.findViewById(R.id.LayerIranCell);
        LayerRitel=(LinearLayout) myFragmentView.findViewById(R.id.LayerRitel);


        TxvSearch.setTypeface(TextFont,Typeface.BOLD);
        TxvMyFavorite.setTypeface(TextFont,Typeface.BOLD);

        TxvPrivateCode.setTypeface(TextFont,Typeface.BOLD);
        TxvMCI.setTypeface(TextFont,Typeface.BOLD);

        TxvIranCell.setTypeface(TextFont,Typeface.BOLD);
        TxvRitel.setTypeface(TextFont,Typeface.BOLD);


        TxvOrgan.setTypeface(TextFont,Typeface.BOLD);
        TxvBimeh.setTypeface(TextFont,Typeface.BOLD);

        TxvBank.setTypeface(TextFont,Typeface.BOLD);
        TxvCompany.setTypeface(TextFont,Typeface.BOLD);

        TxvAction.setTypeface(TextFont,Typeface.BOLD);
        TxvComment.setTypeface(TextFont,Typeface.BOLD);

        TxvApplist.setTypeface(TextFont,Typeface.BOLD);
        TxvAboutMe.setTypeface(TextFont,Typeface.BOLD);

        LayerPrivateCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClassHelper.setGroupPreviousPage("");
                ClassHelper.setPreviousPage("");

                Fragment detail = new FragmentPrivateCode();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();

            }
        });


        LayerMyFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClassHelper.setGroupPreviousPage("");
                ClassHelper.setPreviousPage("");


                TO.set_Head_id("10000");
                TO.set_Head_Title("کدهای مورد علاقه");

                Fragment detail = new FragmentInterfacePage();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();

            }
        });

        LayerSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClassHelper.setGroupPreviousPage("");
                ClassHelper.setPreviousPage("");

                ClassHelper.setSearchData("");

                Fragment detail = new FragmentSearch();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();

            }
        });

        LayerAboutMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClassHelper.setGroupPreviousPage("");
                ClassHelper.setPreviousPage("");

                Fragment detail = new FragmentAboutMe();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();

            }
        });

        LayerOrganization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClassHelper.setGroupPreviousPage("");
                ClassHelper.setPreviousPage("");


                TO.set_Head_id("4");
                TO.set_Head_Title("سازمان ها");

                Fragment detail = new FragmentInterfacePage();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();

            }
        });

        LayerBimeh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClassHelper.setGroupPreviousPage("");
                ClassHelper.setPreviousPage("");

                TO.set_Head_id("5");
                TO.set_Head_Title("بیمه ها");

                Fragment detail = new FragmentInterfacePage();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();

            }
        });

        LayerBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClassHelper.setGroupPreviousPage("");
                ClassHelper.setPreviousPage("");

                TO.set_Head_id("7");
                TO.set_Head_Title("بانک ها");

                Fragment detail = new FragmentInterfacePage();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();

            }
        });

        LayerCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClassHelper.setGroupPreviousPage("");
                ClassHelper.setPreviousPage("");

                TO.set_Head_id("8");
                TO.set_Head_Title("شرکت ها");

                Fragment detail = new FragmentInterfacePage();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();

            }
        });

        LayerMCI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClassHelper.setGroupPreviousPage("");
                ClassHelper.setPreviousPage("");


                TO.set_Group_Head_id("100");
                TO.set_Group_Head_Title("همراه اول");

                Fragment detail = new FragmentGroupList();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();

            }
        });

        LayerIranCell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClassHelper.setGroupPreviousPage("");
                ClassHelper.setPreviousPage("");

                TO.set_Group_Head_id("150");
                TO.set_Group_Head_Title("ایرانسل");

                Fragment detail = new FragmentGroupList();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();

            }
        });

        LayerRitel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClassHelper.setGroupPreviousPage("");
                ClassHelper.setPreviousPage("");

                TO.set_Group_Head_id("170");
                TO.set_Group_Head_Title("رایتل");

                Fragment detail = new FragmentGroupList();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();

            }
        });

        LayerAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClassHelper.setGroupPreviousPage("");
                ClassHelper.setPreviousPage("");

                TO.set_Group_Head_id("200");
                TO.set_Group_Head_Title("عملیات");

                Fragment detail = new FragmentGroupList();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();

            }
        });

        LayerInsertComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (ClassHelper.getMarketName().equals("cafebazaar")) {
                    try {

                        Intent intent = new Intent(Intent.ACTION_EDIT);
                        intent.setData(Uri.parse("bazaar://details?id=" + "samaco.myson.ussd"));
                        intent.setPackage("com.farsitel.bazaar");
                        startActivity(intent);
                    }
                    catch (Exception ex)
                    {
                        Toast.makeText(myFragmentView.getContext().getApplicationContext(), "نرم افزار بازار بر روی دستگاه شما نصب نیست", Toast.LENGTH_LONG).show();
                    }

                }//if (ClassHelper.getMarketName().equals("cafebazaar"))
                else if (ClassHelper.getMarketName().equals("cando"))
                {
                    try {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("cando://leave-review?id=samaco.myson.ussd"));
                        startActivity(intent);
                    }
                    catch (Exception ex)
                    {
                        Toast.makeText(myFragmentView.getContext().getApplicationContext(),"نرم افزار کندو بر روی دستگاه شما نصب نیست",Toast.LENGTH_LONG).show();
                    }

                }//else if (ClassHelper.getMarketName().equals("cando"))

            }
        });

        LayerAppList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (ClassHelper.getMarketName().equals("cafebazaar")) {
                    try {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("bazaar://collection?slug=by_author&aid=" + "alirezayaghoubi"));
                        intent.setPackage("com.farsitel.bazaar");
                        startActivity(intent);
                    }
                    catch (Exception ex)
                    {
                        Toast.makeText(myFragmentView.getContext().getApplicationContext(),"نرم افزار بازار بر روی دستگاه شما نصب نیست",Toast.LENGTH_LONG).show();
                    }

                }//if (MarketName.equals("cafebazaar"))
                else if (ClassHelper.getMarketName().equals("cando")) {

                    try {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("cando://publisher?id=a.yaghoubi.samaco@gmail.com"));
                        startActivity(intent);
                    }
                    catch (Exception ex)
                    {
                        Toast.makeText(myFragmentView.getContext().getApplicationContext(),"نرم افزار کندو بر روی دستگاه شما نصب نیست",Toast.LENGTH_LONG).show();
                    }

                }//else if (ClassHelper.getMarketName().equals("cando"))


            }
        });

        return myFragmentView;
    }

 }
