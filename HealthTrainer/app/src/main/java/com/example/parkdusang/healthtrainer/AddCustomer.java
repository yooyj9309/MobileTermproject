package com.example.parkdusang.healthtrainer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class AddCustomer extends AppCompatActivity {
    Spinner s1;
    String[] plants_arrays = {
            "이름", "성별", "나이", "전화번호"
    };
    ListView listView;
    ArrayList<MyCustomDTOAddCustim> list;
    Button btn2;
    String name,content;
    int imgid;
    RadioButton radio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_customer);
        btn2 = (Button)findViewById(R.id.btn1);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent returnintent = new Intent();
                returnintent.putExtra("name",name);
                returnintent.putExtra("content",content);
                returnintent.putExtra("imgid",imgid);
                setResult(Activity.RESULT_OK, returnintent);
                finish();

            }
        });


        s1 = (Spinner) findViewById(R.id.spinnersort);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, plants_arrays);
        s1.setAdapter(adapter);
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0,
                                       View arg1, int arg2, long arg3) {
                int index = s1.getSelectedItemPosition();
                Toast.makeText(getBaseContext(),
                        "You have selected item : " + plants_arrays[index], Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        list = new ArrayList<MyCustomDTOAddCustim>();
        list.add(new MyCustomDTOAddCustim("누군가", "홍길동 테스트!", R.drawable.user1));
        list.add(new MyCustomDTOAddCustim("미친존재감", "영희 테스트!", R.drawable.user2));
        list.add(new MyCustomDTOAddCustim("추가", "철수 테스트!", R.drawable.user1));

        listView = (ListView)findViewById(R.id.listView3);

        MyCustomAdapter3 adapter3 =
                new MyCustomAdapter3(
                        getApplicationContext(),
                        R.layout.list_row_addcustomer,
                        list);

        listView.setAdapter(adapter3);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                name = list.get(position).getTitle().toString();
                content = list.get(position).getContent().toString();
                imgid = list.get(position).getImgIcon();
                for (int i = 0; i < parent.getCount() ; i ++)
                {

                    View v = parent.getChildAt(i);
                    RadioButton radio = (RadioButton) v.findViewById(R.id.radio);
                    radio.setChecked(false);

                }

                RadioButton radio = (RadioButton) view.findViewById(R.id.radio);
                radio.setChecked(true);



            }
        });

    }
}
