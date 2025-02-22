package com.superkiment.ttd.client;

import com.superkiment.ttd.common.GameConstants;

public class ClientMain {
    static Window window;

    public void run() {
        window.init();
        window.loop();
        window.cleanup();
    }

    public static void main(String[] args) {
        window = new Window();
        new ClientMain().run();
    }
}