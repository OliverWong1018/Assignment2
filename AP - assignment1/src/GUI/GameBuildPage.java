//Author is Wen Zhang
package GUI;

import java.sql.ResultSet;
import java.sql.SQLException;

import io.DatabaseConn;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;

// Class for building game
public class GameBuildPage {

	// set a game title in GameBuildPage
	public static void setGameTitle(String currentGameType, Label currentGameType2) {
		if (Main.currentGameType.equals("S"))
			currentGameType2.setText("Swimming Game");
		if (Main.currentGameType.equals("C"))
			currentGameType2.setText("Cycling Game");
		if (Main.currentGameType.equals("R"))
			currentGameType2.setText("Running Game");
	}

	// insert data in Candidate Table
	public static void setLeftTableValue(ObservableList<Table> data, ResultSet rs) {
		try {
			while (rs.next()) {
				data.add(new Table("", "", "", "", ""));
				int f = data.size() - 1;
				data.get(f).setRID1(rs.getString(1));
				data.get(f).setRName1(rs.getString(2));
				data.get(f).setRAge1(rs.getString(4));
				data.get(f).setRState1(rs.getString(5));
				data.get(f).setRType1(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static int getAlthNeededNum(int althNeededNum, ObservableList<Table2> data2) {
		althNeededNum = 8;
		for (int i = 0; i < data2.size(); i++) {
			if (!data2.get(i).getRType2().equals("Referee")) {
				althNeededNum -= 1;
			}
		}
		return althNeededNum;
	}

	public static int getRefNeededNum(int refNeededNum, ObservableList<Table2> data2) {
		refNeededNum = 1;
		for (int i = 0; i < data2.size(); i++) {
			if (data2.get(i).getRType2().equals("Referee")) {
				refNeededNum = 0;
			}
		}
		return refNeededNum;
	}
}
