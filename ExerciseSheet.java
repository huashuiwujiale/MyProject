package Experiment3;

import com.csvreader.CsvReader;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

public class ExerciseSheet {
    //获取最后一个问题
    public static int[] resultList1 = new int[50];
    public static int[] resultList2 = new int[50];
    public static int right = 0,wrong = 0;
    public static void get_last_pro()
    {
        ArrayList<String[]> lstFile = new ArrayList<String[]>();
        String pathCSV = "d:\\problem.csv";
        try {
            CsvReader reader = new CsvReader(pathCSV,',', Charset.forName("gb2312"));
            reader.readHeaders();
            while(reader.readRecord()){
                //System.out.println(reader.getRawRecord());
                lstFile.add(reader.getValues());
            }
            reader.close();
            for(int i=0; i<lstFile.size(); ++i)
            {
                System.out.printf("（%2d）%-8s____   ",(i+1),lstFile.get(i)[0]);
                //字符串的输出
//                System.out.print("**");
                if((i+1)%5==0) System.out.printf("\n");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void get_last_pro(int i)
    {
        ArrayList<String[]> lstFile = new ArrayList<String[]>();
        String pathCSV = "d:\\problem.csv";
        try {
            CsvReader reader = new CsvReader(pathCSV,',', Charset.forName("gb2312"));
            reader.readHeaders();
            while(reader.readRecord()){
                //System.out.println(reader.getRawRecord());
                lstFile.add(reader.getValues());
            }
            reader.close();
            System.out.printf("（%2d）%-8s____   ",(i),lstFile.get(i-1)[0]);
            //字符串的输出
//          System.out.print("**");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //获取算式的答案情况，找到-1
    public static int get_last_record()
    {
        ArrayList<String[]> lstFile = new ArrayList<String[]>();
        int[] resultList = new int[50];
        int temp = 0;
        String pathCSV = "d:\\problemResult.csv";
        try {
            CsvReader reader = new CsvReader(pathCSV,',', Charset.forName("gb2312"));
            reader.readHeaders();
            while(reader.readRecord()){
                //System.out.println(reader.getRawRecord());
                lstFile.add(reader.getValues());
//                System.out.println(reader.getValues());
            }
            reader.close();

            for(int i=0; i<lstFile.size(); ++i)
            {
//                if(lstFile.get(i)[0].equals("-1"))
//                System.out.println(lstFile.get(i)[0]);
                resultList[i]=Integer.parseInt(lstFile.get(i)[0]);
                if(Integer.parseInt(lstFile.get(i)[0])==-1)
                {
                    temp= i;
                    break;
                }
            }
            get_last_pro();//重新输出50题，提醒用户从第几题开始
            System.out.printf("上次你做到了第%d题，请继续。下面请开始做第%d题",temp,temp+1);
            //将i传递过去，表明i之前的算式都已经做完了
            get_resultLIst_pro(resultList,temp);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return temp;
    }
    //用于输出没做完的题，i之前的算式都已经做完
    public static void get_resultLIst_pro(int resultList[],int start)
    {
        start = start+1;
        Exercise exercise = new Exercise();
        System.out.println("请在对应题号后开始作答！");
        System.out.println("如果想停止做题，请输入-1。");
        for (int i = start; i <= 50; ++i)//输出算式，将答案保存到resultList
        {
//            System.out.print(i);
            get_last_pro(i);
            Scanner scanner3 = new Scanner(System.in);
            resultList[i - 1] = scanner3.nextInt();
            //当用户输入-1时，表明不想继续做下去
            if (resultList[i - 1] == -1) {
                System.out.println("做题记录已保存，下次可以选择继续做");
                break;
            }
        }
        exercise.pro_save_userResult(resultList);//保存用户答案
    }
    public static void readProblemAutoResult(){
        //存放系统生成答案放到resultList1
        ArrayList<String[]> lstFile = new ArrayList<String[]>();
        int temp = 0;
        String pathCSV = "d:\\problemAutoResult.csv";
        try {
            CsvReader reader = new CsvReader(pathCSV,',', Charset.forName("gb2312"));
            reader.readHeaders();
            while(reader.readRecord()){
                //System.out.println(reader.getRawRecord());
                lstFile.add(reader.getValues());
//                System.out.println(reader.getValues());
            }
            reader.close();
            for(int i=0; i<lstFile.size(); ++i)
            {
                resultList1[i]=Integer.parseInt(lstFile.get(i)[0]);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void readProblemResult(){
        ////存放系统生成答案放到resultList2
        ArrayList<String[]> lstFile = new ArrayList<String[]>();
        int temp = 0;
        String pathCSV = "d:\\problemResult.csv";
        try {
            CsvReader reader = new CsvReader(pathCSV,',', Charset.forName("gb2312"));
            reader.readHeaders();
            while(reader.readRecord()){
                //System.out.println(reader.getRawRecord());
                lstFile.add(reader.getValues());
//                System.out.println(reader.getValues());
            }
            reader.close();
            for(int i=0; i<lstFile.size(); ++i)
            {
                resultList2[i]=Integer.parseInt(lstFile.get(i)[0]);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void compare(){
        //系统生成答案=resultList1，用户答案=resultList2
        for(int i=0;i<50;i++)
        {
            if(resultList2[i]!=-1)
            {
                if(resultList1[i]==resultList2[i])
                {
                    right++;
                }
                else {
                    wrong++;
                }
            }
            else if(resultList2[i]==-1)
            {
                break;
            }
        }

        System.out.printf("正确题目数为：%d\n",right);
        System.out.printf("错误题目数为：%d\n",wrong);
    }
    public static void main(String[] args) {
        Exercise exercise = new Exercise();
        int[] resultList = new int[50];//用来暂时存放用户输入的结果
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("请选择重新生成（输入1）题或者继续上次的做题记录（输入2）");
        int record = 0;
        record = scanner2.nextInt();
        if (record == 1) {
            System.out.println("即将开始为你生成算式，题量为50。\n1代表加减法混合算式，2代表加法算式，3代表加法算式，请输入想做的题的种类。");
            Scanner scanner = new Scanner(System.in);
            int type = scanner.nextInt();
            if (type == 1) {
                exercise.generateBinaryExercise(50);
                //生成加减法混合算式
            }
            else if (type == 2) {
                exercise.generateAdditionExercise(50);
                //只生成加法算式
            }
            else if (type == 3) {
                exercise.generateSubstractExercise(50);
                //只生成减法算式
            }
//        exercise.formattedDisplay(50,5);
            exercise.pro_save_exercise(50);
            //将生成的50个算式进行保存
            get_last_pro();
            exercise.pro_save_exerciseResult(50);
            //输出算式的方法，并且每行显示5个算式，先全部输出，再作答
            System.out.println("请在对应题号后开始作答！");
            System.out.println("如果想停止做题，请输入-1。");
            for (int i = 1; i <= 50; ++i)//输出算式，将答案保存到resultList
            {
//            System.out.print(i);
                get_last_pro(i);
                Scanner scanner1 = new Scanner(System.in);

                resultList[i - 1] = scanner1.nextInt();
                //当用户输入-1时，表明不想继续做下去
                if (resultList[i - 1] == -1) {
                    System.out.println("做题记录已保存，下次可以选择继续做");
                    break;
                }
            }
            exercise.pro_save_userResult(resultList);//保存用户答案
            readProblemResult();
            readProblemAutoResult();
            compare();
        }
        else if (record == 2)
        {

//            int start=0;
            //可以返回开始的题目数
            get_last_record();
//            System.out.println(value);经过测试,start能接收到正确是开始题号；
            readProblemResult();
            readProblemAutoResult();
            compare();
        }
        else
        {
            System.out.println("输入有误！");
        }
    }
}
