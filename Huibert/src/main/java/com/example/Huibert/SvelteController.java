package com.example.Huibert;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SvelteController {
    @PostMapping("/execute-java")
    public void executeJava(@RequestBody Map<String, String> data) {
        try {
            int motor = Integer.parseInt(data.get("motor"));
            String displayText = data.get("displayText");
            int displayVel = Integer.parseInt(data.get("displayVel"));
            int led = Integer.parseInt(data.get("led"));

            System.out.println(motor);
            System.out.println(displayText);
            System.out.println(displayVel);
            System.out.println(led);

            // Call your Java code with the values
            //String result = MyJavaClass.execute(value1, value2, value3);

            // Return a JSON response
            //JsonObject jsonResponse = new JsonObject();
            //jsonResponse.addProperty("result", result);
            //return new Gson().toJson(jsonResponse);
            // GET VALUES FROM SESSION STORAGE
            Executor exec = new Executor();
            exec.writeToJsonMotor(motor);
            exec.writeToJsonLED(led);
            exec.writeToJsonDisplay(displayVel, displayText);
            exec.setValuesPI();
            //exec.stopEverything();

            System.out.println("Success");
        } catch (Exception Exception ){
            Exception.printStackTrace();
        }
    }
}
