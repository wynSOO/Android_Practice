package com.biz.myapp05;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton bt = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = findViewById(R.id.fab);

        // 정의된 이벤트를 설정(등록)
        bt.setOnClickListener(new BtAction());
    }

    // 이벤트 정의
    class BtAction implements View.OnClickListener{

        // fad 버튼을 클릭하면 실행된 method
        @Override
        public void onClick(View view) {
            Toast t = Toast.makeText(MainActivity.this,
                    "안녕하세요",
                    Toast.LENGTH_LONG);
            t.show();

            // 안드로이드 폰은 PC에 비해 용량이 작아서 최대한 변수를 안만드는것이 좋다.
            // class chaining 이라고 한다.
            Toast.makeText(MainActivity.this,"또다른토스트",Toast.LENGTH_LONG).show();

        }
    }


}
