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
 * @author blanc
 */
@Entity
public class EnderecoEntrega implements Serializable {
    
    @Id
    @GeneratedValue
    private int idEnderecoEntrega;
    
    private String cep;
    
    private double valorEntrega;

    public double getValorEntrega() {
        return valorEntrega;
    }

    public void setValorEntrega(double valorEntrega) {
        this.valorEntrega = valorEntrega;
    }

    public int getIdEnderecoEntrega() {
        return idEnderecoEntrega;
    }

    public void setIdEnderecoEntrega(int idEnderecoEntrega) {
        this.idEnderecoEntrega = idEnderecoEntrega;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + this.idEnderecoEntrega;
        hash = 43 * hash + Objects.hashCode(this.cep);
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.valorEntrega) ^ (Double.doubleToLongBits(this.valorEntrega) >>> 32));
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
        final EnderecoEntrega other = (EnderecoEntrega) obj;
        if (this.idEnderecoEntrega != other.idEnderecoEntrega) {
            return false;
        }
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorEntrega) != Double.doubleToLongBits(other.valorEntrega)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EnderecoEntrega{" + "idEnderecoEntrega=" + idEnderecoEntrega + ", cep=" + cep + ", valorEntrega=" + valorEntrega + '}';
    }
   
}