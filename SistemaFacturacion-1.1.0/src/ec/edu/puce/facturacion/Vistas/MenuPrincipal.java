package ec.edu.puce.facturacion.Vistas;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ec.edu.puce.facturacion.Infoclientes;
import ec.edu.puce.facturacion.Infoproductos;

public class MenuPrincipal extends JFrame {
	
	 private JPanel contentPane;
	 private JDesktopPane desktopPane;
	 private Infoproductos infoproductos = new Infoproductos(); 
	 private FrmProducto frmProducto;
	 private ListaProducto listaProducto;
	 private FrmFactura frmFacturar; 
    private Infoclientes infoclientes = new Infoclientes(); 
    private FrmCliente frmCliente;
    private ListaCliente listaCliente;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuPrincipal frame = new MenuPrincipal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MenuPrincipal() {
        setTitle("SISTEMA DE FACTURACIÓN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        setBounds(0, 0, screenWidth, screenHeight);
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(87, 227, 137));
        setJMenuBar(menuBar);

        JMenu mnFile = new JMenu("File");
        mnFile.setFont(new Font("Dialog", Font.BOLD, 16));
        menuBar.add(mnFile);

        JMenuItem mntmSalir = new JMenuItem("Salir");
        mntmSalir.setFont(new Font("Dialog", Font.BOLD, 16));
        mnFile.add(mntmSalir);

        mntmSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JMenu mnClientes = new JMenu("Clientes");
        mnClientes.setFont(new Font("Dialog", Font.BOLD, 16));
        menuBar.add(mnClientes);

        JMenuItem mntmCrearClientes = new JMenuItem("Crear Clientes");

        mntmCrearClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (frmCliente == null || !frmCliente.isVisible()) {
                    frmCliente = new FrmCliente(infoclientes);
                    desktopPane.add(frmCliente);
                    frmCliente.setVisible(true);
                } else {
                    frmCliente.requestFocus();
                }
            }
        });

        mntmCrearClientes.setFont(new Font("Dialog", Font.BOLD, 16));
        mnClientes.add(mntmCrearClientes);

        JMenuItem mntmListaDeClientes = new JMenuItem("Lista de Clientes");
        mntmListaDeClientes.setFont(new Font("Dialog", Font.BOLD, 16));
        mnClientes.add(mntmListaDeClientes);

        mntmListaDeClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (listaCliente == null || !listaCliente.isVisible()) {
                    listaCliente = new ListaCliente(infoclientes);
                    desktopPane.add(listaCliente);
                    listaCliente.setVisible(true);
                } else {
                    listaCliente.requestFocus();
                }
            }
        });

        JMenu mnProductos = new JMenu("Productos");
        mnProductos.setFont(new Font("Dialog", Font.BOLD, 16));
        menuBar.add(mnProductos);

        JMenuItem mntmCrearProducto = new JMenuItem("Crear Producto");
        mntmCrearProducto.setFont(new Font("Dialog", Font.BOLD, 16));
        mnProductos.add(mntmCrearProducto);

        mntmCrearProducto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (frmProducto == null || !frmProducto.isVisible()) {
                    frmProducto = new FrmProducto(infoproductos);
                    desktopPane.add(frmProducto);
                    frmProducto.setVisible(true);
                } else {
                    frmProducto.requestFocus();
                }
            }
        });

        JMenuItem mntmListaDeProductos = new JMenuItem("Lista de Productos");
        mntmListaDeProductos.setFont(new Font("Dialog", Font.BOLD, 16));
        mnProductos.add(mntmListaDeProductos);

        mntmListaDeProductos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (listaProducto == null || !listaProducto.isVisible()) {
                    listaProducto = new ListaProducto(infoproductos);
                    desktopPane.add(listaProducto);
                    listaProducto.setVisible(true);
                } else {
                    listaProducto.requestFocus();
                }
            }
        });
        
        JMenu mnFacturas = new JMenu("Facturas");
        mnFacturas.setFont(new Font("Dialog", Font.BOLD, 16));
        menuBar.add(mnFacturas);

        JMenuItem mntmFacturar = new JMenuItem("Facturar");
        mntmFacturar.setFont(new Font("Dialog", Font.BOLD, 16));
        mnFacturas.add(mntmFacturar);

        mntmFacturar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (frmFacturar == null || !frmFacturar.isVisible()) {
                    frmFacturar = new FrmFactura(infoclientes, infoproductos);
                    desktopPane.add(frmFacturar);
                    frmFacturar.setVisible(true);
                } else {
                    frmFacturar.requestFocus();
                }
            }
        });

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new CardLayout(0, 0));

        desktopPane = new JDesktopPane();
        desktopPane.setBackground(new Color(222, 221, 218));
        contentPane.add(desktopPane, "name_250806999939613");
    }
}