package ec.edu.puce.facturacion.Vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

import ec.edu.puce.facturacion.Cliente;
import ec.edu.puce.facturacion.Infoclientes;
import ec.edu.puce.facturacion.Producto;
import ec.edu.puce.facturacion.Infoproductos;

public class FrmFactura extends JInternalFrame {
    private JTextField txtNombreCliente;
    private JTextField txtCedula;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtCantidad;
    private JTable table;
    private DefaultTableModel model;
    private Infoclientes infoclientes;
    private Infoproductos infoproductos;
    private JLabel lblSubtotal, lblIVA, lblTotal;
    private JLabel lblNumFactura;
    private JTextField textFecha;
    private JDesktopPane desktopPane;

    public FrmFactura(Infoclientes infoclientes, Infoproductos infoproductos) {
        setClosable(true);
        setResizable(true);
        this.infoclientes = infoclientes;
        this.infoproductos = infoproductos;
        initialize();
    }

    private void initialize() {
        setTitle("Facturación");
        setBounds(0, 0, 800, 650);
        getContentPane().setLayout(null);

        JLabel lblFechaText = new JLabel("Fecha:");
        lblFechaText.setBounds(498, 20, 70, 15);
        getContentPane().add(lblFechaText);

        JLabel lblNombreCliente = new JLabel("Nombre:");
        lblNombreCliente.setBounds(12, 20, 70, 15);
        getContentPane().add(lblNombreCliente);

        txtNombreCliente = new JTextField();
        txtNombreCliente.setBounds(100, 18, 200, 19);
        getContentPane().add(txtNombreCliente);
        txtNombreCliente.setColumns(10);

        JButton btnBuscarCliente = new JButton("Buscar Cliente");
        btnBuscarCliente.setBounds(310, 15, 150, 25);
        btnBuscarCliente.setBackground(new Color(153, 193, 241));
        getContentPane().add(btnBuscarCliente);

        btnBuscarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarCliente();
            }
        });

        JLabel lblCedula = new JLabel("Cedula/RUC:");
        lblCedula.setBounds(12, 60, 80, 15);
        getContentPane().add(lblCedula);

        txtCedula = new JTextField();
        txtCedula.setBounds(100, 58, 200, 19);
        getContentPane().add(txtCedula);
        txtCedula.setColumns(10);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(12, 100, 70, 15);
        getContentPane().add(lblDireccion);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(100, 98, 200, 19);
        getContentPane().add(txtDireccion);
        txtDireccion.setColumns(10);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setBounds(12, 140, 70, 15);
        getContentPane().add(lblTelefono);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(100, 138, 200, 19);
        getContentPane().add(txtTelefono);
        txtTelefono.setColumns(10);

        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setBounds(12, 180, 70, 15);
        getContentPane().add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(100, 178, 200, 19);
        getContentPane().add(txtCantidad);
        txtCantidad.setColumns(10);

        JButton btnAgregarProducto = new JButton("Añadir Producto");
        btnAgregarProducto.setBounds(310, 55, 150, 25);
        btnAgregarProducto.setBackground(new Color(143, 240, 164));
        getContentPane().add(btnAgregarProducto);

        JButton btnEliminarProducto = new JButton("Quitar Producto");
        btnEliminarProducto.setBounds(310, 95, 150, 25);
        btnEliminarProducto.setBackground(new Color(246, 97, 81));
        getContentPane().add(btnEliminarProducto);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 220, 780, 200);
        getContentPane().add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] { "Cod", "Detalle", "Precio", "Cantidad", "IVA", "Total" }
        ));
        scrollPane.setViewportView(table);
        model = (DefaultTableModel) table.getModel();

        JLabel lblSubtotalText = new JLabel("SUBTOTAL:");
        lblSubtotalText.setBounds(12, 440, 100, 15);
        getContentPane().add(lblSubtotalText);

        lblSubtotal = new JLabel("0.00");
        lblSubtotal.setBounds(120, 440, 100, 15);
        getContentPane().add(lblSubtotal);

        JLabel lblIVAText = new JLabel("I.V.A:");
        lblIVAText.setBounds(12, 470, 100, 15);
        getContentPane().add(lblIVAText);

        lblIVA = new JLabel("0.00");
        lblIVA.setBounds(120, 470, 100, 15);
        getContentPane().add(lblIVA);

        JLabel lblTotalText = new JLabel("TOTAL:");
        lblTotalText.setBounds(12, 500, 100, 15);
        getContentPane().add(lblTotalText);

        lblTotal = new JLabel("0.00");
        lblTotal.setBounds(120, 500, 100, 15);
        getContentPane().add(lblTotal);

        JButton btnRealizarVenta = new JButton("Realizar Venta");
        btnRealizarVenta.setBounds(320, 550, 150, 25);
        btnRealizarVenta.setBackground(new Color(143, 240, 164));
        getContentPane().add(btnRealizarVenta);

        btnRealizarVenta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarVenta();
            }
        });

        JButton btnImprimirFactura = new JButton("Imprimir Factura");
        btnImprimirFactura.setBounds(480, 550, 150, 25);
        btnImprimirFactura.setBackground(new Color(153, 193, 241));
        getContentPane().add(btnImprimirFactura);
        
        textFecha = new JTextField();
        textFecha.setBounds(542, 17, 114, 21);
        getContentPane().add(textFecha);
        textFecha.setColumns(10);

        btnImprimirFactura.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                imprimirFactura();
            }
        });

        btnAgregarProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                seleccionarProducto();
            }
        });

        btnEliminarProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                eliminarProducto();
            }
        });
    }

    private void buscarCliente() {
        ListaCliente listaCliente = new ListaCliente(infoclientes);
        JDialog dialog = new JDialog();
        dialog.setContentPane(listaCliente.getContentPane());
        dialog.setSize(listaCliente.getSize());
        dialog.setModal(true);
        dialog.setVisible(true);

        Cliente clienteSeleccionado = listaCliente.getClienteSeleccionado();
        if (clienteSeleccionado != null) {
            txtNombreCliente.setText(clienteSeleccionado.getNombre() + " " + clienteSeleccionado.getApellido());
            txtCedula.setText(clienteSeleccionado.getCedula());
            txtDireccion.setText(clienteSeleccionado.getDireccion());
            txtTelefono.setText(clienteSeleccionado.getTelefono());
        }
    }

    private void seleccionarProducto() {
        ListaProducto listaProducto = new ListaProducto(infoproductos);
        JDialog dialog = new JDialog();
        dialog.setContentPane(listaProducto.getContentPane());
        dialog.setSize(listaProducto.getSize());
        dialog.setModal(true);
        dialog.setVisible(true);

        Producto productoSeleccionado = listaProducto.getProductoSeleccionado();
        if (productoSeleccionado != null) {
            agregarProductoSeleccionado(productoSeleccionado);
        }
    }

    private void agregarProductoSeleccionado(Producto producto) {
        int cantidad;
        try {
            if (txtCantidad.getText().isEmpty()) {
                cantidad = 1; // Valor predeterminado si no se ingresa nada
            } else {
                cantidad = Integer.parseInt(txtCantidad.getText());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double precioTotal = producto.getPrecio() * cantidad;
        double iva = precioTotal * 0.12;

        model.addRow(new Object[]{
            producto.getCodigo(),
            producto.getNombre(),
            producto.getPrecio(),
            cantidad,
            iva,
            precioTotal
        });

        actualizarTotales();
        txtCantidad.setText("");
    }

    private void eliminarProducto() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            model.removeRow(selectedRow);
            actualizarTotales();
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarTotales() {
        double subtotal = 0;
        double totalIVA = 0;
        double total = 0;

        for (int i = 0; i < model.getRowCount(); i++) {
            double precio = (double) model.getValueAt(i, 2);
            int cantidad = (int) model.getValueAt(i, 3);
            double iva = (double) model.getValueAt(i, 4);
            double totalFila = (double) model.getValueAt(i, 5);

            subtotal += precio * cantidad;
            totalIVA += iva;
            total = subtotal + totalIVA;
        }

        lblSubtotal.setText(String.format("%.2f", subtotal));
        lblIVA.setText(String.format("%.2f", totalIVA));
        lblTotal.setText(String.format("%.2f", total));
    }

    private void realizarVenta() {
      
        JOptionPane.showMessageDialog(this, "Venta realizada con éxito.", "Venta", JOptionPane.INFORMATION_MESSAGE);
    }

    private void imprimirFactura() {
       
        JOptionPane.showMessageDialog(this, "Factura impresa con éxito.", "Imprimir", JOptionPane.INFORMATION_MESSAGE);
    }
}

