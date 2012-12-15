/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.test.dr4zkdemo.view.model;

import mx.dr.forms.constants.FormActions;
import mx.dr.forms.view.DRField;
import mx.dr.forms.view.component.DRGrid;
import mx.dr.forms.view.component.DRTextBox;
import mx.dr.forms.view.component.DRLabel;
import mx.dr.forms.view.component.DRListBox;
import mx.dr.forms.view.validable.DRValidateStringPattern;
import mx.test.vo.Estado;


/**
 *
 * @author jorge
 */
@DRGrid(id = "empfisregGrid", width = "700px")
public class RegisterEmpresaFiscal {

    @DRField(actions= FormActions.EDIT, label =
    @DRLabel(key = "registro.razon.social"), order = 5)
    @DRTextBox(maxlenght = 199)
    private String registroFiscal$razonSocial;
    @DRValidateStringPattern(pattern="^([A-Z]{4}|[A-Z]{3})\\d{6}([A-Z\\w]{3})$")
    @DRField(actions= FormActions.EDIT,label =
    @DRLabel(key = "registro.rfc"), order = 5)
    @DRTextBox(maxlenght = 13,uppercase=true)
    private String registro$rfc;
    @DRField(actions= FormActions.EDIT,label =
    @DRLabel(key = "registro.calle"), order = 5)
    @DRTextBox(maxlenght = 299)
    private String registroFiscal$direccionFiscal$calle;
    @DRField(actions= FormActions.EDIT,label =
    @DRLabel(key = "registro.colonia"), order = 5)
    @DRTextBox(maxlenght = 99)
    private String registro$colonia;
    @DRField(actions= FormActions.EDIT,label =
    @DRLabel(key = "registro.municipio"), order = 5)
    @DRTextBox(maxlenght = 99)
    private String registroFiscal$direccionFiscal$municipio;
    @DRField(actions= FormActions.EDIT,label =
    @DRLabel(key = "registro.cp"), order = 5)
    @DRTextBox(maxlenght = 5)
    private String registroFiscal$direccionFiscal$cp;
    @DRField(actions= FormActions.EDIT,label =
    @DRLabel(key = "registro.estado"), order = 5)
    @DRListBox(mold = DRListBox.MOLD.SELECT, itemRenderer = mx.dr.forms.zul.DRResultsListSimpleRender.class, model = "mx.dr.ml.view.facade.EstadoFacade@findMXEstados")
    private Estado registroFiscal$direccionFiscal$estado;
}
