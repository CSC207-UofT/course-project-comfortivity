public class CLI {
    public static void main(String[] args) {
        system.out.println("please enter your name")
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