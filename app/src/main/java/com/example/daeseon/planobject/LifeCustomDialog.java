package com.example.daeseon.planobject;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

/**
 * Created by DaeSeon on 2017-03-08.
 */

public class LifeCustomDialog extends Dialog {

    public EditText dialog_title,dialog_content;
    public TimePicker time_before,time_after;
    public Button dialog_bt1,dialog_bt2;
    public String title,content,bt1str,bt2str;
    public int before_hour,before_min,after_hour,after_min;

    public View.OnClickListener bt1ClickListener;
    public View.OnClickListener bt2ClickListener;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //dialog 외부화면 흐리게 표현 안써도 됨
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);

        setContentView(R.layout.customdialog);

        dialog_title = (EditText) findViewById(R.id.dialog_title);
        dialog_content = (EditText) findViewById(R.id.dialog_content);
        time_before = (TimePicker) findViewById(R.id.time_before);
        time_before.setCurrentHour(before_hour);
        time_before.setCurrentMinute(before_min);
        time_after = (TimePicker) findViewById(R.id.time_after);
        time_after.setCurrentHour(after_hour);
        time_after.setCurrentMinute(after_min);
        time_after.setIs24HourView(true);
        time_before.setIs24HourView(true);
        dialog_title.setText(title);
        dialog_content.setText(content);
        dialog_bt1 = (Button)findViewById(R.id.dialog_bt1);
        dialog_bt2 = (Button)findViewById(R.id.dialog_bt2);
        dialog_bt1.setText(bt1str);
        dialog_bt2.setText(bt2str);
        dialog_bt1.setOnClickListener(bt1ClickListener);
        dialog_bt2.setOnClickListener(bt2ClickListener);

    }

    public LifeCustomDialog(Context context, String title, String content, String bt1str, String bt2str,
                            int before_hour,int before_min, int after_hour, int after_min,
                            View.OnClickListener bt1ClickListener, View.OnClickListener bt2ClickListener){
        super(context);
        this.title = title;
        this.content = content;
        this.bt1str = bt1str;
        this.bt2str = bt2str;
        this.before_hour = before_hour;
        this.before_min = before_min;
        this.after_hour = after_hour;
        this.after_min = after_min;
        this.bt1ClickListener = bt1ClickListener;
        this.bt2ClickListener = bt2ClickListener;
    }
}
