package dragonsVSCars.Entities.dragon;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.List;

public class Dragons extends Tower implements SceneBorderTouchingWatcher , Collided {
    public static int margin = 40;
    public int attackRange;
    public int upgradeCost;


    public String name;
    public  Coordinate2D location;

    public  Dragons(Coordinate2D initialLocation, String Dragon, int attackSpeed, int attackRange, int upgradeCost, int attackDamage, int pierceDamage) {
        super("Dragons/"+ Dragon + ".png", initialLocation, attackSpeed, attackDamage, pierceDamage);
        this.location = initialLocation;
        this.attackRange = attackRange;
        this.upgradeCost = upgradeCost;
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {

    }

    @Override
    public void onCollision(List<Collider> collidingObjects) {

    }
}
