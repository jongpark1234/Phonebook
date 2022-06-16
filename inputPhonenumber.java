import java.io.FileOutputStream;
public class inputPhonenumber {
    static String[] inputData() throws Exception {
        String[] data; // 입력받을 데이터를 저장할 변수
        while (true) {
            io.print("전화번호 등록\n\n\"이름 010-1234-5678\" 형태로 정보를 입력해주세요. 해당 명령을 취소하려면 \"X\"를 입력해주세요.\n");
            data = io.input().split(" "); // 공백을 기준으로 이름과 전화번호로 나눔.
            if (data.length == 2) { // 길이가 2라면 (이름, 전화번호가 정상적으로 입력되었다면)
                if (data[1].matches("^[0-9\\-]*$")) // 전화번호가 정상적인 형식이라면
                    break; // 반복문 탈출
                else { // 정상적인 형식이 아니라면
                    utility.clearConsole(); // 터미널 청소
                    messages.retryMessage(); // 재시도 메세지
                }
            }
            else { // 정상적으로 입력되지 않았다면
                if (data[0].equals("X")) { // 명령 실행 종료 명령을 받을 시
                    break; // 반복문 탈출
                }
                utility.clearConsole(); // 터미널 청소
                messages.retryMessage(); // 재시도 메세지
            }
        }
        return data; // 데이터 반환
    }
    public static void run() throws Exception {
        String[] data = inputData(); // 데이터 입력
        utility.clearConsole(); // 터미널 청소
        FileOutputStream file = new FileOutputStream(utility.DIR, true); // 파일을 쓸 FileOutputStream
        if (data.length == 2) { // 길이가 2라면 ( 정상적으로 입력이 이루어졌다면 )
            file.write((data[0] + " " + data[1] + "\n").getBytes()); // 파일에 "이름 전화번호\n" 형태로 데이터를 추가함
            io.print("성공적으로 등록되었습니다.");
            file.close(); // 파일 닫음
            return; // 명령 종료
        }
        messages.cancelMessage(); // X를 입력받았다면 명령 취소 메세지 출력
        file.close(); // 파일 닫음
    }
}
