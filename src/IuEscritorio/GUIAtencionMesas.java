/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package IuEscritorio;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import logica.ProcesadoraPedidos;
import logica.observador.Observable;

/**
 *
 * @author Sebastian
 */
public class GUIAtencionMesas extends javax.swing.JDialog implements logica.observador.Observador {

    /**
     * Creates new form GUIAtencionMesas
     */
    public GUIAtencionMesas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        lblCodigo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnAbrirMesa = new javax.swing.JButton();
        btnCerrarMesa = new javax.swing.JButton();
        btnTransferirMesa = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtCodigoProducto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDescripcionProducto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCantidadProducto = new javax.swing.JTextField();
        btnAgregarProducto = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        pnlMesa1 = new javax.swing.JPanel();
        lblMesa1 = new javax.swing.JLabel();
        pnlMesa4 = new javax.swing.JPanel();
        lblMesa4 = new javax.swing.JLabel();
        pnlMesa2 = new javax.swing.JPanel();
        lblMesa2 = new javax.swing.JLabel();
        pnlMesa5 = new javax.swing.JPanel();
        lblMesa5 = new javax.swing.JLabel();
        pnlMesa3 = new javax.swing.JPanel();
        lblMesa3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("App Atencion de Mesas");

        lblCodigo.setText("Codigo");

        jLabel2.setText("Mesa 5");

        btnAbrirMesa.setText("Abrir");

        btnCerrarMesa.setText("Cerrar");

        btnTransferirMesa.setText("Transferir");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAbrirMesa)
                    .addComponent(btnTransferirMesa)
                    .addComponent(btnCerrarMesa))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(btnAbrirMesa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTransferirMesa)
                .addGap(18, 18, 18)
                .addComponent(btnCerrarMesa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"2", "Chivito Con fritas", "10", "20", "A punto sin cebolla"},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cantidad", "Descripcion", "Precio Unitario", "SubTotal", "Comentarios"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jLabel3.setText("Descripcion");

        jLabel4.setText("Cantidad");

        btnAgregarProducto.setText("Agregar Producto");

        pnlMesa1.setBackground(new java.awt.Color(0, 153, 0));
        pnlMesa1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlMesa1.setForeground(new java.awt.Color(0, 0, 0));
        pnlMesa1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlMesa1MouseClicked(evt);
            }
        });

        lblMesa1.setForeground(new java.awt.Color(255, 255, 255));
        lblMesa1.setText("Mesa 1");

        javax.swing.GroupLayout pnlMesa1Layout = new javax.swing.GroupLayout(pnlMesa1);
        pnlMesa1.setLayout(pnlMesa1Layout);
        pnlMesa1Layout.setHorizontalGroup(
            pnlMesa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMesa1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblMesa1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        pnlMesa1Layout.setVerticalGroup(
            pnlMesa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMesa1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(lblMesa1)
                .addGap(26, 26, 26))
        );

        pnlMesa4.setBackground(new java.awt.Color(153, 0, 0));
        pnlMesa4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlMesa4.setForeground(new java.awt.Color(0, 0, 0));
        pnlMesa4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlMesa4MouseClicked(evt);
            }
        });

        lblMesa4.setForeground(new java.awt.Color(255, 255, 255));
        lblMesa4.setText("Mesa 4");

        javax.swing.GroupLayout pnlMesa4Layout = new javax.swing.GroupLayout(pnlMesa4);
        pnlMesa4.setLayout(pnlMesa4Layout);
        pnlMesa4Layout.setHorizontalGroup(
            pnlMesa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMesa4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblMesa4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        pnlMesa4Layout.setVerticalGroup(
            pnlMesa4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMesa4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblMesa4)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pnlMesa2.setBackground(new java.awt.Color(0, 153, 0));
        pnlMesa2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlMesa2.setForeground(new java.awt.Color(0, 0, 0));
        pnlMesa2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlMesa2MouseClicked(evt);
            }
        });

        lblMesa2.setForeground(new java.awt.Color(255, 255, 255));
        lblMesa2.setText("Mesa 2");

        javax.swing.GroupLayout pnlMesa2Layout = new javax.swing.GroupLayout(pnlMesa2);
        pnlMesa2.setLayout(pnlMesa2Layout);
        pnlMesa2Layout.setHorizontalGroup(
            pnlMesa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMesa2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblMesa2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        pnlMesa2Layout.setVerticalGroup(
            pnlMesa2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMesa2Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(lblMesa2)
                .addGap(26, 26, 26))
        );

        pnlMesa5.setBackground(new java.awt.Color(153, 0, 0));
        pnlMesa5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlMesa5.setForeground(new java.awt.Color(0, 0, 0));
        pnlMesa5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlMesa5MouseClicked(evt);
            }
        });

        lblMesa5.setForeground(new java.awt.Color(255, 255, 255));
        lblMesa5.setText("Mesa 5");

        javax.swing.GroupLayout pnlMesa5Layout = new javax.swing.GroupLayout(pnlMesa5);
        pnlMesa5.setLayout(pnlMesa5Layout);
        pnlMesa5Layout.setHorizontalGroup(
            pnlMesa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMesa5Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblMesa5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        pnlMesa5Layout.setVerticalGroup(
            pnlMesa5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMesa5Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(lblMesa5)
                .addGap(24, 24, 24))
        );

        pnlMesa3.setBackground(new java.awt.Color(153, 0, 0));
        pnlMesa3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlMesa3.setForeground(new java.awt.Color(0, 0, 0));
        pnlMesa3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlMesa3MouseClicked(evt);
            }
        });

        lblMesa3.setForeground(new java.awt.Color(255, 255, 255));
        lblMesa3.setText("Mesa 3");

        javax.swing.GroupLayout pnlMesa3Layout = new javax.swing.GroupLayout(pnlMesa3);
        pnlMesa3.setLayout(pnlMesa3Layout);
        pnlMesa3Layout.setHorizontalGroup(
            pnlMesa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMesa3Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(lblMesa3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        pnlMesa3Layout.setVerticalGroup(
            pnlMesa3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMesa3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMesa3)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlMesa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(pnlMesa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(pnlMesa3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(pnlMesa4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(pnlMesa5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlMesa3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlMesa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlMesa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlMesa5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlMesa4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Mozo: {{Nombre Mozo}}");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(txtDescripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnAgregarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtDescripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pressPanel(JPanel pnl) {
        unPressPanels();
        pnl.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
    }

    private void unPressPanels() {
        this.pnlMesa1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.pnlMesa2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.pnlMesa3.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.pnlMesa4.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.pnlMesa5.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

    }
    private void pnlMesa1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMesa1MouseClicked
        pressPanel(this.pnlMesa1);
    }//GEN-LAST:event_pnlMesa1MouseClicked

    private void pnlMesa2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMesa2MouseClicked

        pressPanel(this.pnlMesa2);
    }//GEN-LAST:event_pnlMesa2MouseClicked

    private void pnlMesa3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMesa3MouseClicked

        pressPanel(this.pnlMesa3);
    }//GEN-LAST:event_pnlMesa3MouseClicked

    private void pnlMesa4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMesa4MouseClicked

        pressPanel(this.pnlMesa4);
    }//GEN-LAST:event_pnlMesa4MouseClicked

    private void pnlMesa5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlMesa5MouseClicked

        pressPanel(this.pnlMesa5);
    }//GEN-LAST:event_pnlMesa5MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirMesa;
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnCerrarMesa;
    private javax.swing.JButton btnTransferirMesa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblMesa1;
    private javax.swing.JLabel lblMesa2;
    private javax.swing.JLabel lblMesa3;
    private javax.swing.JLabel lblMesa4;
    private javax.swing.JLabel lblMesa5;
    private javax.swing.JPanel pnlMesa1;
    private javax.swing.JPanel pnlMesa2;
    private javax.swing.JPanel pnlMesa3;
    private javax.swing.JPanel pnlMesa4;
    private javax.swing.JPanel pnlMesa5;
    private javax.swing.JTextField txtCantidadProducto;
    private javax.swing.JTextField txtCodigoProducto;
    private javax.swing.JTextField txtDescripcionProducto;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento.equals(ProcesadoraPedidos.eventos.agregarPedido)){
            
        }
    }

}
