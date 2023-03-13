public class ExitPhoneBook extends PhoneBookTask {
    @Override
    public void run() throws Exception {
        IOStream.print("프로그램이 종료되었습니다.");
        System.exit(0);
    }

    @Override
    public String getTaskName() {
        return "프로그램 종료";
    }
}
