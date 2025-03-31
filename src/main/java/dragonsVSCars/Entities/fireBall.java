package dragonsVSCars.Entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class fireBall extends DynamicSpriteEntity {

    Coordinate2D position;
    int speed;
    int damage;
    int pierce;

    protected fireBall(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }

    private void decreasePierce() {
        this.pierce--;
    }

    private void hitTarget() {
        // Logic to hit target
        decreasePierce();
    }
}

