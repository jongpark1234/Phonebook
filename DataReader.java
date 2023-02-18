import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataReader {
    public static ArrayList<String> fetchFileAndClose(String file, boolean isNumbering) throws IOException {
        BufferedReader fi = new BufferedReader(new InputStreamReader(new FileInputStream(file))); // 파일을 읽을 FileInputStream
        ArrayList<String> phoneNumbers = DataReader.getFile(fi.lines().collect(Collectors.toList()), isNumbering); // 파일의 전체 목록을 가져옴.
        fi.close(); // 닫음.
        return phoneNumbers;
    }

    public static ArrayList<String> getFile(/*byte[] b*/List<String> array, boolean isNumbering) { // 파일에서 읽은 데아터를 문자열 형태로 ArrayList에 저장하는 함수
        int idx = 0; // 인덱스 변수 ( 삭제 명령에 필요 )
        ArrayList<String> ret = new ArrayList<String>(); // 데이터를 가공하여 저장할 벡터
        for (String i: /*new String(b).trim().split("\n")*/array) { // 문자열 양 쪽의 개행, 공백을 제거한 뒤 해당 문자를 개행으로 나눈 요소 반복
            String j = i.trim();
            ret.add(isNumbering ? j + " " + idx++ : j); // 넘버링이 필요한 경우에는 이름, 전화번호 뒤에 몇 번째 요소인지 여부도 함께 넣음.
        }
        return ret; // 벡터 반환
    }
    static ArrayList<String> choosing(List<String> v, String data, int idx) { // 원하는 문자열이 포함된 데이터를 반환하는 함수
        ArrayList<String> ret = new ArrayList<String>(); // 검색 결과를 저장할 벡터
        for (String i: v) { // 벡터 내 요소 반복
            if (i.split(" ")[idx].contains(data)) { // idx가 0이면 이름, 1이면 전화번호 내에서 검색함.
                ret.add(i); // data를 부분 문자열로 가진다면 ret에 add함.
            }
        }
        return ret; // 벡터 반환
    }
    public static ArrayList<String> chooseData(List<String> v, String message) throws Exception {
        String data;
        ArrayList<String> ret = new ArrayList<>();
        while (true) {
            IOStream.print(message + "\n\n이름 또는 전화번호를 입력해주세요. ( 일부만 입력해도 됩니다. )\n명령을 취소하려면 X를 입력해주세요.\n");
            data = IOStream.input(); // 이름 / 전화번호를 입력받음.
            if (data.equalsIgnoreCase("X")) { // 입력받은 값이 X 라면 ( 명령을 취소한다면 )
                ret.add(data); // X를 넣고
                return ret; // 벡터 반환
            }
            if (data.matches("[가-힣]+")) { // 이름 검색일 경우
                ret = choosing(v, data, 0); // 벡터 v에서 이름 부분에 data가 포함된 요소들을 가져옴
                break; // 반복문 탈출
            }
            else if (data.matches("[0-9\\-]+")) { // 전화번호 검색일 경우
                ret = choosing(v, data, 1); // 벡터 v에서 전화번호 부분에 data가 포함된 요소들을 가져옴
                break; // 반복문 탈출
            }
            else { // 예외
                Utility.clearConsole(); // 터미널 청소
                Messages.retryMessage(); // 재시도 메세지
            }
        }
        return ret; // 벡터 반환
    }
}
