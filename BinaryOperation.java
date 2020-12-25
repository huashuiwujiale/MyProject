package Experiment3;
import java.util.Random;

abstract class BinaryOperation {
    //调用了两个抽象方法，生成合法的算式部分，调用者负责输入合法的参数
    static final int UPPER = 100;
    static final int LOWER = 0;
    private int left_operand = 0,right_operand = 0;
    private char operator = '+';
    private int value = 0;
    protected void generateBinaryOperation(char anOperator){

        int left=0,right=0,result;
        Random random = new Random();
        left = random.nextInt(UPPER+1);
        do {
            left = random.nextInt(UPPER+1);
            right = random.nextInt(UPPER+1);
            result=calculate(left,right);
        }while (!checkingCalculation(result));
        left_operand =left;
        right_operand=right;
        operator=anOperator;
        value=result;
    }
    //子类必须实现的两个方法
    abstract boolean checkingCalculation(int anInteger);
    abstract int calculate(int left,int right);

    public int getLeft_operand() {
        //获取第一个操作数
        return left_operand;
    }
    public int getRight_operand() {
        //获取第二个操作数
        return right_operand;
    }
    public char getOperator() {
        //获取操作符
        return operator;
    }
    public int getValue() {
        return value;
    }


    public boolean equals(BinaryOperation operationList){
        //判断两个算式的三个元素(left_operand,operator,right_operand)是否完全相同
        //一个是新生成的算式，一个是题集里已经存在的算式
        return left_operand == operationList.getLeft_operand()&&
                right_operand == operationList.getRight_operand()&&
                operator == operationList.getOperator();
    }
    public String toString(){
    //例如：返回"32+5"
    return left_operand+" "+operator+" "+right_operand;
}
    public String asString(){
        //例如：返回"32+5="
        return left_operand+" "+operator+" "+right_operand+"=";
    }
    public String fullString(){
        //例如：返回"32+5=37"
        return left_operand+" "+operator+" "+right_operand+"="+value;
    }
}
