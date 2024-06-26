package ec.edu.puce.facturacion.Vistas;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ec.edu.puce.facturacion.Producto;
import ec.edu.puce.facturacion.Infoproductos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FrmProducto extends JInternalFrame {
    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JTable table;
    private DefaultTableModel model;
    private Infoproductos infoproductos;

    public FrmProducto(Infoproductos infoproductos) {
        setBackground(new Color(246, 245, 244));
        this.infoproductos = infoproductos; 
        initialize();
    }

    public void initialize() {
        setTitle("Productos");
        setBounds(0, 0, 500, 558);
        getContentPane().setLayout(null);


        JLabel lblCodigo = new JLabel("ID");
        lblCodigo.setBounds(12, 20, 70, 15);
        getContentPane().add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(105, 18, 114, 19);
        getContentPane().add(txtCodigo);
        txtCodigo.setColumns(10);

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(12, 50, 70, 15);
        getContentPane().add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(105, 48, 114, 19);
        getContentPane().add(txtNombre);
        txtNombre.setColumns(10);

        JLabel lblPrecio = new JLabel("Precio");
        lblPrecio.setBounds(12, 80, 70, 15);
        getContentPane().add(lblPrecio);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(105, 78, 114, 19);
        getContentPane().add(txtPrecio);
        txtPrecio.setColumns(10);


        JButton btnNuevo = new JButton("Nuevo");
        btnNuevo.setBackground(new Color(153, 193, 241));
        btnNuevo.setBounds(275, 20, 117, 25);
        getContentPane().add(btnNuevo);
        btnNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(new Color(143, 240, 164));
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarProducto();
            }
        });
        btnGuardar.setBounds(275, 60, 117, 25);
        getContentPane().add(btnGuardar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(new Color(246, 97, 81));
        btnCancelar.setBounds(275, 100, 117, 25);
        getContentPane().add(btnCancelar);

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 180, 450, 300);
        getContentPane().add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {"ID", "Nombre", "Precio"} 
        ));
        scrollPane.setViewportView(table);
        model = (DefaultTableModel) table.getModel();
    }

    public void limpiarCampos() {
        txtCodigo.setText(null);
        txtNombre.setText(null);
        txtPrecio.setText(null);
    }

    private void guardarProducto() {
        String codigo = txtCodigo.getText();
        String nombre = txtNombre.getText();
        double precio = Double.parseDouble(txtPrecio.getText());

        Producto producto = new Producto(codigo, nombre, "", precio, 0); 

        agregarFila(producto);
        infoproductos.agregarProducto(producto);
    }

    private void agregarFila(Producto producto) {
        Object[] fila = new Object[3];
        fila[0] = producto.getCodigo();
        fila[1] = producto.getNombre();
        fila[2] = producto.getPrecio();
        model.addRow(fila);
    }
}
