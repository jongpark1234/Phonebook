import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Vector;
public class removePhonenumber {
    static Vector<String> removing(Vector<String> v, String data, int idx) {
        Vector<String> ret = new Vector<String>();
        for (String i: v) {
            if (i.split(" ")[idx].contains(data)) {
                ret.add(i);
            }
        }
        return ret;
    }

    static Vector<String> removeData(Vector<String> v) throws Exception {
        String data;
        Vector<String> ret = new Vector<String>();
        while (true) {
            io.print("전화번호 삭제\n\n이름 또는 전화번호를 입력해주세요. ( 일부만 입력해도 됩니다. )\n");
            data = io.input();
            if (data.matches("[가-힣]+")) { // 이름 검색
                ret = removing(v, data, 0);
                break;
            }
            else if (data.matches("[0-9\\-]+")) { // 전화번호 검색
                ret = removing(v, data, 1);
                break;
            }
            else { // 예외
                utility.clearConsole();
                utility.retryMessage();
            }

        }
        return ret;
    }
    public static void run() throws Exception {
        byte[] b = new byte[999999];
        Vector<String>outputData = new Vector<String>();
        Vector<String>v = new Vector<String>();
        if (!new File(".\\phonebook.txt").exists()) {
            io.print("전화번호부가 비어있습니다.");
            return;
        } 
        FileInputStream fi = new FileInputStream(".\\phonebook.txt");
        StringBuilder ret = new StringBuilder();
        int deleteNumber;
        int idx = 0;
        fi.read(b);
        fi.close();
        for (String i: new String(b).trim().split("\n")) {
            outputData.add(i + " " + Integer.toString(idx));
            idx += 1;
        }
        io.print(outputData.toString());
        v = removeData(outputData);
        Object[] objs = v.toArray();
        Arrays.sort(objs);
        for (int i = 0; i < objs.length; i++) {
            String[] temp = objs[i].toString().split(" ");
            io.print(Integer.toString(i + 1) + ". " + temp[0] + " " + temp[1]);
        }
        io.print("삭제할 번호를 입력해주세요.");
        deleteNumber = Integer.parseInt(io.input()) - 1;
        outputData.remove(Integer.parseInt(objs[deleteNumber].toString().split(" ")[2]));
        for (String i: outputData) {
            String[] temp = i.split(" ");
            ret.append(temp[0] + " " + temp[1] + "\n");
        }
        FileOutputStream fo = new FileOutputStream(".\\phonebook.txt", false);
        fo.write(ret.toString().getBytes());
        fo.close();
    }
}
