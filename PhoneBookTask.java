import java.util.ArrayList;
import java.util.List;

public abstract class PhoneBookTask {

    public abstract void run() throws Exception;

    public abstract String getTaskName();

    private static final List<PhoneBookTask> tasks = new ArrayList<>();

    public static void registerTask(PhoneBookTask task) {
        tasks.add(task);
    }

    public static void run(int n) throws Exception {
        if (1 <= n && n <= tasks.size())
            tasks.get(n - 1).run();
        else throw new IllegalArgumentException(String.format("%d is not correct number", n));
    }

    public static List<PhoneBookTask> printTasks() {
        StringBuilder sb = new StringBuilder();
        List<PhoneBookTask> tasks = PhoneBookTask.getTasks();
        for (int i = 0; i < tasks.size(); i++) {
            sb.append(i + 1)
                    .append(". ")
                    .append(tasks.get(i).getTaskName())
                    .append('\t');
        }
        IOStream.print(sb.toString());
    }

}
