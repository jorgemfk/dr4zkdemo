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

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import mx.dr.util.Base;

/**
 * Contact persistence class
 * @author jorge
 *
 */
@Entity
@Table(name = "ml_contact")
public class Contact extends Base{
	/**
	 * serial
	 */
	private static final long serialVersionUID = 2782410547191362225L;
	/**
	 * register id	
	 */
	private Integer id;
	/**
	 * contact person name
	 */
	private String name;
	/**
	 * private phone number 
	 */
	private Integer phone_number;
	/**
	 * seconde phone number
	 */
	private Integer phone_number_two;
	/**
	 * mobile phone number
	 */
	private String mobile;

	/**
	 * default constructor
	 */
	public Contact() {
		super();
	}

	/**
	 * constructor by id
	 * @param id the id
	 */
	public Contact(Integer id) {
		super();
		this.id = id;
	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",  nullable = false)
	public Integer getId() {
		return id;
	}
	/**
	 * 
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	@Column(name = "nombre", nullable = false)
	public String getName() {
		return name;
	}
	/**
	 * @param nombre the name to set
	 */
	public void setName(String nombre) {
		this.name = nombre;
	}

	/**
	 * @return the phone number
	 */
	@Column(name = "telefono_uno", nullable = false)
	public Integer getPhone_number() {
		return phone_number;
	}
	/**
	 * @param telefono_uno the phone number to set
	 */
	public void setPhone_number(Integer telefono_uno) {
		this.phone_number = telefono_uno;
	}

	/**
	 * @return the phone_number_two
	 */
	@Column(name = "telefono_dos", nullable = true)
	public Integer getPhone_number_two() {
		return phone_number_two;
	}
	/**
	 * 
	 * @param telefono_dos th phone_number_two to set
	 */
	public void setPhone_number_two(Integer telefono_dos) {
		this.phone_number_two = telefono_dos;
	}

	/**
	 * 
	 * @return the mobile
	 */
	@Column(name = "nextel", nullable = true)
	public String getMobile() {
		return mobile;
	}
	/**
	 * 
	 * @param nextel the mobile to set
	 */
	public void setMobile(String nextel) {
		this.mobile = nextel;
	}


}
