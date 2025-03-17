package com.superkiment.ttd.client.graphics;

import com.superkiment.ttd.client.ClientMain;
import com.superkiment.ttd.common.types.KVector;
import org.lwjgl.opengl.GL11;

public class Drawing {
    public static KVector actualColor = new KVector();

    public static Align align = Align.CORNER;

    public enum Align {
        CENTER, CORNER
    }

    public static void setActualColor(float v1, float v2, float v3) {
        actualColor = new KVector(v1, v2, v3);
    }

    public static void drawSquare(float x, float y, float width, float height) {
        Window w = ClientMain.window;
        float widthW = w.getWidth();
        float heightW = w.getHeight();


//        GL11.glTranslatef(x * 2 * iWidthW - 1f, -y * 2 * iHeightW +1f, 0.0f);

        float iWidthW = 1f / widthW, iHeightW = 1f / heightW;

        float trX = (x * 2f - widthW) * iWidthW, trY = (-y * 2f + heightW) * iHeightW;

        GL11.glBegin(GL11.GL_QUADS); // Début du dessin

        switch (align) {
            case CENTER -> {
                GL11.glVertex2f(-0.5f, -0.5f); // Bas gauche
                GL11.glVertex2f(0.5f, -0.5f); // Bas droit
                GL11.glVertex2f(0.5f, 0.5f); // Haut droit
                GL11.glVertex2f(-0.5f, 0.5f); // Haut gauche
            }
            case CORNER -> {
                GL11.glVertex2f(trX, trY + height * 2 * iHeightW); // Bas gauche
                GL11.glVertex2f(trX + width * 2 * iWidthW, trY + height * 2 * iHeightW); // Bas droit
                GL11.glVertex2f(trX + width * 2 * iWidthW, trY); // Haut droit
                GL11.glVertex2f(trX, trY); // Haut gauche
            }
            default -> throw new IllegalStateException("Unexpected value: " + align);
        }


        GL11.glEnd(); // Fin du dessin
    }

}
