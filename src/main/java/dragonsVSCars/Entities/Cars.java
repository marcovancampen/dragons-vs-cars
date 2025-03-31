package dragonsVSCars.Entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class Cars extends DynamicSpriteEntity implements SceneBorderTouchingWatcher {
    protected int X;
    protected int Y;
    protected int marge;
    protected int health;
    protected int speed;
    protected int[] path;
    protected boolean isLast;

    Cars(int x, int y, int health, int speed, int[] path, Coordinate2D initialLocations) {
        super("levelImage/mapEasy.png", initialLocations);
        this.X = x;
        this.Y = y;
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

    public void getHealth(){

    }


    @Override
    public void notifyBoundaryTouching(SceneBorder border) {

    }
}
