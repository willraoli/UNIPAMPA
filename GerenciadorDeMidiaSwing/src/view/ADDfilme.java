/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ADDfilme extends javax.swing.JInternalFrame {

    /**
     * Creates new form ADDfoto
     */
    public ADDfilme() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        TituloForm = new javax.swing.JLabel();
        DescricaoForm = new javax.swing.JLabel();
        TituloADD = new javax.swing.JTextField();
        DescricaoADD = new javax.swing.JTextField();
        GeneroADD = new javax.swing.JTextField();
        IdiomaADD = new javax.swing.JTextField();
        DiretorADD = new javax.swing.JTextField();
        AdicionarBotao = new javax.swing.JButton();
        GeneroForm = new javax.swing.JLabel();
        IdiomaForm = new javax.swing.JLabel();
        DiretorForm = new javax.swing.JLabel();
        AtorForm = new javax.swing.JLabel();
        DuracaoForm = new javax.swing.JLabel();
        AnoForm = new javax.swing.JLabel();
        DuracaoADD = new javax.swing.JTextField();
        AtorADD = new javax.swing.JTextField();
        AnoADD = new javax.swing.JTextField();

        jLabel9.setText("jLabel9");

        setClosable(true);

        TituloForm.setText("Título:");

        DescricaoForm.setText("Descrição:");

        AdicionarBotao.setText("Adicionar");
        AdicionarBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarBotaoActionPerformed(evt);
            }
        });

        GeneroForm.setText("Gênero:");

        IdiomaForm.setText("Idioma:");

        DiretorForm.setText("Diretor:");

        AtorForm.setText("Atores principais:");

        DuracaoForm.setText("Duração:");

        AnoForm.setText("Ano:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TituloForm)
                                    .addComponent(DescricaoForm)
                                    .addComponent(GeneroForm)
                                    .addComponent(IdiomaForm)
                                    .addComponent(DiretorForm)
                                    .addComponent(DuracaoForm))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TituloADD, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                                    .addComponent(DescricaoADD)
                                    .addComponent(GeneroADD)
                                    .addComponent(IdiomaADD)
                                    .addComponent(DiretorADD)
                                    .addComponent(DuracaoADD)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(AtorForm)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AtorADD, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(AnoForm)
                                .addGap(45, 45, 45)
                                .addComponent(AnoADD))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(AdicionarBotao)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TituloForm)
                    .addComponent(TituloADD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DescricaoForm)
                    .addComponent(DescricaoADD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GeneroForm)
                    .addComponent(GeneroADD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdiomaForm)
                    .addComponent(IdiomaADD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DiretorADD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DiretorForm))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DuracaoADD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DuracaoForm))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AtorForm)
                    .addComponent(AtorADD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AnoForm)
                    .addComponent(AnoADD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(AdicionarBotao)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AdicionarBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarBotaoActionPerformed
        // TODO add your handling code here:
        //Pegar o título a ser adicionado
        
        JOptionPane.showMessageDialog(null, "Título:" + TituloADD.getText() + "\nDescrição:" + DescricaoADD.getText() + "\nGênero: " + GeneroADD.getText()
        + "\nIdioma:" + IdiomaADD.getText() + "\nDiretor:" + DiretorADD.getText() + "\nAtores principais:" + AtorADD.getText() + "\nDuração: " + DuracaoADD.getText()
        + "\nAno: " + AnoADD.getText());
        
        
    }//GEN-LAST:event_AdicionarBotaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdicionarBotao;
    private javax.swing.JTextField AnoADD;
    private javax.swing.JLabel AnoForm;
    private javax.swing.JTextField AtorADD;
    private javax.swing.JLabel AtorForm;
    private javax.swing.JTextField DescricaoADD;
    private javax.swing.JLabel DescricaoForm;
    private javax.swing.JTextField DiretorADD;
    private javax.swing.JLabel DiretorForm;
    private javax.swing.JTextField DuracaoADD;
    private javax.swing.JLabel DuracaoForm;
    private javax.swing.JTextField GeneroADD;
    private javax.swing.JLabel GeneroForm;
    private javax.swing.JTextField IdiomaADD;
    private javax.swing.JLabel IdiomaForm;
    private javax.swing.JTextField TituloADD;
    private javax.swing.JLabel TituloForm;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
