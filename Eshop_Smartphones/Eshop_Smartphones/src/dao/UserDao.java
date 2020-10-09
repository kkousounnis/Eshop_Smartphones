package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

import com.mysql.jdbc.Statement;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import model.Buyer;
import model.User;
import util.DbUtil;

public class UserDao {
	
private Connection connection;
	
	
	public UserDao() {
        connection = DbUtil.getConnection();
    }
	
	public boolean addStudent(User User) {
		boolean x=false; 
        try {
        	
            PreparedStatement preparedStatement = connection.
            		prepareStatement("INSERT INTO USERS (Username,Password,Idnumber, Name, Surname,Phonenumber,Address) VALUES (?,?,?,?,?,?,?)");
            // Parameters start with 1
            
            preparedStatement.setString(1, User.getUsername());
            preparedStatement.setString(2, User.getPassword());
            preparedStatement.setString(3, User.getIdnumber());
            preparedStatement.setString(4, User.getName());
            preparedStatement.setString(5, User.getSurname());
            preparedStatement.setString(6, User.getPhonenumber());
            preparedStatement.setString(7, User.getAddress());
            preparedStatement.executeUpdate();
            x=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x;
    }
	public boolean Check(String Username,String Password)  {
		boolean x=false;
		User User = new User();
         
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from dbphonestore.USERS where Username=?");
            preparedStatement.setString(1, Username);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	 
            	User.setPassword((rs.getString("Password")));
                
               if (Password.equals(User.getPassword())) {
            	    
            	   x=true;
            	   
               }
            	   
			 	
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return x;
    }
	public String valuesofBuyer(String Idnumber,String Username,String Password) {
		System.out.println(Idnumber+Username+Password);
		String Buyer = null;
		User User = new User();
		try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from dbphonestore.USERS where Idnumber=? and Username=? and Password=?");
            preparedStatement.setString(1, Idnumber);
            preparedStatement.setString(2, Username);
            preparedStatement.setString(3, Password);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	User.setName(rs.getString("Name"));
            	User.setSurname(rs.getString("Surname"));
            	User.setPhonenumber(rs.getString("Phonenumber"));
            	User.setPassword((rs.getString("Password")));
            	User.setAddress(rs.getString("Address"));              
                 
            }
            Buyer=User.getName()+"-"+User.getSurname()+"-"+User.getPhonenumber()+"-"+User.getAddress();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return Buyer;
	}
	public boolean addBuyer(String Status,String idnumber,String Model,String Price) {
		boolean x= false;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate localDate = LocalDate.now();
		System.out.println(dtf.format(localDate)); //2016/11/16
		try {
        	System.out.println(connection+"me lene giwrgo");
            PreparedStatement preparedStatement = connection.
            		prepareStatement("INSERT INTO dbphonestore.statusbuy  (Status,idnumber, model, price,date) VALUES (?,?,?,?,?)");
            // Parameters start with 1
            
            preparedStatement.setString(1, Status);
            preparedStatement.setString(2, idnumber);
            preparedStatement.setString(3, Model);
            preparedStatement.setString(4, Price);
            preparedStatement.setDate(5, java.sql.Date.valueOf(localDate));
            preparedStatement.executeUpdate();
            x=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		
		return x;
	}
	public String Status(String Username,String Password) {
		String x="";
		User User = new User();
        
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select Idnumber from dbphonestore.USERS where Username=? && Password=?");
            preparedStatement.setString(1, Username);
            preparedStatement.setString(2, Password);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	 
            	User.setIdnumber(rs.getString("Idnumber"));
                
               
            	   
			 	
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        String Status="";
        String model="";
        String price="";
        String date="";
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * \r\n" + 
                    		"from dbphonestore.users\r\n" + 
                    		"inner join dbphonestore.statusbuy\r\n" + 
                    		"on users.idnumber=statusbuy.idnumber\r\n"
                    		+ "where users.idnumber=?");
            preparedStatement.setString(1, User.getIdnumber()); 
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	 User.setName(rs.getString("Name"));
            	 User.setSurname(rs.getString("Surname"));
            	 User.setPhonenumber(rs.getString("Phonenumber"));
            	 User.setAddress(rs.getString("Address"));
            	 
            	
                Status=rs.getString("Status");
                model=rs.getString("model");
                price=rs.getString("price");
                date=rs.getString("date");
               
            	   
			 	
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
        
        x=User.getName()+"-"+User.getSurname()+"-"+User.getPhonenumber()+"-"+User.getAddress()+"-"+Status+"-"+model+"-"+price+"-"+date;
		
		return x;
	}
	public boolean CheckAdminLogin(String Username,String Password)  {
		boolean x=false;
		User User = new User();
         
        try {
            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from dbphonestore.admin where username=?");
            preparedStatement.setString(1, Username);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
            	 
            	User.setPassword((rs.getString("Password")));
                
               if (Password.equals(User.getPassword())) {
            	    
            	   x=true;
            	   
               }
            	   
			 	
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

     return x;
    }
	
	
	public  ArrayList<Buyer> getAllStudents() {
		
		 ArrayList<Buyer> Buyers = new  ArrayList<Buyer>();
         
        try {
            java.sql.Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * \r\n" + 
            		"from dbphonestore.users\r\n" + 
            		"inner join dbphonestore.statusbuy\r\n" + 
            		"on users.idnumber=statusbuy.idnumber");
            while (rs.next()) {
                Buyer Buyer=new Buyer();
                Buyer.setName(rs.getString("Name"));
                Buyer.setSurname(rs.getString("Surname"));
                Buyer.setPhonenumber(rs.getString("Phonenumber"));
                Buyer.setAddress(rs.getString("Address"));
           	 
                Buyer.setStatus(rs.getString("Status"));
               Buyer.setModel(rs.getString("model"));
               Buyer.setPrice(rs.getString("price"));
               Buyer.setDate(rs.getString("date"));
             
               Buyers.add(Buyer);
               
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Buyers;
    }
	
	
	

}
