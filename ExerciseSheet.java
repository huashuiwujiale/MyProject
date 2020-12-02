package Experiment2.V2;

public class ExerciseSheet {
    public static void main(String[] args) {
        Exercise exercise = new Exercise();
//        exercise.generateBinaryExercise(50);
        //生成加减法混合算式
        exercise.generateAdditionExercise(25);
        //只生成加法算式
        exercise.generateSubstractExercise(25);
        //只生成减法算式
        exercise.formattedDisplay(50,5);
        //输出算式的方法，并且每行显示5个算式
    }
}
