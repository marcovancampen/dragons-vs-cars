package dragonsVSCars;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import dragonsVSCars.Scenes.LevelEasy;
import dragonsVSCars.Scenes.titleScreen;

public class DragonsVSCars extends YaegerGame {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Dragons VS Cars");
        setSize(new Size(1920,1080));

    }

    @Override
    public void setupScenes(){
        addScene(0, new titleScreen(this));
        addScene(1, new LevelEasy());
    }
}