/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import dao.CarroDao;
import dao.InstanceDao;
import dao.LocadoraDao;
import dao.MotoDao;
import design.DesignApp;
import idioma.IdiomaApp;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.SpinnerNumberModel;
import modelos.Locadora;
import modelos.Moto;

/**
 *
 * @author Isaac
 */
public class MotoDados extends javax.swing.JFrame 
    implements FrameTheme, WindowListener, FrameLang {
    
    private LocadoraDao locadoraDao = InstanceDao.LOCADORA_DAO;
    private CarroDao carroDao = InstanceDao.CARRO_DAO;
    private MotoDao motoDao = InstanceDao.MOTO_DAO;
    private Locadora locadoraAtual; //locadora add na classe anterior pelo addLocadora - locator added in the ancient class
  //  private Locadora locadoraAtual = locadoraDao.get(1L) ; //to test
    private LocadoraAdmVeiculos locadoraAdmVeiculos;
    private Moto motoAtual;
    private SpinnerNumberModel anoSpModel;
    private SpinnerNumberModel kmSpModel;
    private SpinnerNumberModel cilindradasSpModel;
    private SpinnerNumberModel caucaoSpModel;
    private SpinnerNumberModel valorDiarioSpModel;
    /**
     * Creates new form MotoDados
     */
    public MotoDados() {
        initComponents();
        locadoraAtual = locadoraDao.get(1L);
//        for(Veiculo v: locadoraAtual.getVeiculos()) { //poe carro no carro atual //to test
//            if(v instanceof Moto) {
//                motoAtual = (Moto)v; //pega 1o carro
//                break;
//            }
//        }
//        extraConfigs();
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

        pnCampos = new javax.swing.JPanel();
        txtId = new javax.swing.JTextField();
        lblId = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        lblCor = new javax.swing.JLabel();
        lblCombustivel = new javax.swing.JLabel();
        lblAno = new javax.swing.JLabel();
        lblKm = new javax.swing.JLabel();
        lblPlaca = new javax.swing.JLabel();
        lblCaucao = new javax.swing.JLabel();
        lblValorDiario = new javax.swing.JLabel();
        lblMotor = new javax.swing.JLabel();
        txtTipo = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtPlaca = new javax.swing.JTextField();
        txtCombustivel = new javax.swing.JTextField();
        txtMotor = new javax.swing.JTextField();
        txtCor = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        spAno = new javax.swing.JSpinner();
        spValorDiario = new javax.swing.JSpinner();
        spKm = new javax.swing.JSpinner();
        lblKmDesc = new javax.swing.JLabel();
        spCaucao = new javax.swing.JSpinner();
        pnMoto = new javax.swing.JPanel();
        lblCilindradas = new javax.swing.JLabel();
        spCilindradas = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("FastVehicles | Dados da moto");

        txtId.setToolTipText("Id do veículo");
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        lblId.setText("Id");

        lblTipo.setText("Tipo");
        lblTipo.setToolTipText("");

        lblMarca.setText("Marca");

        lblModelo.setText("Modelo");

        lblCor.setText("Cor");

        lblCombustivel.setText("Combustível");

        lblAno.setText("Ano");

        lblKm.setText("Quilometragem");

        lblPlaca.setText("Placa");

        lblCaucao.setText("Caução R$");

        lblValorDiario.setText("Valor Diário R$");

        lblMotor.setText("Motor");

        txtTipo.setToolTipText("Tipo do veículo");
        txtTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoActionPerformed(evt);
            }
        });

        txtMarca.setToolTipText("Marca do veículo");

        txtPlaca.setToolTipText("Placa do veículo");

        txtCombustivel.setToolTipText("Combustível do veículo");

        txtMotor.setToolTipText("Motor do veículo");

        txtCor.setToolTipText("Cor do veículo");

        txtModelo.setToolTipText("Modelo do veículo");

        spAno.setToolTipText("Ano do veículo");

        spValorDiario.setToolTipText("Valor Diário do veículo");

        spKm.setToolTipText("Quilometragem do veículo");

        lblKmDesc.setText("Km");

        spCaucao.setToolTipText("Caução do veículo");

        lblCilindradas.setText("Cilindradas");

        spCilindradas.setToolTipText("Cilindradas da moto");

        javax.swing.GroupLayout pnMotoLayout = new javax.swing.GroupLayout(pnMoto);
        pnMoto.setLayout(pnMotoLayout);
        pnMotoLayout.setHorizontalGroup(
            pnMotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMotoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCilindradas)
                .addGap(41, 41, 41)
                .addComponent(spCilindradas, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        pnMotoLayout.setVerticalGroup(
            pnMotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnMotoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnMotoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCilindradas)
                    .addComponent(spCilindradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnCamposLayout = new javax.swing.GroupLayout(pnCampos);
        pnCampos.setLayout(pnCamposLayout);
        pnCamposLayout.setHorizontalGroup(
            pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCamposLayout.createSequentialGroup()
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCamposLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnCamposLayout.createSequentialGroup()
                                .addComponent(lblPlaca)
                                .addGap(30, 30, 30)
                                .addComponent(txtPlaca))
                            .addGroup(pnCamposLayout.createSequentialGroup()
                                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMarca)
                                    .addComponent(lblTipo)
                                    .addComponent(lblModelo)
                                    .addComponent(lblCor))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtModelo)
                                    .addGroup(pnCamposLayout.createSequentialGroup()
                                        .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE))
                                    .addComponent(txtMarca)
                                    .addComponent(txtTipo)))))
                    .addGroup(pnCamposLayout.createSequentialGroup()
                        .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnCamposLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(lblId)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnCamposLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCombustivel)
                                    .addComponent(lblAno))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCombustivel, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spAno, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnCamposLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnCamposLayout.createSequentialGroup()
                                        .addComponent(lblKm)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(spKm, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblKmDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnCamposLayout.createSequentialGroup()
                                        .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblValorDiario, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                            .addComponent(lblCaucao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(spCaucao, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(spValorDiario, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(pnCamposLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblMotor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMotor, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnCamposLayout.createSequentialGroup()
                .addComponent(pnMoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnCamposLayout.setVerticalGroup(
            pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCamposLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo)
                    .addComponent(txtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMarca)
                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModelo)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCor)
                    .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCombustivel)
                    .addComponent(txtCombustivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAno)
                    .addComponent(spAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKm)
                    .addComponent(spKm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblKmDesc))
                .addGap(9, 9, 9)
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlaca)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCaucao)
                    .addComponent(spCaucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblValorDiario)
                    .addComponent(spValorDiario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMotor)
                    .addComponent(txtMotor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnMoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoActionPerformed

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
            java.util.logging.Logger.getLogger(MotoDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MotoDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MotoDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MotoDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MotoDados().setVisible(true);
            }
        });
    }
    
     public void extraConfigs() {
        this.setTitle("FastVehicles | Dados da Moto - " 
            + motoAtual.getModelo().toUpperCase());
        //configs do frame - frames config
        setLocationRelativeTo(null);
        //coloca icone no jframe - insert icon on jframe
        URL url = getClass().getResource("/images/car-default-img.png");
        if(!(url == null)) {
            setIconImage(new ImageIcon(url).getImage());
        }
        
        //confgs dos elementos - elements config
        lblId.setFont(DesignApp.fonteGeral);
        lblTipo.setFont(DesignApp.fonteGeral);
        lblMarca.setFont(DesignApp.fonteGeral);
        lblModelo.setFont(DesignApp.fonteGeral);
        lblCor.setFont(DesignApp.fonteGeral);
        lblCombustivel.setFont(DesignApp.fonteGeral);
        lblAno.setFont(DesignApp.fonteGeral);
        lblKm.setFont(DesignApp.fonteGeral);
        lblKmDesc.setFont(DesignApp.fonteGeral);
        lblPlaca.setFont(DesignApp.fonteGeral);
        lblCaucao.setFont(DesignApp.fonteGeral);
        lblValorDiario.setFont(DesignApp.fonteGeral);
        lblMotor.setFont(DesignApp.fonteGeral);
        txtId.setFont(DesignApp.fonteGeral);
        txtId.setEnabled(false);
        txtId.setText(String.valueOf(motoAtual.getId()));
        lblCilindradas.setFont(DesignApp.fonteGeral);
        
        txtTipo.setFont(DesignApp.fonteGeral);
        txtMarca.setFont(DesignApp.fonteGeral);
        txtModelo.setFont(DesignApp.fonteGeral);
        txtCor.setFont(DesignApp.fonteGeral);
        txtCombustivel.setFont(DesignApp.fonteGeral);
        txtPlaca.setFont(DesignApp.fonteGeral);
        txtMotor.setFont(DesignApp.fonteGeral);
        spAno.setFont(DesignApp.fonteGeral);
        spKm.setFont(DesignApp.fonteGeral);
        spCaucao.setFont(DesignApp.fonteGeral);
        spValorDiario.setFont(DesignApp.fonteGeral);
        spCilindradas.setFont(DesignApp.fonteGeral);
        
        //instanciating spinner models
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        anoSpModel = new SpinnerNumberModel(currentYear, 1980, currentYear, 1);
        kmSpModel = new SpinnerNumberModel(100, 0, 1000000000, 10); 
        caucaoSpModel = new SpinnerNumberModel(200, 0, 10000000, 5);
        cilindradasSpModel = new SpinnerNumberModel(100, 1, 100000, 10); 
        valorDiarioSpModel = new SpinnerNumberModel(50, 1, 10000000, 5);
        
        spAno.setModel(anoSpModel);
        spKm.setModel(kmSpModel);
        spCaucao.setModel(caucaoSpModel);
        spValorDiario.setModel(valorDiarioSpModel);
        spCilindradas.setModel(cilindradasSpModel);
        
        //desabilita todos os campos - disable all fields
        txtTipo.setEditable(false);
        txtMarca.setEditable(false);
        txtModelo.setEditable(false);
        txtCombustivel.setEditable(false);
        txtMotor.setEditable(false);
        txtCor.setEditable(false);
        txtPlaca.setEditable(false);    
        anoSpModel.setMaximum(motoAtual.getAno());
        anoSpModel.setMinimum(motoAtual.getAno());
        kmSpModel.setMaximum(motoAtual.getQuilometragem());
        kmSpModel.setMinimum(motoAtual.getQuilometragem());
        caucaoSpModel.setMaximum(motoAtual.getCaucao());
        caucaoSpModel.setMinimum(motoAtual.getCaucao());
        valorDiarioSpModel.setMaximum(motoAtual.getValorDiario());
        valorDiarioSpModel.setMinimum(motoAtual.getValorDiario());
        cilindradasSpModel.setMaximum(motoAtual.getCilindradas());
        cilindradasSpModel.setMinimum(motoAtual.getCilindradas());
        
        txtTipo.setText(motoAtual.getTipo());
        txtMarca.setText(motoAtual.getMarca());
        txtModelo.setText(motoAtual.getModelo());
        txtCor.setText(motoAtual.getCor());
        txtCombustivel.setText(motoAtual.getCombustivel());
        txtPlaca.setText(motoAtual.getPlaca());
        txtMotor.setText(motoAtual.getMotor());
        anoSpModel.setValue(motoAtual.getAno());
        kmSpModel.setValue(motoAtual.getQuilometragem());
        caucaoSpModel.setValue(motoAtual.getCaucao());
        valorDiarioSpModel.setValue(motoAtual.getValorDiario());
        cilindradasSpModel.setValue(motoAtual.getCilindradas());
        
          //update lang
        if(IdiomaApp.idiomaAtual == IdiomaApp.INGLES) {
            updateLangComponents();
        }

        
    }
        
    public void addMoto(Moto m) {
        this.motoAtual = m;
        extraConfigs();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblCaucao;
    private javax.swing.JLabel lblCilindradas;
    private javax.swing.JLabel lblCombustivel;
    private javax.swing.JLabel lblCor;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblKm;
    private javax.swing.JLabel lblKmDesc;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JLabel lblMotor;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblValorDiario;
    private javax.swing.JPanel pnCampos;
    private javax.swing.JPanel pnMoto;
    private javax.swing.JSpinner spAno;
    private javax.swing.JSpinner spCaucao;
    private javax.swing.JSpinner spCilindradas;
    private javax.swing.JSpinner spKm;
    private javax.swing.JSpinner spValorDiario;
    private javax.swing.JTextField txtCombustivel;
    private javax.swing.JTextField txtCor;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtMotor;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void resetaListenerCampos() {
        //faz nada (facilitar)
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
	   setTitle("FastVehicles | Data Bike - " 
            + motoAtual.getModelo().toUpperCase());
           
            lblTipo.setText("Type");
            lblModelo.setText("Model");
            lblCor.setText("Color");
            lblMarca.setText("Brand");
            lblPlaca.setText("Plate");
            lblCombustivel.setText("Fuel");
            lblAno.setText("Year");
            lblKm.setText("Mileage");
            lblCaucao.setText("Deposit");
            lblValorDiario.setText("Rent Day");
            lblMotor.setText("Engine");
            lblCilindradas.setText("Cylinder cap.");
            
            //tips
            txtId.setToolTipText("Vehicle id");
            txtTipo.setToolTipText("Tipo do veículo");
            txtMarca.setToolTipText("Marca do veículo");
            txtModelo.setToolTipText("Modelo do veículo");
            txtCor.setToolTipText("Cor do veículo");
            txtCombustivel.setToolTipText("Combustível do veículo");
            spAno.setToolTipText("Ano do veículo");
            spKm.setToolTipText("Quilometragem do veículo");
            txtPlaca.setToolTipText("Placa do veículo");
            spCaucao.setToolTipText("Caução do veículo");
            spValorDiario.setToolTipText("Valor diário do veículo");
            txtMotor.setToolTipText("Motor do veículo");
            spCilindradas.setToolTipText("Cilindradas da moto");
            
            
	}else if(IdiomaApp.idiomaAtual == IdiomaApp.PORTUGUES) { //se for portugues
            setTitle("FastVehicles | Dados da Moto - " 
            + motoAtual.getModelo().toUpperCase());
            
            lblTipo.setText("Tipo");
            lblModelo.setText("Modelo");
            lblCor.setText("Cor");
            lblMarca.setText("Marca");
            lblPlaca.setText("Placa");
            lblCombustivel.setText("Combustível");
            lblAno.setText("Ano");
            lblKm.setText("Quilometragem");
            lblCaucao.setText("Caução");
            lblValorDiario.setText("Valor Diário");
            lblMotor.setText("Motor");
            lblCilindradas.setText("Cilindradas");
            
            //tips
            txtId.setToolTipText("Id do veículo");
            txtTipo.setToolTipText("Tipo do veículo");
            txtMarca.setToolTipText("Marca do veículo");
            txtModelo.setToolTipText("Modelo do veículo");
            txtCor.setToolTipText("Cor do veículo");
            txtCombustivel.setToolTipText("Combustível do veículo");
            spAno.setToolTipText("Ano do veículo");
            spKm.setToolTipText("Quilometragem do veículo");
            txtPlaca.setToolTipText("Placa do veículo");
            spCaucao.setToolTipText("Caução do veículo");
            spValorDiario.setToolTipText("Valor diário do veículo");
            txtMotor.setToolTipText("Motor do veículo");

	}
   }
}
