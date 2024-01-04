public class Calculation {
    // Private Constructor, prevent initialisation
    private Calculation(){
        //empty constructor
    }

    public static double add(double a, double b){
        return a + b;
    }
    public static double minus(double a, double b){
        return a - b;
    }
    public static double divide(double a, double b){
        if (b !=0){
            return a / b;
        } else{
            throw new IllegalArgumentException("Can't divide zero(0)");
        }
    }
    public static double multiple(double a, double b){
        return a * b;
    }


}
