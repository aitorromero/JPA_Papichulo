package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import javax.persistence.Embeddable;
 
@Embeddable
@Table (name = "M6UF2_DIRECCIONS")
public class Adreca{

    private String carrer;
    private int numero;
    private String poblacio;

    public Adreca(String carrer, int numero, String poblacio) {
        this.carrer = carrer;
        this.numero = numero;
        this.poblacio = poblacio;
    }

    public Adreca(){}
    
    public String getCarrer() {
        return carrer;
    }

    public int getNumero() {
        return numero;
    }

    public String getPoblacio() {
        return poblacio;
    }

    public void setCarrer(String carrer) {
        this.carrer = carrer;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setPoblacio(String poblacio) {
        this.poblacio = poblacio;
    }

    @Override
    public String toString() {
        return "Adreca{" + "carrer=" + carrer + ", numero=" + numero + ", poblacio=" + poblacio + '}';
    }
    
    

}
