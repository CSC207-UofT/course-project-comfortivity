import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class CLI {

    public static void main(String[] args) throws IOException {

        System.out.println("please enter your name");
        {
            // Enter data using BufferReader
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));

            // Reading data using readLine
            String name = reader.readLine();

            // Printing the read line
            System.out.println(name);
        }
    }
}