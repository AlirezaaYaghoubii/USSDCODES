package samaco.myson.ussd;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import samaco.myson.ussd.Business.BuPrivateCodeUpdate;
import samaco.myson.ussd.Common.ClassHelper;
import samaco.myson.ussd.Entities.MyData;
import samaco.myson.ussd.Entities.TO;


public class FragmentCodeEdit extends Fragment {

    private View myFragmentView;

    Button BtnSave;
    TextView TxvHeader;

    EditText TxtTitle;
    EditText TxtCode;
    EditText TxtFormat;
    EditText TxtComment;




    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myFragmentView = inflater.inflate(R.layout.fragmentcodeedite, container, false);



        BtnSave=(Button)myFragmentView.findViewById(R.id.BtnSave);
        TxvHeader=(TextView) myFragmentView.findViewById(R.id.TxvHeader);

        TxtTitle=(EditText) myFragmentView.findViewById(R.id.TxtTitle);
        TxtCode=(EditText) myFragmentView.findViewById(R.id.TxtCode);
        TxtFormat=(EditText) myFragmentView.findViewById(R.id.TxtFormat);
        TxtComment=(EditText) myFragmentView.findViewById(R.id.TxtComment);


        Typeface TextFont = Typeface.createFromAsset(myFragmentView.getContext().getAssets(), "fonts/BYekan.ttf");

        TxvHeader.setText("ایجاد / ویرایش کد");

        TxvHeader.setTypeface(TextFont,Typeface.BOLD);
        BtnSave.setTypeface(TextFont);

        TxtTitle.setTypeface(TextFont,Typeface.BOLD);
        TxtCode.setTypeface(TextFont,Typeface.BOLD);
        TxtFormat.setTypeface(TextFont);
        TxtComment.setTypeface(TextFont);

        if (ClassHelper.getEditStatus().equals("Edit"))
        {
            MyData myData=new MyData();
            BuPrivateCodeUpdate buPrivateCodeUpdate = new BuPrivateCodeUpdate();
            myData=buPrivateCodeUpdate.GetCodeData(myFragmentView.getContext().getApplicationContext(),TO.get_Id());

            TxtTitle.setText(myData.getTitle());
            TxtCode.setText(myData.getSmsno());
            TxtFormat.setText(myData.getSmsformat());
            TxtComment.setText(myData.getSmsdetails());


        }//if (ClassHelper.getEditStatus().equals("Edit"))


        BtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!TxtTitle.getText().toString().equals("") && !TxtCode.getText().toString().equals("")) {
                    if (ClassHelper.getEditStatus().equals("Insert")) {

                        if (TxtFormat.getText().toString().equals(""))
                            TxtFormat.setText("-");

                        if (TxtComment.getText().toString().equals(""))
                            TxtComment.setText("-");


                        BuPrivateCodeUpdate buPrivateCodeUpdate = new BuPrivateCodeUpdate();
                        buPrivateCodeUpdate.TblHead_Insert(myFragmentView.getContext().getApplicationContext(), TxtTitle.getText().toString()
                                , TxtCode.getText().toString(), TxtFormat.getText().toString(), TxtComment.getText().toString());


                        TxtTitle.setText("");
                        TxtCode.setText("");
                        TxtFormat.setText("");
                        TxtComment.setText("");


                        Toast.makeText(myFragmentView.getContext().getApplicationContext(),"اطلاعات ثبت شد",Toast.LENGTH_LONG).show();




                    }//if (ClassHelper.getEditStatus().equals("Insert"))

                    else if (ClassHelper.getEditStatus().equals("Edit")) {

                        if (TxtFormat.getText().toString().equals(""))
                            TxtFormat.setText("-");

                        if (TxtComment.getText().toString().equals(""))
                            TxtComment.setText("-");


                        BuPrivateCodeUpdate buPrivateCodeUpdate = new BuPrivateCodeUpdate();
                        buPrivateCodeUpdate.TblHead_Update(myFragmentView.getContext().getApplicationContext()
                                , TO.get_Id(), TxtTitle.getText().toString()
                                , TxtCode.getText().toString(), TxtFormat.getText().toString(), TxtComment.getText().toString());

                        Toast.makeText(myFragmentView.getContext().getApplicationContext(),"اطلاعات ثبت شد",Toast.LENGTH_LONG).show();

                    }// else if (ClassHelper.getEditStatus().equals("Edit"))

                }//if (!TxtTitle.getText().toString().equals("") && !TxtCode.getText().toString().equals(""))
                else
                {
                    Toast.makeText(myFragmentView.getContext().getApplicationContext(),"اطلاعات تکمیل نیست",Toast.LENGTH_LONG).show();
                }

            }
        });



        return myFragmentView;
    }
}