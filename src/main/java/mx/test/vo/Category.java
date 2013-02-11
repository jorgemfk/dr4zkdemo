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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "ml_category")
public class Category extends Base{

	/**
	 * serial
	 */
	private static final long serialVersionUID = -8120192258989915584L;

	/**
	 * default constructor
	 */
	public Category() {
		super();
	}

	/**
	 * constructor by id
	 * @param id the id
	 */
	public Category(Integer id) {
		super();
		this.id = id;
	}

	/**
	 * Category id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;
	/**
	 * category name. 
	 * the DRField as LIST automatically makes the attribute value visible on listbox or combobox.
	 */
	@DRField(columnListWidth = "200px",label=@DRLabel(key=""),actions= {FormActions.LIST})       
	private String name;
	/**
	 * registry date
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "registry_date")
	/**
	 * category status
	 */
	private Date registryDate;
	@Column(name = "status")
	private String status;
	/**
	 * user who saved the record
	 */
	@ManyToOne
	@JoinColumn(name = "iduser")
	private User user;
	/**
	 * main category or parent category.
	 */
	@ManyToOne
	@JoinColumn(name = "id_category_main")
	private MainCategory father;

	
	
	/**
	 * get status as enum
	 * @return the calago status enum
	 */
	public CatalogStatus getEstatusEnum() {
		return CatalogStatus.getValueOf(status);
	}

	/**
	 * set the status by a enum
	 * @param estatus enum value
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
		if(!(obj instanceof Category))
			return false;
		if(id==null || ((Category)obj).getId()==null)
			return false;
		return this.id==((Category)obj).getId().intValue();
	}

	/*
	 * (non-Javadoc)
	 * @see mx.dr.util.Base#toString()
	 */
	public String toString(){
		return id +" "+name;
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
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the father
	 */
	public MainCategory getFather() {
		return father;
	}

	/**
	 * @param father the father to set
	 */
	public void setFather(MainCategory father) {
		this.father = father;
	}

	
}
