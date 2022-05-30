/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package IuEscritorio;

import mvc.vista.VistaProcesadoraPedidos;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import logica.Fachada;
import logica.modelo.ProcesadoraPedidos;
import logica.modelo.Gestor;

/**
 *
 * @author Sebastian
 */
public class DialogSeleccionarProcesadora extends javax.swing.JDialog {

    private final Gestor gestorActual;

    /**
     * Creates new form DialogSeleccionarProcesadora
     */
    public DialogSeleccionarProcesadora(java.awt.Frame parent, boolean modal,Gestor gestor) {
        super(parent, modal);
        initComponents();
        
        this.gestorActual = gestor;
        
        
        ProcesadoraPedidos[] procesadoras =  Fachada.getInstancia().getProcesadoras().toArray(ProcesadoraPedidos[]::new);
        DefaultComboBoxModel cboBoxModel = 
                new DefaultComboBoxModel<ProcesadoraPedidos>(procesadoras);
        
        this.cbxProcesadora.setModel(cboBoxModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbxProcesadora = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Seleccionar Procesadora");

        jLabel1.setText("Procesadora");

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxProcesadora, 0, 205, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxProcesadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConfirmar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        ProcesadoraPedidos procesadoraSeleccionada = (ProcesadoraPedidos)this.cbxProcesadora.getSelectedItem();
        
        gestorActual.asignarProcesadora(procesadoraSeleccionada);
        procesadoraSeleccionada.agregarGestor(gestorActual);
        
        JDialog d = new VistaProcesadoraPedidos(null, false, gestorActual,procesadoraSeleccionada);
        d.setVisible(true);
        d.setLocationRelativeTo(null);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnConfirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JComboBox<ProcesadoraPedidos> cbxProcesadora;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
