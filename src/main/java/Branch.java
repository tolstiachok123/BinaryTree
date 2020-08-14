import java.awt.geom.Line2D;

public class Branch {

    private Point2D startPoint;
    private Point2D endPoint;
    private int length;

    public Branch(Point2D startPoint, Point2D endPoint, int length) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.length=length;
    }

    public Line2D createLineByTwoPoints(){
        return new Line2D.Double(startPoint.getXCoordinate(), startPoint.getYCoordinate(), endPoint.getXCoordinate(), endPoint.getYCoordinate());
    }

    public Point2D getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point2D startPoint) {
        this.startPoint = startPoint;
    }

    public Point2D getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point2D endPoint) {
        this.endPoint = endPoint;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
