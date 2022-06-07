/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package mvc.vista;

import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Fachada;
import logica.excepciones.LogicException;
import logica.modelo.Mesa;
import logica.modelo.Mozo;
import logica.modelo.Producto;
import logica.modelo.Transferencia;

/**
 *
 * @author Sebastian
 */
public class DialogMozosTransferir extends javax.swing.JDialog {
    Mozo mozoOrigen;
    Mesa mesaActual;
    
    VistaAtencionMesas vistaOriginal;
    /**
     * Creates new form DialogMozosTransferir
     */
    public DialogMozosTransferir(java.awt.Frame parent, boolean modal, Mozo mozoOrigen,Mesa mesaActual) {
        super(parent, modal);
        initComponents();
        
        this.vistaOriginal = (VistaAtencionMesas)parent;
        
        this.mozoOrigen = mozoOrigen;
        this.mesaActual = mesaActual;
        
        cbxMozosTransferir.removeAllItems();
        for (Mozo m : Fachada.getInstancia().getMozosAptosTransferir(mozoOrigen)) {
            cbxMozosTransferir.addItem(m);
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

        jLabel1 = new javax.swing.JLabel();
        cbxMozosTransferir = new javax.swing.JComboBox<>();
        btnSolicitarTransferencia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Transferir Mesa A: ");
        setModal(true);

        jLabel1.setText("Mozos");

        btnSolicitarTransferencia.setText("Solicitar");
        btnSolicitarTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarTransferenciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxMozosTransferir, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSolicitarTransferencia)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxMozosTransferir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSolicitarTransferencia))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSolicitarTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarTransferenciaActionPerformed
        Object o = cbxMozosTransferir.getSelectedItem();
        if (o!= null) {
            Mozo mozoDestino = (Mozo)o;
            Transferencia transf= new Transferencia(mozoOrigen, mesaActual, mozoDestino);
            transf.avisarMozoDestino();
            this.dispose();
        }
        else {
            this.vistaOriginal.mostrarAlerta("Debe seleccionar un mozo");
        }
    }//GEN-LAST:event_btnSolicitarTransferenciaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSolicitarTransferencia;
    private javax.swing.JComboBox<Mozo> cbxMozosTransferir;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
