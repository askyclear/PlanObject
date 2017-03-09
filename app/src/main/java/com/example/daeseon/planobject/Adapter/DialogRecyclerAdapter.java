package com.example.daeseon.planobject.Adapter;


import android.os.Build;
import android.support.design.widget.CheckableImageButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.daeseon.planobject.DataModel.DialogColor;
import com.example.daeseon.planobject.R;

import java.util.List;

/**
 * Created by DaeSeon on 2017-03-09.
 * 컬러선택을 하기 위한 리사이클러뷰의 어댑터 부분.
 */

public class DialogRecyclerAdapter extends RecyclerView.Adapter<DialogRecyclerAdapter.ViewHolder> {
    private List<DialogColor> dialogColorList;
    private int itemLayout;
    private static int lastCheckedPosition = -1;

    //생성자
    public DialogRecyclerAdapter(List<DialogColor> items, int itemLayout, int colorPosition){
        this.dialogColorList = items;
        this.itemLayout = itemLayout;
        lastCheckedPosition = colorPosition;
    }

    @Override
    public DialogRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_dialogcolor,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DialogRecyclerAdapter.ViewHolder holder, int position) {
        DialogColor item = dialogColorList.get(position);
        holder.colorPick.setBackgroundResource(item.getColor());
        if(item.getChecked()==true) {
            item.setChecked(false);
            lastCheckedPosition = position;
        }
        if(position == lastCheckedPosition) {
            holder.butCheck.setChecked(true);
            holder.butCheck.setAlpha(0.99f);
        }else {
            holder.butCheck.setChecked(false);
            holder.butCheck.setAlpha(0.00f);
        }
    }

    @Override
    public int getItemCount() {

        return dialogColorList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView colorPick;
        public CheckableImageButton butCheck;

        public ViewHolder(View itemView) {
            super(itemView);
            colorPick=(ImageView)itemView.findViewById(R.id.color_pick);
            butCheck=(CheckableImageButton) itemView.findViewById(R.id.but_checked);
            butCheck.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogColor item = dialogColorList.get(getAdapterPosition());
                    item.setChecked(true);
                    lastCheckedPosition = getAdapterPosition();
                    dialogColorList.set(getAdapterPosition(),item);
                    notifyItemRangeChanged(0,dialogColorList.size());

                }
            });
        }
    }
    public int getLastCheckedPosition(){
        return lastCheckedPosition;
    }
}
