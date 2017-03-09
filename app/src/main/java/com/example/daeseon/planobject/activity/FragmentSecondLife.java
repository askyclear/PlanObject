package com.example.daeseon.planobject.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.daeseon.planobject.DataModel.FragmentSecondData;
import com.example.daeseon.planobject.R;
import com.example.daeseon.planobject.Custom.LifeCustomDialog;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by DaeSeon on 2017-03-07.
 * 생활계획표의 2번째 추가 프레그먼트
 */

public class FragmentSecondLife extends Fragment {
    public Button addBut;
    public LifeCustomDialog mCustomDialog;
    private Realm mRealm;
    private List<FragmentSecondData> mList = new ArrayList<FragmentSecondData>();
    private RecyclerView recyclerView;
    private Random mRand;
    int size;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second_life,container,false);
        //Button 클릭을 통한 추가 dialog 화면을 show해주기 위한 부분
        findId();
        setEvent();
        setUpRealm();
        setUpRecyclerView();
        return view;
    }

    //id 찾기
    private void findId(){
        addBut = (Button)getActivity().findViewById(R.id.addBut);
        recyclerView = (RecyclerView)getActivity().findViewById(R.id.second_recycler);
    }

    //event
    private void setEvent(){
        mRand = new Random();
        addBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //customDialog를 호출해서 show해주는 부분.
                mCustomDialog = new LifeCustomDialog(view.getContext(),"제목","내용","추가","취소",
                            10,30,12,0,mRand.nextInt(19),bt1ClickListner,bt2ClickListner);
                mCustomDialog.show();
            }
        });
    }
    //Realm 초기화
    private void setUpRealm(){
        Realm.init(getContext());
        mRealm = Realm.getDefaultInstance();
        RealmResults<FragmentSecondData> dataList = getDataList();
        Toast.makeText(getActivity(), ">>>>> Data.size : " +dataList.size(), Toast.LENGTH_SHORT).show();
    }
    //data 정보 리스트 반환
    private RealmResults<FragmentSecondData> getDataList(){
        return mRealm.where(FragmentSecondData.class).findAll();
    }
    //setUpRecyclerView
    private void setUpRecyclerView() {

    }
    /*
     *bt2는 dialog 왼쪽 버튼 이벤트, bt1은 오른쪽 버튼 이벤트, 처음에는 추가하는 dialog 이지만
     *나중에 수정을 위한 dialog로도 활용 예정
     */
    private View.OnClickListener bt1ClickListner = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            /*
              dialog 내에서 event를 처리하지 않고 외부에서 한다면 customDialog.으로 찾아야함.
             */
            EditText editTitle = (EditText)mCustomDialog.findViewById(R.id.dialog_title);
            EditText editContent = (EditText)mCustomDialog.findViewById(R.id.dialog_content);
            TimePicker time_before = (TimePicker)mCustomDialog.findViewById(R.id.time_before);
            TimePicker time_after = (TimePicker)mCustomDialog.findViewById(R.id.time_after);
            RecyclerView dialog_recycler = (RecyclerView)mCustomDialog.findViewById(R.id.dialog_recycler);
            //저장 시작
            //mRealm.beginTransaction();
            mCustomDialog.getColorPosition();
            FragmentSecondData item = new FragmentSecondData();
            item.setTitle(editTitle.getText().toString());
            item.setContent(editContent.getText().toString());
            item.setBeforeHour(time_before.getCurrentHour());
            item.setBeforeMin(time_before.getCurrentMinute());
            item.setAfterHour(time_after.getCurrentHour());
            item.setAfterMin(time_after.getCurrentMinute());
            item.setColor(mCustomDialog.getColorPosition());
            mList.add(item);
            //mRealm.commitTransaction();
            //저장 종료
            mCustomDialog.dismiss();
            Toast.makeText(getActivity(), ">>>>> Data.size : " +mCustomDialog.getColorPosition(), Toast.LENGTH_SHORT).show();
        }
    };
    private View.OnClickListener bt2ClickListner = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            mCustomDialog.dismiss();
        }
    };
}
