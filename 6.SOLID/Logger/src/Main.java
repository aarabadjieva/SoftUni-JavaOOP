import controllers.EngineImpl;
import controllers.InputParser;
import controllers.LoggerFactory;
import interfaces.Engine;
import interfaces.Factory;
import interfaces.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    private static final Factory<Logger> LOGGER_FACTORY = new LoggerFactory();
    private static  Engine engine;

    public static void main(String[] args) throws IOException {
        InputParser inputParser = new InputParser();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Main.engine = new EngineImpl(Main.LOGGER_FACTORY.produce(inputParser.readLoggerInfo(bufferedReader)));
        engine.run("END", bufferedReader);
        System.out.println(engine.toString());
    }
}
