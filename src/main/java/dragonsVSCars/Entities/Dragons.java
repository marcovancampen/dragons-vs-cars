package dragonsVSCars.Entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Dragons extends SpriteEntity {
    protected int marge;
    protected Coordinate2D position;
    protected int attackSpeed;
    protected int attackRange;
    protected int upgradeCost;

    protected Dragons(String resource, Coordinate2D initialLocation, int attackSpeed, int attackRange, int upgradeCost) {
        super(resource, initialLocation);
        this.attackSpeed = attackSpeed;
        this.attackRange = attackRange;
        this.upgradeCost = upgradeCost;
    }

    public void spawnDragon() {

    }
    public void upgradeDragon() {

    }
    public void Attack(){

    }
}
