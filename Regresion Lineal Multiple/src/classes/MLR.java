package classes;

public class MLR implements Regression{
    
    private double [] coefficients;
    
    public MLR(){
        coefficients = new double[] {0,0};
    }
    
    public MLR(double [][] dataSet){
        this.coefficients = CramerFunction.cramer3x3(dataSet);
        printEquation();
    }

    @Override
    public double predictFor(double[] factors) {
        double y = coefficients[0];
        
        for(int i = 0; i < 2; i++){
            y += coefficients[i+1] * factors[i];
        }
        System.out.println("Resultado: \ny = " + String.format("%.2f", y));
        return y;
    }

    @Override
    public double[] getCoefficients() {
        return this.coefficients;
    }

    @Override
    public void printEquation() {
        System.out.println("Ecuacion Generada:\ny = " + String.format("%.2f", this.coefficients[0]) + " + " + String.format("%.2f", this.coefficients[1]) + "*Factor (x1) + " + String.format("%.2f", this.coefficients[2]) + "*Factor (x2)");
    }

}