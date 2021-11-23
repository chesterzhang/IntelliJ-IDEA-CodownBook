public class Calculator {

    public Calculator() {
    }

    public static int add(int a, int b){
        return a+b;
    }

    public static float mult(float a , float b){
        return a*b;
    }

    @Override
    public String toString() {
        return "This is a calculator, we can do addition and multiplication.";
    }

}
