package samaco.myson.ussd;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import samaco.myson.ussd.Adapter.MainAdapter;
import samaco.myson.ussd.Adapter.SearchAdapter;
import samaco.myson.ussd.Business.GetVersionBu;
import samaco.myson.ussd.Common.ClassHelper;
import samaco.myson.ussd.DataAccess.DeleteDataBase;
import samaco.myson.ussd.Entities.TO;


public class MainActivity extends ActionBarActivity {

    TextView TxvHeader;
    ListView Lst;
    ArrayList<String> DetailsItemList=new ArrayList<String>();
    ArrayList<String> ID_List=new ArrayList<String>();


    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private String[] mPlanetTitles;
    String dokme_txt = "USSD";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        ClassHelper.setAppVersion("1.1.0");
        //ClassHelper.setMarketName("cafebazaar");
        //ClassHelper.setMarketName("cando");
        ClassHelper.setMarketName("");



       //Delete
       //DeleteDataBase deleteDataBase=new DeleteDataBase();
       //deleteDataBase.DeleteIfExists(this);

        String CurrentVersion="";

        GetVersionBu getVersionBu=new GetVersionBu();
        CurrentVersion=getVersionBu.GetCurrentVersion(this);



        if (!(CurrentVersion.equals(ClassHelper.getAppVersion())))
        {
            //Delete DataBase
            DeleteDataBase ddb=new DeleteDataBase();
            ddb.DeleteIfExists(this);

            Toast.makeText(getApplicationContext(), "بانک اطلاعاتی بروز شد", Toast.LENGTH_LONG).show();

        }//if (!(CurrentVersion.equals(ClassHelper.getAppVersion())))


        //Lst=(ListView)findViewById(R.id.LstVwDetails);


        Typeface TextFontJadid = Typeface.createFromAsset(getAssets(),"fonts/BJadidBd.ttf");
        Typeface TextFontElham = Typeface.createFromAsset(getAssets(),"fonts/BElham.ttf");


        mPlanetTitles = getResources().getStringArray(R.array.dokmeha);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        // Set the adapter for the list view
       // mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                //android.R.layout.simple_list_item_1, mPlanetTitles));

        List_Fill();

        MainAdapter adapter=new MainAdapter(this,DetailsItemList,ID_List);
        mDrawerList.setAdapter(adapter);


        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int post, long arg3) {

                //dokme_txt = DetailsItemList.get(post);

                Integer Id=Integer.parseInt(ID_List.get(post));

                if (Id==0)
                {
                    ClassHelper.setGroupPreviousPage("");
                    ClassHelper.setPreviousPage("");
                    Fragment detail = new FragmentMain();
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();

                }
                else if (Id==1)
                {
                    ClassHelper.setGroupPreviousPage("");
                    ClassHelper.setPreviousPage("");

                    TO.set_Group_Head_id("100");
                    TO.set_Group_Head_Title("همراه اول");

                    Fragment detail = new FragmentGroupList();
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();
                }

                else if (Id==2)
                {
                    ClassHelper.setGroupPreviousPage("");
                    ClassHelper.setPreviousPage("");

                    TO.set_Group_Head_id("150");
                    TO.set_Group_Head_Title("ایرانسل");

                    Fragment detail = new FragmentGroupList();
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();

                }

                else if (Id==3)
                {

                    ClassHelper.setGroupPreviousPage("");
                    ClassHelper.setPreviousPage("");

                    TO.set_Group_Head_id("170");
                    TO.set_Group_Head_Title("رایتل");

                    Fragment detail = new FragmentGroupList();
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();

                }

                else if (Id==4)
                {
                    ClassHelper.setGroupPreviousPage("");
                    ClassHelper.setPreviousPage("");

                    TO.set_Head_id("4");
                    TO.set_Head_Title("سازمان ها");

                    Fragment detail = new FragmentInterfacePage();
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();
                }

                else if (Id==5)
                {
                    ClassHelper.setGroupPreviousPage("");
                    ClassHelper.setPreviousPage("");


                    TO.set_Head_id("5");
                    TO.set_Head_Title("بیمه ها");

                    Fragment detail = new FragmentInterfacePage();
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();
                }

                else if (Id==6)
                {

                    ClassHelper.setGroupPreviousPage("");
                    ClassHelper.setPreviousPage("");

                    TO.set_Head_id("7");
                    TO.set_Head_Title("بانک ها");

                    Fragment detail = new FragmentInterfacePage();
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();
                }

                else if (Id==7)
                {

                    ClassHelper.setGroupPreviousPage("");
                    ClassHelper.setPreviousPage("");

                    TO.set_Head_id("8");
                    TO.set_Head_Title("شرکت ها");

                    Fragment detail = new FragmentInterfacePage();
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();

                }

                else if (Id==8)
                {

                    ClassHelper.setGroupPreviousPage("");
                    ClassHelper.setPreviousPage("");

                    TO.set_Group_Head_id("200");
                    TO.set_Group_Head_Title("عملیات");

                    Fragment detail = new FragmentGroupList();
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();
                }

                else if (Id==9)
                {
                    ClassHelper.setGroupPreviousPage("");
                    ClassHelper.setPreviousPage("");

                    ClassHelper.setSearchData("");

                    Fragment detail = new FragmentSearch();
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();
                }

                else if (Id==10)
                {
                    ClassHelper.setGroupPreviousPage("");
                    ClassHelper.setPreviousPage("");

                    TO.set_Head_id("10000");
                    TO.set_Head_Title("کدهای مورد علاقه");

                    Fragment detail = new FragmentInterfacePage();
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();
                }

                else if (Id==11)
                {
                    ClassHelper.setGroupPreviousPage("");
                    ClassHelper.setPreviousPage("");

                    Fragment detail = new FragmentPrivateCode();
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();
                }

                else if (Id==12)
                {
                    if (ClassHelper.getMarketName().equals("cafebazaar")) {
                        try {

                            Intent intent = new Intent(Intent.ACTION_EDIT);
                            intent.setData(Uri.parse("bazaar://details?id=" + "samaco.myson.ussd"));
                            intent.setPackage("com.farsitel.bazaar");
                            startActivity(intent);
                        }
                        catch (Exception ex)
                        {
                            Toast.makeText(getApplicationContext(), "نرم افزار بازار بر روی دستگاه شما نصب نیست", Toast.LENGTH_LONG).show();
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
                            Toast.makeText(getApplicationContext(),"نرم افزار کندو بر روی دستگاه شما نصب نیست",Toast.LENGTH_LONG).show();
                        }

                    }//else if (ClassHelper.getMarketName().equals("cando"))
                }

                else if (Id==13)
                {
                    if (ClassHelper.getMarketName().equals("cafebazaar")) {
                        try {
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.setData(Uri.parse("bazaar://collection?slug=by_author&aid=" + "alirezayaghoubi"));
                            intent.setPackage("com.farsitel.bazaar");
                            startActivity(intent);
                        }
                        catch (Exception ex)
                        {
                            Toast.makeText(getApplicationContext(),"نرم افزار بازار بر روی دستگاه شما نصب نیست",Toast.LENGTH_LONG).show();
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
                            Toast.makeText(getApplicationContext(),"نرم افزار کندو بر روی دستگاه شما نصب نیست",Toast.LENGTH_LONG).show();
                        }

                    }//else if (ClassHelper.getMarketName().equals("cando"))
                }

                else if (Id==14)
                {

                    Fragment detail = new FragmentAboutMe();
                    FragmentManager fragmentManager = getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();

                }

                else if (Id==15)
                {
                    MainActivity.this.finish();
                }

                mDrawerLayout.closeDrawer(mDrawerList);

            }

        });

        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                R.mipmap.best2,
                R.string.drawer_open, R.string.drawer_close){

            /** هنگامی که منو کشویی کاملا بسته شده متد زیر اجرا میشه */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(dokme_txt);
                supportInvalidateOptionsMenu();
                // creates call to
                // onPrepareOptionsMenu()
            }

            /** هنگامی که منو کشویی کاملا باز شده متد زیر اجرا میشه */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("USSD");
                supportInvalidateOptionsMenu(); // creates call to
                // onPrepareOptionsMenu()
            }


        };




        mDrawerLayout.setDrawerListener(mDrawerToggle);



        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ff6e8cca")));

        getSupportActionBar().setTitle("USSD");

        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        Fragment detail = new FragmentMain();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();


    }

    private void List_Fill()
    {
        DetailsItemList.add("صفحه اصلی");
        ID_List.add("0");


        DetailsItemList.add("همراه اول");
        ID_List.add("1");


        DetailsItemList.add("ایرانسل");
        ID_List.add("2");

        DetailsItemList.add("رایتل");
        ID_List.add("3");


        DetailsItemList.add("سازمان ها");
        ID_List.add("4");


        DetailsItemList.add("بیمه ها");
        ID_List.add("5");

        DetailsItemList.add("بانک ها");
        ID_List.add("6");

        DetailsItemList.add("شرکت ها");
        ID_List.add("7");

        DetailsItemList.add("عملیات");
        ID_List.add("8");

        DetailsItemList.add("جستجو");
        ID_List.add("9");

        DetailsItemList.add("کدهای مورد علاقه");
        ID_List.add("10");

        DetailsItemList.add("کدهای شخصی");
        ID_List.add("11");

        DetailsItemList.add("ثبت نظر");
        ID_List.add("12");

        DetailsItemList.add("سایر برنامه ها");
        ID_List.add("13");

        DetailsItemList.add("در مورد برنامه");
        ID_List.add("14");

        DetailsItemList.add("خروج");
        ID_List.add("15");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {

            case R.id.HomeMenu:
                Fragment Home = new FragmentMain();
                FragmentManager fragmentManagerhome = getFragmentManager();
                fragmentManagerhome.beginTransaction().replace(R.id.content_frame, Home).commit();
                return true;

            case R.id.SearchMenu:
                ClassHelper.setSearchData("");
                Fragment detail = new FragmentSearch();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();
                return true;

            case R.id.myfavorite:
                TO.set_Head_id("10000");
                Fragment fay = new FragmentInterfacePage();
                FragmentManager fragmentManagerfay = getFragmentManager();
                fragmentManagerfay.beginTransaction().replace(R.id.content_frame, fay).commit();
                return true;

            case R.id.privatecode:
                Fragment detailprivatecode = new FragmentPrivateCode();
                FragmentManager fragmentManagerprivatecode = getFragmentManager();
                fragmentManagerprivatecode.beginTransaction().replace(R.id.content_frame, detailprivatecode).commit();
                return true;

            case R.id.MyApp:
                Fragment detailMyApp = new FragmentAboutMe();
                FragmentManager fragmentManagerMyApp = getFragmentManager();
                fragmentManagerMyApp.beginTransaction().replace(R.id.content_frame, detailMyApp).commit();
                return true;

            case R.id.ExitMenu:
                MainActivity.this.finish();
                return true;

            case R.id.Comment:
                GetUssdOnNet();
                return true;

            case R.id.MyAppList:
                GetMyAppList();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }//switch (item.getItemId())


    }


    private void GetUssdOnNet()
    {
        if (ClassHelper.getMarketName().equals("cafebazaar")) {
            try {

                Intent intent = new Intent(Intent.ACTION_EDIT);
                intent.setData(Uri.parse("bazaar://details?id=" + "samaco.myson.ussd"));
                intent.setPackage("com.farsitel.bazaar");
                startActivity(intent);
            }
            catch (Exception ex)
            {
                Toast.makeText(getApplicationContext(), "نرم افزار بازار بر روی دستگاه شما نصب نیست", Toast.LENGTH_LONG).show();
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
                Toast.makeText(getApplicationContext(),"نرم افزار کندو بر روی دستگاه شما نصب نیست",Toast.LENGTH_LONG).show();
            }

        }//else if (ClassHelper.getMarketName().equals("cando"))
    }

    private void GetMyAppList()
    {

        if (ClassHelper.getMarketName().equals("cafebazaar")) {
            try {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("bazaar://collection?slug=by_author&aid=" + "alirezayaghoubi"));
                intent.setPackage("com.farsitel.bazaar");
                startActivity(intent);
            }
            catch (Exception ex)
            {
                Toast.makeText(getApplicationContext(),"نرم افزار بازار بر روی دستگاه شما نصب نیست",Toast.LENGTH_LONG).show();
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
                Toast.makeText(getApplicationContext(),"نرم افزار کندو بر روی دستگاه شما نصب نیست",Toast.LENGTH_LONG).show();
            }

        }//else if (ClassHelper.getMarketName().equals("cando"))

    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {

        FragmentManager fragmentManager = getFragmentManager();
        Fragment currentFragment = fragmentManager.findFragmentById(R.id.content_frame);


        if (currentFragment instanceof  FragmentSearch)
        {
            Fragment Frm = new FragmentMain();
            fragmentManager.beginTransaction().replace(R.id.content_frame, Frm).commit();
        }

        else if (currentFragment instanceof  FragmentFinalShow)
        {
            if (ClassHelper.getPreviousPage().equals("FragmentSearch")) {

                Fragment Frm = new FragmentSearch();
                fragmentManager.beginTransaction().replace(R.id.content_frame, Frm).commit();

            }
            else if (ClassHelper.getPreviousPage().equals("FragmentInterfacePage")) {

                Fragment Frm = new FragmentInterfacePage();
                fragmentManager.beginTransaction().replace(R.id.content_frame, Frm).commit();

            }
        }

        else if (currentFragment instanceof  FragmentAboutMe)
        {
            Fragment Frm = new FragmentMain();
            fragmentManager.beginTransaction().replace(R.id.content_frame, Frm).commit();
        }

        else if (currentFragment instanceof  FragmentInterfacePage)
        {
            if (ClassHelper.getPreviousPage().equals("FragmentGroupList")
                    || ClassHelper.getGroupPreviousPage().equals("FragmentGroupList")) {


                ClassHelper.setGroupPreviousPage("");
                ClassHelper.setPreviousPage("");

                Fragment Frm = new FragmentGroupList();
                fragmentManager.beginTransaction().replace(R.id.content_frame, Frm).commit();

            }
            else {

                Fragment Frm = new FragmentMain();
                fragmentManager.beginTransaction().replace(R.id.content_frame, Frm).commit();
            }
        }

        else if (currentFragment instanceof  FragmentGroupList)
        {
            Fragment Frm = new FragmentMain();
            fragmentManager.beginTransaction().replace(R.id.content_frame, Frm).commit();
        }


        else if (currentFragment instanceof  FragmentPrivateCode)
        {
            Fragment Frm = new FragmentMain();
            fragmentManager.beginTransaction().replace(R.id.content_frame, Frm).commit();
        }

        else if (currentFragment instanceof  FragmentCodeEdit)
        {
            Fragment Frm = new FragmentPrivateCode();
            fragmentManager.beginTransaction().replace(R.id.content_frame, Frm).commit();
        }


        else
            super.onBackPressed();


    }
}
