package dragonsVSCars.Entities.maps;

import com.github.hanyaeger.api.scenes.TileMap;
import dragonsVSCars.Entities.Cars;
import dragonsVSCars.Entities.Dragons;
import dragonsVSCars.Entities.Fireball;
import dragonsVSCars.Entities.tiles.Tile;


public class LevelEasyMap extends TileMap {


    @Override
    public void setupEntities() {
        addEntity(1, Tile.class, "carSprites/Yellow_MICRO_CLEAN_SOUTH_005.png");

    }

    @Override
    public int[][] defineMap() {
        return new int[22][15];
    }
}
