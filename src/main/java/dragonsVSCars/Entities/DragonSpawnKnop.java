package dragonsVSCars.Entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DragonSpawnKnop extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

    private static String name;
    public static int cost;
    public boolean selected;

    public DragonSpawnKnop(Coordinate2D initialLocation, int cost, String name, String label) {
        super(initialLocation, label+ " \n" + cost);
        this.name = name;
        this.cost = cost;
        this.selected = false;
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    }


    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        setFill(Color.GREEN);
        selected = true;

    }

    public void notEnoughCost() {
        setFill(Color.RED);
    }

    @Override
    public void onMouseEntered() {

    }

    @Override
    public void onMouseExited() {

    }
    public static String getName() {
        return name;
    }
}
