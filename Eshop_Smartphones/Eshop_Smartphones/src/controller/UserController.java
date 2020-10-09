package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 

import dao.UserDao;
import model.Buyer;
import model.User;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static String Admin_Menu = "/Admin_Menu.jsp";
    
	private UserDao dao;
	hashsalt hs=new hashsalt();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
        dao = new UserDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				response.setContentType("text/html; charset=UTF-8");
				response.setCharacterEncoding("UTF-8");
				request.setCharacterEncoding("UTF-8");
		    	String action = request.getParameter("action");
		    	String forward="";
		    	User User=new User();
		    	if(request.getParameter("PhoneNumber")!=null) {
		    		User.setPhonenumber( request.getParameter("PhoneNumber"));
		    	}
		    	User.setUsername(request.getParameter("username"));
		    	User.setPassword(request.getParameter("password"));
		    	
		    	User.setIdnumber(request.getParameter("idnumber"));
		    	
		    	User.setName(request.getParameter("name"));
		    	User.setSurname(request.getParameter("SurName"));
		    	User.setAddress(request.getParameter("Address"));
		    	
		        
		       try {
		    	   if(User.getPassword()!=null)
		    		   User.setPassword( hs.hashpassword(User.getPassword()));
		    	   if(User.getIdnumber()!=null)
		    		   User.setIdnumber(hs.hashpassword(User.getIdnumber()));
			
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		       
		       boolean x=false;
		    	if (action.equalsIgnoreCase("insert")){
		    		 
		    		x=dao.addStudent(User);
		    		 if(x==true)response.sendRedirect("ValidateMessage.jsp");
		    		 else {
		    			 response.sendRedirect("InvalidMessage.jsp");
		    		 }
		       }
		    	else if (action.equalsIgnoreCase("login")){
		    		  
		    		 
		    		
		    		
		        	  x=dao.Check(User.getUsername(),User.getPassword());
		        	  if(x==true) {
		        		Cookie Username =new Cookie("username",request.getParameter("username"));
		      			Cookie Password =new Cookie("password",User.getPassword());
		      			  
		      			// Set expiry date after 24 Hrs for both the cookies.
		      			Username.setMaxAge(60*60*24);
		      			Password.setMaxAge(60*60*24);
		      			
		      			// Add both the cookies in the response header.
		      		      response.addCookie( Username );
		      		      response.addCookie( Password );
		      		   
		        		  response.sendRedirect("Menu.jsp");
		        		  
		        	  }else {
		        		  response.sendRedirect("InvalidMessage.jsp");
		        	  }
		           }
		    	else if(action.equalsIgnoreCase("Buy")) {
		    		String name =request.getParameter("model");
		    		String price=request.getParameter("price");
		    		
		    		
		    			
		    		PrintWriter out = response.getWriter();
		    		 
		    		 
		    			
			    		
		    			 out.print("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n" + 
				    		 		"<html>\r\n" + 
				    		 		"<head>\r\n" + 
				    		 		"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n" + 
				    		 		"<link REL=STYLESHEET  HREF=\"theme.css\"\r\n" + 
				    		 		"      TYPE=\"text/css\">\r\n" + 
				    		 		"<title>Insert title here</title>\r\n" + 
				    		 		"</head>\r\n" + 
				    		 		"<body>\r\n" + 
				    		 		" <img src=\"back.png\"style=\"width:500px;float:left;background-size:cover;\">     \r\n" + 
				    		 		"   \r\n" + 
				    		 		"<div class=\"navbar\"> \r\n" + 
				    		 		"  <a href=\"index.jsp\">Αρχική</a>\r\n" + 
				    		 		" <form style=\"display:inline-block;\" method=\"post\" action=\"UserController\">\r\n" + 
				    		 		"  <input type=\"hidden\" name=\"action\" value=\"Status\" /> \r\n" + 
				    		 		"  <input class=\"but button1\"  type=\"submit\" value=\"Παραγγελίες\" >\r\n" + 
				    		 		"  </form>\r\n" + 
				    		 		"  <form style=\"display:inline-block;\" method=\"post\" action=\"UserController\"> \r\n" + 
				    		 		" <input type=\"hidden\" name=\"action\" value=\"logout\" /> \r\n" + 
				    		 		"  <input class=\"but button1\"  type=\"submit\" value=\"Αποσύνδεση\" >\r\n" + 
				    		 		"  </form> "+
				    		 		"  \r\n" + 
				    		 		"</div>\r\n" + 
				    		 		"<br>\r\n" + 
				    		 		"<br>\r\n" + 
				    		 		"<br>\r\n" + 
				    		 		"<br>\r\n" + 
				    		 		"<fieldset style=\"position:absolute\">  				\r\n" + 
				    		 		"<form method=\"post\" action=\"UserController\"> \r\n" + 
				    		 		"<input type=\"hidden\" name=\"action\" value=\"BuyCheck\" /> \r\n" +		    		
				    		 		"To μοντέλο που θέλετε να αγοράσετε είναι :<input style=\"border:white;font-size:20px;\" type=\"text\" name=\"model\" value=\""+name+"\"required><br></br> \r\n" + 
				    		 		"Τα χρήματα που θα δώσετε είναι τα εξής:<input style=\"border:white;font-size:20px\" type=\"text\" name=\"price\" value=\""+price+"\"required><br></br> \r\n" + 
				    		 		"Για να προχωρήσετε στην συναλλαγή θα πρέπει να πληκτρολογήσεις τον αριθμό ταυτότητας σου:"
				    		 		+ "<br></br>"
				    		 		+ "<input type=\"text\" maxlength=\"7\" placeholder=\"XX-XXXX\" style=\"text-transform:uppercase\" style=\"text-transform:uppercase\" name=\"idnumber\" required><br></br>\r\n" + 
				    		 		"<input type=\"submit\" value=\"Συνέχεια\" > \r\n" + 
				    		 		"				 	\r\n" + 
				    		 		"</form>\r\n" + 
				    		 		"</fieldset>\r\n" + 
				    		 		"\r\n" + 
				    		 		"\r\n" + 
				    		 		"</body>\r\n" + 
				    		 		"</html>"); 
		    		 }
		    		 if(action.equalsIgnoreCase("BuyCheck")){ 
		    			
		    			String name =request.getParameter("model");
			    		String price=request.getParameter("price");
			    		String idnumber=request.getParameter("idnumber");
			    		PrintWriter out = response.getWriter();
			    		
			    		Cookie cookie = null;
				  	      Cookie[] cookies = null;
				  	   
				  	      // Get an array of Cookies associated with this domain
				  	      cookies = request.getCookies();
				  	      
				  	      if(cookies!=null) {
				  	    	  for (int i=0;i<cookies.length;i++) {
				  	    		  cookie = cookies[i];
				  	    		  if(cookie.getName().equals("username"))
				  	    				  {
				  	    			  User.setUsername(cookie.getValue());
				  	    			  
				  	    		  }
				  	    		  if(cookie.getName().equals("password")) {
				  	    			  User.setPassword(cookie.getValue());
				  	    		  }
				  	              
				  	    	  
				  	    	  }
				  	    	  
				  	      
				  	      }
				  	      else {
				  	    	  
				  	    	  out.print("NO COOKIES FOUND");
				  	      }
			    		
			    		String Buyer=dao.valuesofBuyer(User.getIdnumber(),User.getUsername(),User.getPassword());
			    		
			    		
			    		String [] buyer=Buyer.split("-");
			    		System.out.println(buyer[0]+"dsjknd");
			    		if(buyer[0].contains("null")) {
			    		
			    			 out.print("<html>\r\n" + 
			    			 		"<head>\r\n" + 
			    			 		"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n" + 
			    			 		"<link REL=STYLESHEET  HREF=\"theme.css\"\r\n" + 
			    			 		"      TYPE=\"text/css\">\r\n" + 
			    			 		"<title>Insert title here</title>\r\n" + 
			    			 		"</head>\r\n" + 
			    			 		"<body>\r\n" + 
			    			 		"<img src=\"back.jpg\"style=\"width:500px;float:left;background-size:cover;\">     \r\n" + 
			    			 		"   \r\n" + 
			    			 		"<div class=\"navbar\"> \r\n" + 
			    			 		"  <a href=\"index.jsp\">Αρχική</a>\r\n" +
			    			 		" <form style=\"display:inline-block;\" method=\"post\" action=\"UserController\">\r\n" + 
				    		 		"  <input type=\"hidden\" name=\"action\" value=\"Status\" /> \r\n" + 
				    		 		"  <input class=\"but button1\"  type=\"submit\" value=\"Παραγγελίες\" >\r\n" + 
				    		 		"  </form>\r\n" + 
				    		 		"  <form style=\"display:inline-block;\" method=\"post\" action=\"UserController\"> \r\n" + 
				    		 		" <input type=\"hidden\" name=\"action\" value=\"logout\" /> \r\n" + 
				    		 		"  <input class=\"but button1\"  type=\"submit\" value=\"Αποσύνδεση\" >\r\n" + 
				    		 		"  </form> "+
			    			 		"</div>\r\n" + 
			    			 		"<br>\r\n" + 
			    			 		"<br>\r\n" + 
			    			 		"<br>\r\n" + 
			    			 		"<br>\r\n" + 
			    			 		"\r\n" + 
			    			 		"<h2 style=\"color:red\">Λάθος Εισαγωγή Αριθμού ταυτότητας</h2>\r\n" + 
			    			 		"<meta http-equiv=\"refresh\" content=\"2; URL='Menu.jsp'\" />\r\n" + 
			    			 		"</body>\r\n" + 
			    			 		"</html>");
			    			}else {
		    			out.print("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n" + 
				    		 		"<html>\r\n" + 
				    		 		"<head>\r\n" + 
				    		 		"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n" + 
				    		 		"<link REL=STYLESHEET  HREF=\"theme.css\"\r\n" + 
				    		 		"      TYPE=\"text/css\">\r\n" + 
				    		 		"<title>Insert title here</title>\r\n" + 
				    		 		"</head>\r\n" + 
				    		 		"<body>\r\n" + 
				    		 		" <img src=\"back.png\"style=\"width:500px;float:left;background-size:cover;\">     \r\n" + 
				    		 		"   \r\n" + 
				    		 		"<div class=\"navbar\"> \r\n" + 
				    		 		"  <a href=\"index.jsp\">Αρχική</a>\r\n" + 
				    		 		" <form style=\"display:inline-block;\" method=\"post\" action=\"UserController\">\r\n" + 
				    		 		"  <input type=\"hidden\" name=\"action\" value=\"Status\" /> \r\n" + 
				    		 		"  <input class=\"but button1\"  type=\"submit\" value=\"Παραγγελίες\" >\r\n" + 
				    		 		"  </form>\r\n" + 
				    		 		"  <form style=\"display:inline-block;\" method=\"post\" action=\"UserController\"> \r\n" + 
				    		 		" <input type=\"hidden\" name=\"action\" value=\"logout\" /> \r\n" + 
				    		 		"  <input class=\"but button1\"  type=\"submit\" value=\"Αποσύνδεση\" >\r\n" + 
				    		 		"  </form> "+
				    		 		"  \r\n" + 
				    		 		"</div>\r\n" + 
				    		 		"<br>\r\n" + 
				    		 		"<br>\r\n" + 
				    		 		"<br>\r\n" + 
				    		 		"<br>\r\n" + 
				    		 		"<fieldset style=\"position:absolute\">  				\r\n" + 
				    		 		"<form method=\"post\" action=\"UserController\"> \r\n" + 
				    		 		"<input type=\"hidden\" name=\"action\" value=\"AddPurchase\" /> \r\n" +		    		
				    		 		"To μοντέλο που θέλετε να αγοράσετε είναι :<input style=\"border:white;font-size:20px;\" type=\"text\" name=\"model\" value=\""+name+"\"required><br></br> \r\n" + 
				    		 		"Τα χρήματα που θα δώσετε είναι τα εξής:<input style=\"border:white;font-size:20px\" type=\"text\" name=\"price\" value=\""+price+"\"required><br></br> \r\n" +  	
				    		 		 
				    		 		"Αριθμος Ταυτότητας:<input type=\"text\" maxlength=\"7\" placeholder=\"XX-XXXX\" style=\"text-transform:uppercase\" name=\"idnumber\" value=\""+idnumber+"\"required><br></br> "
				    		 		 
				    		 		+"Όνομα :<input style=\"border:white;font-size:20px;\" type=\"text\" name=\"Firstname\" value=\""+buyer[0]+"\"required><br></br> \r\n" + 
				    		 		 
				    		 		"Επίθετο :<input style=\"border:white;font-size:20px;\" type=\"text\" name=\"SurName\" value=\""+buyer[1]+"\"required><br></br> \r\n" +
				    		 		 
				    		 		"Αριθμός Τηλεφώνου :<input style=\"border:white;font-size:20px;\" type=\"text\" name=\"PhoneNumber\" value=\""+buyer[2]+"\"required><br></br> \r\n" +
				    		 	 
				    		 		"Διεύθυνση :<input style=\"border:white;font-size:20px;\" type=\"text\" name=\"Address\" value=\""+buyer[3]+"\"required><br></br> \r\n" 
				    		 		+ "<br></br>"
				    		 		+ 
				    		 		 
				    		 		"<input type=\"submit\" value=\"Επιβεβαίωση Αγοράς\" > \r\n" + 
				    		 		"				 	\r\n" + 
				    		 		"</form>\r\n" + 
				    		 		"</fieldset>\r\n" + 
				    		 		"\r\n" + 
				    		 		"\r\n" + 
				    		 		"</body>\r\n" + 
				    		 		"</html>");
		    			}
		    		}
		    	if(action.equalsIgnoreCase("AddPurchase")) {
		    		String price = request.getParameter("price");
		    		String model=request.getParameter("model");
		    		String Status="pending";
		    		
		    		User.setIdnumber(request.getParameter("idnumber"));
		    		User.setName(request.getParameter("Firstname"));
		    		User.setSurname(request.getParameter("Surname"));
		    		User.setPhonenumber(request.getParameter("Phonenumber"));
		    		User.setAddress(request.getParameter("Address"));
		    		
		    		PrintWriter out = response.getWriter();
		    		 
				   try {
					   if(User.getIdnumber()!=null)
						   
						   User.setIdnumber(hs.hashpassword(User.getIdnumber()));
					   
					  
					   
				   } catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				   }
				   x=dao.addBuyer(Status, User.getIdnumber(), model, price);	 
		    		if (x==false) {
		    			out.print("<html>\r\n" + 
		    					"<head>\r\n" + 
		    					"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n" + 
		    					"<link REL=STYLESHEET  HREF=\"theme.css\"\r\n" + 
		    					"      TYPE=\"text/css\">\r\n" + 
		    					"<title>Insert title here</title>\r\n" + 
		    					"</head>\r\n" + 
		    					"<body>\r\n" + 
		    					"<img src=\"back.jpg\"style=\"width:500px;float:left;background-size:cover;\">     \r\n" + 
		    					"   \r\n" + 
		    					"<div class=\"navbar\"> \r\n" + 
		    					"  <a href=\"index.jsp\">Αρχική</a>\r\n" + 		    					 
		    					"</div>\r\n" + 
		    					" <form style=\"display:inline-block;\" method=\"post\" action=\"UserController\">\r\n" + 
		    					"  <input type=\"hidden\" name=\"action\" value=\"Status\" /> \r\n" + 
		    					"  <input class=\"but button1\"  type=\"submit\" value=\"Παραγγελίες\" >\r\n" + 
		    					"  </form>\r\n" + 
		    					"  <form style=\"display:inline-block;\" method=\"post\" action=\"UserController\"> \r\n" + 
		    					" <input type=\"hidden\" name=\"action\" value=\"logout\" /> \r\n" + 
		    					"  <input class=\"but button1\"  type=\"submit\" value=\"Αποσύνδεση\" >\r\n" + 
		    					"  </form> "+
		    					"<br>\r\n" + 
		    					"<br>\r\n" + 
		    					"<br>\r\n" + 
		    					"<br>\r\n" + 
		    					"\r\n" + 
		    					"<h2 style=\"color:red\">Δεν μπορείτε να αγορασετε το ίδιο προιόν δύο φορές </h2>\r\n" + 
		    					"<meta http-equiv=\"refresh\" content=\"2; URL='Menu.jsp'\" />\r\n" + 
		    					"</body>\r\n" + 
		    					"</html>");
		    			}
		    		else {
		    			out.print("<html>\r\n" + 
		    					"<head>\r\n" + 
		    					"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n" + 
		    					"<link REL=STYLESHEET  HREF=\"theme.css\"\r\n" + 
		    					"      TYPE=\"text/css\">\r\n" + 
		    					"<title>Insert title here</title>\r\n" + 
		    					"</head>\r\n" + 
		    					"<body>\r\n" + 
		    					"<img src=\"back.jpg\"style=\"width:500px;float:left;background-size:cover;\">     \r\n" + 
		    					"   \r\n" + 
		    					"<div class=\"navbar\"> \r\n" + 
		    					"  <a href=\"index.jsp\">Αρχική</a>\r\n" + 		    					 
		    					"</div>\r\n" +
		    					" <form style=\"display:inline-block;\" method=\"post\" action=\"UserController\">\r\n" + 
		    					"  <input type=\"hidden\" name=\"action\" value=\"Status\" /> \r\n" + 
		    					"  <input class=\"but button1\"  type=\"submit\" value=\"Παραγγελίες\" >\r\n" + 
		    					"  </form>\r\n" + 
		    					"  <form style=\"display:inline-block;\" method=\"post\" action=\"UserController\"> \r\n" + 
		    					" <input type=\"hidden\" name=\"action\" value=\"logout\" /> \r\n" + 
		    					"  <input class=\"but button1\"  type=\"submit\" value=\"Αποσύνδεση\" >\r\n" + 
		    					"  </form> "+
		    					"<br>\r\n" + 
		    					"<br>\r\n" + 
		    					"<br>\r\n" + 
		    					"<br>\r\n" + 
		    					"\r\n" + 
		    					"<h2 style=\"color:green\">Η παραγγελία έχει πραγματοποιηθεί  μπορείτε να πάτε στις παραγγελίες σας για να δείτε την αγορά σας</h2>\r\n" + 
		    					"<meta http-equiv=\"refresh\" content=\"2; URL='Menu.jsp'\" />\r\n" + 
		    					"</body>\r\n" + 
		    					"</html>");
		    		}
		    		 
		    		
		    		} 	
		    	if(action.equalsIgnoreCase("Status")) {
		    		Cookie cookie = null;
		  	      Cookie[] cookies = null;
		  	    PrintWriter out = response.getWriter();
		  	      // Get an array of Cookies associated with this domain
		  	      cookies = request.getCookies();
		  	      
		  	      if(cookies!=null) {
		  	    	  for (int i=0;i<cookies.length;i++) {
		  	    		  cookie = cookies[i];
		  	    		  if(cookie.getName().equals("username"))
		  	    				  {
		  	    			  User.setUsername(cookie.getValue());
		  	    			  
		  	    		  }
		  	    		  if(cookie.getName().equals("password")) {
		  	    			  User.setPassword(cookie.getValue());
		  	    		  }
		  	              
		  	    	  
		  	    	  }
		  	    	  
		  	      
		  	      }
		  	      else {
		  	    	  
		  	    	  out.print("NO COOKIES FOUND");
		  	      }
		  	      		
		    			String UserBuyValues=dao.Status(User.getUsername(), User.getPassword());
		    			String [] buyer=UserBuyValues.split("-");
		    			if(buyer[4].contains("pending")) {
		    				buyer[4]="Eκρεμεί";
		    			}
		    			out.print("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n" + 
			    		 		"<html>\r\n" + 
			    		 		"<head>\r\n" + 
			    		 		"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n" + 
			    		 		"<link REL=STYLESHEET  HREF=\"theme.css\"\r\n" + 
			    		 		"      TYPE=\"text/css\">\r\n" + 
			    		 		"<title>Insert title here</title>\r\n" + 
			    		 		"</head>\r\n" + 
			    		 		"<body>\r\n" + 
			    		 		" <img src=\"back.png\"style=\"width:500px;float:left;background-size:cover;\">     \r\n" + 
			    		 		"   \r\n" + 
			    		 		"<div class=\"navbar\"> \r\n" + 
			    		 		"  <a href=\"index.jsp\">Αρχική</a>\r\n" + 
			    		 		" <form style=\"display:inline-block;\" method=\"post\" action=\"UserController\">\r\n" + 
			    		 		"  <input type=\"hidden\" name=\"action\" value=\"Status\" /> \r\n" + 
			    		 		"  <input class=\"but button1\"  type=\"submit\" value=\"Παραγγελίες\" >\r\n" + 
			    		 		"  </form>\r\n" + 
			    		 		"  <form style=\"display:inline-block;\" method=\"post\" action=\"UserController\"> \r\n" + 
			    		 		" <input type=\"hidden\" name=\"action\" value=\"logout\" /> \r\n" + 
			    		 		"  <input class=\"but button1\"  type=\"submit\" value=\"Αποσύνδεση\" >\r\n" + 
			    		 		"  </form> "+
			    		 		"  \r\n" + 
			    		 		"</div>\r\n" + 
			    		 		"<br>\r\n" + 
			    		 		"<br>\r\n" + 
			    		 		"<br>\r\n" + 
			    		 		"<br>\r\n" + 
			    		 		"<fieldset style=\"position:absolute\">  				\r\n" + 
			    		 		"<form method=\"post\" action=\"UserController\"> \r\n" + 
			    		 		"<input type=\"hidden\" name=\"action\" value=\"AddPurchase\" /> \r\n" +		    		
			    		 		 
			    		 		 
			    		 		"Όνομα :<b> "+buyer[0]+"  </b> <br></br> \r\n" + 
			    		 		 
			    		 		"Επίθετο :<b> "+buyer[1]+"</b> <br></br> \r\n" +
			    		 		 
			    		 		"Αριθμός Τηλεφώνου :<b> "+buyer[2]+"</b> <br></br> \r\n" +
			    		 	 
			    		 		"Διεύθυνση <b>:"+buyer[3]+"</b><br></br> \r\n" 
			    		 		+ "<br></br>"+
			    		 		"Αιτημα Έγκρισης Απο διαχειριστή:<b style=\"border:white;background-color:grey;\" >"+buyer[4]+" </b><br></br> \r\n" 
			    		 		+"<br></br>"
			    		 		+ "To μοντέλο που θέλετε να αγοράσετε είναι :<b> "+buyer[5]+"</b> <br></br> \r\n" + 
			    		 		"<br></br>"
			    		 		+ "Τα χρήματα που θα δώσετε είναι τα εξής: <b>"+buyer[6]+"</b> <br></br> \r\n" +  	
			    		 		 
								"Ημερομηνία Αιτήματος: <b> "+buyer[7]+"-"+buyer[8]+"-"+buyer[9]+" </b><br></br> \r\n" + 
			    		 		 
			    		 		 
			    		 		"				 	\r\n" + 
			    		 		"</form>\r\n" + 
			    		 		"</fieldset>\r\n" + 
			    		 		"\r\n" + 
			    		 		"\r\n" + 
			    		 		"</body>\r\n" + 
			    		 		"</html>");
		    			
		    			 
		    		}
		    	
		    	
		    	
		    	
		    	
		    	if(action.equalsIgnoreCase("logout")) {
		    		Cookie cookie = null;
		  	      Cookie[] cookies = null;
		  	         
		  	      // Get an array of Cookies associated with this domain
		  	      cookies = request.getCookies();
		  	      
		  	      if( cookies != null ) {
		  	          

		  		         for (int i = 0; i < cookies.length; i++) {
		  		            cookie = cookies[i];

		  		            if( (cookie.getName( )).compareTo("username") == 0) {
		  		               cookie.setMaxAge(0);
		  		               response.addCookie(cookie);
		  		                
		  		                
		  		            }
		  		            if((cookie.getName( )).compareTo("password") == 0 ) {
		  			               cookie.setMaxAge(0);
		  			               response.addCookie(cookie);
		  			                
		  			            }
		  		             
		  		         }
		  		      } else {
		  		    	  System.out.print("No cookies found!!!"); 
		  		      }
		  	      
		  	      response.sendRedirect("index.jsp");
		    	}
		    	if(action.equalsIgnoreCase("Admin_Menu")) {
		    			
		    		 x=dao.CheckAdminLogin(User.getUsername(), User.getPassword()) ;
		    		  
		    		 if(x==true) {
			        		 
		    			 request.setAttribute("Buyers", dao.getAllStudents());
		    			  
		    			 
		    			 
		    			 request.getRequestDispatcher("Admin_Menu.jsp").forward(request, response);
		    	            //response.sendRedirect("Admin_Menu.jsp"); 
			        	  }else {
			        		  response.sendRedirect("InvalidMessage.jsp");
			        	  }
			           
		    	}
		    }
}


