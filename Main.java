public class Main {
    public static void main(String[] args) throws Exception {
        int commandNumber; // 명령 번호를 입력받을 변수
        Utility.clearConsole(); // 터미널 청소
        while (true) {
            IOStream.print("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 전화번호부 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
            IOStream.print("1. 전화번호 등록\t2. 전화번호 검색\t3. 전화번호 삭제\n4. 전화번호 목록\t5. 프로그램 종료\n");
            System.out.print("번호를 입력하세요 : ");
            try {
                commandNumber = Integer.parseInt(IOStream.input()); // 명령 번호 입력
                Utility.clearConsole(); // 터미널 청소
            } catch (Exception e) { // 입력받은 값이 정수가 아니라면
                Utility.clearConsole(); // 터미널 청소
                IOStream.print("정수를 입력해주세요.");
                continue; // 프로그램 재시작
            }
            if (commandNumber < 1 || commandNumber > 5) { // 번호 입력 제한 범위를 벗어났다면
                IOStream.print("명령이 가능한 정수를 입력해주세요.");
                continue;
            }
            switch (commandNumber) {
                case 1: // 1번 명령
                    InputPhoneNumber.run(); // 전화번호 등록
                    break;
                case 2: // 2번 명령
                    SearchPhoneNumber.run(); // 전화번호 검색
                    break;
                case 3: // 3번 명령
                    RemovePhoneNumber.run(); // 전화번호 삭제
                    break;
                case 4: // 4번 명령
                    PrintPhoneNumber.run(); // 전화번호 목록
                    break;
                case 5: // 5번 명령
                    IOStream.print("프로그램이 종료되었습니다.");
                    System.exit(0); // 프로그램 종료
                default:
                    break;
            }
        }
    }
}