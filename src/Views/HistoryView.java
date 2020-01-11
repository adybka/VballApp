package Views;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Controllers.BaseController;

public class HistoryView extends JTable {

	private static final String[] columns = { "SetterPosition", "ReceiveType", "BlockingNum", "ReceivingPlayer", "PassQuality", "Attacker", "AttackResult", "killType", "KillX", "KillY", "killTeam", "hitFix", "BlockResult", "BlockingPlayer", "BlockingAssist" };
	private BaseController controller;
	public DefaultTableModel model;
	
	public HistoryView(BaseController controller) {
		super(new DefaultTableModel(columns, 0));
		DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
		centerRender.setHorizontalAlignment(JLabel.CENTER);
		for(int i=0; i<15; i++) {
			this.getColumnModel().getColumn(i).setCellRenderer( centerRender );
		}
		this.setRowHeight(70);
		model = (DefaultTableModel) this.getModel();
		this.controller = controller;
	}
	
}
