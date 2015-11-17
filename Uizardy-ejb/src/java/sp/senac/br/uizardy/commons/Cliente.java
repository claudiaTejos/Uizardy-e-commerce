/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.senac.br.uizardy.commons;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 *
 * @author Joana
 */

@Entity
public class Cliente implements Serializable{
    
    @Id
    @GeneratedValue
    private int idCliente;
    
    private String nomeCliente;
    private String cpfCliente;
    private String enderecoCliente;
    private String telefoneCliente;
    private String senhaCliente;
    private String emailCliente;

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the nomeCliente
     */
    public String getNomeCliente() {
        return nomeCliente;
    }

    /**
     * @param nomeCliente the nomeCliente to set
     */
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    /**
     * @return the cpfCliente
     */
    public String getCpfCliente() {
        return cpfCliente;
    }

    /**
     * @param cpfCliente the cpfCliente to set
     */
    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    /**
     * @return the enderecoCliente
     */
    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    /**
     * @param enderecoCliente the enderecoCliente to set
     */
    public void setEnderecoCliente(String enderecoCliente) {
        this.enderecoCliente = enderecoCliente;
    }

    /**
     * @return the telefoneCliente
     */
    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    /**
     * @param telefoneCliente the telefoneCliente to set
     */
    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    /**
     * @return the senhaCliente
     */
    public String getSenhaCliente() {
        return senhaCliente;
    }

    /**
     * @param senhaCliente the senhaCliente to set
     */
    public void setSenhaCliente(String senhaCliente) {
        this.senhaCliente = senhaCliente;
    }

    /**
     * @return the emailCliente
     */
    public String getEmailCliente() {
        return emailCliente;
    }

    /**
     * @param emailCliente the emailCliente to set
     */
    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.idCliente;
        hash = 47 * hash + Objects.hashCode(this.nomeCliente);
        hash = 47 * hash + Objects.hashCode(this.cpfCliente);
        hash = 47 * hash + Objects.hashCode(this.enderecoCliente);
        hash = 47 * hash + Objects.hashCode(this.telefoneCliente);
        hash = 47 * hash + Objects.hashCode(this.senhaCliente);
        hash = 47 * hash + Objects.hashCode(this.emailCliente);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (!Objects.equals(this.nomeCliente, other.nomeCliente)) {
            return false;
        }
        if (!Objects.equals(this.cpfCliente, other.cpfCliente)) {
            return false;
        }
        if (!Objects.equals(this.telefoneCliente, other.telefoneCliente)) {
            return false;
        }
        if (!Objects.equals(this.senhaCliente, other.senhaCliente)) {
            return false;
        }
        if (!Objects.equals(this.emailCliente, other.emailCliente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", nomeCliente=" + nomeCliente + ", cpfCliente=" + cpfCliente + ", enderecoCliente=" + enderecoCliente + ", telefoneCliente=" + telefoneCliente + ", senhaCliente=" + senhaCliente + ", emailCliente=" + emailCliente + '}';
    }
    
    
}

