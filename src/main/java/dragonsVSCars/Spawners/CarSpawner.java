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
    public int totalCarsSpawned;

    public CarSpawner(double sceneWidth, double sceneHeight, PlayerStats playerStats) {
        super(1000);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
        this.playerStats = playerStats;
        this.totalCarsSpawned = 0;
    }


    @Override
    protected void spawnEntities() {
        System.out.println("Spawning entities");
        if (totalCarsSpawned<20) {
            spawner(3,1, 20);
            playerStats.setRound(1);
        }else if (totalCarsSpawned < 40) {
            spawner(4,2,20);
            playerStats.setRound(2);
        }else if (totalCarsSpawned < 60) {
            spawner(4,2,30);
            playerStats.setRound(3);
        }else if (totalCarsSpawned < 80) {
            spawner(5,2,30);
            playerStats.setRound(4);
        }else if (totalCarsSpawned < 100) {
            spawner(5,3,30);
            playerStats.setRound(5);
        }else if (totalCarsSpawned < 120) {
            spawner(5,3,40);
            playerStats.setRound(6);
        }else if (totalCarsSpawned < 140) {
            spawner(5,3,50);
            playerStats.setRound(7);
        }else if (totalCarsSpawned < 160) {
            spawner(6,3,50);
            playerStats.setRound(8);
        }else if (totalCarsSpawned < 180) {
            spawner(7,3,50);
            playerStats.setRound(9);
        }else if (totalCarsSpawned < 200) {
            spawner(8,3,100);
            playerStats.setRound(10);
        }
    }

    private void spawner(int chance, int speed, int health){
        if (new Random().nextInt(10) < chance) {
            Cars car = new Cars(health, speed, new Coordinate2D(180, 775), this.playerStats, getCarList());
            car.setAnchorPoint(AnchorPoint.CENTER_CENTER);
            spawn(car);
            cars.add(car);
            totalCarsSpawned++;
        }
    }

    public ArrayList<Cars> getCarList(){
        return cars;
    }
}




