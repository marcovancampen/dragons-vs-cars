package dragonsVSCars.Entities.Buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import dragonsVSCars.DragonsVSCars;
import javafx.scene.input.MouseButton;

public class QuitButton extends MenuButtons {
    public QuitButton(Coordinate2D initialLocation, DragonsVSCars dragonsVSCars) {
        super(initialLocation, "Quit", dragonsVSCars);
    }

    @Override
    public void buttonAction() {
        dragonsVSCars.quit();
    }
}
