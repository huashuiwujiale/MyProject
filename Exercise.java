package Experiment2.V1;

public class Exercise {
    private static final short OPERATION_NUMBER=50;
    private static final short COLUMN_NUMBER=5;
    private BinaryOperation operationList[] = new BinaryOperation[OPERATION_NUMBER];
    private static int count=0;
//    创建了数组，存放50个BinaryOperation类型的对象，用来表示算式
    public void generateBinaryxercise(){
        //生成二元算式
        BinaryOperation anOperation = new BinaryOperation();
        //anOperation用来存放generateBinaryOperation()生成的算式（对象）
        BinaryOperation opCreater = new BinaryOperation();
        //opCreater用来调用generateBinaryOperation()方法创造算式（对象）
        for (int i=0;i<OPERATION_NUMBER;i++)
        {
            anOperation = opCreater.generateBinaryOperation();
            while (contains(anOperation,i-1))
            //while循环用来判断习题集中是否已经存在该算式
            //如果已经存在该算式，那么重新生成一个算式，然后继续循环进行比较，直到这个算式不会再次出现
            {
                anOperation = opCreater.generateBinaryOperation();
            }
            operationList[i]=anOperation;
            //将符合条件的算式放入数组中
        }
    }
//    public void generateAdditionExercise(){
//        //将加法算式加入练习题尾部
//
//    }
//    public void generateSubstractExercise(){
//        //将减法算式加入练习题尾部
//
//    }
//public void generateAdditionExercise(){
//    BinaryOperation anOperation, opCreator = new BinaryOperation_3_1();
//    for(int i=0; i < OPERATION_NUMBER; i++){
//        anOperation = opCreator.generateAdditionOperation();
//        while (contains(anOperation,i-1)){
//            anOperation = opCreator.generateAdditionOperation();
//        }
//        operationList[i]= anOperation;
//    }
//}
//    public void generateSubstractExercise(){
//        BinaryOperation anOperation, opCreator = new BinaryOperation_3_1();
//        for(int i=0; i < OPERATION_NUMBER; i++){
//            anOperation = opCreator.generateSubstractOperation();
//            while (contains(anOperation,i-1)){
//                anOperation = opCreator.generateSubstractOperation();
//            }
//            operationList[i]= anOperation;
//        }
//    }
    private boolean contains(BinaryOperation anOperation,int length){
        //查找习题中是否有这个算式，返回值true代表有相同的算式，false代表没有
        boolean found=false;
        for (int i=0;i<=length;i++){
            if(anOperation.equals(operationList[i])){
                found = true;
                break;
            }
        }
        return found;
    }
    static void formateAndDisplay(){
        //格式化显示
        //利用BinaryOperation的toString方法进行输出
        Exercise exercise = new Exercise();
        exercise.generateBinaryxercise();
        for (int i=0;i<50;i++)
        {

            if (count%5==0)
            {
                System.out.printf("\n");
            }
//            System.out.println(exercise.operationList[i].toString());
//            System.out.println(exercise.operationList[i].asString());
            System.out.printf("%-14s ",exercise.operationList[i].fullString());
            count++;
        }
    }

    public static void main(String[] args) {

        formateAndDisplay();
    }
}
