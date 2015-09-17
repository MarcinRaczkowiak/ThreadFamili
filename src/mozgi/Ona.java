package mozgi;

import java.util.Random;

import javax.swing.JOptionPane;

import okienka.GuzikiOna;
import okienka.Okienko;
import okienka.OkienkoNiepowodzeñ;
import otoczenie.DobraM;
import otoczenie.Podstawowe;
import otoczenie.PoziomTrudnosci;
import otoczenie.ZasobyRodzinyM;

public class Ona extends Mozg {
	static boolean pregnet;

	public Ona(int sporzczegawczos, int hp, int sila, int przedmiot,
			int pracowitosc, int lenistwo, int sex, String imie, boolean plecm) {
		super(sporzczegawczos, hp, sila, przedmiot, pracowitosc, lenistwo, sex,
				imie, plecm);
		pregnet = false;

	}

	public void AutomatONA() {
		Random rand = new Random();
		int b = rand.nextInt(100);
		if (b <= 25) {
			Obija();
		} else if (b <= 50) {
			ZrobMaleWnyki();
		} else if (b <= 75) {
			Garboj();
		} else {
			Sprzataj();
		}
	}

	public void PraceOna(final On on, final Ona ona) {
		Random rand = new Random();
		int b = rand.nextInt(100);
		if (b <= 20) {
			MyslPrzetwarzaj(on, ona);
		} else if (b <= 40) {
			MyslZbierajJedzenie(on, ona);
		} else if (b <= 60) {
			MyslZbierajSurowce(on, ona);
		} else if (b <= 80) {
			MyslDbajOSiebie(on, ona);
		} else {
			AutomatONA();
		}
	}

	public String Nazwisko(On on) {
		return imie + " " + on.Nazwisko();
	}

	public void zmuszaczona(final On on, final Ona ona) {
		if (polecenie.equals("Obija")) {
			Obija();
		} else if (polecenie.equals("ZrobMaleWnyki")) {
			ZrobMaleWnyki();
		} else if (polecenie.equals("Garboj")) {
			Garboj();
		} else if (polecenie.equals("ZbierajOdchody")) {
			ZbierajOdchody();
		} else if (polecenie.equals("Sprzataj")) {
			Sprzataj();
		} else {
			zmuszacz = false;
			polecenie = "";
			GuzikiOna.setCiaglosOna(false);
			OkienkoNiepowodzeñ.DopiszTekst("Nie ma takiej czynnoœci");
			if (!PoziomTrudnosci.getOkienkaInformacyjne())
				JOptionPane.showMessageDialog(null, "Komêda " + polecenie
						+ " nie istnieje ", "Pilna wiadomoœæ",
						JOptionPane.WARNING_MESSAGE);
		}
	}

	public void Sprzataj() {

		ZasobyRodzinyM.OdliczOdchody(50);
		Okienko.updateTableZasobyRodziny();

		Okienko.OnaRobi("Sprz¹ta");

		try {
			Thread.sleep((long) (PoziomTrudnosci.geTczasPracy()
					* PoziomTrudnosci.getTempo() * 2000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void ZbierajOdchody() {

		ZasobyRodzinyM.DodajOdchody(2);
		Okienko.updateTableZasobyRodziny();
		Okienko.OnaRobi("Zbieraj odchody");

		try {
			Thread.sleep((long) (PoziomTrudnosci.geTczasPracy()
					* PoziomTrudnosci.getTempo() * 1200));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void Garboj() {
		if (ZasobyRodzinyM.getSkora() >= 2 && ZasobyRodzinyM.getOdchody() >= 2) {
			ZasobyRodzinyM.OdliczDrewno(2);
			ZasobyRodzinyM.OdliczOdchody(2);
			ZasobyRodzinyM.DodajGarbowanaSkora(1);
			Okienko.updateTableZasobyRodziny();
		} else {
			String a = imie + " Nie wykona zadania bo \n";
			if (ZasobyRodzinyM.getSkora() < 2)
				a = a + "Za ma³o skór w magazynie\n";
			if (ZasobyRodzinyM.getOdchody() < 2)
				a = a + "Za ma³o odchodów w magazynie\n";
			OkienkoNiepowodzeñ.DopiszTekst(a);
			if (!PoziomTrudnosci.getOkienkaInformacyjne())
				JOptionPane.showMessageDialog(null, a, "Pilna wiadomoœæ",
						JOptionPane.INFORMATION_MESSAGE);
		}

		Okienko.OnaRobi("Garbóje skórê");

		try {
			Thread.sleep((long) (PoziomTrudnosci.geTczasPracy()
					* PoziomTrudnosci.getTempo() * 2000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void ZrobMaleWnyki() {
		if (ZasobyRodzinyM.getDrewno() >= 5) {
			ZasobyRodzinyM.OdliczDrewno(5);
			DobraM.ZwiekszMaleWnyki();
			Okienko.updateTableDobra();
			Okienko.updateTableZasobyRodziny();
			Podstawowe.licz();

		} else {
			String a = imie + " Nie wykona zadania bo \n";
			a = a + "Za ma³o Drewna w magazynie\n";
			OkienkoNiepowodzeñ.DopiszTekst(a);
			if (!PoziomTrudnosci.getOkienkaInformacyjne())
				JOptionPane.showMessageDialog(null, a, "Pilna wiadomoœæ",
						JOptionPane.INFORMATION_MESSAGE);
		}

		Okienko.OnaRobi(" Robi wnyki");

		try {
			Thread.sleep((long) (PoziomTrudnosci.geTczasPracy()
					* PoziomTrudnosci.getTempo() * 2000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void Obija() {
		Okienko.OnaRobi(" obija sie");

		try {
			Thread.sleep((long) (PoziomTrudnosci.geTczasPracy()
					* PoziomTrudnosci.getTempo() * 1700));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
