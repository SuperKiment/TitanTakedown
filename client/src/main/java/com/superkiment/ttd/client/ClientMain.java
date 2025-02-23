package com.superkiment.ttd.client;

import com.superkiment.ttd.client.graphics.Window;

public class ClientMain {
    public static Window window;

    /**
     * Stores the current state of the application
     */
//    public static GameManager gameManager;

    /**
     * The game created and played when the connection with a world is established
     */
//    public static Game game;

    /**
     * The player's username, passed to the world and seen by others.
     */
    public String playerName = "Player" + (int) Math.random()*10000;

    /**
     * Handles the UI : Buttons, Text inputs, etc.
     */
//    UI ui;

    public void run() {
        window.init();
        window.loop();
        window.cleanup();
    }

//    public void setupModules() {
//        gameManager = new GameManager();
//        ui = new UI(gameManager, this);
//        println(playerName);
//        debugHTML = new DebugHTML(this);
//    }

    public static void main(String[] args) {
        window = new Window();
        new ClientMain().run();
    }
}