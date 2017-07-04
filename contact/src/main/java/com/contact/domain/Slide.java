package com.contact.domain;

import java.sql.Date;

import org.springframework.data.domain.Persistable;

public class Slide implements Persistable<Integer> {

	private static final long serialVersionUID = 1L;

	public Integer id;
	public String name;
	public String image;
	public Date createDate;
	public String creator;

	public Slide(int id, String name, String image, Date createDate,
			String creator) {
		this.id = id;
		this.name = name;
		this.image = image;
		this.createDate = createDate;
		this.creator = creator;
	}

	/* id */
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public Integer getId() {
		return null;
	}

	@Override
	public boolean isNew() {
		return this.id == null;
	}

	/* id */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}
}
