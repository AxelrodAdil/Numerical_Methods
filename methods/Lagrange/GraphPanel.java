package A_NM_matrix.Lagrange;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.util.ArrayList;

public class GraphPanel extends JPanel {
    BufferedImage img = new BufferedImage(1000, 1000, ColorModel.TRANSLUCENT);
    Boolean printing = true;
    ArrayList<Vector_> points = new ArrayList<>();
    public static ArrayList<Vector_> EqPoints = new ArrayList<>();

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, this);
    }

    public void drawEqs() {
        CalculateEquations();
        if (printing) {
            SCalculateEquations();
        }
        Draw();
    }

    public void Draw() {
        Graphics2D g = (Graphics2D) img.getGraphics();
        g.clearRect(0, 0, 1000, 1000);
        g.setColor(Color.red);
        if (points.size() > 1) {
            for (int i = 0; i < points.size(); i++) {
                Vector_ v = points.get(i);
                g.drawRect((int) v.x + 500, (int) v.y + 500, 1, 1);
                if (i + 1 < points.size()) {
                    Vector_ v2 = points.get(i + 1);
                    g.drawLine((int) v.x + 500, (int) v.y + 500, (int) v2.x + 500, (int) v2.y + 500);
                }

            }
        }

        g.setColor(Color.blue);
        for (Vector_ point : EqPoints) {
            g.fillOval((int) point.x + 500 - 5, (int) point.y + 500 - 5, 10, 10);
        }
        repaint();
    }

    public void CalculateEquations() {
        points.clear();
        for (float l = -500; l < 500; l += 0.1f) {
            float count = 0;
            int n = EqPoints.size() - 1;
            for (int i = 0; i <= n; i++) {
                Vector_ point = EqPoints.get(i);
                count += POfJ(n, l, i) * point.y;
            }
            float y = count;
            points.add(new Vector_(l, y));
        }
    }

    public float POfJ(int n, float x, int i) {
        float count = 1;
        for (int j = 0; j <= n; j++) {
            if (j == i) {
                continue;
            }
            count *= ((x - EqPoints.get(j).x) / (EqPoints.get(i).x - EqPoints.get(j).x));
        }
        return count;
    }

    public void SCalculateEquations() {
        StringBuilder count = new StringBuilder("y = ");
        int n = EqPoints.size() - 1;
        for (int i = 0; i <= n; i++) {
            Vector_ point = EqPoints.get(i);
            count.append(SPOfJ(n, i)).append("*").append(point.y).append("  +  ");
        }
        System.out.println(count);
    }

    public String SPOfJ(int n, int i) {
        StringBuilder count = new StringBuilder();
        for (int j = 0; j <= n; j++) {
            if (j == i) {
                continue;
            }
            count.append("((x - ").append(EqPoints.get(j).x).append(")) / (").append(EqPoints.get(i).x).append(" - ").append(EqPoints.get(j).x).append(")");
        }
        return count.toString();
    }
}