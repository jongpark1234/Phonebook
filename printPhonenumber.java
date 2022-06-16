import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class printPhonenumber {
    static void printArray(Object[] arr) throws IOException {
        for (Object i: arr) {
            io.print(i.toString());
        }
        io.print("");
    }
    public static void run() throws Exception {
        if (!utility.fileExists()) {
            messages.fileNotFoundMessage();
            return;
        }
        byte[] b = new byte[999999];
        FileInputStream fi = new FileInputStream(utility.DIR);
        fi.read(b);
        fi.close();
        Object[] phonenumArray = dataring.getFile(b, false).toArray();
        if (utility.isCanceled(phonenumArray)) {
            utility.clearConsole();
            messages.cancelMessage();
            return;
        }
        Arrays.sort(phonenumArray);
        io.print("ㅡㅡ  전화번호 목록 ㅡㅡ");
        printArray(phonenumArray);
        utility.checking();
    }
}
