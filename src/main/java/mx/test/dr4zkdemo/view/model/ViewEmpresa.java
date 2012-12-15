/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.test.dr4zkdemo.view.model;

import java.util.List;
import mx.dr.forms.constants.FormActions;
import mx.dr.forms.view.DRFellowLink;
import mx.dr.forms.view.DRField;
import mx.dr.forms.view.DRModel;
import mx.dr.forms.view.DRRootEntity;
import mx.dr.forms.view.component.DRGmaps;
import mx.dr.forms.view.component.DRImage;
import mx.dr.forms.view.component.DRLabel;

/**
 *
 * @author jorge
 */
@DRRootEntity(entity = mx.test.vo.Empresa.class)
@DRFellowLink(action= FormActions.READ,param = "id", paramAction = "mx.dr.ml.view.facade.UsuarioFacade@empresaById")
public class ViewEmpresa {

    private Integer id;

    @DRField(actions= FormActions.READ, readParent = "nombreRow", label =
    @DRLabel(key = DRLabel.NO_LABEL))
    @DRLabel(key = DRLabel.NO_LABEL,sclass="uptitulo")
    private String marca;
    
    @DRField(actions= FormActions.READ, readParent = "sloganRow", label =
    @DRLabel(key = DRLabel.NO_LABEL))
    @DRLabel(key = DRLabel.NO_LABEL,sclass="slogan")
    private String slogan;

    @DRField(actions= FormActions.READ, readParent = "imgPerfil", label =
    @DRLabel(key = DRLabel.NO_LABEL))
    @DRImage(width = "100px", prepend = "../..")
    private String adjunto$uri;
    
    @DRField(actions= FormActions.READ, readParent = "giro", label =
    @DRLabel(key = DRLabel.NO_LABEL))
    @DRLabel(key = DRLabel.NO_LABEL)
    private String categoria$nombre;

    @DRField(actions= FormActions.READ, readParent = "telefonoRow", label =
    @DRLabel(key = "empresa.telefono"))
    @DRLabel(key = DRLabel.NO_LABEL)
    private String telefono;

    @DRField(actions= FormActions.READ, readParent = "bioRow", label =
    @DRLabel(key = DRLabel.NO_LABEL))
    @DRLabel(key = DRLabel.NO_LABEL,sclass="bio")
    private String bio;

    @DRField(actions= FormActions.READ, readParent = "especialidad", label =
    @DRLabel(key = DRLabel.NO_LABEL))
    @DRLabel(key = DRLabel.NO_LABEL)
    private String especialidad;

    @DRField(actions= FormActions.READ, readParent = "calleRow", label =
    @DRLabel(key = DRLabel.NO_LABEL))
    @DRLabel(key = DRLabel.NO_LABEL)
    private String direccion$calle;


    @DRField(actions= FormActions.READ, readParent = "coloniaRow", label =
    @DRLabel(key = DRLabel.NO_LABEL))
    @DRLabel(key = DRLabel.NO_LABEL)
    private String direccion$colonia;

    @DRField(actions= FormActions.READ, readParent = "municipioRow", label =
    @DRLabel(key = DRLabel.NO_LABEL))
    @DRLabel(key = DRLabel.NO_LABEL)
    private String direccion$municipio;
    /*
    @DRReadField(parent = "cpRow", label =
    @DRLabel(key = "registro.cp"))
    @DRLabel(key = DRLabel.NO_LABEL)
    @DRBOField(field = "direccion.cp")
    private String cp;
    */
    @DRField(actions= FormActions.READ, readParent = "estadoRow", label =
    @DRLabel(key = DRLabel.NO_LABEL))
    @DRLabel(key = DRLabel.NO_LABEL)
    private String direccion$estado$nombre;

    @DRField(actions= FormActions.READ, readParent = "mapRow", label =
    @DRLabel(key = DRLabel.NO_LABEL))
    @DRGmaps(showLargeCtrl=true, width = "450px", height = "450px", latitude = "latitude", longitude = "longitude", gmarkContent="marca")
    private Double direccion$latitude;
    private Double direccion$longitude;

    @DRField(actions= FormActions.READ, readParent="fotosD", label =
    @DRLabel(key = DRLabel.NO_LABEL))
    @DRImage(width = "150px", prepend = "../..",rotate=false,minimages=6,nullimage="/temp/0.png")
    @DRModel(model="mx.dr.ml.view.facade.UsuarioFacade@requestPhotosEmpresa", modelParams={"id"})
    private List fotos;

    public Double getDireccion$latitude() {
        return direccion$latitude;
    }

    public Double getDireccion$longitude() {
        return direccion$longitude;
    }


    

    public String getMarca() {
        return marca;
    }

    public Integer getId() {
        return id;
    }
    
    
}
