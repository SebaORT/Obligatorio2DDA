package mvc.vista;

import mvc.controlador.ControladorAtencionMesa;
import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import logica.Fachada;
import logica.modelo.ProcesadoraPedidos;
import logica.excepciones.LogicException;
import logica.modelo.Mesa;
import logica.modelo.Mozo;
import logica.modelo.Pedido;
import logica.modelo.Producto;
import logica.modelo.Transferencia;
import logica.observador.Observable;
import mvc.IVistaAtencionMesa;

/**
 *
 * @author Sebastian
 */
public class VistaAtencionMesas extends javax.swing.JFrame implements IVistaAtencionMesa {

    private ControladorAtencionMesa controlador;
    private final JPanel[] panelsMesasButtons = new JPanel[5];
    private final JLabel[] labelMesas = new JLabel[5];
    private int indexMesaSeleccionada = -1;
    private String[] columnNames = { "Producto", "Cantidad",
            "Precio Unitario", "SubTotal", "Estado","Gestor" };
    private ArrayList<Mesa> mesasMozoVista;
    
    private Mozo mozoActual;
    

    /**
     * Creates new form GUIAtencionMesas
     */
    public VistaAtencionMesas( Mozo mozo) {
        initComponents();

        this.mozoActual = mozo;
        controlador = new ControladorAtencionMesa(mozo, this);
    }

    public void mostrarInfoPedidoListo(Pedido pedido) {
        this.mostrarMensaje(pedido.toString());
    }

    public void initLabels(Mozo mozo) {
        lblMozo.setText("Mozo: " + mozo.getNombreCompleto());
        lblMontoTotal.setText("Monto: 0");
    }

    public void solicitacionTransferencia(Transferencia transf) {
        Mozo mozoOrigen = transf.getMozoOrigen();
        Mesa mesaOrigen = transf.getMesa();
        String abiertaStr = mesaOrigen.isAbierta() ? "Si" : "No";
         int result = JOptionPane.
                 showConfirmDialog(this, 
                         "Transferencia recibida de mesa : (N°:"+ mesaOrigen.getNumero()+"-Abierta: "+abiertaStr+") "+
                                 " | Mozo Origen: "+mozoOrigen.getNombreCompleto());
         if (result == JOptionPane.YES_OPTION) {
               controlador.realizarTransferencia();
         }
         else {
             controlador.avisarTransferenciaDenegada();
         }
         
    }
    
    public void initMesasUI(ArrayList<Mesa> mesasMozo) {
        panelsMesasButtons[0] = pnlMesa1;
        panelsMesasButtons[1] = pnlMesa2;
        panelsMesasButtons[2] = pnlMesa3;
        panelsMesasButtons[3] = pnlMesa4;
        panelsMesasButtons[4] = pnlMesa5;
        labelMesas[0] = lblMesa1;
        labelMesas[1] = lblMesa2;
        labelMesas[2] = lblMesa3;
        labelMesas[3] = lblMesa4;
        labelMesas[4] = lblMesa5;

        
        mesasMozoVista = mesasMozo;
        int i = 0;
        for (Mesa mesa : mesasMozo) {
            if (mesa.isAbierta()) {
                setMesaAbierta(mesa);
            } else { // mesa cerrada
                setMesaCerrada(mesa);
            }
            labelMesas[i].setText(mesa.toString());
              panelsMesasButtons[i].setEnabled(true);
            i++;
        }

        for (int j = i; j < 5; j++) {
            // mesa no asignada al mozo
            panelsMesasButtons[j].setBackground(new Color(153, 153, 153));// gray
            panelsMesasButtons[j].setEnabled(false);
            labelMesas[j].setText("N/A");
            unPressPanel(j);
        }
    }
    
    private void unPressPanel(int i) {
        panelsMesasButtons[i].setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }

    public void setMesaAbierta(Mesa m) {
        int i = mesasMozoVista.indexOf(m);
        panelsMesasButtons[i].setBackground(new Color(0, 153, 0)); // green
    }

    public void setMesaCerrada(Mesa m) {
        int i = mesasMozoVista.indexOf(m);
        panelsMesasButtons[i].setBackground(new Color(153, 0, 0));// red
    }

    public void updateListaProductos(ArrayList<Producto> productos) {
        cbxProducto.removeAllItems();
        for (Producto producto : productos) {
            cbxProducto.addItem(producto);
        }
    }

    public void updateServicioActual(ArrayList<Pedido> servicioActual) {
        ArrayList<Object[]> data = new ArrayList<Object[]>();
        Mesa mesaSeleccionada = indexMesaSeleccionada !=-1 ? this.mesasMozoVista.get(indexMesaSeleccionada) : null;
        for (Pedido pedido : servicioActual) {            
            if (pedido.esMiMesa(mesaSeleccionada))
            {
                data.add(new Object[] {
                        pedido.getProducto().getNombre(),
                        pedido.getCantidad(),
                        pedido.getProducto().getPrecio(),
                        pedido.getMontoPedido(),
                        pedido.getEstado().name(),
                        pedido.getGestor()
                });
            }
        }

        TableModelCustom model = new TableModelCustom(columnNames, data);
        tblServicioActual.setModel(model);
    }

    public void mostrarExceptionError(Exception ex) {
        Logger.getLogger(VistaAtencionMesas.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void mostrarAlerta(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "INFO",
                JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void cerrar() {
        this.setVisible(false);
        this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblProducto = new javax.swing.JLabel();
        pnlAccionesMesas = new javax.swing.JPanel();
        lblMesaSeleccionada = new javax.swing.JLabel();
        btnAbrirMesa = new javax.swing.JButton();
        btnCerrarMesa = new javax.swing.JButton();
        btnTransferirMesa = new javax.swing.JButton();
        paneServicio = new javax.swing.JScrollPane();
        tblServicioActual = new javax.swing.JTable();
        lblDescripProducto = new javax.swing.JLabel();
        txtDescripcionProducto = new javax.swing.JTextField();
        lblCantidad = new javax.swing.JLabel();
        btnAgregarProducto = new javax.swing.JButton();
        pnlMesas = new javax.swing.JPanel();
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
        lblMozo = new javax.swing.JLabel();
        lblServicioParaMesa = new javax.swing.JLabel();
        spnCantidad = new javax.swing.JSpinner();
        lblMontoTotal = new javax.swing.JLabel();
        cbxProducto = new javax.swing.JComboBox<>();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("App Atencion de Mesas");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblProducto.setText("Producto");

        lblMesaSeleccionada.setText("Mesa 5");

        btnAbrirMesa.setText("Abrir");
        btnAbrirMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirMesaActionPerformed(evt);
            }
        });

        btnCerrarMesa.setText("Cerrar");
        btnCerrarMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarMesaActionPerformed(evt);
            }
        });

        btnTransferirMesa.setText("Transferir");
        btnTransferirMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferirMesaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAccionesMesasLayout = new javax.swing.GroupLayout(pnlAccionesMesas);
        pnlAccionesMesas.setLayout(pnlAccionesMesasLayout);
        pnlAccionesMesasLayout.setHorizontalGroup(
            pnlAccionesMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAccionesMesasLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlAccionesMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblMesaSeleccionada, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTransferirMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrarMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAbrirMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        pnlAccionesMesasLayout.setVerticalGroup(
            pnlAccionesMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAccionesMesasLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblMesaSeleccionada)
                .addGap(18, 18, 18)
                .addComponent(btnAbrirMesa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTransferirMesa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCerrarMesa)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        tblServicioActual.setModel(new javax.swing.table.DefaultTableModel(
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
        paneServicio.setViewportView(tblServicioActual);

        lblDescripProducto.setText("Descripcion");

        lblCantidad.setText("Cantidad");

        btnAgregarProducto.setText("Agregar Producto al Servicio");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        pnlMesa1.setBackground(new java.awt.Color(0, 153, 0));
        pnlMesa1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlMesa1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlMesa1MouseClicked(evt);
            }
        });

        lblMesa1.setForeground(new java.awt.Color(255, 255, 255));
        lblMesa1.setText("Mesa 1");
        lblMesa1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMesa1MouseClicked(evt);
            }
        });

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
        pnlMesa4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlMesa4MouseClicked(evt);
            }
        });

        lblMesa4.setForeground(new java.awt.Color(255, 255, 255));
        lblMesa4.setText("Mesa 4");
        lblMesa4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMesa4MouseClicked(evt);
            }
        });

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
        pnlMesa2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlMesa2MouseClicked(evt);
            }
        });

        lblMesa2.setForeground(new java.awt.Color(255, 255, 255));
        lblMesa2.setText("Mesa 2");
        lblMesa2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMesa2MouseClicked(evt);
            }
        });

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

        pnlMesa5.setBackground(new java.awt.Color(153, 153, 153));
        pnlMesa5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlMesa5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlMesa5MouseClicked(evt);
            }
        });

        lblMesa5.setForeground(new java.awt.Color(255, 255, 255));
        lblMesa5.setText("Mesa 5");
        lblMesa5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMesa5MouseClicked(evt);
            }
        });

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
        pnlMesa3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlMesa3MouseClicked(evt);
            }
        });

        lblMesa3.setForeground(new java.awt.Color(255, 255, 255));
        lblMesa3.setText("Mesa 3");
        lblMesa3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMesa3MouseClicked(evt);
            }
        });

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

        javax.swing.GroupLayout pnlMesasLayout = new javax.swing.GroupLayout(pnlMesas);
        pnlMesas.setLayout(pnlMesasLayout);
        pnlMesasLayout.setHorizontalGroup(
            pnlMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMesasLayout.createSequentialGroup()
                .addGroup(pnlMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMesasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlMesa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(pnlMesa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(pnlMesa3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMesasLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(pnlMesa4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(pnlMesa5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        pnlMesasLayout.setVerticalGroup(
            pnlMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMesasLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlMesa3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlMesasLayout.createSequentialGroup()
                        .addGroup(pnlMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlMesa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlMesa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlMesa5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlMesa4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        lblMozo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMozo.setText("Mozo: {{Nombre Mozo}}");

        lblServicioParaMesa.setText("Servicio para {{mesa}}");

        spnCantidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnCantidadStateChanged(evt);
            }
        });

        lblMontoTotal.setText("Monto Total:  {{monto}}");

        btnLogout.setText("Log Out");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblServicioParaMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(paneServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblDescripProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtDescripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(lblCantidad)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(cbxProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addComponent(btnAgregarProducto))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblMozo, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(305, 305, 305)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(pnlAccionesMesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(0, 7, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMozo)
                    .addComponent(btnLogout))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlAccionesMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblProducto)
                            .addComponent(cbxProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDescripProducto)
                            .addComponent(txtDescripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCantidad)
                            .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnAgregarProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblServicioParaMesa)
                    .addComponent(lblMontoTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneServicio, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        controlador.logout();
    }//GEN-LAST:event_formWindowClosing

    private void btnAbrirMesaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAbrirMesaActionPerformed
        controlador.AbrirMesa(mesasMozoVista.get(indexMesaSeleccionada));
    }// GEN-LAST:event_btnAbrirMesaActionPerformed

    private void btnCerrarMesaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCerrarMesaActionPerformed
        controlador.CerrarMesa(mesasMozoVista.get(indexMesaSeleccionada));
    }// GEN-LAST:event_btnCerrarMesaActionPerformed

    private void btnTransferirMesaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTransferirMesaActionPerformed
        
        Mesa mesaActual = this.mesasMozoVista.get(this.indexMesaSeleccionada);
        JDialog d = new DialogMozosTransferir(this, true, this.mozoActual, mesaActual);

        d.pack();
        d.setLocationRelativeTo(this);
         d.setVisible(true);
        
    }// GEN-LAST:event_btnTransferirMesaActionPerformed

    private void updateMesaActual(JPanel pnl, int index) {
        if (pnl.isEnabled()) {
            this.indexMesaSeleccionada = index - 1;
            unPressPanels();
            pnl.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));

            Component comp = panelsMesasButtons[index - 1].getComponent(0);
            JLabel label = comp != null ? (JLabel) comp : null;

            if (label != null) {
                lblMesaSeleccionada.setText(label.getText());
                lblServicioParaMesa.setText("Servicio para " + label.getText());
            }

          controlador.UpdateServicioActual(mesasMozoVista.get(indexMesaSeleccionada));
        }
        
        
    }


    private void unPressPanels() {
        this.pnlMesa1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.pnlMesa2.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.pnlMesa3.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.pnlMesa4.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.pnlMesa5.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

    }

    private void pnlMesa1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_pnlMesa1MouseClicked
        updateMesaActual(this.pnlMesa1, 1);
    }// GEN-LAST:event_pnlMesa1MouseClicked

    private void pnlMesa2MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_pnlMesa2MouseClicked

        updateMesaActual(this.pnlMesa2, 2);

    }// GEN-LAST:event_pnlMesa2MouseClicked

    private void pnlMesa3MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_pnlMesa3MouseClicked
        updateMesaActual(this.pnlMesa3, 3);
    }// GEN-LAST:event_pnlMesa3MouseClicked

    private void pnlMesa4MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_pnlMesa4MouseClicked
        updateMesaActual(this.pnlMesa4, 4);
    }// GEN-LAST:event_pnlMesa4MouseClicked

    private void pnlMesa5MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_pnlMesa5MouseClicked
        updateMesaActual(this.pnlMesa5, 5);
    }// GEN-LAST:event_pnlMesa5MouseClicked

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAgregarProductoActionPerformed

        Object o = cbxProducto.getSelectedItem();
        int cantidad = (Integer) spnCantidad.getValue();
        String description = txtDescripcionProducto.getText();
        Producto prod = o != null ? (Producto) o : null;
        Mesa m = indexMesaSeleccionada!= -1 ? mesasMozoVista.get(indexMesaSeleccionada) : null;
        controlador.agregarProductoAlServicio(m, prod, cantidad, description);

    }// GEN-LAST:event_btnAgregarProductoActionPerformed

    private void lblMesa1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblMesa1MouseClicked
        pnlMesa1MouseClicked(evt);
    }// GEN-LAST:event_lblMesa1MouseClicked

    private void lblMesa2MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblMesa2MouseClicked
        pnlMesa2MouseClicked(evt);
    }// GEN-LAST:event_lblMesa2MouseClicked

    private void lblMesa3MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblMesa3MouseClicked
        pnlMesa3MouseClicked(evt);
    }// GEN-LAST:event_lblMesa3MouseClicked

    private void lblMesa4MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblMesa4MouseClicked
        pnlMesa4MouseClicked(evt);
    }// GEN-LAST:event_lblMesa4MouseClicked

    private void lblMesa5MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_lblMesa5MouseClicked
        pnlMesa5MouseClicked(evt);
    }// GEN-LAST:event_lblMesa5MouseClicked

    private void spnCantidadStateChanged(javax.swing.event.ChangeEvent evt) {// GEN-FIRST:event_spnCantidadStateChanged
        if ((Integer) spnCantidad.getValue() < 0) {
            spnCantidad.setValue(0);
        }
    }// GEN-LAST:event_spnCantidadStateChanged

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {
        controlador.logout();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirMesa;
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnCerrarMesa;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnTransferirMesa;
    private javax.swing.JComboBox<Producto> cbxProducto;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblDescripProducto;
    private javax.swing.JLabel lblMesa1;
    private javax.swing.JLabel lblMesa2;
    private javax.swing.JLabel lblMesa3;
    private javax.swing.JLabel lblMesa4;
    private javax.swing.JLabel lblMesa5;
    private javax.swing.JLabel lblMesaSeleccionada;
    private javax.swing.JLabel lblMontoTotal;
    private javax.swing.JLabel lblMozo;
    private javax.swing.JLabel lblProducto;
    private javax.swing.JLabel lblServicioParaMesa;
    private javax.swing.JScrollPane paneServicio;
    private javax.swing.JPanel pnlAccionesMesas;
    private javax.swing.JPanel pnlMesa1;
    private javax.swing.JPanel pnlMesa2;
    private javax.swing.JPanel pnlMesa3;
    private javax.swing.JPanel pnlMesa4;
    private javax.swing.JPanel pnlMesa5;
    private javax.swing.JPanel pnlMesas;
    private javax.swing.JSpinner spnCantidad;
    private javax.swing.JTable tblServicioActual;
    private javax.swing.JTextField txtDescripcionProducto;
    // End of variables declaration//GEN-END:variables

}
