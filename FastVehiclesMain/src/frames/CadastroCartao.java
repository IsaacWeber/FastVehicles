/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import dao.CartaoDao;
import design.DesignApp;
import idioma.IdiomaApp;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import listener.TipNoFocus;
import modelos.Cartao;
import modelos.Cliente;
import validadores.Validador;

/**
 *
 * @author Isaac
 */
public class CadastroCartao extends javax.swing.JFrame
    implements FrameTheme, WindowListener, FrameLang {
    
    private ButtonGroup radioGroup;
    private CartaoDao cartaoDao;
    private Cliente clienteAtual;
    private ClienteCartoes clienteCartoes;
    /**
     * Creates new form CadastroCartao
     */
    public CadastroCartao() {
        initComponents();
       // extraConfigs();
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
        lblTitulo = new javax.swing.JLabel();
        pnDados = new javax.swing.JPanel();
        lblNumero = new javax.swing.JLabel();
        lblBanco = new javax.swing.JLabel();
        lblValidade = new javax.swing.JLabel();
        lblCvc = new javax.swing.JLabel();
        lblFuncao = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        txtBanco = new javax.swing.JTextField();
        txtValidade = new javax.swing.JTextField();
        txtCvc = new javax.swing.JTextField();
        lblBandeira = new javax.swing.JLabel();
        txtBandeira = new javax.swing.JTextField();
        rdCredito = new javax.swing.JRadioButton();
        rdDebito = new javax.swing.JRadioButton();
        lblNomeTitular = new javax.swing.JLabel();
        txtNomeTitular = new javax.swing.JTextField();
        btnCad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("FastVehicles | Cadastro de Cartão");

        lblTitulo.setText("Novo cartão");

        lblNumero.setText("Número");

        lblBanco.setText("Banco");

        lblValidade.setText("Validade");

        lblCvc.setText("CVC");

        lblFuncao.setText("Função");

        txtNumero.setToolTipText("Digite o número do cartão");

        txtBanco.setToolTipText("Digite o nome do banco");

        txtValidade.setToolTipText("Digite a validade ( somente mês e ano )");

        txtCvc.setToolTipText("Digite o CVC do cartão");

        lblBandeira.setText("Bandeira");

        txtBandeira.setToolTipText("Digite a bandeira do cartão");

        rdCredito.setText("Crédito");
        rdCredito.setToolTipText("");

        rdDebito.setText("Débito");

        lblNomeTitular.setText("Nome Titular");

        txtNomeTitular.setToolTipText("Digite o nome do titular da mesma forma que está no cartão");

        javax.swing.GroupLayout pnDadosLayout = new javax.swing.GroupLayout(pnDados);
        pnDados.setLayout(pnDadosLayout);
        pnDadosLayout.setHorizontalGroup(
            pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDadosLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDadosLayout.createSequentialGroup()
                        .addComponent(lblNomeTitular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNomeTitular, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnDadosLayout.createSequentialGroup()
                        .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblBandeira)
                            .addComponent(lblNumero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblBanco, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblCvc)
                                .addComponent(lblValidade))
                            .addComponent(lblFuncao, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtBanco, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                                .addComponent(txtNumero)
                                .addComponent(txtCvc, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtValidade, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtBandeira, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnDadosLayout.createSequentialGroup()
                                .addComponent(rdCredito)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdDebito)))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        pnDadosLayout.setVerticalGroup(
            pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDadosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNumero))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeTitular)
                    .addComponent(txtNomeTitular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBanco)
                    .addComponent(txtBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCvc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCvc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFuncao)
                    .addComponent(rdCredito)
                    .addComponent(rdDebito))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBandeira)
                    .addComponent(txtBandeira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        btnCad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/signup.png"))); // NOI18N
        btnCad.setText("Adicionar");
        btnCad.setToolTipText("Adicione o cartão");
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
                        .addGap(128, 128, 128)
                        .addComponent(lblTitulo))
                    .addGroup(pnGeralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnGeralLayout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(btnCad)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        pnGeralLayout.setVerticalGroup(
            pnGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(btnCad)
                .addContainerGap(29, Short.MAX_VALUE))
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
    
    private boolean cartaoJaCadatrado(long num) { //se o cartao ja estiver cadastrado - if card is already stored
//        System.out.println(cliente.getCartoes());
        for(Cartao c: clienteAtual.getCartoes()) {
            if(Long.parseLong(c.getNumero()) == num ){
                return true;
            } 
        }
        
        return false;
    }
    
    private void resetaCampos() {
        txtNumero.setForeground(DesignApp.FIELD_FONT_TIP_COLOR);
        txtBanco.setForeground(DesignApp.FIELD_FONT_TIP_COLOR);
        txtNomeTitular.setForeground(DesignApp.FIELD_FONT_TIP_COLOR);
        txtValidade.setForeground(DesignApp.FIELD_FONT_TIP_COLOR);
        txtCvc.setForeground(DesignApp.FIELD_FONT_TIP_COLOR);
        txtBandeira.setForeground(DesignApp.FIELD_FONT_TIP_COLOR);
        
        txtNumero.setText("Ex.: 1234123412341234");
        txtBanco.setText("Ex.: Banco do Brasil");
        txtNomeTitular.setText("Ex.: MARIO F PEREIRA");
        txtValidade.setText("Ex.: 02/27");
        txtCvc.setText("Ex.: 123");
        txtBandeira.setText("Ex.: Master Card");
        
    }
    
    
    private void btnCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadActionPerformed
        //validar os dados para poder salvar o cartao
        if(!placeholderOrEmpty(txtNumero) && Validador.numeroCartaoCerto(txtNumero.getText().trim())) {
            if(!cartaoJaCadatrado(Long.parseLong(txtNumero.getText().trim()))) { 
                if(!placeholderOrEmpty(txtNomeTitular) && Validador.nomeCerto(txtNomeTitular.getText().trim())) {
                    if(!placeholderOrEmpty(txtBanco) && Validador.nomeCerto(txtBanco.getText().trim())) {
                        if(!placeholderOrEmpty(txtValidade) && Validador.validadeCerta(txtValidade.getText().trim())) {
                            if(!placeholderOrEmpty(txtCvc) && Validador.cvcCerto(txtCvc.getText().trim())) {
                                if(!placeholderOrEmpty(txtBandeira) && Validador.nomeCerto(txtBandeira.getText().trim())) {
                                    String funcao = rdCredito.isSelected() ? 
                                            rdCredito.getText(): rdDebito.getText(); //pega a funcao dependendo de quem esta selecionado - get the function by the selected card

                                    
                                    Cartao cartao = new Cartao(txtNumero.getText().trim(),
                                        txtNomeTitular.getText().trim(), txtBanco.getText().trim(),
                                        txtValidade.getText().trim(), Integer.parseInt(txtCvc.getText().trim()),
                                        funcao, txtBandeira.getText().trim(), clienteAtual); //cria cartao - create card

                                    cartaoDao.save(cartao); //salva cartao no bd - save card on db
                                    //clienteAtual.getCartoes().add(cartao); //adiciona cartao aa lista de cartoes do cliente para salvar no bd depois - add cards in the client card list
                                    
                                    clienteCartoes.updateTbl(); //atualiza tabela de cartoes
                                    //MOSTRA MSG SUCESSO - display sucess msg
                                    URL url = getClass().getResource("/images/success.png");
                                    ImageIcon sucessIcon = new ImageIcon(url);
                                       
                                    if(IdiomaApp.idiomaAtual == IdiomaApp.PORTUGUES) {
                                        JOptionPane.showMessageDialog(this, "Cartão cadastrado com sucesso!", 
                                            "Cartão cadastrado!", JOptionPane.PLAIN_MESSAGE, sucessIcon);
                                    
                                    }else if(IdiomaApp.idiomaAtual == IdiomaApp.INGLES) {
                                        JOptionPane.showMessageDialog(this, "Card successfully registered!", 
                                            "Card Registered!", JOptionPane.PLAIN_MESSAGE, sucessIcon);

                                    }
                      
                                    resetaCampos(); //RESETA
                                }else {
                                    
                                    if(IdiomaApp.idiomaAtual == IdiomaApp.PORTUGUES) {
                                        JOptionPane.showMessageDialog(this, "Erro na bandeira do cartão:"
                                            + "\n- Verifique se o campo está vazio;"
                                            + "\n- O nome deve apenas ter letras.",
                                            "Erro na Bandeira do Cartão", JOptionPane.ERROR_MESSAGE);
                                    }else if(IdiomaApp.idiomaAtual == IdiomaApp.INGLES) {
                                        JOptionPane.showMessageDialog(this, "Card flag error:"
                                            + "\n- Verify if flag field is empty;"
                                            + "\n- Flag must have letters only.",
                                            "Card Flag Error", JOptionPane.ERROR_MESSAGE);
                                    }

                                }
                            }else {
                                
                                if(IdiomaApp.idiomaAtual == IdiomaApp.PORTUGUES) {
                                    JOptionPane.showMessageDialog(this, "Erro no CVC do cartão:"
                                            + "\n- Verifique se o campo está vazio;"
                                            + "\n- Verifique se o número está correto;"
                                            + "\n- O número deve ter 3 ou 4 dígitos.",
                                        "Erro no CVC do Cartão", JOptionPane.ERROR_MESSAGE);
                                }else if(IdiomaApp.idiomaAtual == IdiomaApp.INGLES) {
                                    JOptionPane.showMessageDialog(this, "CVC card error:"
                                        + "\n- Verify if CVC field is empty;"
                                        + "\n- Verify if CVC number is right;"
                                        + "\n- CVC number must have 3 or 4 numbers only.",
                                        "CVC Card Error", JOptionPane.ERROR_MESSAGE);
                                }

                            }
                        }else {
                            
                            if(IdiomaApp.idiomaAtual == IdiomaApp.PORTUGUES) {
                                JOptionPane.showMessageDialog(this, "Erro na validade do cartão:"
                                    + "\n- Verifique se o campo está vazio;"
                                    + "\n- Verifique o mês e o ano;"
                                    + "\n- A validade deve ter seguir o formato mm/aa ou mm/aaaa, ex.: 02/27 ou 02/2027;"
                                    + "\n- Veja se digitou com dois dígitos para o mês;"
                                    + "\n- Veja se seu cartão está vencido.",
                                    "Erro na Validade do Cartão", JOptionPane.ERROR_MESSAGE);
                            }else if(IdiomaApp.idiomaAtual == IdiomaApp.INGLES) {
                                JOptionPane.showMessageDialog(this, "Expiry date error:"
                                    + "\n- Verify if expiry date field is empty;"
                                    + "\n- Verify month and year;"
                                    + "\n- Expiry date must have the pattern mm/yy or mm/yyyy, like: 02/27 or 02/2027;"
                                    + "\n- Verify if you type 2 numbers for month;"
                                    + "\n- Verify if card is expired.",
                                    "Expiry Date Error", JOptionPane.ERROR_MESSAGE);
                            }

                        }
                    }else {
                        
                        if(IdiomaApp.idiomaAtual == IdiomaApp.PORTUGUES) {
                            JOptionPane.showMessageDialog(this, "Erro no nome do banco:"
                            + "\n- Verifique se o campo está vazio;"
                            + "\n- O nome deve apenas ter letras.",
                            "Erro no Nome do Banco", JOptionPane.ERROR_MESSAGE);
                        }else if(IdiomaApp.idiomaAtual == IdiomaApp.INGLES) {
                            JOptionPane.showMessageDialog(this, "Bank name error:"
                            + "\n- Verify if bank field is empty;"
                            + "\n- Bank field must have letters only.",
                            "Bank Name Error", JOptionPane.ERROR_MESSAGE);
                        }

                    }
                }else {
                    
                    if(IdiomaApp.idiomaAtual == IdiomaApp.PORTUGUES) {
                        JOptionPane.showMessageDialog(this, "Erro no nome do titular:"
                            + "\n- Verifique se o campo está vazio;"
                            + "\n- O nome deve conter somente letras e espaços não duplicados;"
                            + "\n- Verifique se o nome possui espaços duplicados, deixe apenas um por palavra.",
                            "Erro no Nome do Titular", JOptionPane.ERROR_MESSAGE);
                    }else if(IdiomaApp.idiomaAtual == IdiomaApp.INGLES) {
                        JOptionPane.showMessageDialog(this, "User name error:"
                            + "\n- Verify if user name field is empty;"
                            + "\n- User name field must have just letters and nonduplicated whitespaces;"
                            + "\n- Verify if user name field has duplicated whitespaces, use only one per word.",
                            "User Name Error", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }else {
                if(IdiomaApp.idiomaAtual == IdiomaApp.PORTUGUES) {
                    JOptionPane.showMessageDialog(this, "Cartão já cadastrado!",
                        "Cartão Já Cadastrado", JOptionPane.ERROR_MESSAGE);
                }else if(IdiomaApp.idiomaAtual == IdiomaApp.INGLES) {
                    JOptionPane.showMessageDialog(this, "Card alredy registered!",
                        "Card Already Registered", JOptionPane.ERROR_MESSAGE);
                }

            }
        }else {
            
            if(IdiomaApp.idiomaAtual == IdiomaApp.PORTUGUES) {
                JOptionPane.showMessageDialog(this, "Erro no número do cartão:"
                    + "\n- Verifique se o campo está vazio;"
                    + "\n- Verifique se o número está correto;"
                    + "\n- O número deve ter 13 ou 15 dígitos.",
                    "Erro no Numero do Cartão", JOptionPane.ERROR_MESSAGE);
            }else if(IdiomaApp.idiomaAtual == IdiomaApp.INGLES) {
                JOptionPane.showMessageDialog(this, "Card number error:"
                    + "\n- Verify if number field is empty;"
                    + "\n- Verify if number is right;"
                    + "\n- Number must have 13 or 15 characters.",
                    "Card Number Error", JOptionPane.ERROR_MESSAGE);
            }

        }
            
        
    }//GEN-LAST:event_btnCadActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroCartao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroCartao().setVisible(true);
            }
        });
    }
    
    public void extraConfigs() {
        //configs do frame - frames config
        setLocationRelativeTo(null);
        //coloca icone no jframe - insert icon on jframe
        URL url = getClass().getResource("/images/car-default-img.png");
        if(!(url == null)) {
            setIconImage(new ImageIcon(url).getImage());
        }
        
        //configuracoes gerais - general configs
        lblTitulo.setFont(DesignApp.fonteTitulo);
        lblNumero.setFont(DesignApp.fonteGeral);
        lblBanco.setFont(DesignApp.fonteGeral);
        lblValidade.setFont(DesignApp.fonteGeral);
        lblCvc.setFont(DesignApp.fonteGeral);
        lblFuncao.setFont(DesignApp.fonteGeral);
        lblBandeira.setFont(DesignApp.fonteGeral);
        lblNomeTitular.setFont(DesignApp.fonteGeral);

        
        cartaoDao = new CartaoDao();
        txtNumero.setFont(DesignApp.fonteGeral);
        txtBanco.setFont(DesignApp.fonteGeral);
        txtValidade.setFont(DesignApp.fonteGeral);
        txtCvc.setFont(DesignApp.fonteGeral);
        txtBandeira.setFont(DesignApp.fonteGeral);
        txtNomeTitular.setFont(DesignApp.fonteGeral);
        rdCredito.setFont(DesignApp.fonteGeral);
        rdCredito.setSelected(true);
        rdDebito.setFont(DesignApp.fonteGeral);
        btnCad.setFont(DesignApp.fonteGeral);
        
        radioGroup = new ButtonGroup();
        radioGroup.add(rdCredito);
        radioGroup.add(rdDebito);
        
        
        txtNumero.addFocusListener(new TipNoFocus(
                txtNumero,"Ex.: 1234123412341234",
                DesignApp.FIELD_FONT_COLOR,
                DesignApp.FIELD_FONT_TIP_COLOR, 0));
        txtBanco.addFocusListener(new TipNoFocus(
                txtBanco,"Ex.: Banco do Brasil",
                DesignApp.FIELD_FONT_COLOR,
                DesignApp.FIELD_FONT_TIP_COLOR, 0));
        txtValidade.addFocusListener(new TipNoFocus(
                txtValidade,"Ex.: 02/27", 
                DesignApp.FIELD_FONT_COLOR,
                DesignApp.FIELD_FONT_TIP_COLOR, 0));
        txtCvc.addFocusListener(new TipNoFocus(
                txtCvc,"Ex.: 123", 
                DesignApp.FIELD_FONT_COLOR,
                DesignApp.FIELD_FONT_TIP_COLOR, 0));
        txtBandeira.addFocusListener(new TipNoFocus(
            txtBandeira,"Ex.: Master Card",
                DesignApp.FIELD_FONT_COLOR,
                DesignApp.FIELD_FONT_TIP_COLOR, 0));
        txtNomeTitular.addFocusListener(new TipNoFocus(
            txtNomeTitular,"Ex.: MARIO F PEREIRA", 
                DesignApp.FIELD_FONT_COLOR,
                DesignApp.FIELD_FONT_TIP_COLOR, 0));
        
          //update lang
        if(IdiomaApp.idiomaAtual == IdiomaApp.INGLES) {
            updateLangComponents();
        }

        

    }
    
    public void addCliente(Cliente c) {
        this.clienteAtual = c;
        extraConfigs();
    }
    
    public void addClienteCartoes(ClienteCartoes cc) {
        this.clienteCartoes = cc;
    }

    public boolean placeholderOrEmpty(JTextField comp) { //verifica se campo tem texto de exemplo padrao
        return comp.getForeground() == DesignApp.FIELD_FONT_TIP_COLOR
            || comp.getText().trim().isEmpty();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCad;
    private javax.swing.JLabel lblBanco;
    private javax.swing.JLabel lblBandeira;
    private javax.swing.JLabel lblCvc;
    private javax.swing.JLabel lblFuncao;
    private javax.swing.JLabel lblNomeTitular;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValidade;
    private javax.swing.JPanel pnDados;
    private javax.swing.JPanel pnGeral;
    private javax.swing.JRadioButton rdCredito;
    private javax.swing.JRadioButton rdDebito;
    private javax.swing.JTextField txtBanco;
    private javax.swing.JTextField txtBandeira;
    private javax.swing.JTextField txtCvc;
    private javax.swing.JTextField txtNomeTitular;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtValidade;
    // End of variables declaration//GEN-END:variables

    @Override
    public void resetaListenerCampos() {
        txtNumero.setForeground(DesignApp.FIELD_FONT_TIP_COLOR);
        txtBanco.setForeground(DesignApp.FIELD_FONT_TIP_COLOR);
        txtNomeTitular.setForeground(DesignApp.FIELD_FONT_TIP_COLOR);
        txtValidade.setForeground(DesignApp.FIELD_FONT_TIP_COLOR);
        txtCvc.setForeground(DesignApp.FIELD_FONT_TIP_COLOR);
        txtBandeira.setForeground(DesignApp.FIELD_FONT_TIP_COLOR);
        
        for(FocusListener focus: txtNumero.getFocusListeners()) { //percorre listeneers
            txtNumero.removeFocusListener(focus);//remove focus listeners
        }
        
        for(FocusListener focus: txtBanco.getFocusListeners()) { //percorre listeneers
            txtBanco.removeFocusListener(focus);//remove focus listeners
        }
        
        for(FocusListener focus: txtNomeTitular.getFocusListeners()) { //percorre listeneers
            txtNomeTitular.removeFocusListener(focus);//remove focus listeners
        }
        
        for(FocusListener focus: txtValidade.getFocusListeners()) { //percorre listeneers
            txtValidade.removeFocusListener(focus);//remove focus listeners
        }
        
        for(FocusListener focus: txtCvc.getFocusListeners()) { //percorre listeneers
            txtCvc.removeFocusListener(focus);//remove focus listeners
        }
        
        for(FocusListener focus: txtBandeira.getFocusListeners()) { //percorre listeneers
            txtBandeira.removeFocusListener(focus);//remove focus listeners
        }
        
         txtNumero.addFocusListener(new TipNoFocus(
                txtNumero,"Ex.: 1234123412341234",
                DesignApp.FIELD_FONT_COLOR,
                DesignApp.FIELD_FONT_TIP_COLOR, 0));
        txtBanco.addFocusListener(new TipNoFocus(
                txtBanco,"Ex.: Banco do Brasil",
                DesignApp.FIELD_FONT_COLOR,
                DesignApp.FIELD_FONT_TIP_COLOR, 0));
        txtValidade.addFocusListener(new TipNoFocus(
                txtValidade,"Ex.: 02/27", 
                DesignApp.FIELD_FONT_COLOR,
                DesignApp.FIELD_FONT_TIP_COLOR, 0));
        txtCvc.addFocusListener(new TipNoFocus(
                txtCvc,"Ex.: 123", 
                DesignApp.FIELD_FONT_COLOR,
                DesignApp.FIELD_FONT_TIP_COLOR, 0));
        txtBandeira.addFocusListener(new TipNoFocus(
            txtBandeira,"Ex.: Master Card",
                DesignApp.FIELD_FONT_COLOR,
                DesignApp.FIELD_FONT_TIP_COLOR, 0));
        txtNomeTitular.addFocusListener(new TipNoFocus(
            txtNomeTitular,"Ex.: MARIO F PEREIRA", 
                DesignApp.FIELD_FONT_COLOR,
                DesignApp.FIELD_FONT_TIP_COLOR, 0));
           
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
            setTitle("FastVehicles | Card Registering");
            lblTitulo.setText("New Card");
            lblNumero.setText("Number");
            lblNomeTitular.setText("User Name");
            lblBanco.setText("Bank");
            lblValidade.setText("Expiry date");
            lblFuncao.setText("Function");
            lblBandeira.setText("Flag");
            rdCredito.setText("Credit");
            rdDebito.setText("Debit");
            btnCad.setText("Add");
            
            txtNumero.setToolTipText("Type card number");
            txtNomeTitular.setToolTipText("Type card user name "
                    + "as it is writed on card");
            txtBanco.setToolTipText("Type bank name");
            txtValidade.setToolTipText("Type card expiry date"
                    + " ( just month and year )");
            txtCvc.setToolTipText("Type card CVC");
            txtBandeira.setToolTipText("Type card flag");
            btnCad.setToolTipText("Add card");

	}else if(IdiomaApp.idiomaAtual == IdiomaApp.PORTUGUES) { //se for portugues
            setTitle("FastVehicles | Cadastro de Cartão");
            lblTitulo.setText("Novo cartão");
            lblNumero.setText("Número");
            lblNomeTitular.setText("Nome Titular");
            lblBanco.setText("Banco");
            lblValidade.setText("Validade");
            lblFuncao.setText("Função");
            lblBandeira.setText("Bandeira");
            rdCredito.setText("Crédito");
            rdDebito.setText("Débito");
            btnCad.setText("Cadastrar");
            
            txtNumero.setToolTipText("Digite o número do cartão");
            txtNomeTitular.setToolTipText("Digite o nome do titular "
                    + "da mesma forma que está no cartão");
            txtBanco.setToolTipText("Digite o nome do banco");
            txtValidade.setToolTipText("Digite a validade ( somente mês e ano )");
            txtCvc.setToolTipText("Digite o CVC do cartão");
            txtBandeira.setToolTipText("Digite a bandeira do cartão");
            btnCad.setToolTipText("Adicione o cartão");
            
        }
        
   }
    
    
}
