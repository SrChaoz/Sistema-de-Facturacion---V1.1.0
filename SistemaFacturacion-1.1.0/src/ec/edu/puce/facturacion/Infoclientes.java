package ec.edu.puce.facturacion;

import java.util.ArrayList;
import java.util.List;

public class Infoclientes {
    private List<Cliente> listaClientes;

    public Infoclientes() {
        this.listaClientes = new ArrayList<>();
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void agregarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }


}