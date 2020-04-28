package TrafficLights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s");
        List<TrafficLight> trafficLights = new LinkedList<>();
        for (String color:input
             ) {
            TrafficLight trafficLight = new TrafficLight(Signal.valueOf(color));
            trafficLights.add(trafficLight);
        }

        int changes = Integer.parseInt(reader.readLine());
        for (int i = 0; i < changes; i++) {
            for (TrafficLight trl:trafficLights
                 ) {
                trl.updateSignal(trl.getSignal());
                System.out.printf("%s ",trl.getSignal());
            }
            System.out.println();
        }
    }
}
