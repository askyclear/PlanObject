package com.example.daeseon.planobject.activity;

import android.app.Activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.daeseon.planobject.R;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.realm.Realm;

/**
 * Created by DaeSeon on 2017-03-07.
 * 첫번째 메인 엑티비티.
 */

public class FirstActivity extends Activity {
    private TextView title_tv;
    private Button but1,but2,but3,but4,but5,but6;
    private Realm mRealm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Realm.init(getApplicationContext());
        title_tv = (TextView) findViewById(R.id.title_tv);
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat CurYearFormat = new SimpleDateFormat("yyyy");
        String strCurYear = CurYearFormat.format(date);
        title_tv.setText(strCurYear);

        BtnOnClickListener btnClick = new BtnOnClickListener();
        but1 = (Button) findViewById(R.id.but1);
        but2 = (Button) findViewById(R.id.but2);
        but3 = (Button) findViewById(R.id.but3);
        but4 = (Button) findViewById(R.id.but4);
        but5 = (Button) findViewById(R.id.but5);
        but6 = (Button) findViewById(R.id.but6);
        but1.setText("생활계획표");
        but1.setOnClickListener(btnClick);
        but2.setOnClickListener(btnClick);
        but3.setOnClickListener(btnClick);
        but4.setOnClickListener(btnClick);
        but5.setOnClickListener(btnClick);
        but6.setOnClickListener(btnClick);
    }

    private class BtnOnClickListener implements Button.OnClickListener {
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.but1:
                    Intent intent = new Intent(FirstActivity.this,LifeSchedularActivity.class);
                    startActivity(intent,ActivityOptions.makeSceneTransitionAnimation(FirstActivity.this).toBundle());
                    break;
                case R.id.but2:
                    break;
                case R.id.but3:
                    break;
                case R.id.but4:
                    break;
                case R.id.but5:
                    break;
                case R.id.but6:
                    break;
            }
        }
    }
}
