package com.example.daeseon.planobject.DataModel;

/**
 * Created by DaeSeon on 2017-03-09.
 * 컬러 데이타 정보
 */

public class DialogColor {
        private int color;
        private boolean checked;
        public void setChecked(boolean checked){
            this.checked = checked;
        }
        public void setColor(int color){
            this.color = color;
        }
        public boolean getChecked(){
            return checked;
        }
        public int getColor(){
            return color;
        }
}
