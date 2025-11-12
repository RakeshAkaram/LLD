package snakeNLadder;
import java.util.*;

public class Game {
    private static int[] board;
    //private Board board;
    private static  Integer noOfPlayers;
    private static Deque<Player> players;
    private static Dice dice;
    private static Deque<Player> printDeque = new ArrayDeque<>();

    public static void main(String[] args) {
        //board
        initializeBoard();
        //Dice
        int maxValue=6;
        dice = new Dice();
        dice.setMaxValue(maxValue);
        //snakeNLadder
        Map<Integer,Integer> snakeNLadderMap = fetchData();
        //Register players
        players = registerPlayers();
        StringBuilder header = new StringBuilder("\t");
        for(Player player:players){
            header.append(player.getName()).append("\t");
        }
        System.out.println(header);
        startPlay(snakeNLadderMap);

    }
    public static void initializeBoard(){
        //Input
        Integer boardSize = 100;
        board= new int[boardSize+1];
        //this.board = new Board();
    }

    private static Map<Integer,Integer> fetchData() {
        Map<Integer,Integer> ladderData =  new HashMap<>();
        ladderData.put(1,38);
        ladderData.put(4,14);
        ladderData.put(9,31);
        ladderData.put(21,42);
        ladderData.put(28,84);
        ladderData.put(51,67);
        ladderData.put(72,91);
        ladderData.put(80,99);
        ladderData.put(17,7);
        ladderData.put(54,34);
        ladderData.put(62,19);
        ladderData.put(64,60);
        ladderData.put(87,36);
        ladderData.put(93,73);
        ladderData.put(95,75);
        ladderData.put(98,79);
        return ladderData;
    }

    public static void startPlay(Map<Integer, Integer> snakeNLadderMap){
        Deque<Player> winnersQ = new ArrayDeque<>();
        while(players.size()>1){
            boolean playerWon =false;
            Player playerPlaying = players.getFirst();
            int valueShown = dice.rollDice(playerPlaying.getName());
            if(valueShown==0) {
                System.out.println("Game was discontinued");
                break;
            }

            int position = playerPlaying.getPosition()+valueShown;
            int finalValue = board.length-1;
            if(position==finalValue){
                playerPlaying.setPosition(position);
                winnersQ.addLast(playerPlaying);
                players.removeFirst();
                playerWon = true;
            }
            else if(position<finalValue){
                playerPlaying.setPosition(position);
            }
            Integer isSnakeorLadder = snakeNLadderMap.get(playerPlaying.getPosition());
            if(isSnakeorLadder!=null)
                playerPlaying.setPosition(isSnakeorLadder);
            //Dice value logic
            //System.out.println("Player "+playerPlaying.getName()+" at: "+playerPlaying.getPosition());
            displayPosition();
            if(!dice.isSix()){
                if(!playerWon){
                    players.addLast(playerPlaying);
                    players.removeFirst();
                }
            }else{
                if(!playerWon){
                 System.out.println("Player "+playerPlaying.getName()+" gets another chances");
                }
            }
            //
        }
        // Winners Declaration code:
        int ranking = 1;
        for(Player player:winnersQ){
            System.out.println("Ranking");
            System.out.println(ranking+". "+player.getName()+" at position:" +player.getPosition());
            ranking++;
        }
    }

    private static void displayPosition() {
        StringBuilder header = new StringBuilder("\t");
        for(Player player:printDeque){
            header.append(player.getPosition()).append("\t");
        }
        System.out.println(header);
    }

    public static Deque<Player> registerPlayers(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Number of player:");
        noOfPlayers = scanner.nextInt();
        int maxPlayer = noOfPlayers;
        Deque<Player> playerDeque = new ArrayDeque<>();
        while(maxPlayer>0){
            System.out.println("Enter the name of the player:");
            String name = scanner.next();
            Player player = new Player(name,0);
            playerDeque.addLast(player);
            printDeque.addLast(player);
            maxPlayer--;
        }
        return playerDeque;
    }


}
