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

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import mx.dr.forms.constants.FormActions;
import mx.dr.forms.view.DRField;
import mx.dr.forms.view.component.DRLabel;
import mx.dr.util.Base;

/**
 * Main Category persistence class
 * @author jorge
 *
 */
@Entity
@Table(name = "ml_category_main")
public class MainCategory extends Base{

	/**
	 * serial
	 */
	private static final long serialVersionUID = -3160758613353699374L;
	/**
	 * Main category id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)

	private Integer id;
	/**
	 * category name. 
	 * the DRField as LIST automatically makes the attribute value visible on listbox or combobox.
	 */
	@Column(name = "name")
	@DRField(columnListWidth = "200px",label=@DRLabel(key=""),actions= {FormActions.LIST})
	private String name;
	/**
	 * registry date
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "registry_date")
	private Date registryDate;
	/**
	 * status
	 */
	@Column(name = "status")
	private String status;



	/**
	 * default constructor
	 */
	public MainCategory() {
		super();
	}

	/**
	 * Constructor by id
	 * @param id
	 */
	public MainCategory(Integer id) {
		this.id = id;
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
	 * @return the registryDate
	 */
	public Date getRegistryDate() {
		return registryDate;
	}

	/**
	 * @param registryDate the registryDate to set
	 */
	public void setRegistryDate(Date registryDate) {
		this.registryDate = registryDate;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 
	 * @return the status as enum
	 */
	public CatalogStatus getEstatusEnum() {
		return CatalogStatus.getValueOf(status);
	}
	/**
	 * 
	 * @param estatus the status enum to set
	 */
	public void setEstatusEnum(CatalogStatus estatus) {
		if(estatus!=null)
			this.status = estatus.getId();
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj){
		if(!(obj instanceof MainCategory))
			return false;
		if(id==null || ((MainCategory)obj).getId()==null)
			return false;
		return this.id==((MainCategory)obj).getId().intValue();
	}
}
