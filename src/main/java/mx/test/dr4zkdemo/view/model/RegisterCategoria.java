/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
import mx.test.vo.CategoriaMain;
import mx.dr.util.Base;


/**
 *
 * @author JLMR
 */

@DRActions(actions={@DRFellowLink(action=FormActions.LIST, param="id",fellow=FellowType.SELF,componentPath="//main/ccat",listLabel=@DRLabel(key="catalogo.editar"),url="/regCategoria.zul?dto_class=mx.test.dl.RegisterCategoria&action=EDIT"),
@DRFellowLink(action=FormActions.ADD, fellow=FellowType.SELF,componentPath="//main/ccat",url="/busCategoria.zul?dto_class=mx.test.dl.RegisterCategoria&action=SEARCH",submitAction="mx.dr.ml.view.facade.CatalogoFacade@save"),
@DRFellowLink(action=FormActions.EDIT, fellow=FellowType.SELF,componentPath="//main/ccat",url="/busCategoria.zul?dto_class=mx.test.dl.RegisterCategoria&action=SEARCH",submitAction="mx.dr.ml.view.facade.CatalogoFacade@save", param="id", paramAction="mx.dr.ml.view.facade.CatalogoFacade@boById"),
@DRFellowLink(action=FormActions.SEARCH, submitAction="mx.dr.ml.view.facade.CatalogoFacade@findByExampleDTO", resultsComponent=@DRListBox(header=true,id="resultado_categorias",itemRenderer=mx.dr.forms.zul.DRResultsListRender.class, dtoResult=RegisterCategoria.class))})
@DRGrid(id="comregGrid",width="700px")
@DRRootEntity(entity=mx.test.vo.Categoria.class)
public class RegisterCategoria extends Base{
    

    @DRField(label=@DRLabel(key="categoria.nombre"),order=2,columnListWidth="300px",searchOperador=DRField.Operator.LIKE, liveValidate=true, actions={FormActions.ADD, FormActions.EDIT, FormActions.SEARCH, FormActions.LIST})
    @DRTextBox(maxlenght=50)
    @DRValidateNotEmpty
    @DRValidateBusinessResult(action="mx.dr.ml.view.facade.CategoriaFacade@validaXNombre")
    private String nombre;
    
    @DRField(label=@DRLabel(key="catalogo.id"),order=1, actions={FormActions.EDIT})
    @DRIntBox(readOnly=true)
    @DRValidateNotEmpty
    private Integer id;

    @DRField(label=@DRLabel(key="catalogo.status"),order=6, actions={FormActions.EDIT})
    @DRListBox(mold=DRListBox.MOLD.SELECT, itemRenderer=mx.dr.forms.zul.DRResultsListSimpleRender.class,
    model="mx.dr.ml.view.facade.CatalogoFacade@getCatalogStatus") 
    @DRValidateNotEmpty 
    private CatalogStatus estatusEnum;

    
    @DRField(label=@DRLabel(key="categoria.padre"),order=5, actions={FormActions.EDIT, FormActions.ADD})
    @DRListBox(mold=DRListBox.MOLD.SELECT, itemRenderer=mx.dr.forms.zul.DRResultsListSimpleRender.class,         
    model="mx.dr.ml.view.facade.CategoriaFacade@findCategoriasPadre")
    @DRValidateNotEmpty 
    private CategoriaMain padre;

    private String algo$dumy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
