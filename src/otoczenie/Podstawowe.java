package otoczenie;

public class Podstawowe {
	private static int licz = 0;

	public synchronized static void licz() {
		licz = licz + PoziomTrudnosci.getMnorznikPunktow();
	}

	public synchronized static void odlicz() {
		licz = licz - PoziomTrudnosci.getMnorznikPunktow();
	}

	public static int getLicz() {
		return licz;
	}
}
