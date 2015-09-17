package okienka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import mozgi.On;
import otoczenie.PoziomTrudnosci;

public class GuzikiOn extends JPanel implements ActionListener {
	private JButton enter;
	private ButtonGroup bg;
	private JRadioButton automat, zbierajSurowce, zdobywaniePokarmu,
			przetwarzanieProduktow, dbajOSiebie;
	static JTextField textON;
	static JCheckBox ciaglosON;
	static boolean ciagloscon = true;

	public GuzikiOn() {
		// setSize(400, 500);

		setLayout(null);
		TabelaOn t = new TabelaOn();

		ciaglosON = new JCheckBox("Wielkielitery");
		ciaglosON.setToolTipText("Wykonuje stale to samo zajecie");
		ciaglosON.setBounds(270, 21, 20, 20);
		add(ciaglosON);
		ciaglosON.addActionListener(this);

		enter = new JButton("GO");
		enter.setBounds(201, 21, 65, 20);
		enter.addActionListener(this);
		add(enter);

		t.setBounds(1, 44, 290, 175);
		add(t);

		textON = new JTextField("Rozkazuj");
		textON.setBounds(1, 21, 200, 25);
		add(textON);

		bg = new ButtonGroup();
		automat = new JRadioButton("AP", true);
		automat.setBounds(1, 1, 45, 20);
		automat.setToolTipText("Samodzielne myslenie i wykonywanie dzia³añ");
		automat.addActionListener(this);
		bg.add(automat);

		zbierajSurowce = new JRadioButton("ZS", false);
		zbierajSurowce
				.setToolTipText("Skupia siê g³ównie na zbieraniu surowców");
		zbierajSurowce.setBounds(45, 1, 55, 20);
		zbierajSurowce.addActionListener(this);
		bg.add(zbierajSurowce);

		zdobywaniePokarmu = new JRadioButton("ZP", false);
		zdobywaniePokarmu
				.setToolTipText("Skupia siê na zdobywaniu po¿ywnienia");
		zdobywaniePokarmu.setBounds(100, 1, 50, 20);
		zdobywaniePokarmu.addActionListener(this);
		bg.add(zdobywaniePokarmu);

		przetwarzanieProduktow = new JRadioButton("PP", false);
		przetwarzanieProduktow
				.setToolTipText("Osoba zajmuje sie przetwórstwem");
		przetwarzanieProduktow.setBounds(150, 1, 60, 20);
		przetwarzanieProduktow.addActionListener(this);
		bg.add(przetwarzanieProduktow);

		dbajOSiebie = new JRadioButton("NAR", false);
		dbajOSiebie.setToolTipText("Myœli tylko o sobie");
		dbajOSiebie.setBounds(210, 1, 55, 20);
		dbajOSiebie.addActionListener(this);
		bg.add(dbajOSiebie);

		add(zdobywaniePokarmu);
		add(automat);
		add(zbierajSurowce);
		add(przetwarzanieProduktow);
		add(dbajOSiebie);

	}

	public void actionPerformed(ActionEvent e) {
		Object zr = e.getSource();
		if (zr == automat) {
			PoziomTrudnosci.setOnSuwak("automat");
		} else if (zr == zbierajSurowce) {
			PoziomTrudnosci.setOnSuwak("zbierajSurowce");
		} else if (zr == zdobywaniePokarmu) {
			PoziomTrudnosci.setOnSuwak("zdobywaniePokarmu");
		} else if (zr == przetwarzanieProduktow) {
			PoziomTrudnosci.setOnSuwak("przetwarzanieProduktow");
		} else if (zr == dbajOSiebie) {
			PoziomTrudnosci.setOnSuwak("dbajOSiebie");
		} else if (zr == enter) {
			On.setPolecenieon(textON.getText());

			On.zmuszacztrueon();
		}
		if (ciaglosON.isSelected() == true) {
			ciagloscon = false;
		} else {
			ciagloscon = true;
		}
	}

	public static boolean getciagloscon() {
		return ciagloscon;
	}

	public static void wpiszOn(String x) {
		textON.setText(x);
	}

	public static void main(String[] args) {

		GuzikiOn t = new GuzikiOn();
		JFrame jf = new JFrame();
		jf.setTitle("tabela");
		jf.setSize(600, 600);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(t);
	}

	public static void setCiaglosON(boolean x) {
		ciaglosON.setSelected(x);
	}

}
