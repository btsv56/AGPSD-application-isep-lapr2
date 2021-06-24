/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.records;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lapr.project.autorization.AuthorizationFacade;
import lapr.project.gpsd.model.Client;
import lapr.project.gpsd.model.Constants;
import lapr.project.gpsd.model.PostalAddress;

/**
 *
 * @author Utilizador
 */
public class ClientRecords {

    List<Client> clientsList = new ArrayList<>();
    private final AuthorizationFacade m_oAutorization;

    public ClientRecords() {
        this.m_oAutorization = new AuthorizationFacade();
    }

    public AuthorizationFacade getAutorizacaoFacade() {
        return this.m_oAutorization;
    }

    // Clientes
    // <editor-fold defaultstate="collapsed">
    public Client getClientByEmail(String strEMail) {
        for (Client client : this.clientsList) {
            if (client.hasEmail(strEMail)) {
                return client;
            }
        }

        return null;
    }

    public Client newClient(String strName, String strTIN, String strPhone, String strEmail, PostalAddress address) {
        return new Client(strName, strTIN, strPhone, strEmail, address);
    }

    public Client newClient(String strName, String strTIN, String strPhone, String strEmail) {
        return new Client(strName, strTIN, strPhone, strEmail);
    }

    public boolean registerClient(Client client, String strPwd) {
        if (this.validateClient(client, strPwd)) {
            if (this.m_oAutorization.registerUserWithPaper(client.getName(), client.getEmail(), strPwd, Constants.PAPER_CLIENT)) {
                return addClient(client);
            }
        }
        return false;
    }

    private boolean addClient(Client client) {
        return this.clientsList.add(client);
    }

    public boolean validateClient(Client client, String strPwd) {
        boolean bRet = true;

        // Escrever aqui o código de validação
        if (this.m_oAutorization.existUser(client.getEmail())) {
            bRet = false;
        }
        if (strPwd == null) {
            bRet = false;
        }
        if (strPwd.isEmpty()) {
            bRet = false;
        }
        return bRet;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ClientRecords other = (ClientRecords) obj;
        if (!Objects.equals(this.clientsList, other.clientsList)) {
            return false;
        }
        return true;
    }

    public List<Client> getClientList() {
        return this.clientsList;
    }

    // </editor-fold>
}
