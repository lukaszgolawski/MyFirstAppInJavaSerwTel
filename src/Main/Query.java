package Main;

import java.sql.*;

import javax.swing.JOptionPane;

abstract public class Query {
	private static final String password = "admin";
	private static final String username = "java";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String sql;
	private Connection connection;
	private Statement statement;
        //private PreparedStatement preparedstatement;
	protected ResultSet resultSet;
	//private ResultSetMetaData resultColumn;
	
	public Query(String sql) {
		this.sql = sql;
		
	}
	
	public void execute() {
		try {
			connectToDatabase();
			//JOptionPane.showMessageDialog(null, "Połączono pomyślnie");	
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Błąd danych połączenia z bazą!");	
		}
		try {
			executeSQL();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Błąd w zapytaniu do bazy danych");
		}
		try {
			process();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();	
		}
		try {
			close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	private void connectToDatabase() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection(url, username, password);	
	}
	
	private void executeSQL() throws ClassNotFoundException, SQLException{
		statement = connection.createStatement();
		resultSet = statement.executeQuery(sql);
		//resultColumn = resultSet.getMetaData();
	}
	
	abstract protected void process() throws SQLException;
	
	private void close() throws SQLException{
		resultSet.close();
		statement.close();
		connection.close();
             // JOptionPane.showMessageDialog(null, "Zakończono pomyślnie");	
	}
}
