package InputOutput;

import java.io.*;
public class FileWriter1 {
    public static void main(String[] args) throws IOException
    {
        FileWriter fileWriter = new FileWriter("demo.txt");
        //创建新的文件，如果已经有同名文件，就将同名文件覆盖掉
//        fileWriter.write("wujiale666");
        //这样写不会存到txt文件中，是写到内存中的流当中
        fileWriter.write("wujiale");
//        fileWriter.flush();
        //必须得用刷新操作才行
        fileWriter.write("haha");
        fileWriter.flush();
        fileWriter.close();
        //注意flush和close区别，close关闭流资源，但是关闭之前会刷新一次缓冲中的数据，
        //将数据刷到目的地中，flush刷新后流可以继续输入，close之后不可以，最后必须进行关闭
    }
}