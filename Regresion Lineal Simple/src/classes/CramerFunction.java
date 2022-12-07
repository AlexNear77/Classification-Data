package classes;


public class CramerFunction {

    public static double[] cramer2x2(double[][] dataSet){
        
        int n = dataSet.length;
        double sumX = 0;
        double sumY = 0;
        double sumXY = 0;
        double sumXX = 0;
        
        for(int i = 0; i < n; i++){
            sumX += dataSet[i][0];
            sumXX += dataSet[i][0] * dataSet[i][0];
            sumY += dataSet[i][1];
            sumXY += dataSet[i][0] * dataSet[i][1];
        }
        
        double ds = n * sumXX - sumX * sumX;
        double db1 = n * sumXY - sumX * sumY;
        double db0 = sumY * sumXX - sumXY * sumX;
        
        double b0 = db0 / ds; //La intercepción
        double b1 = db1 / ds; //La pendiente
        
        return new double[] {b0, b1};
    }
}