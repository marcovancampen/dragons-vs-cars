package dragonsVSCars.Scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import dragonsVSCars.DragonsVSCars;
import dragonsVSCars.Entities.Buttons.QuitButton;
import dragonsVSCars.Entities.Buttons.StartButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameOver extends StaticScene {

    private final DragonsVSCars dragonsVSCars;
    private final String text;

    public GameOver(DragonsVSCars dragonsVSCars, String text) {
        this.dragonsVSCars = dragonsVSCars;
        this.text = text;

    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/TitleScreen.jpeg");
        var gameOverText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 3),
                text
        );

        gameOverText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        gameOverText.setFill(Color.RED);
        gameOverText.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        gameOverText.setStrokeColor(Color.BLACK);
        addEntity(gameOverText);

    }

    @Override
    public void setupEntities() {
        double buttonY = getHeight() / 2 + 100;
        double spacing = 150;

        var QuitButton = new QuitButton(new Coordinate2D(getWidth() / 2 + spacing, buttonY), dragonsVSCars);
        QuitButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        QuitButton.setFill(Color.GREEN);
        addEntity(QuitButton);

        var startButton = new StartButton(new Coordinate2D(getWidth() / 2 - spacing, buttonY), dragonsVSCars);
        startButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        startButton.setFill(Color.GREEN);
        addEntity(startButton);
    }
}
