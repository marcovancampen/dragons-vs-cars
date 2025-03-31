package dragonsVSCars.Tools;
import com.github.hanyaeger.api.Coordinate2D;

public class MathUtils {
    public static double getAngle(Coordinate2D source, Coordinate2D target) {
        double deltaY = target.getY() - source.getY();
        double deltaX = target.getX() - source.getX();
        return Math.toDegrees(Math.atan2(deltaX, -deltaY));
    }
}
