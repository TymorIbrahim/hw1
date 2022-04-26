package com.company;

public class Player {
    String name;
    GamePiece gamePiece;

    public Player (String name, Color color){
        this.name = name;
        this.gamePiece = new GamePiece(color);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GamePiece getGamePiece() {
        return gamePiece;
    }

    public void setGamePiece(GamePiece gamePiece) {
        this.gamePiece = gamePiece;
    }
}
