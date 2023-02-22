package com.example.Motorgeschwindigkeit;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import java.io.*;
import java.util.ArrayList;


public class Executor {

    private ArrayList<Process> processList= new ArrayList<>();

    public void writeToJsonMotor(int wert) throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader("data.json"));
        JSONObject jo = (JSONObject) obj;

        // Get non-set values
        int brightness = (int) jo.get("LEDBrightness");
        int veloDisplay = (int) jo.get("DisplayVelocity");
        String display = (String) jo.get("DisplayText");

        //write them in Json form
        jo.put("MotorVelocity", wert);
        jo.put("LEDBrightness", brightness);
        jo.put("DisplayVelocity", veloDisplay);
        jo.put("DisplayText", display);

        //write to File
        FileWriter writer = new FileWriter("data.json");
        writer.write(jo.toString());
        writer.close();

        //System.out.println(velocity + brightness + veloDisplay + display);
    }
    public void writeToJsonLED(int wert) throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader("data.json"));
        JSONObject jo = (JSONObject) obj;

        // Get non-set values
        int velocity = (int) jo.get("MotorVelocity");
        int veloDisplay = (int) jo.get("DisplayVelocity");
        String display = (String) jo.get("DisplayText");

        //write them in Json form
        jo.put("MotorVelocity", velocity);
        jo.put("LEDBrightness", wert);
        jo.put("DisplayVelocity", veloDisplay);
        jo.put("DisplayText", display);

        //write to File
        FileWriter writer = new FileWriter("data.json");
        writer.write(jo.toString());
        writer.close();

        //System.out.println(velocity + brightness + veloDisplay + display);
    }
    public void writeToJsonDisplay(int wert, String text) throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader("data.json"));
        JSONObject jo = (JSONObject) obj;

        // Get non-set values
        int velocity = (int) jo.get("MotorVelocity");
        int brightness = (int) jo.get("LEDBrightness");

        //write them in Json form
        jo.put("MotorVelocity", velocity);
        jo.put("LEDBrightness", brightness);
        jo.put("DisplayVelocity", wert);
        jo.put("DisplayText", text);

        //write to File
        FileWriter writer = new FileWriter("data.json");
        writer.write(jo.toString());
        writer.close();

        //System.out.println(velocity + brightness + veloDisplay + display);
    }

    public void setValuesPI() throws IOException, InterruptedException, ParseException {

        if(processList.size() != 0){
            for (Process p : processList) {
                p.destroy();
            }
        }

        ProcessBuilder builder1 = new ProcessBuilder();
        //ProcessBuilder builder2 = new ProcessBuilder();
        //ProcessBuilder builder3 = new ProcessBuilder();

        Object obj = new JSONParser().parse(new FileReader("data.json"));
        JSONObject jo = (JSONObject) obj;

        String velocity = (String) jo.get("MotorVelocity");
        String brightness = (String) jo.get("LEDBrightness");
        String veloDisplay = (String) jo.get("DisplayVelocity");
        String display = (String) jo.get("DisplayText");

        builder1.command("python3", "./display.py", velocity);
        builder1.command("python3", "./display.py", brightness);
        builder1.command("python3", "./display.py", veloDisplay, display);

        Process process = builder1.start();
        processList.add(process);
        process.waitFor();
    }
}
