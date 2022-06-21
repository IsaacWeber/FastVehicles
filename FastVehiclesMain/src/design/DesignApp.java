/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package design;

import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author Isaac
 */
public class DesignApp {
    
    //fontes
    public static final Font fonteTitulo = new Font(Font.DIALOG, Font.BOLD, 25);
    public static final Font fonteGeral = new Font(Font.DIALOG, Font.PLAIN, 15);
    public static final Font fonteGeralPequena = new Font(Font.DIALOG, Font.PLAIN, 13);
    public static final Font fonteCumprimento = new Font(Font.DIALOG, Font.BOLD, 33);
    public static final Font fonteDescricao = new Font(Font.DIALOG, Font.PLAIN, 20);
    public static final Font fonteTabela = new Font(Font.DIALOG, Font.PLAIN, 13);
    
    
    //cores
    public static Color FIELD_FONT_COLOR = Color.BLACK; //(branco-white)pode ser alterada quand mudar tema - not final cuz it can be changed by theme
    public static Color FIELD_FONT_TIP_COLOR = Color.GRAY; //cor de fonte para dica
    
    //tema 
    public static String temaAtual = "light"; //tema light padrao inicial
    
}
