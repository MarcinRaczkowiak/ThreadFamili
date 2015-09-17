package okienka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import otoczenie.PoziomTrudnosci;

public class GuzikiBoga extends JPanel implements ActionListener {

	private ButtonGroup bg;
	private JRadioButton lip, lin, nrr, bmpg, mtr;
	private JCheckBox zdrowie, okienkaInformacyjne, ochota, sytosc, wyspany,
			szczescie;

	public GuzikiBoga() {
		setSize(400, 400);

		setLayout(null);

		bg = new ButtonGroup();
		lip = new JRadioButton("£IP", false);
		lip.setBounds(1, 1, 50, 15);
		lip.setToolTipText("£atwa i przyjemna symulacja");
		lip.addActionListener(this);
		bg.add(lip);

		lin = new JRadioButton("£IN", false);
		lin.setToolTipText("£atwa i nudna");
		lin.setBounds(50, 1, 50, 15);
		lin.addActionListener(this);
		bg.add(lin);

		nrr = new JRadioButton("NRR", true);
		nrr.setToolTipText("Normalna realna rozgrywka");
		nrr.setBounds(100, 1, 50, 15);
		nrr.addActionListener(this);
		bg.add(nrr);

		bmpg = new JRadioButton("BMPG", false);
		bmpg.setToolTipText("Bêdziesz mia³ pod górkê");
		bmpg.setBounds(150, 1, 60, 15);
		bmpg.addActionListener(this);
		bg.add(bmpg);

		mtr = new JRadioButton("MTR", false);
		mtr.setToolTipText("Mega trudna rozgrywka");
		mtr.setBounds(210, 1, 55, 15);
		mtr.addActionListener(this);
		bg.add(mtr);

		add(nrr);
		add(lip);
		add(lin);
		add(bmpg);
		add(mtr);

		zdrowie = new JCheckBox("Zdrowi");
		zdrowie.setToolTipText("Ludzie nie trac¹ zdrowia");
		zdrowie.setBounds(90, 30, 70, 15);
		add(zdrowie);
		zdrowie.addActionListener(this);

		okienkaInformacyjne = new JCheckBox("BlokujOkna");
		okienkaInformacyjne
				.setToolTipText("Zaznaczenie zablokóje okienka informój¹ce gracza o nie udanych akcjach ludzi");
		okienkaInformacyjne.setBounds(161, 15, 110, 15);
		add(okienkaInformacyjne);
		okienkaInformacyjne.addActionListener(this);

		ochota = new JCheckBox("Chêtni");
		ochota.setToolTipText("Ludzie maj¹ zawsze ochotê");
		ochota.setBounds(1, 15, 65, 15);
		add(ochota);
		ochota.addActionListener(this);

		sytosc = new JCheckBox("Syci");
		sytosc.setToolTipText("Ludzie nie czuj¹ g³odu");
		sytosc.setBounds(90, 15, 50, 15);
		add(sytosc);
		sytosc.addActionListener(this);

		wyspany = new JCheckBox("Wyspany");
		wyspany.setToolTipText("Ludzie siê nie mêcz¹");
		wyspany.setBounds(1, 30, 80, 15);
		add(wyspany);
		wyspany.addActionListener(this);

		szczescie = new JCheckBox("Szczêœciaze");
		szczescie.setToolTipText("Ludzie maj¹ zawsze szczêœcie");
		szczescie.setBounds(161, 30, 110, 15);
		add(szczescie);
		szczescie.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object zr = e.getSource();
		if (zr == lip) {
			PoziomTrudnosci.ustawLIP();
		} else if (zr == lin) {
			PoziomTrudnosci.ustawLIN();
		} else if (zr == nrr) {
			PoziomTrudnosci.ustawNRR();
		} else if (zr == bmpg) {
			PoziomTrudnosci.ustawBMPG();
		} else if (zr == mtr) {
			PoziomTrudnosci.ustawMTR();
		}
		if (zdrowie.isSelected() == true) {
			PoziomTrudnosci.setZdrowie(true);
		} else {
			PoziomTrudnosci.setZdrowie(false);
		}
		if (okienkaInformacyjne.isSelected() == true) {
			PoziomTrudnosci.setOkienkaInformacyjne(true);
		} else {
			PoziomTrudnosci.setOkienkaInformacyjne(false);
		}
		if (ochota.isSelected() == true) {
			PoziomTrudnosci.setOchota(true);
		} else {
			PoziomTrudnosci.setOchota(false);
		}
		if (sytosc.isSelected() == true) {
			PoziomTrudnosci.setSytosc(true);
		} else {
			PoziomTrudnosci.setSytosc(false);
		}
		if (wyspany.isSelected() == true) {
			PoziomTrudnosci.setWyspany(true);
		} else {
			PoziomTrudnosci.setWyspany(false);
		}
		if (szczescie.isSelected() == true) {
			PoziomTrudnosci.setSzczescie(true);
		} else {
			PoziomTrudnosci.setSzczescie(false);
		}
	}

	// public static void main(String[] args) {

	// GuzikiBoga t = new GuzikiBoga();
	// JFrame jf = new JFrame();
	// jf.setTitle("tabela");
	// jf.setSize(600, 600);
	// jf.setVisible(true);
	// jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// jf.add(t);
	// }

}
