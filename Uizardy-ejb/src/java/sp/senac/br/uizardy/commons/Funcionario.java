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
 * @author claudia tejos
 */
@Entity
public class Funcionario implements Serializable {
    
    @Id
    @GeneratedValue
    private int idFuncionario;
    
    private String nomeFuncionario;
    private String cpfFuncionario;
    private String rgFuncionario;
    private String cargoFuncionario;
    private String enderecoFuncionario;
    private String telefoneFuncionario;
    private String senhaFuncionario;
    private boolean statusFuncionario;

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    public String getRgFuncionario() {
        return rgFuncionario;
    }

    public void setRgFuncionario(String rgFuncionario) {
        this.rgFuncionario = rgFuncionario;
    }

    public String getCargoFuncionario() {
        return cargoFuncionario;
    }

    public void setCargoFuncionario(String cargoFuncionario) {
        this.cargoFuncionario = cargoFuncionario;
    }

    public String getEnderecoFuncionario() {
        return enderecoFuncionario;
    }

    public void setEnderecoFuncionario(String enderecoFuncionario) {
        this.enderecoFuncionario = enderecoFuncionario;
    }

    public String getTelefoneFuncionario() {
        return telefoneFuncionario;
    }

    public void setTelefoneFuncionario(String telefoneFuncionario) {
        this.telefoneFuncionario = telefoneFuncionario;
    }

    public boolean isStatusFuncionario() {
        return statusFuncionario;
    }

    public void setStatusFuncionario(boolean statusFuncionario) {
        this.statusFuncionario = statusFuncionario;
    }

    public String getSenhaFuncionario() {
        return senhaFuncionario;
    }

    public void setSenhaFuncionario(String senhaFuncionario) {
        this.senhaFuncionario = senhaFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idFuncionario;
        hash = 97 * hash + Objects.hashCode(this.nomeFuncionario);
        hash = 97 * hash + Objects.hashCode(this.cpfFuncionario);
        hash = 97 * hash + Objects.hashCode(this.rgFuncionario);
        hash = 97 * hash + Objects.hashCode(this.cargoFuncionario);
        hash = 97 * hash + Objects.hashCode(this.enderecoFuncionario);
        hash = 97 * hash + Objects.hashCode(this.telefoneFuncionario);
        hash = 97 * hash + Objects.hashCode(this.senhaFuncionario);
        hash = 97 * hash + (this.statusFuncionario ? 1 : 0);
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
        final Funcionario other = (Funcionario) obj;
        if (this.idFuncionario != other.idFuncionario) {
            return false;
        }
        if (!Objects.equals(this.nomeFuncionario, other.nomeFuncionario)) {
            return false;
        }
        if (!Objects.equals(this.cpfFuncionario, other.cpfFuncionario)) {
            return false;
        }
        if (!Objects.equals(this.rgFuncionario, other.rgFuncionario)) {
            return false;
        }
        if (!Objects.equals(this.cargoFuncionario, other.cargoFuncionario)) {
            return false;
        }
        if (!Objects.equals(this.enderecoFuncionario, other.enderecoFuncionario)) {
            return false;
        }
        if (!Objects.equals(this.telefoneFuncionario, other.telefoneFuncionario)) {
            return false;
        }
        if (!Objects.equals(this.senhaFuncionario, other.senhaFuncionario)) {
            return false;
        }
        if (this.statusFuncionario != other.statusFuncionario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "idFuncionario=" + idFuncionario + ", nomeFuncionario=" + nomeFuncionario + ", cpfFuncionario=" + cpfFuncionario + ", rgFuncionario=" + rgFuncionario + ", cargoFuncionario=" + cargoFuncionario + ", enderecoFuncionario=" + enderecoFuncionario + ", telefoneFuncionario=" + telefoneFuncionario + ", senhaFuncionario=" + senhaFuncionario + ", statusFuncionario=" + statusFuncionario + '}';
    }
  
}