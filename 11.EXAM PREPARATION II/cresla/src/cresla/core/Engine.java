package cresla.core;

import cresla.IO.InputReaderImpl;
import cresla.IO.OutputWriterImpl;
import cresla.interfaces.InputReader;
import cresla.interfaces.Manager;
import cresla.interfaces.OutputWriter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine {
    private Manager manager;
    private InputReader inputReader;
    private OutputWriter outputWriter;

    public Engine() {
        this.manager = new ManagerImpl();
        this.inputReader = new InputReaderImpl();
        this.outputWriter = new OutputWriterImpl();
    }

    public void run(){
        String info = this.inputReader.readLine();
        while (!info.equals("Exit")){
            List<String> infoCmd = Arrays.stream(info.split("\\s")).collect(Collectors.toList());
            List<String> cmd = infoCmd.subList(1,infoCmd.size());
            switch (infoCmd.get(0)){
                case "Reactor":
                    this.outputWriter.writeLine(this.manager.reactorCommand(cmd));
                    break;
                case "Module":
                    this.outputWriter.writeLine(this.manager.moduleCommand(cmd));
                    break;
                case "Report":
                    this.outputWriter.writeLine(this.manager.reportCommand(cmd));
                    break;
            }
            info = this.inputReader.readLine();
        }

        this.outputWriter.writeLine(this.manager.exitCommand(Arrays.stream(info.split("\\s")).collect(Collectors.toList())));
    }
}
