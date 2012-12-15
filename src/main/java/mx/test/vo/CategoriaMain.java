package mx.test.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import mx.dr.forms.constants.FormActions;
import mx.dr.forms.view.DRField;
import mx.dr.forms.view.component.DRLabel;
import mx.dr.util.Base;


@Entity
@Table(name = "ml_categoria_main")

public class CategoriaMain extends Base{
	


	public CategoriaMain() {
		super();
		// TODO Auto-generated constructor stub
	}

    public CategoriaMain(Integer id) {
        this.id = id;
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


    public boolean equals(Object obj){
            if(!(obj instanceof CategoriaMain))
                return false;
            if(id==null || ((CategoriaMain)obj).getId()==null)
                return false;
            return this.id==((CategoriaMain)obj).getId().intValue();
        }
}
