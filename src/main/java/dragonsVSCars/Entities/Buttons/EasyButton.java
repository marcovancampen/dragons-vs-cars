package dragonsVSCars.Entities.Buttons;


import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import dragonsVSCars.*;
import javafx.scene.Cursor;
import javafx.scene.control.MenuButton;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class EasyButton extends MenuButtons {


    public EasyButton(Coordinate2D initialPosition, DragonsVSCars dragonsVSCars) {
        super(initialPosition, "Easy", dragonsVSCars);
    }

    @Override
    public void buttonAction() {
        dragonsVSCars.setActiveScene(1);
    }
}

