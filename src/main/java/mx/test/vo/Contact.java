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


@Entity
@Table(name = "ml_contact")
public class Contact extends Base{
	
private Integer id;

private String name;

private String phone_number;

private String phone_number_two;

private String mobile;

public Contact() {
	super();
}

public Contact(Integer id) {
	super();
	this.id = id;
}

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id",  nullable = false)
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}

@Column(name = "nombre", nullable = false)
public String getName() {
	return name;
}
public void setName(String nombre) {
	this.name = nombre;
}

@Column(name = "telefono_uno", nullable = false)
public String getPhone_number() {
	return phone_number;
}
public void setPhone_number(String telefono_uno) {
	this.phone_number = telefono_uno;
}

@Column(name = "telefono_dos", nullable = true)
public String getPhone_number_two() {
	return phone_number_two;
}
public void setPhone_number_two(String telefono_dos) {
	this.phone_number_two = telefono_dos;
}

@Column(name = "nextel", nullable = true)
public String getMobile() {
	return mobile;
}
public void setMobile(String nextel) {
	this.mobile = nextel;
}




}
