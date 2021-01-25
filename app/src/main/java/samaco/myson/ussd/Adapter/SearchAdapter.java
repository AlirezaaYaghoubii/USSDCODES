package samaco.myson.ussd.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import samaco.myson.ussd.R;

/**
 * Created by Alireza on 08/12/2015.
 */
public class SearchAdapter extends BaseAdapter {

    LayoutInflater inflater ;
    ArrayList<String> DetailsItemList;
    ArrayList<String> DetailsItemList_No;
    ArrayList<String> ID_List;
    Typeface TextFont;

    public SearchAdapter(Context context, ArrayList<String> DetailsItemList,ArrayList<String> DetailsItemList_No
    ,ArrayList<String> ID_List)
    {
        inflater = LayoutInflater.from(context);
        this.DetailsItemList=DetailsItemList;
        this.DetailsItemList_No=DetailsItemList_No;
        this.ID_List=ID_List;
        TextFont=Typeface.createFromAsset(context.getAssets(),"fonts/BYekan.ttf");

    }



    @Override
    public int getCount()
    {
        return DetailsItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        MyHolder holder;

        if(convertView==null)
        {
            holder = new MyHolder();
            convertView = inflater.inflate(R.layout.list_item_search,null);

            holder.MyText = (TextView) convertView.findViewById(R.id.myText);
            holder.MyNo = (TextView) convertView.findViewById(R.id.myno);
            holder.MyImg = (ImageView) convertView.findViewById(R.id.MyImg);

            convertView.setTag(holder);
        }
        else
        {
            holder = (MyHolder) convertView.getTag();

        }

        holder.MyText.setText(DetailsItemList.get(position));
        holder.MyNo.setText(DetailsItemList_No.get(position));




        if (ID_List.get(position).equals("101"))
            holder.MyImg.setImageResource(R.mipmap.mcipng);

            //طرحهای تشویقی
        else if (ID_List.get(position).equals("102"))
            holder.MyImg.setImageResource(R.mipmap.mymoney);

        else if (ID_List.get(position).equals("103"))
            holder.MyImg.setImageResource(R.mipmap.internetblue);

            //سرویس های همراه اول
        else if (ID_List.get(position).equals("104"))
            holder.MyImg.setImageResource(R.mipmap.internetroyal);

            //جیرینگ همراه اول
        else if (ID_List.get(position).equals("105"))
            holder.MyImg.setImageResource(R.mipmap.kifpol2);

            // طرح های مناسبتی
        else if (ID_List.get(position).equals("106"))
            holder.MyImg.setImageResource(R.mipmap.cake);

            //خدمات پرداخت مشترکین دائمی
        else if (ID_List.get(position).equals("107"))
            holder.MyImg.setImageResource(R.mipmap.pardakht);

            //خدمات پرداخت مشترکین اعتباری
        else if (ID_List.get(position).equals("108"))
            holder.MyImg.setImageResource(R.mipmap.payment);

            //خدمات غیرحضوری
        else if (ID_List.get(position).equals("109"))
            holder.MyImg.setImageResource(R.mipmap.internetbold);

            //آوای انتظار
        else if (ID_List.get(position).equals("110"))
            holder.MyImg.setImageResource(R.mipmap.music);

            //اینترنت
        else if (ID_List.get(position).equals("111"))
            holder.MyImg.setImageResource(R.mipmap.internetpack);


            //خدمات مکالمه
        else if (ID_List.get(position).equals("112"))
            holder.MyImg.setImageResource(R.mipmap.chat);


            //خدمات ارزش افزوده
        else if (ID_List.get(position).equals("113"))
            holder.MyImg.setImageResource(R.mipmap.football);


            //چتر اضطراری
        else if (ID_List.get(position).equals("114"))
            holder.MyImg.setImageResource(R.mipmap.emergency);


            //بسته های پیامک
        else if (ID_List.get(position).equals("115"))
            holder.MyImg.setImageResource(R.mipmap.smsmci);


            //بسته های مکالمه
        else if (ID_List.get(position).equals("116"))
            holder.MyImg.setImageResource(R.mipmap.chat2);


            //شارژ موبایل
        else if (ID_List.get(position).equals("201"))
            holder.MyImg.setImageResource(R.mipmap.mobileicon);


            //پرداخت قبوض
        else if (ID_List.get(position).equals("202"))
            holder.MyImg.setImageResource(R.mipmap.pardakht);


            //خیریه
        else if (ID_List.get(position).equals("203"))
            holder.MyImg.setImageResource(R.mipmap.sekeh);



            //بسته اینترنت
        else if (ID_List.get(position).equals("204"))
            holder.MyImg.setImageResource(R.mipmap.internetred);

            //خرید
        else if (ID_List.get(position).equals("205"))
            holder.MyImg.setImageResource(R.mipmap.pardakht2);


            //متفرقه
        else if (ID_List.get(position).equals("9"))
            holder.MyImg.setImageResource(R.mipmap.box);


            //کدهای دستوری رایتل
        else if (ID_List.get(position).equals("3"))
            holder.MyImg.setImageResource(R.mipmap.rightelpng);

            //بسته های مصرفی اینترنت – سرعت پایه
        else if (ID_List.get(position).equals("171"))
            holder.MyImg.setImageResource(R.mipmap.internetgreen);

            //بسته های پیامکی دایمی و اعتباری
        else if (ID_List.get(position).equals("172"))
            holder.MyImg.setImageResource(R.mipmap.smsrightel);

            //بسته های مصرفی اینترنت – سرعت حرفه ای
        else if (ID_List.get(position).equals("173"))
            holder.MyImg.setImageResource(R.mipmap.internetfast);


            //سیم کارت اعتباری
        else if (ID_List.get(position).equals("151"))
            holder.MyImg.setImageResource(R.mipmap.irancell);

            //سیم کارت دائمی
        else if (ID_List.get(position).equals("152"))
            holder.MyImg.setImageResource(R.mipmap.mysim);

            //بسته های ترکیبی ایرانسل
        else if (ID_List.get(position).equals("153"))
            holder.MyImg.setImageResource(R.mipmap.basteirancell);

            //بسته های اینترنت
        else if (ID_List.get(position).equals("154"))
            holder.MyImg.setImageResource(R.mipmap.internetred);

            //بسته اینترنت همراه هدیه دهید!
        else if (ID_List.get(position).equals("155"))
            holder.MyImg.setImageResource(R.mipmap.gift);

            //پیشنهادهای تشویقی
        else if (ID_List.get(position).equals("156"))
            holder.MyImg.setImageResource(R.mipmap.mymoney);

            //روش‌های شارژ اضطراری
        else if (ID_List.get(position).equals("157"))
            holder.MyImg.setImageResource(R.mipmap.emergency);

            //طرح های تعرفه
        else if (ID_List.get(position).equals("158"))
            holder.MyImg.setImageResource(R.mipmap.mysetting);

            //طرح های تعرفه رنگی دیتا
        else if (ID_List.get(position).equals("159"))
            holder.MyImg.setImageResource(R.mipmap.paint);

            //سایر کدها
        else if (ID_List.get(position).equals("160"))
            holder.MyImg.setImageResource(R.mipmap.bookmarklist);

            //شارژ مستقیم اینترنت همراه
        else if (ID_List.get(position).equals("161"))
            holder.MyImg.setImageResource(R.mipmap.internetpack);

            //بسته‌های ترکیبی آی ‌سیم
        else if (ID_List.get(position).equals("162"))
            holder.MyImg.setImageResource(R.mipmap.smsirancell);




        else if (ID_List.get(position).equals("7"))
            holder.MyImg.setImageResource(R.mipmap.bankpbg);

        else if (ID_List.get(position).equals("8"))
            holder.MyImg.setImageResource(R.mipmap.mycompany);

        else if (ID_List.get(position).equals("5"))
            holder.MyImg.setImageResource(R.mipmap.umbrella);

        else if (ID_List.get(position).equals("4"))
            holder.MyImg.setImageResource(R.mipmap.organpng);

        else if (ID_List.get(position).equals("5000"))
            holder.MyImg.setImageResource(R.mipmap.privateusers);

        else if (ID_List.get(position).equals(""))
            holder.MyImg.setImageResource(R.mipmap.smsirancell);

        else if (ID_List.get(position).equals(""))
            holder.MyImg.setImageResource(R.mipmap.smsirancell);




        holder.MyText.setTypeface(TextFont);

        return convertView;



    }

    private class MyHolder
    {
        TextView MyText;
        TextView MyNo;
        ImageView MyImg;

    }
}
