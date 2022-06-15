import java.io.FileOutputStream;
public class inputPhonenumber {
    static String[] inputData() throws Exception {
        String[] data;
        while (true) {
            io.print("전화번호 등록\n\n\"이름 010-1234-5678\" 형태로 정보를 입력해주세요. 해당 명령을 취소하려면 \"X\"를 입력해주세요.\n");
            data = io.input().split(" ");
            if (data.length == 2) {
                if (data[1].matches("^[0-9\\-]*$"))
                    break;
                else {
                    utility.clearConsole();
                    utility.retryMessage();
                }
            }
            else {
                if (data[0].equals("X")) {
                    break;
                }
                utility.clearConsole();
                utility.retryMessage();
            }
        }
        return data;
    }
    public static void run() throws Exception {
        String[] data = inputData();
        utility.clearConsole();
        FileOutputStream file = new FileOutputStream(".\\phonebook.txt", true);
        if (data.length == 2) {
            file.write((data[0] + " " + data[1] + "\n").getBytes());
            io.print("성공적으로 등록되었습니다.");
            file.close();
            return;
        }
        io.print("명령을 취소했습니다.");
        file.close();
    }
}
