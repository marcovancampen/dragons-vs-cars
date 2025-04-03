package dragonsVSCars.Entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import java.util.List;

public class Dragons extends DynamicSpriteEntity implements SceneBorderTouchingWatcher , Collided {
    public static int margin = 40;
    public int attackSpeed;
    public int attackRange;
    public int upgradeCost;
    public int attackDamage;
    public int pierceDamage;
    public String name;
    public  Coordinate2D location;

    public  Dragons(Coordinate2D initialLocation, String Dragon, int attackSpeed, int attackRange, int upgradeCost, int attackDamage, int pierceDamage) {
        super("Dragons/"+ Dragon + ".png", initialLocation);
        this.location = initialLocation;
        this.attackSpeed = attackSpeed;
        this.attackRange = attackRange;
        this.upgradeCost = upgradeCost;
        this.attackDamage = attackDamage;
        this.pierceDamage = pierceDamage;
    }

    public void upgradeDragon() {


    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {

    }

    @Override
    public void onCollision(List<Collider> collidingObjects) {

    }
}
