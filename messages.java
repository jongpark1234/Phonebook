import java.io.IOException;

public class messages {
    public static void fileNotFoundMessage() throws IOException {
        io.print("파일이 존재하지 않습니다.");
    }
    public static void retryMessage() throws IOException {
        io.print("재입력 바랍니다.");
    }
    public static void cancelMessage() throws IOException {
        io.print("명령을 취소하였습니다.");
    }
}
