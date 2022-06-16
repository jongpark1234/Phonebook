import java.io.IOException;

public class messages {
    public static void fileNotFoundMessage() throws IOException { // 파일이 존재하지 않을 때 메세지
        io.print("파일이 존재하지 않습니다.");
    }
    public static void retryMessage() throws IOException { // 재입력이 필요할 때 메세지
        io.print("재입력 바랍니다.");
    }
    public static void cancelMessage() throws IOException { // 명령이 취소되었을 때 메세지
        io.print("명령을 취소하였습니다.");
    }
    public static void searchResultNotFoundMessage() throws IOException { // 입력 결과가 존재하지 않을 때 메세지
        io.print("검색 결과가 존재하지 않습니다.\n");
    }
    public static void indexErrorMessage() throws IOException { // 인덱스 에러일 때 메세지
        io.print("인덱스 범위를 벗어났습니다. 다시 입력해주세요.");
    }
}
