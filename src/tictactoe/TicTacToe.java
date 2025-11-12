package tictactoe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Establish the board
        System.out.println("Great to Have you here for this Game. This game will undergo in 3 stage\n 1. Establish the board \n 2. Register Players \n 3. Play starts");
        System.out.println("Can you enter the size of the board");
        int size = scanner.nextInt();
        Board board = new Board();
        board.setSize(size);
        board.createBoard();
        board.printBoard();
        //Register Players with symbols
        Symbol symbol1 = new Symbol("X", "X");
        Symbol symbol2 = new Symbol("O","O");
        Player player1=new Player("Ravi",symbol1);
        Player player2 = new Player("Sharan", symbol2);

        //play the game
        int turnOfPlayer = 1;
        boolean winner  = false;
        while(!board.isBoardFull()){
            Player player = (turnOfPlayer==1)?player1:player2;
            System.out.println(player.getName()+" can you select the position");
            String[] index = scanner.next().split(",");
            int row = Integer.parseInt(index[0]);
            int col = Integer.parseInt(index[1]);
            if(row<0 || row>size || col<0 || col>size){
                System.out.println("ERROR: Invalid input. Please check the input bound");
                continue;
            }
            if(board.isValidMove(row,col)){
                board.makeMove(row,col,player.getSymbol());
                board.printBoard(); // As a Status of the match
                if(board.checkWin(row,col)){
                    System.out.println(player.getName()+" is the Winner. Congratulation!!! ");
                    winner=true;
                    break;
                }
                turnOfPlayer =  (turnOfPlayer==1) ? 2:1;
            }
            else{
                System.out.println("ERROR: Move is invalid. Please, try another position");
                continue;
            }
        }
        if(!winner)
            System.out.println("Well Played!! This game is a Tie");
    }
}
