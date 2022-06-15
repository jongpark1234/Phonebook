import java.io.IOException;
public class utility {
    public static void clearConsole() throws IOException {
        io.print("\033[H\033[2J");
    }
}
