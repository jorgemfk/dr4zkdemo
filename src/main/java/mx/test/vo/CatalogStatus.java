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
package mx.test.vo;

import mx.dr.forms.constants.FormActions;
import mx.dr.forms.view.DRField;
import mx.dr.forms.view.component.DRLabel;
import mx.dr.forms.view.utils.DRBOFieldTranslator;
import org.zkoss.util.resource.Labels;

public enum CatalogStatus implements DRBOFieldTranslator {

    ACTIVE("A", "status.name.active"), INACTIVE("I", "status.name.inactive");
    private String id;
    private String label;
    @DRField(columnListWidth = "200px",label=@DRLabel(key=""),actions= {FormActions.LIST})
    private String labelDescription;

    CatalogStatus(String id, String label) {
        this.id = id;
        this.label = label;
    }

    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public String getLabelDescription() {
        return Labels.getLabel(label);
    }

    public static String getLabel(String id) {
        for (CatalogStatus c : CatalogStatus.values()) {
            if (c.id.equals(id)) {
                return c.label;
            }
        }
        return null;
    }

    public static CatalogStatus getValueOf(String id) {
        for (CatalogStatus c : CatalogStatus.values()) {
            if (c.id.equals(id)) {
                return c;
            }
        }
        return null;
    }

    public String getFieldName() {
        return "estatus";
    }

    public Object getFieldValue() {
        return this.id;
    }
}
