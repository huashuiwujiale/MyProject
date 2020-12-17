package InputOutput;

import java.io.*;
public class IOException1 {
    public static void main(String[] args) {
        FileWriter fw = null;
        try {
//            fw = new FileWriter("demo.txt");
            fw = new FileWriter("k:\\demo.txt");
            //创建对象时，如果出现异常，创建失败，那么下面调用时会出现指针异常
            fw.write("abcdef");
        }
        catch (IOException e)
        {
            System.out.println("捕获到异常"+e.toString());
        }
        finally {
            try {
                if(fw!=null)
                   fw.close();
                //一定要进行判断
            }
            catch (IOException e)
            {
                System.out.println(e.toString());
            }
        }

    }
}


