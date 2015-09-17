package otoczenie;

public class PoziomTrudnosci {
	private static int czasPracy = 2, mnorznikSurowcow = 2, utrataSil = 2,
			mnorznikPunktow = 4;
	private static boolean zdrowie = false, okienkaInformacyjne = false,
			ochota = false, sytosc = false, wyspany = false, szczescie = false;
	private static String onaSuwak = "automat", onSuwak = "automat";
	private static double tempo = 1;

	public static double getTempo() {
		return tempo;
	}

	public static void setTempo(double tempoo) {
		tempo = tempoo;
	}

	public static void setOnSuwak(String to) {
		onSuwak = to;
	}

	public static void setOnaSuwak(String to) {
		onaSuwak = to;
	}

	public static String getOnSuwak() {
		return onSuwak;
	}

	public static String getOnaSuwak() {
		return onaSuwak;
	}

	public static boolean getZdrowie() {
		return zdrowie;
	}

	public static boolean getOkienkaInformacyjne() {
		return okienkaInformacyjne;
	}

	public static boolean getOchota() {
		return ochota;
	}

	public static boolean getSytosc() {
		return sytosc;
	}

	public static boolean getWyspany() {
		return wyspany;
	}

	public static boolean getSzczescie() {
		return szczescie;
	}

	public static void setZdrowie(boolean to) {
		zdrowie = to;
	}

	public static void setOkienkaInformacyjne(boolean to) {
		okienkaInformacyjne = to;
	}

	public static void setOchota(boolean to) {
		ochota = to;
	}

	public static void setSytosc(boolean to) {
		sytosc = to;
	}

	public static void setWyspany(boolean to) {
		wyspany = to;
	}

	public static void setSzczescie(boolean to) {
		szczescie = to;
	}

	public static int geTczasPracy() {
		return czasPracy;
	}

	public static int getMnorznikSurowcow() {
		return mnorznikSurowcow;
	}

	public static int getUtrataSil() {
		return utrataSil;
	}

	public static int getMnorznikPunktow() {
		return mnorznikPunktow;
	}

	public static void ustawLIP() {
		czasPracy = 1;
		mnorznikSurowcow = 4;
		utrataSil = 4;
		mnorznikPunktow = 1;

	}

	public static void ustawLIN() {
		czasPracy = 2;
		mnorznikSurowcow = 4;
		utrataSil = 4;
		mnorznikPunktow = 2;

	}

	public static void ustawNRR() {
		czasPracy = 2;
		mnorznikSurowcow = 2;
		utrataSil = 3;
		mnorznikPunktow = 4;

	}

	public static void ustawBMPG() {
		czasPracy = 3;
		mnorznikSurowcow = 1;
		utrataSil = 2;
		mnorznikPunktow = 8;

	}

	public static void ustawMTR() {
		czasPracy = 3;
		mnorznikSurowcow = 1;
		utrataSil = 1;
		mnorznikPunktow = 16;

	}

}
