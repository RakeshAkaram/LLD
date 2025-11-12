package tictactoe;

public class Symbol {
    private String symbolDesign;
    private String name;

    public Symbol(String symbolDesign, String name) {
        this.symbolDesign = symbolDesign;
        this.name = name;
    }

    public String getSymbolDesign() {
        return symbolDesign;
    }

    public void setSymbolDesign(String symbolDesign) {
        this.symbolDesign = symbolDesign;
    }
}
