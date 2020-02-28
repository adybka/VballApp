package Views;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


import Controllers.BaseController;

public class HittingStatsView extends JTable {

	private static final String[] columns = { "Player#", "Hits", "Kills", "Conts", "Error", "Blocks", "+/-" };
	public DefaultTableModel model;
	
	public HittingStatsView(Integer[][] data) {
		super(new DefaultTableModel(data, columns));
		DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
		centerRender.setHorizontalAlignment(JLabel.CENTER);
		for(int i=0; i<7; i++) {
			this.getColumnModel().getColumn(i).setCellRenderer( centerRender );
		}
		this.setRowHeight(40);
		model = (DefaultTableModel) this.getModel();
	}
	
}
