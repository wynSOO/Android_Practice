package app.biz.drawerlayout_2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnOpen;
    Button btnClose;
    CheckBox chk_lock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnOpen = findViewById(R.id.btn_open);
        btnClose = findViewById(R.id.btn_close);
        chk_lock = findViewById(R.id.chk_lock);

        chk_lock.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawerLayout dr = findViewById(R.id.drawer);
                CheckBox checkBox = (CheckBox)v;

                if(checkBox.isChecked()){
                    if(dr.isDrawerOpen(Gravity.LEFT)){

                        // Content 영역을 터치했을 때 Drawer가 사라지지 않도록
                        dr.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN);
                    }else {

                        // 화면 가장자리를 쓸어 넘길 때 Drawer가 나타나지 않도록
                        dr.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
                    }
                }else{
                    // Lock 해제
                    // 쓸어넘겨서 Drawer 나타나거나, 사라지도록
                    dr.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                }
            }
        });
        btnOpen.setOnClickListener(this);
        btnClose.setOnClickListener(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id==R.id.btn_open){

            // Gravity.START, Gravity.LEFT 항목을 열기 위해서는
            // xml에 해당하는 layout_gravity="start"가 선언되어 있어야 한다.
            DrawerLayout dr = findViewById(R.id.drawer);
            if(!dr.isDrawerOpen(Gravity.START)){
                dr.openDrawer(Gravity.START);
            }

            // Gravity.START, Gravity.end 항목을 열기 위해서는
            // xml에 해당하는 layout_gravity="end"가 선언되어 있어야 한다.
            if(!dr.isDrawerOpen(Gravity.END)){
                dr.openDrawer(Gravity.END);
            }
        }
        if(id==R.id.btn_close){
            DrawerLayout dr = findViewById(R.id.drawer);
            if(dr.isDrawerOpen(Gravity.START)){
                dr.closeDrawer(Gravity.START);
            }
            if(dr.isDrawerOpen(Gravity.END)){
                dr.closeDrawer(Gravity.END);
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
