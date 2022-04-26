package com.company;

public class GamePiece {
    Color color;
    Square square;

    public GamePiece (Color color){
        this.color = color;
        this.square = new Square(1);
    }
    public GamePiece(){
        this.color= Color.NULL;
        this.square = null;
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
