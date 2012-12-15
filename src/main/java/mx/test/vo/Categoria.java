package mx.test.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import mx.dr.forms.constants.FormActions;
import mx.dr.forms.view.DRField;
import mx.dr.forms.view.component.DRLabel;
import mx.dr.util.Base;



@Entity
@Table(name = "ml_categoria")

public class Categoria extends Base{
	


	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}




	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", updatable = false, nullable = false)
   
	private Integer id;
	@Column(name = "nombre")
        @DRField(columnListWidth = "200px",label=@DRLabel(key=""),actions= {FormActions.LIST})
        
	private String nombre;
        @Temporal(TemporalType.TIMESTAMP)
        @Column(name = "fecha_alta")
	private Date fechaAlta;
        @Column(name = "status")
	private String status;
	@ManyToOne
	@JoinColumn(name = "idusuario")
        private Usuario usuario;
        @ManyToOne
	@JoinColumn(name = "id_categoria_main")
        
        private CategoriaMain padre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setFechaAlta(Date fecha_alta) {
        this.fechaAlta = fecha_alta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CatalogStatus getEstatusEnum() {
        return CatalogStatus.getValueOf(status);
    }

    public void setEstatusEnum(CatalogStatus estatus) {
        if(estatus!=null)
            this.status = estatus.getId();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public CategoriaMain getPadre() {
        return padre;
    }

    public void setPadre(CategoriaMain padre) {
        this.padre = padre;
    }

    public boolean equals(Object obj){
            if(!(obj instanceof Categoria))
                return false;
            if(id==null || ((Categoria)obj).getId()==null)
                return false;
            return this.id==((Categoria)obj).getId().intValue();
        }
}
