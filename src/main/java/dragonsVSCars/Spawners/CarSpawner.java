package dragonsVSCars.Spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import dragonsVSCars.Entities.Cars;
import dragonsVSCars.Entities.PlayerStats;

import java.util.Random;

public class CarSpawner extends EntitySpawner {

    private final double sceneWidth;
    private final double sceneHeight;
    private PlayerStats playerStats;

    public CarSpawner(double sceneWidth, double sceneHeight, PlayerStats playerStats) {
        super(1000);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
        this.playerStats = playerStats;

    }

    @Override
    protected void spawnEntities() {
        if (new Random().nextInt(10) < 4) {
            spawn(new Cars(20, 20, new int[]{0, 1, 2}, new Coordinate2D(50, 700), this.playerStats));
        }
    }


}
