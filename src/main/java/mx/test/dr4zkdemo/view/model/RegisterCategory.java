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

import mx.dr.forms.view.DRFellowLink;
import mx.dr.forms.view.DRMessage;
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
 * View class that is readable in action SEARCH, READ, ADD and EDIT, it uses a object Category as a wrapper to fill it's content. 
 * <br/>In ADD and EDIT action the submitAction is the method to save a new Category, on success will show the defined successMessage, the fellowType will define how the next URL will be displayed.
 * <br/>In READ action, paramAction is the method to search the given Category by the id value
 * <br/>In SEARCH action the submitAction is the method to search the category given by the valued attributes marked as SEARCH DRfields.
 * <br/>The links with action LIST will render an action link to other view page passing the value of the defined parameter id.
 * The fellowType is the method how this new pages will be displayed (NEW page, POPUP)
 * @author jorge
 */
@DRActions(actions={
		@DRFellowLink(action=FormActions.LIST, param="id",fellow=FellowType.SELF,componentPath="//main/myInclude",listLabel=@DRLabel(key="catalogo.editar"),url="/registerCategory.zul?dto_class=mx.test.dr4zkdemo.view.model.RegisterCategory&action=EDIT"),
	    //componentPath is necessary on FellowType.SELF (ajax render)
		@DRFellowLink(action= FormActions.LIST, param="id",fellow=FellowType.SELF,componentPath="//main/myInclude",listLabel=@DRLabel(key="catalogo.ver"),url="/viewCategory.zul?dto_class=mx.test.dr4zkdemo.view.model.RegisterCategory&action=READ"),
	    @DRFellowLink(action= FormActions.READ,param = "id", paramAction = "mx.dr.ml.view.facade.CatalogFacade@boById"),
		@DRFellowLink(action=FormActions.ADD, fellow=FellowType.SELF,componentPath="//main/myInclude",url="/genericFind.zul?dto_class=mx.test.dr4zkdemo.view.model.RegisterCategory&action=SEARCH",submitAction="mx.dr.ml.view.facade.CatalogFacade@save",successMessage=@DRMessage(label=@DRLabel(key="anuncio.msg.alta"))),
		@DRFellowLink(action=FormActions.EDIT, fellow=FellowType.SELF,componentPath="//main/myInclude",url="/genericFind.zul?dto_class=mx.test.dr4zkdemo.view.model.RegisterCategory&action=SEARCH",submitAction="mx.dr.ml.view.facade.CatalogFacade@save", successMessage=@DRMessage(label=@DRLabel(key="anuncio.msg.update")), param="id", paramAction="mx.dr.ml.view.facade.CatalogFacade@boById"),
		@DRFellowLink(action=FormActions.SEARCH, submitAction="mx.dr.ml.view.facade.CatalogFacade@findByExampleDTO",loadOnInit=true, resultsComponent=@DRListBox(header=true,id="resultado_categorias",itemRenderer=mx.dr.forms.zul.DRResultsListRender.class, dtoResult=RegisterCategory.class))})
@DRGrid(id="comregGrid",width="700px")
@DRRootEntity(entity=mx.test.vo.Category.class)
public class RegisterCategory extends Base{


	/**
	 * serial
	 */
	private static final long serialVersionUID = 837033246769654984L;

	/**
     * category name.
     * <br/>
     * Is readable in action READ, will be render as a Textbox as child of readParent component.
     * <br/>
     * Is assignable in actions SEARCH, ADD, EDIT, will be rendered at position 2 as a Textbox with a previous label with key categoria.nombre
     * <br/>
     * In LIST action it will be rendered as a column in the search results listbox, and its value will apply a like operator in sql query
     */
	@DRField(label=@DRLabel(key="categoria.nombre"),order=2,columnListWidth="300px",searchOperador=DRField.Operator.LIKE, liveValidate=true, actions={FormActions.ADD, FormActions.EDIT, FormActions.SEARCH, FormActions.LIST, FormActions.READ},readParent="nameRow")
	@DRTextBox(maxlenght=50)
	//mandatory capture
	@DRValidateNotEmpty
	@DRValidateBusinessResult(action="mx.dr.ml.view.facade.CategoryFacade@validateXName")
	private String name;

	/**
     * category id.
     * <br/>
     * Is readable in action READ, will be render as a read only Textbox as child of readParent component.
     * <br/>
     * Is assignable in action EDIT, will be rendered at position 1 as a read only Textbox with a previous label with key catalogo.id
     */
	@DRField(label=@DRLabel(key="catalogo.id"),order=1, actions={FormActions.EDIT, FormActions.READ},readParent="keyRow")
	@DRIntBox(readOnly=true)
	private Integer id;

	/**
     * category status.
     * <br/>
     * Is assignable in action EDIT, will be rendered at position 6 as a Listbox with a previous label with key catalogo.status
     */
	@DRField(label=@DRLabel(key="catalogo.status"),order=6, actions={FormActions.EDIT})
	//model method must return a collection of the possible values in list
	@DRListBox(mold=DRListBox.MOLD.SELECT, itemRenderer=mx.dr.forms.zul.DRResultsListSimpleRender.class,
	model="mx.dr.ml.view.facade.CatalogFacade@getCatalogStatus") 
	//mandatory capture
	@DRValidateNotEmpty 
	private CatalogStatus estatusEnum;


	/**
     * parent category.
     * <br/>
     * Is assignable in actions EDIT, ADD, will be rendered at position 5 as a Listbox with a previous label with key categoria.padre
     */
	@DRField(label=@DRLabel(key="categoria.padre"),order=5, actions={FormActions.EDIT, FormActions.ADD})
	@DRListBox(mold=DRListBox.MOLD.SELECT, itemRenderer=mx.dr.forms.zul.DRResultsListSimpleRender.class,         
	model="mx.dr.ml.view.facade.CategoryFacade@findMainCategory")
	//mandatory capture
	@DRValidateNotEmpty 
	private MainCategory father;

	/**
     * category status description.
     * <br/>
     * Is readable in action READ, will be render as a Label as child of readParent component with a previous label with key catalogo.status.
     */
	@DRField(actions= FormActions.READ, readParent="status", label =
			@DRLabel(key = "catalogo.status"))
	@DRLabel(key = DRLabel.NO_LABEL)
	private String estatusEnum$labelDescription;
	
	/**
     * parent category name
     * <br/>
     * Is readable in action READ, will be render as a Label as child of readParent component with a previous label with key catalogo.status.
     * <br/>
     * d4zk supports depth in the root entity attributes, separating the attributes by the $ symbol. Will use the value of the attribute name in father.
     */
	@DRField(actions= FormActions.READ, readParent="categoryRow", label =
			@DRLabel(key = "categoria.padre"))
	@DRLabel(key = DRLabel.NO_LABEL)
	private String father$name;
	
	/**
     * list of companies in the given category
     * <br/>
     * Is readable in action READ, will be render as a listbox as child of readParent component with a previous label with key empresa.nombre.
     */
	@DRField(actions= FormActions.READ, readParent="companiesRow", label =
			@DRLabel(key = "empresa.nombre"))
	//Is possible to pass parameters through the model method, them must be mapped on this view Class, in this case the id. the dtoResults is the class where the attributes LIST are defined to renderer the list columns
	@DRListBox(header=false,model="mx.dr.ml.view.facade.CompanyFacade@requestByCategory",modelParams={"id"},dtoResult=SearchCompanyMain.class)
	private List companies;

	//not necessary all attributes must be mapped, this attribute is not usable in this example
	private String will$not$pass;

	/**
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param nombre the nombre to set
	 */
	public void setName(String nombre) {
		this.name = nombre;
	}


}
