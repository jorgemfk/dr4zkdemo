/*
*
*
* Copyright (C) 2012 Jorge Luis Martinez Ramirez
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU Lesser General Public License as
* published by the Free Software Foundation, either version 3 of the
* License, or (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public License
* along with this program. If not, see <http://www.gnu.org/licenses/>.
*
* Author: Jorge Luis Martinez Ramirez
* Email: jorgemfk1@gmail.com
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
import mx.test.vo.Category;

/**
 *
 * @author jorge
 */
@DRGrid(id="empregGrid",width="850px")
public class RegisterCompany extends Base {

    
    @DRValidateNotEmpty
    @DRField(actions= FormActions.ADD,label=@DRLabel(key="registro.marca"),order=-1)
    @DRTextBox(maxlenght=99,uppercase=true,cols=40)
    private String brand;

    @DRValidateNotEmpty
    @DRField(actions= FormActions.ADD,label=@DRLabel(key="registro.reg.giro"),order=0)
    @DRComboBox(model="mx.dr.ml.view.facade.CategoriaFacade@findActive",
    action="mx.dr.ml.view.facade.CategoriaFacade@save")
    private Category category;

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
    private List<DRMedia> media;

    

    public List<DRMedia> getMedia() {
        return media;
    }

    public void setMedia(List<DRMedia> medias) {
        this.media = medias;
    }

    
}
