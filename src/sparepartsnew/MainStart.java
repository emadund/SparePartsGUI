/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sparepartsnew;

import javax.swing.JFrame;
import sparepartsnew.ui.HomePageForm;

/**
 *
 * @author Marko HP
 */
public class MainStart {

    
    public static void main(String[] args) {
       HomePageForm homePageForm = new HomePageForm();
       homePageForm.setLocationRelativeTo(null);
       homePageForm.setExtendedState(JFrame.MAXIMIZED_BOTH);
       homePageForm.setVisible(true);
       
    }
    
}
