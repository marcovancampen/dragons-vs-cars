package dragonsVSCars.Entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class Cars extends DynamicSpriteEntity implements SceneBorderTouchingWatcher {
    protected int marge;
    protected int health;
    protected int speed;
    protected int[] path;
    protected boolean isLast;

    Cars(int health, int speed, int[] path, Coordinate2D initialLocations) {
        super("levelImage/mapEasy.png", initialLocations);
        this.health = health;
        this.speed = speed;
        this.path = path;
    }

    public void spawnCar(){

    }

    public void moveCar(){

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


    }
}
