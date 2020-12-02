package Experiment2.V2;

import java.util.Random;

public class Exercise {
    private static final short OPERATION_NUMBER=50;
    private BinaryOperation operationList[] = new BinaryOperation[OPERATION_NUMBER];
    //创建了数组，存放50个BinaryOperation类型的对象，用来表示算式
    //负责产生一组算式，作为习题
    public void generateBinaryExercise(int operationCount){
        //生成加减法混合运算，operationCount代表需要生成的算式数量
        int i= 0;
        BinaryOperation anOperation;
        while (operationCount>0)
        {
            do {
                anOperation = generateOperation();
            }while (contains(anOperation,i));
//            把anOperation加入到Exercise
            operationCount--;
            operationList[i]=anOperation;
            i++;
            //生成一个算式后，需要生成的算式数量就减一
        }
    }
    private boolean contains(BinaryOperation anOperation,int length){
        //查找习题中是否有这个算式，返回值true代表有相同的算式，false代表没有
        boolean found=false;
        for (int i=0;i<length;i++){
            if(anOperation.equals(operationList[i])){
                found = true;
                break;
            }
        }
        return found;
    }
    private BinaryOperation generateOperation(){
        Random random = new Random();
        int opValue = random.nextInt(2);
        if(opValue == 1)
        {
            return new AdditionOperation();

        }else
        {
            return new SubstractOperation();
        }

    }
    public void generateAdditionExercise(int operationCount){
        //只生成加法算式
        int i= 0;
        BinaryOperation anOperation;
        while (operationCount>0)
        {
            do {
                anOperation = new AdditionOperation();
            }while (contains(anOperation,i));
//            把anOperation加入到Exercise
            operationCount--;

            operationList[i]=anOperation;
            i++;
            //生成一个算式后，需要生成的算式数量就减一
        }
    }
    public void generateSubstractExercise(int operationCount){
        //只生成减法算式
        int i= 0;
        BinaryOperation anOperation;
        while (operationCount>0)
        {
            do {
                anOperation = new SubstractOperation();
            }while (contains(anOperation,i));
//            把anOperation加入到Exercise
            operationCount--;
            operationList[i]=anOperation;
            i++;
            //生成一个算式后，需要生成的算式数量就减一
        }
    }
    public void formattedDisplay(int nums,int columns){
        //格式化显示
        //利用BinaryOperation的toString方法进行输出
        Exercise exercise = new Exercise();
        for (int i=0;i<nums;i++)
        {
//            System.out.println(exercise.operationList[i].toString());
//            System.out.println(exercise.operationList[i].asString());
//            System.out.printf("%-14s ",exercise.operationList[i].fullString());
            System.out.printf("(%2d)",(i+1));
            System.out.printf("%2d%c%2d=   ",operationList[i].getLeft_operand(),operationList[i].getOperator(),
                    operationList[i].getRight_operand());
            if ((i+1)%columns==0)
            {
                System.out.printf("\n");
            }

        }
    }

}
