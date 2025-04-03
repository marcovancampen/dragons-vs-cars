package dragonsVSCars.Spawners;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.api.scenes.YaegerScene;
import com.github.hanyaeger.core.TimerListProvider;
import com.github.hanyaeger.core.Updatable;
import com.github.hanyaeger.core.UpdateDelegator;
import dragonsVSCars.Entities.Cars;
import dragonsVSCars.Entities.CarsMovementTimer;
import dragonsVSCars.Entities.Dragons;
import dragonsVSCars.Entities.PlayerStats;
import dragonsVSCars.Scenes.LevelEasy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarSpawner extends EntitySpawner{

    private final double sceneWidth;
    private final double sceneHeight;
    private PlayerStats playerStats;
    public ArrayList<Cars> cars = new ArrayList<>();

    public CarSpawner(double sceneWidth, double sceneHeight, PlayerStats playerStats) {
        super(1000);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
        this.playerStats = playerStats;
    }


    @Override
    protected void spawnEntities() {
        System.out.println("Spawning entities");
        if (new Random().nextInt(10) < 4) {
            Cars car = new Cars(20, 1, new Coordinate2D(180, 775), this.playerStats);
            car.setAnchorPoint(AnchorPoint.CENTER_CENTER);
            spawn(car);
            cars.add(car);
        }
    }

    public ArrayList<Cars> getCarList(){
        return cars;
    }
}




