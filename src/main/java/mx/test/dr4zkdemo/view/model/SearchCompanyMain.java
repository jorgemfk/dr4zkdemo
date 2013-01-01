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


import mx.dr.forms.view.DRRootEntity;
import mx.dr.forms.view.component.DRGrid;
import mx.dr.forms.view.component.DRTextBox;
import mx.dr.forms.view.component.DRLabel;
import mx.dr.forms.view.component.DRListBox;
import mx.dr.forms.constants.FellowType;
import mx.dr.forms.constants.FormActions;
import mx.dr.forms.view.DRActions;
import mx.dr.forms.view.DRFellowLink;
import mx.dr.forms.view.DRField;
import mx.dr.forms.view.component.DRIntBox;
import mx.dr.forms.view.validable.DRValidateNotEmpty;
import mx.dr.util.Base;
/**
 *
 * @author JLMR
 */
@DRActions(actions={
@DRFellowLink(action= FormActions.SEARCH, submitAction="mx.dr.ml.view.facade.CatalogFacade@findByExampleDTO", resultsComponent=@DRListBox(header=true,id="resultado_empresas",itemRenderer=mx.dr.forms.zul.DRResultsListRender.class, dtoResult=SearchCompanyMain.class))
, @DRFellowLink(action= FormActions.LIST, param="id",fellow=FellowType.POPUP,componentPath="//main/ccat",listLabel=@DRLabel(key="catalogo.editar"),url="/pages/admin/editCompany.zul?dto_class=mx.dr.ml.view.dto.empresa.EditCompanyMain&action=EDIT")
})
@DRGrid(id="emregGrid",width="700px")
@DRRootEntity(entity=mx.test.vo.Company.class)
public class SearchCompanyMain extends Base{

    @DRValidateNotEmpty(applySearch=true)
    @DRField(actions= {FormActions.SEARCH, FormActions.LIST}, label=@DRLabel(key="empresa.nombre"),order=2,searchOperador=DRField.Operator.LIKE)
    @DRTextBox(maxlenght=50)
    private String brand;

    @DRField(actions= {FormActions.SEARCH, FormActions.LIST}, label=@DRLabel(key="catalogo.clave"),order=1,searchOperador=DRField.Operator.EQUALS)
    @DRIntBox(maxlenght=50)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
}