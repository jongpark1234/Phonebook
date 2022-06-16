import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;
public class removePhonenumber {
    static void printArray(Object[] arr) throws IOException { // 파일에서 얻은 데이터들을 출력하는 함수
        io.print("\n↓ 검색 결과 ↓\n");
        for (int i = 0; i < arr.length; i++) { // 배열의 길이까지 반복
            String[] temp = arr[i].toString().split(" "); // 해당 요소를 공백을 기준으로 나눔.
            io.print(Integer.toString(i + 1) + ". " + temp[0] + " " + temp[1]); // (번호). (이름) (전화번호) 형태로 출력함.
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
        StringBuilder ret = new StringBuilder(); // 파일에 덮어 씌울 StringBuilder
        int deleteNumber; // 지울 요소의 인덱스를 저장할 int
        fi.read(b); // 파일을 읽고
        fi.close(); // 닫음.
        while (true) {
            Vector<String> dataList = dataring.getFile(b, true); // 현재 있는 전체 데이터의 목록을 파일에서 가져옴.
            Object[] phonenumArray = dataring.chooseData(dataList, "전화번호 삭제").toArray(); // 검색 결과에 포함된 목록을 가져옴.
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
            while (true) {
                printArray(phonenumArray); // 검색에 포함된 데이터들을 출력함.
                io.print("삭제할 번호를 입력해주세요. 명령을 취소하려면 X를 입력해주세요.");
                try {
                    deleteNumber = Integer.parseInt(io.input()) - 1; // 삭제할 번호를 입력받음.
                } catch (Exception e) { // 받은 내용이 int 자료형이 아니라면
                    utility.clearConsole(); // 터미널 청소
                    messages.cancelMessage(); // 명령이 취소되었다는 메세지 출력
                    return; // 프로그램 종료
                }
                try {
                    dataList.remove(Integer.parseInt(phonenumArray[deleteNumber].toString().split(" ")[2])); // 해당 인덱스와 일치하는 원소를 전체 데이터 목록에서 삭제.
                    break; // 반복문 탈출
                } catch (Exception e) { // 입력받은 int 값이 데이터들의 인덱스를 벗아났다면
                    utility.clearConsole(); // 터미널 청소
                    messages.indexErrorMessage(); // 인덱스가 초과됐다는 메세지를 출력함.
                }
            }
            for (String i: dataList) { // 전체 데이터 목록을 한 바퀴씩 순회함.
                String[] temp = i.split(" "); // 값을 ['이름', '전화번호', '인덱스'] 형태로 나눔. 이는 파일에 저장할 때 필요하지 않은 인덱스를 제거하기 위함.
                ret.append(temp[0] + " " + temp[1] + "\n"); // 이름과 전화번호를 넣은 후 StringBuilder에 추가
            }
            FileOutputStream fo = new FileOutputStream(utility.DIR, false); // 파일을 쓸 FileOutputStream. 덮어 쓸 것이기 때문에 append는 false로 설정.
            fo.write(ret.toString().getBytes()); // 파일을 덮어씀.
            fo.close(); // FileOutputStream을 닫음.
            utility.clearConsole(); // 터미널 청소
            io.print("성공적으로 삭제하였습니다."); // 삭제 완료 메세지를 출력함.
            break; // 해당 명령 종료
        }
        
    }
}
