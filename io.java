import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class io {
    public static String input() throws IOException { // 입력을 받는 함수
        BufferedReader BufferReader = new BufferedReader(new InputStreamReader(System.in, "euc-kr"));
        return BufferReader.readLine();
    }
    public static void print(String stringLine) throws IOException { // 출력을 하는 함수
        BufferedWriter BufferWriter = new BufferedWriter(new OutputStreamWriter(System.out, "euc-kr"));
        BufferWriter.write(stringLine + "\n");
        BufferWriter.flush();
    }
}
