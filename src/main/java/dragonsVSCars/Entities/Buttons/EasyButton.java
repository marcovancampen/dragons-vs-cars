package dragonsVSCars.Entities.Buttons;


import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import dragonsVSCars.*;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class EasyButton extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private final dragonsVSCars dragonsVSCars;

    public EasyButton(Coordinate2D initialPosition, dragonsVSCars dragonsVSCars) {
        super(initialPosition, "Easy");
        this.dragonsVSCars = dragonsVSCars;
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        dragonsVSCars.setActiveScene(1);
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

