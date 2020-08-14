import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class PaintPanel extends JPanel {

    private List<Branch> branches =  new CopyOnWriteArrayList<Branch>();
    private double angle=0;

    public void setAngle(double angle) {
        this.angle = angle;
    }
    //Рекурсивная функция, в которой отрисовываются две новые ветки исходящие из предыдущей, и добавляются в список
    //в неё передается длина ветки, точка начала отрисовки, угол наклона, и шаг рекурсии
    public void fractal(int startLength, Point2D startPoint, double alpha, int step){
        if(alpha<0) alpha=360;
        double radian =(alpha/(180/Math.PI));

        Point2D leftBrunchEndPoint = new Point2D();
        Point2D rightBrunchEndPoint = new Point2D();

        leftBrunchEndPoint.setXCoordinate((float) (startPoint.getXCoordinate()-startLength*Math.cos(radian)));
        leftBrunchEndPoint.setYCoordinate((float) (startPoint.getYCoordinate()-startLength*Math.sin(radian)));
        branches.add(new Branch(startPoint, leftBrunchEndPoint, startLength));

        rightBrunchEndPoint.setXCoordinate((float) (startPoint.getXCoordinate()-startLength*Math.cos(radian)));
        rightBrunchEndPoint.setYCoordinate((float) (startPoint.getYCoordinate()-startLength*Math.sin(radian)));
        branches.add(new Branch(startPoint, rightBrunchEndPoint, startLength));

        if(step>0){
            step--;
            startLength-=4;
            fractal(startLength, leftBrunchEndPoint, alpha - (20 + angle), step); //angle понадобится для анимации
            fractal(startLength, rightBrunchEndPoint, alpha + (20 - angle), step);
        }
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        fractal(60, new Point2D(320, 480), 90, 10);
        Graphics2D graphics2D = (Graphics2D)graphics;
        for(Branch branch: branches){
            graphics2D.setColor(branch.getLength()>30 ? Color.ORANGE.darker() : Color.GREEN);
            graphics2D.draw(branch.createLineByTwoPoints());
        }
        branches.clear();
    }

    public Dimension getPreferredSize() {
        // TODO Auto-generated method stub
        return new Dimension(640,480);
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    public double getAngle() {
        return angle;
    }
}
