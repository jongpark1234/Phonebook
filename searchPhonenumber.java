import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Vector;

public class searchPhonenumber {
    static Vector<String> searching(Vector<String> v, String data, int idx) {
        Vector<String> ret = new Vector<String>();
        for (String i: v) {
            if (i.split(" ")[idx].contains(data)) {
                ret.add(i);
            }
        }
        return ret;
    }

    static Vector<String> searchData(Vector<String> v) throws Exception {
        String data;
        Vector<String> ret = new Vector<String>();
        while (true) {
            io.print("전화번호 검색\n\n이름 또는 전화번호를 입력해주세요. ( 일부만 입력해도 됩니다. )\n");
            data = io.input();
            if (data.matches("[가-힣]+")) { // 이름 검색
                ret = searching(v, data, 0);
                break;
            }
            else if (data.matches("[0-9\\-]+")) { // 전화번호 검색
                ret = searching(v, data, 1);
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
        Vector<String> v = new Vector<String>();
        if (!new File(".\\phonebook.txt").exists()) {
            io.print("전화번호부가 비어있습니다.");
            return;
        }
        FileInputStream fi = new FileInputStream(".\\phonebook.txt");
        fi.read(b);
        fi.close();
        for (String i: new String(b).trim().split("\n")) {
            v.add(i);
        }
        v = searchData(v);
        Object[] objs = v.toArray();
        Arrays.sort(objs);
        for (int i = 0; i < objs.length; i++) {
            System.out.println(objs[i]);
        }

    }
}
