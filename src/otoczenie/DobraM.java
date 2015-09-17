package otoczenie;

import okienka.Okienko;

public class DobraM {
	static int ceglanyPlot = 0;

	public static int getCeglanyPlot() {
		return ceglanyPlot;
	}

	public static void DodajCeglanyPlot() {
		ceglanyPlot++;
		Okienko.updateTableDobra();
	}

	static int drewnianyPlot = 0;

	public static int getDrewnianyPlot() {
		return drewnianyPlot;
	}

	public static void DodajDrewnianyPlot() {
		drewnianyPlot++;
		Okienko.updateTableDobra();
	}

	static int maleWnyki = 1;

	public static int getMaleWnyki() {
		return maleWnyki;
	}

	public static void OdliczMaleWnyki(int odlicz) {
		maleWnyki -= odlicz;
	}

	public static void ZwiekszMaleWnyki() {
		maleWnyki++;
		Okienko.updateTableDobra();
	}

	static int rozstawioneMaleWnyki = 0;

	public static int getRozstawioneMaleWnyki() {
		return rozstawioneMaleWnyki;
	}

	public static void OdliczRozstawioneMaleWnyki(int odlicz) {
		rozstawioneMaleWnyki -= odlicz;
	}

	public static void ZwiekszRozstawioneMaleWnyki() {
		rozstawioneMaleWnyki++;
		Okienko.updateTableDobra();
	}

	static int kurnik = 1;

	public static int getKurnik() {
		return kurnik;
	}

	public static void OdliczKurnik(int odlicz) {
		kurnik -= odlicz;
	}

	public static void DodajKurnik() {
		kurnik++;
		Okienko.updateTableDobra();
	}

}
