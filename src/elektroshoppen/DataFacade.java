/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elektroshoppen;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bogs
 */
public class DataFacade {

    static private String FILENAME = "productData.dat";

    public static void saveProducts(ArrayList a) {
        ObjectOutputStream output = null;
        try {
            output = new ObjectOutputStream(new FileOutputStream(FILENAME));
            output.writeObject(a);
            output.close();
        } catch (IOException ex) {
            Logger.getLogger(DataFacade.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                output.close();
            } catch (IOException ex) {
                Logger.getLogger(DataFacade.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    public static void updatePIM() {
        try {
            PIM PIM = new PIM();
            int[] PIMProducts = PIM.listProducts();
            File file = new File("ERP.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String[] columns = scanner.nextLine().split(";");
                boolean found = false;
                int i = 0;
                while (found == false && i < PIMProducts.length) {
                    if (Integer.parseInt(columns[0]) == PIMProducts[i]) {
                        found = true;
                    } else {
                        i++;
                    }

                }
                if (found == false) {
                    PIM.addProduct(columns[0], columns[1], columns[2]);
                    if (columns[3].equals("cpu")) {
                        PIM.addCPU(columns[0], columns[4]);
                    }
                    if (columns[3].equals("graphics")) {
                        PIM.addGraphics(columns[0], columns[4]);
                    }
                    if (columns[3].equals("hd")) {
                        PIM.addHD(columns[0], columns[4], columns[5], columns[6]);
                    }
                    if (columns[3].equals("laptop")) {
                        PIM.addLaptop(columns[0], columns[4], columns[5], columns[6]);
                    }
                    if (columns[3].equals("ram")) {
                        PIM.addRAM(columns[0], columns[4], columns[5]);
                    }
                    if (columns[3].equals("speakers")) {
                        PIM.addSpeakers(columns[0], columns[4], columns[5], columns[6]);
                    }
                    if (columns[3].equals("tv")) {
                        PIM.addTV(columns[0], columns[4], columns[5]);
                    }

                }

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
