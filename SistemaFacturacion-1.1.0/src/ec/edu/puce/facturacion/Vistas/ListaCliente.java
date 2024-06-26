package ec.edu.puce.facturacion.Vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.Color;

import ec.edu.puce.facturacion.Cliente;
import ec.edu.puce.facturacion.Infoclientes;

public class ListaCliente extends JInternalFrame {
    private JTable table;
    private Infoclientes infoclientes;
    private DefaultTableModel model;
    private Cliente clienteSeleccionado; // Campo para almacenar el cliente seleccionado

    public ListaCliente(Infoclientes infoclientes) {
        getContentPane().setBackground(new Color(153, 193, 241));
        this.infoclientes = infoclientes;
        setTitle("Clientes");
        setBounds(100, 100, 450, 558);
        getContentPane().setLayout(null);

        JButton btnCancelar = new JButton("Salir");
        btnCancelar.setBounds(281, 478, 117, 25);
        btnCancelar.setBackground(new Color(246, 97, 81));
        getContentPane().add(btnCancelar);

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(23, 11, 375, 454);
        getContentPane().add(scrollPane);

        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] { "Cédula", "Nombres", "Apellidos", "Dirección", "Teléfono", "Email" }
        ));
        scrollPane.setViewportView(table);
        model = (DefaultTableModel) table.getModel();
        cargarClientes();

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (row >= 0) {
                    clienteSeleccionado = infoclientes.getListaClientes().get(row);
                }
            }
        });
    }

    private void cargarClientes() {
        model.setRowCount(0); 
        List<Cliente> listaClientes = infoclientes.getListaClientes();
        for (Cliente cliente : listaClientes) {
            agregarFila(cliente);
        }
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

    // Método para obtener el cliente seleccionado
    public Cliente getClienteSeleccionado() {
        return clienteSeleccionado;
    }
}
