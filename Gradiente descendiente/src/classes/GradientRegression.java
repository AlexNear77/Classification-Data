package classes;


public class GradientRegression implements Regression{
    private double b[];
    private final double learningRate;
    private final int maxIterations;
    private final double error;
    private boolean stopGradient;
    
    public GradientRegression(){ //Inicializamos
        learningRate = 0.0005;
        maxIterations = 100000;
        error = 0.00001;
        stopGradient = false;
        b = new double[] {};
    }

    public final void gradientDescent(DataSet data){
        b = new double[2];
        b[0] = 0; //inicializamos las betas 
        b[1] = 0;
        int step = 0;
        while(step < maxIterations && !stopGradient){ //Comienza a iterar se detiene hasta que llegue al maximo o hasta que el gradiente cumpla con su chamba
            stepGradient(data);
            step++;
        }
 
        printEquation(); // ecuacione
    }
    private void stepGradient(DataSet data){ // STEP 2 da el brinco
        if(Math.abs(calculateTheError(data.getDataSet())) <= error){ //Revisa el error para ver si llego al objetivo
            stopGradient = true;
            return;
        }
        
        final int n = data.getRows();//Obetenemos la cantidad total de datos
        double [] gradient = new double[2]; // Inicializamos el gradiente
        // Prepara el array del gradiente
        gradient[0] = 0;
        gradient[1] = 0;
        
        for(int i = 0; i < n; i++){
            double y = data.getDataSet()[i][2-1]; //sacamos y de nuestro data set 
            double yHat = calculateYHat(data.getDataSet()[i]);//Calculamos y de Hat
            
            gradient[0] += -(2.0/n) * (y - yHat);
            for(int k = 1; k < 2; k++)
                gradient[k] += -(2.0/n) * data.getDataSet()[i][k-1] * (y - yHat);
        }
        
        for(int i = 0; i < 2; i++)
            b[i] = b[i] - (learningRate * gradient[i]);
    }
    
    private double calculateTheError(double[][] data){ 
        double totalError = 0;
        for(int i = 0; i < data[0].length; i++){
            totalError += (data[i][data[i].length-1] - calculateYHat(data[i]))* (data[i][data[i].length-1] - calculateYHat(data[i]));
        }
        System.out.println("Error: " + totalError);
        return totalError / data.length;
    }
    
    private double calculateYHat(double [] factor){
        double yHat = b[0];
        for(int i = 0; i < factor.length - 1; i++)
            yHat += b[i+1] * factor[i];
        return yHat;
    }
    
 
    
    
    @Override
    public void printEquation(){
        String equation = "Gradient descent.\ny = " + String.format("%.2f", b[0]);
        for(int i = 1; i < b.length; i++){
            equation += " + " + String.format("%.2f", b[i]) + "*Factor" + i;
        }
        System.out.println(equation);
    }
    @Override
    public double predictFor(double[] x){
        if(b.length == 0) return 0;
        double y = b[0];
        for(int i = 1; i < b.length; i++){
            y += b[i] * x[i-1];
        }
        System.out.println("y = " + String.format("%.2f", y));
        return y;
    }
    @Override
    public double[] getCoefficients(){
        return b;
    }
}