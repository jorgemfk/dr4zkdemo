/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.test.dr4zkdemo.view.model;

import mx.dr.forms.constants.FormActions;
import mx.dr.forms.view.DRField;
import mx.dr.forms.view.component.DRGrid;
import mx.dr.forms.view.component.DRLabel;
import mx.dr.forms.view.component.DRTextBox;
import mx.dr.forms.view.validable.DRValidateBusinessResult;
import mx.dr.forms.view.validable.DRValidateLenght;
import mx.dr.forms.view.validable.DRValidateNotEmpty;
import mx.dr.forms.view.validable.DRValidateStringPattern;

/**
 *
 * @author jorge
 */
@DRGrid(id = "empconregGrid", width = "850px")
public class RegisterEmpresaContacto {
    
    @DRValidateStringPattern(pattern=".+@.+.[a-z]+")
    @DRValidateNotEmpty
    @DRValidateBusinessResult(action="mx.dr.ml.view.facade.UsuarioFacade@usuarioByClave")
    @DRField(actions= FormActions.ADD, label =
    @DRLabel(key = "registro.email"), order = 3)
    @DRTextBox(maxlenght=49)
    private String clave;
    
    @DRValidateLenght(lenght=6, mode= DRValidateLenght.MODE.MIN)
    @DRValidateNotEmpty
    @DRField(actions= FormActions.ADD, label =
    @DRLabel(key = "registro.password"), order = 4)
    @DRTextBox(type = DRTextBox.TxtType.password,maxlenght=100)
    private String pasword;

    @DRValidateNotEmpty
    @DRField(actions= {FormActions.ADD, FormActions.EDIT },label =
    @DRLabel(key = "registro.nombre.contacto"), order = 1)
    @DRTextBox(maxlenght=199)
    private String contacto$nombre;

    @DRValidateNotEmpty
    @DRField(actions= {FormActions.ADD, FormActions.EDIT },label =
    @DRLabel(key = "registro.telefono.contacto"), order = 2)
    @DRTextBox(maxlenght=20, mask="(9999) 9999-9999")
    private String contacto$telefono_uno;

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
