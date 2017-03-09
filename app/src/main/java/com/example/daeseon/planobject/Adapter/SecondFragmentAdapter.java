package com.example.daeseon.planobject.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.daeseon.planobject.DataModel.FragmentSecondData;

/**
 * Created by DaeSeon on 2017-03-09.
 * Fragment RecyclerView 어댑터 부분. item은 구현 완료. 안에 ViewHolder와 Bind 등을 구현하자.
 */

public class SecondFragmentAdapter extends RecyclerView.Adapter<SecondFragmentAdapter.ViewHolder> {



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
