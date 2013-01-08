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
import mx.dr.forms.view.component.*;
import mx.dr.forms.view.validable.DRValidateCaptcha;
import mx.dr.forms.view.validable.DRValidateNotEmpty;
import mx.test.vo.City;

/**
 *
 * @author jorge
 */
@DRGrid(id="empdirregGrid",width="850px")
public class RegisterCompanyAddress {

@DRValidateNotEmpty
    @DRField(actions= {FormActions.ADD, FormActions.EDIT },label=@DRLabel(key="registro.calle"),order=1)
@DRTextBox(rows=5,maxlenght=299)
private String address$street;


@DRValidateNotEmpty
    @DRField(actions= {FormActions.ADD, FormActions.EDIT },label=@DRLabel(key="registro.estado"),order=2)
@DRListBox(mold=DRListBox.MOLD.SELECT, itemRenderer=mx.dr.forms.zul.DRResultsListSimpleRender.class
,model="mx.dr.ml.view.facade.CityFacade@findMXCities")
private City address$city;

@DRValidateNotEmpty
    @DRField(actions= {FormActions.ADD, FormActions.EDIT },label=@DRLabel(key="registro.latitud"),order=3)
@DRDecimalBox(format="#.000000")
private Double address$latitude;

@DRValidateNotEmpty
    @DRField(actions= {FormActions.ADD, FormActions.EDIT },label=@DRLabel(key="registro.longitud"),order=4)
@DRDecimalBox(format="#.000000")
private Double address$longitude;

@DRField(actions= {FormActions.ADD },label=@DRLabel(key=DRLabel.NO_LABEL),order=5)
@DRValidateCaptcha
@DRCaptcha
private String strcaptcha;
}
