package dragonsVSCars.Spawners;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import dragonsVSCars.Entities.Cars;
import dragonsVSCars.Entities.PlayerStats;

import java.util.ArrayList;
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
            spawner(4,1);
            playerStats.setRound(1);
        } else if (totalCarsSpawned < 40) {
            spawner(3,2);
            playerStats.setRound(2);
        }
    }

    private void spawner(int chance, int speed){
        if (new Random().nextInt(10) < chance) {
            Cars car = new Cars(20, speed, new Coordinate2D(180, 775), this.playerStats);
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




