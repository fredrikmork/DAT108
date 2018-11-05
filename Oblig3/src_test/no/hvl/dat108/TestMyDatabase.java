package no.hvl.dat108;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class TestMyDatabase {
	Connection conn = null;
	Statement stmt = null;

	public void connectionPerson() {

		try {
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
		    conn = DriverManager.getConnection(
		            "jdbc:mysql://data1.hib.no:5432/h571544", "h571544", "123456");
		    stmt = conn.createStatement();
	
		    if (!conn.isClosed()) 
		        System.out.println("Successfully connection");
		} catch (SQLException e) {
		    e.printStackTrace();
		} catch (InstantiationException e) {
		    e.printStackTrace();
		} catch (IllegalAccessException e) {
		    e.printStackTrace();
		} catch (ClassNotFoundException e) {
		    e.printStackTrace();
		}
	}



	public String leggTilDB(Person object) {
	
		Person p = (Person) object ;
	
		String mobil = p.getMobil();
		String etternavn = p.getEtternavn();
		String fornavn = p.getFornavn();
		String kjonn = p.getKjonn();
		String passord = p.getPassord();
		
	
		String result = "";
		int rowcount;
	
		try {
		    String query = "Insert into course (fornavn , etternavn, mobil, passord, kjonn) values"
		            + " ('"
		            + fornavn
		            + "', '"
		            + etternavn
		            + "', '"
		            + mobil
		            + "')"
		            + "', '"
		            + passord
		            + "')"
		            + "', '"
		            + kjonn
		            + "')";
		    rowcount = stmt.executeUpdate(query);
		    if (rowcount > 0) {
		        result = "true";
		        System.out.println("Course inserted successful");
		    } else {
		        result = "false: The data could not be inserted in the databse";
		    }
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		return result;
	}
}