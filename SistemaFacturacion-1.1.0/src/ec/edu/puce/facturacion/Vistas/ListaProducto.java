package ec.edu.puce.facturacion.Vistas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.Color;

import ec.edu.puce.facturacion.Producto;
import ec.edu.puce.facturacion.Infoproductos;

public class ListaProducto extends JInternalFrame {
    private JTable table;
    private Infoproductos infoproductos;
    private DefaultTableModel model;
    private Producto productoSeleccionado; 

    public ListaProducto(Infoproductos infoproductos) {
        getContentPane().setBackground(new Color(153, 193, 241));
        this.infoproductos = infoproductos;
        setTitle("Productos");
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
            new String[] { "Código", "Nombre", "Precio" }
        ));
        scrollPane.setViewportView(table);
        model = (DefaultTableModel) table.getModel();
        cargarProductos();

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                if (row >= 0) {
                    productoSeleccionado = infoproductos.getListaProductos().get(row);
                }
            }
        });
    }

    private void cargarProductos() {
        model.setRowCount(0);
        List<Producto> listaProductos = infoproductos.getListaProductos();
        for (Producto producto : listaProductos) {
            agregarFila(producto);
        }
    }

    private void agregarFila(Producto producto) {
        Object[] fila = new Object[4];
        fila[0] = producto.getCodigo();
        fila[1] = producto.getNombre();
        fila[2] = producto.getPrecio();
        model.addRow(fila);
    }


    public Producto getProductoSeleccionado() {
        return productoSeleccionado;
    }
}
