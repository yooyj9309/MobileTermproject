package com.example.parkdusang.healthtrainer;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MyCustomAdapter3 extends BaseAdapter {

    Context ctx;
    int layout;
    ArrayList<MyCustomDTOAddCustim> list;
    LayoutInflater inf;
    int selectedPosition = 0;

    public MyCustomAdapter3(Context ctx, int layout, ArrayList<MyCustomDTOAddCustim> list){
        this.ctx = ctx;
        this.layout = layout;
        this.list = list;

        inf = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if( v == null){
            v = inf.inflate(layout, null);

        }
        TextView txtTitle = (TextView)v.findViewById(R.id.txtTitle3);
        TextView txtContent = (TextView) v.findViewById(R.id.txtContent3);
        ImageView imgIcon =  (ImageView)v.findViewById(R.id.imgIcon3);
        RadioButton rbSelect = (RadioButton) v.findViewById(R.id.radioBtn);
        RadioButton r = (RadioButton)v.findViewById(R.id.radioBtn);


       /* r.setChecked(position == selectedPosition);
        r.setTag(position);
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedPosition = (Integer)view.getTag();
                notifyDataSetChanged();
            }
        });

*/
        MyCustomDTOAddCustim dto = list.get(position);
        txtTitle.setText(dto.getTitle());
        txtContent.setText(dto.getContent());
        imgIcon.setImageResource(dto.getImgIcon());
        rbSelect.setChecked(false);
        return v;
    }

}
