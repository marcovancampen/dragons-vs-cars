package dragonsVSCars.Scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import dragonsVSCars.DragonsVSCars;
import dragonsVSCars.Entities.*;
import dragonsVSCars.Entities.dragon.Dragons;
import dragonsVSCars.Spawners.CarSpawner;
import dragonsVSCars.Spawners.FireBallSpawner;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public class LevelEasy extends DynamicScene implements EntitySpawnerContainer, MouseButtonPressedListener {
    public static PlayerStats playerStats;
    private final DragonsVSCars dragonsVSCars;
    ArrayList<Dragons> dragons = new ArrayList<>();
    ArrayList<Cars> Cars = new ArrayList<>();
    ArrayList<FireBallSpawner> FireBallSpawners = new ArrayList<>();



    public LevelEasy(DragonsVSCars dragonsVSCars){
        this.dragonsVSCars = dragonsVSCars;
    }
    @Override
    public void setupScene() {
        setBackgroundColor(Color.BLACK);
        setBackgroundImage("LevelImages/mapEasy.png");

    }


    @Override
    public void setupEntities() {
        playerStats = new PlayerStats(new Coordinate2D(50, 50), "hallo", 100, 500, 1, dragonsVSCars);
        addEntity(playerStats);
        var spawnmenu = new SpawnMenu(new Coordinate2D(getWidth(), getHeight()));
        spawnmenu.setMenu(getHeight());
        spawnmenu.setAnchorPoint(AnchorPoint.BOTTOM_RIGHT);
        addEntity(spawnmenu);
        var MenuDragon = new MenuDragon(new Coordinate2D(1400, 0), 200, "green_dragon_small", "Green Dragon");
        addEntity(MenuDragon);

    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        if(checkDragons(coordinate2D)) {
            var dragon = getDragonAt(coordinate2D);

            if (dragon != null &&  playerStats.getCash() >= dragon.upgradeCost ) {
                upgradeDragon(dragon);
            }
        }
        if (!checkDragons(coordinate2D) && playerStats.getCash() >= MenuDragon.cost) {

            placeDragon(coordinate2D);
        }

    }
    public FireBallSpawner getFireBallAt(Coordinate2D coordinate2D) {
        if (FireBallSpawners == null || FireBallSpawners.isEmpty()) {
            return null; // No dragons placed yet
        }

        for (FireBallSpawner FireBallSpawner : FireBallSpawners) {
            if (FireBallSpawner.getLocation() == coordinate2D) {
                return FireBallSpawner; // Return the dragon found within the margin
            }
        }
        return null; // No dragon found at the specified location
    }

    public Dragons getDragonAt(Coordinate2D coordinate2D) {
        if (dragons == null || dragons.isEmpty()) {
            return null; // No dragons placed yet
        }

        for (Dragons dragon : dragons) {
            if (dragon.getAnchorLocation().distance(coordinate2D) < Dragons.margin) {
                return dragon; // Return the dragon found within the margin
            }
        }
        return null; // No dragon found at the specified location
    }


    boolean checkDragons(Coordinate2D coordinate2D) {
        if (dragons == null || dragons.isEmpty()) {
            return false; // No dragons placed yet, so it's safe to place a new one
        }

        for (Dragons dragon : dragons) {
            if (dragon.getAnchorLocation().distance(coordinate2D) < Dragons.margin) {
                return true; // A dragon is too close
            }
        }
       return false;
    }
    public void upgradeDragon(Dragons dragon) {
        playerStats.decreaseCash(dragon.upgradeCost);
        var FireBall = getFireBallAt(dragon.location);
        var upgradedDragon = new Dragons(dragon.location,"green_dragon_big", dragon.speed+20, dragon.attackRange+40, 999999999, dragon.damage+20, dragon.pierce+20);
        upgradedDragon.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        var upgradedFireball = new FireBallSpawner(1000 - upgradedDragon.speed, upgradedDragon.location, upgradedDragon.speed, upgradedDragon.damage, upgradedDragon.pierce, Cars, upgradedDragon.attackRange);
        dragon.remove();
        FireBall.remove();
        addEntity(upgradedDragon);
        addEntitySpawner(upgradedFireball);
        FireBallSpawners.add(upgradedFireball);
    }
    public void placeDragon(Coordinate2D coordinate2D){
        playerStats.decreaseCash(MenuDragon.cost);
        String name =  MenuDragon.getName();
        var Dragon = new Dragons(coordinate2D, name , 10, 300, 10, 10 , 10);
        Dragon.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        dragons.add(Dragon);
        addEntity(Dragon);
        var fireballSpawner = new FireBallSpawner(1000, Dragon.location, Dragon.speed, Dragon.damage, Dragon.damage, Cars, Dragon.attackRange);
        addEntitySpawner(fireballSpawner);
        FireBallSpawners.add(fireballSpawner);
    }

    @Override
    public void setupEntitySpawners() {
        System.out.println("doin this");
        var carSpawner = new CarSpawner(getWidth(), getHeight(), playerStats);
        addEntitySpawner(carSpawner);
        Cars = carSpawner.getCarList();
    }
}

