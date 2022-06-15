import java.io.IOException;
public class utility {
    public static void clearConsole() throws IOException {
        io.print("\033[H\033[2J");
    }
    public static void retryMessage() throws IOException {
        io.print("재입력 바랍니다.");
    }
}
