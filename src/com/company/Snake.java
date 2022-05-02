package com.company;

public class Snake {
    int head_square;
    int tail_square;

    /**
     * Construction.
     * @param head
     * @param length
     */
    public Snake (int head, int length){
        this.head_square = head;
        this.tail_square = head - length;
    }

    public int getHead_square() {
        return head_square;
    }

    public int getTail_square() {
        return tail_square;
    }

    public void setHead_square(int head_square) {
        this.head_square = head_square;
    }

    public void setTail_square(int tail_square) {
        this.tail_square = tail_square;
    }
}
