package dragonsVSCars.Spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import dragonsVSCars.Entities.Cars;

import java.util.Random;

public class CarSpawner extends EntitySpawner {

    private final double sceneWidth;
    private final double sceneHeight;

    public CarSpawner(double sceneWidth, double sceneHeight) {
        super(100);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
    }

    @Override
    protected void spawnEntities() {
        if (new Random().nextInt(10) < 4) {
            spawn(new Cars(20, 20, new int[]{0, 1, 2}, new Coordinate2D(20, 20)));
        }
    }


}
