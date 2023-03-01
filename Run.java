package com.example.Motorgeschwindigkeit;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

public class Run extends Thread{

    private Process process = null;
    private final AtomicBoolean running = new AtomicBoolean(false);

    public void run(ProcessBuilder builder) throws IOException{
        running.set(true);
        process = builder.start();
    }

    public void stopThread(){
        running.set(false);
        process.destroy();
        Thread.currentThread().interrupt();

    }
}
