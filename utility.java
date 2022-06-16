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
        io.print("다음으로 넘어가려면 엔터 키를 입력해주세요.");
        io.input();
        clearConsole();
    }
    public static Boolean isCanceled(Object[] arr) throws IOException {
        if (arr.length == 0) {
            return false;
        }
        return arr[0].toString().equals("X");
    }
}
