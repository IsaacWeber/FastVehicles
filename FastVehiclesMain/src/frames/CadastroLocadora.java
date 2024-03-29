/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import dao.InstanceDao;
import dao.LocadoraDao;
import design.DesignApp;
import idioma.IdiomaApp;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import listener.TipNoFocus;
import modelos.Locadora;
import validadores.Validador;

/**
 *
 * @author Isaac
 */
public class CadastroLocadora extends javax.swing.JFrame
    implements FrameTheme, WindowListener, FrameLang  {
    
    private LocadoraDao locadoraDao = InstanceDao.LOCADORA_DAO;
    /**
     * Creates new form CadastroLocadora
     */
    public CadastroLocadora() {
        initComponents();
        extraConfigs();
        addWindowListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnGeral = new javax.swing.JPanel();
        pnCampos = new javax.swing.JPanel();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblTelefone = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblEndereco = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        lblCnpj = new javax.swing.JLabel();
        txtCnpj = new javax.swing.JTextField();
        lblSenha = new javax.swing.JLabel();
        pwSenha = new javax.swing.JPasswordField();
        lblConfSenha = new javax.swing.JLabel();
        pwConfSenha = new javax.swing.JPasswordField();
        btnCad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("FastVehicles | Cadastro Locadora");

        pnCampos.setToolTipText("");

        lblNome.setText("Nome");

        txtNome.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtNome.setToolTipText("Digite seu  nome");
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        lblTelefone.setText("Telefone");

        txtTelefone.setToolTipText("Digite seu telefone");
        txtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneActionPerformed(evt);
            }
        });

        lblEmail.setText("Email");

        txtEmail.setToolTipText("Digite seu e-mail");

        lblEndereco.setText("Endereço");

        txtEndereco.setToolTipText("Digite seu endereço");
        txtEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnderecoActionPerformed(evt);
            }
        });

        lblCnpj.setText("CNPJ");

        txtCnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCnpjActionPerformed(evt);
            }
        });

        lblSenha.setText("Senha");

        pwSenha.setToolTipText("Digite sua senha");

        lblConfSenha.setText("Confirmar Senha");

        pwConfSenha.setToolTipText("Digite novamente a sua senha");

        javax.swing.GroupLayout pnCamposLayout = new javax.swing.GroupLayout(pnCampos);
        pnCampos.setLayout(pnCamposLayout);
        pnCamposLayout.setHorizontalGroup(
            pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCamposLayout.createSequentialGroup()
                        .addComponent(lblConfSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pwConfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblCnpj)
                    .addGroup(pnCamposLayout.createSequentialGroup()
                        .addComponent(lblEndereco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pwSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblSenha)
                    .addGroup(pnCamposLayout.createSequentialGroup()
                        .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTelefone)
                            .addGroup(pnCamposLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(lblNome))
                            .addComponent(lblEmail))
                        .addGap(18, 18, 18)
                        .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        pnCamposLayout.setVerticalGroup(
            pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCamposLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEndereco)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCnpj)
                    .addComponent(txtCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCamposLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lblSenha))
                    .addGroup(pnCamposLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(pwSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConfSenha)
                    .addComponent(pwConfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnCad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/signup.png"))); // NOI18N
        btnCad.setText("Cadastrar");
        btnCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnGeralLayout = new javax.swing.GroupLayout(pnGeral);
        pnGeral.setLayout(pnGeralLayout);
        pnGeralLayout.setHorizontalGroup(
            pnGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGeralLayout.createSequentialGroup()
                .addGroup(pnGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnGeralLayout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(btnCad))
                    .addGroup(pnGeralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnGeralLayout.setVerticalGroup(
            pnGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGeralLayout.createSequentialGroup()
                .addComponent(pnCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnCad)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadActionPerformed
        if(!placeholderOrEmpty(txtCnpj) && Validador.cnpjCerto(txtCnpj.getText().trim())) {
            if(!locadoraJaCadastrada(txtCnpj.getText().trim())) {
                if(!placeholderOrEmpty(txtNome) && Validador.nomeCerto(txtNome.getText().trim())) { 
                    if(!placeholderOrEmpty(txtTelefone) && Validador.telefoneCerto(txtTelefone.getText().trim())) {
                        if(!placeholderOrEmpty(txtEndereco)) {
                            if(!placeholderOrEmpty(txtEmail) && Validador.emailCerto(txtEmail.getText().trim())) {
                                if(pwSenha.getForeground() == DesignApp.FIELD_FONT_COLOR
                                    && pwSenha.getPassword().length > 0) { //se a senha esta preenchida - if password is filled
                                    if(Validador.senhaMatches(pwSenha.getPassword(),
                                            pwConfSenha.getPassword())) { //se as senhas sao iguais - if keypasses are equals
                                        if(!emailExiste(txtEmail.getText().trim())) { //se email n existe no bd
                                                Locadora loc = new Locadora(
                                                    txtNome.getText().trim(), txtTelefone.getText().trim(), 
                                                    txtEmail.getText().trim(), txtEndereco.getText().trim(),
                                                    txtCnpj.getText().trim(),  String.valueOf(pwSenha.getPassword()));


                                                locadoraDao.save(loc);

                                                //mensagem de cadastro com sucesso - succes message
                                                URL url = getClass().getResource("/images/success.png");
                                                ImageIcon sucessIcon = new ImageIcon(url);
                                                
                                                    if(IdiomaApp.idiomaAtual == IdiomaApp.PORTUGUES) {
                                                        JOptionPane.showMessageDialog(this, "Locadora cadastrada com sucesso!", 
                                                            "Locadora cadastrada!", JOptionPane.PLAIN_MESSAGE, sucessIcon);

                                                    }else if(IdiomaApp.idiomaAtual == IdiomaApp.INGLES) {
                                                        JOptionPane.showMessageDialog(this, "Locator succesfully registered!", 
                                                            "Locador Registered!", JOptionPane.PLAIN_MESSAGE, sucessIcon);
                                                    }


                                                resetaCampos();//resta os dados - reset data
                                    
                                      }else {

                                        if(IdiomaApp.idiomaAtual == IdiomaApp.PORTUGUES) {
                                            JOptionPane.showMessageDialog(this, "Este e-mail já existe, cadastre um outro",
                                                "E-mail Não Disponível!", JOptionPane.ERROR_MESSAGE);
                                        }else if(IdiomaApp.idiomaAtual == IdiomaApp.INGLES) {
                                            JOptionPane.showMessageDialog(this, "This email already exist! Create another one",
                                               "Email alredy exist!", JOptionPane.ERROR_MESSAGE);
                                        }

                                      }  
                                        
                                    }else {
                                        
                                        if(IdiomaApp.idiomaAtual == IdiomaApp.PORTUGUES) {
                                            JOptionPane.showMessageDialog(this, 
                                                "A senha confirmada não é igual a senha informada."
                                                + "\nRefaça a confirmação, por favor.",
                                                "Senhas não são iguais!", JOptionPane.ERROR_MESSAGE);
                                        }else if(IdiomaApp.idiomaAtual == IdiomaApp.INGLES) {
                                            JOptionPane.showMessageDialog(this, 
                                                "The passwords don't match! Check it out.",
                                                "Passwords Don't match!", JOptionPane.ERROR_MESSAGE);
                                        }
                                        
                                    }
                                            
                                }else {
                                    
                                    if(IdiomaApp.idiomaAtual == IdiomaApp.PORTUGUES) {
                                        JOptionPane.showMessageDialog(this, "Preencha sua senha",
                                            "Senha Vazia!", JOptionPane.ERROR_MESSAGE);
                                    }else if(IdiomaApp.idiomaAtual == IdiomaApp.INGLES) {
                                        JOptionPane.showMessageDialog(this, "Fill out your password!",
                                            "Empty Password!", JOptionPane.ERROR_MESSAGE);
                                    }
                                    
                                }

                            }else {
                                
                                if(IdiomaApp.idiomaAtual == IdiomaApp.PORTUGUES) {
                                  JOptionPane.showMessageDialog(this, "Erro no e-mail da locadora:"
                                        + "\n- Verifique se o campo está vazio;"
                                        + "\n- Verifique se o e-mail está correto",
                                        "Erro no E-mail da Locadora", JOptionPane.ERROR_MESSAGE);  
                                }else if(IdiomaApp.idiomaAtual == IdiomaApp.INGLES) {
                                    JOptionPane.showMessageDialog(this, "Locator email error:"
                                        + "\n- Verify if email field is empty;"
                                        + "\n- Verify if email was filled out right.",
                                        "Locator Email Error", JOptionPane.ERROR_MESSAGE);
                                }
                                
  
                            }
                        
                        }else {
                            if(IdiomaApp.idiomaAtual == IdiomaApp.PORTUGUES) {
                                JOptionPane.showMessageDialog(this, "Preencha seu endereço",
                                    "Endereço Vazio!", JOptionPane.ERROR_MESSAGE);
                            }else if(IdiomaApp.idiomaAtual == IdiomaApp.INGLES) {
                                JOptionPane.showMessageDialog(this, "Fill out your address",
                                    "Empty Address!", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                      
                    }else {
                        
                        if(IdiomaApp.idiomaAtual == IdiomaApp.PORTUGUES) {
                            JOptionPane.showMessageDialog(this, "Erro no telefone da locadora:"
                                + "\n- Verifique se o campo está vazio;"
                                + "\n- Preencha o telefone com apenas números. Ex.: 61981828182",
                                "Erro no Telefone da locadora", JOptionPane.ERROR_MESSAGE);
                        }else if(IdiomaApp.idiomaAtual == IdiomaApp.INGLES) {
                            JOptionPane.showMessageDialog(this, "Locator phone error:"
                                + "\n- Verify if phone field is empty;"
                                + "\n- Fill out phone field with numbers only. Ex.: 61981828182",
                                "Locator Phone Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    
                }else {
                    if(IdiomaApp.idiomaAtual == IdiomaApp.PORTUGUES) {
                        JOptionPane.showMessageDialog(this, "Erro no nome da locadora:"
                            + "\n- Verifique se o campo está vazio;"
                            + "\n- O nome deve conter somente letras e espaços não duplicados;"
                            + "\n- Verifique se o nome possui espaços duplicados, deixe apenas um.",
                            "Erro no Nome da locadora", JOptionPane.ERROR_MESSAGE);
                    }else if(IdiomaApp.idiomaAtual == IdiomaApp.INGLES) {
                        JOptionPane.showMessageDialog(this, "Locator name error:"
                            + "\n- Verify if name field is empty;"
                            + "\n- Name field must have just letters and nonduplicated whitespaces."
                            + "\n- Verify if name field has whitespaces. Use just only one to split words.",
                            "Locator Name Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            
            }else {
                if(IdiomaApp.idiomaAtual == IdiomaApp.PORTUGUES) {
                    JOptionPane.showMessageDialog(this, "Locadora já cadastrado",
                        "Locadora Já Cadastrado", JOptionPane.ERROR_MESSAGE);
                }else if(IdiomaApp.idiomaAtual == IdiomaApp.INGLES) {
                    JOptionPane.showMessageDialog(this, "Locator already registered!",
                        "Locator already Registered", JOptionPane.ERROR_MESSAGE);
                }  
            }
 
        }else {
            if(IdiomaApp.idiomaAtual == IdiomaApp.PORTUGUES) {
                JOptionPane.showMessageDialog(this, "Erro no CNPJ da locadora:"
                        + "\n- Verifique se o campo está vazio;"
                        + "\n- Digite o CNPJ com apenas números"
                        + "\n- O CNPJ deve ter entre 14 e 20 dígitos",
                        "Erro no CNPJ da Locadora", JOptionPane.ERROR_MESSAGE);
            }else if(IdiomaApp.idiomaAtual == IdiomaApp.INGLES) {
                JOptionPane.showMessageDialog(this, "Locator CNPJ error"
                    + "\n- Verify if CNPJ field is empty"
                    + "\n- CNPJ must have only numbers"
                    + "\n- CNPJ must have 14 to 20 numbers",
                    "Locator CNPJ Error", JOptionPane.ERROR_MESSAGE);
            }


        }
    }//GEN-LAST:event_btnCadActionPerformed

    private void txtCnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCnpjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCnpjActionPerformed

    private void txtEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnderecoActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefoneActionPerformed

    private boolean locadoraJaCadastrada(String cnpj) {
        for(Locadora l: locadoraDao.getAll()) {
            if(l.getCnpj().equals(cnpj)) {
                return true;
            }
        }
        
        return false;
    }
    
    private void resetaCampos() {
        txtNome.setForeground(DesignApp.FIELD_FONT_TIP_COLOR);
        txtTelefone.setForeground(DesignApp.FIELD_FONT_TIP_COLOR);
        txtEmail.setForeground(DesignApp.FIELD_FONT_TIP_COLOR);
        txtEndereco.setForeground(DesignApp.FIELD_FONT_TIP_COLOR);
        txtCnpj.setForeground(DesignApp.FIELD_FONT_TIP_COLOR);
        pwSenha.setForeground(DesignApp.FIELD_FONT_TIP_COLOR);

        txtNome.setText("Ex.: Mario Ferreira");
        txtTelefone.setText("Ex.: (61)99090-9090");
        txtEmail.setText("Ex.: mail@mail.com");
        txtEndereco.setText("Ex.: RIACHO FUNDO 2, QN 0B CJ 00 LT 0");
        txtCnpj.setText("Ex.: 12341234123412");
        pwSenha.setText("Ex.: 22222222222");
        pwConfSenha.setText("");

    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroLocadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroLocadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroLocadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroLocadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroLocadora().setVisible(true);
            }
        });
    }

    
    public void extraConfigs() {
        setLocationRelativeTo(null); //configs do frame - frames config
        //coloca icone no jframe - insert icon on jframe
        URL url = getClass().getResource("/images/car-default-img.png");
        if(!(url == null)) {
            setIconImage(new ImageIcon(url).getImage());
        }
        
        //modificacoes gerais - general changes
        lblNome.setFont(DesignApp.fonteGeral);
        lblTelefone.setFont(DesignApp.fonteGeral);
        lblEmail.setFont(DesignApp.fonteGeral);
        lblEndereco.setFont(DesignApp.fonteGeral);
        lblCnpj.setFont(DesignApp.fonteGeral);
        lblSenha.setFont(DesignApp.fonteGeral);
        lblConfSenha.setFont(DesignApp.fonteGeral);
        btnCad.setFont(DesignApp.fonteGeral);

        txtNome.setFont(DesignApp.fonteGeral);
        txtNome.addFocusListener(new TipNoFocus(txtNome, "Ex.: Mario Ferreira",
                DesignApp.FIELD_FONT_COLOR,
                DesignApp.FIELD_FONT_TIP_COLOR, 0));
        
        txtTelefone.setFont(DesignApp.fonteGeral);
        txtTelefone.addFocusListener(new TipNoFocus(txtTelefone,
                "Ex.: (61)99090-9090", 
                DesignApp.FIELD_FONT_COLOR,
                DesignApp.FIELD_FONT_TIP_COLOR,0));
        txtEmail.setFont(DesignApp.fonteGeral);
        txtEmail.addFocusListener(new TipNoFocus(txtEmail, 
                "Ex.: mail@mail.com",
                DesignApp.FIELD_FONT_COLOR,
                DesignApp.FIELD_FONT_TIP_COLOR, 0));
        txtEndereco.setFont(DesignApp.fonteGeral);
        txtEndereco.addFocusListener(new TipNoFocus(txtEndereco, 
                "Ex.: RIACHO FUNDO 2, QN 0B CJ 00 LT 0",
                DesignApp.FIELD_FONT_COLOR,
                DesignApp.FIELD_FONT_TIP_COLOR,0));
        txtCnpj.setFont(DesignApp.fonteGeral);
        txtCnpj.addFocusListener(new TipNoFocus(txtCnpj, 
                "Ex.: 12341234123412", 
                DesignApp.FIELD_FONT_COLOR,
                DesignApp.FIELD_FONT_TIP_COLOR, 0));
        pwSenha.setFont(DesignApp.fonteGeral);
        pwSenha.addFocusListener(new TipNoFocus(pwSenha, 
                "Ex.: 22222222222", 
                DesignApp.FIELD_FONT_COLOR,
                DesignApp.FIELD_FONT_TIP_COLOR, 1));
        pwConfSenha.setFont(DesignApp.fonteGeral);
        
          //update lang
        if(IdiomaApp.idiomaAtual == IdiomaApp.INGLES) {
            updateLangComponents();
        }
        
    }
    
    public boolean emailExiste(String email) { //verifica se email nao existe no bd - verify if there is no this email inside db
        
        for(Locadora l: locadoraDao.getAll()) {
            if(l.getEmail().equals(email)) { //se email = a algum existente
                return true;
            }
        }
        
        return false; //se email n existe
    }
    
    public boolean placeholderOrEmpty(JTextField comp) { //verifica se campo tem texto de exemplo padrao
        return comp.getForeground() == DesignApp.FIELD_FONT_TIP_COLOR
            || comp.getText().trim().isEmpty();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCad;
    private javax.swing.JLabel lblCnpj;
    private javax.swing.JLabel lblConfSenha;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JPanel pnCampos;
    private javax.swing.JPanel pnGeral;
    private javax.swing.JPasswordField pwConfSenha;
    private javax.swing.JPasswordField pwSenha;
    private javax.swing.JTextField txtCnpj;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables

    @Override
    public void resetaListenerCampos() {
        txtNome.setForeground(DesignApp.FIELD_FONT_TIP_COLOR);
        txtTelefone.setForeground(DesignApp.FIELD_FONT_TIP_COLOR);
        txtEmail.setForeground(DesignApp.FIELD_FONT_TIP_COLOR);
        txtEndereco.setForeground(DesignApp.FIELD_FONT_TIP_COLOR);
        txtCnpj.setForeground(DesignApp.FIELD_FONT_TIP_COLOR);
        pwSenha.setForeground(DesignApp.FIELD_FONT_TIP_COLOR);    
    
        for(FocusListener focus: txtNome.getFocusListeners()) { //percorre listeneers
            txtNome.removeFocusListener(focus);//remove focus listeners
        }


      for(FocusListener focus: txtTelefone.getFocusListeners()) { //percorre listeneers
            txtTelefone.removeFocusListener(focus);//remove focus listeners
        }
        
        for(FocusListener focus: txtEmail.getFocusListeners()) { //percorre listeneers
            txtEmail.removeFocusListener(focus);//remove focus listeners
        }
        
        for(FocusListener focus: txtEndereco.getFocusListeners()) { //percorre listeneers
            txtEndereco.removeFocusListener(focus);//remove focus listeners
        }
        
        for(FocusListener focus: txtCnpj.getFocusListeners()) { //percorre listeneers
            txtCnpj.removeFocusListener(focus);//remove focus listeners
        }
        
        for(FocusListener focus: pwSenha.getFocusListeners()) { //percorre listeneers
            pwSenha.removeFocusListener(focus);//remove focus listeners
        }
        
        txtNome.addFocusListener(new TipNoFocus(txtNome, "Ex.: Mario Ferreira",
                DesignApp.FIELD_FONT_COLOR,
                DesignApp.FIELD_FONT_TIP_COLOR, 0));
        
        txtTelefone.addFocusListener(new TipNoFocus(txtTelefone,
                "Ex.: (61)99090-9090", 
                DesignApp.FIELD_FONT_COLOR,
                DesignApp.FIELD_FONT_TIP_COLOR,0));

        txtEmail.addFocusListener(new TipNoFocus(txtEmail, 
                "Ex.: mail@mail.com",
                DesignApp.FIELD_FONT_COLOR,
                DesignApp.FIELD_FONT_TIP_COLOR, 0));

        txtEndereco.addFocusListener(new TipNoFocus(txtEndereco, 
                "Ex.: RIACHO FUNDO 2, QN 0B CJ 00 LT 0",
                DesignApp.FIELD_FONT_COLOR,
                DesignApp.FIELD_FONT_TIP_COLOR,0));

        txtCnpj.addFocusListener(new TipNoFocus(txtCnpj, 
                "Ex.: 12341234123412", 
                DesignApp.FIELD_FONT_COLOR,
                DesignApp.FIELD_FONT_TIP_COLOR, 0));

        pwSenha.addFocusListener(new TipNoFocus(pwSenha, 
                "Ex.: 22222222222", 
                DesignApp.FIELD_FONT_COLOR,
                DesignApp.FIELD_FONT_TIP_COLOR, 1));
        
    }
    
    
     //window listener
    @Override
    public void windowOpened(WindowEvent e) {
        InstanceFrame.addFrame(this); //adiciona frame na lista de frames abertos
    }

    @Override
    public void windowClosing(WindowEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowClosed(WindowEvent e) {
        InstanceFrame.removeFrame(this); //remove frame
    }

    @Override
    public void windowIconified(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowActivated(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
        //update lang method
    @Override
    public void updateLangComponents() {
        if(IdiomaApp.idiomaAtual == IdiomaApp.INGLES) { //se idioma eh ingles
	    setTitle("FastVehicles | Locator Registering");
            lblNome.setText("Name");
            lblTelefone.setText("Phone");
            lblEndereco.setText("Address");
            lblSenha.setText("Password");
            lblConfSenha.setText("Repeat password");
            btnCad.setText("Add");
            
            //tool tips - dicas caixa de diálogo
            txtNome.setToolTipText("Type your name");
            txtTelefone.setToolTipText("Type your phone");
            txtEmail.setToolTipText("Type your e-mail");
            txtEndereco.setToolTipText("Type your address");
            txtCnpj.setToolTipText("Type your CNPJ");
            pwSenha.setToolTipText("Type your password");
            pwConfSenha.setToolTipText("Type your password again");
            btnCad.setToolTipText("Press to sign up a new locator");
        
	}else if(IdiomaApp.idiomaAtual == IdiomaApp.PORTUGUES) { //se for portugues
            setTitle("FastVehicles | Cadastro Cliente");
            lblNome.setText("Nome");
            lblTelefone.setText("Telefone");
            lblEndereco.setText("Endereço");
            lblSenha.setText("Senha");
            lblConfSenha.setText("Confirmar Senha");
            btnCad.setText("Cadastrar");
            
            //tool tips - dicas caixa de diálogo
            txtNome.setToolTipText("Digite seu nome");
            txtTelefone.setToolTipText("Digite seu telefone");
            txtEmail.setToolTipText("Digite seu e-mail");
            txtEndereco.setToolTipText("Digite seu endereço");
            txtCnpj.setToolTipText("Digite seu CNPJ");
            pwSenha.setToolTipText("Digite sua senha");
            pwConfSenha.setToolTipText("Digite novamente a sua senha");
            btnCad.setToolTipText("Clique para cadastrar uma nova locadora");
	}
    }
}
