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

import mx.dr.forms.constants.FellowType;
import mx.dr.forms.constants.FormActions;
import mx.dr.forms.view.DRFellowLink;
import mx.dr.forms.view.DRField;
import mx.dr.forms.view.DRRootEntity;
import mx.dr.forms.view.component.DRGrid;
import mx.dr.forms.view.component.DRGroupBox;
import mx.dr.forms.view.component.DRLabel;

/**
 * View class that is readable in action ADD, it uses a object Company as a wrapper to fill it's content. 
 * <br/>In ADD action the submitAction is the method to save a new Company, on success will show the defined successMessage, the fellowType will define how the next URL will be displayed.
 * @author jorge
 */
//componentPath is necessary on FellowType.SELF (ajax render)
@DRFellowLink(action= FormActions.ADD,fellow=FellowType.SELF,componentPath="//main/myInclude",url="/genericFind.zul?dto_class=mx.test.dr4zkdemo.view.model.SearchCompanyMain&action=SEARCH",submitAction="mx.dr.ml.view.facade.CompanyFacade@saveNewCompany")
@DRRootEntity(entity=mx.test.vo.Company.class)
@DRGrid(id="registerComGrid", cols=1,width="950px")
public class RegisterCompanyMain {

	/**
     * composite contact form.
     * <br/>
     * Is assignable in actions ADD, will be rendered at position 1 as a Groupbox container with title registro.reg.contacto
     */
    @DRField(actions= FormActions.ADD,isField=false, order=1, label=@DRLabel(key="registro.reg.contacto"))
    @DRGroupBox(mold=DRGroupBox.MOLD._3D,width="900px")  
    private RegisterCompanyContact contact;
	 /**
     * composite company form.
     * <br/>
     * Is assignable in actions ADD, will be rendered at position 2 as a Groupbox container with title registro.reg.comensal
     */
    @DRField(actions= FormActions.ADD,isField=false, order=2, label=@DRLabel(key="registro.reg.comensal"))
    @DRGroupBox(mold=DRGroupBox.MOLD._3D,width="900px")
    private RegisterCompany company;
    
	/**
     * composite address form.
     * <br/>
     * Is assignable in actions ADD, will be rendered at position 3 as a Groupbox container with title registro.reg.localizacion
     */
    @DRField(actions= FormActions.ADD,isField=false, order=3, label=@DRLabel(key="registro.reg.localizacion"))
    @DRGroupBox(mold=DRGroupBox.MOLD._3D,width="900px")
    private RegisterCompanyAddress address;


    /**
     * 
     * @return the composite Company form
     */
    public RegisterCompany getCompany() {
        return company;
    }

    /**
     * 
     * @param empresa the composite company form to set
     */
    public void setCompany(RegisterCompany empresa) {
        this.company = empresa;
    }


}
