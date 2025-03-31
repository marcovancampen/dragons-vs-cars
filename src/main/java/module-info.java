module dragons.Cars {
    requires hanyaeger;
    requires java.desktop;

    exports dragonsVSCars;

    opens audio;
    opens backgrounds;
    opens sprites;
    opens LevelImages;
    exports com.github.hanyaeger.tutorial.entities;
    exports com.github.hanyaeger.tutorial.scenes;
    exports com.github.hanyaeger.tutorial.entities.buttons;
}
