import java.util.Random;

public class TestOneV02 {
    public static int left_operand;
    public static int right_operand;
    static int count=0;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int operator;
        char op;
        int [][] nums=new int[50][3];
        for(int i=0;i<50;i++)
        {
            int [] operand= new int[2];
            operator=generateEquation();//从随机生成操作符的函数中获取操作符，0代表+，1代表-
            operand=randomNumber();//从随机生成操作数函数中获取包含两个操作数的数组
            nums[i][0]=operand[0];
            nums[i][2]=operand[1];
            nums[i][1]=operator;
            if(0==nums[i][1])
            {
                op='+';
            }
            else
            {
                op='-';
            }
            System.out.printf("%2d. %3d%c%3d=  ",(count+1),nums[i][0],op,nums[i][2]);
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
    public static int calculate(int leftOperand,int operator,int rightOperand){
        //计算算式结果
        int sum=0;
        if(0==operator)
        {
            sum=leftOperand+rightOperand;
        }
        else if(1==operator)
        {
            sum=leftOperand-rightOperand;
        }
        return sum;
    }
    public static int generateEquation() {
        //生成操作符,0代表+，1代表-
        Random rand2=new Random();
        int ov=rand2.nextInt(2);
        return ov;
    }
}
