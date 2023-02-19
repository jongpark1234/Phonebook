import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrintPhoneNumber {
    public static void run() throws Exception {
        if (!Utility.fileExists()) { // 파일이 존재하지 않는다면
            Messages.fileNotFoundMessage(); // 파일이 존재하지 않는다는 메세지 출력
            return; // 명령 종료
        }
        List<String> phoneNumbers = DataReader.fetchFileAndClose(Utility.DIR, false);
        if (Utility.isCancelled(phoneNumbers)) { // 명령 실행 종료 명령을 받을 시
            Utility.clearConsole(); // 터미널 청소
            Messages.cancelMessage(); // 명령이 취소되었다는 메세지 출력
            return; // 프로그램 종료
        }
        Collections.sort(phoneNumbers); // 검색으로 얻은 데이터들을 이름 기준 오름차순으로 정렬함.
        IOStream.print("ㅡㅡ  전화번호 목록 ㅡㅡ");
        for (Object i : phoneNumbers) { // 배열 내 요소 반복
            IOStream.print(i.toString()); // 해당 요소를 String 형태로 변환한 뒤 출력함.
        }
        IOStream.print("");
        Utility.checking(); // 체킹
    }
}
