package dragonsVSCars.Entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import dragonsVSCars.DragonsVSCars;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class PlayerStats extends TextEntity {

    private final DragonsVSCars dragonsVSCars;
    public int health;
    public int cash;
    public int round;

    public PlayerStats(Coordinate2D initialLocation, String text, int health, int cash, int round, DragonsVSCars dragonsVSCars) {
        super(initialLocation, text);
        this.health = health;
        this.cash = cash;
        this.round = round;
        this.dragonsVSCars = dragonsVSCars;
        setText();
    }

    public void setText(){
        setText("Health: " + this.health + " Cash: " + this.cash + " Round: " + this.round);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
        setFill(Color.WHITE);
    }

    public void decreaseHealth(int value){
        this.health -= value;
        if(this.health <= 0){
            this.health = 0;
            this.dragonsVSCars.setActiveScene(2);
        }

        setText();
    }

    public void decreaseCash(int value){
        this.cash -= value;
        setText();
    }

    public void increaseCash(int value){
        this.cash += value;
        setText();
    }

    public void setRound(int round){
        this.round = round;
        setText();
    }

    public int getCash(){
        return  cash;
    }
}
