package dragonsVSCars.Scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.tutorial.entities.Hanny;
import com.github.hanyaeger.tutorial.entities.text.HealthText;
import dragonsVSCars.DragonsVSCars;
import dragonsVSCars.Entities.Cars;

public class GameOver extends StaticScene {

    public GameOver() {

    }

    public void resetCurrentLevel(int level){

    }

    @Override
    public void setupScene() {

    }

    @Override
    public void setupEntities() {
        setBackgroundImage("backgrounds/TitleScreen.jpeg");
    }
}
