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
import mx.dr.forms.view.DRMessage;
import mx.dr.forms.view.DRRootEntity;
import mx.dr.forms.view.component.DRTabPanel;
import mx.dr.forms.view.component.DRLabel;
import mx.dr.forms.view.component.DRTabBox;
/**
 * View class that is readable in action EDIT, it uses a object Company as a wrapper to fill it's content. 
 * <br/>In EDIT action the submitAction is the method to save a new Company, on success will show the defined successMessage, the fellowType will define how the next URL will be displayed.
 * @author jorge
 */
//componentPath is necessary on FellowType.SELF (ajax render)
@DRFellowLink(action= FormActions.EDIT,fellow=FellowType.POPUP,
componentPath="//main/myInclude",url="/genericFind.zul?dto_class=mx.test.dr4zkdemo.view.model.SearchCompanyMain&action=SEARCH",
        submitAction="mx.dr.ml.view.facade.CompanyFacade@updateCompany",
        param="id",
        paramAction="mx.dr.ml.view.facade.CatalogFacade@boById",
        successMessage=@DRMessage(label=@DRLabel(key="anuncio.msg.alta")))
@DRRootEntity(entity=mx.test.vo.Company.class)
//Define the Tabbox container
@DRTabBox(width="900px")
public class EditCompanyMain {

	/**
     * composite fiscal info form.
     * <br/>
     * Is assignable in actions EDIT, will be rendered at position 4 as a TabPanel container with title registro.reg.localizacion
     */
    @DRField(actions= FormActions.EDIT,isField=false, label=@DRLabel(key="registro.reg.info.fiscal"), order=4)
    @DRTabPanel
    private RegisteCompanyFiscal fiscal;
    
    /**
     * composite address form.
     * <br/>
     * Is assignable in actions EDIT, will be rendered at position 3 as a TabPanel container with title registro.reg.localizacion
     */
    @DRField(actions= FormActions.EDIT,isField=false, label=@DRLabel(key="registro.reg.localizacion"), order=3)
    @DRTabPanel
    private RegisterCompanyAddress address;
    
    /**
     * composite company form.
     * <br/>
     * Is assignable in actions EDIT, will be rendered at position 2 as a TabPanel container with title registro.reg.comensal
     */
    @DRField(actions= FormActions.EDIT,isField=false, label=@DRLabel(key="registro.reg.comensal"), order=2)
    @DRTabPanel
    private EditCompany company;

    /**
     * composite contact form.
     * <br/>
     * Is assignable in actions EDIT, will be rendered at position 1 as a TabPanel container with title registro.reg.contacto
     */
    @DRField(actions= FormActions.EDIT, isField=false, label=@DRLabel(key="registro.reg.contacto"), order=1)
    @DRTabPanel
    private RegisterCompanyContact contact;

    /**
     * 
     * @return the composite Company form
     */
    public EditCompany getCompany() {
        return company;
    }
    /**
     * 
     * @param empresa the composite company form to set
     */
    public void setCompany(EditCompany empresa) {
        this.company = empresa;
    }

    /**
     * 
     * @return the composite Company contact form
     */
    public RegisterCompanyContact getContact() {
        return contact;
    }

    
}
