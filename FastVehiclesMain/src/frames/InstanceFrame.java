/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import design.DesignApp;
import idioma.IdiomaApp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Isaac
 */
public class InstanceFrame {
    
    private static final List<JFrame> frameList = 
            new ArrayList<>(20);
    
    public static void addFrame(JFrame frame) { //add na lista se n existir
        if(!frameList.contains(frame)) {
            frameList.add(frame);
        }     
    }
    
    public static void removeFrame(JFrame frame) { //remove da lista se existir
        if(frameList.contains(frame)) {
            frameList.remove(frame);
        }
    }
    
    public static void updateAllFrames() { //atualiza os componentes de todos os frames abertos
        for(JFrame f: frameList) { //percorre frames abertos
            SwingUtilities.updateComponentTreeUI(f); //atualiza tela especificada
            
            ((FrameTheme)f).resetaListenerCampos(); //reseta todos os campos 
            
            if(f instanceof FrameMenuTheme) { 
                FrameMenuTheme fmt = ((FrameMenuTheme)f);  
            
                //toogle menu
                if(DesignApp.temaAtual.equals("light")) { //coloca light como selecionado
                    fmt.getMniLight().setSelected(true); 
                    fmt.getMniDark().setSelected(false);
                }else { //coloca dark
                    fmt.getMniLight().setSelected(false);
                    fmt.getMniDark().setSelected(true);
                }
            }


        }         
    }
    
    public static void updateAllFramesLang() { //chama metodo de atualizacao de linguagem de todos os frames e atualiza menus 
        for(JFrame f: frameList) { //percorre frames abertos
     
            ((FrameLang)f).updateLangComponents();//reseta todos os campos 
            
            if(f instanceof FrameMenuLang) { 
                FrameMenuLang fml = ((FrameMenuLang)f);  
           
                //toggle menu
                if(IdiomaApp.idiomaAtual == IdiomaApp.INGLES) { //coloca ingles - set en
                    fml.getMniIngles().setSelected(true); 
                    fml.getMniPortugues().setSelected(false);
                }else if(IdiomaApp.idiomaAtual == IdiomaApp.PORTUGUES) { //coloca pt - set pt
                    fml.getMniIngles().setSelected(false);
                    fml.getMniPortugues().setSelected(true);
                }
            }


        }       
    }
    
}
