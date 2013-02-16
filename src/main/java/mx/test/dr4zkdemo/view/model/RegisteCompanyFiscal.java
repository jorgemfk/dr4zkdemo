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
import mx.dr.forms.view.component.DRTextBox;
import mx.dr.forms.view.component.DRLabel;
import mx.dr.forms.view.component.DRListBox;
import mx.dr.forms.view.validable.DRValidateStringPattern;
import mx.test.vo.City;



/**
 * Composite view Class for Company fiscal address.
 * @author jorge
 */
//need to specify the container, in this case a Grid
//note that no DRFellowLink or DRRootEntity since them was defined on parent View Class
@DRGrid(id = "empfisregGrid", width = "700px")
public class RegisteCompanyFiscal {

	/**
     * company fiscal name.
     * <br/>
     * Is assignable in actions EDIT, will be rendered at position 1 as a Textbox with a previous label with key registro.razon.social"
     * <br/>
     * d4zk supports depth in the root entity attributes, separating the attributes by the $ symbol. Will use the value of the attribute fiscalName in fiscalRegistry
     */
	@DRField(actions= FormActions.EDIT, label =
			@DRLabel(key = "registro.razon.social"), order = 1)
	@DRTextBox(maxlenght = 199)
	private String fiscalRegistry$fiscalName;
	
	/**
     * company fiscal rfc.
     * <br/>
     * Is assignable in actions EDIT, will be rendered at position 2 as a Textbox with a previous label with key registro.calle"
     * <br/>
     * d4zk supports depth in the root entity attributes, separating the attributes by the $ symbol. Will use the value of the attribute street in rfc of fiscalRegistry
     */
	@DRValidateStringPattern(pattern="^([A-Z]{4}|[A-Z]{3})\\d{6}([A-Z\\w]{3})$")
	@DRField(actions= FormActions.EDIT,label =
	@DRLabel(key = "registro.rfc"), order = 2)
	@DRTextBox(maxlenght = 13,uppercase=true)
	private String fiscalRegistry$rfc;
	/**
     * company fiscal street address.
     * <br/>
     * Is assignable in actions EDIT, will be rendered at position 3 as a Textbox with a previous label with key registro.calle"
     * <br/>
     * d4zk supports depth in the root entity attributes, separating the attributes by the $ symbol. Will use the value of the attribute street in fiscalAddress of fiscalRegistry
     */
	@DRField(actions= FormActions.EDIT,label =
			@DRLabel(key = "registro.calle"), order = 3)
	@DRTextBox(maxlenght = 299)
	private String fiscalRegistry$fiscalAddress$street;
	/**
     * company fiscal zip code address.
     * <br/>
     * Is assignable in actions EDIT, will be rendered at position 4 as a Textbox with a previous label with key registro.cp"
     * <br/>
     * d4zk supports depth in the root entity attributes, separating the attributes by the $ symbol. Will use the value of the attribute zip in fiscalAddress of fiscalRegistry
     */
	@DRField(actions= FormActions.EDIT,label =
			@DRLabel(key = "registro.cp"), order = 4)
	@DRTextBox(maxlenght = 5)
	private String fiscalRegistry$fiscalAddress$cp;
	/**
     * company city fiscal address.
     * <br/>
     * Is assignable in actions EDIT, will be rendered at position 5 as a Listbox with a previous label with key registro.estado
     * <br/>
     * d4zk supports depth in the root entity attributes, separating the attributes by the $ symbol. Will use the value of the attribute city in fiscalAddress of fiscalRegistry
     */
	@DRField(actions= FormActions.EDIT,label =
			@DRLabel(key = "registro.estado"), order = 5)
	@DRListBox(mold = DRListBox.MOLD.SELECT, itemRenderer = mx.dr.forms.zul.DRResultsListSimpleRender.class, model = "mx.dr.ml.view.facade.CityFacade@findMXCities")
	private City fiscalRegistry$fiscalAddress$city;
}
