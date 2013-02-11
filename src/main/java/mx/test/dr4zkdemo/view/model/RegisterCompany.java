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
import mx.dr.forms.view.component.DRFCKEditor;
import mx.dr.forms.view.component.DRGrid;
import mx.dr.forms.view.component.DRIntBox;
import mx.dr.forms.view.component.DRTextBox;
import mx.dr.forms.view.component.DRLabel;
import mx.dr.forms.dto.DRMedia;
import mx.dr.forms.view.DRField;
import mx.dr.forms.view.DRIsMedia;
import mx.dr.forms.view.component.DRComboBox;
import mx.dr.forms.view.validable.DRValidateNotEmpty;
import mx.dr.forms.view.validable.DRValidateStringPattern;
import mx.dr.util.Base;
import mx.test.vo.Category;


/**
 * Composite view Class for Company.
 * @author jorge
 */
//need to specify the container, in this case a Grid
//note that no DRFellowLink or DRRootEntity since them was defined on parent View Class
@DRGrid(id="empregGrid",width="880px")
public class RegisterCompany extends Base {

	/**
     * company brand name.
     * <br/>
     * Is assignable in action ADD, will be rendered at order -1 as a Textbox with a previous label with key registro.marca"
     */
	//mandatory capture
    @DRValidateNotEmpty
    @DRField(actions= FormActions.ADD,label=@DRLabel(key="registro.marca"),order=-1)
    //the input value will be transformed to uppercase
    @DRTextBox(maxlenght=99,uppercase=true,cols=40)
    private String brand;

    /**
     * company category.
     * <br/>
     * Is assignable in action ADD, will be rendered at order 0 as a Combobox with a previous label with key registro.reg.giro
     */
	//mandatory capture
    @DRValidateNotEmpty
    @DRField(actions= FormActions.ADD,label=@DRLabel(key="registro.reg.giro"),order=0)
    //the action in the combobox define a method to handle a value doesn't registered previously
    @DRComboBox(model="mx.dr.ml.view.facade.CategoryFacade@findActive",
    action="mx.dr.ml.view.facade.CategoryFacade@save")
    private Category category;

    /**
     * company about info.
     * <br/>
     * Is assignable in action ADD, will be rendered at order 1 as a FCKEditor with a previous label with key registro.bio
     */
	//mandatory capture
    @DRValidateNotEmpty
    @DRField(actions= FormActions.ADD,label=@DRLabel(key="registro.bio"),order=1)
    @DRFCKEditor(width="440px", height="440px")
    private String bio;

    /**
     * company phone.
     * <br/>
     * Is assignable in action ADD, will be rendered at order 4 as a Intbox with a previous label with key registro.telefono
     */
    @DRField(actions= FormActions.ADD,label=@DRLabel(key="registro.telefono"),order=4)
    //mask need to include jquery mask in zul and must change to drtextbox
    @DRIntBox(maxlenght=9/*, mask="(9999) 9999-9999"*/)
    private Integer phone;

    /**
     * company logo.
     * <br/>
     * Is assignable in action ADD, will be rendered at order 5 as a Custom upload list with a previous label with key registro.reg.logo
     */
    @DRValidateNotEmpty
    @DRField(actions= FormActions.ADD,label=@DRLabel(key="registro.reg.logo"),order=5)
    //Custom multi attach file component 
    @DRAttachList(maxRow=1)
    //all Media handled objets must marked as DRIsMEdia
    @DRIsMedia
    private List<DRMedia> media;

    /**
     * company external home page url.
     * <br/>
     * Is assignable in action ADD, will be rendered at order 6 as a Textbox with a previous label with key registro.link
     */
    //mandatory capture
    @DRValidateNotEmpty
    @DRValidateStringPattern(pattern = "\\b(https?)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]")
    @DRField(actions= FormActions.ADD,label=@DRLabel(key="registro.link"),order=6)
    @DRTextBox(maxlenght=99)
    private String link;

    /**
     * 
     * @return the list of media
     */
    public List<DRMedia> getMedia() {
        return media;
    }

    /**
     * 
     * @param medias the medias to set
     */
    public void setMedia(List<DRMedia> medias) {
        this.media = medias;
    }

    
}
