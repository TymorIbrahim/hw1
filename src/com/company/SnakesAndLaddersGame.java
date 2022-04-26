package com.company;

public class SnakesAndLaddersGame {
    Die die;
    Player [] players = new Player[5];
    int player_count = 0;
    static String add_player = "add player ";

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
}
