package com.superkiment.ttd.client.graphics;

import com.superkiment.ttd.client.inputs.Cursor;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public class Window {
    private long window;
    final private int vSync = 1;
    final private int width = 800, height = 600;
    private boolean isWindowShown = true;
    private Cursor cursorPos;

    public void init() {
        // Capture des erreurs GLFW
        GLFWErrorCallback.createPrint(System.err).set();

        // Initialisation de GLFW
        if (!GLFW.glfwInit()) {
            throw new IllegalStateException("Impossible d'initialiser GLFW !");
        }

        // Configuration de GLFW
        GLFW.glfwDefaultWindowHints();
        GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE);
        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_TRUE);

        // Création de la fenêtre
        window = GLFW.glfwCreateWindow(width, height, SplashText.getRandom(), 0, 0);
        if (window == 0) {
            throw new RuntimeException("Échec de la création de la fenêtre GLFW");
        }

        GLFW.glfwSetCursorPosCallback(window, cursorPos = new Cursor());

        // Centrage de la fenêtre
        try (var stack = org.lwjgl.system.MemoryStack.stackPush()) {
            int[] widthTabl = new int[1], heightTabl = new int[1];
            GLFW.glfwGetWindowSize(window, widthTabl, heightTabl);
            long monitor = GLFW.glfwGetPrimaryMonitor();
            var videoMode = GLFW.glfwGetVideoMode(monitor);
            if (videoMode != null) {
                GLFW.glfwSetWindowPos(
                        window,
                        (videoMode.width() - width) / 2,
                        (videoMode.height() - height) / 2
                );
            }
        }

        // Création du contexte OpenGL
        GLFW.glfwMakeContextCurrent(window);
        GL.createCapabilities();
        GLFW.glfwSwapInterval(vSync);

        // Affichage de la fenêtre
        if (isWindowShown)
            GLFW.glfwShowWindow(window);
    }

    public void loop() {
        while (!GLFW.glfwWindowShouldClose(window)) {
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

            // Dessine le carré
            GL11.glPushMatrix();

            GL11.glColor3f(1, 0, 0); // Rouge
            Drawing.drawSquare((float) Cursor.posX, (float) Cursor.posY, 100, 200);

            GL11.glPopMatrix();

            // Dessine le cercle
//            GL11.glPushMatrix();
//            GL11.glTranslatef(0.5f, 0.0f, 0.0f); // Décale à droite
//            drawCircle();
//            GL11.glPopMatrix();

            GLFW.glfwSwapBuffers(window);
            GLFW.glfwPollEvents();
        }
    }


    public void cleanup() {
        // Destruction de la fenêtre
        GLFW.glfwDestroyWindow(window);
        GLFW.glfwTerminate();
        GLFW.glfwSetErrorCallback(null).free();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
