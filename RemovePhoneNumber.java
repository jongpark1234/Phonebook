import java.io.FileOutputStream;
import java.util.*;

public class RemovePhoneNumber {
    public static void run() throws Exception {
        if (!Utility.fileExists()) { // 파일이 존재하지 않는다면
            Messages.fileNotFoundMessage(); // 파일이 존재하지 않는다는 메세지 출력
            return; // 명령 종료
        } 
        StringBuilder ret = new StringBuilder(); // 파일에 덮어 씌울 StringBuilder
        int deleteNumber; // 지울 요소의 인덱스를 저장할 int
        List<String> data = DataReader.fetchFileAndClose(Utility.DIR, true);
        while (true) {
            ArrayList<String> phoneNumArray = DataReader.chooseData(data, "전화번호 삭제"); // 검색 결과에 포함된 목록을 가져옴.
            int phoneNumArraySize = phoneNumArray.size();
            if (Utility.isCancelled(phoneNumArray)) { // 명령 실행 종료 명령을 받을 시
                Utility.clearConsole(); // 터미널 청소
                Messages.cancelMessage(); // 명령이 취소되었다는 메세지 출력
                break; // 프로그램 종료
            }
            if (phoneNumArraySize == 0) { // 만약 얻은 데이터가 없다면
                Utility.clearConsole(); // 터미널 청소
                Messages.searchResultNotFoundMessage(); // 검색 결과가 없다는 메세지 출력
                continue; // 다시 검색 키워드 입력 단계로 돌아감.
            }
            Collections.sort(phoneNumArray); // 검색으로 얻은 데이터들을 이름 기준 오름차순으로 정렬함.
            while (true) {
                IOStream.print("\n↓ 검색 결과 ↓\n");
                int i = 0;
                for (String a : phoneNumArray) { // 배열의 길이까지 반복
                    String[] temp = a.split(" "); // 해당 요소를 공백을 기준으로 나눔.
                    IOStream.print(i + 1 + ". " + temp[0] + " " + temp[1]); // (번호). (이름) (전화번호) 형태로 출력함.
                    ++i;
                }
                IOStream.print("");
                IOStream.print("삭제할 번호를 입력해주세요. 명령을 취소하려면 X를 입력해주세요.");
                try {
                    deleteNumber = Integer.parseInt(IOStream.input()) - 1; // 삭제할 번호를 입력받음.
                } catch (Exception e) { // 받은 내용이 int 자료형이 아니라면
                    Utility.clearConsole(); // 터미널 청소
                    Messages.cancelMessage(); // 명령이 취소되었다는 메세지 출력
                    return; // 프로그램 종료
                }
                try {
                    phoneNumArray.remove(deleteNumber);
                    break; // 반복문 탈출
                } catch (Exception e) { // 입력받은 int 값이 데이터들의 인덱스를 벗아났다면
                    Utility.clearConsole(); // 터미널 청소
                    Messages.indexErrorMessage(); // 인덱스가 초과됐다는 메세지를 출력함.
                }
            }
            for (String i: phoneNumArray) { // 전체 데이터 목록을 한 바퀴씩 순회함.
                String[] temp = i.split(" "); // 값을 ['이름', '전화번호', '인덱스'] 형태로 나눔. 이는 파일에 저장할 때 필요하지 않은 인덱스를 제거하기 위함.
                ret.append(temp[0]).append(" ").append(temp[1]).append("\n"); // 이름과 전화번호를 넣은 후 StringBuilder에 추가
            }
            FileOutputStream fo = new FileOutputStream(Utility.DIR, false); // 파일을 쓸 FileOutputStream. 덮어 쓸 것이기 때문에 append는 false로 설정.
            fo.write(ret.toString().getBytes()); // 파일을 덮어씀.
            fo.close(); // FileOutputStream을 닫음.
            Utility.clearConsole(); // 터미널 청소
            IOStream.print("성공적으로 삭제하였습니다."); // 삭제 완료 메세지를 출력함.
            break; // 해당 명령 종료
        }
        
    }
}
