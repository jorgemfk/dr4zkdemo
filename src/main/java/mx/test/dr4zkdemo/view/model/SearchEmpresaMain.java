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
@DRFellowLink(action= FormActions.SEARCH, submitAction="mx.dr.ml.view.facade.CatalogoFacade@findByExampleDTO", resultsComponent=@DRListBox(header=true,id="resultado_empresas",itemRenderer=mx.dr.forms.zul.DRResultsListRender.class, dtoResult=SearchEmpresaMain.class))
, @DRFellowLink(action= FormActions.LIST, param="id",fellow=FellowType.POPUP,componentPath="//main/ccat",listLabel=@DRLabel(key="catalogo.editar"),url="/pages/admin/editEmpresa.zul?dto_class=mx.dr.ml.view.dto.empresa.EditEmpresaMain&action=EDIT")
})
@DRGrid(id="emregGrid",width="700px")
@DRRootEntity(entity=mx.test.vo.Empresa.class)
public class SearchEmpresaMain extends Base{

    @DRValidateNotEmpty(applySearch=true)
    @DRField(actions= {FormActions.SEARCH, FormActions.LIST}, label=@DRLabel(key="empresa.nombre"),order=2,searchOperador=DRField.Operator.LIKE)
    @DRTextBox(maxlenght=50)
    private String marca;

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
