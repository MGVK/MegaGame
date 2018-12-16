package ru.mgvk.megacliker;

public class Constants {

    public static final String PREFERENCES_FILE_NAME = "GamePrefs";
    public static final int[]  LEVELS_TIMEOUTS       = {1000, 500, 300};
    public static final String PREFERENCES_LEVEL_I   = "lvl";


    public static int getTimeout(int lvlI) {
        return LEVELS_TIMEOUTS[lvlI];
    }
}
