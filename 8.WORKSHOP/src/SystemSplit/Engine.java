package SystemSplit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine {
    MySystem system;

    public Engine() {
        this.system = new MySystem();
    }

    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        while (!input.equals("System Split")){
            int begining = input.indexOf('(');
            int end = input.indexOf(')');
            String cmd = input.substring(0,begining);
            String[] data = input.substring(begining+1,end).split(", ");
            switch (cmd){
                case "RegisterPowerHardware":
                    system.registerPowerHardware(data[0],Integer.parseInt(data[1]),Integer.parseInt(data[2]));
                    break;
                case "RegisterHeavyHardware":
                    system.registerHeavyHardware(data[0],Integer.parseInt(data[1]),Integer.parseInt(data[2]));
                    break;
                case "RegisterExpressSoftware":
                    system.registerExpressSoftware(data[0],data[1],Integer.parseInt(data[2]),Integer.parseInt(data[3]));
                    break;
                case "RegisterLightSoftware":
                    system.registerLightSoftware(data[0],data[1],Integer.parseInt(data[2]),Integer.parseInt(data[3]));
                    break;
                case "ReleaseSoftwareComponent":
                    system.releaseSoftwareComponent(data[0],data[1]);
                    break;
                case "Analyze":
                    System.out.println(system.analyze());
                    break;
                case "Dump":
                    system.dump(data[0]);
                    break;
                case "Restore":
                    system.restore(data[0]);
                    break;
                case "Destroy":
                    system.getBin().destroy(data[0]);
                    break;
                case "DumpAnalyze":
                    System.out.println(system.getBin().analyze());
                    break;
            }
            input = reader.readLine();
        }
        System.out.println(system.systemSplit());
    }
}
