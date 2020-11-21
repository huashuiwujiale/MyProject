import java.util.Random;

public class TestOneV01 {
    public static int left_operand;
    public static int right_operand;
    static int count=0;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char operator;
        for(int i=0;i<50;i++)
        {
            int [] operand= new int[2];
            operator=generateEquation();//从随机生成操作符的函数中获取操作符
            operand=randomNumber();//从随机生成操作数函数中获取包含两个操作数的数组
            System.out.printf("%2d. %3d%c%3d=  ",(count+1),operand[0],operator,operand[1]);
            count++;
        }

    }
    public static int[] randomNumber() {
        //生成两个操作数
        int sum=0;
        int [] operand= new int[2];
        char o='+';
        Random rand1=new Random();
        left_operand=rand1.nextInt(101);
        right_operand=rand1.nextInt(101);
        operand[0]=left_operand;
        operand[1]=right_operand;
        sum=left_operand+right_operand;
//		System.out.printf("%2d. %3d%c%3d=%3d  ",count,left_operand,o,right_operand,sum);
        return operand;
    }
    public static char generateEquation() {
        //生成操作符
        Random rand2=new Random();
        char operator=' ';
        int ov=rand2.nextInt(2);
        if(0==ov)
        {
            operator='+';
        }
        else if(1==ov)
        {
            operator='-';
        }
        return operator;

    }
}
