package dragonsVSCars.Scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import dragonsVSCars.Entities.Dragons;
import dragonsVSCars.Spawners.CarSpawner;
import dragonsVSCars.Spawners.FireBallSpawner;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import java.util.ArrayList;

public class LevelEasy extends DynamicScene implements EntitySpawnerContainer, MouseButtonPressedListener {
    ArrayList<Dragons> dragons = new ArrayList<>();
    @Override

    public void setupScene() {
        setBackgroundColor(Color.BLACK);
        setBackgroundImage("LevelImages/mapEasy.png");
    }

    @Override
    public void setupEntities() {

    }
    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        if (!checkDragons(coordinate2D)) {
            var Dragon = new Dragons(coordinate2D, 10, 10, 10, 10 );
            Dragon.setAnchorPoint(AnchorPoint.CENTER_CENTER);
            dragons.add(Dragon);
            addEntity(Dragon);
            addEntitySpawner(new FireBallSpawner(10, Dragon.location, Dragon.attackSpeed, Dragon.attackDamage, Dragon.attackRange));

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
        return false; // No dragon is too close
    }
    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new CarSpawner(getWidth(), getHeight()));
    }
}

