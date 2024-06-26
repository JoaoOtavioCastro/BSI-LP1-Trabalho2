/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agro.view;

import br.com.agro.dto.FuncionarioDTO;
import javax.swing.JOptionPane;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author jotav
 */
public class PrincipalVIEW extends javax.swing.JFrame {

    /**
     * Creates new form PrincipalVIEW
     */
    public PrincipalVIEW(FuncionarioDTO fdto) {
        initComponents();
        this.setLocationRelativeTo(null);
        if (!fdto.isTipo_fun()) {
            itemMFuncionario.setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImageIcon imageicon = new ImageIcon(getClass().getResource("imagens/agro_tela.jpeg"));
        Image image = imageicon.getImage();
        desktopPane = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics graphics){
                graphics.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        menuBar = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        itemMFazenda = new javax.swing.JMenuItem();
        itemMFornecedor = new javax.swing.JMenuItem();
        itemMPlantacao = new javax.swing.JMenuItem();
        itemMProduto = new javax.swing.JMenuItem();
        itemMProprietario = new javax.swing.JMenuItem();
        itemMFuncionario = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        itemMAplicacao = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuCadastro.setMnemonic('f');
        menuCadastro.setText("Cadastro");

        itemMFazenda.setMnemonic('o');
        itemMFazenda.setText("Fazenda");
        itemMFazenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMFazendaActionPerformed(evt);
            }
        });
        menuCadastro.add(itemMFazenda);

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
        menuCadastro.add(itemMFornecedor);

        itemMPlantacao.setMnemonic('a');
        itemMPlantacao.setText("Plantação");
        itemMPlantacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMPlantacaoActionPerformed(evt);
            }
        });
        menuCadastro.add(itemMPlantacao);

        itemMProduto.setMnemonic('x');
        itemMProduto.setText("Produto");
        itemMProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMProdutoActionPerformed(evt);
            }
        });
        menuCadastro.add(itemMProduto);

        itemMProprietario.setText("Proprietário");
        itemMProprietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMProprietarioActionPerformed(evt);
            }
        });
        menuCadastro.add(itemMProprietario);

        itemMFuncionario.setText("Funcionario");
        itemMFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMFuncionarioActionPerformed(evt);
            }
        });
        menuCadastro.add(itemMFuncionario);

        menuBar.add(menuCadastro);

        editMenu.setMnemonic('e');
        editMenu.setText("Realização");

        itemMAplicacao.setMnemonic('t');
        itemMAplicacao.setText("Aplicação");
        itemMAplicacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMAplicacaoActionPerformed(evt);
            }
        });
        editMenu.add(itemMAplicacao);

        menuBar.add(editMenu);

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
            .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 986, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSairMouseClicked
        sair();
    }//GEN-LAST:event_menuSairMouseClicked

    private void itemMAplicacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMAplicacaoActionPerformed
        abreAplicacaoVIEW();
    }//GEN-LAST:event_itemMAplicacaoActionPerformed

    private void itemMFazendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMFazendaActionPerformed
        abreFazendaVIEW();
    }//GEN-LAST:event_itemMFazendaActionPerformed

    private void itemMFornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemMFornecedorMouseClicked
        abreFornecedorVIEW();
    }//GEN-LAST:event_itemMFornecedorMouseClicked

    private void itemMFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMFornecedorActionPerformed
        abreFornecedorVIEW();
    }//GEN-LAST:event_itemMFornecedorActionPerformed

    private void itemMPlantacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMPlantacaoActionPerformed
        abrePlantacaoVIEW();
    }//GEN-LAST:event_itemMPlantacaoActionPerformed

    private void itemMProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMProdutoActionPerformed
        abreProdutoVIEW();
    }//GEN-LAST:event_itemMProdutoActionPerformed

    private void itemMProprietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMProprietarioActionPerformed
        abreProprietarioVIEW();
    }//GEN-LAST:event_itemMProprietarioActionPerformed

    private void itemMFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMFuncionarioActionPerformed
        abreFuncionarioVIEW();
    }//GEN-LAST:event_itemMFuncionarioActionPerformed

    /**
     * @param args the command line arguments
     */
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

    private void abreFazendaVIEW() {
        FazendaVIEW fazendaVIEW = new FazendaVIEW();
        this.desktopPane.add(fazendaVIEW);
        fazendaVIEW.setVisible(true);
        fazendaVIEW.setPosicao();
    }

    private void abreFuncionarioVIEW() {
        FuncionarioVIEW funcionarioVIEW = new FuncionarioVIEW();
        this.desktopPane.add(funcionarioVIEW);
        funcionarioVIEW.setVisible(true);
        funcionarioVIEW.setPosicao();
    }

    private void abreProdutoVIEW() {
        ProdutoVIEW produtoVIEW = new ProdutoVIEW();
        this.desktopPane.add(produtoVIEW);
        produtoVIEW.setVisible(true);
        produtoVIEW.setPosicao();
    }

    private void abrePlantacaoVIEW() {
        PlantacaoVIEW plantacaoVIEW = new PlantacaoVIEW();
        this.desktopPane.add(plantacaoVIEW);
        plantacaoVIEW.setVisible(true);
        plantacaoVIEW.setPosicao();
    }

    private void abreProprietarioVIEW() {
        ProprietarioVIEW proprietarioVIEW = new ProprietarioVIEW();
        this.desktopPane.add(proprietarioVIEW);
        proprietarioVIEW.setVisible(true);
        proprietarioVIEW.setPosicao();
    }

    private void abreAplicacaoVIEW() {
        AplicacaoVIEW aplicacaoVIEW = new AplicacaoVIEW();
        this.desktopPane.add(aplicacaoVIEW);
        aplicacaoVIEW.setVisible(true);
        aplicacaoVIEW.setPosicao();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem itemMAplicacao;
    private javax.swing.JMenuItem itemMFazenda;
    private javax.swing.JMenuItem itemMFornecedor;
    private javax.swing.JMenuItem itemMFuncionario;
    private javax.swing.JMenuItem itemMPlantacao;
    private javax.swing.JMenuItem itemMProduto;
    private javax.swing.JMenuItem itemMProprietario;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenu menuSair;
    // End of variables declaration//GEN-END:variables

}
