/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Isaac
 */
public class TipNoFocus implements FocusListener {
    
    private Component component;
    private String tipText;
    private Color bgColor, tipColor;
    private int type;
    private static final int TXT_FIELD = 0, PW_FIELD = 1;
    
    public TipNoFocus(Component component, String tipText, 
            Color bgColor, Color tipColor, int type) {
        this.component = component;
        this.tipText = tipText;
        this.bgColor = bgColor;
        this.tipColor = tipColor;
        this.type = type;
        
        ((JTextField)component).setText(tipText);//insert tip text
        component.setForeground(tipColor); //set tipColor
    }
    
    
    @Override
    public void focusGained(FocusEvent e) {
        if(type == TXT_FIELD) {
            JTextField txtComp = (JTextField) component;
            if(txtComp.getText().equals(tipText)) {
                txtComp.setText("");
                txtComp.setForeground(bgColor); //toogle color to bgColor
            }
        }else if(type == PW_FIELD) {
            JPasswordField pwComp = (JPasswordField) component;
            if(String.valueOf(pwComp.getPassword()).equals(tipText)) {
                pwComp.setText("");
                pwComp.setForeground(bgColor); //toogle color to bgColor
            }
        }
       
    }

    @Override
    public void focusLost(FocusEvent e) {
        if(type == TXT_FIELD) {
            JTextField txtComp = (JTextField) component;
            if(txtComp.getText().isEmpty()) {
                txtComp.setForeground(tipColor);//toogle color to tipColor
                txtComp.setText(tipText);
            }
        }else if(type == PW_FIELD) {
            JPasswordField pwComp = (JPasswordField) component;
            if(pwComp.getPassword().length == 0) {
                pwComp.setForeground(tipColor); //toogle color to tipColor
                pwComp.setText(tipText);
            }
        }
         
    }
    
}
