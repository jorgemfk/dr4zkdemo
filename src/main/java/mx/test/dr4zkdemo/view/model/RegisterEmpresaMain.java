/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.test.dr4zkdemo.view.model;

import mx.dr.forms.constants.FellowType;
import mx.dr.forms.constants.FormActions;
import mx.dr.forms.view.DRFellowLink;
import mx.dr.forms.view.DRField;
import mx.dr.forms.view.DRRootEntity;
import mx.dr.forms.view.component.DRGroupBox;
import mx.dr.forms.view.component.DRLabel;

/**
 *
 * @author jorge
 */

@DRFellowLink(action= FormActions.ADD,fellow=FellowType.NEW,componentPath="//main/ctab",url="/registrarSucess.jsp",submitAction="mx.dr.ml.view.facade.UsuarioFacade@saveNewEmpresa")
@DRRootEntity(entity=mx.test.vo.Empresa.class)
public class RegisterEmpresaMain {

    @DRField(actions= FormActions.ADD,isField=false, label=@DRLabel(key="registro.reg.comensal"))
    @DRGroupBox(mold=DRGroupBox.MOLD._3D, label=@DRLabel(key="registro.reg.localizacion"),width="900px")
    private RegisterEmpresaDireccion direccion;

    @DRField(actions= FormActions.ADD,isField=false, label=@DRLabel(key="registro.reg.comensal"))
    @DRGroupBox(mold=DRGroupBox.MOLD._3D, label=@DRLabel(key="registro.reg.comensal"),width="900px")
    private RegisterEmpresa empresa;

    @DRField(actions= FormActions.ADD,isField=false, label=@DRLabel(key="registro.reg.comensal"))
    @DRGroupBox(mold=DRGroupBox.MOLD._3D, label=@DRLabel(key="registro.reg.contacto"),width="900px")
    private RegisterEmpresaContacto contacto;

    public RegisterEmpresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(RegisterEmpresa empresa) {
        this.empresa = empresa;
    }


}
