/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package mvc.vista;

import java.util.ArrayList;
import javax.swing.JButton;
import mvc.controlador.ControladorProcesadora;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import logica.Fachada;
import logica.modelo.ProcesadoraPedidos;
import logica.modelo.Gestor;
import logica.modelo.Pedido;
import logica.observador.Observable;
import mvc.IVistaProcesadora;

/**
 *
 * @author Sebastian
 */
public class VistaProcesadoraPedidos extends javax.swing.JDialog implements IVistaProcesadora {

    private ControladorProcesadora controlador;
    private ArrayList<Pedido> pedidosPendientesVista;
    private ArrayList<Pedido> pedidosEnCursoVista;
    
    /**
     * Creates new form GUIProcesadoraPedidos
     */
    public VistaProcesadoraPedidos(java.awt.Frame parent, boolean modal, Gestor gestorActual,
            ProcesadoraPedidos procesadora) {
        super(parent, modal);
        initComponents();
        controlador = new ControladorProcesadora(gestorActual,procesadora, this);       
    }

    public void initLabels(Gestor g, ProcesadoraPedidos p) {
        lblGestor.setText("Gestor: " + g.getNombreUsuario());
        lblProcesadora.setText("Unidad Procesadora: " + p.getNombre());
    }
    
    @Override
    public void actualizarPedidosPendientes(ArrayList<Pedido> pedidos) {
         pedidosPendientesVista = pedidos;
         actualizarTablaGeneric(pedidos, tblPedidosPendientes);
    }
    
    @Override
    public void actualizarPedidosEnCurso(ArrayList<Pedido> pedidos) {
        pedidosEnCursoVista = pedidos;
        actualizarTablaGeneric(pedidos, tblPedidosCurso);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMonitorPedidosTitle = new javax.swing.JLabel();
        lblGestor = new javax.swing.JLabel();
        lblProcesadora = new javax.swing.JLabel();
        scrollPanePedidos = new javax.swing.JScrollPane();
        tblPedidosPendientes = new javax.swing.JTable();
        btnTomarPedido = new javax.swing.JButton();
        btnFinalizarPedido = new javax.swing.JButton();
        lblPedidosPendientes = new javax.swing.JLabel();
        scrollPanePedidos1 = new javax.swing.JScrollPane();
        tblPedidosCurso = new javax.swing.JTable();
        lblPedidosCurso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblMonitorPedidosTitle.setFont(new java.awt.Font("Segoe UI", 2, 16)); // NOI18N
        lblMonitorPedidosTitle.setText("Monitor de Pedidos");

        lblGestor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblGestor.setText("Gestor: {{nombreGestor}}");

        lblProcesadora.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblProcesadora.setText("Unidad Procesadora: {{nombreUnidadProcesadora}}");

        tblPedidosPendientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Papa fritas", "2", "Papa fritas noisette", "11", "Julio", "Esperando"},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre Producto", "Cantidad", "Descripcion", "N° Mesa", "Mozo ", "Estado"
            }
        ));
        tblPedidosPendientes.setCellSelectionEnabled(false);
        tblPedidosPendientes.setRowSelectionAllowed(true);
        scrollPanePedidos.setViewportView(tblPedidosPendientes);
        tblPedidosPendientes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btnTomarPedido.setText("Tomar Pedido");
        btnTomarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTomarPedidoActionPerformed(evt);
            }
        });

        btnFinalizarPedido.setText("Finalizar Pedido");
        btnFinalizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarPedidoActionPerformed(evt);
            }
        });

        lblPedidosPendientes.setText("Pedidos Pendientes");

        tblPedidosCurso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Hamburguesa", "1", "Hamburguesa de a casa Jugosa", "4", "Pepe", "Procesando"},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre Producto", "Cantidad", "Descripcion", "N° Mesa", "Mozo ", "Estado"
            }
        ));
        scrollPanePedidos1.setViewportView(tblPedidosCurso);
        tblPedidosCurso.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        lblPedidosCurso.setText("Pedidos en proceso");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollPanePedidos)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblMonitorPedidosTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTomarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnFinalizarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(scrollPanePedidos1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPedidosCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblGestor, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(66, 66, 66)
                                .addComponent(lblProcesadora, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblPedidosPendientes, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 35, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGestor)
                    .addComponent(lblProcesadora))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnFinalizarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTomarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblMonitorPedidosTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPedidosPendientes)
                .addGap(9, 9, 9)
                .addComponent(scrollPanePedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPedidosCurso)
                .addGap(9, 9, 9)
                .addComponent(scrollPanePedidos1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTomarPedidoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTomarPedidoActionPerformed
        int rowSel = tblPedidosPendientes.getSelectedRow();
        Pedido p = rowSel>=0 ? pedidosPendientesVista.get(rowSel) : null;
        controlador.prepararPedido(p); 
    }// GEN-LAST:event_btnTomarPedidoActionPerformed

    private void btnFinalizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnFinalizarPedidoActionPerformed
        int rowSel = tblPedidosCurso.getSelectedRow();
        Pedido p = rowSel>=0 ? pedidosEnCursoVista.get(rowSel) : null;
        controlador.finalizarPedido(p);
        
    }// GEN-LAST:event_btnFinalizarPedidoActionPerformed
    
    private void actualizarTablaGeneric(ArrayList<Pedido> lista, JTable tbl){
        String[] columnNames = {"Producto", "Cantidad",
        "Descripcion", "N° Mesa", "Mozo"};
        ArrayList<Object[]> data = new ArrayList<Object[]>();

        for (Pedido pedido : lista) {
            data.add(new Object[]{
                pedido.getProducto().getNombre(),
                pedido.getCantidad(),
                pedido.getDescripcion(),
                pedido.getServicio().getMesa().getNumero(),
                pedido.getServicio().getMesa().getMozo().getNombreCompleto()
            });
        }
        TableModelCustom model = new TableModelCustom(columnNames, data);
        tbl.setModel(model);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizarPedido;
    private javax.swing.JButton btnTomarPedido;
    private javax.swing.JLabel lblGestor;
    private javax.swing.JLabel lblMonitorPedidosTitle;
    private javax.swing.JLabel lblPedidosCurso;
    private javax.swing.JLabel lblPedidosPendientes;
    private javax.swing.JLabel lblProcesadora;
    private javax.swing.JScrollPane scrollPanePedidos;
    private javax.swing.JScrollPane scrollPanePedidos1;
    private javax.swing.JTable tblPedidosCurso;
    private javax.swing.JTable tblPedidosPendientes;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarError(String mensaje) {
       JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
    }



    

   

    
}
