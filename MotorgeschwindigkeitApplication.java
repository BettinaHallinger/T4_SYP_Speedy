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
			callPython(0);
			System.out.println("Success");
		}catch (IOException Exception ){
			Exception.printStackTrace();
		}

		//SpringApplication.run(MotorgeschwindigkeitApplication.class, args);
	}

	public static void callPython(int velocity) throws IOException {
		String line = "python3 ./" + "motor.py " + velocity;
		CommandLine cmdLine = CommandLine.parse(line);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);

		DefaultExecutor executor = new DefaultExecutor();
		executor.setStreamHandler(streamHandler);

		int exitCode = executor.execute(cmdLine);
	}

}
