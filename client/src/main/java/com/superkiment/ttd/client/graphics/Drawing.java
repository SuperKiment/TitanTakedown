package com.superkiment.ttd.client.graphics;

import com.superkiment.ttd.client.ClientMain;
import org.lwjgl.opengl.GL11;

public class Drawing {
    public static void drawSquare(float x, float y, float width, float height) {
        Window w = ClientMain.window;
        int widthW = w.getWidth();
        int heightW = w.getWidth();

        GL11.glBegin(GL11.GL_QUADS); // Début du dessin

        GL11.glColor3f(1.0f, 0.0f, 0.0f); // Rouge

        GL11.glVertex2f(-0.5f, -0.5f); // Bas gauche
        GL11.glVertex2f( 0.5f, -0.5f); // Bas droit
        GL11.glVertex2f( 0.5f,  0.5f); // Haut droit
        GL11.glVertex2f(-0.5f,  0.5f); // Haut gauche

        GL11.glEnd(); // Fin du dessin
    }

}
