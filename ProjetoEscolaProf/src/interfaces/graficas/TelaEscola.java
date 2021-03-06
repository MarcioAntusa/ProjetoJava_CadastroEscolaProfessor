/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.graficas;

import javax.swing.JOptionPane;
import modelos.entidades.*;
import controle.EscolaControle;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import utilitarios.UtilitarioEscola;

/**
 *
 * @author M
 */
public class TelaEscola extends javax.swing.JFrame {

    EscolaControle escolaControle = null;
    private final String msgCampoTelefone = "(##) #####-####";
    private final String msgCampoID = "DIGITE O ID";
    private String criterioEscola = "nome_escola";

    /**
     * Creates new form TelaTeste
     */
    public TelaEscola() {
        initComponents();
        jTextFieldIdentificadorEscola.setEditable(false);
        //jTextFieldTelefoneEscola.setDocument(new SoNumero());
        //jTextFieldConsultarExcluirEscola.setDocument(new SoNumero());

        try {
            escolaControle = new EscolaControle();
            mostrarDadosDasEscolas(escolaControle.listagem(criterioEscola));
            preencherComboBoxColunasEscola();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }

    private Escola getDados() {
        int id = 0;
        if (!jTextFieldIdentificadorEscola.getText().equals("")) {
            id = Integer.parseInt(jTextFieldIdentificadorEscola.getText());
        }
        String nomeDaEscola = jTextFieldNomeEscola.getText();
        String telefone = jTextFieldTelefoneEscola.getText();
        String email = jTextFieldEmailEscola.getText();
        String endereco = jTextFieldEnderecoEscola.getText();
        Escola objEscola = new Escola(id, nomeDaEscola, telefone, email, endereco);
        return objEscola;
    }

    private void limparTela() {
        jTextFieldIdentificadorEscola.setText("");
        jTextFieldNomeEscola.setText("");
        jTextFieldTelefoneEscola.setText("");
        jTextFieldEmailEscola.setText("");
        jTextFieldEnderecoEscola.setText("");
        jTextFieldConsultarExcluirEscola.setText("DIGITE O ID");
        jTextFieldTelefoneEscola.setText("(##) #####-####");
    }

    private void mostrarDadosDasEscolas(Iterator obj) {
        try {
            Iterator<Escola> listaDeEscolas = obj;
            DefaultTableModel model = (DefaultTableModel) jTableEscola.getModel();
            model.setNumRows(0);
            //Iterator
            while (listaDeEscolas.hasNext()) {
                String[] saida = new String[5];
                Escola aux = (Escola) listaDeEscolas.next();
                saida[0] = aux.getId() + "";
                saida[1] = aux.getNome();
                saida[2] = aux.getTelefone();
                saida[3] = aux.getEmail();
                saida[4] = aux.getEndereco();
                model.addRow(saida);
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }

    private void alterarCampoTextField(JTextField obj, String msg1, Boolean aux, String msg2) {
        if (obj.getText().equals(msg1)) {
            obj.setFocusable(aux);
            obj.setText(msg2);
        }
    }

    private void preencherComboBoxColunasEscola() throws Exception {
        /*for (int pos = 0; pos < jTableEscola.getColumnCount(); pos++) {
            jComboBoxOrdenarEscola.addItem((jTableEscola.getColumnName(pos)));
        }*/
        String[] colunas = escolaControle.listaDeColunas();
        for (String coluna : colunas) {
            jComboBoxOrdenarEscola.addItem(coluna);
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

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelIdentificador = new javax.swing.JLabel();
        jLabelNomeEscola = new javax.swing.JLabel();
        jLabelTelefone = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jTextFieldIdentificadorEscola = new javax.swing.JTextField();
        jTextFieldNomeEscola = new javax.swing.JTextField();
        jTextFieldEnderecoEscola = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEscola = new javax.swing.JTable();
        jTextFieldTelefoneEscola = new javax.swing.JTextField();
        jTextFieldEmailEscola = new javax.swing.JTextField();
        jLabelEndereco = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButtonIncluirEscola = new javax.swing.JButton();
        jButtonAlterarEscola = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButtonConsultarPorIdEscola = new javax.swing.JButton();
        jButtonExcluirPorIdEscola = new javax.swing.JButton();
        jTextFieldConsultarExcluirEscola = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jButtonLimparDadosEscola = new javax.swing.JButton();
        jButtonOrdenarEscola = new javax.swing.JButton();
        jComboBoxOrdenarEscola = new javax.swing.JComboBox<>();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CADASTRO DAS ESCOLAS");

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CADASTRO DAS ESCOLAS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(266, 266, 266)
                .addComponent(jLabel1)
                .addContainerGap(266, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(33, 33, 33))
        );

        jLabelIdentificador.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelIdentificador.setText("IDENTIFICADOR");

        jLabelNomeEscola.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelNomeEscola.setText("NOME DA ESCOLA");

        jLabelTelefone.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelTelefone.setText("TELEFONE");

        jLabelEmail.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelEmail.setText("EMAIL");

        jTextFieldNomeEscola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeEscolaActionPerformed(evt);
            }
        });

        jTextFieldEnderecoEscola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEnderecoEscolaActionPerformed(evt);
            }
        });

        jTableEscola.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDENTIFICADOR", "NOME_DA_ESCOLA", "TELEFONE", "EMAIL", "ENDERECO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEscola.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEscolaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableEscola);

        jTextFieldTelefoneEscola.setText("(##) #####-####");
        jTextFieldTelefoneEscola.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextFieldTelefoneEscolaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextFieldTelefoneEscolaMouseExited(evt);
            }
        });

        jLabelEndereco.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelEndereco.setText("ENDERE??O");

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        jButtonIncluirEscola.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonIncluirEscola.setText("INCLUIR");
        jButtonIncluirEscola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirEscolaActionPerformed(evt);
            }
        });

        jButtonAlterarEscola.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonAlterarEscola.setText("ALTERAR");
        jButtonAlterarEscola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarEscolaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonAlterarEscola, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(jButtonIncluirEscola, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(246, 246, 246))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonIncluirEscola)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAlterarEscola)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));

        jButtonConsultarPorIdEscola.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonConsultarPorIdEscola.setText("CONSULTAR POR ID");
        jButtonConsultarPorIdEscola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarPorIdEscolaActionPerformed(evt);
            }
        });

        jButtonExcluirPorIdEscola.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonExcluirPorIdEscola.setText("EXCLUIR POR ID");
        jButtonExcluirPorIdEscola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirPorIdEscolaActionPerformed(evt);
            }
        });

        jTextFieldConsultarExcluirEscola.setText("DIGITE O ID");
        jTextFieldConsultarExcluirEscola.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextFieldConsultarExcluirEscolaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextFieldConsultarExcluirEscolaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonConsultarPorIdEscola, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonExcluirPorIdEscola, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldConsultarExcluirEscola, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonConsultarPorIdEscola)
                    .addComponent(jTextFieldConsultarExcluirEscola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonExcluirPorIdEscola)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));

        jButtonLimparDadosEscola.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonLimparDadosEscola.setText("LIMPAR DADOS");
        jButtonLimparDadosEscola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparDadosEscolaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonLimparDadosEscola, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonLimparDadosEscola)
                .addContainerGap())
        );

        jButtonOrdenarEscola.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonOrdenarEscola.setForeground(new java.awt.Color(204, 0, 51));
        jButtonOrdenarEscola.setText("ORDENAR");
        jButtonOrdenarEscola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOrdenarEscolaActionPerformed(evt);
            }
        });

        jComboBoxOrdenarEscola.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxOrdenarEscola.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ORDENAR POR:" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelTelefone)
                                    .addComponent(jLabelEmail))
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldTelefoneEscola, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 349, Short.MAX_VALUE))
                                    .addComponent(jTextFieldEmailEscola)
                                    .addComponent(jTextFieldEnderecoEscola)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelEndereco)
                                .addGap(339, 339, 339))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelIdentificador)
                                    .addComponent(jLabelNomeEscola))
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldIdentificadorEscola, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldNomeEscola))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBoxOrdenarEscola, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonOrdenarEscola, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41))))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldIdentificadorEscola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelIdentificador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNomeEscola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNomeEscola))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTelefone)
                    .addComponent(jTextFieldTelefoneEscola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEmailEscola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEndereco)
                    .addComponent(jTextFieldEnderecoEscola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonOrdenarEscola)
                            .addComponent(jComboBoxOrdenarEscola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIncluirEscolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirEscolaActionPerformed
        try {
            if (UtilitarioEscola.getCheckDados(getDados())) {
                escolaControle.incluir(getDados());
                limparTela();
                mostrarDadosDasEscolas(escolaControle.listagem(criterioEscola));
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }//GEN-LAST:event_jButtonIncluirEscolaActionPerformed

    private void jTextFieldNomeEscolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeEscolaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeEscolaActionPerformed

    private void jTextFieldEnderecoEscolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEnderecoEscolaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEnderecoEscolaActionPerformed

    private void jButtonAlterarEscolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarEscolaActionPerformed
        try {
            if (UtilitarioEscola.getCheckDados(getDados())) {
                escolaControle.alterar(getDados());
                limparTela();
                mostrarDadosDasEscolas(escolaControle.listagem(criterioEscola));
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }//GEN-LAST:event_jButtonAlterarEscolaActionPerformed

    private void jButtonExcluirPorIdEscolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirPorIdEscolaActionPerformed
        try {
            if (!jTextFieldConsultarExcluirEscola.getText().equals("DIGITE O ID")) {
                int id = Integer.parseInt(jTextFieldConsultarExcluirEscola.getText());
                escolaControle.excluirPorID(id);
                mostrarDadosDasEscolas(escolaControle.listagem(criterioEscola));
                if (jTextFieldConsultarExcluirEscola.getText().equals(jTextFieldIdentificadorEscola.getText())) {
                    limparTela();
                }
                jTextFieldConsultarExcluirEscola.setText("DIGITE O ID");
                
            } else {
                JOptionPane.showMessageDialog(null, "ID N??O DIGITADO!");
            }

        } catch (Exception erro) {
            //JOptionPane.showMessageDialog(this, erro.getMessage());
            JOptionPane.showMessageDialog(this, "ID N??O ENCONTRADO!");
        }

    }//GEN-LAST:event_jButtonExcluirPorIdEscolaActionPerformed

    private void jButtonConsultarPorIdEscolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarPorIdEscolaActionPerformed
        try {
            /*List<Escola> obj = new LinkedList<Escola>();
            obj.add(escolaControle.consultarPorID(id));
            mostrarDadosDasEscolas(obj.iterator());*/

            if (!jTextFieldConsultarExcluirEscola.getText().equals("DIGITE O ID")) {
                int id = Integer.parseInt(jTextFieldConsultarExcluirEscola.getText());
                Escola escola = new Escola();
                escola = escolaControle.consultarPorID(id);
                jTextFieldIdentificadorEscola.setText(escola.getId() + "");
                jTextFieldNomeEscola.setText(escola.getNome());
                jTextFieldTelefoneEscola.setText(escola.getTelefone());
                jTextFieldEmailEscola.setText(escola.getEmail());
                jTextFieldEnderecoEscola.setText(escola.getEndereco());
                jTextFieldConsultarExcluirEscola.setText("DIGITE O ID");

            } else {
                JOptionPane.showMessageDialog(null, "ID N??O DIGITADO!");
            }

        } catch (Exception erro) {
            //JOptionPane.showMessageDialog(this, erro.getMessage());
            JOptionPane.showMessageDialog(this, "ID N??O ENCONTRADO!");
        }

    }//GEN-LAST:event_jButtonConsultarPorIdEscolaActionPerformed

    private void jTableEscolaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEscolaMouseClicked
        jTextFieldIdentificadorEscola.setText(jTableEscola.getValueAt(jTableEscola.getSelectedRow(), 0).toString());
        jTextFieldNomeEscola.setText(jTableEscola.getValueAt(jTableEscola.getSelectedRow(), 1).toString());
        jTextFieldTelefoneEscola.setText(jTableEscola.getValueAt(jTableEscola.getSelectedRow(), 2).toString());
        jTextFieldEmailEscola.setText(jTableEscola.getValueAt(jTableEscola.getSelectedRow(), 3).toString());
        jTextFieldEnderecoEscola.setText(jTableEscola.getValueAt(jTableEscola.getSelectedRow(), 4).toString());
    }//GEN-LAST:event_jTableEscolaMouseClicked

    private void jButtonLimparDadosEscolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparDadosEscolaActionPerformed
        limparTela();
    }//GEN-LAST:event_jButtonLimparDadosEscolaActionPerformed

    private void jTextFieldTelefoneEscolaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldTelefoneEscolaMouseEntered
        alterarCampoTextField(jTextFieldTelefoneEscola, msgCampoTelefone, true, "");
    }//GEN-LAST:event_jTextFieldTelefoneEscolaMouseEntered

    private void jTextFieldTelefoneEscolaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldTelefoneEscolaMouseExited
        alterarCampoTextField(jTextFieldTelefoneEscola, "", false, msgCampoTelefone);
    }//GEN-LAST:event_jTextFieldTelefoneEscolaMouseExited

    private void jTextFieldConsultarExcluirEscolaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldConsultarExcluirEscolaMouseEntered
        alterarCampoTextField(jTextFieldConsultarExcluirEscola, msgCampoID, true, "");
    }//GEN-LAST:event_jTextFieldConsultarExcluirEscolaMouseEntered

    private void jTextFieldConsultarExcluirEscolaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldConsultarExcluirEscolaMouseExited
        alterarCampoTextField(jTextFieldConsultarExcluirEscola, "", false, msgCampoID);
    }//GEN-LAST:event_jTextFieldConsultarExcluirEscolaMouseExited

    private void jButtonOrdenarEscolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOrdenarEscolaActionPerformed
        try {
            if (!jComboBoxOrdenarEscola.getSelectedItem().equals("ORDENAR POR:")) {
                criterioEscola = jComboBoxOrdenarEscola.getSelectedItem().toString();
                mostrarDadosDasEscolas(escolaControle.listagem(criterioEscola));
                jComboBoxOrdenarEscola.setSelectedIndex(0);
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }//GEN-LAST:event_jButtonOrdenarEscolaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaEscola.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEscola.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEscola.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEscola.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEscola().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterarEscola;
    private javax.swing.JButton jButtonConsultarPorIdEscola;
    private javax.swing.JButton jButtonExcluirPorIdEscola;
    private javax.swing.JButton jButtonIncluirEscola;
    private javax.swing.JButton jButtonLimparDadosEscola;
    private javax.swing.JButton jButtonOrdenarEscola;
    private javax.swing.JComboBox<String> jComboBoxOrdenarEscola;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEndereco;
    private javax.swing.JLabel jLabelIdentificador;
    private javax.swing.JLabel jLabelNomeEscola;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEscola;
    private javax.swing.JTextField jTextFieldConsultarExcluirEscola;
    private javax.swing.JTextField jTextFieldEmailEscola;
    private javax.swing.JTextField jTextFieldEnderecoEscola;
    private javax.swing.JTextField jTextFieldIdentificadorEscola;
    private javax.swing.JTextField jTextFieldNomeEscola;
    private javax.swing.JTextField jTextFieldTelefoneEscola;
    // End of variables declaration//GEN-END:variables
}
