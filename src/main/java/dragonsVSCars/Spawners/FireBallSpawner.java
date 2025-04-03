package dragonsVSCars.Spawners;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import dragonsVSCars.Entities.Cars;
import dragonsVSCars.Entities.Fireball;

import java.util.ArrayList;

import static dragonsVSCars.Tools.MathUtils.getAngle;

public class FireBallSpawner extends EntitySpawner {
    private Coordinate2D location;
    private int speed;
    private int damage;
    private int pierce;
    private int range;
    private ArrayList<Cars> cars;
    private Double currentAngle;

    public FireBallSpawner(long intervalInMs, Coordinate2D location, int speed, int damage, int pierce, ArrayList<Cars> cars, int range) {
        super(intervalInMs);
        this.location = location;
        this.speed = speed;
        this.damage = damage;
        this.pierce = pierce;
        this.cars = cars;
        this.range = range;
    }

    @Override
    protected void spawnEntities() {

        Cars closestCar = findClosestCar();

        if (closestCar == null) {
            return;
        }

        double distanceToCar = location.distance(closestCar.getAnchorLocation());
        System.out.println("Closest car distance: " + distanceToCar + " | Attack Range: " + range);

        if (distanceToCar > range) {
            return;
        }


        currentAngle = getAngle(this.location, closestCar.getAnchorLocation());
        var fireball = new Fireball(this.location, this.speed, this.damage, this.pierce, currentAngle);
        fireball.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        spawn(fireball);
    }


    private Cars findClosestCar() {
        Cars closestCar = null;
        double closestDistance = Double.MAX_VALUE;

        for (Cars car : cars) {
            double distance = location.distance(car.getAnchorLocation());

            if (distance < closestDistance) { // Find the closest car first
                closestDistance = distance;
                closestCar = car;
            }
        }

        return closestCar;
    }

    public Coordinate2D getLocation() {
        return location;
    }
}
