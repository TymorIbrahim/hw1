package com.company;

public class Ladder {
    Square base;
    Square top;

    public Ladder (int base, int length){
        this.base = new Square(base);
        this.base.setFlag(true);
        this.top = new Square(base + length);
        this.top.setFlag(true);
    }
}
