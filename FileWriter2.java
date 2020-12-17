package InputOutput;
//演示对已有文件的续写
import java.io.*;
public class FileWriter2 {
    public static void main(String[] args) throws IOException
    {
        FileWriter fileWriter = new FileWriter("demo.txt",true);
        //传递一个true参数，代表不覆盖已经有的内容
        fileWriter.write("hello\nworld");
        fileWriter.close();
    }
}
