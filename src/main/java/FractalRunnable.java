public class FractalRunnable implements Runnable{

    private PaintPanel paintPanel;

    public FractalRunnable(PaintPanel paintPanel) {
        this.paintPanel=paintPanel;
    }

    public void run() {
        double count=0;
        boolean leftSlopeAnimation = true;
        while(true){
            if(count>7 && count<8){
                leftSlopeAnimation=false;
            }
            if(count<-7 && count>-8){
                leftSlopeAnimation=true;
            }
            if(leftSlopeAnimation)
                count+=0.01;
            else
                count-=0.01;

            paintPanel.setAngle(count);
            paintPanel.repaint();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public PaintPanel getPaintPanel() {
        return paintPanel;
    }

    public void setPaintPanel(PaintPanel paintPanel) {
        this.paintPanel = paintPanel;
    }

}
