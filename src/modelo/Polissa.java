package modelo;

import java.io.Serializable;
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
    @NamedQuery(name = "cercaPolizasCliente", query = "SELECT p FROM Polissa p WHERE p.cliente.id=:id")
    ,
@NamedQuery(name = "cercaPolizaPerVehicle", query = "SELECT p FROM Polissa p WHERE p.vehicle.vehicleId=:vehicle")})

@Table(name = "POLISSA", indexes = {
    @Index(columnList = "prenedorPolissa", name = "indexPrenedorPolissa")})

public class Polissa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "polissaId")
    private Long polissaId;

    public static final String CONSULTA = "PolissaId";

    @Column(name = "numeroPolissa", length = 10)
    private String numeroPolissa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prenedorPolissa", nullable = false)
    private Client prenedor;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehiclePolissa", nullable = false)
    private Vehicle vehiclePolissa;

    @Column(name = "dataIniciPolissa")
    private Calendar dataIniciPolissa;

    @Column(name = "dataFiPolissa")
    private Calendar dataFiPolissa;

    @Column(name = "tipusPolissa")
    private boolean tipusPolissa;

    @Column(name = "primaPolissa")
    private double primaPolissa;

    @ManyToOne
    @JoinColumn(name = "asseguradoraId")
    private Asseguradora asseguradora;

    public Polissa(Long polissaId, String numeroPolissa, Client prenedor, Vehicle vehiclePolissa, Calendar dataIniciPolissa, Calendar dataFiPolissa, boolean tipusPolissa, double primaPolissa, Asseguradora asseguradora) {
        this.polissaId = polissaId;
        this.numeroPolissa = numeroPolissa;
        this.prenedor = prenedor;
        this.vehiclePolissa = vehiclePolissa;
        this.dataIniciPolissa = dataIniciPolissa;
        this.dataFiPolissa = dataFiPolissa;
        this.tipusPolissa = tipusPolissa;
        this.primaPolissa = primaPolissa;
        this.asseguradora = asseguradora;
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

    public Asseguradora getAsseguradora() {
        return asseguradora;
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
    
    
    public void setAsseguradora(Asseguradora asseguradora) {
        this.asseguradora = asseguradora;
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
