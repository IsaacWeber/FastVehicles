/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validadores;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 *
 * @author Isaac
 */
public class Validador {
    
    public static boolean nomeCerto(String nome) { //retorna true se o nome estiver correto (ex. isaac weber )
        nome = nome.toLowerCase(); //descapitaliza para poder verificar com menos complexidade - put it to lower to have a not so complex regex
        return nome.matches("^[a-záàâãéèêíïóôõöúçñ ]+$"
                + "|^[a-záàâãéèêíïóôõöúçñ ]+$([ '-]^[a-záàâãéèêíïóôõöúçñ ]+$)*");
    }
    
    public static boolean telefoneCerto(String tel) { //retorna true se telefone estiver certo (ex. 61999999999) 
        return tel.matches("((\\(\\d{2}\\))9?\\d{8}|\\d{2}9?\\d{8})" //6199999999 ou (61)999999999 619999999 (61)99999999
                + "|((\\(\\d{2}\\))9?\\d{4}-\\d{4}|\\d{2}9?\\d{4}-\\d{4})" //...
                + "|((\\(\\d{2}\\))9-?\\d{8}|\\d{2}9-?\\d{8})" //...
                + "|((\\(\\d{2}\\))9-?\\d{4}-\\d{4}|\\d{2}9-?\\d{4}-\\d{4})" //... tentei todas as possibilidades
        );

    }
   
    
    public static boolean cnhCerto(String cnh) { //retorna true se cnh correto
        return cnh.matches("\\d{11,12}");
    }
   
    public static boolean cpfCerto(String cpf) {
        return cpf.matches("\\d{9}-?\\d{2}");
    }
    
    public static boolean cnpjCerto(String cnpj) {
        return cnpj.matches("\\d{14,20}");
    }
    
    public static boolean rgCerto(String rg) {
        return rg.matches("\\d{1,15}");
    }
    
    public static boolean numeroCartaoCerto(String numero) {
        return numero.matches("\\d{13,19}");
    }
    
    public static boolean cvcCerto(String cvc) {
        return cvc.matches("\\d{3,4}");
    }
    public static boolean emailCerto(String email) {
        return email.matches("^(.+)@(.+)$");
    }
    
    public static boolean validadeCerta(String validade) {
        if(validade.matches("\\d{2}/(\\d{2}|\\d{4})")) {
            String[] valVect = validade.split("/");
            
            Calendar calendar = Calendar.getInstance();
            //concatena 20 se ano tem apenas 2 digitos - concat 20 if year has just 2 digs
            int ano = valVect[1].length() < 4 ? 
                Integer.parseInt("20"+valVect[1]) 
                :Integer.parseInt(valVect[1]); //app para ser usado até 2099, após isso, atualizar a validação - after 2099 update this validation
            int mes = Integer.parseInt(valVect[0]);
            
            
            if(ano > calendar.get(Calendar.YEAR) ) { //se ano >= ao atual - if month is >= the current month
                return true;
            }else if(ano == calendar.get(Calendar.YEAR)) { //se ano = o atual
                if(mes <= 12 && mes  
                    >= (calendar.get(Calendar.MONTH) + 1)) { //se o mes eh >= ao atual - if month >= the current month
                    return true;
                }
            }
        }
        return false;
    }
    
    public static boolean senhaMatches(char[] senha, char[] confSenha) { //se todos os chars match - if all chars matches 
        int counter = 0;
        
        if(senha.length == confSenha.length) {
            for(int i = 0; i < senha.length; ++i) {
                if(senha[i] == confSenha[i]) {
                    ++counter;
                }
            }
        }
        
        return counter == senha.length; 
    } 
    
    public static boolean dataCerta(String date) { //verifica se a data está correta  
        if(date.matches("\\d{2}/\\d{2}/\\d{4}")) {
            String[] dateVect = date.split("/");
            int dia = Integer.parseInt(dateVect[0]);
            int mes = Integer.parseInt(dateVect[1]);
            int ano = Integer.parseInt(dateVect[2]); //app para ser usado até 2099, após isso, atualizar a validação - after 2099 update this validation
           
            
            
            Calendar cal = Calendar.getInstance();
            
            //System.out.println("dia " + dia + "\nmes " + mes + "\nano " + ano + "\ndia do mes " + cal.get(Calendar.DAY_OF_MONTH));
            if(ano > cal.get(Calendar.YEAR)) {// se ano maior q o atual
                if(mes > 0 && mes <= 12) { //se mes maior q 0  e menor ou igual a 12
                    if(mes == 2) { //se mes eh 2
                        if(dia < 1 || dia > 29) { //dia menor q 1 ou maior q 29
                            return false;
                        }
                    }else { //se mes eh outro
                        if(dia < 1 || dia > 31) { //dia menor q 1 ou maior q 31
                            return false; //data invalida
                        }
                    }
                }else { //mes <= 0 ou mes > 12
                    return false;
                }
                
            }else if(ano == cal.get(Calendar.YEAR)) { //se ano eh o atual
                
                if(mes <= 12 && mes  
                    == (cal.get(Calendar.MONTH) + 1)) { //se o mes eh = ao atual - if month = the current month
                    if(mes == 2) { //se mes eh 2
                        if(dia <= cal.get(Calendar.DAY_OF_MONTH) || dia > 29) { //dia menor ou igual ao atual ou maior q 29
                            return false;
                        }
                    }else { //se mes eh outro
                        if(dia <= cal.get(Calendar.DAY_OF_MONTH) || dia > 31) { //dia menor ou igual ao atual ou maior q 31
                            return false; //data invalida
                        }
                    }
                }else if(mes <= 12 && mes  
                    > (cal.get(Calendar.MONTH) + 1)) { //se mes maior q o atual
                    
                    if(mes == 2) { //se mes eh 2
                        if(dia < 1 || dia > 29) { //dia menor q 1 ou maior q 29
                            return false;
                        }
                    }else { //se mes eh outro
                        if(dia < 1 || dia > 31) { //dia menor q 1 ou maior q 31
                            return false; //data invalida
                        }
                    }
                }else { //mes < q o atual ou maior q 12
                        
                    return false;
                }
            }else { //ano eh menor q o atual
                return false;
            }

            
        }else { //se a data n da match
            return false;
        } 
            
        
        return true; //se passou no teste
    }
    
    public static void test() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(new java.sql.Date(System.currentTimeMillis())));
    }
    
    public static void main(String[] args) {
        test();
//        System.out.println(dataCerta("29/02/2023"));
//        System.out.println(Calendar.getInstance().get(Calendar.MONTH));
    }
    
    
    
}
