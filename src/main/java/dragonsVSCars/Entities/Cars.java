package dragonsVSCars.Entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.ArrayList;

import static com.github.hanyaeger.api.entities.Direction.*;

public class Cars extends DynamicSpriteEntity implements SceneBorderTouchingWatcher, TimerContainer {
    protected int marge;
    protected int health;
    protected int speed;
    protected Coordinate2D[] path;
    protected boolean isLast;
    protected PlayerStats playerStats;
    private int currentPathIndex;
    private final ArrayList<CarsMovementTimer> timers = new ArrayList<>();  // Store timers


    public Cars(int health, int speed, Coordinate2D initialLocations, PlayerStats playerStats) {
        super("carSprites/Yellow_MICRO_CLEAN_SOUTH_005.png", initialLocations);
        this.health = health;
        this.speed = speed;
        this.playerStats = playerStats;
        this.currentPathIndex = 0;
        this.path = new Coordinate2D[]{
                new Coordinate2D(180, 615),
                new Coordinate2D(1415, 615),
                new Coordinate2D(1415, 400),
                new Coordinate2D(255, 400),
                new Coordinate2D(255, 185),
                new Coordinate2D(1415, 185),
                new Coordinate2D(1415, -50)
        };
    }

    public void move() {
        System.out.println(getAnchorLocation());
        if (currentPathIndex < path.length) {
            moveToDestination(path[currentPathIndex]);  // Move towards the current waypoint
        }
    }

    private void moveToDestination(Coordinate2D destination) {
        Coordinate2D currentLocation = getAnchorLocation();
        double deltaX = destination.getX() - currentLocation.getX();
        double deltaY = destination.getY() - currentLocation.getY();
        double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

        if (distance > 1) {
            double moveX = (deltaX / distance) * speed;
            double moveY = (deltaY / distance) * speed;
            setAnchorLocation(new Coordinate2D(currentLocation.getX() + moveX, currentLocation.getY() + moveY));
        } else {
            currentPathIndex++;
            rotateSprite();
        }
    }


    private void rotateSprite(){

    }

    public void deductHealth(int damage){
        health -= damage;
        if (health <= 0){
            this.playerStats.increaseCash(20);
            deSpawnCar();
        }

    }

    public void deSpawnCar(){
        remove();
    }

    public int getHealth(){
        return this.health;
    }


    @Override
    public void notifyBoundaryTouching(SceneBorder border) {

        switch (border){
            case TOP:
                deSpawnCar();
                this.playerStats.decreaseHealth(this.health);
        }

    }

    @Override
    public void setupTimers() {
        addTimer(new CarsMovementTimer(this));
    }
}


