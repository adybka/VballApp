package Controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Models.Set;
import Models.Substitution;
import Models.Possession;

public class CsvSaver {
	
	private static final String[] columns = { "SetterPosition", "ReceiveType", "BlockingNum", "ReceivingPlayer", "PassQuality", "Attacker", "AttackResult", "killType", "KillX", "KillY", "killTeam", "hitFix", "BlockResult", "BlockingPlayer", "BlockingAssist" };
	private Set SetToSave;
	private FileWriter writer;
	private FileWriter miscWriter;
	
	public CsvSaver() {
	}
	
	public void newFile(Set set) {
		this.SetToSave = set;
		try {
			writer = new FileWriter(new File(SetToSave.name+".csv"));
			for(int i=0; i<columns.length-1; i++) {
				writer.write(columns[i]+",");
			}
			writer.write(columns[columns.length-1]+"\n");
						
		} catch (IOException e) {
			System.out.println("FILEWRITER NOT CREATED");
			e.printStackTrace();
		}
	}
	
	
	public void writeAllPossessions(ArrayList<Possession> possessions)  {
		for(Possession p: possessions) {
			for(int i=0; i<p.getAllThings().size()-1; i++) {
				try {
					if(p.getAllThings().get(i)==null)
						writer.write(",");
					else
						writer.write(p.getAllThings().get(i) + ",");
				} catch (IOException e) {
					System.out.println("Failed to add possession");
					e.printStackTrace();
				};
			}
			//write last entry
			try {
				if(p.getAllThings().get(p.getAllThings().size()-1)!=null)
					writer.write(p.getAllThings().get(p.getAllThings().size()-1)+"\n");
				else
					writer.write("\n");
			} catch (IOException e) {
				System.out.println("Failed to add possession");
				e.printStackTrace();
			}
		}
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void saveSetInformation(Set set) {
		try {
			miscWriter = new FileWriter(set.name+"SetInfo.txt");
			miscWriter.write("Set Name: "+set.name+"\n");
			miscWriter.write("Staring Line Up (1-6, lib): ");
			miscWriter.write(set.getLineUp().getP1()+", ");
			miscWriter.write(set.getLineUp().getP2()+", ");
			miscWriter.write(set.getLineUp().getP3()+", ");
			miscWriter.write(set.getLineUp().getP4()+", ");
			miscWriter.write(set.getLineUp().getP5()+", ");
			miscWriter.write(set.getLineUp().getP6()+", ");
			miscWriter.write(set.getLineUp().getLib()+"\n");
			miscWriter.write("\nSubs (off, On): \n");
			for(Substitution s: set.getSubs()) {
				miscWriter.write(s.getPlayerOff() + ", " + s.getPlayerOn()+"\n");
			}
			miscWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
