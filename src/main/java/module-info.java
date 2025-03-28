module dragons.Cars {
    requires hanyaeger;

    exports dragonsVSCars;

    opens audio;
    opens backgrounds;
    opens sprites;
    exports com.github.hanyaeger.tutorial.entities;
    exports com.github.hanyaeger.tutorial.scenes;
    exports com.github.hanyaeger.tutorial.entities.buttons;
}
