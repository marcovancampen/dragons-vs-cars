package dragonsVSCars.Entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class Cars extends DynamicSpriteEntity implements SceneBorderTouchingWatcher {
    protected Coordinate2D position;
    protected int marge;
    //protected image[] sprite;
    protected int health;
    protected int speed;
    protected int[] path;
    protected boolean isLast;

    Cars(String resource, Coordinate2D initialLocation, int health, int speed, int[] path) {
        super(resource, initialLocation);
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

    public void deductHealth(int attackValue){
        this.health -= attackValue;
    }

    public void deSpawnCar(){

    }

    public void getHealth(){

    }


    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {

    }
}
