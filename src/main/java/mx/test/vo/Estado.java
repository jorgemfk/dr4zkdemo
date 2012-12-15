package mx.test.vo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import mx.dr.forms.constants.FormActions;
import mx.dr.forms.view.DRField;
import mx.dr.forms.view.component.DRLabel;
import mx.dr.util.Base;


@Entity
@Table(name = "ml_cestado")
public class Estado extends Base {
    public static final String TODOS="TODAS LAS CIUDADES";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",  nullable = false)
    private Integer id;
    @DRField(actions={FormActions.LIST},label=@DRLabel(key=""), columnListWidth= "200px")
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "idpais")
    private String pais;
    @Column(name = "visible")
    private Boolean visible;

    public Estado() {
    }

    public Estado(Integer id, String nombre) {
        super();
        this.id = id;
        this.nombre = nombre;
    }

    public Estado(String pais) {
        super();
        this.pais = pais;
    }

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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Estado)) {
            return false;
        }
        if (id == null || ((Estado) obj).getId() == null) {
            return false;
        }
        return this.id == ((Estado) obj).getId().intValue();
    }
}
