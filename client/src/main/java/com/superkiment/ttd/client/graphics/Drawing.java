package com.superkiment.ttd.client.graphics;

import com.superkiment.ttd.client.ClientMain;
import com.superkiment.ttd.common.KVector;
import org.lwjgl.opengl.GL11;

public class Drawing {
    public static KVector actualColor = new KVector();

    public static Align align = Align.CORNER;

    enum Align {
        CENTER, CORNER
    }

    public static void setActualColor(float v1, float v2, float v3) {
        actualColor = new KVector(v1, v2, v3);
    }

    public static void drawSquare(float x, float y, float width, float height) {
        Window w = ClientMain.window;
        int widthW = w.getWidth();
        int heightW = w.getHeight();


        GL11.glTranslatef(x*2 / widthW - 1f, (y*2 / heightW) - 1f, 0.0f); // Décale à gauch
        
        GL11.glBegin(GL11.GL_QUADS); // Début du dessin

        switch (align) {
            case CENTER -> {
                GL11.glVertex2f(-0.5f, -0.5f); // Bas gauche
                GL11.glVertex2f(0.5f, -0.5f); // Bas droit
                GL11.glVertex2f(0.5f, 0.5f); // Haut droit
                GL11.glVertex2f(-0.5f, 0.5f); // Haut gauche
            }
            case CORNER -> {
                GL11.glVertex2f(0, height*2 / heightW); // Bas gauche
                GL11.glVertex2f(width*2 / widthW, height*2 / heightW); // Bas droit
                GL11.glVertex2f(width*2 / widthW, 0); // Haut droit
                GL11.glVertex2f(0, 0); // Haut gauche
            }
            default -> throw new IllegalStateException("Unexpected value: " + align);
        }


        GL11.glEnd(); // Fin du dessin
    }

}
