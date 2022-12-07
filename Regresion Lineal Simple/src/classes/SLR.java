package classes;


public class SLR implements Regression {
    private double b1; 
    private double b0; 
    
    //definimos las betas
    public SLR(){
        b0 = 0;
        b1 = 0;
    }
    
    
    public SLR(double [][] dataSet){
        double[] coeficients = CramerFunction.cramer2x2(dataSet); //Obtiene los coeficientes 
        this.b0 = coeficients[0]; // los definimos en las betas
        this.b1 = coeficients[1];
        printEquation();
    }

    @Override //Se predice siendo el factor la variable de entrada
    public double predictFor(double[] factor) {
        double y =  b0 + b1 * factor[0];
        System.out.println("Resulado: \ny = " + String.format("%.2f", y));
        return y;
    }

    @Override
    public double[] getCoefficients() {
        return new double [] {b0, b1};
    }

    @Override
    public void printEquation() {
        System.out.println("Ecuacion Generada:\ny = " + String.format("%.2f", this.b0) + " + " + String.format("%.2f", this.b1) + "*x");
    }
    
}