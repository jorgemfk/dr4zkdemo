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

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.persistence.Transient;

/**
 * Company persistence class
 * @author jorge
 *
 */
@Entity
@Table(name = "ml_company")
@DiscriminatorValue("RES")
public class Company extends User {
 
    /**
	 * serial
	 */
	private static final long serialVersionUID = 7266475158648007021L;

	/**
	 * company brand name
	 */
	private String brand;
   
	/**
	 * about the company
	 */
    private String bio;

    /**
     * URL to external Homepage
     */
    private String link;
    
    /**
     * company contact
     */
    @ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name = "idcontact")
    private Contact contact;

    /**
     * company category
     */
    @ManyToOne
    @JoinColumn(name = "idcategory")
    private Category category;
    
    /**
     * company address
     */
    @ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name = "idaddress")
    private Address address;

    /**
     * invoice information
     */
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "idregistry_fiscal")
    private FiscalRegistry fiscalRegistry;

    /**
     * company brand logo
     */
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "idattachment")
    private Attachment logo;

    /**
     * company phone number
     */
    private Integer phone;

    /**
     * company slogan
     */
    private String slogan;
    /**
     * specialty on service
     */
    private String specialty;
    /**
     * schedule for service
     */
    private Date schedule;

    /**
     * dummy
     */
    @Transient
    public String categoryMainName;
    /**
     * dummy
     */
    @Transient
    public String categoryName;

    /**
     * category name bridge
     * @return category name
     */
    public String getCategoryName(){return category.getName();}

    /**
     * parent category name bridge
     * @return category name
     */
    public String getCategoryMainName(){return category.getFather().getName();}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the bio
	 */
	public String getBio() {
		return bio;
	}

	/**
	 * @param bio the bio to set
	 */
	public void setBio(String bio) {
		this.bio = bio;
	}

	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * @return the contact
	 */
	public Contact getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(Contact contact) {
		this.contact = contact;
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the fiscalRegistry
	 */
	public FiscalRegistry getFiscalRegistry() {
		return fiscalRegistry;
	}

	/**
	 * @param fiscalRegistry the fiscalRegistry to set
	 */
	public void setFiscalRegistry(FiscalRegistry fiscalRegistry) {
		this.fiscalRegistry = fiscalRegistry;
	}

	/**
	 * @return the logo
	 */
	public Attachment getLogo() {
		return logo;
	}

	/**
	 * @param logo the logo to set
	 */
	public void setLogo(Attachment logo) {
		this.logo = logo;
	}

	/**
	 * @return the phone
	 */
	public Integer getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	/**
	 * @return the slogan
	 */
	public String getSlogan() {
		return slogan;
	}

	/**
	 * @param slogan the slogan to set
	 */
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	/**
	 * @return the specialty
	 */
	public String getSpecialty() {
		return specialty;
	}

	/**
	 * @param specialty the specialty to set
	 */
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	/**
	 * @return the schedule
	 */
	public Date getSchedule() {
		return schedule;
	}

	/**
	 * @param schedule the schedule to set
	 */
	public void setSchedule(Date schedule) {
		this.schedule = schedule;
	}
    
   
	/*
	 * dummy
	 *
    public Integer getId(){
        return super.getId();
    }
	*/

}
