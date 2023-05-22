package br.com.agro.view;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import br.com.agro.dto.AplicacaoDTO;
import br.com.agro.ctr.AplicacaoCTR;
import br.com.agro.dto.ProdutoDTO;
import br.com.agro.ctr.ProdutoCTR;
import br.com.agro.dto.PlantacaoDTO;
import br.com.agro.ctr.PlantacaoCTR;
import java.util.Date;

public class AplicacaoVIEW extends javax.swing.JInternalFrame {

    AplicacaoCTR aplicacaoCTR = new AplicacaoCTR();
    AplicacaoDTO aplicacaoDTO = new AplicacaoDTO();
    ProdutoCTR produtoCTR = new ProdutoCTR();
    ProdutoDTO produtoDTO = new ProdutoDTO();
    PlantacaoCTR plantacaoCTR = new PlantacaoCTR();
    PlantacaoDTO plantacaoDTO = new PlantacaoDTO();
    
    ResultSet rs;
    DefaultTableModel modelo_jtl_consultar_pla;
    DefaultTableModel modelo_jtl_consultar_pro;
    DefaultTableModel modelo_jtl_consultar_pro_selecionado;
    
    public AplicacaoVIEW() {
        initComponents();
        liberaCampos(false);
        liberaBotoes(true, false, false, true);
        modelo_jtl_consultar_pla = (DefaultTableModel) jtl_consultar_pla.getModel();
        modelo_jtl_consultar_pro = (DefaultTableModel) jtl_consultar_pro.getModel();
        modelo_jtl_consultar_pro_selecionado = (DefaultTableModel) jtl_consultar_pro_selecionado.getModel();
    }
    
    public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2); 
    }//Fecha método setPosicao()
    
    private void preencheTabelaPlantacao(String nome_pla){
        try{
            //Limpa todas as linhas
            modelo_jtl_consultar_pla.setNumRows(0);
            //Enquanto tiver linhas - faça
            plantacaoDTO.setCultivo_pla(nome_pla);
            rs = plantacaoCTR.consultarPlantacao(plantacaoDTO, 1); //1 = é a pesquisa por nome na classe DAO
            while(rs.next()){
                modelo_jtl_consultar_pla.addRow(new Object[]{
                  rs.getString("id_pla"),
                  rs.getString("nome_pla"),
                });
            }        
        }
        catch(Exception erTab){
            System.out.println("Erro SQL: "+erTab);
        } 
    }//Fecha método preencheTabela(String nome)
    
    private void preencheTabelaProduto(String nome_prod){
        try{
            //Limpa todas as linhas
            modelo_jtl_consultar_pro.setNumRows(0);
            //Enquanto tiver linhas - faça
            produtoDTO.setNome_pro(nome_prod);
            rs = produtoCTR.consultarProduto(produtoDTO, 1); //1 = é a pesquisa por nome na classe DAO
            while(rs.next()){
                modelo_jtl_consultar_pro.addRow(new Object[]{
                  rs.getString("id_pro"),
                  rs.getString("nome_pro"),
                  rs.getDouble("val_pro")
                });
            }        
        }
        catch(Exception erTab){
            System.out.println("Erro SQL: "+erTab);
        } 
    }
    
    private void gravar(){
        aplicacaoDTO.setDta_apl(new Date());
        aplicacaoDTO.setVal_apl(Double.parseDouble(total_aplicacaos.getText()));
        plantacaoDTO.setId_pla(Integer.parseInt(String.valueOf(jtl_consultar_pla.getValueAt(
                jtl_consultar_pla.getSelectedRow(), 0))));
        
        JOptionPane.showMessageDialog(null, aplicacaoCTR.inserirAplicacao(aplicacaoDTO, plantacaoDTO, 
                jtl_consultar_pro_selecionado));
    }
    
    private void adicionaProdutoSelecionado(int id_prod, String nome_prod, double p_aplicacao_prod){
        try {
            modelo_jtl_consultar_pro_selecionado.addRow(new Object[]{
                id_prod, nome_prod, p_aplicacao_prod, 0
            });
        } catch (Exception e) {
            System.out.println("Erro SQL: " + e.getMessage());
        }
    }
    
    private void removeProdutoSelecionado(int linha_selecionada){
        try {
            if (linha_selecionada >= 0){
                modelo_jtl_consultar_pro_selecionado.removeRow(linha_selecionada);
                calculaTotalAplicacao();
            }
        } catch (Exception e) {
            System.out.println("Erro SQL: " + e.getMessage());
        }
    }
    
    private void calculaTotalAplicacao(){
        try {
            double total = 0;
            for (int cont = 0; cont < jtl_consultar_pro_selecionado.getRowCount(); cont++){
                total += (Double.parseDouble(String.valueOf(jtl_consultar_pro_selecionado.getValueAt(cont, 2))) * 
                        (Integer.parseInt(String.valueOf(jtl_consultar_pro_selecionado.getValueAt(cont, 3)))));
            }
            total_aplicacaos.setText(String.valueOf(total));
        } catch (Exception e) {
            System.out.println("Erro SQL: " + e.getMessage());
        }
    }
    
    private void limpaCampos(){
        pesquisa_nome_pla.setText("");
        pesquisa_nome_pro.setText("");
        modelo_jtl_consultar_pla.setNumRows(0);
        modelo_jtl_consultar_pro.setNumRows(0);
        modelo_jtl_consultar_pro_selecionado.setNumRows(0);
    }
    
    private void liberaCampos(boolean a){
        pesquisa_nome_pla.setEnabled(a);
        btnPesquisarPla.setEnabled(a);
        jtl_consultar_pla.setEnabled(a);
        pesquisa_nome_pro.setEnabled(a);
        btnPesquisarPro.setEnabled(a);
        jtl_consultar_pro.setEnabled(a);
        btnProAdd.setEnabled(a);
        btnProRem.setEnabled(a);
        jtl_consultar_pro_selecionado.setEnabled(a);
        total_aplicacaos.setText("0.00");
    }
    
    private void liberaBotoes(boolean a, boolean b, boolean c, boolean d){
        btnNovo.setEnabled(a);
        btnSalvar.setEnabled(b);
        btnCancelar.setEnabled(c);
        btnSair.setEnabled(d);
    }
    
    private boolean verificaPreenchimento(){
        if (jtl_consultar_pla.getSelectedRowCount() <= 0){
            JOptionPane.showMessageDialog(null, "Deve ser selecionado um plantacao! ");
            jtl_consultar_pla.requestFocus();
            return false;
        } else {
            if (jtl_consultar_pro_selecionado.getRowCount() <= 0){
                JOptionPane.showMessageDialog(null, "É necessário adicionar ao menos 1 produto no pedido! ");
                jtl_consultar_pro_selecionado.requestFocus();
                return false;
            } else {
                int verifica = 0;
                for (int cont = 0; cont < jtl_consultar_pro_selecionado.getRowCount(); cont++){
                    if (String.valueOf(jtl_consultar_pro_selecionado.getValueAt(cont, 3)).equalsIgnoreCase("null")){
                        verifica++;
                    }
                }
                if (verifica > 0){
                    JOptionPane.showMessageDialog(null, "A quantidade de cada produto deve ser informada! ");
                    jtl_consultar_pro_selecionado.requestFocus();
                    return false;
                } else {
                    return true;
                }
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnProAdd = new javax.swing.JButton();
        btnProRem = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        pesquisa_nome_pla = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtl_consultar_pla = new javax.swing.JTable();
        btnPesquisarPla = new javax.swing.JButton();
        cliente = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        vendas = new javax.swing.JLabel();
        total_vendas = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtl_consultar_pro = new javax.swing.JTable();
        pesquisa_nome_pro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnPesquisarPro = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtl_consultar_pro_selecionado = new javax.swing.JTable();

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agro/view/imagens/novo.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agro/view/imagens/salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agro/view/imagens/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agro/view/imagens/sair.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnProAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agro/view/imagens/prod_add.png"))); // NOI18N
        btnProAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProAddActionPerformed(evt);
            }
        });

        btnProRem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agro/view/imagens/prod_rem.png"))); // NOI18N
        btnProRem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProRemActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(pesquisa_nome_pla, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 226, -1));

        jtl_consultar_pla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtl_consultar_pla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jtl_consultar_pla);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 71, 348, 110));

        btnPesquisarPla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agro/view/imagens/pesquisar.png"))); // NOI18N
        btnPesquisarPla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarPlaActionPerformed(evt);
            }
        });
        jPanel1.add(btnPesquisarPla, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 29, 63, -1));

        cliente.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cliente.setText("Plantação:");
        jPanel1.add(cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 43, -1, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vendas.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        vendas.setText("TOTAL DE VENDAS: ");
        jPanel2.add(vendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 18, 214, 64));

        total_vendas.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        total_vendas.setForeground(new java.awt.Color(0, 204, 51));
        total_vendas.setText("0.00");
        jPanel2.add(total_vendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(226, 18, 128, 64));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtl_consultar_pro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtl_consultar_pro.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jtl_consultar_pro);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 70, 465, 112));
        jPanel3.add(pesquisa_nome_pro, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 6, 348, -1));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Produto:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 9, -1, -1));

        btnPesquisarPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/agro/view/imagens/pesquisar.png"))); // NOI18N
        btnPesquisarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarProActionPerformed(evt);
            }
        });
        jPanel3.add(btnPesquisarPro, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 6, 53, -1));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtl_consultar_pro_selecionado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Valor", "QTD"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtl_consultar_pro_selecionado.getTableHeader().setReorderingAllowed(false);
        jtl_consultar_pro_selecionado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtl_consultar_pro_selecionadoKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jtl_consultar_pro_selecionado);
        if (jtl_consultar_pro_selecionado.getColumnModel().getColumnCount() > 0) {
            jtl_consultar_pro_selecionado.getColumnModel().getColumn(1).setPreferredWidth(400);
        }

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 12, 465, 99));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(195, 195, 195)
                                .addComponent(btnProAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnProRem, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnProAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnProRem, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair)
                    .addComponent(btnCancelar)
                    .addComponent(btnSalvar)
                    .addComponent(btnNovo))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
     // TODO add your handling code here:
        liberaCampos(true);
        liberaBotoes(false, true, true, true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        limpaCampos();
        liberaCampos(false);
        liberaBotoes(true, false, false, true);
        modelo_jtl_consultar_pla.setNumRows(0);
        modelo_jtl_consultar_pro.setNumRows(0);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnPesquisarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarProActionPerformed
        // TODO add your handling code here:
        preencheTabelaProduto(pesquisa_nome_pro.getText());
    }//GEN-LAST:event_btnPesquisarProActionPerformed

    private void btnProAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProAddActionPerformed
        // TODO add your handling code here:
        adicionaProdutoSelecionado(Integer.parseInt(String.valueOf(
                jtl_consultar_pro.getValueAt(jtl_consultar_pro.getSelectedRow(), 0))), 
                String.valueOf(jtl_consultar_pro.getValueAt(jtl_consultar_pro.getSelectedRow(), 1)),
                Double.parseDouble(String.valueOf(jtl_consultar_pro.getValueAt(
                        jtl_consultar_pro.getSelectedRow(), 2))));
    }//GEN-LAST:event_btnProAddActionPerformed

    private void btnProRemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProRemActionPerformed
        // TODO add your handling code here:
        removeProdutoSelecionado(jtl_consultar_pro_selecionado.getSelectedRow());
    }//GEN-LAST:event_btnProRemActionPerformed

    private void jtl_consultar_pro_selecionadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtl_consultar_pro_selecionadoKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER){
            calculaTotalAplicacao();
        }
    }//GEN-LAST:event_jtl_consultar_pro_selecionadoKeyReleased

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        if (verificaPreenchimento()){
            gravar();
            limpaCampos();
            liberaCampos(false);
            liberaBotoes(true, false, false, true);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnPesquisarPlaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarPlaActionPerformed
        // TODO add your handling code here:
        preencheTabelaPlantacao(pesquisa_nome_pla.getText());
    }//GEN-LAST:event_btnPesquisarPlaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisarPla;
    private javax.swing.JButton btnPesquisarPro;
    private javax.swing.JButton btnProAdd;
    private javax.swing.JButton btnProRem;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel cliente;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jtl_consultar_pla;
    private javax.swing.JTable jtl_consultar_pro;
    private javax.swing.JTable jtl_consultar_pro_selecionado;
    private javax.swing.JTextField pesquisa_nome_pla;
    private javax.swing.JTextField pesquisa_nome_pro;
    private javax.swing.JLabel total_vendas;
    private javax.swing.JLabel vendas;
    // End of variables declaration//GEN-END:variables
}
