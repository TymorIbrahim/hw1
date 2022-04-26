package com.company;

public class Square {
    int num;
    boolean flag;

    public Square (int num){
        this.num = num;
        this.flag = false;
    }

    public boolean isFlag() {
        return flag;
    }

    public int getNum() {
        return num;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean equals (Square square){
        if (this.num == square.num)
            return true;
        else return false;
    }
}
