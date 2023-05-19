package br.com.carro.view;

import javax.swing.JOptionPane;

public class PrincipalVIEW extends javax.swing.JFrame {

    /**
     * Creates new form PrincipalVIEW
     */
    public PrincipalVIEW() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        desktopPane = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        itemMenuDono = new javax.swing.JMenuItem();
        itemMenuCarro = new javax.swing.JMenuItem();
        itemMenuMotor = new javax.swing.JMenuItem();
        itemMenuMecanico = new javax.swing.JMenuItem();
        menuVenda = new javax.swing.JMenu();
        itemMenuConserto = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem3.setText("jMenuItem3");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/carro/view/imagem/maxresdefault.jpg"))); // NOI18N
        desktopPane.add(jLabel1);
        jLabel1.setBounds(0, -10, 1550, 720);

        menuCadastro.setMnemonic('c');
        menuCadastro.setText("Cadastro");

        itemMenuDono.setText("Dono");
        itemMenuDono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuDonoActionPerformed(evt);
            }
        });
        menuCadastro.add(itemMenuDono);

        itemMenuCarro.setMnemonic('f');
        itemMenuCarro.setText("Carro");
        itemMenuCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuCarroActionPerformed(evt);
            }
        });
        menuCadastro.add(itemMenuCarro);

        itemMenuMotor.setMnemonic('p');
        itemMenuMotor.setText("Motor");
        itemMenuMotor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuMotorActionPerformed(evt);
            }
        });
        menuCadastro.add(itemMenuMotor);

        itemMenuMecanico.setText("Mecanico");
        itemMenuMecanico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuMecanicoActionPerformed(evt);
            }
        });
        menuCadastro.add(itemMenuMecanico);

        menuBar.add(menuCadastro);

        menuVenda.setText("Conserto");

        itemMenuConserto.setText("Realizar Conserto");
        itemMenuConserto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuConsertoActionPerformed(evt);
            }
        });
        menuVenda.add(itemMenuConserto);

        menuBar.add(menuVenda);

        menuSair.setMnemonic('s');
        menuSair.setText("Sair");
        menuSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSairMouseClicked(evt);
            }
        });
        menuBar.add(menuSair);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSairMouseClicked
        sair();
    }//GEN-LAST:event_menuSairMouseClicked

    private void itemMenuCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuCarroActionPerformed
        abreCarroVIEW();
    }//GEN-LAST:event_itemMenuCarroActionPerformed

    private void itemMenuMotorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuMotorActionPerformed
        abreMotorVIEW();
    }//GEN-LAST:event_itemMenuMotorActionPerformed

    private void itemMenuDonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuDonoActionPerformed
        abreDonoVIEW();
    }//GEN-LAST:event_itemMenuDonoActionPerformed

    private void itemMenuConsertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuConsertoActionPerformed
        abreConcertoVIEW();
    }//GEN-LAST:event_itemMenuConsertoActionPerformed

    private void itemMenuMecanicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuMecanicoActionPerformed
        abreMecanicoVIEW();
    }//GEN-LAST:event_itemMenuMecanicoActionPerformed

    /**
     * Método para fechar o sistema.
     */ 
    private void sair(){
        Object[] options = { "Sair", "Cancelar" };
        if(JOptionPane.showOptionDialog(null, "Deseja Sair do Sistema", "Informação", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]) == 0){
            System.exit(0);
        } 
    } 
    
    
    /**
     * Método para abrir a classe ClienteVIEW.
     */
    private void abreCarroVIEW(){
        CarroVIEW carroVIEW = new CarroVIEW();
        this.desktopPane.add(carroVIEW);
        carroVIEW.setVisible(true); 
      //  carroVIEW.setPosicao();
    }
    
    
    /**
     * Método para abrir a classe FornecedorVIEW.
     */
    private void abreConcertoVIEW(){
        ConcertoVIEW concertoVIEW = new ConcertoVIEW();
        this.desktopPane.add(concertoVIEW);
        concertoVIEW.setVisible(true); 
       // concertoVIEW.setPosicao();
    }
    
    
    /**
     * Método para abrir a classe ProdutoVIEW.
     */
    private void abreDonoVIEW(){
        DonoVIEW donoVIEW = new DonoVIEW();
        this.desktopPane.add(donoVIEW);
        donoVIEW.setVisible(true); 
      //  donoVIEW.setPosicao();
    }
    
    private void abreMotorVIEW(){
        MotorVIEW motorVIEW = new MotorVIEW();
        this.desktopPane.add(motorVIEW);
        motorVIEW.setVisible(true); 
       // motorVIEW.setPosicao();
    }
    private void abreMecanicoVIEW(){
        MecanicoVIEW mecanicoVIEW = new MecanicoVIEW();
        this.desktopPane.add(mecanicoVIEW);
        mecanicoVIEW.setVisible(true); 
        //mecanicoVIEW.setPosicao();
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
            java.util.logging.Logger.getLogger(PrincipalVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalVIEW.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalVIEW().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem itemMenuCarro;
    private javax.swing.JMenuItem itemMenuConserto;
    private javax.swing.JMenuItem itemMenuDono;
    private javax.swing.JMenuItem itemMenuMecanico;
    private javax.swing.JMenuItem itemMenuMotor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenu menuSair;
    private javax.swing.JMenu menuVenda;
    // End of variables declaration//GEN-END:variables

}
