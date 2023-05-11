package com.example.Huibert;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import java.io.*;
import java.util.ArrayList;


public class Executor {

    private ArrayList<Run> processList= new ArrayList<>();

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


        if(processList.size() != 0){


            processList = null;
        }

        ProcessBuilder builder = new ProcessBuilder();
        ProcessBuilder builder0 = new ProcessBuilder();
        ProcessBuilder builder4 = new ProcessBuilder();



        ProcessBuilder builder1 = new ProcessBuilder();
        ProcessBuilder builder2 = new ProcessBuilder();
        ProcessBuilder builder3 = new ProcessBuilder();

        builder.command("python3", "pkill -9 -f ./motor.py");
        builder0.command("python3", "pkill -9 -f ./led.py");
        builder4.command("python3", "pkill -9 -f ./display.py");

        Run run4 = new Run();
        Run run5 = new Run();
        Run run6 = new Run();

        run4.run(builder);
        run5.run(builder0);
        run6.run(builder4);

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

        Run run1 = new Run();
        Run run2 = new Run();
        Run run3 = new Run();

        run1.run(builder1);
        run2.run(builder2);
        run3.run(builder3);

        processList.add(run1);
        processList.add(run2);
        processList.add(run3);


        System.out.println(processList.size());

    }

    public void stopEverything(){

        //Stop every Thread
        for (Run p:processList) {
            p.stopThread();
        }

        /*
        ProcessBuilder builder1 = new ProcessBuilder();
        ProcessBuilder builder2 = new ProcessBuilder();
        ProcessBuilder builder3 = new ProcessBuilder();

        builder1.command("python3", "./motor.py", "0");
        builder2.command("python3", "./led.py", "0");
        builder3.command("python3", "./display.py", "0", "");

        Process process = builder1.start();
        Process process1 = builder2.start();
        Process process3 = builder3.start();
         */
    }

}
