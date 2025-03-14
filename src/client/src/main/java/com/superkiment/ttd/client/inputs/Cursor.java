package com.superkiment.ttd.client.inputs;

import org.lwjgl.glfw.GLFWCursorPosCallback;

public class Cursor extends GLFWCursorPosCallback {
    public static double posX = 0, posY = 0;

    @Override
    public void invoke(long l, double v, double v1) {
//        System.out.println("x : " + v + " y : " + v1);

        posX = v;
        posY = v1;
    }
}
