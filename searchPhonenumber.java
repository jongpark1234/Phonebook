import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class searchPhonenumber {
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
        while (true) {
            Object[] phonenumArray = dataring.chooseData(dataring.getFile(b, false), "전화번호 검색").toArray();
            if (utility.isCanceled(phonenumArray)) {
                utility.clearConsole();
                messages.cancelMessage();
                break;
            }
            Arrays.sort(phonenumArray);
            if (phonenumArray.length == 0) {
                utility.clearConsole();
                io.print("검색 결과가 존재하지 않습니다.\n");
                continue;
            }
            io.print("\n총 " + Integer.toString(phonenumArray.length) + "개의 검색 결과\n");
            printArray(phonenumArray);
            utility.checking();
            break;
        }
    }
}
