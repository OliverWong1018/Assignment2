//Author's name is Wen Zhang
package io;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//this Class is for manage the database including update and the game data such as points, SportID and select candidates data.
public class DatabaseConn {
	//get connection to database
	public static Connection getConn(){
		Connection connection = null;
		//"jdbc:hsqldb:file:DataBase/Ozlimpic;write_delay=false;MODE=MYSQL"
		//jdbc:hsqldb:hsql://localhost/mydb
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			connection = DriverManager.getConnection("jdbc:hsqldb:file:DataBase/Ozlimpic;ifexists=true;write_delay=false;shutdown=true", "Wayne", "");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return connection;
		
	}
	//get all candidates including athletes and referees from database
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
	//updated the sportID depending on type of different game
	public static void updateGameTimes(String sportID) {
		Connection conn = getConn();
		PreparedStatement pstmt;
		String updateTimes = null;
		if(sportID.startsWith("S")){
			int times = getGameTimes("swimming")+1;
			updateTimes = "Update gametimes set times = " + times + " where gameType = 'swimming';";
		}
		if(sportID.startsWith("R")){
			int times = getGameTimes("running")+1;
			updateTimes = "Update gametimes set times = " + times + " where gameType = 'running';";
		}
		if(sportID.startsWith("C")){
			int times = getGameTimes("cycling")+1;
			updateTimes = "Update gametimes set times = " + times + " where gameType = 'cycling';";
		}
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(updateTimes);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	//update the points for all athletes
	public static void updateAthletePoints(String AthleteID, int points) {
		Connection conn = getConn();
		PreparedStatement pstmt;
		String updatepoints = "Update athlete set points = " + "points +" + points + " where candidateid = '"+AthleteID+"';";
		
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(updatepoints);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	//get the SportID by different game type
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
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return times;
	}
	
	/*public static void main(String[] args) {
		Connection connection = getConn();*/
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
		
		
		
		try {
			connection.prepareStatement("drop table gametimes if exists;").execute();
			connection.prepareStatement("create table gametimes (gametype varchar(10), times integer);").execute();
			connection.prepareStatement("insert into gametimes (gametype, times) values ('swimming', 1);").execute();
			connection.prepareStatement("insert into gametimes (gametype, times) values ('running', 1);").execute();
			connection.prepareStatement("insert into gametimes (gametype, times) values ('cycling', 1);").execute();
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
		 * }
		*/
		
		
	// get all points of athletes from database
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
