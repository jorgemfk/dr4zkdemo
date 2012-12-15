/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.test.vo;
import java.util.Date;
import javax.persistence.*;
import mx.dr.forms.constants.FormActions;
import mx.dr.forms.view.DRField;
import mx.dr.forms.view.component.DRLabel;
/**
 *
 * @author JLMR
 */
@Entity
@Table(name = "ml_ccontrato")
public class Contrato {
        @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",  nullable = false)
	private Integer id;
        @Temporal(TemporalType.DATE)
        private Date fecha;
        @DRField(actions= FormActions.SEARCH, searchOperador=DRField.Operator.EQUALS,label=@DRLabel(key=DRLabel.NO_LABEL))
        private String tipo;
        private String contenido;

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

        
}
