package Main;

import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
public class Aktualne extends Query{
	public class Customer {
	    
	    private String name;
	    private String telnum;
	    private String ename;
	    private String id_order;
	    private String status;
	    private String model;
            private String date;
            private String time;
	    
	    public Customer(String name, String telnum, String ename, String id_order, String status,String model, String date, String time)
	    {
	        this.name = name;
	        this.telnum = telnum;
	        this.ename = ename;
                this.id_order= id_order;
                this.status= status;
                this.model=model;
                this.date=date;
                this.time=time;
	    }
	    
	    public String getname()
	    {
	        return name;
	    }
	    
	    public String gettelnum()
	    {
	        return telnum;
	    }
	    
	    public String getename()
	    {
	        return ename;
	    }
	    
	    public String getid_order()
	    {
	        return id_order;
	    }
	    public String getstatus()
	    {
	        return status;
	    }
	    public String getmodel()
	    {
	        return model;
	    }            
	    public String getdate()
	    {
	        return date;
	    }
            public String gettime()
	    {
	        return time;
	    }
	    
	}
	static ArrayList<Customer> tablica;
	//public static String aktualne = "T";
	private NumberFormat formater;
	public Aktualne() {
		super("SELECT distinct C.NAME NAZWA, C.TELNUM TELNUM, E.ENAME PRACOWNIK, O.ID_ORDER NRZAM, max(n.info) OVER(PARTITION BY n.id_order) as status, O.MODEL MODEL, O.STARTDATE DATA, O.STARTIME CZAS\n" +
"                        FROM CUSTOMERS C JOIN ORDERS O ON C.ID=O.ID_CUST JOIN NOTES N ON O.ID_ORDER=N.ID_ORDER JOIN EMP E ON N.ID_EMP=E.ID_EMP\n" +
"                        WHERE O.ACTIVE LIKE 'T'");
	}
	protected void process() throws SQLException{
		tablica = new ArrayList<Customer>();
		formater = NumberFormat.getCurrencyInstance();
		while(resultSet.next()) {
			Customer Customer = new Customer(
                                resultSet.getString("NAZWA"),
                                resultSet.getString("TELNUM"),
                                resultSet.getString("PRACOWNIK"),
                                resultSet.getString("NRZAM"),
                                resultSet.getString("STATUS"),
                                resultSet.getString("MODEL"),
                                resultSet.getString("DATA"),
                                resultSet.getString("CZAS")
                        );
            tablica.add(Customer);
		}
	}
}