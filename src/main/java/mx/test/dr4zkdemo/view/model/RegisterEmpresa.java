/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.test.dr4zkdemo.view.model;

import java.util.List;
import mx.dr.forms.constants.FormActions;
import mx.dr.forms.view.component.DRAttachList;
import mx.dr.forms.view.component.DRGrid;
import mx.dr.forms.view.component.DRTextBox;
import mx.dr.forms.view.component.DRLabel;
import mx.dr.forms.dto.DRMedia;
import mx.dr.forms.view.DRField;
import mx.dr.forms.view.component.DRComboBox;
import mx.dr.forms.view.validable.DRValidateNotEmpty;
import mx.dr.util.Base;
import mx.test.vo.Categoria;

/**
 *
 * @author jorge
 */
@DRGrid(id="empregGrid",width="850px")
public class RegisterEmpresa extends Base {

    
    @DRValidateNotEmpty
    @DRField(actions= FormActions.ADD,label=@DRLabel(key="registro.marca"),order=-1)
    @DRTextBox(maxlenght=99,uppercase=true,cols=40)
    private String marca;

    @DRValidateNotEmpty
    @DRField(actions= FormActions.ADD,label=@DRLabel(key="registro.reg.giro"),order=0)
    @DRComboBox(model="mx.dr.ml.view.facade.CategoriaFacade@findActive",
    action="mx.dr.ml.view.facade.CategoriaFacade@save")
    private Categoria categoria;

    @DRValidateNotEmpty
    @DRField(actions= FormActions.ADD,label=@DRLabel(key="registro.bio"),order=1)
    @DRTextBox(rows=8,maxlenght=499)
    private String bio;

    @DRValidateNotEmpty
    @DRField(actions= FormActions.ADD,label=@DRLabel(key="registro.telefono"),order=4)
    @DRTextBox(maxlenght=20, mask="(9999) 9999-9999")
    private String telefono;

    @DRValidateNotEmpty
    @DRField(actions= FormActions.ADD,label=@DRLabel(key="registro.reg.logo"),order=4)
    @DRAttachList(maxRow=1)
    private List<DRMedia> medias;

    

    public List<DRMedia> getMedias() {
        return medias;
    }

    public void setMedias(List<DRMedia> medias) {
        this.medias = medias;
    }

    
}
