package com.company;

public class Ladder {
    int base_square;
    int top_square;

    public Ladder (int base, int length){
        this.base_square = base;
        this.top_square = base + length;
    }

    public Ladder(){
        this.base_square = 0;
        this.top_square = 0;
    }

    public int getBase_square() {
        return base_square;
    }

    public int getTop_square() {
        return top_square;
    }

    public void setBase_square(int base_square) {
        this.base_square = base_square;
    }

    public void setTop_square(int top_square) {
        this.top_square = top_square;
    }
}

