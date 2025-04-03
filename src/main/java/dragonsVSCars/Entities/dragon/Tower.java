package dragonsVSCars.Entities.dragon;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Tower  extends DynamicSpriteEntity {
    public int pierce;
    public int speed;
    public int damage;;

    protected Tower(String resource, Coordinate2D initialLocation, int speed, int damage, int pierce) {
        super(resource, initialLocation);
        this.speed = speed;
        this.damage = damage;
        this.pierce = pierce;

    }
}
