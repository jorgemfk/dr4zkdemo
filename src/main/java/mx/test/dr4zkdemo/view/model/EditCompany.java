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

import java.util.Date;
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
 * Composite view Class for Company.
 * @author jorge
 */
//need to specify the container, in this case a Grid
//note that no DRFellowLink or DRRootEntity since them was defined on parent View Class
@DRGrid(id="empregGrid",width="700px")
public class EditCompany  {
	/**
     * company brand name.
     * <br/>
     * Is assignable in action EDIT, will be rendered at order -1 as a Textbox with a previous label with key registro.marca"
     */
	//mandatory capture
    @DRValidateNotEmpty
    @DRField(actions= FormActions.EDIT,label=@DRLabel(key="registro.marca"),order=1)
    //the input value will be transformed to uppercase
    @DRTextBox(maxlenght=100, uppercase=true)
    private String brand;

    /**
     * company category.
     * <br/>
     * Is assignable in action EDIT, will be rendered at order 0 as a Combobox with a previous label with key registro.reg.giro
     */
	//mandatory capture
    @DRValidateNotEmpty
    @DRField(actions= FormActions.EDIT, label=@DRLabel(key="registro.reg.giro"),order=0)
    @DRListBox(model="mx.dr.ml.view.facade.CategoryFacade@findAll",mold=DRListBox.MOLD.SELECT)
    private Category category;

    /**
     * company phone.
     * <br/>
     * Is assignable in action EDIT, will be rendered at order 4 as a Intbox with a previous label with key registro.telefono
     */
    @DRField(actions= FormActions.EDIT,label=@DRLabel(key="registro.telefono"),order=4)
    @DRIntBox(maxlenght=9)
    private Integer phone;

    /**
     * company slogan.
     * <br/>
     * Is assignable in action EDIT, will be rendered at order 7 as a Textbox with a previous label with key registro.slogan
     */
    @DRField(actions= FormActions.EDIT,label=@DRLabel(key="registro.slogan"),order=7)
    @DRTextBox(maxlenght=199)
    private String slogan;

    /**
     * company specialty.
     * <br/>
     * Is assignable in action EDIT, will be rendered at order 8 as a Textbox with a previous label with key registro.especialidad
     */
    @DRField(actions= FormActions.EDIT,label=@DRLabel(key="registro.especialidad"),order=8)
    @DRTextBox(rows=2,maxlenght=299,cols=38)
    private String specialty;

    /**
     * company schedule.
     * <br/>
     * Is assignable in action EDIT, will be rendered at order 9 as a Datebox with a previous label with key registro.horario
     */
    @DRField(actions= FormActions.EDIT,label=@DRLabel(key="registro.horario"),order=9)
    @DRDateBox(format="dd/MM/yyyy")
    private Date schedule;

    /**
     * company logo.
     * <br/>
     * Is assignable in action EDIT, will be rendered at order 5 as a Custom upload list with a previous label with key registro.reg.logo
     */
    @DRField(actions= FormActions.EDIT,label=@DRLabel(key="registro.reg.logo"),order=5)
    //Custom multi attach file component 
    @DRAttachList(maxRow=1)
    //all Media handled objets must marked as DRIsMEdia
    @DRIsMedia
    private List<DRMedia> logo;

    /**
     * company status.
     * <br/>
     * Is assignable in action EDIT, will be rendered at order 5 as a Combo Listbox with a previous label with key catalogo.status
     */
    @DRField(actions= FormActions.EDIT,label=@DRLabel(key="catalogo.status"),order=6)
    @DRListBox(mold=DRListBox.MOLD.SELECT, itemRenderer=mx.dr.forms.zul.DRResultsListSimpleRender.class,
    model="mx.dr.ml.view.facade.CatalogFacade@getCatalogStatus")
    private CatalogStatus estatusEnum;

    /**
     * company about info.
     * <br/>
     * Is assignable in action EDIT, will be rendered at order 1 as a FCKEditor with a previous label with key registro.bio
     */
    @DRField(actions= FormActions.EDIT,label=@DRLabel(key="registro.bio"),order=1)
    @DRFCKEditor(width="350px", height="350px")
    private String bio;

    /**
     * company external home page url.
     * <br/>
     * Is assignable in action EDIT, will be rendered at order 6 as a Textbox with a previous label with key registro.link
     */
    @DRField(actions= FormActions.EDIT,label=@DRLabel(key="registro.link"),order=10)
    @DRTextBox(maxlenght=99)
    private String link;

    /**
     * 
     * @return the list of media
     */
    public List<DRMedia> getLogo() {
        return logo;
    }

    /**
     * 
     * @param medias the medias to set
     */
    public void setLogo(List<DRMedia> adjunto) {
        this.logo = adjunto;
    }

    
}
