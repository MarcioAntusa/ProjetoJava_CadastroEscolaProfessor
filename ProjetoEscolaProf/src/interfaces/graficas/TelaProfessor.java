/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces.graficas;

import controle.EscolaControle;
import controle.ProfessorControle;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelos.entidades.Escola;
import modelos.entidades.Professor;
import persistencia.ProfessorJDBCDao;
import utilitarios.SoNumero;
import utilitarios.UtilitarioProfessor;

/**
 *
 * @author M
 */
public class TelaProfessor extends javax.swing.JFrame {

    ProfessorControle professorControle = null;
    EscolaControle escolaControle = null;
    private final String msgCampoTelefone = "(##) #####-####";
    private final String msgCampoID = "DIGITE O ID";
    private String criterioEscola = "nome_escola";
    private String criterioProf = "nome_prof";

    /**
     * Creates new form TelaProfessor
     */
    public TelaProfessor() {
        initComponents();
        jTextFieldIdentificadorProf.setEditable(false);
        jTextFieldMatriculaProf.setDocument(new SoNumero());
        //jTextFieldTelefoneProf.setDocument(new SoNumero());
        //jTextFieldConsultarExcluirProf.setDocument(new SoNumero());

        try {
            professorControle = new ProfessorControle();
            escolaControle = new EscolaControle();
            mostrarDadosDosProfessores(professorControle.listagem(criterioProf));
            preencherComboBoxColunasProf();

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }

    private Professor getDados() throws Exception {
        int id = 0;
        if (!jTextFieldIdentificadorProf.getText().equals("")) {
            id = Integer.parseInt(jTextFieldIdentificadorProf.getText());
        }
        int matricula = Integer.parseInt(jTextFieldMatriculaProf.getText());
        String nomeProfessor = jTextFieldNomeProf.getText();
        String telefone = jTextFieldTelefoneProf.getText();
        String email = jTextFieldEmailProf.getText();
        String endereco = jTextFieldEnderecoProf.getText();
        String titulacao = "" + jComboBoxTitulacaoProf.getSelectedItem();
        String nomeEscola = "" + jComboBoxEscolaProf.getSelectedItem();

        Professor objProfessor = new Professor(id, matricula,
                nomeProfessor, telefone,
                email, endereco,
                titulacao,
                escolaControle.consultarPorNome(nomeEscola)
        );

        return objProfessor;
    }

    private void limparTela() {
        jTextFieldIdentificadorProf.setText("");
        jTextFieldMatriculaProf.setText("");
        jTextFieldNomeProf.setText("");
        jTextFieldTelefoneProf.setText("");
        jTextFieldEmailProf.setText("");
        jTextFieldEnderecoProf.setText("");
        jComboBoxTitulacaoProf.setSelectedIndex(0);
        jComboBoxEscolaProf.setSelectedIndex(0);
        jTextFieldConsultarExcluirProf.setText("DIGITE O ID");
        jTextFieldTelefoneProf.setText("(##) #####-####");
    }

    private void mostrarDadosDosProfessores(Iterator obj) {
        try {
            Iterator<Professor> listaDeProfessores = obj;
            DefaultTableModel model = (DefaultTableModel) jTableProf.getModel();
            model.setNumRows(0);
            //Iterator
            while (listaDeProfessores.hasNext()) {
                String[] saida = new String[8];
                Professor aux = (Professor) listaDeProfessores.next();
                saida[0] = aux.getId() + "";
                saida[1] = aux.getMatricula() + "";
                saida[2] = aux.getNome();
                saida[3] = aux.getTelefone();
                saida[4] = aux.getEmail();
                saida[5] = aux.getEndereco();
                saida[6] = aux.getTitulacao();
                saida[7] = aux.getEscola().getNome();
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

    private void preencherComboBoxColunasProf() throws Exception {
        /*for (int pos = 0; pos < jTableProf.getColumnCount(); pos++) {
            jComboBoxOrdenarProf.addItem((jTableProf.getColumnName(pos)));
        }*/
        String[] colunas = professorControle.listaDeColunas();
        for (String coluna : colunas) {
            jComboBoxOrdenarProf.addItem(coluna);
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

        jTextFieldEnderecoProf = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProf = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButtonLimparDadosProf = new javax.swing.JButton();
        jTextFieldTelefoneProf = new javax.swing.JTextField();
        jTextFieldEmailProf = new javax.swing.JTextField();
        jLabelEndereco = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButtonIncluirProf = new javax.swing.JButton();
        jButtonAlterarProf = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelIdentificador = new javax.swing.JLabel();
        jLabelNomeProfessor = new javax.swing.JLabel();
        jLabelTelefone = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jTextFieldIdentificadorProf = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButtonConsultarPorIdProf = new javax.swing.JButton();
        jButtonExcluirPorIdProf = new javax.swing.JButton();
        jTextFieldConsultarExcluirProf = new javax.swing.JTextField();
        jTextFieldNomeProf = new javax.swing.JTextField();
        jLabelMatricula = new javax.swing.JLabel();
        jComboBoxEscolaProf = new javax.swing.JComboBox<>();
        jComboBoxTitulacaoProf = new javax.swing.JComboBox<>();
        jTextFieldMatriculaProf = new javax.swing.JTextField();
        jComboBoxOrdenarProf = new javax.swing.JComboBox<>();
        jButtonOrdenarProf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CADASTRO DOS PROFESSORES");

        jTableProf.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "MATRICULA", "NOME", "TELEFONE", "EMAIL", "ENDERECO", "TITULACAO", "ESCOLA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableProf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProfMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProf);

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));

        jButtonLimparDadosProf.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonLimparDadosProf.setText("LIMPAR DADOS");
        jButtonLimparDadosProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparDadosProfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonLimparDadosProf, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonLimparDadosProf)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextFieldTelefoneProf.setText("(##) #####-####");
        jTextFieldTelefoneProf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextFieldTelefoneProfMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextFieldTelefoneProfMouseExited(evt);
            }
        });

        jLabelEndereco.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelEndereco.setText("ENDEREÇO");

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        jButtonIncluirProf.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonIncluirProf.setText("INCLUIR");
        jButtonIncluirProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirProfActionPerformed(evt);
            }
        });

        jButtonAlterarProf.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonAlterarProf.setText("ALTERAR");
        jButtonAlterarProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarProfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonAlterarProf, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(jButtonIncluirProf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(246, 246, 246))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonIncluirProf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAlterarProf)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CADASTRO DOS PROFESSORES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jLabelIdentificador.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelIdentificador.setText("IDENTIFICADOR");

        jLabelNomeProfessor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelNomeProfessor.setText("NOME ");

        jLabelTelefone.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelTelefone.setText("TELEFONE");

        jLabelEmail.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelEmail.setText("EMAIL");

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));

        jButtonConsultarPorIdProf.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonConsultarPorIdProf.setText("CONSULTAR POR ID");
        jButtonConsultarPorIdProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarPorIdProfActionPerformed(evt);
            }
        });

        jButtonExcluirPorIdProf.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonExcluirPorIdProf.setText("EXCLUIR POR ID");
        jButtonExcluirPorIdProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirPorIdProfActionPerformed(evt);
            }
        });

        jTextFieldConsultarExcluirProf.setText("DIGITE O ID");
        jTextFieldConsultarExcluirProf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextFieldConsultarExcluirProfMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextFieldConsultarExcluirProfMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonConsultarPorIdProf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonExcluirPorIdProf, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldConsultarExcluirProf, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonConsultarPorIdProf)
                    .addComponent(jTextFieldConsultarExcluirProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonExcluirPorIdProf)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelMatricula.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelMatricula.setText("MATRICULA");

        jComboBoxEscolaProf.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxEscolaProf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ESCOLA" }));
        jComboBoxEscolaProf.setToolTipText("");
        jComboBoxEscolaProf.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jComboBoxEscolaProfAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jComboBoxTitulacaoProf.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxTitulacaoProf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TITULACAO", "GRADUACAO", "ESPECIALIZACAO", "MESTRADO", "DOUTORADO" }));
        jComboBoxTitulacaoProf.setToolTipText("");
        jComboBoxTitulacaoProf.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jComboBoxTitulacaoProfAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jComboBoxOrdenarProf.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jComboBoxOrdenarProf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ORDENAR POR:" }));

        jButtonOrdenarProf.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonOrdenarProf.setForeground(new java.awt.Color(204, 0, 51));
        jButtonOrdenarProf.setText("ORDENAR");
        jButtonOrdenarProf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOrdenarProfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboBoxEscolaProf, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(jComboBoxTitulacaoProf, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(34, 34, 34)
                                        .addComponent(jComboBoxOrdenarProf, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonOrdenarProf, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(145, 145, 145))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelEndereco)
                                .addGap(36, 36, 36)
                                .addComponent(jTextFieldEnderecoProf)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelNomeProfessor)
                                .addGap(58, 58, 58)
                                .addComponent(jTextFieldNomeProf))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelEmail)
                                .addGap(57, 57, 57)
                                .addComponent(jTextFieldEmailProf))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelIdentificador)
                                    .addComponent(jLabelMatricula))
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldMatriculaProf, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabelTelefone)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextFieldTelefoneProf, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldIdentificadorProf, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldIdentificadorProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelIdentificador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTelefone)
                    .addComponent(jTextFieldTelefoneProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMatricula)
                    .addComponent(jTextFieldMatriculaProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNomeProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNomeProfessor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEmailProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEnderecoProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEndereco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxEscolaProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTitulacaoProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxOrdenarProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOrdenarProf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableProfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProfMouseClicked
        jTextFieldIdentificadorProf.setText(jTableProf.getValueAt(jTableProf.getSelectedRow(), 0).toString());
        jTextFieldMatriculaProf.setText(jTableProf.getValueAt(jTableProf.getSelectedRow(), 1).toString());
        jTextFieldNomeProf.setText(jTableProf.getValueAt(jTableProf.getSelectedRow(), 2).toString());
        jTextFieldTelefoneProf.setText(jTableProf.getValueAt(jTableProf.getSelectedRow(), 3).toString());
        jTextFieldEmailProf.setText(jTableProf.getValueAt(jTableProf.getSelectedRow(), 4).toString());
        jTextFieldEnderecoProf.setText(jTableProf.getValueAt(jTableProf.getSelectedRow(), 5).toString());
        jComboBoxTitulacaoProf.setSelectedItem(jTableProf.getValueAt(jTableProf.getSelectedRow(), 6).toString());
        jComboBoxEscolaProf.setSelectedItem(jTableProf.getValueAt(jTableProf.getSelectedRow(), 7).toString());
    }//GEN-LAST:event_jTableProfMouseClicked

    private void jButtonLimparDadosProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparDadosProfActionPerformed
        limparTela();
    }//GEN-LAST:event_jButtonLimparDadosProfActionPerformed

    private void jButtonIncluirProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirProfActionPerformed
        try {
            if (UtilitarioProfessor.getCheckDados(getDados())) {
                professorControle.incluir(getDados());
                limparTela();
                mostrarDadosDosProfessores(professorControle.listagem(criterioProf));
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }//GEN-LAST:event_jButtonIncluirProfActionPerformed

    private void jButtonAlterarProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarProfActionPerformed
        try {
            if (UtilitarioProfessor.getCheckDados(getDados())) {
                professorControle.alterar(getDados());
                limparTela();
                mostrarDadosDosProfessores(professorControle.listagem(criterioProf));
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }//GEN-LAST:event_jButtonAlterarProfActionPerformed

    private void jButtonConsultarPorIdProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarPorIdProfActionPerformed
        try {
            /*List<Professor> obj = new LinkedList<Professor>();
            int id = Integer.parseInt(jTextFieldConsultarExcluir.getText());
            obj.add(professorControle.consultarPorID(id));
            mostrarDadosDosProfessores(obj.iterator());*/

            if (!jTextFieldConsultarExcluirProf.getText().equals("DIGITE O ID")) {
                int id = Integer.parseInt(jTextFieldConsultarExcluirProf.getText());
                Professor prof = new Professor();
                prof = professorControle.consultarPorID(id);
                jTextFieldIdentificadorProf.setText(prof.getId() + "");
                jTextFieldMatriculaProf.setText(prof.getMatricula() + "");
                jTextFieldNomeProf.setText(prof.getNome());
                jTextFieldTelefoneProf.setText(prof.getTelefone());
                jTextFieldEmailProf.setText(prof.getEmail());
                jTextFieldEnderecoProf.setText(prof.getEndereco());
                jComboBoxTitulacaoProf.setSelectedItem(prof.getTitulacao());
                jComboBoxEscolaProf.setSelectedItem(prof.getEscola().getNome());
                jTextFieldConsultarExcluirProf.setText("DIGITE O ID");

            } else {
                JOptionPane.showMessageDialog(this, "ID NÃO DIGITADO!");
            }

        } catch (Exception erro) {
            //JOptionPane.showMessageDialog(this, erro.getMessage());
            JOptionPane.showMessageDialog(this, "ID NÃO ENCONTRADO!");
        }
    }//GEN-LAST:event_jButtonConsultarPorIdProfActionPerformed

    private void jButtonExcluirPorIdProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirPorIdProfActionPerformed
        try {
            if (!jTextFieldConsultarExcluirProf.getText().equals("DIGITE O ID")) {
                int id = Integer.parseInt(jTextFieldConsultarExcluirProf.getText());
                professorControle.excluirPorID(id);
                mostrarDadosDosProfessores(professorControle.listagem(criterioProf));
                if (jTextFieldConsultarExcluirProf.getText().equals(jTextFieldIdentificadorProf.getText())) {
                    limparTela();
                }
                jTextFieldConsultarExcluirProf.setText("DIGITE O ID");
            } else {
                JOptionPane.showMessageDialog(this, "ID NÃO DIGITADO!");
            }

        } catch (Exception erro) {
            //JOptionPane.showMessageDialog(this, erro.getMessage());
            JOptionPane.showMessageDialog(this, "ID NÃO ENCONTRADO!");
        }

    }//GEN-LAST:event_jButtonExcluirPorIdProfActionPerformed

    private void jComboBoxEscolaProfAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jComboBoxEscolaProfAncestorAdded
        try {
            Iterator<Escola> listaDeEscolas = escolaControle.listagem(criterioEscola);
            //jComboBoxEscolaProf.removeAll();
            while (listaDeEscolas.hasNext()) {
                jComboBoxEscolaProf.addItem(((Escola) listaDeEscolas.next()).getNome());
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }

    }//GEN-LAST:event_jComboBoxEscolaProfAncestorAdded

    private void jComboBoxTitulacaoProfAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jComboBoxTitulacaoProfAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTitulacaoProfAncestorAdded

    private void jTextFieldTelefoneProfMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldTelefoneProfMouseEntered
        alterarCampoTextField(jTextFieldTelefoneProf, msgCampoTelefone, true, "");
    }//GEN-LAST:event_jTextFieldTelefoneProfMouseEntered

    private void jTextFieldTelefoneProfMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldTelefoneProfMouseExited
        alterarCampoTextField(jTextFieldTelefoneProf, "", false, msgCampoTelefone);
    }//GEN-LAST:event_jTextFieldTelefoneProfMouseExited

    private void jTextFieldConsultarExcluirProfMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldConsultarExcluirProfMouseEntered
        alterarCampoTextField(jTextFieldConsultarExcluirProf, msgCampoID, true, "");
    }//GEN-LAST:event_jTextFieldConsultarExcluirProfMouseEntered

    private void jTextFieldConsultarExcluirProfMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldConsultarExcluirProfMouseExited
        alterarCampoTextField(jTextFieldConsultarExcluirProf, "", false, msgCampoID);
    }//GEN-LAST:event_jTextFieldConsultarExcluirProfMouseExited

    private void jButtonOrdenarProfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOrdenarProfActionPerformed
        try {
            if (!jComboBoxOrdenarProf.getSelectedItem().equals("ORDENAR POR:")) {
                criterioProf = jComboBoxOrdenarProf.getSelectedItem().toString();
                mostrarDadosDosProfessores(professorControle.listagem(criterioProf));
                jComboBoxOrdenarProf.setSelectedIndex(0);
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(this, erro.getMessage());
        }
    }//GEN-LAST:event_jButtonOrdenarProfActionPerformed

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
            java.util.logging.Logger.getLogger(TelaProfessor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaProfessor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaProfessor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaProfessor.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaProfessor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterarProf;
    private javax.swing.JButton jButtonConsultarPorIdProf;
    private javax.swing.JButton jButtonExcluirPorIdProf;
    private javax.swing.JButton jButtonIncluirProf;
    private javax.swing.JButton jButtonLimparDadosProf;
    private javax.swing.JButton jButtonOrdenarProf;
    private javax.swing.JComboBox<String> jComboBoxEscolaProf;
    private javax.swing.JComboBox<String> jComboBoxOrdenarProf;
    private javax.swing.JComboBox<String> jComboBoxTitulacaoProf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEndereco;
    private javax.swing.JLabel jLabelIdentificador;
    private javax.swing.JLabel jLabelMatricula;
    private javax.swing.JLabel jLabelNomeProfessor;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProf;
    private javax.swing.JTextField jTextFieldConsultarExcluirProf;
    private javax.swing.JTextField jTextFieldEmailProf;
    private javax.swing.JTextField jTextFieldEnderecoProf;
    private javax.swing.JTextField jTextFieldIdentificadorProf;
    private javax.swing.JTextField jTextFieldMatriculaProf;
    private javax.swing.JTextField jTextFieldNomeProf;
    private javax.swing.JTextField jTextFieldTelefoneProf;
    // End of variables declaration//GEN-END:variables
}
