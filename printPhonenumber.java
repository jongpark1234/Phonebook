import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class printPhonenumber {
    static void printArray(Object[] arr) throws IOException { // 파일에서 얻은 데이터들을 출력하는 함수.
        for (Object i: arr) { // 배열 내 요소 반복
            io.print(i.toString()); // 해당 요소를 String 형태로 변환한 뒤 출력함.
        }
        io.print("");
    }
    public static void run() throws Exception {
        if (!utility.fileExists()) { // 파일이 존재하지 않는다면
            messages.fileNotFoundMessage(); // 파일이 존재하지 않는다는 메세지 출력
            return; // 명령 종료
        }
        byte[] b = new byte[999999]; // 읽은 파일을 저장할 byte 자료형의 배열
        FileInputStream fi = new FileInputStream(utility.DIR); // 파일을 읽을 FileInputStream
        fi.read(b); // 파일을 읽고
        fi.close(); // 닫음.
        Object[] phonenumArray = dataring.getFile(b, false).toArray(); // 파일의 전체 목록을 가져옴.
        if (utility.isCanceled(phonenumArray)) { // 명령 실행 종료 명령을 받을 시
            utility.clearConsole(); // 터미널 청소
            messages.cancelMessage(); // 명령이 취소되었다는 메세지 출력
            return; // 프로그램 종료
        }
        Arrays.sort(phonenumArray); // 검색으로 얻은 데이터들을 이름 기준 오름차순으로 정렬함.
        io.print("ㅡㅡ  전화번호 목록 ㅡㅡ");
        printArray(phonenumArray); // 파일 목록을 출력함
        utility.checking(); // 체킹
    }
}
