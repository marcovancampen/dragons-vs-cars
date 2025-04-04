package dragonsVSCars.Entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class    SpawnMenu extends RectangleEntity {

    public SpawnMenu(Coordinate2D initialLocation) {
        super(initialLocation);


    }
    public void setMenu(double height){
        setWidth(200);
        setHeight(height);
        setFill(Color.DARKGRAY);
    }
}
