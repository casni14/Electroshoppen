/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elektroshoppen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

/**
 *
 * @author Bogs
 */
public class PIM {

    String url = "jdbc:postgresql://localhost:5432/PIM";
    String user = "postgres";
    String password = "123";
    Connection con = null;
    public PIM () {
        connect();
    }

    private void connect() {

        //CONNECTING
        try {

            con = DriverManager.getConnection(url, user, password);

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(PIM.class.getName());
            lgr.log(Level.WARNING, ex.getMessage(), ex);

        }
    }

    public int[] listProducts() {
        int[] products = new int[100];
        try {
            Statement st = con.createStatement();
            String query = "select productid from product";
            ResultSet rs = st.executeQuery(query);
            int i = 0;
            while (rs.next()) {
                products[i] = rs.getInt(1);
                i++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    public ResultSet getPIMProducts() {
            ResultSet rs = null;
        try {
            Statement st = con.createStatement();
            String query = "select * from product natural join pim";
            rs = st.executeQuery(query);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PIM.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public void addProduct(String productID, String name, String price) {
        try {
            Statement st = con.createStatement();
            String update = "insert into product VALUES(" + productID + ",'" + name + "'," + price + ");";
            st.executeUpdate(update);
            update = "insert into PIM VALUES(" + productID + ", null, null);";
            st.executeUpdate(update);
        } catch (SQLException ex) {
            Logger.getLogger(PIM.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void addCPU(String cpuid, String busspeed) {
        try {
            Statement st = con.createStatement();
            String update = "insert into cpu VALUES(" + cpuid + "," + busspeed + ");";
            st.executeUpdate(update);

        } catch (SQLException ex) {
            Logger.getLogger(PIM.class.getName()).log(Level.SEVERE, null, ex);

        }
    }        

    public void addGraphics(String graphicsid, String clockspeed) {
                try {
            Statement st = con.createStatement();
            String update = "insert into graphics VALUES(" + graphicsid + "," + clockspeed + ");";
            st.executeUpdate(update);

        } catch (SQLException ex) {
            Logger.getLogger(PIM.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void addHD(String hdid, String speed, String capacity, String typeofhd) {
                try {
            Statement st = con.createStatement();
            String update = "insert into hd VALUES(" + hdid + "," + speed + "," + capacity + "," + typeofhd + ");";
            st.executeUpdate(update);

        } catch (SQLException ex) {
            Logger.getLogger(PIM.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void addLaptop(String productid, String screensize, String battery, String sound) {
                try {
            Statement st = con.createStatement();
            String update = "insert into laptop VALUES(" + productid + "," + screensize + "," + battery + "," + sound + ");";
            st.executeUpdate(update);

        } catch (SQLException ex) {
            Logger.getLogger(PIM.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void addRAM(String ramid, String busspeed, String typeOfRam) {
                try {
            Statement st = con.createStatement();
            String update = "insert into ram VALUES(" + ramid + "," + busspeed + "," + typeOfRam + ");";
            st.executeUpdate(update);

        } catch (SQLException ex) {
            Logger.getLogger(PIM.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void addSpeakers(String productid, String subwoofer, String frequency, String sensitivity) {
                try {
            Statement st = con.createStatement();
            String update = "insert into speakers VALUES(" + productid + "," + subwoofer + "," + frequency + "," + sensitivity + ");";
            st.executeUpdate(update);

        } catch (SQLException ex) {
            Logger.getLogger(PIM.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void addTV(String productid, String frequency, String screensize) {
                try {
            Statement st = con.createStatement();
            String update = "insert into tv VALUES(" + productid + "," + frequency + "," + screensize + ");";
            st.executeUpdate(update);

        } catch (SQLException ex) {
            Logger.getLogger(PIM.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

}
