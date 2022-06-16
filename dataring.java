import java.util.Vector;
public class dataring {
    public static Vector<String> getFile(byte[] b, Boolean isNumbering) {
        int idx = 0;
        Vector<String> ret = new Vector<String>();
        for (String i: new String(b).trim().split("\n")) {
            ret.add(isNumbering ? i + " " + Integer.toString(idx++) : i);
        }
        return ret;
    }
    static Vector<String> choosing(Vector<String> v, String data, int idx) {
        Vector<String> ret = new Vector<String>();
        for (String i: v) {
            if (i.split(" ")[idx].contains(data)) {
                ret.add(i);
            }
        }
        return ret;
    }
    public static Vector<String> chooseData(Vector<String> v, String message) throws Exception {
        String data;
        Vector<String> ret = new Vector<String>();
        while (true) {
            io.print(message + "\n\n이름 또는 전화번호를 입력해주세요. ( 일부만 입력해도 됩니다. )\n명령을 취소하려면 X를 입력해주세요.\n");
            data = io.input();
            io.print(data);
            if (data.equals("X")) {
                ret.add(data);
                return ret;
            }
            if (data.matches("[가-힣]+")) { // 이름 검색
                ret = choosing(v, data, 0);
                break;
            }
            else if (data.matches("[0-9\\-]+")) { // 전화번호 검색
                ret = choosing(v, data, 1);
                break;
            }
            else { // 예외
                utility.clearConsole();
                messages.retryMessage();
            }
        }
        return ret;
    }
}
