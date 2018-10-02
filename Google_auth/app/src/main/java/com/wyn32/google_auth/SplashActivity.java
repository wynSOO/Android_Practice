package com.wyn32.google_auth;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // splash 는 App 이 실행되면서
        // 초기화, 데이터로딩 등을 실행하는 과정에
        // 딜레이가 발생할때
        // 사용자에게 잠시 기다리라는 의미
        // 여기에 초기화 코드가 추가되면
        // splash 화면이 잠시, 길게 나타났다가
        // MainActivity를 호출 하도록 되어 있다.

        Intent main = new Intent(SplashActivity.this,MainActivity.class);
        startActivity(main);

        // 나는 그만 사라진다.
        for(int i = 0; i<10000 ; i++);
        finish();
    }


}
