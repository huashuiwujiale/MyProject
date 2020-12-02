package Experiment2.V1;
import java.util.Random;
public class BinaryOperation {
    static final int UPPER = 100;
    static final int LOWER = 0;
    private int left_operand = 0,right_operand = 0;
    private char operator = '+';
    private int value = 0;
    private int add = 0;
    private int sub = 0;
    private void construct(int left,int right,char op){
        //计算结果方法
        left_operand = left;
        right_operand = right;
        operator = op;
        if(op=='+'){
            value=left+right;
        }
        else
        {
            value=left-right;
        }
    }
    public BinaryOperation generateAdditionOperation(){
        //生成加法算式
        Random random = new Random();
        int left,right,result;
        left=random.nextInt(UPPER+1);
        do {
            right=random.nextInt(UPPER+1);
            result=left+right;
        }while (result>UPPER);
        BinaryOperation bop = new BinaryOperation();
        bop.construct(left,right,'+');
        return bop;
    }
    public BinaryOperation generateSubstractExercise() {
        //生成减法算式
        Random random = new Random();
        int left, right, result;
        left = random.nextInt(UPPER + 1);
        do {
            right = random.nextInt(UPPER + 1);
            result = left - right;
        } while (result < LOWER);
        BinaryOperation bop = new BinaryOperation();
        bop.construct(left, right, '-');
        return bop;
    }
    public BinaryOperation generateBinaryOperation()
    {
        Random random = new Random();
        int temp=random.nextInt(2);

        if(add==25)
        {
            temp=1;
        }
        else if(sub==25)
        {
            temp=0;
        }
//        if(0==temp)
//        {
//
//        }
//        else{
//
//        }
        if(temp==0)
        {
            add++;
            return generateAdditionOperation();

        }
        else {
            sub++;
            return generateSubstractExercise();

        }
    }
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
    public boolean equals(BinaryOperation anOperation){
        //判断两个算式的三个元素(left_operand,operator,right_operand)是否完全相同
        //要使用getOperator()
        return left_operand == anOperation.getLeft_operand()&
                right_operand == anOperation.getRight_operand()&
                operator == anOperation.getOperator();
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
