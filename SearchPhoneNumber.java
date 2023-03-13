import java.util.ArrayList;
import java.util.Collections;

public class SearchPhoneNumber extends PhoneBookTask {
    @Override
    public void run() throws Exception {
        if (!Utility.fileExists()) { // 파일이 존재하지 않는다면
            Messages.fileNotFoundMessage(); // 파일이 존재하지 않는다는 메세지 출력
            return; // 명령 종료
        }
        ArrayList<String> phoneNumbers = DataReader.fetchFileAndClose(Utility.DIR, false);
        while (true) {
            ArrayList<String> phoneNumArray = DataReader.chooseData(phoneNumbers, "전화번호 검색");
            if (Utility.isCancelled(phoneNumArray)) { // 명령 실행 종료 명령을 받을 시
                Utility.clearConsole(); // 터미널 청소
                Messages.cancelMessage(); // 명령이 취소되었다는 메세지 출력
                break; // 프로그램 종료
            }

            int phoneNumArraySize = phoneNumArray.size();
            if (phoneNumArraySize == 0) { // 만약 얻은 데이터가 없다면
                Utility.clearConsole(); // 터미널 청소
                Messages.searchResultNotFoundMessage(); // 검색 결과가 없다는 메세지 출력
                continue; // 다시 검색 키워드 입력 단계로 돌아감.
            }
            Collections.sort(phoneNumArray); // 검색으로 얻은 데이터들을 이름 기준 오름차순으로 정렬함.
            IOStream.print("\n총 " + phoneNumArraySize + "개의 검색 결과\n"); // 얻은 결과의 개수 출력
            for (String i : phoneNumArray) // 배열 내 요소 반복
                IOStream.print(i); // 해당 요소를 String 형태로 변환한 뒤 출력함.
            IOStream.print("");
            Utility.checking(); // 체킹
            break; // 해당 명령 종료
        }
    }

    @Override
    public String getTaskName() {
        return "전화번호 검색";
    }
}
