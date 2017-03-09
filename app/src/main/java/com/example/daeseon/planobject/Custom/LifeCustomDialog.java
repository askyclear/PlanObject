package com.example.daeseon.planobject.Custom;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.daeseon.planobject.Adapter.DialogRecyclerAdapter;
import com.example.daeseon.planobject.DataModel.DialogColor;
import com.example.daeseon.planobject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DaeSeon on 2017-03-08.
 * customdialog를 만들기 위해 dialog를 상속받음.
 */

public class LifeCustomDialog extends Dialog {

    private EditText dialog_title,dialog_content;
    private TimePicker time_before,time_after;
    private Button dialog_bt1,dialog_bt2;
    private String title,content,bt1str,bt2str;
    private int before_hour,before_min,after_hour,after_min,colorPosition;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private  List<DialogColor> list;
    private int [] color = {R.color.red,R.color.pink,R.color.purple,
                                R.color.deep_purple, R.color.indigo,R.color.blue,
                                R.color.light_blue, R.color.cyan, R.color.teal,
                                R.color.green,R.color.light_green,R.color.lime,R.color.yellow,
                                R.color.amber,R.color.orange,R.color.deep_orange,R.color.brown,
                                R.color.grey, R.color.blue_grey};

    private DialogRecyclerAdapter mAdapter;
    private View.OnClickListener bt1ClickListener;
    private View.OnClickListener bt2ClickListener;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //dialog 외부화면 흐리게 표현 안써도 됨
        WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
        lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        lpWindow.dimAmount = 0.8f;
        getWindow().setAttributes(lpWindow);
        //dialog화면을 set 해줌.
        setContentView(R.layout.customdialog);
        //각종 위젯 셋팅 부분.
        findId();
        setDialogEvent();


    }
    private void findId(){
        dialog_title = (EditText) findViewById(R.id.dialog_title);
        dialog_content = (EditText) findViewById(R.id.dialog_content);
        time_before = (TimePicker) findViewById(R.id.time_before);
        time_after = (TimePicker) findViewById(R.id.time_after);
        dialog_bt1 = (Button)findViewById(R.id.dialog_bt1);
        dialog_bt2 = (Button)findViewById(R.id.dialog_bt2);
        recyclerView = (RecyclerView)findViewById(R.id.dialog_recycler);
    }
    //초기 설정.
    private void setDialogEvent(){
        time_before.setCurrentHour(before_hour);
        time_before.setCurrentMinute(before_min);

        time_after.setCurrentHour(after_hour);
        time_after.setCurrentMinute(after_min);
        time_after.setIs24HourView(true);
        time_before.setIs24HourView(true);
        dialog_title.setText(title);
        dialog_content.setText(content);

        dialog_bt1.setText(bt1str);
        dialog_bt2.setText(bt2str);
        dialog_bt1.setOnClickListener(bt1ClickListener);
        dialog_bt2.setOnClickListener(bt2ClickListener);

        setColorList();
        mAdapter = new DialogRecyclerAdapter(list,R.layout.recyclerview_dialogcolor,colorPosition);
        recyclerView.setAdapter(mAdapter);
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        layoutManager.scrollToPosition(colorPosition);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    private void setColorList(){
        list = new ArrayList<DialogColor>();
        for(int i=0; i<color.length; i++) {
            DialogColor dialogColor = new DialogColor();
            if (i == colorPosition){
                dialogColor.setColor(color[i]);
                dialogColor.setChecked(true);
            }else{
                dialogColor.setColor(color[i]);
                dialogColor.setChecked(false);
            }
            list.add(dialogColor);
        }
    }
    //생성자 입력 부분 및 전역 변수 셋팅
    public LifeCustomDialog(Context context, String title, String content, String bt1str, String bt2str,
                            int before_hour, int before_min, int after_hour, int after_min, int colorPosition,
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
        this.colorPosition = colorPosition;
    }
    //Current Adapter에서 Check한 Color 의 포지션 값을 가져오기 위해.
    public int getColorPosition(){
        return colorPosition = mAdapter.getLastCheckedPosition();
    }
}
