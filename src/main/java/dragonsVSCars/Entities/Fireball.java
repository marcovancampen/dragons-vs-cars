package dragonsVSCars.Entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.CircleEntity;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import javafx.scene.paint.Color;

public class Fireball extends DynamicSpriteEntity {

    Coordinate2D position;
    public int speed;
    public int damage;
    public int pierce;

    public Fireball(Coordinate2D initialLocation, int speed, int damage, int pierce, double angle) {
        super("Dragons/white_dragon_small.png",initialLocation);
        this.setMotion(speed, angle);
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

