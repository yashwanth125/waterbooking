/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajj;

/**
 *
 * @author Yashwanth
 */
import java.sql.*;

/**
 *
 * @author Yashwanth
 */
public class LoginDao {
    
    public static boolean validate(String name,String pass){  
boolean status=false;  
try{  
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my_db1111?zeroDateTimeBehavior=convertToNull","root","");
PreparedStatement ps=con.prepareStatement("select * from reg where no=? and pass=?");  
ps.setString(1,name);  
ps.setString(2,pass);  
      
ResultSet rs=ps.executeQuery();  
status=rs.next();  
}
catch(Exception e){System.out.println(e);}  
return status;  
}  
    
}

