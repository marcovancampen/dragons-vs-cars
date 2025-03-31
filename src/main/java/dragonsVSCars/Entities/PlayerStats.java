package dragonsVSCars.Entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicTextEntity;

public class PlayerStats extends DynamicTextEntity {

    public int health;
    public int cash;
    public int round;

    protected PlayerStats(Coordinate2D initialLocation, int health, int cash, int round) {
        super(initialLocation);
        this.health = health;
        this.cash = cash;
        this.round = round;
    }

    public void decreaseHealth(int value){
        this.health -= value;
    }

    public void decreaseCash(int value){
        this.cash -= value;
    }

    public void increaseCash(int value){
        this.cash += value;
    }

    public void increaseRound(){
        this.round ++;
    }
}
