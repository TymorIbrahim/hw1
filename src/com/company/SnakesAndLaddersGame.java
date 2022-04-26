package com.company;

public class SnakesAndLaddersGame {
    Die die;
    Player [] players = new Player[5];
    int player_count = 0;

    public SnakesAndLaddersGame (int min, int max){
        this.die = new Die(min, max);
    }

    public SnakesAndLaddersGame (){
        this.die = new Die();
    }

    public void initializeGame (){
        String input = "";
        while (input != "end"){
            input = Main.scanner.nextLine();
            String add_player = "add player ";
            if (input.contains(add_player)){
                String player_name = "";
                Color color = null;
                int i;
                for (i = add_player.length(); i < input.length(); i++){
                    while (input.charAt(i) != ' ') {
                        player_name += input.charAt(i);
                    }
                    break;
                }
                i++;
                String c = "";
                while (i < input.length()){
                   c += input.charAt(i);
                }
                if (c == "red"){
                    color = Color.Red;
                }
                if (c == "blue"){
                    color = Color.Blue;
                }
                if (c == "green"){
                    color = Color.Green;
                }
                if (c == "yellow"){
                    color = Color.Yellow;
                }
                if (c == "orange"){
                    color = Color.Orange;
                }
                Player new_player = new Player(player_name, color);
                players [player_count] = new_player;
                player_count++;
            }
        }
    }
}
