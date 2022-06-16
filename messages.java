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
    public static void searchResultNotFoundMessage() throws IOException {
        io.print("검색 결과가 존재하지 않습니다.\n");
    }
    public static void indexErrorMessage() throws IOException {
        io.print("인덱스 범위를 벗어났습니다. 다시 입력해주세요.");
    }
}
