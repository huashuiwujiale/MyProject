import java.util.Random;

public class TestOneV04 {
    public static int left_operand;
    public static int right_operand;
    static int count=0;
    private static Random ran;
    static int add = 0,sub=0;//add代表加法出现的次数，sub代表减法出现的次数
//    Random ran=new Random();
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int operator;
        char op;
        int [][] nums=new int[50][3];
        System.out.println("习题：");
        for(int i=0;i<50;i++)
        {
            int [] operand= new int[2];
            operator=generateEquation();//从随机生成操作符的函数中获取操作符，0代表+，1代表-
            operand=randomNumber(operator);//从随机生成操作数函数中获取包含两个操作数的数组
            nums[i][0]=operand[0];
            nums[i][2]=operand[1];
            nums[i][1]=operator;
//            if(0==nums[i][1])
//            {
//                op='+';
//            }
//            else
//            {
//                op='-';
//            }

//            System.out.printf("%2d. %3d%c%3d=  ",(count+1),nums[i][0],op,nums[i][2]);
//            count++;
//            if (count%5==0)
//            {
//                System.out.printf("\n");
//            }
        }
        for (int i=0;i<49;i++)
        {
            for (int j=i+1;j<50;j++)
            {
                if(nums[i][0]==nums[j][0]&&nums[i][1]==nums[j][1]&&nums[i][2]==nums[j][2])
                {
                    nums[i][0]=ran.nextInt(101);
                    nums[i][1]=ran.nextInt(2);
                    nums[i][2]=ran.nextInt(101);
                }
            }
        }
        for(int i=0;i<50;i++)
        {
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
            if (count%5==0)
            {
                System.out.printf("\n");
            }
        }
        System.out.println("参考答案：");
        count=0;
        for(int i=0;i<50;i++)
        {
            int sum=calculate(nums[i][0],nums[i][1],nums[i][2]);//得到计算结果
            System.out.printf("%3d. %5d   ",(count+1),sum);
            count++;
            if (count%5==0)
            {
                System.out.printf("\n");
            }
        }
    }
    public static int[] randomNumber(int operator) {
        //生成两个操作数
        int sum=0;
        int [] operand= new int[2];
        Random rand1=new Random();
        left_operand=rand1.nextInt(101);
        if (0==operator)
        {
            right_operand=rand1.nextInt(101-left_operand);
        }
        else if (1==operator)
        {
            right_operand=rand1.nextInt(left_operand);
        }
        operand[0]=left_operand;
        operand[1]=right_operand;
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
        if(add==25)
        {
            ov=1;
        }
        else if(sub==25)
        {
            ov=0;
        }
        if(0==ov)
        {
            add++;
        }
        else{
            sub++;
        }
        return ov;
    }
}
