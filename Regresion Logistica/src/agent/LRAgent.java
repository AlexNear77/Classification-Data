package agent;

import classes.DataSet;
import classes.LR;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;


public class LRAgent extends Agent{
    LR logisticRegression;
    DataSet testData;
    
    @Override
    protected void setup(){
        System.out.println("Okey Lets Go!");
        nbaData();
        
        trainAgent();
    }
    @Override
    protected void takeDown(){
        System.out.println("Agent: finish him x_x");
    }
    protected void nbaData(){
        DataSet dataSet = new DataSet(new double[][] {
            {1,1,0},
            {4,2,1},
            {2,4,1}
        });
        logisticRegression = new LR(dataSet);
        logisticRegression.showProgress(true);
        logisticRegression.setIterations(100);//// iteraciones
        testData = new DataSet(dataSet.getData());
    }
    public void trainAgent(){
        addBehaviour(new OneShotBehaviour(){
            @Override
            public void action(){
                logisticRegression.train();
            }
            @Override
            public int onEnd(){
                testAgent(testData);
                return super.onEnd();
            }
        });
    }
    public void testAgent(final DataSet data){
        addBehaviour(new OneShotBehaviour(){
            @Override
            public void action(){
                for(double[] data: testData.getData())
                    logisticRegression.test(data);
            }
            @Override
            public int onEnd(){
                myAgent.doDelete();
                return super.onEnd();
            }
        });
    }
}