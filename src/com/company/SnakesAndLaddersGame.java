package com.company;

public class SnakesAndLaddersGame {
    Die die;
    Player [] players = new Player[5];
    int player_count = 0;
    static String add_player = "add player ";
    GameBoard Board = new GameBoard();
    Snake [] snakes = new Snake[100];
    Ladder [] ladders = new Ladder[100];

    public SnakesAndLaddersGame (int min, int max){

        this.die = new Die(min, max);
    }

    public SnakesAndLaddersGame (){

        this.die = new Die();
    }

    public boolean contains(String input, String target){
        for (int i = 0; i < target.length(); i++){
            if (input.charAt(i) != target.charAt(i))
                return false;
        }
        return true;
    }

    String getPlayerNameFromInput (String input){
        String player_name = "";
        int i = add_player.length();
        while (input.charAt(i) != ' ') {
            player_name += input.charAt(i);
            i++;
        }
        return player_name;
    }

    public Color getColorFromInput (String input, String name){
        String c = "";
        int i = add_player.length() + name.length() + 1;
        while (i < input.length()){
            c += input.charAt(i);
            i++;
        }
        Color color = Color.NULL;
        if (c.equals("red")){
            color = Color.Red;
        }
        if (c.equals("blue")){
            color = Color.Blue;
        }
        if (c.equals("green")){
            color = Color.Green;
        }
        if (c.equals("yellow")){
            color = Color.Yellow;
        }
        if (c.equals("orange")){
            color = Color.Orange;
        }
        return color;
    }

    public void initializeGame (){
        String input = Main.scanner.nextLine();
        while (!input.equals("end")){
            //System.out.println("player added 1");
            if (contains(input, add_player)){
                System.out.println("player added");
                String new_player_name = getPlayerNameFromInput(input);
                Color new_player_color = getColorFromInput(input, new_player_name);
                Player new_player = new Player(new_player_name, new_player_color);
                players [player_count] = new_player;
                player_count++;
            }
            input = Main.scanner.nextLine();
        }
        if (input.equals("end")) {
            System.out.println("end of input");
            int i = 0;
            for (i = 0; i < player_count; i++) {
                System.out.println(players[i].getName() + "--" + players[i].getGamePiece().toString());
            }
        }
    }

    public void add_ladder(int length, int square_number){
        if (square_number > 100 || square_number < 1){
            System.out.println("The square is not within the board's boundaries!");
            return;
        }
        if (square_number + length > 100) {
            System.out.println("The ladder is too long!");
            return;
        }
        if (Board.gameBoard[square_number].getFlag_for_ladder() == true){
            System.out.println("This square already contains a bottom of a ladder!");
            return;
        }
        if (Board.gameBoard[square_number].getFlag_for_snake() == true){
            System.out.println("This square contains a head of a snake!");
            return;
        }
        Board.gameBoard[square_number].setFlag_for_snake(true);
        Board.gameBoard[square_number].setFlag_for_ladder(true);
        int i = 0;
        while (ladders[i].base_square != 0){
            i++;
        }
        ladders[i] = new Ladder(square_number, length);
    }

    public void add_snake(int length, int square_number){
        if (square_number > 100 || square_number < 1){
            System.out.println("The square is not within the board's boundaries!");
            return;
        }
        if (square_number - length < 0) {
            System.out.println("The ladder is too long!");
            return;
        }
        if (square_number == 100){
            System.out.println("You cannot add a snake in the last square");
        }
        if (Board.gameBoard[square_number].getFlag_for_ladder() == true){
            System.out.println("This square contains a bottom of a ladder!");
            return;
        }
        if (Board.gameBoard[square_number].getFlag_for_snake() == true){
            System.out.println("This square already contains a head of a snake!");
            return;
        }
        Board.gameBoard[square_number].setFlag_for_snake(true);
        Board.gameBoard[square_number].setFlag_for_ladder(true);
        int i = 0;
        while (snakes[i].head_square != 0){
            i++;
        }
        snakes[i] = new Snake(square_number, length);
    }
}
