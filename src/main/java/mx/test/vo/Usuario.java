package mx.test.vo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;

import org.zkoss.util.resource.Labels;

import mx.dr.util.Base;

@Entity
@Table(name = "dr_cusuario")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("MLU")
@SequenceGenerator(name = "dr_cusuario_id_seq", sequenceName =
"dr_cusuario_id_seq", allocationSize = 1)
public class Usuario extends Base implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1798263937864023931L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dr_cusuario_id_seq")
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
    @Column(name = "clave")
    private String clave;
    @Column(name = "estatus")
    private String estatus;
    @Column(name = "pasword")
    private String pasword;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "fecha_alta")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaAlta;
    @Column(name = "fecha_activacion")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaActivacion;
    @Column(name = "fecha_login")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date  fechaLogin;

    public Usuario() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Usuario(Integer id, String nombre) {
        super();
        this.id = id;
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public CatalogStatus getEstatusEnum() {
        return CatalogStatus.getValueOf(estatus);
    }

    public void setEstatusEnum(CatalogStatus estatus) {
        if(estatus!=null){
        this.estatus = estatus.getId();
        if(estatus.equals(CatalogStatus.ACTIVE)&& id == null)
            fechaActivacion = Calendar.getInstance().getTime();
        }
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }



    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

 
    public String getEstatusLabel() {
        return Labels.getLabel(CatalogStatus.getLabel(this.estatus));
    }

    public boolean equals(Object obj){
            if(!(obj instanceof Usuario))
                return false;
            if(id==null || ((Usuario)obj).getId()==null)
                return false;
            return this.id==((Usuario)obj).getId().intValue();
        }
}
