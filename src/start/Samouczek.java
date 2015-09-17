package start;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Samouczek extends JFrame implements ActionListener {
	private pSamouczek p;
	private JButton KS;

	public Samouczek() {
		setTitle("Samouczek");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);

		p = new pSamouczek();
		p.setBounds(1, 1, 800, 500);
		add(p);

		KS = new JButton("Kontynu³uj Samouczek");
		KS.setBounds(310, 550, 200, 20);
		add(KS);
		KS.addActionListener(this);

	}

	public void zmiana() {
		// remove(p);
	}

	public void actionPerformed(ActionEvent e) {
		Object z = e.getSource();
		if (z == KS) {

			remove(p);
			remove(KS);
			p2Samouczek p2 = new p2Samouczek();
			p2.setBounds(1, 1, 800, 600);
			add(p2);

			repaint();

		}
	}
}
