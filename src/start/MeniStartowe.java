package start;

import javax.swing.JOptionPane;

public class MeniStartowe {
	public void main() {
		int odp = JOptionPane.showConfirmDialog(null,
				"Czy zapozna³eœ siê z zasadami gry?", "Gra w Boga",
				JOptionPane.YES_NO_OPTION);
		if (odp == JOptionPane.YES_OPTION) {
			new Kreator().main();
		} else if (odp == JOptionPane.NO_OPTION) {
			Samouczek appMenu = new Samouczek();
			appMenu.setVisible(true);

		} else if (odp == JOptionPane.CLOSED_OPTION) {
			JOptionPane.showMessageDialog(null, "gra zostanie wy³¹czona",
					"Gra w boga", JOptionPane.INFORMATION_MESSAGE);
		}

	}
}
