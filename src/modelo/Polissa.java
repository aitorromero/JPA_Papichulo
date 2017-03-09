package modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.IndexColumn;

@Entity 
@NamedQueries({
    @NamedQuery(name=Polissa.CONSULTA, query="SELECT p FROM Polisses p WHERE p.polissaId=:id")
//    @NamedQuery(name="PolissaClient", query="SELECT p FROM Polisses p WHERE p.prenedorPolissa=:nombre"),
//    @NamedQuery(name="PolissaVehicle", query="SELECT p FROM Polisses p WHERE p.dataIniciPolissa=:dataActucal AND p.dataIniciPolissa=:dataActucal"),
//    @NamedQuery(name="PolissaVigent", query="SELECT p FROM Polisses p WHERE p.dataFiPolissa=:dataActucal AND p.dataFiPolissa=:dataActucal")
})

@Table(name = "POLISSES", indexes = {@Index(columnList = "prenedorPolissa", name="indexPrenedorPolissa" )})

public class Polissa {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "polissaId")
    private Long polissaId;
    
    public static final String CONSULTA = "PersonaNombre";

    @Column(name = "numeroPolissa", length = 10)
    private String numeroPolissa;
    
    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "prenedorPolissa", nullable = false)
    @Basic(fetch = FetchType.LAZY)
    private Client prenedor;

    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "vehiclePolissa", nullable = false)
    @Basic(fetch = FetchType.LAZY)
    private Vehicle vehiclePolissa;

    @Column(name = "dataIniciPolissa")
    private Calendar dataIniciPolissa;
    
    @Column(name = "dataFiPolissa")
    private Calendar dataFiPolissa;

    @Column(name = "tipusPolissa")
    private boolean tipusPolissa;
    
    @Column(name = "primaPolissa")
    private double primaPolissa;

    public Polissa(Long polissaId, String numeroPolissa, Client prenedor, Vehicle vehiclePolissa, Calendar dataIniciPolissa, Calendar dataFiPolissa, boolean tipusPolissa, double primaPolissa) {
        this.polissaId = polissaId;
        this.numeroPolissa = numeroPolissa;
        this.prenedor = prenedor;
        this.vehiclePolissa = vehiclePolissa;
        this.dataIniciPolissa = dataIniciPolissa;
        this.dataFiPolissa = dataFiPolissa;
        this.tipusPolissa = tipusPolissa;
        this.primaPolissa = primaPolissa;
    }

    public Polissa() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getPolissaId() {
        return polissaId;
    }

    public String getNumeroPolissa() {
        return numeroPolissa;
    }

    public Client getPrenedor() {
        return prenedor;
    }

    public Vehicle getVehiclePolissa() {
        return vehiclePolissa;
    }

    public Calendar getDataIniciPolissa() {
        return dataIniciPolissa;
    }

    public Calendar getDataFiPolissa() {
        return dataFiPolissa;
    }

    public boolean isTipusPolissa() {
        return tipusPolissa;
    }

    public double getPrimaPolissa() {
        return primaPolissa;
    }

    public void setPolissaId(Long polissaId) {
        this.polissaId = polissaId;
    }

    public void setNumeroPolissa(String numeroPolissa) {
        this.numeroPolissa = numeroPolissa;
    }

    public void setPrenedor(Client prenedor) {
        this.prenedor = prenedor;
    }

    public void setVehiclePolissa(Vehicle vehiclePolissa) {
        this.vehiclePolissa = vehiclePolissa;
    }

    public void setDataIniciPolissa(Calendar dataIniciPolissa) {
        this.dataIniciPolissa = dataIniciPolissa;
    }

    public void setDataFiPolissa(Calendar dataFiPolissa) {
        this.dataFiPolissa = dataFiPolissa;
    }

    public void setTipusPolissa(boolean tipusPolissa) {
        this.tipusPolissa = tipusPolissa;
    }

    public void setPrimaPolissa(double primaPolissa) {
        this.primaPolissa = primaPolissa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.polissaId);
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
        final Polissa other = (Polissa) obj;
        if (!Objects.equals(this.polissaId, other.polissaId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Polissa{" + "polissaId=" + polissaId + ", numeroPolissa=" + numeroPolissa + ", prenedor=" + prenedor + ", vehiclePolissa=" + vehiclePolissa + ", dataIniciPolissa=" + dataIniciPolissa + ", dataFiPolissa=" + dataFiPolissa + ", tipusPolissa=" + tipusPolissa + ", primaPolissa=" + primaPolissa + '}';
    }

    
    
}
