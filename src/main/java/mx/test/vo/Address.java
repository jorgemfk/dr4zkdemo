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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Transient;
import mx.dr.util.Base;


@Entity
@Table(name = "ml_address")

public class Address extends Base{

private Integer id;

private String street;

private String cp;

private City city;

private Double latitude = 0D;

private Double longitude = 0D;


public Address() {
	super();
}

public Address(Integer id) {
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

@Column(name = "calle", nullable = true)
public String getStreet() {
	return street;
}
public void setStreet(String calle) {
	this.street = calle;
}


@Column(name = "cp", nullable = true)
public String getCp() {
	return cp;
}


public void setCp(String cp) {
	this.cp = cp;
}


@Transient
public String getEstadoString(){return city.getName();}

@ManyToOne
@JoinColumn(name = "idestado")
public City getCity() {
	return city;
}

public void setCity(City estado) {
	this.city = estado;
}

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String printable(){
            return new StringBuffer(street).append(", ")
                    .append(city.getName()).toString();
    }

public Address clone(){
	Address d=null;
	try {
		d = (Address) super.clone();
	} catch (CloneNotSupportedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	d.setId(null);
	return d;
}

}
