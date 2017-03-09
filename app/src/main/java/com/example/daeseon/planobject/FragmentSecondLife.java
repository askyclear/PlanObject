package com.example.daeseon.planobject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by DaeSeon on 2017-03-07.
 */

public class FragmentSecondLife extends Fragment {
    public Button addBut;
    public LifeCustomDialog mCustomDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second_life,container,false);

        addBut = (Button)getActivity().findViewById(R.id.addBut);
        addBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCustomDialog = new LifeCustomDialog(view.getContext(),"제목","내용","추가","취소",10,30,12,0,bt1ClickListner,bt2ClickListner);
                mCustomDialog.show();
            }
        });
        return view;
    }
    private View.OnClickListener bt1ClickListner = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            mCustomDialog.dismiss();
        }
    };
    private View.OnClickListener bt2ClickListner = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            mCustomDialog.dismiss();
        }
    };
}
