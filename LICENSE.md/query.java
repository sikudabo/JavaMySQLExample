package com.simi.practice.easy;
import java.util.*;
import java.lang.*;
import java.io.*;
import com.simi.practice.easy.SimpleStuff;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class App 
{
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/knowledgeBase";
	
	//Database Credentials
	static final String USER = "simi";
	static final String PASS = "AmazonApples2018";
	

    public static void main( String[] args ) throws IOException, ClassNotFoundException
    {
    	Connection conn = null;
    	Statement stmt = null;
    	
    	try {
    		//STEP 2: Register JDBC driver
    		Class.forName("com.mysql.jdbc.Driver");
    		
    		//STEP 3: Open connection
    		System.out.println("Connecting to database...");
    		conn = DriverManager.getConnection(DB_URL, USER, PASS);
    		
    		//STEP 4: Execute query
    		System.out.println("Creating statement... ");
    		stmt = conn.createStatement();
    		String sql;
    		sql = "SELECT entity, abstract FROM entityMap";
    		ResultSet rs = stmt.executeQuery(sql);
    		
    		//STEP 5: Extract data from result set
    		while(rs.next()) {
    			//Retrieve by column name
    			String entity = rs.getString("entity");
    			String ab = rs.getString("abstract");
    			
    			//Display values
    			System.out.println("Entity: " + entity);
    			System.out.println("Abstract: " + ab);
    			
    		}
    	}
    		//STEP 6: Clean up environment:
    		catch(SQLException se) {
    			se.printStackTrace(System.out);
    			
    		}
    	System.out.println("Done");
    	}
    	
    }