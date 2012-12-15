/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.test.dr4zkdemo.view.model;

import mx.dr.forms.constants.FormActions;
import mx.dr.forms.view.DRField;
import mx.dr.forms.view.component.DRGrid;
import mx.dr.forms.view.component.DRIntBox;
import mx.dr.forms.view.component.DRLabel;
import mx.dr.forms.view.component.DRTextBox;
import mx.dr.forms.view.validable.DRValidateNotEmpty;
import mx.dr.forms.view.validable.DRValidateStringPattern;

/**
 *
 * @author jorge
 */
@DRGrid(id = "empconregGrid", width = "700px")
public class EditEmpresaContacto {

    @DRValidateNotEmpty
    @DRField(actions= FormActions.EDIT,label=@DRLabel(key="catalogo.clave"),order=0)
    @DRIntBox(readOnly=true)
    private Integer id;

    @DRValidateNotEmpty
    @DRValidateStringPattern(pattern = ".+@.+.[a-z]+")
    @DRField(actions= FormActions.EDIT, label =
    @DRLabel(key = "registro.email"), order = 3)
    @DRTextBox( readOnly=true,maxlenght=49)
    private String clave;
    
    @DRValidateNotEmpty
    @DRField(actions= FormActions.EDIT,label =
    @DRLabel(key = "registro.nombre.contacto"), order = 1)
    @DRTextBox(maxlenght=199)
    private String contacto$nombre;


    @DRValidateNotEmpty
    @DRField(actions= FormActions.EDIT,label =
    @DRLabel(key = "registro.telefono.contacto"), order = 2)
    @DRTextBox(maxlenght=19)
    private String contacto$telefono_uno;

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer idE) {
        this.id = idE;
    }


}
