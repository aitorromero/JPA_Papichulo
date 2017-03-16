package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@NamedQueries({
@NamedQuery(name = "cercaClientNom", query = "SELECT c FROM Client c WHERE c.nomClient=:nom"),
@NamedQuery(name="cercaVehiclesClient", query="SELECT v FROM Vehicle v WHERE v.propietari.id=:id"), //Query que busca un Client dins de Polissas pel seu ID
})@Table(name = "CLIENT")

public class Client implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public static final String CONSULTA = "ClientNombre";
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "clientId")
    private long clientId;   
    
    @Column(name = "clientNif", length = 9, nullable = false, unique = true)
    private String clientNif;

    @Column(name = "nomClient", length = 50)
    private String nombre;
    
    @Embedded
    private Adreca adreca;
    
    @OneToMany(mappedBy="propietari" )
    List<Vehicle> vList;
    
    @OneToMany(mappedBy = "cliente")
    private List<Polissa> listaPolizas;

    public Client(Long clientId, String clientNif, String nombre, Adreca adreca) {
        this.clientId = clientId;
        this.clientNif = clientNif;
        this.nombre = nombre;
        this.adreca = adreca;
    }

    public Client() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getClientId() {
        return clientId;
    }

    public String getClientNif() {
        return clientNif;
    }

    public String getNombre() {
        return nombre;
    }

    public Adreca getAdreca() {
        return adreca;
    }
    public List<Polissa> getListaPolizas() {
        return listaPolizas;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public void setClientNif(String clientNif) {
        this.clientNif = clientNif;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAdreca(Adreca adreca) {
        this.adreca = adreca;
    }

    public void setListaPolizas(List<Polissa> listaPolizas) {
        this.listaPolizas = listaPolizas;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.clientId);
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
        final Client other = (Client) obj;
        if (!Objects.equals(this.clientId, other.clientId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Client{" + "clientId=" + clientId + ", clientNif=" + clientNif + ", nombre=" + nombre + ", adreca=" + adreca + '}';
    }

    

}
