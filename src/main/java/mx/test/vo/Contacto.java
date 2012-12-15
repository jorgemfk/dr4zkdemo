package mx.test.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import mx.dr.util.Base;


@Entity
@Table(name = "ml_ccontacto")
public class Contacto extends Base{
	
private Integer id;

private String nombre;

private String telefono_uno;

private String telefono_dos;

private String nextel;

public Contacto() {
	super();
}

public Contacto(Integer id) {
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

@Column(name = "nombre", nullable = false)
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}

@Column(name = "telefono_uno", nullable = false)
public String getTelefono_uno() {
	return telefono_uno;
}
public void setTelefono_uno(String telefono_uno) {
	this.telefono_uno = telefono_uno;
}

@Column(name = "telefono_dos", nullable = true)
public String getTelefono_dos() {
	return telefono_dos;
}
public void setTelefono_dos(String telefono_dos) {
	this.telefono_dos = telefono_dos;
}

@Column(name = "nextel", nullable = true)
public String getNextel() {
	return nextel;
}
public void setNextel(String nextel) {
	this.nextel = nextel;
}




}
