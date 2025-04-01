package dragonsVSCars.Spawners;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import dragonsVSCars.Entities.Cars;
import dragonsVSCars.Entities.Fireball;

import java.util.ArrayList;

import static com.github.hanyaeger.api.AnchorPoint.*;
import static dragonsVSCars.Tools.MathUtils.getAngle;

public class FireBallSpawner extends EntitySpawner {
    private Coordinate2D location;
    private int speed;
    private int damage;
    private int pierce;
    private ArrayList<Cars> cars;
    private Double lastKnownAngle;
    private Double currentAngle;

    public FireBallSpawner(long intervalInMs, Coordinate2D location, int speed, int damage, int pierce, ArrayList<Cars> cars) {
        super(intervalInMs);
        this.location = location;
        this.speed = speed;
        this.damage = damage;
        this.pierce = pierce;
        this.cars = cars;
    }

    @Override
    protected void spawnEntities() {
        Cars closestCar = findClosestCar();
        if (closestCar != null) {
            currentAngle = getAngle(this.location, closestCar.getAnchorLocation());
        }
        if (currentAngle != lastKnownAngle) {
            var fireball = new Fireball(this.location, this.speed, this.damage, this.pierce, currentAngle);
            fireball.setAnchorPoint(AnchorPoint.CENTER_CENTER);
            spawn(fireball);
            lastKnownAngle = currentAngle;
        }
    }

    private Cars findClosestCar() {
        Cars closestCar = null;
        double closestDistance = Double.MAX_VALUE;

        for (Cars car : cars) {
            double distance = location.distance(car.getAnchorLocation());
            if (distance < closestDistance) {
                closestDistance = distance;
                closestCar = car;
            }
        }

        return closestCar;
    }
}
