package start;

import javax.swing.JLabel;
import javax.swing.JPanel;

import okienka.GuzikiBoga;
import okienka.GuzikiOna;

public class pSamouczek extends JPanel {

	public pSamouczek() {
		setSize(800, 600);

		setLayout(null);

		JLabel tekstSamouczka = new JLabel(
				"<-Tutaj masz podane informacje na temat tego co robi� twoje postacie ");
		tekstSamouczka.setBounds(300, 1, 450, 20);
		add(tekstSamouczka);
		JLabel tekstSamouczka1 = new JLabel(
				"<-Guziki Boga przesuwanie kropki zmienia poziom trudno�ci ");
		tekstSamouczka1.setBounds(300, 45, 450, 20);
		add(tekstSamouczka1);
		JLabel tekstSamouczka2 = new JLabel(
				"<-zaznaczanie tych kwadracik�w jest r�wno znaczne z wpisywaniem kod�w ");
		tekstSamouczka2.setBounds(300, 65, 450, 20);
		add(tekstSamouczka2);
		JLabel tekstSamouczka3 = new JLabel(
				"<-tym s�wakiem zaznaczasz co chcesz by robi� tw�j bohater ");
		tekstSamouczka3.setBounds(300, 110, 450, 20);
		add(tekstSamouczka3);
		JLabel tekstSamouczka4 = new JLabel(
				"<-tu wpisujesz konkretne polecenie a kwadracik zap�tla zadanie");
		tekstSamouczka4.setBounds(300, 130, 450, 20);
		add(tekstSamouczka4);
		JLabel tekstSamouczka5 = new JLabel(
				"<-dzi�ki tabeli nie musisz wpisywa� polece� r�cznie");
		tekstSamouczka5.setBounds(300, 190, 450, 20);
		add(tekstSamouczka5);
		JLabel tekstSamouczka6 = new JLabel(
				"pobaw si� przyciskami, poklikaj, po zmieniaj, kliknij w tabeli");
		tekstSamouczka6.setBounds(300, 220, 450, 20);
		add(tekstSamouczka6);
		JLabel tekstSamouczka7 = new JLabel(
				"po najechaniu na przycisk wy�wietli si� co konkretnie robi");
		tekstSamouczka7.setBounds(300, 250, 450, 20);
		add(tekstSamouczka7);

		JLabel onr = new JLabel("robio");
		JLabel JLon = new JLabel("on:");
		JLabel onar = new JLabel("robib");
		JLabel JLona = new JLabel("ona:");
		JLabel lBug = new JLabel("Guziki Boga:");
		JLabel onal = new JLabel("Panel za��dzania kobiet�");

		JLon.setBounds(1, 1, 220, 15);
		JLona.setBounds(1, 15, 220, 15);
		onr.setBounds(50, 1, 250, 15);
		onar.setBounds(50, 15, 250, 15);

		onal.setBounds(5, 55, 467, 100);
		lBug.setBounds(5, 30, 220, 15);

		add(onal);

		add(JLon);
		add(JLona);
		add(onr);
		add(onar);
		add(lBug);

		GuzikiBoga g1 = new GuzikiBoga();
		GuzikiOna g2 = new GuzikiOna();

		g1.setBounds(1, 45, 300, 60);
		g2.setBounds(1, 115, 500, 210);

		add(g1);
		add(g2);

	}

	/*
	 * System.exit(0);
	 */
}
