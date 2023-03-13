import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        int commandNumber; // 명령 번호를 입력받을 변수
        Utility.clearConsole(); // 터미널 청소

        PhoneBookTask.registerTask(new InputPhoneNumber());
        PhoneBookTask.registerTask(new PrintPhoneNumber());
        PhoneBookTask.registerTask(new RemovePhoneNumber());
        PhoneBookTask.registerTask(new SearchPhoneNumber());
        PhoneBookTask.registerTask(new ExitPhoneBook());

        while (true) {
            IOStream.print("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 전화번호부 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
            PhoneBookTask.printTasks();
            System.out.print("번호를 입력하세요 : ");
            try {
                commandNumber = Integer.parseInt(IOStream.input()); // 명령 번호 입력
                Utility.clearConsole(); // 터미널 청소
            } catch (Exception e) { // 입력받은 값이 정수가 아니라면
                Utility.clearConsole(); // 터미널 청소
                IOStream.print("정수를 입력해주세요.");
                continue; // 프로그램 재시작
            }

            try {
                PhoneBookTask.run(commandNumber);
            } catch (IllegalArgumentException e) {
                Messages.indexErrorMessage();
            }
        }
    }
}