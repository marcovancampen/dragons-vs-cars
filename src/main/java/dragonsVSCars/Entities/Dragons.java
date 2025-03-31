package dragonsVSCars.Entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.List;

public class Dragons extends DynamicSpriteEntity implements SceneBorderTouchingWatcher , Collided {
    protected int marge;
    protected Coordinate2D position;
    protected int attackSpeed;
    protected int attackRange;
    protected int upgradeCost;
    protected int attackDamage;

    protected Dragons(String resource, Coordinate2D initialLocation, int attackSpeed, int attackRange, int upgradeCost, int attackDamage) {
        super(resource, initialLocation);
        this.attackSpeed = attackSpeed;
        this.attackRange = attackRange;
        this.upgradeCost = upgradeCost;
        this.attackDamage = attackDamage;
    }

    public void spawnDragon() {

    }

    public void upgradeDragon() {

    }

    public void Attack(){

    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {

    }

    @Override
    public void onCollision(List<Collider> collidingObjects) {

    }
}
