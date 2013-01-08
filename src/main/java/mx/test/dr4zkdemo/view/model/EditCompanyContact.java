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
public class EditCompanyContact {

    @DRValidateNotEmpty
    @DRField(actions= FormActions.EDIT,label=@DRLabel(key="catalogo.clave"),order=0)
    @DRIntBox(readOnly=true)
    private Integer id;

    @DRValidateNotEmpty
    @DRValidateStringPattern(pattern = ".+@.+.[a-z]+")
    @DRField(actions= FormActions.EDIT, label =
    @DRLabel(key = "registro.email"), order = 3)
    @DRTextBox( readOnly=true,maxlenght=49)
    private String key;
    
    @DRValidateNotEmpty
    @DRField(actions= FormActions.EDIT,label =
    @DRLabel(key = "registro.nombre.contacto"), order = 1)
    @DRTextBox(maxlenght=199)
    private String contact$name;


    @DRValidateNotEmpty
    @DRField(actions= FormActions.EDIT,label =
    @DRLabel(key = "registro.telefono.contacto"), order = 2)
    //mask need to include jquery mask in zul
    @DRTextBox(maxlenght=19/*, mask="(9999) 9999-9999"*/)
    private String contact$phone_number;

    public String getKey() {
        return key;
    }

    public void setKey(String clave) {
        this.key = clave;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer idE) {
        this.id = idE;
    }


}
