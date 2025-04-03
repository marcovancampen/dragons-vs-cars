package dragonsVSCars.Entities.Buttons;


import com.github.hanyaeger.api.Coordinate2D;
import dragonsVSCars.*;

public class StartButton extends MenuButtons {


    public StartButton(Coordinate2D initialPosition, DragonsVSCars dragonsVSCars) {
        super(initialPosition, "Start", dragonsVSCars);
    }

    @Override
    public void buttonAction() {
        dragonsVSCars.setActiveScene(1);
    }
}

