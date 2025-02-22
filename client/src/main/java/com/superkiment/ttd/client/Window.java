package com.superkiment.ttd.client;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public class Window {
    private long window;
    final private int vSync = 1;
    final private int width = 800, height = 600;

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
        window = GLFW.glfwCreateWindow(width, height, "Ma Fenêtre LWJGL", 0, 0);
        if (window == 0) {
            throw new RuntimeException("Échec de la création de la fenêtre GLFW");
        }

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
        GLFW.glfwShowWindow(window);
    }

    public void loop() {
        // Boucle de rendu
        while (!GLFW.glfwWindowShouldClose(window)) {
            // Nettoyage de l'écran
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

            // Rafraîchissement de l'affichage
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
