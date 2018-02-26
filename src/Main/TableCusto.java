package Main;

import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
public class TableCusto extends Query{
	public class Customer {
	    
	        private String id;
	        private String name;
	        private String nip;
                private String street;
                private String pcode;
                private String city;
                private String telnum;
	    
	    public Customer(String id, String name, String nip, String street, String pcode,String city, String telnum)
	    {
	        this.id = id;
	        this.name = name;
	        this.nip = nip;
                this.street= street;
                this.pcode= pcode;
                this.city=city;
                this.telnum=telnum;
	    }
	    
	    public String getid()
	    {
	        return id;
	    }
	    
	    public String getname()
	    {
	        return name;
	    }
	    
	    public String getnip()
	    {
	        return nip;
	    }
	    
	    public String getstreet()
	    {
	        return street;
	    }
	    public String getpcode()
	    {
	        return pcode;
	    }
	    public String getcity()
	    {
	        return city;
	    }            
	    public String gettelnum()
	    {
	        return telnum;
	    }
	    
	}
	static ArrayList<Customer> table;
	//public static String aktualne = "T";
	private NumberFormat formater;
	public TableCusto() {
		super("SELECT * from customers ORDER by ID desc");
	}
	protected void process() throws SQLException{
		table = new ArrayList<Customer>();
		formater = NumberFormat.getCurrencyInstance();
		while(resultSet.next()) {
			Customer Customer = new Customer(
                                resultSet.getString("ID"),
                                resultSet.getString("NAME"),
                                resultSet.getString("NIP"),
                                resultSet.getString("STREET"),
                                resultSet.getString("PCODE"),
                                resultSet.getString("CITY"),
                                resultSet.getString("TELNUM")
                        );
            table.add(Customer);
		}
	}
}