package io;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hsqldb.Server;

public class DatabaseConn {
	
	public static Connection getConn(){
		Connection connection = null;
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			connection = DriverManager.getConnection("jdbc:hsqldb:file:DataBase/Ozlimpic;hsqldb.write_delay=false", "Wayne", "");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
		
	}
	public static void main(String[] args) {

		Connection connection = getConn();
		// making a connection
		
		try {
			connection.prepareStatement("drop table candidate if exists;").execute();
			connection.prepareStatement("create table candidate (candidateid varchar(5), name varchar(20), type varchar(15),age integer,state varchar(5),PRIMARY KEY(candidateid));").execute();
			connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('A01', 'Tim','Swimming',31,'TAS');").execute();
			connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('A02', 'Oliver','Swimming',22,'WA');").execute();
			connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('A03', 'Danny','Swimming',31,'NSW');").execute();
			connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('A04', 'Misse','Swimming',29,'SA');").execute();
			connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('A05', 'Ronaldo','Swimming',21,'NT');").execute();
			connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('A06', 'Tom','Swimming',34,'QLD');").execute();
			connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('A07', 'Pattto','Running',23,'TAS');").execute();
			connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('A08', 'Totti','Running',19,'QLD');").execute();
			connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('A09', 'Byer','Running',25,'SA');").execute();
			connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('A10', 'Rolan','Running',26,'NSW');").execute();
			connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('A11', 'Dylan','Running',30,'WA');").execute();
			connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('A12', 'Jack','Running',33,'NT');").execute();
			connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('A13', 'Rose','Cycling',41,'TAS');").execute();
			connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('A14', 'Ozile','Cycling',24,'WA');").execute();
			connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('A15', 'Jams','Cycling',18,'NSW');").execute();
			connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('A16', 'Jason','Cycling',35,'NT');").execute();
			connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('A17', 'Zydan','Cycling',27,'QLD');").execute();
			connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('A18', 'Beckham','Cycling',28,'TAS');").execute();
			connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('A19', 'David','SuperAthlete',29,'QLD');").execute();
			connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('A20', 'Katte','SuperAthlete',41,'TAS');").execute();
			connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('A21', 'Alice','SuperAthlete',22,'NT');").execute();
			connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('A22', 'Allen','SuperAthlete',21,'WA');").execute();
			connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('A23', 'Coco','SuperAthlete',27,'NSW');").execute();
			connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('A24', 'Victoria','SuperAthlete',29,'TAS');").execute();
			connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('R01', 'Bush','Referee',29,'QLD');").execute();
			connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('R02', 'Tongwei','Referee',41,'TAS');").execute();
			connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('R03', 'Dakang','Referee',22,'NT');").execute();
			connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('R04', 'Liangping','Referee',21,'WA');").execute();
			connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('R05', 'Yuliang','Referee',27,'NSW');").execute();
			connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('R06', 'Chenhai','Referee',29,'TAS');").execute();
			
			// // query from the db
			connection.commit();

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		displayAll("candidate");
		// end of stub code for in/out stub

	}

	public static void displayAll(String s) {

		Connection conn = getConn();

		String sql2 = "select * from " + s;
		PreparedStatement pstmt4;
		try {
			pstmt4 = (PreparedStatement) conn.prepareStatement(sql2);
			ResultSet rs = pstmt4.executeQuery();
			int col = rs.getMetaData().getColumnCount();
			System.out.println("============================");
			while (rs.next()) {
				for (int f = 1; f <= col; f++) {
					System.out.print(rs.getString(f) + "\t");
				}
				System.out.println("");
			}
			System.out.println("============================");
			System.out.println("Retrieved Data from " + s + " table.");
			pstmt4.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
