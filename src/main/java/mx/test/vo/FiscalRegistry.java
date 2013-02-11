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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import mx.dr.util.Base;

/**
 * Fiscal Regestry persistence class
 * @author jorge
 *
 */
@Entity
@Table(name = "ml_registry_fiscal")
public class FiscalRegistry extends Base{
	
    /**
	 * serial
	 */
	private static final long serialVersionUID = -4542951027360121801L;

	/**
	 * Registry id
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",  nullable = false)
    private Integer id;
	/**
	 * tax name
	 */
    @Column(name = "fiscal_name")
    private String fiscalName;
    /**
     * tax id
     */
    private String rfc;
    /**
     * address
     */
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "idaddress")
    private Address fiscalAddress;
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
	 * @return the fiscalName
	 */
	public String getFiscalName() {
		return fiscalName;
	}
	/**
	 * @param fiscalName the fiscalName to set
	 */
	public void setFiscalName(String fiscalName) {
		this.fiscalName = fiscalName;
	}
	/**
	 * @return the rfc
	 */
	public String getRfc() {
		return rfc;
	}
	/**
	 * @param rfc the rfc to set
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	/**
	 * @return the fiscalAddress
	 */
	public Address getFiscalAddress() {
		return fiscalAddress;
	}
	/**
	 * @param fiscalAddress the fiscalAddress to set
	 */
	public void setFiscalAddress(Address fiscalAddress) {
		this.fiscalAddress = fiscalAddress;
	}

}
