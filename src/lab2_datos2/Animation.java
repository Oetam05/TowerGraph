
package lab2_datos2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Animation extends JPanel {

    City city;
    Toolkit t;
    private Image background;
    boolean mst;
    ArrayList<int[]> mstEdges;

    public Animation(City c) {
        this.city = c;
        t = Toolkit.getDefaultToolkit();
        background = t.getImage("src\\lab2_datos2\\Assets\\map1.png");
        mst = false;
        mstEdges = new ArrayList();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);

        for (Tower tower : city.getTowers()) {
            g.setColor(Color.GRAY);
            g.fillOval(tower.getX(), tower.getY(), tower.getD(), tower.getD());
            g.setColor(Color.BLACK);
            g.setFont(new Font(Font.SERIF, Font.BOLD, 18));
            g.drawString(tower.getName() + "", tower.getX() + tower.getD(), tower.getY() + tower.getD());

        }
        int x1, x2, y1, y2, x3, y3;
        if (!mst) {
            for (Edge edge : city.getEdges()) {
                g.setColor(Color.blue);
                x1 = edge.getOrigin().getX() + 15;
                y1 = edge.getOrigin().getY() + 15;
                x2 = edge.getDestination().getX() + 15;
                y2 = edge.getDestination().getY() + 15;
                g.drawLine(x1, y1, x2, y2);
                if (x1 > x2) {
                    x3 = x2 + ((x1 - x2) / 2);
                } else {
                    x3 = x1 + ((x2 - x1) / 2);
                }
                if (y1 > y2) {
                    y3 = y2 + ((y1 - y2) / 2);
                } else {
                    y3 = y1 + ((y2 - y1) / 2);
                }
                g.setColor(Color.blue);
                g.drawString(edge.getDistance() + "", x3, y3);

            }
        } else {
            for (int[] mstEdge : mstEdges) {
                for (Edge edge : city.getEdges()) {
                    if ((mstEdge[0] == edge.getOrigin().getName() && mstEdge[1] == edge.getDestination().getName()) || (mstEdge[0] == edge.getDestination().getName() && mstEdge[1] == edge.getOrigin().getName())) {
                        g.setColor(Color.red);
                        x1 = edge.getOrigin().getX() + 15;
                        y1 = edge.getOrigin().getY() + 15;
                        x2 = edge.getDestination().getX() + 15;
                        y2 = edge.getDestination().getY() + 15;
                        g.drawLine(x1, y1, x2, y2);
                        if (x1 > x2) {
                            x3 = x2 + ((x1 - x2) / 2);
                        } else {
                            x3 = x1 + ((x2 - x1) / 2);
                        }
                        if (y1 > y2) {
                            y3 = y2 + ((y1 - y2) / 2);
                        } else {
                            y3 = y1 + ((y2 - y1) / 2);
                        }
                        g.setColor(Color.blue);
                        g.drawString(edge.getDistance() + "", x3, y3);
                    }
                }
            }
        }
        repaint();
    }

    public void setMst(boolean mst) {
        this.mst = mst;
    }

    public boolean isMst() {
        return mst;
    }

    public void setMstEdges(ArrayList<int[]> mstEdges) {
        this.mstEdges = mstEdges;
    }

}
