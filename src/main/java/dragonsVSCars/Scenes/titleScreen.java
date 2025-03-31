package dragonsVSCars.Scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import dragonsVSCars.Entities.Buttons.EasyButton;
import dragonsVSCars.Entities.Buttons.HardButton;
import dragonsVSCars.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class titleScreen extends StaticScene {
    private DragonsVSCars dragonsVSCars;

    public titleScreen(DragonsVSCars dragonsVSCars) {
        this.dragonsVSCars = dragonsVSCars;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/TitleScreen.jpeg");
    }

    @Override
    public void setupEntities(){
        var title = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 3),
                "Dragons VS Cars"
        );
        title.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        title.setFill(Color.RED);
        title.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 80));
        addEntity(title);

        double buttonY = getHeight() / 2 + 100;
        double spacing = 150;

        var easyButton = new EasyButton(new Coordinate2D(getWidth() / 2 - spacing, buttonY), dragonsVSCars);
        easyButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        easyButton.setFill(Color.GREEN);
        addEntity(easyButton);

        var hardButton = new HardButton(new Coordinate2D(getWidth() / 2 + spacing, buttonY), dragonsVSCars);
        hardButton.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        hardButton.setFill(Color.RED);
        addEntity(hardButton);
    }
}
