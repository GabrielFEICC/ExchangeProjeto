/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ControllerCompraVenda;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Gabriel
 */
public class JanelaComprarCripto extends javax.swing.JFrame {
        private String cpf;
        private ControllerCompraVenda controller;
        private JanelaSaldo viewSaldo;
    /**
     * Creates new form JanelaCripto
     */
    public JanelaComprarCripto(String cpf) throws SQLException {
        this.cpf = cpf;
        viewSaldo = new JanelaSaldo(cpf);
        initComponents();
        controller = new ControllerCompraVenda(this, viewSaldo);
        realizarCompra();

    }

    public JRadioButton getBtBtc() {
        return btBtc;
    }

    public void setBtBtc(JRadioButton btBtc) {
        this.btBtc = btBtc;
    }

    public JButton getBtComprar() {
        return btComprar;
    }

    public void setBtComprar(JButton btComprar) {
        this.btComprar = btComprar;
    }

    public JRadioButton getBtEth() {
        return btEth;
    }

    public void setBtEth(JRadioButton btEth) {
        this.btEth = btEth;
    }

    public JRadioButton getBtXrp() {
        return btXrp;
    }

    public void setBtXrp(JRadioButton btXrp) {
        this.btXrp = btXrp;
    }

    public ButtonGroup getButtonGroup1() {
        return buttonGroup1;
    }

    public void setButtonGroup1(ButtonGroup buttonGroup1) {
        this.buttonGroup1 = buttonGroup1;
    }

    public JLabel getLblCompra() {
        return lblCompra;
    }

    public void setLblCompra(JLabel lblCompra) {
        this.lblCompra = lblCompra;
    }

    public JLabel getLblCripto() {
        return lblCripto;
    }

    public void setLblCripto(JLabel lblCripto) {
        this.lblCripto = lblCripto;
    }

    public JTextField getTxtQuant() {
        return txtQuant;
    }

    public void setTxtQuant(JTextField txtQuant) {
        this.txtQuant = txtQuant;
    }
    
    private void realizarCompra() {
        String nome = null;
        if (btBtc.isSelected()) {
            nome = "btc";
        } else if (btEth.isSelected()) {
            nome = "eth";
        } else if (btXrp.isSelected()) {
            nome = "xrp";
        }

        String quantidadeStr = txtQuant.getText();
        double quantidade;
        try {
          quantidade = Double.parseDouble(quantidadeStr);
        } catch (NumberFormatException ex) {
            return;
        }

        controller.comprarCripto(cpf, nome, quantidade);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        lblCripto = new javax.swing.JLabel();
        btBtc = new javax.swing.JRadioButton();
        btEth = new javax.swing.JRadioButton();
        btXrp = new javax.swing.JRadioButton();
        lblCompra = new javax.swing.JLabel();
        txtQuant = new javax.swing.JTextField();
        btComprar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCripto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCripto.setText("Qual CriptoMoeda deseja comprar:");

        buttonGroup1.add(btBtc);
        btBtc.setText("Btc");
        btBtc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBtcActionPerformed(evt);
            }
        });

        buttonGroup1.add(btEth);
        btEth.setText("Eth");
        btEth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEthActionPerformed(evt);
            }
        });

        buttonGroup1.add(btXrp);
        btXrp.setText("Xrp");
        btXrp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXrpActionPerformed(evt);
            }
        });

        lblCompra.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCompra.setText("Quantidade:");

        txtQuant.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btComprar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btComprar.setText("Comprar");
        btComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btComprarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(lblCripto))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(btBtc)
                        .addGap(18, 18, 18)
                        .addComponent(btEth)
                        .addGap(18, 18, 18)
                        .addComponent(btXrp))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(lblCompra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtQuant, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(btComprar)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(lblCripto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btBtc)
                    .addComponent(btEth)
                    .addComponent(btXrp))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCompra)
                    .addComponent(txtQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btComprar)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btBtcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBtcActionPerformed

    }//GEN-LAST:event_btBtcActionPerformed

    private void btEthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btEthActionPerformed

    private void btXrpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXrpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btXrpActionPerformed

    private void btComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btComprarActionPerformed
        realizarCompra();
        this.setVisible(false);
            
            
    }//GEN-LAST:event_btComprarActionPerformed
     /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(JanelaComprarCripto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(JanelaComprarCripto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(JanelaComprarCripto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(JanelaComprarCripto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new JanelaComprarCripto().setVisible(true);
//            }
//        });
//    }


        
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btBtc;
    private javax.swing.JButton btComprar;
    private javax.swing.JRadioButton btEth;
    private javax.swing.JRadioButton btXrp;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel lblCompra;
    private javax.swing.JLabel lblCripto;
    private javax.swing.JTextField txtQuant;
    // End of variables declaration//GEN-END:variables
 }

