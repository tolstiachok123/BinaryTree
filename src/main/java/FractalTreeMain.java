import java.awt.*;

public class FractalTreeMain {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFractalFrame frame = new JFractalFrame();
                frame.setVisible(true);
            }
        });
    }
}
