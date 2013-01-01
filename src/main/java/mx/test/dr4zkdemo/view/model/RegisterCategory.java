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
import mx.dr.forms.view.*;
import mx.dr.forms.view.component.DRIntBox;
import mx.dr.forms.view.validable.DRValidateBusinessResult;
import mx.dr.forms.view.validable.DRValidateNotEmpty;
import mx.test.vo.CatalogStatus;
import mx.test.vo.MainCategory;
import mx.dr.util.Base;


/**
 *
 * @author JLMR
 */

@DRActions(actions={@DRFellowLink(action=FormActions.LIST, param="id",fellow=FellowType.SELF,componentPath="//main/myInclude",listLabel=@DRLabel(key="catalogo.editar"),url="/registerCategory.zul?dto_class=mx.test.dr4zkdemo.view.model.RegisterCategory&action=EDIT"),
@DRFellowLink(action=FormActions.ADD, fellow=FellowType.SELF,componentPath="//main/myInclude",url="/genericFind.zul?dto_class=mx.test.dr4zkdemo.view.model.RegisterCategory&action=SEARCH",submitAction="mx.dr.ml.view.facade.CatalogFacade@save"),
@DRFellowLink(action=FormActions.EDIT, fellow=FellowType.SELF,componentPath="//main/myInclude",url="/genericFind.zul?dto_class=mx.test.dr4zkdemo.view.model.RegisterCategory&action=SEARCH",submitAction="mx.dr.ml.view.facade.CatalogFacade@save", param="id", paramAction="mx.dr.ml.view.facade.CatalogFacade@boById"),
@DRFellowLink(action=FormActions.SEARCH, submitAction="mx.dr.ml.view.facade.CatalogFacade@findByExampleDTO", resultsComponent=@DRListBox(header=true,id="resultado_categorias",itemRenderer=mx.dr.forms.zul.DRResultsListRender.class, dtoResult=RegisterCategory.class))})
@DRGrid(id="comregGrid",width="700px")
@DRRootEntity(entity=mx.test.vo.Category.class)
public class RegisterCategory extends Base{
    

    @DRField(label=@DRLabel(key="categoria.nombre"),order=2,columnListWidth="300px",searchOperador=DRField.Operator.LIKE, liveValidate=true, actions={FormActions.ADD, FormActions.EDIT, FormActions.SEARCH, FormActions.LIST})
    @DRTextBox(maxlenght=50)
    @DRValidateNotEmpty
    @DRValidateBusinessResult(action="mx.dr.ml.view.facade.CategoryFacade@validateXName")
    private String name;
    
    @DRField(label=@DRLabel(key="catalogo.id"),order=1, actions={FormActions.EDIT})
    @DRIntBox(readOnly=true)
    @DRValidateNotEmpty
    private Integer id;

    @DRField(label=@DRLabel(key="catalogo.status"),order=6, actions={FormActions.EDIT})
    @DRListBox(mold=DRListBox.MOLD.SELECT, itemRenderer=mx.dr.forms.zul.DRResultsListSimpleRender.class,
    model="mx.dr.ml.view.facade.CatalogFacade@getCatalogStatus") 
    @DRValidateNotEmpty 
    private CatalogStatus estatusEnum;

    
    @DRField(label=@DRLabel(key="categoria.padre"),order=5, actions={FormActions.EDIT, FormActions.ADD})
    @DRListBox(mold=DRListBox.MOLD.SELECT, itemRenderer=mx.dr.forms.zul.DRResultsListSimpleRender.class,         
    model="mx.dr.ml.view.facade.CategoryFacade@findMainCategory")
    @DRValidateNotEmpty 
    private MainCategory father;

    private String will$not$pass;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }
    
    
}
