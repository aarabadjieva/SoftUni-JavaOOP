package interfaces;

import java.io.BufferedReader;
import java.io.IOException;

public interface Engine {
    void run(String string, BufferedReader br) throws IOException;
}
