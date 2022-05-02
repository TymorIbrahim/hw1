package com.company;

public class Die {
    int min;
    int max;

    /**
     * Construction.
     * @param min
     * @param max
     */
    public Die (int min, int max){
        this.min = min;
        this.max = max;
    }

    /**
     * Construction. (for the default situation)
     */
    public Die (){
        this.min = 1;
        this.max = 6;
    }

    /**
     * This function roll a die randomly.
     * @return the number that rolled.
     */
    public int roll (){
        int result;
        result = Main.rnd.nextInt((max - min) + 1) + min;
        return result;
    }
}
