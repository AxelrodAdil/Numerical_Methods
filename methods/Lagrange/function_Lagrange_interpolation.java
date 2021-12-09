package A_NM_matrix.Lagrange;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class function_Lagrange_interpolation {
    public static GraphPanel g;
    private static JPanel xyPairGen(int num) {
        SpinnerModel x_model = new SpinnerNumberModel(0, -500, 500, 1);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        GraphPanel.EqPoints.add(new Vector_(0, 0));
        final int myIndex = GraphPanel.EqPoints.size() - 1;
        JPanel x = new JPanel();
        JSpinner x_spinner = new JSpinner(x_model);
        x_spinner.addChangeListener(e -> {
            JSpinner s = (JSpinner) e.getSource();
            GraphPanel.EqPoints.get(myIndex).x = (int) s.getValue();
            g.drawEqs();


        });
        x.add(x_spinner);

        SpinnerModel y_model = new SpinnerNumberModel(0, -500, 500, 1);
        JPanel y = new JPanel();
        JSpinner y_spinner = new JSpinner(y_model);
        y_spinner.addChangeListener(e -> {
            JSpinner s = (JSpinner) e.getSource();
            GraphPanel.EqPoints.get(myIndex).y = (int) s.getValue();
            g.drawEqs();
        });
        y.add(y_spinner);

        panel.setBorder(BorderFactory.createTitledBorder("Point " + num + " :"));
        panel.add(x);
        panel.add(y);
        return panel;
    }

    static void function_Lagrange_interpolation_solve() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);

        g = new GraphPanel();
        g.drawEqs();
        frame.add(g);

        frame.setVisible(true);
        JFrame pointsFrame = new JFrame();
        pointsFrame.setSize(500, 500);
        JPanel optWrapper = new JPanel(new BorderLayout());
        JButton newPoint = new JButton("New Point");
        JButton removePoint = new JButton("Remove Point");

        optWrapper.add(newPoint, BorderLayout.NORTH);
        JPanel optionsPanel = new JPanel(new GridLayout(5, 1));
        frame.setAlwaysOnTop(true);
        pointsFrame.setAlwaysOnTop(true);
        pointsFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        newPoint.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel xy = xyPairGen(GraphPanel.EqPoints.size());
                optionsPanel.add(xy);
                optionsPanel.repaint();
                optionsPanel.validate();
            }
        });

        removePoint.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = optionsPanel.getComponentCount() - 1;
                optionsPanel.remove(index);
                optionsPanel.repaint();
                GraphPanel.EqPoints.remove(index);
                g.drawEqs();
                optionsPanel.validate();
            }
        });

        optWrapper.add(removePoint, BorderLayout.SOUTH);
        optWrapper.add(optionsPanel, BorderLayout.CENTER);
        pointsFrame.add(optWrapper);
        pointsFrame.setVisible(true);
        g.drawEqs();
    }

    public static void doMethod() {
        for_the_sake_of_beauty();
        System.out.println("function_Lagrange_interpolation_solve: ");
        function_Lagrange_interpolation_solve();
        for_the_sake_of_beauty();
    }

    static void for_the_sake_of_beauty() {
        System.out.println("\n---------------------------------------------------\n");
    }
}