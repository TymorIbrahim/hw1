package com.company;

public class GamePiece {
    Color color;
    Square square;
    boolean first_move;

    public GamePiece (Color color){
        this.color = color;
        this.square = new Square(1);
        this.first_move = false;
    }
    public GamePiece(){
        this.color= Color.NULL;
        this.square = null;
        this.first_move = false;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Square getSquare() {
        return square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    @Override
    public String toString() {
        return "GamePiece{" +
                "color=" + color +
                '}';
    }
}
