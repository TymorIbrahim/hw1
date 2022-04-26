package com.company;

public class Square {
    int num;
    boolean flag_for_ladder;
    boolean flag_for_snake;

    public Square (int num){
        this.num = num;
        this.flag_for_ladder = false;
        this.flag_for_snake = false;
    }

    public boolean getFlag_for_ladder() {
        return flag_for_ladder;
    }

    public boolean getFlag_for_snake() {
        return flag_for_snake;
    }

    public int getNum() {
        return num;
    }

    public void setFlag_for_ladder(boolean flag) {
        this.flag_for_ladder = flag;
    }

    public void setFlag_for_snake(boolean flag) {
        this.flag_for_snake = flag;
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
