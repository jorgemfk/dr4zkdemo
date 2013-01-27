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

import mx.dr.forms.constants.FormActions;
import mx.dr.forms.view.DRFellowLink;
import mx.dr.forms.view.DRField;
import mx.dr.forms.view.DRRootEntity;
import mx.dr.forms.view.component.DRGmaps;
import mx.dr.forms.view.component.DRHtml;
import mx.dr.forms.view.component.DRImage;
import mx.dr.forms.view.component.DRLabel;

/**
 *
 * @author jorge
 */
@DRRootEntity(entity = mx.test.vo.Company.class)
@DRFellowLink(action= FormActions.READ,param = "id", paramAction = "mx.dr.ml.view.facade.CompanyFacade@companyById")
public class ViewCompany {

    private Integer id;

    @DRField(actions= FormActions.READ, readParent = "nombreRow", label =
    @DRLabel(key = DRLabel.NO_LABEL))
    @DRLabel(key = DRLabel.NO_LABEL,sclass="uptitulo")
    private String brand;
    
    @DRField(actions= FormActions.READ, readParent = "sloganRow", label =
    @DRLabel(key = DRLabel.NO_LABEL))
    @DRLabel(key = DRLabel.NO_LABEL)
    private String slogan;

    @DRField(actions= FormActions.READ, readParent = "imgPerfil", label =
    @DRLabel(key = DRLabel.NO_LABEL))
    @DRImage(width = "100px", prepend = ".")
    private String logo$uri;
    
    @DRField(actions= FormActions.READ, readParent = "giro", label =
    @DRLabel(key = DRLabel.NO_LABEL))
    @DRLabel(key = DRLabel.NO_LABEL)
    private String category$name;

    @DRField(actions= FormActions.READ, readParent = "telefonoRow", label =
    @DRLabel(key = "empresa.telefono"))
    @DRLabel(key = DRLabel.NO_LABEL)
    private String phone;

    @DRField(actions= FormActions.READ, readParent = "bioRow", label =
    @DRLabel(key = DRLabel.NO_LABEL))
    @DRHtml()
    private String bio;

    @DRField(actions= FormActions.READ, readParent = "especialidad", label =
    @DRLabel(key = DRLabel.NO_LABEL))
    @DRLabel(key = DRLabel.NO_LABEL)
    private String specialty;

    @DRField(actions= FormActions.READ, readParent = "calleRow", label =
    @DRLabel(key = DRLabel.NO_LABEL))
    @DRLabel(key = DRLabel.NO_LABEL)
    private String address$street;

    @DRField(actions= FormActions.READ, readParent = "estadoRow", label =
    @DRLabel(key = DRLabel.NO_LABEL))
    @DRLabel(key = DRLabel.NO_LABEL)
    private String address$city$name;

    @DRField(actions= FormActions.READ, readParent = "mapRow", label =
    @DRLabel(key = DRLabel.NO_LABEL))
    @DRGmaps(showLargeCtrl=true, width = "450px", height = "450px", latitude = "address$latitude", longitude = "address$longitude", gmarkContent="brand")
    private Double address$latitude;
    private Double address$longitude;
/*
 * example view multiple images, doesn't working for this example.
    @DRField(actions= FormActions.READ, readParent="fotosD", label =
    @DRLabel(key = DRLabel.NO_LABEL))
    @DRImage(width = "150px", prepend = "../..",rotate=false,minimages=6,nullimage="/temp/0.png")
    @DRModel(model="mx.dr.ml.view.facade.CompanyFacade@requestPhotosEmpresa", modelParams={"id"})
    private List photos;
*/
    public Double getAddress$latitude() {
        return address$latitude;
    }

    public Double getAddress$longitude() {
        return address$longitude;
    }

    public String getBrand() {
        return brand;
    }

    public Integer getId() {
        return id;
    }
    
    
}
