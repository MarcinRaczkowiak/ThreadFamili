package okienka;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import otoczenie.ZasobyRodzinyM;

public class ZasobyRodziny extends JPanel {

	private JTable tabela;

	public ZasobyRodziny() {
		JTable tabela = createTable();
		JScrollPane jps = new JScrollPane(tabela);
		add(jps);
	}

	private JTable createTable() {
		DefaultTableModel dtm = getModel();
		tabela = new MojaTabela(dtm);

		tabela.setPreferredScrollableViewportSize(new Dimension(450, 163));
		tabela.setFillsViewportHeight(false);
		return tabela;
	}

	private DefaultTableModel getModel() {
		String[] columnNames = { "Nazwa surowca", "Iloœæ surowców" };
		String[][] data = prepareData();

		DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
		return dtm;
	}

	private static String[][] prepareData() {
		String[][] data = {
				{ "jedzenie", String.valueOf(ZasobyRodzinyM.getJedzenie()) },
				{ "jajka", String.valueOf(ZasobyRodzinyM.getJajka()) },
				{ "zio³a", String.valueOf(ZasobyRodzinyM.getZiola()) },
				{ "lekarstwo", String.valueOf(ZasobyRodzinyM.getLekarstwo()) },
				{ "glina", String.valueOf(ZasobyRodzinyM.getGlina()) },
				{ "ceg³y", String.valueOf(ZasobyRodzinyM.getCegla()) },
				{ "skóra", String.valueOf(ZasobyRodzinyM.getSkora()) },
				{ "garbowana skóra",
						String.valueOf(ZasobyRodzinyM.getGarbowanaSkora()) },
				{ "drewno", String.valueOf(ZasobyRodzinyM.getDrewno()) },
				{ "odchody", String.valueOf(ZasobyRodzinyM.getOdchody()) },
				{ "pasza", String.valueOf(ZasobyRodzinyM.getPasza()) },
				{ "dz", String.valueOf(ZasobyRodzinyM.getOdchody()) }, };
		return data;
	}

	public void updateTable() {
		tabela.setModel(getModel());
		repaint();
	}

	private class MojaTabela extends JTable {

		public MojaTabela(DefaultTableModel dtm) {
			super(dtm);
		}

		public boolean isCellEditable(int data, int columns) {
			return false;
		}

		public Component prepareRenderer(TableCellRenderer r, int data,
				int columns) {
			Component c = super.prepareRenderer(r, data, columns);
			if (data % 2 == 0)
				c.setBackground(Color.WHITE);

			else
				c.setBackground(Color.LIGHT_GRAY);

			return c;
		}
	}

}
