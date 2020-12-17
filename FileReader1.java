package InputOutput;
import java.io.*;
public class FileReader1 {
    public static void main(String[] args) throws IOException
    {
        //创建一个文件读取流对象，和指定名称的文件名相关联
        //要保证该文件是已经存在的
        FileReader fr = new FileReader("demo.txt");
        //调用读取流的read方法,read()方法一次读一个字符，而且会一直读下去
//        int ch = fr.read();
//        System.out.println("ch"+(char)ch);
        //此时我的demo.txt 文件中的第一个是字母a，输出的是ch97，转换成了int,可以使用强制转换
        /*while (true)
        {
            int ch= fr.read();
            if(ch==-1)
                break;
            System.out.println("ch="+(char)ch);
        }*/
        int ch=0;
        while ((ch=fr.read())!=-1)
        {
            System.out.println("ch="+(char)ch);
        }
        fr.close();

    }
}
