import java.io.*;
import java.nio.charset.StandardCharsets;

public class IOStream {
    public static BufferedReader br = null;
    public static BufferedWriter bw = null;

    public static String input() throws IOException { // 입력을 받는 함수
        if (br == null) br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        return br.readLine();
    }
    public static void print(String stringLine) throws IOException { // 출력을 하는 함수
        if (bw == null) bw = new BufferedWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
        bw.write(stringLine + "\n");
        bw.flush();
    }
}
