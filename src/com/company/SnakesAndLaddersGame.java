package com.company;

public class SnakesAndLaddersGame {
    Die die;
    Player [] players = new Player[5];
    int player_count = 0;
    static String add_player = "add player ";
    static String add_ladder = "add ladder ";
    static String add_snake = "add snake ";
    GameBoard Board = new GameBoard();
    Snake [] snakes = new Snake[100];
    Ladder [] ladders = new Ladder[100];
    final int max_num_of_players = 5;

    public boolean isLegalPlayer (Player player){
        if (player_count >= max_num_of_players){
            System.out.println("The maximal number of players is five !");
            return false;
        }
        if (!checkPlayersNames(player.getName())) {
            if (!checkPlayersColors(player.gamePiece.getColor())) {
                System.out.println("The name and the color are already taken!");
                return false;
            } else {
                System.out.println("The name is already taken!");
                return false;
            }
        }
        if(!checkPlayersColors(player.gamePiece.getColor())){
            System.out.println("The color is already taken!");
            return false;
        }
        return true;
    }

    public boolean checkPlayersColors (Color color){
        for (int i = 0; i < player_count; i++){
            if (players[i].gamePiece.getColor().equals(color))
                return false;
        }
        return true;
    }

    public boolean checkPlayersNames (String name){
        for (int i = 0; i < player_count; i++){
            if (players[i].getName().equals(name))
                return false;
        }
        return true;
    }

    public void addNewPlayer (String input){
        String new_player_name = getPlayerNameFromInput(input);
        Color new_player_color = getColorFromInput(input, new_player_name);
        Player new_player = new Player(new_player_name, new_player_color);
        if (isLegalPlayer(new_player)) {
            players[player_count] = new_player;
            player_count++;
        }
    }

    public SnakesAndLaddersGame (int min, int max){

        this.die = new Die(min, max);
    }

    public SnakesAndLaddersGame (){

        this.die = new Die();
    }


    public void initializeGame (){
        String input = "";
        while (!input.equals("end")){
            input = Main.scanner.nextLine();
            if (contains(input, add_player)){
                addNewPlayer(input);
            }
            if (contains(input, add_ladder)){
                int length = get_Length(input, add_ladder);
                int squareNumber = get_squareNumber(input);
                add_ladder(length, squareNumber);
            }
            if (contains(input, add_snake)){
                int length = get_Length(input, add_snake);
                int squareNumber = get_squareNumber(input);
                add_snake(length, squareNumber);
            }
            if(input.equals("end")){
                if (player_count < 2){
                    System.out.println("Cannot start the game, there are less than two players!");
                    input = "";
                }
            }
        }
        if (input == "end") {
            sort_players();
            start();
        }
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

    public void add_ladder(int length, int square_number){
        if (square_number > 100 || square_number < 1){
            System.out.println("The square is not within the board's boundaries!");
            return;
        }
        else if (square_number + length > 100) {
            System.out.println("The ladder is too long!");
            return;
        }
        else if (Board.gameBoard[square_number - 1].getFlag_for_ladder() == true){
            System.out.println("This square already contains a bottom of a ladder!");
            return;
        }
        else if (Board.gameBoard[square_number - 1].getFlag_for_snake() == true){
            System.out.println("This square contains a head of a snake!");
            return;
        }
        else {
            Board.gameBoard[square_number - 1].setFlag_for_ladder(true);
            ladders[square_number - 1] = new Ladder(square_number - 1, length);
        }
    }

    public void add_snake(int length, int square_number){
        if (square_number > 100 || square_number < 1){
            System.out.println("The square is not within the board's boundaries!");
            return;
        }
        else if (square_number - length < 0) {
            System.out.println("The snake is too long!");
            return;
        }
        else if (square_number == 100){
            System.out.println("You cannot add a snake in the last square");
        }
        else if (Board.gameBoard[square_number - 1].getFlag_for_ladder() == true){
            System.out.println("This square contains a bottom of a ladder!");
            return;
        }
        else if (Board.gameBoard[square_number - 1].getFlag_for_snake() == true){
            System.out.println("This square already contains a head of a snake!");
            return;
        }
        else {
            Board.gameBoard[square_number - 1].setFlag_for_snake(true);
            snakes[square_number - 1] = new Snake(square_number - 1, length);
        }
    }

    /**
     * This function extract the length of the ladder/snake from the input.
     * @param input
     * @param description
     * @return the length of the ladder/snake.
     */
    public int get_Length (String input, String description){
        char c;
        int length = 0;
        int i = description.length();
        while (input.charAt(i) != ' ') {
            c = input.charAt(i);
            length += (c - 48);
            length *= 10;
            i++;
        }
        return length / 10;
    }

    /**
     * This function extract the square number from the input.
     * @param input
     * @return the square number.
     */
    public int get_squareNumber (String input){
        int i = input.length() - 1;
        while(input.charAt(i) != ' '){
            i--;
        }
        i++;
        char c;
        int squareNumber = 0;
        while (i < input.length()) {
            c = input.charAt(i);
            squareNumber += (c - 48);
            squareNumber *= 10;
            i++;
        }
        return squareNumber / 10;
    }

    /**
     * This function sort the player alphabetically by their name.
     */
    public void sort_players(){
        String temp;
        for (int i = 0; i < player_count; i++) {
            for (int j = i + 1; j < player_count; j++) {

                // to compare one string with other strings
                if (players[i].getName().compareTo(players[j].getName()) > 0) {
                    // swapping
                    Color temp_color = players[i].gamePiece.color;
                    temp = players[i].getName();
                    players[i].setName(players[j].getName());
                    players[i].gamePiece.setColor(players[j].gamePiece.color);
                    players[j].setName(temp);
                    players[j].gamePiece.setColor(temp_color);
                }
            }
        }
    }

    /**
     * This function player the game, so she roll the dice for the player and do the calculation, move the player and prints his movement
     * and finally prints and player positions.
     * @return the winner name.
     */
    public String start(){
        int round = 1;
        while (true){
            if (!checkWinner().equals(""))
                return checkWinner();
            System.out.println("------------------------- Round number " + round + " -------------------------");
            for (int i = 0; i < player_count; i++){
                int player_square_num = players[i].gamePiece.square.getNum();
                int roll_num = die.roll();
                int new_square_num = checkmorethan100(roll_num, i);
                // if the new square number less than zero make the player move to square 1.
                if (new_square_num < 1){
                    new_square_num = 1;
                }
                System.out.print(players[i].getName() + " rolled " + roll_num + ". The path to the next square: " + player_square_num);
                System.out.print(" -> " + new_square_num);
                players[i].gamePiece.square.setNum(new_square_num);
                // check if there is any ladder or snake and make the moves, and print the movements.
                while ((checkLadderAndMove(new_square_num, i) != -1) || (checkSnakeAndMove(new_square_num) != -1)){
                    if (checkLadderAndMove(new_square_num, i) != -1)
                        new_square_num = checkLadderAndMove(new_square_num, i);
                    else
                        new_square_num = checkSnakeAndMove(new_square_num);
                    players[i].gamePiece.square.setNum(new_square_num);
                    System.out.print(" -> " + new_square_num);
                }
                System.out.println();
                players[i].gamePiece.setFirst_move(true);
                // if there is any player make his way to the 100 there is no need to continue.
                if (new_square_num == 100)
                    break;
            }
            System.out.println();
            System.out.println("Players positions on the board:");
            for (int j = 0; j < player_count; j++){
                System.out.println(players[j].getName() + " is in square number " + players[j].gamePiece.square.getNum());
            }
            round++;
        }
    }

    /**
     * This function check if there is any winner in the game.
     * @return the name of the winner.
     */
    public String checkWinner(){
        for (int i = 0; i < player_count; i++){
            if (players[i].gamePiece.square.getNum() == 100){
                return players[i].getName();
            }
        }
        return "";
    }

    /**
     * This function do the calculation for the player after he rolled the dice so how much should he move.
     * @param roll_num
     * @param index
     * @return the new square number that the player should go to.
     */
    public int checkmorethan100 (int roll_num, int index){
        int new_square_num = players[index].gamePiece.square.getNum() + roll_num;
        if (new_square_num <=100 )
            return new_square_num;
        else{
            return  new_square_num - 2*(new_square_num % 100);
        }
    }

    /**
     * This function check if the new square that the player want to move to is a bottom of ladder, and check if the ladder was in the
     * first square if he can climb on it.
     * @param new_square_num
     * @param index
     * @return where should the player go (if there is a ladder, to the tail) or return -1 if there is not a ladder.
     */
    public int checkLadderAndMove(int new_square_num, int index){
        // if the ladder was in the first square and the game piece of the player was moved before he can climb the ladder.
        if (new_square_num - 1  == 1 && Board.gameBoard[new_square_num - 1].flag_for_ladder && players[index].gamePiece.isFirst_move())
            return ladders[new_square_num - 1].top_square + 1;
        if (Board.gameBoard[new_square_num - 1].flag_for_ladder){
            return ladders[new_square_num - 1].top_square + 1;
        }
        return -1;
    }


    /**
     * This function check if the new square that the player want to move to is a head of snake.
     * @param new_square_num
     * @return the where should the player go (if there is a snake, to the tail) or return -1 if there is not a snake.
     */
    public int checkSnakeAndMove(int new_square_num){
        if (Board.gameBoard[new_square_num - 1].flag_for_snake){
            return snakes[new_square_num - 1].tail_square + 1;
        }
        return -1;
    }
}
