package dragonsVSCars.Entities.dragon;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import dragonsVSCars.Entities.Cars;

import java.util.List;

public class Fireball extends Tower implements SceneBorderTouchingWatcher, Collided {

    Coordinate2D position;


    public Fireball(Coordinate2D initialLocation, int speed, int damage, int pierce, double angle) {
        super("Dragons/fireball.png",initialLocation, speed, damage, pierce);
        this.setMotion(speed, angle);
        this.position = initialLocation;

    }

    private void decreasePierce(int healh) {
        this.pierce -= healh;
    }

    private void hitTarget(Cars cars) {
       var tempPierce = pierce;
        decreasePierce(cars.getHealth());
        cars.deductHealth(tempPierce);
        if(pierce <= 0){
            remove();
        }
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        remove();
    }


    private long lastCollisionTime = 0;
    @Override
    public void onCollision(List<Collider> collidingObjects) {
        long currentTime = System.currentTimeMillis();

        if (currentTime - lastCollisionTime >= 1000) { // Ensure 1 second has passed
            lastCollisionTime = currentTime; // Update the timestamp

            var car = collidingObjects.get(0);
            hitTarget((Cars) car);
        }
    }

}

