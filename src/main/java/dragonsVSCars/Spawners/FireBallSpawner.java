package dragonsVSCars.Spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import dragonsVSCars.Entities.Fireball;

import static dragonsVSCars.Tools.MathUtils.getAngle;

public class FireBallSpawner extends EntitySpawner {
    public Coordinate2D location;
    public int speed;
    public int damage;
    public int pierce;

    public FireBallSpawner(long intervalInMs, Coordinate2D location, int speed, int damage, int pierce) {
        super(intervalInMs);
        this.location = location;
        this.speed = speed;
        this.damage = damage;
        this.pierce = pierce;
    }

    @Override
    protected void spawnEntities() {
//        spawn(new Fireball(this.location, this.speed, this.damage, this.pierce, getAngle(this.location)));
        spawn(new Fireball(this.location, this.speed, this.damage, this.pierce, 9));
    }
}
