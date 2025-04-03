package dragonsVSCars.Entities;

import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;

import java.util.List;

public class CarsMovementTimer extends Timer implements TimerContainer {

    private Cars car;

    public CarsMovementTimer(Cars car) {
        super(10);
        this.car = car;
    }

    @Override
    public void onAnimationUpdate(long l) {
        car.move();
    }

    @Override
    public void setupTimers() {

    }

    @Override
    public List<Timer> getTimers() {
        return List.of();
    }
}
