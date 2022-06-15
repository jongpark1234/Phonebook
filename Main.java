public class Main {
    public static void main(String[] args) throws Exception {
        int commandNumber;
        utility.clearConsole();
        while (true) {
            io.print("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 전화번호부 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
            io.print("1. 전화번호 등록\t2. 전화번호 검색\t3. 전화번호 삭제\n4. 프로그램 종료\n");
            System.out.printf("번호를 입력하세요 : ");
            try {
                commandNumber = Integer.parseInt(io.input());
                utility.clearConsole();
            } catch (Exception e) {
                utility.clearConsole();
                io.print("정수를 입력해주세요.");
                continue;
            }
            if (commandNumber < 1 || commandNumber > 4) {
                io.print("명령이 가능한 정수를 입력해주세요.");
                continue;
            }
            switch (commandNumber) {
                case 1:
                    inputPhonenumber.run();
                    break;
                case 2:
                    searchPhonenumber.run();
                    break;
                case 3:
                    removePhonenumber.run();
                    break;
                case 4:
                    io.print("프로그램이 종료되었습니다.");
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}