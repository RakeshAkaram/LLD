package tictactoe;

public class Board {
    private Integer size;
    private Symbol[][] board;

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Symbol[][] getBoard() {
        return board;
    }

    public void setBoard(Symbol[][] board) {
        this.board = board;
    }
    public void createBoard(){
        board = new Symbol[size][size];
    }
    public void printBoard(){
        if(board!=null){

            for(int i=0; i<size; i++){
                for(int j=0; j<size; j++){
                    if(board[i][j]==null)
                        System.out.print("   "+"|");
                    else
                        System.out.print(" "+board[i][j].getSymbolDesign()+" |");
                }
                System.out.println();
            }
        }
    }
    public boolean isValidMove(int row, int col){
        if(board!=null && board[row][col]==null )
            return true;
        return false;
    }
    public void makeMove(int row, int column, Symbol symbol){
        board[row][column] = symbol;
    }
    public boolean checkWin(int row, int col){
        int r = row;
        int c = col;
        String symbol = board[r][c].getSymbolDesign();
        //row wise
        int count=size;
        for(int j=0; j<size;j++){
            if(board[r][j]!=null && board[r][j].getSymbolDesign().equals(symbol))
                count--;
            else
                break;
        }
        if(count == 0) return true;
        //colm wise
        count=size;
        for(int j=0; j<size;j++){
            if(board[j][c]!=null && board[j][c].getSymbolDesign().equals(symbol))
                count--;
            else
                break;
        }
        if(count == 0) return true;
        //Right diagonal
        count=size;
        r=0;
        c=0;
        for(int j=0; j<size;j++){
            if(board[r+j][c+j]!=null && board[r+j][c+j].getSymbolDesign().equals(symbol))
                count--;
            else
                break;
        }
        if(count == 0) return true;
        //Left diagonal
        count=size;
        r=size-1;
        c=0;
        for(int j=0; j<size;j++){
            if(board[r-j][c+j]!=null && board[r-j][c+j].getSymbolDesign().equals(symbol))
                count--;
            else
                break;
        }
        if(count == 0) return true;
        return false;
    }
    //Also called tie
    public boolean isBoardFull(){
        for(int i=0; i<size;i++)
            for(int j=0; j<size; j++)
                if(board[i][j]==null)
                    return  false;
        return true;
    }
}
