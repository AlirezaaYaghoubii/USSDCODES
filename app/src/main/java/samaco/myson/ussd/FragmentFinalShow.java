package samaco.myson.ussd;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import samaco.myson.ussd.Business.BuDetailsData;
import samaco.myson.ussd.Business.BuPrivateCodeUpdate;
import samaco.myson.ussd.Common.ClassHelper;
import samaco.myson.ussd.Entities.TO;


public class FragmentFinalShow extends Fragment {

    private View myFragmentView;
    TextView TxvHeader;
    TextView TxvShow;
    TextView TxvSmsNo;
    TextView TxvShowDetails;
    TextView TxtCommon;

    EditText EdtSmsBody;
    Button Btn;
    Button BtnNet;
    Button BtnEmail;
    Button BtnSms;

    Button BtnFavorite;
    Button BtnUnFavorite;

    Button BtnUpdateCode;
    Button BtnDeleteCode;

    String Head_id;
    String Id;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        myFragmentView = inflater.inflate(R.layout.fragmentfinalshow, container, false);


        Head_id= TO.get_Head_id();
        Id= TO.get_Id();

        TxvHeader = (TextView) myFragmentView.findViewById(R.id.TxvHeader);
        TxvShow = (TextView) myFragmentView.findViewById(R.id.TxvShow);
        TxvSmsNo = (TextView) myFragmentView.findViewById(R.id.TxvSmsNo);
        TxvShowDetails = (TextView) myFragmentView.findViewById(R.id.TxvShowDetails);

        TxtCommon= (TextView) myFragmentView.findViewById(R.id.TxtCommon);

        EdtSmsBody = (EditText) myFragmentView.findViewById(R.id.EdtSmsBody);

        TxvHeader.setText(TO.get_Title());
        TxvShow.setText(TO.get_Smsformat());

        TxvSmsNo.setText(TO.get_Smsno());
        EdtSmsBody.setText(TO.get_Smsno());

        TxvShowDetails.setText(TO.get_Smsdetails());

        Btn = (Button) myFragmentView.findViewById(R.id.BtnSendSms);
        BtnNet = (Button) myFragmentView.findViewById(R.id.BtnNet);
        BtnEmail = (Button) myFragmentView.findViewById(R.id.BtnEmail);
        BtnSms = (Button) myFragmentView.findViewById(R.id.BtnSms);

        BtnFavorite = (Button) myFragmentView.findViewById(R.id.BtnFavorite);
        BtnUnFavorite = (Button) myFragmentView.findViewById(R.id.BtnUnFavorite);

        BtnUpdateCode = (Button) myFragmentView.findViewById(R.id.BtnUpdateCode);
        BtnDeleteCode = (Button) myFragmentView.findViewById(R.id.BtnDeleteCode);

        Typeface TextFont = Typeface.createFromAsset(myFragmentView.getContext().getAssets(), "fonts/BYekan.ttf");


        TxvHeader.setTypeface(TextFont,Typeface.BOLD);
        TxvShow.setTypeface(TextFont);
        TxvShowDetails.setTypeface(TextFont);
        TxtCommon.setTypeface(TextFont);




        Btn.setTypeface(TextFont,Typeface.BOLD);
        BtnNet.setTypeface(TextFont,Typeface.BOLD);
        BtnEmail.setTypeface(TextFont,Typeface.BOLD);
        BtnSms.setTypeface(TextFont,Typeface.BOLD);


        BtnFavorite.setTypeface(TextFont);
        BtnUnFavorite.setTypeface(TextFont);

        BtnUpdateCode.setTypeface(TextFont);
        BtnDeleteCode.setTypeface(TextFont);


        BtnFavorite.setEnabled(false);
        BtnUnFavorite.setEnabled(false);

        BuDetailsData buDetailsData = new BuDetailsData();
        Boolean Result=buDetailsData.GetFavoriteStatus(myFragmentView.getContext(), Id);


        if (Result) {

            BtnFavorite.setEnabled(false);
            BtnUnFavorite.setEnabled(true);
        }
        else {

            BtnFavorite.setEnabled(true);
            BtnUnFavorite.setEnabled(false);
        }


        BtnUpdateCode.setEnabled(false);
        BtnDeleteCode.setEnabled(false);

        //Toast.makeText(myFragmentView.getContext().getApplicationContext(),Id,Toast.LENGTH_LONG).show();

        BtnDeleteCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                alertTwoButtons();

            }
        });

        if (Integer.parseInt(Id)>5000)
        {
            BtnUpdateCode.setEnabled(true);
            BtnDeleteCode.setEnabled(true);

        }//if (Integer.parseInt(Id)>5000)

        BtnUpdateCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClassHelper.setEditStatus("Edit");

                Fragment detail = new FragmentCodeEdit();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();
            }
        });


        BtnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BuDetailsData buDetailsData = new BuDetailsData();
                buDetailsData.SetFavorite(myFragmentView.getContext(), Id);

                BtnFavorite.setEnabled(false);
                BtnUnFavorite.setEnabled(true);

                Toast.makeText(myFragmentView.getContext().getApplicationContext(), "به لیست کدهای مورد علاقه اضافه شد", Toast.LENGTH_LONG).show();
            }
        });


        BtnUnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BuDetailsData buDetailsData = new BuDetailsData();
                buDetailsData.SetUnFavorite(myFragmentView.getContext(), Id);

                BtnFavorite.setEnabled(true);
                BtnUnFavorite.setEnabled(false);

                Toast.makeText(myFragmentView.getContext().getApplicationContext(),"از لیست کدهای مورد علاقه حذف شد",Toast.LENGTH_LONG).show();

            }
        });


        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent callIntent = new Intent
                        (Intent.ACTION_CALL, ussdToCallableUri(EdtSmsBody.getText().toString()));
                startActivity(callIntent);

            }
        });


        BtnNet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try
                {
                    Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                    sharingIntent.setType("text/plain");
                    String shareBody = TxvHeader.getText().toString()+" \n "+" کد : "+" \n "+TxvSmsNo.getText().toString();
                    sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, TxvHeader.getText().toString());
                    sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                    startActivity(Intent.createChooser(sharingIntent, "به اشتراک گذاری با ..."));
                }
                catch (Exception ex)
                {
                    Toast.makeText(myFragmentView.getContext().getApplicationContext(),ex.getMessage().toString(),Toast.LENGTH_LONG);
                }
            }
        });

        BtnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try
                {
                    String shareBody = TxvHeader.getText().toString()+" \n "+" کد : "+" \n "+TxvSmsNo.getText().toString();
                    Intent intent = new Intent(Intent.ACTION_SENDTO); // it's not ACTION_SEND
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_SUBJECT, TxvHeader.getText().toString());
                    intent.putExtra(Intent.EXTRA_TEXT, shareBody);
                    intent.setData(Uri.parse("mailto:")); // or just "mailto:" for blank
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.
                    startActivity(intent);
                }
                catch (Exception ex)
                {
                    Toast.makeText(myFragmentView.getContext().getApplicationContext(),ex.getMessage().toString(),Toast.LENGTH_LONG);
                }
            }
        });

        BtnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try
                {
                    String shareBody = TxvHeader.getText().toString()+" \n "+" کد : "+" \n "+TxvSmsNo.getText().toString();
                    Intent smsIntent = new Intent(android.content.Intent.ACTION_VIEW);
                    smsIntent.setType("vnd.android-dir/mms-sms");
                    smsIntent.putExtra("address", "");
                    smsIntent.putExtra("sms_body", shareBody);
                    startActivity(smsIntent);
                }
                catch (Exception ex)
                {
                    Toast.makeText(myFragmentView.getContext().getApplicationContext(),ex.getMessage().toString(),Toast.LENGTH_LONG);
                }
            }
        });

        return myFragmentView;
    }

    private Uri ussdToCallableUri(String ussd) {

        String uriString = "";

        if(!ussd.startsWith("tel:"))
            uriString += "tel:";

        for(char c : ussd.toCharArray()) {

            if(c == '#')
                uriString += Uri.encode("#");
            else
                uriString += c;
        }

        return Uri.parse(uriString);
    }


    public void alertTwoButtons() {

        new AlertDialog.Builder(this.getActivity())
                .setTitle("حذف")
                .setMessage("آیا شما مطمئن هستید؟")
                        //افزودن آیکون
                .setIcon(R.mipmap.deletepic)
                .setPositiveButton("بلی",
                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int id) {

                                BuPrivateCodeUpdate buPrivateCodeUpdate=new BuPrivateCodeUpdate();
                                buPrivateCodeUpdate.TblHead_Delete(myFragmentView.getContext().getApplicationContext(),Id);

                                Toast.makeText(myFragmentView.getContext().getApplicationContext(), "حذف شد", Toast.LENGTH_SHORT).show();
                                dialog.cancel();

                                Fragment detail = new FragmentPrivateCode();
                                FragmentManager fragmentManager = getFragmentManager();
                                fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();

                            }
                        })
                .setNegativeButton("خیر", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                }).show();

    }
}
