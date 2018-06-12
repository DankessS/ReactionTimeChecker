package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

/**
 * Created by Daniel Palonek on 2018-06-12.
 */
public class ChangeColorGenerator extends Thread {

    private Rectangle rectangle;

    public ChangeColorGenerator(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    @Override
    public void run() {
        rectangle.setFill(Color.GREEN);
        Random r = new Random();
        int i = r.nextInt(10 - 2 + 1) + 2;
        try {
            Thread.sleep(i * 1000);
            rectangle.setFill(Color.RED);
            Main.startTime = System.currentTimeMillis();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
