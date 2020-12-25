package Experiment3;

import com.csvreader.CsvReader;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class ExerciseSheet {
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
                System.out.print(lstFile.get(i)[0]);
                System.out.print("**");
                if((i+1)%5==0) System.out.printf("\n");
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Exercise exercise = new Exercise();
//        exercise.generateBinaryExercise(50);
        //生成加减法混合算式
//        exercise.generateAdditionExercise(25);
        //只生成加法算式
//        exercise.generateSubstractExercise(25);
        //只生成减法算式
        exercise.generateBinaryExercise(50);
        exercise.formattedDisplay(50,5);
        exercise.pro_save(50);
        //输出算式的方法，并且每行显示5个算式
        get_last_pro();

    }
}
