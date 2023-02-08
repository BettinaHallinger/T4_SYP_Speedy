package com.example.Motorgeschwindigkeit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.PumpStreamHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@SpringBootApplication
public class MotorgeschwindigkeitApplication {

	public static void main(String[] args){

		try{
			callPythonVelocity(0);
			//callPythonLeds(0);
			//callPythonDisplay(2, text);
			System.out.println("Success");
		}catch (IOException Exception ){
			Exception.printStackTrace();
		}

		SpringApplication.run(MotorgeschwindigkeitApplication.class, args);
	}

	//Erstellung eines Prozesses --> Daten über Webseite zuerst in JSON File --> auslesen und dann den neuen Prozess starten
	public static void callPythonVelocity(int velocity) throws IOException {
		String line = "python3 ./" + "motor.py " + velocity;
		CommandLine cmdLine = CommandLine.parse(line);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);

		DefaultExecutor executor = new DefaultExecutor();
		executor.setStreamHandler(streamHandler);

		while(true){
			int exitCode = executor.execute(cmdLine);
		}

	}

	public static void callPythonLeds(int brightness) throws IOException {
		String line = "python3 ./" + "led.py " + brightness;
		CommandLine cmdLine = CommandLine.parse(line);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);

		DefaultExecutor executor = new DefaultExecutor();
		executor.setStreamHandler(streamHandler);

		int exitCode = executor.execute(cmdLine);
	}

	public static void callPythonDisplay(int velocity, String text) throws IOException {
		ProcessBuilder builder = new ProcessBuilder();

		String velo = Integer.toString(velocity);

		builder.command("python3", "./display.py", velo, text);

		//builder.command("sh", "-c", "ls");
		Process process = builder.start();

		/*String line = "python3 ./" + "display.py " + velocity + " " + text;
		System.out.println(line);
		CommandLine cmdLine = CommandLine.parse(line);


		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);

		DefaultExecutor executor = new DefaultExecutor();
		executor.setStreamHandler(streamHandler);

		int exitCode = executor.execute(cmdLine);*/
	}
}
