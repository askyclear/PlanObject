package com.example.daeseon.planobject.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.daeseon.planobject.R;
import com.example.daeseon.planobject.Adapter.TabPagerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by DaeSeon on 2017-03-07.
 * 생활계획표 메인 부분.
 */

public class LifeSchedularActivity extends FragmentActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FrameLayout frameLayout;
    private TextView dateLife,dateLife2,title_life;
    private Button addBut;
    private ImageView imageLife;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifeschedular);

        //오늘 날짜 set 부분
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat curMonthFormat = new SimpleDateFormat("M.d (EEE)");
        SimpleDateFormat curDayinyear = new SimpleDateFormat("D");
        String strDate  = curMonthFormat.format(date);
        String strDayinyear = curDayinyear.format(date);
        dateLife = (TextView)findViewById(R.id.date_life);
        dateLife2= (TextView)findViewById(R.id.date_life_second);
        title_life = (TextView)findViewById(R.id.title_life);
        dateLife.setText(strDate);

        //activity 종료 event
        imageLife = (ImageView)findViewById(R.id.image_life);
        imageLife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        frameLayout = (FrameLayout)findViewById(R.id.changed_frame);

        dateLife2.setText("365일 중 " + strDayinyear+"일 째\n");

        //view pager를 위한 tabLayout 생성 및 tab 추가 부분.
        tabLayout = (TabLayout)findViewById(R.id.sliding_tabs);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.ic_launcher),0);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.mipmap.ic_launcher_round),1);


        viewPager = (ViewPager)findViewById(R.id.pager_life);

        addBut = (Button)findViewById(R.id.addBut);

        //create TabpagerAdaper adapter
        TabPagerAdapter pagerAdapter = new TabPagerAdapter(this.getSupportFragmentManager(),tabLayout.getTabCount());

        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //Set TabSelectedListener
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition()==0){
                    title_life.setText("생활계획표");
                    title_life.setTextColor(0xFFFFFFFF);
                    tabLayout.setBackgroundColor(0xFFF44336);
                    // get the center for the clipping circle
                    int cx = (addBut.getLeft() + addBut.getRight()) / 2;
                    int cy = (addBut.getTop() + addBut.getBottom()) / 2;

                    // get the initial radius for the clipping circle
                    int initialRadius = addBut.getWidth();

                    // create the animation (the final radius is zero)
                    Animator anim =
                            ViewAnimationUtils.createCircularReveal(addBut, cx, cy, initialRadius, 0);

                    // make the view invisible when the animation is done
                    anim.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            addBut.setVisibility(View.INVISIBLE);
                        }
                    });

                    // start the animation
                    anim.start();
                    frameLayout.setBackgroundColor(0xFFF44336);
                }else{
                    title_life.setText("추가");
                    title_life.setTextColor(0xFF000000);
                    tabLayout.setBackgroundColor(0xFF4CAF50);
                    addBut.setVisibility(View.VISIBLE);
                    // get the center for the clipping circle
                    int cx = (addBut.getLeft() + addBut.getRight()) / 2;
                    int cy = (addBut.getTop() + addBut.getBottom()) / 2;

                    // get the final radius for the clipping circle
                    int finalRadius = Math.max(addBut.getWidth(), addBut.getHeight());

                    // create the animator for this view (the start radius is zero)
                    Animator anim =
                            ViewAnimationUtils.createCircularReveal(addBut, cx, cy, 0, finalRadius);

                    // make the view visible and start the animation
                    addBut.setVisibility(View.VISIBLE);
                    anim.start();
                    frameLayout.setBackgroundColor(0xFF4CAF50);
                }
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


}