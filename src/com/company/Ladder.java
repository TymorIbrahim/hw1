package com.company;

public class Ladder {
    int base_square;
    int top_square;

    /**
     * Construction.
     * @param base
     * @param length
     */
    public Ladder (int base, int length){
        this.base_square = base;
        this.top_square = base + length;
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

