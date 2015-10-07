package javaflights;

import javaflights.view.gui.JavaFlightsFrame;
import javaflights.view.ui.UserDialog;
import javaflights.model.SingletonData;
import javaflights.model.SingletonInstanceExistsException;

/**
 * Application class. Contains method main and launches all other components.
 * @author Aigul Zainullina
 * @see javaflights
 */
public class Application {
    public static void main(String args[]) {
        try {
            SingletonData.register();
        } catch (SingletonInstanceExistsException e) {
            System.err.println("Data has already been formed in this seession");
        }
        JavaFlightsFrame userDialog = new JavaFlightsFrame();
        userDialog.setVisible(true);
        //UserDialog.start();
    }
}

