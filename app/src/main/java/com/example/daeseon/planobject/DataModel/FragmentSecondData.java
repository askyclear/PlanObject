package com.example.daeseon.planobject.DataModel;

import java.util.concurrent.atomic.AtomicInteger;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by DaeSeon on 2017-03-09.
 * frgmentlife second에 들어갈 recycler에 data 개체 형식들.DB 개체 형식으로 봐도 됨;
 */

public class FragmentSecondData extends RealmObject {
    private String title;
    private String content;
    private int beforeHour, beforeMin,afterHour,afterMin;
    private int color;
    @PrimaryKey
    private long id;
    //입력부분
    public void setId(long id){
        this.id = id;
    }
    public void setColor(int color){
        this.color = color;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setContent(String content){
        this.content = content;
    }
    public void setBeforeHour(int beforeHour){
        this.beforeHour = beforeHour;
    }
    public void setBeforeMin(int beforeMin){
        this.beforeMin = beforeMin;
    }
    public void setAfterHour(int afterHour){
        this.afterHour = afterHour;
    }
    public void setAfterMin(int afterMin){
        this.afterMin = afterMin;
    }

    //출력 부분
    public String getTitle(){
        return title;
    }
    public String getContent(){
        return content;
    }
    public int getBeforeHour(){
        return beforeHour;
    }
    public int getBeforeMin(){
        return beforeMin;
    }
    public int getAfterHour(){
        return afterHour;
    }
    public int getAfterMin(){
        return afterMin;
    }
    public int getColor(){
        return color;
    }
    public long getId(){
        return id;
    }
}
