package com.example.parkdusang.healthtrainer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class Trainermode extends AppCompatActivity {
    // 처음 트레이너 모드로 로그인하면 들어오는 모드 list view 로 보여준다.
    ListView listView;
    FloatingActionButton btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trainermode);
        btn = (FloatingActionButton)findViewById(R.id.fab);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myAct1 = new Intent (getApplicationContext(), AddCustomer.class);
                startActivity(myAct1);

            }
        });

        ArrayList<MyCustomDTO> list = new ArrayList<MyCustomDTO>();
        list.add( new MyCustomDTO("캐나다", "캐나다 테스트!", R.drawable.canada));
        list.add( new MyCustomDTO("프랑스", "프랑스 테스트!", R.drawable.france));
        list.add( new MyCustomDTO("대한민국", "대한민국 테스트!", R.drawable.korea));
        list.add( new MyCustomDTO("멕시코", "멕시코 테스트!", R.drawable.mexico));
        list.add(new MyCustomDTO("폴란드", "폴란드 테스트", R.drawable.poland));
        list.add(new MyCustomDTO("폴란드", "폴란드 테스트", R.drawable.poland));
        list.add(new MyCustomDTO("폴란드", "폴란드 테스트", R.drawable.poland));

        listView = (ListView)findViewById(R.id.listView1);

        MyCustomAdapter adapter =
                new MyCustomAdapter(
                        getApplicationContext(),
                        R.layout.list_row,
                        list);

        listView.setAdapter(adapter);

    }

}
