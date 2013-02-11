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
import mx.test.dr4zkdemo.custom.DRLink;

/**
 * View class that is readable in action READ, it uses a object Company as a wrapper to fill it's content. paramAction is the method to search the company given by the id value.
 * @author jorge
 */
@DRRootEntity(entity = mx.test.vo.Company.class)
@DRFellowLink(action= FormActions.READ,param = "id", paramAction = "mx.dr.ml.view.facade.CompanyFacade@companyById")
public class ViewCompany {

	/**
	 * company id, not mapped in view.
	 */
    private Integer id;

    /**
     * company brand.
     * <br/>
     * Is readable in action READ, will be render as a Label as child of readParent component.
     */
    @DRField(actions= FormActions.READ, readParent = "nombreRow", label =
    @DRLabel(key = DRLabel.NO_LABEL))
    @DRLabel(key = DRLabel.NO_LABEL,sclass="uptitulo")
    private String brand;
    
    /**
     * company slogan.
     * <br/>
     * Is readable in the action READ, will be render as a Label as child of readParent component.
     */
    @DRField(actions= FormActions.READ, readParent = "sloganRow", label =
    @DRLabel(key = DRLabel.NO_LABEL))
    @DRLabel(key = DRLabel.NO_LABEL)
    private String slogan;

    /**
     * company logo.
     * <br/>
     * Is readable in the action READ, will be render as a Image as child of readParent component.
     * <br/>
     * d4zk supports depth in the root entity attributes, separating the attributes by the $ symbol. Will use the value of the attribute uri in logo.
     */
    @DRField(actions= FormActions.READ, readParent = "imgPerfil", label =
    @DRLabel(key = DRLabel.NO_LABEL))
    @DRImage(width = "100px", prepend = ".")
    private String logo$uri;
    
    /**
     * category name.
     * <br/>
     * Is readable in the action READ, will be render as a Label as child of readParent component.
     * <br/>
     * d4zk supports depth in the root entity attributes, separating the attributes by the $ symbol. Will use the value of the attribute name in category.
     */
    @DRField(actions= FormActions.READ, readParent = "giro", label =
    @DRLabel(key = DRLabel.NO_LABEL))
    @DRLabel(key = DRLabel.NO_LABEL)
    private String category$name;

    /**
     * phone.
     * <br/>
     * Is readable in the action READ, will be render as a Label as child of readParent component.
     * <br/>
     * It will render a Label with the key value of empresa.telefono before the label phone. 
     */
    @DRField(actions= FormActions.READ, readParent = "telefonoRow", label =
    @DRLabel(key = "empresa.telefono"))
    @DRLabel(key = DRLabel.NO_LABEL)
    private Integer phone;

    /**
     * company about info.
     * <br/>
     * Is readable in the action READ, will be render as Html code as child of readParent component. 
     */
    @DRField(actions= FormActions.READ, readParent = "bioRow", label =
    @DRLabel(key = DRLabel.NO_LABEL))
    @DRHtml()
    private String bio;
    /**
     * company home link.
     * <br/>
     * Is readable in the action READ, will be render as custom Image Link as child of readParent component. 
     */
    @DRField(actions= FormActions.READ, readParent = "linkRow", label =
    @DRLabel(key = DRLabel.NO_LABEL))
    @DRLink(image="/img/home_link.png")
    private String link;

    /**
     * company specialty.
     * <br/>
     * Is readable in the action READ, will be render as Label as child of readParent component. 
     */
    @DRField(actions= FormActions.READ, readParent = "especialidad", label =
    @DRLabel(key = DRLabel.NO_LABEL))
    @DRLabel(key = DRLabel.NO_LABEL)
    private String specialty;

    /**
     * street.
     * <br/>
     * Is readable in the action READ, will be render as a Label as child of readParent component.
     * <br/>
     * d4zk supports depth in the root entity attributes, separating the attributes by the $ symbol. Will use the value of the attribute street in address.
     */
    @DRField(actions= FormActions.READ, readParent = "calleRow", label =
    @DRLabel(key = DRLabel.NO_LABEL))
    @DRLabel(key = DRLabel.NO_LABEL)
    private String address$street;

    /**
     * city.
     * <br/>
     * Is readable in the action READ, will be render as a Label as child of readParent component.
     * <br/>
     * d4zk supports depth in the root entity attributes, separating the attributes by the $ symbol. Will use the value of the city name in address.
     */
    @DRField(actions= FormActions.READ, readParent = "estadoRow", label =
    @DRLabel(key = DRLabel.NO_LABEL))
    @DRLabel(key = DRLabel.NO_LABEL)
    private String address$city$name;

    /**
     * location map.
     * <br/>
     * Is readable in the action READ, will be render as a google map as child of readParent component.
     * <br/>
     * It needs at least two parameters were the coordinates latitude and longitude are read.
     */
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
    /**
     * 
     * @return the map latitude
     */
    public Double getAddress$latitude() {
        return address$latitude;
    }

    /**
     * 
     * @return the map longitude
     */
    public Double getAddress$longitude() {
        return address$longitude;
    }

    /**
     * 
     * @return company brand name
     */
    public String getBrand() {
        return brand;
    }

    /**
     * 
     * @return the id
     */
    public Integer getId() {
        return id;
    }
    
    
}
