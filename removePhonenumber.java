import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;
public class removePhonenumber {
    static void printArray(Object[] arr) throws IOException {
        io.print("\n↓ 검색 결과 ↓\n");
        for (int i = 0; i < arr.length; i++) {
            String[] temp = arr[i].toString().split(" ");
            io.print(Integer.toString(i + 1) + ". " + temp[0] + " " + temp[1]);
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
        StringBuilder ret = new StringBuilder();
        int deleteNumber;
        fi.read(b);
        fi.close();
        while (true) {
            Vector<String> dataList = dataring.getFile(b, true);
            Object[] phonenumArray = dataring.chooseData(dataList, "전화번호 삭제").toArray();
            Arrays.sort(phonenumArray);
            printArray(phonenumArray);
            if (phonenumArray.length == 0) {
                utility.clearConsole();
                io.print("검색 결과가 존재하지 않습니다.\n");
                continue;
            }
            io.print("삭제할 번호를 입력해주세요. 명령을 취소하려면 0을 입력해주세요.");
            deleteNumber = Integer.parseInt(io.input()) - 1;
            if (deleteNumber < 0) {
                utility.clearConsole();
                io.print("명령을 취소했습니다.");
                return;
            }
            dataList.remove(Integer.parseInt(phonenumArray[deleteNumber].toString().split(" ")[2]));
            for (String i: dataList) {
                String[] temp = i.split(" ");
                ret.append(temp[0] + " " + temp[1] + "\n");
            }
            FileOutputStream fo = new FileOutputStream(utility.DIR, false);
            fo.write(ret.toString().getBytes());
            fo.close();
            break;
        }
    }
}
