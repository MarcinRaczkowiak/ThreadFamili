package otoczenie;

import okienka.Okienko;

public class ZwierzetaM {

	static int kury = 0;

	public static int getKury() {
		return kury;
	}

	public static void OdliczKury(int odlicz) {
		kury -= odlicz;
	}

	public static void DodajKure() {
		kury++;

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

	static int kurnik = 0;

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
