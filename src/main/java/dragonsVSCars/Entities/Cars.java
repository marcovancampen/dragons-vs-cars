package dragonsVSCars.Entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import static com.github.hanyaeger.api.entities.Direction.*;

public class Cars extends DynamicSpriteEntity implements SceneBorderTouchingWatcher {
    protected int marge;
    protected int health;
    protected int speed;
    protected int[] path;
    protected boolean isLast;
    protected PlayerStats playerStats;
    private Coordinate2D destination;

    public Cars(int health, int speed, int[] path, Coordinate2D initialLocations, PlayerStats playerStats) {
        super("carSprites/Yellow_MICRO_CLEAN_SOUTH_005.png", initialLocations);
        this.health = health;
        this.speed = speed;
        this.path = path;
        this.playerStats = playerStats;
        setMotion(3, UP);


//        moveto(new Coordinate2D(500, 500));

        destination = getAnchorLocation();
    }

    public void spawnCar() {
    }

    public void moveCar(int richting, int speed){
            switch (richting) {
                case 0:
                    setMotion(speed, LEFT);
                case 1:
                    setMotion(speed, RIGHT);
                case 2:
                    setMotion(speed, UP);
                case 3:
                    setMotion(speed, DOWN);
            }
        }



//        public void moveto(Coordinate2D location) {
//        this.destination = location;
//        }
//
//
//    public void moveToDestination() {
//            if (this.destination != null) {
//                Coordinate2D currentLocation = getAnchorLocation();
//                double deltaX = this.destination.getX() - currentLocation.getX();
//                double deltaY = this.destination.getY() - currentLocation.getY();
//                double angle = Math.atan2(deltaY, deltaX);
//                double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
//
//                if (distance > 1) {
//                    // Normalize movement direction and scale by speed
//                    double moveX = (deltaX / distance) * speed;
//                    double moveY = (deltaY / distance) * speed;
//
//                    // Move towards the destination
//                    setAnchorLocation(new Coordinate2D(currentLocation.getX() + moveX, currentLocation.getY() + moveY));
//                }
//            }
//        }


    private void rotateSprite(){

    }

    public void deductHealth(){

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
    }


