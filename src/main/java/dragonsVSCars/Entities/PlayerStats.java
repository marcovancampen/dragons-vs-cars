package dragonsVSCars.Entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class PlayerStats extends TextEntity {

    public int health;
    public int cash;
    public int round;

    public PlayerStats(Coordinate2D initialLocation, String text, int health, int cash, int round) {
        super(initialLocation, text);
        this.health = health;
        this.cash = cash;
        this.round = round;
        setText();
    }

    public void setText(){
        setText("Health: " + this.health + " Cash: " + this.cash + " Round: " + this.round);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
        setFill(Color.WHITE);
    }

    public void decreaseHealth(int value){
        this.health -= value;
        if(this.health < 0){
            this.health = 0;
        }
        setText();
    }

    public void decreaseCash(int value){
        this.cash -= value;
        setText();
    }

    public void increaseCash(int value){
        this.cash += value;
    }

    public void increaseRound(){
        this.round ++;
    }
    public int getCash(){
        return  cash;
    }

    public PlayerStats getPlayerStats(){
        return this;
    }
}
