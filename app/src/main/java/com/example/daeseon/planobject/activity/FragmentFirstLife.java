package com.example.daeseon.planobject.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.daeseon.planobject.R;

/**
 * Created by DaeSeon on 2017-03-07.
 * 생활계획표의 첫번째 프레그먼트.
 * canvas를 사용한 원형 시간표를 그리는 화면
 */

public class FragmentFirstLife extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first_life,container,false);
        return view;
    }
}
