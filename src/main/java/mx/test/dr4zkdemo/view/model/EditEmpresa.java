/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.test.dr4zkdemo.view.model;

import java.util.List;
import mx.dr.forms.constants.FormActions;
import mx.dr.forms.dto.DRMedia;
import mx.dr.forms.view.DRField;
import mx.dr.forms.view.DRIsMedia;
import mx.dr.forms.view.component.*;
import mx.dr.forms.view.validable.DRValidateNotEmpty;
import mx.dr.util.Base;
import mx.test.vo.CatalogStatus;
import mx.test.vo.Categoria;

/**
 *
 * @author jorge
 */
@DRGrid(id="empregGrid",width="700px")
public class EditEmpresa extends Base {
    
    @DRValidateNotEmpty
    @DRField(actions= FormActions.EDIT,label=@DRLabel(key="registro.marca"),order=1)
    @DRTextBox(maxlenght=100, uppercase=true)
    private String marca;

    @DRValidateNotEmpty
    @DRField(actions= FormActions.EDIT, label=@DRLabel(key="registro.reg.giro"),order=0)
    @DRListBox(model="mx.dr.ml.view.facade.CategoriaFacade@findAll",mold=DRListBox.MOLD.SELECT)
    private Categoria categoria;

    @DRField(actions= FormActions.EDIT,label=@DRLabel(key="registro.telefono"),order=4)
    @DRTextBox(maxlenght=99)
    private String telefono;

    @DRField(actions= FormActions.EDIT,label=@DRLabel(key="registro.slogan"),order=4)
    @DRTextBox(maxlenght=199)
    private String slogan;

    @DRField(actions= FormActions.EDIT,label=@DRLabel(key="registro.especialidad"),order=4)
    @DRTextBox(rows=2,maxlenght=299,cols=38)
    private String especialidad;

    @DRField(actions= FormActions.EDIT,label=@DRLabel(key="registro.horario"),order=4)
    @DRTextBox(maxlenght=19)
    private String horario;

    @DRField(actions= FormActions.EDIT,label=@DRLabel(key="registro.reg.logo"),order=5)
    @DRAttachList(maxRow=1)
    @DRIsMedia
    private List<DRMedia> adjunto;

    @DRField(actions= FormActions.EDIT,label=@DRLabel(key="catalogo.status"),order=6)
    @DRListBox(mold=DRListBox.MOLD.SELECT, itemRenderer=mx.dr.forms.zul.DRResultsListSimpleRender.class,
    model="mx.dr.ml.view.facade.CatalogoFacade@getCatalogStatus")
    private CatalogStatus estatusEnum;

    @DRField(actions= FormActions.EDIT,label=@DRLabel(key="registro.bio"),order=1)
    @DRTextBox(rows=8,maxlenght=499,cols=38)
    private String bio;

    @DRField(actions= FormActions.EDIT,label=@DRLabel(key="registro.link"),order=1)
    @DRTextBox(maxlenght=99)
    private String link;

    public List<DRMedia> getAdjunto() {
        return adjunto;
    }

    public void setAdjunto(List<DRMedia> adjunto) {
        this.adjunto = adjunto;
    }

    
}
