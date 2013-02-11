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


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import mx.dr.forms.constants.FormActions;
import mx.dr.forms.view.DRField;
import mx.dr.forms.view.component.DRLabel;
import mx.dr.util.Base;

/**
 * Category persistence class
 * @author jorge
 *
 */
@Entity
@Table(name = "ml_city")
public class City extends Base {
	
    /**
	 * serial
	 */
	private static final long serialVersionUID = 5025507036243029839L;

	/**
	 * static value for all cities combobox
	 */
	public static final String TODOS="ALL CITIES";

	/**
	 * city id
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",  nullable = false)
    private Integer id;
    /**
     * city name.
     * the DRField as LIST automatically makes the attribute value visible on listbox or combobox.
     */
    @DRField(actions={FormActions.LIST},label=@DRLabel(key=""), columnListWidth= "200px")
    private String name;
    /**
     * country id
     */
    @Column(name = "idcountry")
    private String country;

    /**
     * default constructor
     */
    public City() {
    }

    /**
     * constructor
     * @param id the id
     * @param nombre the city name
     */
    public City(Integer id, String nombre) {
        super();
        this.id = id;
        this.name = nombre;
    }

    /**
     * constructor by country
     * @param pais country
     */
    public City(String pais) {
        super();
        this.country = pais;
    }


    /**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof City)) {
            return false;
        }
        if (id == null || ((City) obj).getId() == null) {
            return false;
        }
        return this.id == ((City) obj).getId().intValue();
    }
}
