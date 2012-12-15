/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.test.dr4zkdemo.view.model;

import mx.dr.forms.constants.FormActions;
import mx.dr.forms.view.DRField;
import mx.dr.forms.view.component.*;
import mx.dr.forms.view.validable.DRValidateNotEmpty;
import mx.test.vo.Estado;

/**
 *
 * @author jorge
 */
@DRGrid(id="empdirregGrid",width="850px")
public class RegisterEmpresaDireccion {

@DRValidateNotEmpty
    @DRField(actions= {FormActions.ADD, FormActions.EDIT },label=@DRLabel(key="registro.calle"),order=5)
@DRTextBox(maxlenght=299)
private String direccion$calle;


@DRValidateNotEmpty
    @DRField(actions= {FormActions.ADD, FormActions.EDIT },label=@DRLabel(key="registro.colonia"),order=5)
@DRTextBox(maxlenght=99)
private String direccion$colonia;
@DRValidateNotEmpty
    @DRField(actions= {FormActions.ADD, FormActions.EDIT },label=@DRLabel(key="registro.municipio"),order=5)
@DRTextBox(maxlenght=99)
private String direccion$municipio;


@DRValidateNotEmpty
    @DRField(actions= {FormActions.ADD, FormActions.EDIT },label=@DRLabel(key="registro.estado"),order=5)
@DRListBox(mold=DRListBox.MOLD.SELECT, itemRenderer=mx.dr.forms.zul.DRResultsListSimpleRender.class
,model="mx.dr.ml.view.facade.EstadoFacade@findMXEstados")
private Estado direccion$estado;

@DRValidateNotEmpty
    @DRField(actions= {FormActions.EDIT },label=@DRLabel(key="registro.latitud"),order=5)
@DRDecimalBox(format="#.000000")
private Double direccion$latitude;

@DRValidateNotEmpty
    @DRField(actions= {FormActions.EDIT },label=@DRLabel(key="registro.longitud"),order=5)
@DRDecimalBox(format="#.000000")
private Double direccion$longitude;
}
