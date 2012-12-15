/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
/**
 *
 * @author JLMR
 */
@DRFellowLink(action= FormActions.EDIT,fellow=FellowType.POPUP,
componentPath="//main/ccat",url="/pages/admin/buscarGeneral.zul?dto_class=mx.dr.ml.view.dto.SearchEmpresaMain&action=SEARCH",
        submitAction="mx.dr.ml.view.facade.UsuarioFacade@updateEmpresa",
        param="id",
        paramAction="mx.dr.ml.view.facade.CatalogoFacade@boById",
        sucessMessage=@DRMessage(label=@DRLabel(key="anuncio.msg.alta")))
@DRRootEntity(entity=mx.test.vo.Empresa.class)
public class EditEmpresaMain {


    @DRField(actions= FormActions.EDIT,isField=false, label=@DRLabel(key="registro.reg.comensal"))
    @DRGroupBox(mold=DRGroupBox.MOLD._3D, open=true, label=@DRLabel(key="registro.reg.info.fiscal"),width="800px")
    private RegisterEmpresaFiscal fiscal;
    

    @DRField(actions= FormActions.EDIT,isField=false, label=@DRLabel(key="registro.reg.comensal"))
    @DRGroupBox(mold=DRGroupBox.MOLD._3D, label=@DRLabel(key="registro.reg.localizacion"),width="800px")
    private RegisterEmpresaDireccion direccion;

    @DRField(actions= FormActions.EDIT,isField=false, label=@DRLabel(key="registro.reg.comensal"))
    @DRGroupBox(mold=DRGroupBox.MOLD._3D, label=@DRLabel(key="registro.reg.comensal"),width="800px")
    private EditEmpresa empresa;

    @DRField(actions= FormActions.EDIT, isField=false, label=@DRLabel(key="registro.reg.comensal"))
    @DRGroupBox(mold=DRGroupBox.MOLD._3D, label=@DRLabel(key="registro.reg.contacto"),width="800px")
    private EditEmpresaContacto contacto;

    public EditEmpresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EditEmpresa empresa) {
        this.empresa = empresa;
    }

    public EditEmpresaContacto getContacto() {
        return contacto;
    }

    
}
