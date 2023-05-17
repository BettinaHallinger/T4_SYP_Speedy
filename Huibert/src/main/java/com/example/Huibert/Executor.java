package com.example.Huibert;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Executor {

    private boolean run = false;
    private ArrayList<Process> processes = new ArrayList<Process>();

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

    public void setValuesPI() throws IOException, ParseException {

        if (run) {
            ProcessBuilder builder0 = new ProcessBuilder("sh", "-c", "/usr/bin/killall /usr/bin/python3");
            //builder0.command("/usr/bin/killall /usr/bin/python3");
            Process process0 = builder0.start();
            process0.destroy();
        }

        if(processes.size() > 0){
            for (Process p: processes) {
                p.destroy();
            }
        }




        ProcessBuilder builder1 = new ProcessBuilder();
        ProcessBuilder builder2 = new ProcessBuilder();
        ProcessBuilder builder3 = new ProcessBuilder();



        //Get data from JSON File
        Object obj = new JSONParser().parse(new FileReader("data.json"));
        JSONObject jo = (JSONObject) obj;

        int velocity = (int) jo.get("MotorVelocity");
        int brightness = (int) jo.get("LEDBrightness");
        int veloDisplay = (int) jo.get("DisplayVelocity");
        String display = (String) jo.get("DisplayText");

        //Set commands for Python Scripts
        builder1.command("python3", "./motor.py", Integer.toString(velocity));
        builder2.command("python3", "./led.py", Integer.toString(brightness));
        builder3.command("python3", "./display.py", Integer.toString(veloDisplay), display);



        Process process2 = builder2.start();
        Process process1 = builder1.start();
        Process process3 = builder3.start();

        processes.add(process1);
        processes.add(process2);
        processes.add(process3);

        run = true;



    }



}
