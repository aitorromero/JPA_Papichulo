package modelo;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@NamedQueries({@NamedQuery(name="clientId", query="SELECT c FROM Clientes c WHERE c.clientId=:id")})
@Table(name = "CLIENTS")

public class Client {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "clientId")
    private Long clientId;
    
    //public static final String CONSULTA = "PersonaNombre";
    
    @Column(name = "clientNif", length = 9, unique = true, nullable = false)
    private String nombre;

    @Column(name = "nomClient", length = 20, nullable = false)
    private String apellidos;
    
    @Embedded
    private Adreca adreca;

    public Client(Long id, String nombre, String apellidos, String carrer, int numero, String poblacio) {
        this.clientId = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.adreca = new Adreca(carrer, numero, poblacio);
    }

    public Client() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getClientId() {
        return clientId;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Adreca getAdreca() {
        return adreca;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setAdreca(Adreca adreca) {
        this.adreca = adreca;
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
        return "Client{" + "clientId=" + clientId + ", nombre=" + nombre + ", apellidos=" + apellidos + ", adreca=" + adreca + '}';
    }
    
    

}
