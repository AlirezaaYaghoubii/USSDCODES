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


public class InterfaceAdapter extends BaseAdapter {

    LayoutInflater inflater ;
    ArrayList<String> DetailsItemList;
    ArrayList<String> DetailsItemList_No;
    ArrayList<String> ID_List;
    Typeface TextFont;

    public InterfaceAdapter(Context context, ArrayList<String> DetailsItemList,ArrayList<String> DetailsItemList_No
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
            convertView = inflater.inflate(R.layout.list_interface_page,null);

            holder.MyText = (TextView) convertView.findViewById(R.id.myText);
            holder.MyNo = (TextView) convertView.findViewById(R.id.myno);

            convertView.setTag(holder);
        }
        else
        {
            holder = (MyHolder) convertView.getTag();

        }

        holder.MyText.setText(DetailsItemList.get(position));
        holder.MyNo.setText(DetailsItemList_No.get(position));



        holder.MyText.setTypeface(TextFont);

        return convertView;



    }

    private class MyHolder
    {
        TextView MyText;
        TextView MyNo;

    }
}
