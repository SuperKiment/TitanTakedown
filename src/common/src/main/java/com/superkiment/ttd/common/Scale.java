package com.superkiment.ttd.common;


/**
 * A public static class that directs the scales of the game
 */
public class Scale {
    private static float gameScale = 1.0f;
    private static final float baseHeight = 800;

    public static void UpdateGameScale(int windowHeight) {
        gameScale = (float) windowHeight / baseHeight;
    }

    public static float getGameScale() {
        return gameScale;
    }
}
