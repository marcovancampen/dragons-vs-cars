package dragonsVSCars.Entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import dragonsVSCars.Scenes.LevelEasy;

import java.util.Set;

public class Cars extends DynamicSpriteEntity implements SceneBorderTouchingWatcher {
    protected int marge;
    protected int health;
    protected int speed;
    protected int[] path;
    protected boolean isLast;

    public Cars(int health, int speed, int[] path, Coordinate2D initialLocations) {
        super("carSprites/Yellow_MICRO_CLEAN_SOUTH_005.png", initialLocations);
        this.health = health;
        this.speed = speed;
        this.path = path;

        setMotion(3, Direction.UP);
    }

    public void spawnCar(){

    }

    public void moveCar(int richting, int speed){
            switch (richting) {
                case 0:
                    setMotion(speed, Direction.LEFT);
                case 1:
                    setMotion(speed, Direction.RIGHT);
                case 2:
                    setMotion(speed, Direction.UP);
                case 3:
                    setMotion(speed, Direction.DOWN);
            }
        }


    private void rotateSprite(){

    }

    public void deductHealth(){

    }

    public void deSpawnCar(){

    }

    public int getHealth(){
        return this.health;
    }


    @Override
    public void notifyBoundaryTouching(SceneBorder border) {

        switch (border){
            case TOP:
                LevelEasy.playerStats.decreaseHealth(this.health);
                remove();
        }

    }
    }


