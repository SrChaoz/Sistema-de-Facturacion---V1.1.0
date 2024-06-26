package ec.edu.puce.facturacion.Vistas;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ec.edu.puce.facturacion.Cliente;
import ec.edu.puce.facturacion.Infoclientes;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FrmCliente extends JInternalFrame {
    private JTextField txtCedula;
    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtEmail;
    private JTable table;
    private DefaultTableModel model;
    public boolean clienteFormularioAbierto = false;
    private Infoclientes infoclientes;

    public FrmCliente(Infoclientes infoclientes) {
    	setBackground(new Color(246, 245, 244));
        this.infoclientes = infoclientes; 
        initialize();
    }

    public void initialize() {
        setTitle("Clientes");
        setBounds(0, 0, 450, 558);
        getContentPane().setLayout(null);

        JLabel lblCdula = new JLabel("Cédula");
        lblCdula.setBounds(12, 24, 70, 15);
        getContentPane().add(lblCdula);

        JLabel lblNombres = new JLabel("Nombres");
        lblNombres.setBounds(12, 51, 70, 15);
        getContentPane().add(lblNombres);

        JLabel lblApellidos = new JLabel("Apellidos");
        lblApellidos.setBounds(12, 78, 70, 15);
        getContentPane().add(lblApellidos);

        JLabel lblDireccin = new JLabel("Dirección");
        lblDireccin.setBounds(12, 105, 70, 15);
        getContentPane().add(lblDireccin);

        JLabel lblTelfono = new JLabel("Teléfono");
        lblTelfono.setBounds(12, 132, 70, 15);
        getContentPane().add(lblTelfono);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(12, 159, 70, 15);
        getContentPane().add(lblEmail);

        txtCedula = new JTextField();
        txtCedula.setBounds(105, 22, 114, 19);
        getContentPane().add(txtCedula);
        txtCedula.setColumns(10);

        txtNombres = new JTextField();
        txtNombres.setBounds(105, 49, 114, 19);
        getContentPane().add(txtNombres);
        txtNombres.setColumns(10);

        txtApellidos = new JTextField();
        txtApellidos.setBounds(105, 76, 114, 19);
        getContentPane().add(txtApellidos);
        txtApellidos.setColumns(10);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(105, 103, 114, 19);
        getContentPane().add(txtDireccion);
        txtDireccion.setColumns(10);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(105, 130, 114, 19);
        getContentPane().add(txtTelefono);
        txtTelefono.setColumns(10);

        txtEmail = new JTextField();
        txtEmail.setBounds(105, 157, 114, 19);
        getContentPane().add(txtEmail);
        txtEmail.setColumns(10);

        JButton btnNuevo = new JButton("Nuevo");
        btnNuevo.setBackground(new Color(153, 193, 241));
        btnNuevo.setBounds(23, 206, 117, 25);
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
                crearCliente();
            }
        });
        btnGuardar.setBounds(152, 206, 117, 25);
        getContentPane().add(btnGuardar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(new Color(246, 97, 81));
        btnCancelar.setBounds(281, 206, 117, 25);
        getContentPane().add(btnCancelar);

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clienteFormularioAbierto = false;
                dispose();
            }
        });

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(23, 257, 375, 237);
        getContentPane().add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][] {},
                new String[] { "Cédula", "Nombres", "Apellidos", "Dirección", "Teléfono", "Email" }
        ));
        scrollPane.setViewportView(table);
        model = (DefaultTableModel) table.getModel();
    }

    public void limpiarCampos() {
        txtCedula.setText(null);
        txtNombres.setText(null);
        txtApellidos.setText(null);
        txtDireccion.setText(null);
        txtTelefono.setText(null);
        txtEmail.setText(null);
    }

    private void crearCliente() {
        Cliente cliente = new Cliente();
        cliente.setCedula(txtCedula.getText());
        cliente.setNombre(txtNombres.getText());
        cliente.setApellido(txtApellidos.getText());
        cliente.setDireccion(txtDireccion.getText());
        cliente.setTelefono(txtTelefono.getText());
        cliente.setEmail(txtEmail.getText());

        agregarFila(cliente);

        infoclientes.agregarCliente(cliente);

       
    }

    private void agregarFila(Cliente cliente) {
        Object[] fila = new Object[6];
        fila[0] = cliente.getCedula();
        fila[1] = cliente.getNombre();
        fila[2] = cliente.getApellido();
        fila[3] = cliente.getDireccion();
        fila[4] = cliente.getTelefono();
        fila[5] = cliente.getEmail();
        model.addRow(fila);
    }
}