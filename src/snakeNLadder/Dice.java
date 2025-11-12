package snakeNLadder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
@NoArgsConstructor
public class Dice {
    private int maxValue;
    private int numberObtained;

    public int rollDice(String name){
        /*Scanner scanner = new Scanner(System.in);
        System.out.println(name+" do you want to roll the dice?(Y/N):");
        String rollFlag = scanner.next();*/
        //if(rollFlag.equals("Y")){
            this.numberObtained = (int) (((Math.random()*100)%this.maxValue)+1);
            return this.numberObtained;
        /*}
        System.out.println(name+" denied to play the game");
        return 0;*/
    }

    public Boolean isSix(){
        if(this.numberObtained==(this.maxValue)){
            return true;
        }
        return false;
    }
}
