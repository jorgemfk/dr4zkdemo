/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.test.vo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import mx.dr.util.Base;

/**
 *
 * @author jorge
 */
@Entity
@Table(name = "ml_mregistro_fiscal")
public class RegistroFiscal extends Base{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",  nullable = false)
    private Integer id;

    @Column(name = "razon_social")
    private String razonSocial;
    private String rfc;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "iddireccion")
    private Direccion direccionFiscal;

    public Direccion getDireccionFiscal() {
        return direccionFiscal;
    }

    public void setDireccionFiscal(Direccion direccionFiscal) {
        this.direccionFiscal = direccionFiscal;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }


}
