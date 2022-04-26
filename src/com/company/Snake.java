package com.company;

public class Snake {
    Square head;
    Square tail;

    public Snake (int head, int length){
        this.head = new Square(head);
        this.head.setFlag(true);
        this.tail = new Square(head + length);
        this.tail.setFlag(true);
    }
}
