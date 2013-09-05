import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class jdbcexercise {
  private Connection connect = null;
  private Statement statement = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;
  String url = "jdbc:mysql://localhost:3306/";
  String dbName = "jdbctutorial";
  String driverName = "com.mysql.jdbc.Driver";
  String userName = "root";
  String password = "root";
  public void readDataBase() throws Exception {
    try {
      // This will load the MySQL driver, each DB has its own driver
    	 Class.forName(driverName).newInstance();
    	 connect = DriverManager.getConnection(url+dbName, userName, password);

      // Statements allow to issue SQL queries to the database
      Statement st = connect.createStatement();
      // Result set get the result of the SQL query
      resultSet = statement
          .executeQuery("select * from Film");
      writeResultSet(resultSet);
      String table =
    		  "CREATE TABLE Film(year integer,film String,Director String,Country String)";
    		  st.executeUpdate(table);
    		  System.out.println("Table creation process successfully!");
    		  }
    		  catch(SQLException s){
    		  System.out.println("Table all ready exists!");
      // PreparedStatements can use variables and are more efficient
      preparedStatement = connect
          .prepareStatement("insert into  Film values (2010, Barney's Version, R.Louis, Canada)");
  
      preparedStatement.executeUpdate();

      // Remove again the insert comment
      preparedStatement = connect
      .prepareStatement("delete from Film where film< 2005 ; ");
     
      preparedStatement.executeUpdate();
      
      resultSet = statement
      .executeQuery("select * from film");
      writeMetaData(resultSet);
      
    } catch (Exception e) {
      throw e;
    } finally {
      close();
    }

  }

  private void writeMetaData(ResultSet resultSet) throws SQLException {
    //   Now get some metadata from the database
    // Result set get the result of the SQL query
    
    System.out.println("The columns in the table are: ");
    
    System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
    for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
      System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
    }
  }

  private void writeResultSet(ResultSet resultSet) throws SQLException {
    // ResultSet is initially before the first data set
    while (resultSet.next()) {
      // It is possible to get the columns via name
      // also possible to get the columns via the column number
      // which starts at 1
      // e.g. resultSet.getSTring(2);
      String user = resultSet.getString("myuser");
      String website = resultSet.getString("webpage");
      String summary = resultSet.getString("summary");
      Date date = resultSet.getDate("datum");
      String comment = resultSet.getString("comments");
      System.out.println("User: " + user);
      System.out.println("Website: " + website);
      System.out.println("Summary: " + summary);
      System.out.println("Date: " + date);
      System.out.println("Comment: " + comment);
    }
  }

  // You need to close the resultSet
  private void close() {
    try {
      if (resultSet != null) {
        resultSet.close();
      }

      if (statement != null) {
        statement.close();
      }

      if (connect != null) {
        connect.close();
      }
    } catch (Exception e) {

    }
  }

} 