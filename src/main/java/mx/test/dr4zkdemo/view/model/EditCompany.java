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
import mx.dr.forms.dto.DRMedia;
import mx.dr.forms.view.DRField;
import mx.dr.forms.view.DRIsMedia;
import mx.dr.forms.view.component.*;
import mx.dr.forms.view.validable.DRValidateNotEmpty;
import mx.dr.util.Base;
import mx.test.vo.CatalogStatus;
import mx.test.vo.Category;

/**
 *
 * @author jorge
 */
@DRGrid(id="empregGrid",width="700px")
public class EditCompany extends Base {
    
    @DRValidateNotEmpty
    @DRField(actions= FormActions.EDIT,label=@DRLabel(key="registro.marca"),order=1)
    @DRTextBox(maxlenght=100, uppercase=true)
    private String brand;

    @DRValidateNotEmpty
    @DRField(actions= FormActions.EDIT, label=@DRLabel(key="registro.reg.giro"),order=0)
    @DRListBox(model="mx.dr.ml.view.facade.CategoryFacade@findAll",mold=DRListBox.MOLD.SELECT)
    private Category category;

    @DRField(actions= FormActions.EDIT,label=@DRLabel(key="registro.telefono"),order=4)
    @DRIntBox(maxlenght=9)
    private Integer phone;

    @DRField(actions= FormActions.EDIT,label=@DRLabel(key="registro.slogan"),order=4)
    @DRTextBox(maxlenght=199)
    private String slogan;

    @DRField(actions= FormActions.EDIT,label=@DRLabel(key="registro.especialidad"),order=4)
    @DRTextBox(rows=2,maxlenght=299,cols=38)
    private String specialty;

    @DRField(actions= FormActions.EDIT,label=@DRLabel(key="registro.horario"),order=4)
    @DRTextBox(maxlenght=19)
    private String schedule;

    @DRField(actions= FormActions.EDIT,label=@DRLabel(key="registro.reg.logo"),order=5)
    @DRAttachList(maxRow=1)
    @DRIsMedia
    private List<DRMedia> logo;

    @DRField(actions= FormActions.EDIT,label=@DRLabel(key="catalogo.status"),order=6)
    @DRListBox(mold=DRListBox.MOLD.SELECT, itemRenderer=mx.dr.forms.zul.DRResultsListSimpleRender.class,
    model="mx.dr.ml.view.facade.CatalogFacade@getCatalogStatus")
    private CatalogStatus estatusEnum;

    @DRField(actions= FormActions.EDIT,label=@DRLabel(key="registro.bio"),order=1)
    @DRFCKEditor(width="350px", height="350px")
    private String bio;

    @DRField(actions= FormActions.EDIT,label=@DRLabel(key="registro.link"),order=1)
    @DRTextBox(maxlenght=99)
    private String link;

    public List<DRMedia> getLogo() {
        return logo;
    }

    public void setLogo(List<DRMedia> adjunto) {
        this.logo = adjunto;
    }

    
}
