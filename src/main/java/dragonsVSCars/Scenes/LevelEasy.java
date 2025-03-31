package dragonsVSCars.Scenes;

import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import dragonsVSCars.Spawners.CarSpawner;


public class LevelEasy extends DynamicScene implements EntitySpawnerContainer {
    @Override
    public void setupScene() {
        setBackgroundImage("LevelImages/mapEasy.png");
    }

    @Override
    public void setupEntities() {

    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new CarSpawner(getWidth(), getHeight()));
    }
}
