module dragons.Cars {
    requires hanyaeger;
    requires java.desktop;

    exports dragonsVSCars;

    opens audio;
    opens backgrounds;
    opens LevelImages;
    opens Dragons;
    opens carSprites;
}
