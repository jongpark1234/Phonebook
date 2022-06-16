import java.io.File;
import java.io.IOException;
public class utility {
    public static final String DIR = ".\\phonebook.txt";
    public static Boolean fileExists() throws IOException {
        return new File(".\\phonebook.txt").exists();
    }
    public static void clearConsole() throws IOException {
        io.print("\033[H\033[2J");
    }
    public static void checking() throws IOException {
        io.print("다음으로 넘어가려면 아무 키나 눌러주세요.");
        io.input();
    }
}
