package dragonsVSCars.Entities.Buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import dragonsVSCars.DragonsVSCars;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Optional;

public abstract class MenuButtons extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {


    protected DragonsVSCars dragonsVSCars;

    public MenuButtons(Coordinate2D initialPosition, String text, DragonsVSCars dragonsVSCars) {
        super(initialPosition, text);
        this.dragonsVSCars = dragonsVSCars;
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));

    }

    public abstract void buttonAction();

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        buttonAction();
    }

    @Override
    public void onMouseEntered(){
        setFill(Color.VIOLET);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited(){
        setFill(Color.GREEN);
        setCursor(Cursor.DEFAULT);
    }
}
