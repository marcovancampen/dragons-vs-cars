package dragonsVSCars.Entities;

import com.github.hanyaeger.api.Timer;

public class CarsMovementTimer extends Timer {

    private Cars car;

    public CarsMovementTimer(Cars car) {
        super(10);
        this.car = car;
    }

    @Override
    public void onAnimationUpdate(long l) {
        car.move();
    }
}
