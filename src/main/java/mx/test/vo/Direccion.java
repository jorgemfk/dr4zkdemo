package mx.test.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Transient;
import mx.dr.util.Base;


@Entity
@Table(name = "ml_mdireccion")

public class Direccion extends Base{

private Integer id;

private String calle;

private String colonia;

private String municipio;

private String cp;

private Estado estado;

private Double latitude = 0D;

private Double longitude = 0D;


public Direccion() {
	super();
}

public Direccion(Integer id) {
	super();
	this.id = id;
}

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id",  nullable = false)

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}

@Column(name = "calle", nullable = true)
public String getCalle() {
	return calle;
}
public void setCalle(String calle) {
	this.calle = calle;
}

@Column(name = "colonia", nullable = false)

public String getColonia() {
	return colonia;
}
public void setColonia(String colonia) {
	this.colonia = colonia;
}

@Column(name = "municipio", nullable = false)

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

@Column(name = "cp", nullable = true)
public String getCp() {
	return cp;
}


public void setCp(String cp) {
	this.cp = cp;
}


@Transient
public String getEstadoString(){return estado.getNombre();}

@ManyToOne
@JoinColumn(name = "idestado")
public Estado getEstado() {
	return estado;
}

public void setEstado(Estado estado) {
	this.estado = estado;
}

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String printable(){
            return new StringBuffer(calle).append(", ").append(colonia).append(", ").append(municipio).append(", ")
                    .append(estado.getNombre()).toString();
    }

public Direccion clone(){
	Direccion d=null;
	try {
		d = (Direccion) super.clone();
	} catch (CloneNotSupportedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	d.setId(null);
	return d;
}

}
