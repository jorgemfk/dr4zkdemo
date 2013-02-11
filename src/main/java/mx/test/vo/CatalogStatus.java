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
/**
 * Catalog Status Enum
 * @author jorge
 *
 */
public enum CatalogStatus implements DRBOFieldTranslator {
	/**
	 * possible values for status
	 */
    ACTIVE("A", "status.name.active"), INACTIVE("I", "status.name.inactive");
    /**
     * id for status
     */
    private String id;
    /**
     * label key from properties
     */
    private String label;
    /**
     * label description from properties
     * the DRField as LIST automatically makes the attribute value visible on listbox or combobox.
     */
    @DRField(columnListWidth = "200px",label=@DRLabel(key=""),actions= {FormActions.LIST})
    private String labelDescription;

    /**
     * default parameterized constructor
     * @param id the id
     * @param label the label key
     */
    CatalogStatus(String id, String label) {
        this.id = id;
        this.label = label;
    }


    /**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}



	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}



	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}


	/**
	 * get the label description properties key based
	 * @return
	 */
	public String getLabelDescription() {
        return labelDescription==null?(labelDescription=Labels.getLabel(label)):labelDescription;
    }

	/**
	 * get the label for the desired id
	 * @param id
	 * @return
	 */
    public static String getLabel(String id) {
        for (CatalogStatus c : CatalogStatus.values()) {
            if (c.id.equals(id)) {
                return c.label;
            }
        }
        return null;
    }

    /**
     * get the enum value for desired id
     * @param id
     * @return
     */
    public static CatalogStatus getValueOf(String id) {
        for (CatalogStatus c : CatalogStatus.values()) {
            if (c.id.equals(id)) {
                return c;
            }
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * @see mx.dr.forms.view.utils.DRBOFieldTranslator#getFieldName()
     */
    public String getFieldName() {
        return "estatus";
    }

    /*
     * (non-Javadoc)
     * @see mx.dr.forms.view.utils.DRBOFieldTranslator#getFieldValue()
     */
    public Object getFieldValue() {
        return this.id;
    }
}
