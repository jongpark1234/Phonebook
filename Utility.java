import java.io.File;
import java.io.IOException;
public class utility {
    public static final String DIR = ".\\phonebook.txt";
    public static Boolean fileExists() throws IOException { // 파일이 존재하는지 여부를 보내는 함수
        return new File(DIR).exists(); // exists 함수를 사용하여 true / false를 반환함.
    }
    public static void clearConsole() throws IOException {
        io.print("\033[H\033[2J"); // 탈출 문자를 사용하여 터미널의 위치를 현재에 맞춤.
    }
    public static void checking() throws IOException { // 사용자의 명령이 있을 때 까지 대기시키는 함수
        io.print("다음으로 넘어가려면 엔터 키를 입력해주세요.");
        io.input(); // 무엇인가를 입력받을 때 까지 대기시킴.
        clearConsole(); // 터미널 청소
    }
    public static Boolean isCanceled(Object[] arr) throws IOException { // 해당 명령이 취소됐는지 여부를 판별하는 함수
        if (arr.length == 0) { // 받은 배열의 길이가 0이라면
            return false; // 검색 결과가 존재하지 않는 것이고, 취소된 것이 아님.
        }
        return arr[0].toString().equals("X"); // X를 받았으면 true를 반환하고, 아니면 false를 반환함.
    }
}
