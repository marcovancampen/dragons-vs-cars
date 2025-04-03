package dragonsVSCars.Entities.Buttons;

import com.github.hanyaeger.api.Coordinate2D;
import dragonsVSCars.DragonsVSCars;

public class QuitButton extends MenuButtons {
    public QuitButton(Coordinate2D initialLocation, DragonsVSCars dragonsVSCars) {
        super(initialLocation, "Quit", dragonsVSCars);
    }

    @Override
    public void buttonAction() {
        dragonsVSCars.quit();
    }
}
