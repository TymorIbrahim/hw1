package com.company;

public class SnakesAndLaddersGame {
    Die die;
    Player [] players = new Player[5];
    int player_count = 0;
    static String add_player = "add player ";
    int max_num_of_players = 5;

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

    public String getPlayerNameFromInput (String input){
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

    public boolean isLegalPlayer (Player player){
        if (player_count >= max_num_of_players){
            System.out.println("The maximal number of players is five !");
            return false;
        }
        for (int i = 0; i < player_count; i++) {
            if (player.getName().equals(players[i].getName())) {
                if (player.getGamePiece().getColor().equals(players[i].getGamePiece().getColor())) {
                    System.out.println("The name and the color are already taken!");
                    return false;
                } else {
                    System.out.println("The name is already taken!");
                    return false;
                }
            }
            else if(player.getGamePiece().getColor().equals(players[i].getGamePiece().getColor())){
                System.out.println("The color is already taken!");
                return false;
            }
        }
        return true;
    }

    public void addNewPlayer (String input){
        String new_player_name = getPlayerNameFromInput(input);
        Color new_player_color = getColorFromInput(input, new_player_name);
        Player new_player = new Player(new_player_name, new_player_color);
        if (isLegalPlayer(new_player)) {
            System.out.println("player added");
            players[player_count] = new_player;
            player_count++;
        }
    }

    public void initializeGame (){
        String input = "";
        while (!input.equals("end")){
            input = Main.scanner.nextLine();
            if (contains(input, add_player)){
                addNewPlayer(input);
            }
            if(input.equals("end")){
                if (player_count < 2){
                    System.out.println("Cannot start the game, there are less then two players!");
                    input = "";
                }
            }
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
