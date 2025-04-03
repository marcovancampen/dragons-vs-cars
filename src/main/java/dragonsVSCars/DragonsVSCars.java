package dragonsVSCars;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import dragonsVSCars.Scenes.GameOver;
import dragonsVSCars.Scenes.LevelEasy;
import dragonsVSCars.Scenes.titleScreen;

public class DragonsVSCars extends YaegerGame {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Dragons VS Cars");
        setSize(new Size(1600,800));
    }

    @Override
    public void setupScenes(){
        addScene(0, new titleScreen(this));
        addScene(1, new LevelEasy(this));
        addScene(2, new GameOver(this, "YOU LOSE"));
        addScene(3, new GameOver(this, "YOU WIN"));
    }
}