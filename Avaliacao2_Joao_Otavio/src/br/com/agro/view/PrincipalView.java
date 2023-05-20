/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/MDIApplication.java to edit this template
 */
package br.com.agro.view;

import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author jotavio
 */
public class PrincipalView extends javax.swing.JFrame {

    /**
     * Creates new form PrincipalView
     */
    public PrincipalView() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        itemMFazenda = new javax.swing.JMenuItem();
        itemMFornecedor = new javax.swing.JMenuItem();
        itemMPlantacao = new javax.swing.JMenuItem();
        itemMProduto = new javax.swing.JMenuItem();
        itemMProprietario = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        itemMTratamento = new javax.swing.JMenuItem();
        Menu_Exit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agro/view/imagens/agro_tela.jpeg"))); // NOI18N
        jLabel1.setText(".");
        desktopPane.add(jLabel1);
        jLabel1.setBounds(-20, -10, 1240, 740);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Cadastro");

        itemMFazenda.setMnemonic('o');
        itemMFazenda.setText("Fazenda");
        fileMenu.add(itemMFazenda);

        itemMFornecedor.setMnemonic('s');
        itemMFornecedor.setText("Fornecedor");
        itemMFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemMFornecedorMouseClicked(evt);
            }
        });
        itemMFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMFornecedorActionPerformed(evt);
            }
        });
        fileMenu.add(itemMFornecedor);

        itemMPlantacao.setMnemonic('a');
        itemMPlantacao.setText("Plantação");
        fileMenu.add(itemMPlantacao);

        itemMProduto.setMnemonic('x');
        itemMProduto.setText("Produto");
        itemMProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMProdutoActionPerformed(evt);
            }
        });
        fileMenu.add(itemMProduto);

        itemMProprietario.setText("Proprietário");
        itemMProprietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMProprietarioActionPerformed(evt);
            }
        });
        fileMenu.add(itemMProprietario);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Realização");

        itemMTratamento.setMnemonic('t');
        itemMTratamento.setText("Tratamento");
        editMenu.add(itemMTratamento);

        menuBar.add(editMenu);

        Menu_Exit.setMnemonic('h');
        Menu_Exit.setText("Sair");
        Menu_Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Menu_ExitMouseClicked(evt);
            }
        });
        Menu_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_ExitActionPerformed(evt);
            }
        });
        menuBar.add(Menu_Exit);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1213, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemMProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMProdutoActionPerformed
        abreProdutoVIEW();
    }//GEN-LAST:event_itemMProdutoActionPerformed

    private void Menu_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_ExitActionPerformed
        sair();
    }//GEN-LAST:event_Menu_ExitActionPerformed

    private void itemMFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMFornecedorActionPerformed
        abreFornecedorVIEW();
    }//GEN-LAST:event_itemMFornecedorActionPerformed

    private void itemMFornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemMFornecedorMouseClicked
        abreFornecedorVIEW();
    }//GEN-LAST:event_itemMFornecedorMouseClicked

    private void itemMProprietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMProprietarioActionPerformed
        abreProprietarioVIEW();
    }//GEN-LAST:event_itemMProprietarioActionPerformed

    private void Menu_ExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Menu_ExitMouseClicked
        sair();
    }//GEN-LAST:event_Menu_ExitMouseClicked

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
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalView().setVisible(true);
            }
        });
    }

    private void sair() {
        Object[] options = {"Sair", "Cancelar"};
        if (JOptionPane.showOptionDialog(null, "Deseja Sair do Sistema", "Informação",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]) == 0) {
            System.exit(0);
        }
    }

    private void abreFornecedorVIEW() {
        FornecedorVIEW fornecedorVIEW = new FornecedorVIEW();
        this.desktopPane.add(fornecedorVIEW);
        fornecedorVIEW.setVisible(true);
        fornecedorVIEW.setPosicao();
    }

    private void abreProdutoVIEW() {
        ProdutoVIEW produtoVIEW = new ProdutoVIEW();
        this.desktopPane.add(produtoVIEW);
        produtoVIEW.setVisible(true);
        produtoVIEW.setPosicao();
    }

    private void abreProprietarioVIEW() {
        ProprietarioVIEW proprietarioVIEW = new ProprietarioVIEW();
        this.desktopPane.add(proprietarioVIEW);
        proprietarioVIEW.setVisible(true);
        proprietarioVIEW.setPosicao();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Menu_Exit;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem itemMFazenda;
    private javax.swing.JMenuItem itemMFornecedor;
    private javax.swing.JMenuItem itemMPlantacao;
    private javax.swing.JMenuItem itemMProduto;
    private javax.swing.JMenuItem itemMProprietario;
    private javax.swing.JMenuItem itemMTratamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
