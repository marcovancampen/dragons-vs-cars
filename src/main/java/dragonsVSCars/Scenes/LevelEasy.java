package dragonsVSCars.Scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import dragonsVSCars.Entities.PlayerStats;
import dragonsVSCars.Entities.SpawnMenu;
import dragonsVSCars.Entities.maps.LevelEasyMap;
import dragonsVSCars.Spawners.CarSpawner;
import dragonsVSCars.Spawners.FireBallSpawner;
import dragonsVSCars.Entities.Dragons;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import java.util.ArrayList;
import dragonsVSCars.Entities.Cars;

public class LevelEasy extends DynamicScene implements EntitySpawnerContainer, MouseButtonPressedListener, TileMapContainer {
    public static PlayerStats playerStats;
    ArrayList<Dragons> dragons = new ArrayList<>();
    ArrayList<Cars> Cars = new ArrayList<>();
    @Override

    public void setupScene() {
        var spawnmenu = new SpawnMenu(new Coordinate2D(getWidth(), getHeight()), getHeight());
        spawnmenu.setAnchorPoint(AnchorPoint.BOTTOM_RIGHT);
        addEntity(spawnmenu);
        setBackgroundColor(Color.BLACK);
        setBackgroundImage("LevelImages/mapEasy.png");
    }

    @Override
    public void setupEntities() {
        playerStats = new PlayerStats(new Coordinate2D(50, 50), "hallo", 100, 500, 1);
        addEntity(playerStats);
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        if (!checkDragons(coordinate2D)) {
            var Dragon = new Dragons(coordinate2D, 10, 10, 10, 10 );
            Dragon.setAnchorPoint(AnchorPoint.CENTER_CENTER);
            dragons.add(Dragon);
            addEntity(Dragon);
            addEntitySpawner(new FireBallSpawner(1000, Dragon.location, Dragon.attackSpeed, Dragon.attackDamage, Dragon.attackRange, Cars ));

        }
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

    @Override
    public void setupEntitySpawners() {
        var carSpawner = new CarSpawner(getWidth(), getHeight(), playerStats);
        addEntitySpawner(carSpawner);
        Cars = carSpawner.getCarList();
    }


    @Override
    public void setupTileMaps() {
        addTileMap(new LevelEasyMap());
    }

}

