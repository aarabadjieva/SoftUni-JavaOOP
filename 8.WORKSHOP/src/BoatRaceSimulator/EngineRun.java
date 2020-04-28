package BoatRaceSimulator;

import BoatRaceSimulator.core.CommandHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EngineRun {
private CommandHandler commandHandler;

    public EngineRun(CommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    public void run() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            try{
                String line = br.readLine();
                if (line.toLowerCase().equals("end")){
                    break;
                }
                String[] data = line.split("\\\\");
                String result = this.commandHandler.handle(data);
                System.out.println(result);

            }catch (IOException e) {
                e.printStackTrace();
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
