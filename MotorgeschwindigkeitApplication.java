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

			Executor exec = new Executor();
			exec.writeToJsonMotor(0);
			exec.writeToJsonLED(0);
			exec.writeToJsonDisplay(2, "Hallo mein Name ist Max");
			exec.setValuesPI();
			//exec.stopEverything();

			System.out.println("Success");
		}catch (Exception Exception ){
			Exception.printStackTrace();
		}

		SpringApplication.run(MotorgeschwindigkeitApplication.class, args);
	}

	//Nicht mehr nötig
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

	public static void callPythonDisplay(int velocity, String text) throws IOException, InterruptedException {
		ProcessBuilder builder = new ProcessBuilder();

		String velo = Integer.toString(velocity);

		//Process process = Runtime.getRuntime().exec("python3 ./display.py" + velo + text);


		builder.command("python3", "./display.py", velo, text);

		//builder.command("sh", "-c", "ls");

		Process process = builder.start();
		process.waitFor();



		/*String line = "python3 ./" + "display.py " + velocity + " " + text;
		System.out.println(line);
		CommandLine cmdLine = CommandLine.parse(line);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);

		DefaultExecutor executor = new DefaultExecutor();
		executor.setStreamHandler(streamHandler);

		int exitCode = executor.execute(cmdLine);
		*/

	}
}
