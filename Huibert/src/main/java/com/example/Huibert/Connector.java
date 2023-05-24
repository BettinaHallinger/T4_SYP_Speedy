package com.example.Huibert;

import java.io.IOException;

public class Connector {

    public void hotspot_on() throws IOException {
        ProcessBuilder builder0 = new ProcessBuilder();
        //ProcessBuilder builder0 = new ProcessBuilder("sh", "-c", "/usr/bin/sudo /usr/bin/bash /usr/bin/autohotspot/autohotspot.sh service");
        builder0.command("sudo", "bash", "/usr/bin/autohotspot/autohotspot.sh", "on");

        Process process = builder0.start();
        process.destroy();

    }

    public void hotspot_off() throws IOException, InterruptedException {
        ProcessBuilder builder1 = new ProcessBuilder();
        builder1.command("sudo", "bash", "/usr/bin/autohotspot/autohotspot.sh", "service");
        Process process = builder1.start();
        Thread.sleep(300);
        process.destroy();

        ProcessBuilder builder2 = new ProcessBuilder();
        builder2.command("sudo", "bash", "/usr/bin/autohotspot/autohotspot.sh", "off");
        Process process2 = builder2.start();

    }
}
