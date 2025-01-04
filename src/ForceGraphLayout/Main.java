package ForceGraphLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int nodeCount=1000;
        int edgeCount=1000;
        int width=1080;
        int height=1080;
        int iterations=1000;
        long seed=30;
        int seed1=40;
        boolean isTrue=true;
        Graph graph=new Graph(nodeCount,edgeCount,seed,width,height);
        FRAlgorithm alg=new FRAlgorithm(graph,iterations,width,height,seed1,isTrue);
        JFrame frame=new JFrame("Force Layout Graph");
        UI panel=new UI(graph);
        frame.add(panel);
        frame.setVisible(true);
        frame.setSize(width,height);
        long start=System.currentTimeMillis();
        int dzabe=0;
        int delay = 1000;
        //StartUi u=new StartUi(800,800);
        //u.createUI();
        /*for (int iteration = 0; iteration <iterations ; iteration++) {
            boolean goOn= alg.run();
            panel.updateGraph();
            panel.paintImmediately(panel.getBounds());
            if(!goOn){
                long end=System.currentTimeMillis();
                Logger.log("Done working ---->\n",LogLevel.Success);
                Logger.log("Time spent computing: "+(end-start)+" ms",LogLevel.Success);
                break;
            }
            Thread.sleep(100);
        }
         */
        panel.updateGraph();
        for (int i = 0; i < iterations; i++) {
            if(!alg.run()) {
                Logger.log("Not a good idea to proceed so closing",LogLevel.Success);
                break;
            }
            else{
                Logger.log("i am working",LogLevel.Info);
                panel.updateGraph();
            }
            //Thread.sleep(50);
        }


       // alg.run();
        //panel.updateGraph();
        //panel.repaint();
        long end=System.currentTimeMillis();
        Logger.log("Time used "+(end-start)+" ms, "+((end-start)/1000)+" s, "
                +(double)((end-start)/1000)*(1/60.0000000000)+"min",LogLevel.Success);
        if(isTrue) {
            Logger.log("We need to close the executor service running paralelism....", LogLevel.Warn);
            alg.closeExec();
            Logger.log("All executors taken care of", LogLevel.Success);
        }
    }
}