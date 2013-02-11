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
import mx.dr.forms.view.validable.DRValidateBusinessResult;
import mx.dr.forms.view.validable.DRValidateLenght;
import mx.dr.forms.view.validable.DRValidateNotEmpty;
import mx.dr.forms.view.validable.DRValidateStringPattern;

/**
 * Composite view Class for Company contact.
 * @author jorge
 */
//need to specify the container, in this case a Grid
//note that no DRFellowLink or DRRootEntity since them was defined on parent View Class
@DRGrid(id = "empconregGrid", width = "850px", cols=4)
public class RegisterCompanyContact {
	/**
     * company id.
     * <br/>
     * Is assignable in action EDIT, will be rendered at position 0 as a Textbox with a previous label with key catalogo.clave
     */
    @DRField(actions= FormActions.EDIT,label=@DRLabel(key="catalogo.clave"),order=0)
    @DRIntBox(readOnly=true)
    private Integer id;
	
	/**
     * company key or email.
     * <br/>
     * Is assignable in action ADD, will be rendered at position 3 as a Textbox with a previous label with key registro.email
     */
	//Validate a String regex pattern for the input text.
    @DRValidateStringPattern(pattern=".+@.+.[a-z]+")
    //Validate as mandatory
    @DRValidateNotEmpty
    //a custom validation, validate that there is not a duplicate key on records
    @DRValidateBusinessResult(action="mx.dr.ml.view.facade.CompanyFacade@companyByKey")
    @DRField(actions= {FormActions.ADD,FormActions.EDIT}, label =
    @DRLabel(key = "registro.email"), order = 3)
    @DRTextBox(maxlenght=49)
    private String key;
    
    /**
     * company password.
     * <br/>
     * Is assignable in action ADD, will be rendered at position 4 as a Textbox with a previous label with key registro.password
     */
    //validate a minimum of 6 character length
    @DRValidateLenght(lenght=6, mode= DRValidateLenght.MODE.MIN)
    //Validate as mandatory
    @DRValidateNotEmpty
    @DRField(actions= FormActions.ADD, label =
    @DRLabel(key = "registro.password"), order = 4)
    @DRTextBox(type = DRTextBox.TxtType.password,maxlenght=100)
    private String password;

    /**
     * company name of contact.
     * <br/>
     * Is assignable in actions ADD, EDIT, will be rendered at position 1 as a Textbox with a previous label with key registro.nombre.contacto
     * <br/>
     * d4zk supports depth in the root entity attributes, separating the attributes by the $ symbol. Will use the value of the attribute name in contact
     */
    @DRValidateNotEmpty
    @DRField(actions= {FormActions.ADD, FormActions.EDIT },label =
    @DRLabel(key = "registro.nombre.contacto"), order = 1)
    @DRTextBox(maxlenght=199)
    private String contact$name;


    /**
     * company phone number of contact.
     * <br/>
     * Is assignable in actions ADD, EDIT, will be rendered at position 2 as a Intbox with a previous label with key registro.telefono.contacto
     * <br/>
     * d4zk supports depth in the root entity attributes, separating the attributes by the $ symbol. Will use the value of the attribute name in contact
     */
    @DRField(actions= {FormActions.ADD, FormActions.EDIT },label =
    @DRLabel(key = "registro.telefono.contacto"), order = 2)
    //mask need to include jquery mask in zul and must change to drtextbox
    @DRIntBox(maxlenght=9/*, mask="(9999) 9999-9999"*/)
    private Integer contact$phone_number;

    /** 
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param clave the key to set
     */
    public void setKey(String clave) {
        this.key = clave;
    }

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
    
    
}
