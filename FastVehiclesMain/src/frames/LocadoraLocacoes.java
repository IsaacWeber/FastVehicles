/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import dao.InstanceDao;
import dao.LocacaoCarroDao;
import dao.LocacaoMotoDao;
import dao.LocadoraDao;
import design.DesignApp;
import idioma.IdiomaApp;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import modelos.Locacao;
import modelos.Locadora;
import modelos.Veiculo;

/**
 *
 * @author Isaac
 */
public class LocadoraLocacoes extends javax.swing.JFrame
    implements FrameTheme, WindowListener, FrameLang {
    
    private LocadoraDao locadoraDao = InstanceDao.LOCADORA_DAO;
    private LocacaoCarroDao locacaoCarroDao = InstanceDao.LOCACAO_CARRO_DAO;
    private LocacaoMotoDao locacaoMotoDao = InstanceDao.LOCACAO_MOTO_DAO;
    private Locadora locadoraAtual;
    private DefaultTableModel tblModel;
    private DefaultTableColumnModel tblColumnModel;
    private VerDadosLocadoraLocacao verDadosFrame;
    /**
     * Creates new form LocadoraLocacoes
     */
    public LocadoraLocacoes() {
        initComponents();
//        Locadora locadoraAtual = locadoraDao.get(1L); // to test
//        addLocadora(locadoraAtual);
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
        scrlTblVeiculo = new javax.swing.JScrollPane();
        tblVeiculo = new javax.swing.JTable();
        btnVer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTitulo.setText("Veículos Locados");

        tblVeiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrlTblVeiculo.setViewportView(tblVeiculo);

        btnVer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/see.png"))); // NOI18N
        btnVer.setText("Ver dados");
        btnVer.setToolTipText("Ver dados da locação");
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnGeralLayout = new javax.swing.GroupLayout(pnGeral);
        pnGeral.setLayout(pnGeralLayout);
        pnGeralLayout.setHorizontalGroup(
            pnGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrlTblVeiculo, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnGeralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVer))
            .addGroup(pnGeralLayout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(lblTitulo)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnGeralLayout.setVerticalGroup(
            pnGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGeralLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblTitulo)
                .addGap(42, 42, 42)
                .addComponent(scrlTblVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVer)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        int row = tblVeiculo.getSelectedRow();
        if(row != -1) {
            if(verDadosFrame == null) { //se a tela nao foi iniciada - if screen was not init
                verDadosFrame = new VerDadosLocadoraLocacao();
                verDadosFrame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        if(e.getComponent().equals(verDadosFrame)) {
                            verDadosFrame = null;  //coloca null para poder reiniciar a tela novamente - assign null to init again
                        }
                    }
                });

                for(Locacao locacao: locadoraAtual.getLocacoes()) {
                    //se id e modelo do veiculo da locacao forem iguais ao da linha selecionada
                    if(locacao.getId() == (Long)tblModel.getValueAt(row, 0)
                        && locacao.getVeiculo().getModelo().equals(
                            String.valueOf(tblModel.getValueAt(row, 1)))) {
                        verDadosFrame.addLocacao(locacao); //add locacao ao verDadosFrame
                        break; // fecha loop
                    }
                }
                verDadosFrame.setVisible(true); //torna o frame visivel

            }else if(verDadosFrame.getExtendedState() != NORMAL) {
                verDadosFrame.setExtendedState(NORMAL);
            }else {
                verDadosFrame.requestFocus();
            }
        }else { //se a linha nao esta selecionada - if line is not selected
            if(IdiomaApp.idiomaAtual == IdiomaApp.PORTUGUES) {            
                JOptionPane.showMessageDialog(this, "Linha não selecionada!",
                    "Sem Seleção!", JOptionPane.ERROR_MESSAGE);
            }else if(IdiomaApp.idiomaAtual == IdiomaApp.INGLES) {                           
                JOptionPane.showMessageDialog(this, "Select a line!",
                    "No Selection!", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnVerActionPerformed

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
            java.util.logging.Logger.getLogger(LocadoraLocacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LocadoraLocacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LocadoraLocacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LocadoraLocacoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LocadoraLocacoes().setVisible(true);
            }
        });
    }
    
    public void extraConfigs() {
        this.setTitle("FastVehicles | Veículos locados da Locadora - " 
            + locadoraAtual.getNome().toUpperCase());
        //configs do frame - frames config
        setLocationRelativeTo(null);
        //coloca icone no jframe - insert icon on jframe
        URL url = getClass().getResource("/images/car-default-img.png");
        if(!(url == null)) {
            setIconImage(new ImageIcon(url).getImage());
        }

        //configura tabela carros - setup car table    
        lblTitulo.setFont(DesignApp.fonteTitulo);
        btnVer.setFont(DesignApp.fonteGeral);
        
        tblModel = new DefaultTableModel(new String[]{"Id", "Modelo", "Cliente", 
            "Locação", "Entrega", "Multa"}, 0) {
                
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tblVeiculo.setModel(tblModel);
        tblVeiculo.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        tblColumnModel = ((DefaultTableColumnModel) tblVeiculo.getColumnModel());
        tblColumnModel.getColumn(0).setPreferredWidth(30);
        tblColumnModel.getColumn(1).setPreferredWidth(150);
        tblColumnModel.getColumn(2).setPreferredWidth(150);
        tblColumnModel.getColumn(3).setPreferredWidth(150);
        tblColumnModel.getColumn(4).setPreferredWidth(150);
        
        updateTbl();
        
          //update lang
        if(IdiomaApp.idiomaAtual == IdiomaApp.INGLES) {
            updateLangComponents();
        }

        
    }
    
    
    public void updateTbl() {
        tblModel.setRowCount(0);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        locadoraAtual = locadoraDao.get(locadoraAtual.getId()); //atualiza locadora para n ter erros
        locadoraAtual.setLocacoes(new ArrayList<Locacao>(5));
        locadoraAtual.getLocacoes().addAll(locacaoCarroDao.getAllByLocadora(locadoraAtual)); //add locacoes dos carros
        locadoraAtual.getLocacoes().addAll(locacaoMotoDao.getAllByLocadora(locadoraAtual)); //add locacoes das motos
        //add veiculos na tabela - add vehicles to table 
        for(Locacao locacao: locadoraAtual.getLocacoes()) {
            //calcula multa
            java.sql.Date dataAtual = new java.sql.Date(System.currentTimeMillis()); //pega data atual
            double totalMulta = calcValorTotal(dataAtual, locacao.getDataEntrega(), 
                locacao.getVeiculo()); //retorna um numero real negativo, nulo ou positivo
            if(totalMulta > 0) { //se dataAtual > data de entrega ( valor positivo )
                locacao.setMulta(totalMulta); //adiciona multa linear proporcional ao valor do veiculo
            }
            
            tblModel.addRow(new Object[] {locacao.getId(),    
                locacao.getVeiculo().getModelo(), locacao.getCliente().getNome(),
                sdf.format(locacao.getDataLocacao()), sdf.format(locacao.getDataEntrega()),
                locacao.getMulta()}); 
        }
        
    }
    
    //calcula valor total a partir das datas e do veiculo atual
    private double calcValorTotal(java.sql.Date dataEntrega, 
            java.sql.Date dataLocacao, Veiculo veiculo) {
        Calendar calEnt = Calendar.getInstance();
        calEnt.setTime(dataEntrega);
        Calendar calLoc = Calendar.getInstance();
        calLoc.setTime(dataLocacao);
        
        int[] dataEntArray = {calEnt.get(Calendar.DAY_OF_MONTH), 
            (calEnt.get(Calendar.MONTH) + 1), calEnt.get(Calendar.YEAR)}; //array com dados da data entrega
        
        int[] dataLocArray = {calLoc.get(Calendar.DAY_OF_MONTH), 
            (calLoc.get(Calendar.MONTH) + 1), calLoc.get(Calendar.YEAR)}; //array com dados da data entrega
                
        int dias = (dataEntArray[2] - dataLocArray[2])*365 //diferenca entre anos * 365
            + (dataEntArray[1] - dataLocArray[1])*30 //diferenca entre meses * 30
            + (dataEntArray[0] - dataLocArray[0]); //diferenca entre dias
        
//        System.out.println("dias " + dias);
        return dias * veiculo.getValorDiario(); //multiplica dias pelo valor diario
    }
    
    public void addLocadora(Locadora loc) {
        this.locadoraAtual = loc;
        extraConfigs();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVer;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnGeral;
    private javax.swing.JScrollPane scrlTblVeiculo;
    private javax.swing.JTable tblVeiculo;
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
            this.setTitle("FastVehicles | Rented Vehicles Locator - " 
                + locadoraAtual.getNome().toUpperCase());

            lblTitulo.setText("Rented Vehicles");
            btnVer.setText("See");

            tblColumnModel.getColumn(1).setHeaderValue("Model");
            tblColumnModel.getColumn(2).setHeaderValue("Client");
            tblColumnModel.getColumn(3).setHeaderValue("Rent");
            tblColumnModel.getColumn(4).setHeaderValue("Delivery");
            tblColumnModel.getColumn(5).setHeaderValue("Ticket");
            tblVeiculo.getTableHeader().resizeAndRepaint();
            
            //tips
            btnVer.setToolTipText("See rent data");
            
	}else if(IdiomaApp.idiomaAtual == IdiomaApp.PORTUGUES) { //se for portugues
            this.setTitle("FastVehicles | Veículos locados da Locadora - " 
                + locadoraAtual.getNome().toUpperCase());
            
            lblTitulo.setText("Veículos Locados");
            btnVer.setText("Ver");

            tblColumnModel.getColumn(1).setHeaderValue("Modelo");
            tblColumnModel.getColumn(2).setHeaderValue("Cliente");
            tblColumnModel.getColumn(3).setHeaderValue("Locação");
            tblColumnModel.getColumn(4).setHeaderValue("Entrega");
            tblColumnModel.getColumn(5).setHeaderValue("Multa");
            tblVeiculo.getTableHeader().resizeAndRepaint();

            //tips
            btnVer.setToolTipText("Ver dados da locação");
            
	}
   }
    
}
