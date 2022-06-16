import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class searchPhonenumber {
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
        while (true) {
            Object[] phonenumArray = dataring.chooseData(dataring.getFile(b, false), "전화번호 검색").toArray(); // 검색 결과에 포함된 목록을 가져옴.
            if (utility.isCanceled(phonenumArray)) { // 명령 실행 종료 명령을 받을 시
                utility.clearConsole(); // 터미널 청소
                messages.cancelMessage(); // 명령이 취소되었다는 메세지 출력
                break; // 프로그램 종료
            }
            if (phonenumArray.length == 0) { // 만약 얻은 데이터가 없다면
                utility.clearConsole(); // 터미널 청소
                messages.searchResultNotFoundMessage(); // 검색 결과가 없다는 메세지 출력
                continue; // 다시 검색 키워드 입력 단계로 돌아감.
            }
            Arrays.sort(phonenumArray); // 검색으로 얻은 데이터들을 이름 기준 오름차순으로 정렬함.
            io.print("\n총 " + Integer.toString(phonenumArray.length) + "개의 검색 결과\n"); // 얻은 결과의 개수 출력
            printArray(phonenumArray); // 검색으로 얻은 결과를 출력함
            utility.checking(); // 체킹
            break; // 해당 명령 종료
        }
    }
}
