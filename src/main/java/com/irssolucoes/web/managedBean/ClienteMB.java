/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.irssolucoes.web.managedBean;

import com.irssolucoes.domain.entity.Cliente;
import com.irssolucoes.domain.service.ClienteService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Nicolas Ibanheiz
 */
@ManagedBean
@ViewScoped
public class ClienteMB implements Serializable {

    @ManagedProperty(name = "service", value = "#{clienteService}")
    private ClienteService service;
    private List<Cliente> clientes = new ArrayList<>();
    private Cliente cliente = new Cliente();
    private Cliente selectedCliente;
    String mensagem = "";

    @PostConstruct
    public void init() {
        clientes.clear();
        clientes.addAll(service.listAll());
    }

    public void salvar() {
        if (cliente.getId() == 0) {
            service.save(cliente);
            mensagem = "Cliente salvo com sucesso!";
        } else {
            service.update(cliente);
            mensagem = "Cliente alterado com sucesso!";
        }
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", mensagem);
        FacesContext.getCurrentInstance().addMessage(null, message);
        cliente = new Cliente();
        init();

    }

    public void cancelar() {
        init();
        setCliente(new Cliente());
    }

    public void editar(Cliente cliente) {
        setCliente(cliente);
    }

    public void excluir(Cliente cliente) {
        service.delete(cliente, cliente.getId());
        clientes.remove(cliente);
        selectedCliente = new Cliente();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Cliente excluído com sucesso!");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public ClienteService getService() {
        return service;
    }

    public void setService(ClienteService service) {
        this.service = service;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getSelectedCliente() {
        return selectedCliente;
    }

    public void setSelectedCliente(Cliente selectedCliente) {
        this.selectedCliente = selectedCliente;
    }
}
