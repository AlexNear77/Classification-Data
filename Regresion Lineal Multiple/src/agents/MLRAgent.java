package agents;

import classes.MLR;
import gui.MLRInterface;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class MLRAgent extends Agent{
    private MLRInterface myGui;
    MLR mlr = new MLR();
    @Override
    protected void setup(){
        System.out.println("Okey lets go!");
        myGui = new MLRInterface(this);
        double [][] data = {
    {37.8	,69.2	,22.1},
    {39.3	,45.1	,10.4},
    {45.9	,69.3	,9.3},
    {41.3	,58.5	,18.5},
    {10.8	,58.4	,12.9},
    {48.9	,75	  ,7.2},
    {32.8	,23.5	,11.8},
    {19.6	,11.6	,13.2},
    {2.1	  ,1	    ,4.8},
    {2.6	  ,21.2	,10.6},
    {5.8	  ,24.2	,8.6},
    {24	  ,4	    ,17.4},
    {35.1	,65.9	,9.2},
    {7.6	  ,7.2	  ,9.7},
    {32.9	,46	  ,19},
    {47.7	,52.9	,22.4},
    {36.6	,114	  ,12.5},
    {39.6	,55.8	,24.4},
    {20.5	,18.3	,11.3},
    {23.9	,19.1	,14.6},
    {27.7	,53.4	,18},
    {5.1	  ,23.5	,12.5},
    {15.9	,49.6	,5.6},
    {16.9	,26.2	,15.5},
    {12.6	,18.3	,9.7},
    {3.5	  ,19.5	,12},
    {29.3	,12.6	,15},
    {16.7	,22.9	,15.9},
    {27.1	,22.9	,18.9},
    {16	  ,40.8	,10.5},
    {28.3	,43.2	,21.4},
    {17.4	,38.6	,11.9},
    {1.5	  ,30	  ,9.6},
    {20	  ,0.3	  ,17.4},
    {1.4	  ,7.4	  ,9.5},
    {4.1	  ,8.5	  ,12.8},
    {43.8	,5	    ,25.4},
    {49.4	,45.7	,14.7},
    {26.7	,35.1	,10.1},
    {37.7	,32	  ,21.5},
    {22.3	,31.6	,16.6},
    {33.4	,38.7	,17.1},
    {27.7	,1.8	  ,20.7},
    {8.4	  ,26.4	,12.9},
    {25.7	,43.3	,8.5},
    {22.5	,31.5	,14.9},
    {9.9	  ,35.7	,10.6},
    {41.5	,18.5	,23.2},
    {15.8	,49.9	,14.8},
    {11.7	,36.8	,9.7},
    {3.1	  ,34.6	,11.4},
    {9.6	  ,3.6	  ,10.7},
    {41.7	,39.6	,22.6},
    {46.2	,58.7	,21.2},
    {28.8	,15.9	,20.2},
    {49.4	,60	  ,23.7},
    {28.1	,41.4	,5.5},
    {19.2	,16.6	,13.2},
    {49.6	,37.7	,23.8},
    {29.5	,9.3	  ,18.4},
    {2	    ,21.4	,8.1},
    {42.7	,54.7	,24.2},
    {15.5	,27.3	,15.7},
    {29.6	,8.4	  ,14},
    {42.8	,28.9	,18},
    {9.3	  ,0.9	  ,9.3},
    {24.6	,2.2	  ,9.5},
    {14.5	,10.2	,13.4},
    {27.5	,11	  ,18.9},
    {43.9	,27.2	,22.3},
    {30.6	,38.7	,18.3},
    {14.3	,31.7	,12.4},
    {33	  ,19.3	,8.8},
    {5.7	  ,31.3	,11},
    {24.6	,13.1	,17},
    {43.7	,89.4	,8.7},
    {1.6	  ,20.7	,6.9},
    {28.5	,14.2	,14.2},
    {29.9	,9.4	  ,5.3},
    {7.7	  ,23.1	,11},
    {26.7	,22.3	,11.8},
    {4.1	  ,36.9	,12.3},
    {20.3	,32.5	,11.3},
    {44.5	,35.6	,13.6},
    {43	  ,33.8	,21.7},
    {18.4	,65.7	,15.2},
    {27.5	,16	  ,12},
    {40.6	,63.2	,16},
    {25.5	,73.4	,12.9},
    {47.8	,51.4	,16.7},
    {4.9	  ,9.3	  ,11.2},
    {1.5	  ,33	  ,7.3},
    {33.5	,59	  ,19.4},
    {36.5	,72.3	,22.2},
    {14	  ,10.9	,11.5},
    {31.6	,52.9	,16.9},
    {3.5	  ,5.9	  ,11.7},
    {21	  ,22	  ,15.5},
    {42.3	,51.2	,25.4},
    {41.7	,45.9	,17.2},
    {4.3	  ,49.8	,11.7},
    {36.3	,100.9	,23.8},
    {10.1	,21.4	,14.8},
    {17.2	,17.9	,14.7},
    {34.3	,5.3	  ,20.7},
    {46.4	,59	  ,19.2},
    {11	  ,29.7	,7.2},
    {0.3	  ,23.2	,8.7},
    {0.4	  ,25.6	,5.3},
    {26.9	,5.5	  ,19.8},
    {8.2	  ,56.5	,13.4},
    {38	  ,23.2	,21.8},
    {15.4	,2.4	  ,14.1},
    {20.6	,10.7	,15.9},
    {46.8	,34.5	,14.6},
    {35	  ,52.7	,12.6},
    {14.3	,25.6	,12.2},
    {0.8	  ,14.8	,9.4},
    {36.9	,79.2	,15.9},
    {16	  ,22.3	,6.6},
    {26.8	,46.2	,15.5},
    {21.7	,50.4	,7},
    {2.4	  ,15.6	,11.6},
    {34.6	,12.4	,15.2},
    {32.3	,74.2	,19.7},
    {11.8	,25.9	,10.6},
    {38.9	,50.6	,6.6},
    {0	    ,9.2	  ,8.8},
    {49	  ,3.2	  ,24.7},
    {12	  ,43.1	,9.7},
    {39.6	,8.7	  ,1.6},
    {2.9	  ,43	  ,12.7},
    {27.2	,2.1	  ,5.7},
    {33.5	,45.1	,19.6},
    {38.6	,65.6	,10.8},
    {47	  ,8.5	  ,11.6},
    {39	  ,9.3	  ,9.5},
    {28.9	,59.7	,20.8},
    {25.9	,20.5	,9.6},
    {43.9	,1.7	  ,20.7},
    {17	  ,12.9	,10.9},
    {35.4	,75.6	,19.2},
    {33.2	,37.9	,20.1},
    {5.7	  ,34.4	,10.4},
    {14.8	,38.9	,11.4},
    {1.9	  ,9	    ,10.3},
    {7.3	  ,8.7	  ,13.2},
    {49	  ,44.3	,25.4},
    {40.3	,11.9	,10.9},
    {25.8	,20.6	,10.1},
    {13.9	,37	  ,16.1},
    {8.4	  ,48.7	,11.6},
    {23.3	,14.2	,16.6},
    {39.7	,37.7	,19},
    {21.1	,9.5	  ,15.6},
    {11.6	,5.7	  ,3.2},
    {43.5	,50.5	,15.3},
    {1.3	  ,24.3	,10.1},
    {36.9	,45.2	,7.3},
    {18.4	,34.6	,12.9},
    {18.1	,30.7	,14.4},
    {35.8	,49.3	,13.3},
    {18.1	,25.6	,14.9},
    {36.8	,7.4	  ,18},
    {14.7	,5.4	  ,11.9},
    {3.4	  ,84.8	,11.9},
    {37.6	,21.6	,8},
    {5.2	  ,19.4	,12.2},
    {23.6	,57.6	,17.1},
    {10.6	,6.4	  ,15},
    {11.6	,18.4	,8.4},
    {20.9	,47.4	,14.5},
    {20.1	,17	  ,7.6},
    {7.1	  ,12.8	,11.7},
    {3.4	  ,13.1	,11.5},
    {48.9	,41.8	,27},
    {30.2	,20.3	,20.2},
    {7.8	  ,35.2	,11.7},
    {2.3	  ,23.7	,11.8},
    {10	  ,17.6	,12.6},
    {2.6	  ,8.3	  ,10.5},
    {5.4	  ,27.4	,12.2},
    {5.7	  ,29.7	,8.7},
    {43	  ,71.8	,26.2},
    {21.3	,30	  ,17.6},
    {45.1	,19.6	,22.6},
    {2.1	  ,26.6	,10.3},
    {28.7	,18.2	,17.3},
    {13.9	,3.7	  ,15.9},
    {12.1	,23.4	,6.7},
    {41.1	,5.8	  ,10.8},
    {10.8	,6	    ,9.9},
    {4.1	  ,31.6	,5.9},
    {42	  ,3.6	  ,19.6},
    {35.6	,6	    ,17.3},
    {3.7	  ,13.8	,7.6},
    {4.9	  ,8.1	  ,9.7},
    {9.3	  ,6.4	  ,12.8},
    {42	  ,66.2	,25.5},
    {8.6	  ,8.7	  ,13.4}
  };

        mlr = new MLR(data);
        myGui.showGui();
    }
    
    @Override
    protected void takeDown(){
        System.out.println("finish him x_x");
    }
    
    public void predict(final double factor1, final double factor2){
        addBehaviour(new OneShotBehaviour(){
            @Override
            public void action(){
                mlr.predictFor(new double[]{factor1, factor2});
            }
        });
    }
}