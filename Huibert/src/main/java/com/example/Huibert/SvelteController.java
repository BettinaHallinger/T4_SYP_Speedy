package com.example.Huibert;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SvelteController {
    private Executor exec = new Executor();
    private Connector conn = new Connector();

    @PostMapping("/execute-java")
    public void executeJava(@RequestBody Map<String, String> data) {
        try {
            int motor = Integer.parseInt(data.get("motor"));
            String displayText = data.get("displayText");
            int displayVel = Integer.parseInt(data.get("displayVel"));
            int led = Integer.parseInt(data.get("led"));

            System.out.println("In JAVA (SUBMIT): " + motor);
            System.out.println("In JAVA (SUBMIT): " + displayText);
            System.out.println("In JAVA (SUBMIT): " + displayVel);
            System.out.println("In JAVA (SUBMIT): " + led);

            // Call your Java code with the values
            //String result = MyJavaClass.execute(value1, value2, value3);

            // Return a JSON response
            //JsonObject jsonResponse = new JsonObject();
            //jsonResponse.addProperty("result", result);
            //return new Gson().toJson(jsonResponse);
            // GET VALUES FROM SESSION STORAGE
            //Executor exec = new Executor();
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

    @PostMapping("/change-wlan")
    public void connectToNewWLAN(@RequestBody Map<String, String> data) {
        try {
            String wlanSSID = data.get("wlanSSID");
            String wlanPass = data.get("wlanPass");

            System.out.println("In JAVA (WLAN): " + wlanSSID);
            System.out.println("In JAVA (WLAN): " + wlanPass);

            conn.wifi_change(wlanSSID, wlanPass);

            System.out.println("Success");
        } catch (Exception Exception ){
            Exception.printStackTrace();
        }
    }

    @PostMapping("/change-hotspot")
    public void changeHotspot(@RequestBody Map<String, String> data) {
        try {
            String hotspotSSID = data.get("hotspotSSID");
            String hotspotPass = data.get("hotspotPass");

            System.out.println("In JAVA (HOTSPOT): " + hotspotSSID);
            System.out.println("In JAVA (HOTSPOT): " + hotspotPass);

            conn.hotspot_change(hotspotSSID, hotspotPass);

            System.out.println("Success");
        } catch (Exception Exception ){
            Exception.printStackTrace();
        }
    }

    @PostMapping("/connect-wlan")
    public void connectToWLAN(@RequestBody Map<String, String> data) {
        try {
            conn.hotspot_off();

            System.out.println("In JAVA (WLAN EXISTING): Success");
        } catch (Exception Exception ){
            Exception.printStackTrace();
        }
    }

    @PostMapping("/connect-hotspot")
    public void activateHotspot(@RequestBody Map<String, String> data) {
        try {
            conn.hotspot_on();

            System.out.println("In JAVA (HOTSPOT EXISTING): Success");
        } catch (Exception Exception ){
            Exception.printStackTrace();
        }
    }
}
