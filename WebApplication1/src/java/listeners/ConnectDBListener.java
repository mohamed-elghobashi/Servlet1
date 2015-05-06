/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listeners;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class ConnectDBListener implements ServletContextListener {

    @Override 
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("listener");
       Statement stmt=null;
        ResultSet rs=null; 
        try {        
            //connect DB
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/TEST","root","root");
            stmt=con.createStatement();
          
            sce.getServletContext().setAttribute("stmt", stmt);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectDBListener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDBListener.class.getName()).log(Level.SEVERE, null, ex);
        } 
    } 

    @Override 
    public void contextDestroyed(ServletContextEvent sce) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
