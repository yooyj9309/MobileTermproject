package com.example.parkdusang.healthtrainer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Setexercise extends AppCompatActivity {
    ListView listView;
    ArrayList<MyCustomDTO2> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setexercise);
        // 이부분을 db 불러와서 저장해야됌 ㅇㅇ 겁나 빡실거임
        list = new ArrayList<MyCustomDTO2>();
        list.add(new MyCustomDTO2("달리기", "겁나 달려!", R.drawable.exersice));
        list.add(new MyCustomDTO2("달리기", "겁나 달려!", R.drawable.exersice));
        list.add(new MyCustomDTO2("달리기", "겁나 달려!", R.drawable.exersice));

        listView = (ListView)findViewById(R.id.listView2);

        MyCustomAdapter2 adapter2 =
                new MyCustomAdapter2(
                        getApplicationContext(),
                        R.layout.list_row_exercise,
                        list);

        listView.setAdapter(adapter2);

    }
}
