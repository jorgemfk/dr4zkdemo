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
import mx.dr.forms.view.component.DRGroupBox;
import mx.dr.forms.view.component.DRLabel;
import mx.dr.forms.view.component.DRTabBox;
import mx.dr.forms.view.component.DRTabPanel;
/**
 *
 * @author JLMR
 */
@DRFellowLink(action= FormActions.EDIT,fellow=FellowType.POPUP,
componentPath="//main/myInclude",url="/genericFind.zul?dto_class=mx.test.dr4zkdemo.view.model.SearchCompanyMain&action=SEARCH",
        submitAction="mx.dr.ml.view.facade.CompanyFacade@updateCompany",
        param="id",
        paramAction="mx.dr.ml.view.facade.CatalogFacade@boById",
        sucessMessage=@DRMessage(label=@DRLabel(key="anuncio.msg.alta")))
@DRRootEntity(entity=mx.test.vo.Company.class)
@DRTabBox(width="900px")
public class EditCompanyMain {


    @DRField(actions= FormActions.EDIT,isField=false, label=@DRLabel(key="registro.reg.info.fiscal"), order=4)
    @DRTabPanel
    private RegisteCompanyFiscal fiscal;
    

    @DRField(actions= FormActions.EDIT,isField=false, label=@DRLabel(key="registro.reg.localizacion"), order=3)
    @DRTabPanel
    private RegisterCompanyAddress address;

    @DRField(actions= FormActions.EDIT,isField=false, label=@DRLabel(key="registro.reg.comensal"), order=2)
    @DRTabPanel
    private EditCompany company;

    @DRField(actions= FormActions.EDIT, isField=false, label=@DRLabel(key="registro.reg.contacto"), order=1)
    @DRTabPanel
    private EditCompanyContact contact;

    public EditCompany getCompany() {
        return company;
    }

    public void setCompany(EditCompany empresa) {
        this.company = empresa;
    }

    public EditCompanyContact getContact() {
        return contact;
    }

    
}
