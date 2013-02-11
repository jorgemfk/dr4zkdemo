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

/**
 * address persistence class
 * @author jorge
 *
 */
@Entity
@Table(name = "ml_address")
public class Address extends Base implements Cloneable{

	/**
	 * serial
	 */
	private static final long serialVersionUID = 987336050453404174L;
	/**
	 * address id
	 */
	private Integer id;
	/**
	 * street an number address
	 */
	private String street;

	/**
	 * zip code
	 */
	private String cp;
	/**
	 * city
	 */
	private City city;

	/**
	 * global latitude to be founded on a map
	 */
	private Double latitude = 0D;

	/**
	 * global longitude to be founded on a map
	 */
	private Double longitude = 0D;


	/**
	 * default constructor
	 */
	public Address() {
		super();
	}

	/**
	 * constructor with id parameter
	 * @param id address id
	 */
	public Address(Integer id) {
		super();
		this.id = id;
	}

	/**
	 * 
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",  nullable = false)
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
	 * @return the street
	 */
	@Column(name = "calle", nullable = true)
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * 
	 * @return the zip code
	 */
	@Column(name = "cp", nullable = true)
	public String getCp() {
		return cp;
	}

	/**
	 * @param cp the cp to set
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}

	@Transient
	public String getEstadoString(){return city.getName();}

	/**
	 * 
	 * @return the city
	 */
	@ManyToOne
	@JoinColumn(name = "idestado")
	public City getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}

	/**
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

    /**
     * print all attribute values in one line
     * @return
     */
	public String printable(){
		return new StringBuffer(street).append(", ")
				.append(city.getName()).toString();
	}

	/*
     * (non-Javadoc)
     * @see java.lang.Cloneable#clone()
     */
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
