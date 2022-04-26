package com.company;

public class Die {
    int min;
    int max;

    public Die (int min, int max){
        this.min = min;
        this.max = max;
    }

    public Die (){
        this.min = 1;
        this.max = 6;
    }

    public int roll (){
        int result;
        result = Main.rnd.nextInt((max - min) + 1) + min;
        return result;
    }
}
