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
		
			e.printStackTrace();
		}
		return connection;
		
	}
	public static ResultSet getAllCandidates() {

		Connection conn = getConn();
		ResultSet rs = null;
		String sq = "select * from candidate";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sq);
			rs = pstmt.executeQuery();
			
		
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
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
					System.out.print(rs.getString(f) + "  ");
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
	
	public static int getGameTimes(String gameType) {
		int times = 0;
		Connection conn = getConn();
		String sql = "select times from gametimes where gametype = '" + gameType + "'";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {	
					times = Integer.parseInt(rs.getString(1));	
				}
			System.out.println(times);
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return times;
	}
	
	public static void main(String[] args) {
		Connection connection = getConn();
		/*
		try {
			connection.prepareStatement("drop table athlete if exists;").execute();
			connection.prepareStatement("create table athlete (candidateid varchar(5), name varchar(20), type varchar(15),age integer,state varchar(5),points integer,PRIMARY KEY(candidateid));").execute();
			connection.prepareStatement("insert into athlete (candidateid, name, type, age, state,points) values ('A01', 'Tim','Swimming',31,'TAS',0);").execute();
			connection.prepareStatement("insert into athlete (candidateid, name, type, age, state,points) values ('A02', 'Oliver','Swimming',22,'WA',0);").execute();
			connection.prepareStatement("insert into athlete (candidateid, name, type, age, state,points) values ('A03', 'Danny','Swimming',31,'NSW',0);").execute();
			connection.prepareStatement("insert into athlete (candidateid, name, type, age, state,points) values ('A04', 'Misse','Swimming',29,'SA',0);").execute();
			connection.prepareStatement("insert into athlete (candidateid, name, type, age, state,points) values ('A05', 'Ronaldo','Swimming',21,'NT',0);").execute();
			connection.prepareStatement("insert into athlete (candidateid, name, type, age, state,points) values ('A06', 'Tom','Swimming',34,'QLD',0);").execute();
			connection.prepareStatement("insert into athlete (candidateid, name, type, age, state,points) values ('A07', 'Pattto','Running',23,'TAS',0);").execute();
			connection.prepareStatement("insert into athlete (candidateid, name, type, age, state,points) values ('A08', 'Totti','Running',19,'QLD',0);").execute();
			connection.prepareStatement("insert into athlete (candidateid, name, type, age, state,points) values ('A09', 'Byer','Running',25,'SA',0);").execute();
			connection.prepareStatement("insert into athlete (candidateid, name, type, age, state,points) values ('A10', 'Rolan','Running',26,'NSW',0);").execute();
			connection.prepareStatement("insert into athlete (candidateid, name, type, age, state,points) values ('A11', 'Dylan','Running',30,'WA',0);").execute();
			connection.prepareStatement("insert into athlete (candidateid, name, type, age, state,points) values ('A12', 'Jack','Running',33,'NT',0);").execute();
			connection.prepareStatement("insert into athlete (candidateid, name, type, age, state,points) values ('A13', 'Rose','Cycling',41,'TAS',0);").execute();
			connection.prepareStatement("insert into athlete (candidateid, name, type, age, state,points) values ('A14', 'Ozile','Cycling',24,'WA',0);").execute();
			connection.prepareStatement("insert into athlete (candidateid, name, type, age, state,points) values ('A15', 'Jams','Cycling',18,'NSW',0);").execute();
			connection.prepareStatement("insert into athlete (candidateid, name, type, age, state,points) values ('A16', 'Jason','Cycling',35,'NT',0);").execute();
			connection.prepareStatement("insert into athlete (candidateid, name, type, age, state,points) values ('A17', 'Zydan','Cycling',27,'QLD',0);").execute();
			connection.prepareStatement("insert into athlete (candidateid, name, type, age, state,points) values ('A18', 'Beckham','Cycling',28,'TAS',0);").execute();
			connection.prepareStatement("insert into athlete (candidateid, name, type, age, state,points) values ('A19', 'David','SuperAthlete',29,'QLD',0);").execute();
			connection.prepareStatement("insert into athlete (candidateid, name, type, age, state,points) values ('A20', 'Katte','SuperAthlete',41,'TAS',0);").execute();
			connection.prepareStatement("insert into athlete (candidateid, name, type, age, state,points) values ('A21', 'Alice','SuperAthlete',22,'NT',0);").execute();
			connection.prepareStatement("insert into athlete (candidateid, name, type, age, state,points) values ('A22', 'Allen','SuperAthlete',21,'WA',0);").execute();
			connection.prepareStatement("insert into athlete (candidateid, name, type, age, state,points) values ('A23', 'Coco','SuperAthlete',27,'NSW',0);").execute();
			connection.prepareStatement("insert into athlete (candidateid, name, type, age, state,points) values ('A24', 'Victoria','SuperAthlete',29,'TAS',0);").execute();
			
			
			// // query from the db
			connection.commit();

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		//DatabaseConn.getGameTimes("swimming");
		/*
		
		
		try {
			connection.prepareStatement("drop table gametimes if exists;").execute();
			connection.prepareStatement("create table gametimes (gametype varchar(10), times integer);").execute();
			connection.prepareStatement("insert into gametimes (gametype, times) values ('swimming', 0);").execute();
			connection.prepareStatement("insert into gametimes (gametype, times) values ('running', 0);").execute();
			connection.prepareStatement("insert into gametimes (gametype, times) values ('cycling', 0);").execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// making a connection
		connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('R01', 'Bush','Referee',29,'QLD');").execute();
			connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('R02', 'Tongwei','Referee',41,'TAS');").execute();
			connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('R03', 'Dakang','Referee',22,'NT');").execute();
			connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('R04', 'Liangping','Referee',21,'WA');").execute();
			connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('R05', 'Yuliang','Referee',27,'NSW');").execute();
			connection.prepareStatement("insert into candidate (candidateid, name, type, age, state) values ('R06', 'Chenhai','Referee',29,'TAS');").execute();
		
		
		displayAll("candidate");
		// end of stub code for in/out stub
		*/
		
		
	}
	public static ResultSet getPoints() {
		Connection conn = getConn();
		ResultSet rs = null;
		String sq = "select * from athlete";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sq);
			rs = pstmt.executeQuery();
			
		
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
		
	}
	
}
