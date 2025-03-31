package dragonsVSCars.Entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class fireBall extends DynamicSpriteEntity{

    Coordinate2D position;
    public int speed;
    public int damage;
    public int pierce;

    protected fireBall(String resource, Coordinate2D initialLocation, int speed, int damage, int pierce) {
        super(resource, initialLocation);
        this.position = initialLocation;
        this.speed = speed;
        this.damage = damage;
        this.pierce = pierce;

    }

    private void decreasePierce() {
        this.pierce--;
    }

    private void hitTarget() {
        // Logic to hit target
        decreasePierce();
    }
}

