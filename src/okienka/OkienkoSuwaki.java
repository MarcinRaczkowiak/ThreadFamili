package okienka;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

public class OkienkoSuwaki extends JFrame implements
		javax.swing.event.ChangeListener {
	private JLabel lC, lF;
	private JSlider sC, sF;
	private int tC, tF;

	public OkienkoSuwaki() {

		setTitle("Suwaki");
		setVisible(false);
		setSize(500, 300);
		setLayout(null);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setResizable(false);

		sC = new JSlider(0, 100, 0);
		sC.setBounds(50, 50, 300, 50);
		sC.setMajorTickSpacing(20);
		sC.setMinorTickSpacing(5);
		sC.setPaintTicks(true);
		sC.setPaintLabels(true);
		sC.addChangeListener(this);
		add(sC);

		sF = new JSlider(30, 212, 31);
		sF.setBounds(50, 150, 300, 50);
		sF.setMajorTickSpacing(20);
		sF.setMinorTickSpacing(5);
		sF.setPaintTicks(true);
		sF.setPaintLabels(true);
		sF.setEnabled(false);
		add(sF);

		lC = new JLabel("Cencius");
		lC.setBounds(380, 50, 300, 50);
		add(lC);

		lF = new JLabel("Cencius");
		lF.setBounds(380, 150, 300, 50);
		add(lF);
	}

	public void stateChanged(ChangeEvent e) {
		tC = sC.getValue();
		lC.setText("Cenciusz: " + tC);
		tF = (int) Math.round(32 + (9.0 / 5.0) * tC);
		lF.setText("faren; " + tF);
		sF.setValue(tF);
	}
}
