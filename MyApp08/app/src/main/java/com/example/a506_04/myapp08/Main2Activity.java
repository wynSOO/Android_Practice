package com.example.a506_04.myapp08;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView txtView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtView1=findViewById(R.id.txtView1);

        // MainActivity에서 전달한(putExtra) 값을 받기 위해서
        // 자신의 intent(i)를 추출
        Intent myIntent = getIntent();


        // 자신의 intent로 부터 값들을 추출
        String txtName = myIntent.getExtras().getString("name");
        txtName = myIntent.getStringExtra("name");

        int age = myIntent.getExtras().getInt("age");
        age = myIntent.getIntExtra("age",0);

        String txtTel = myIntent.getExtras().getString("tel");
        txtTel = myIntent.getStringExtra("tel");

        txtView1.setText(txtName + "\n"+ age + "\n"+ txtTel);

    }
}
