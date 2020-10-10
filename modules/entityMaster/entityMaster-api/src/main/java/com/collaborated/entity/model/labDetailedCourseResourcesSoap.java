/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.collaborated.entity.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.collaborated.entity.service.http.labDetailedCourseResourcesServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.collaborated.entity.service.http.labDetailedCourseResourcesServiceSoap
 * @generated
 */
@ProviderType
public class labDetailedCourseResourcesSoap implements Serializable {
	public static labDetailedCourseResourcesSoap toSoapModel(
		labDetailedCourseResources model) {
		labDetailedCourseResourcesSoap soapModel = new labDetailedCourseResourcesSoap();

		soapModel.setPK_courseResourceId(model.getPK_courseResourceId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPK_projectId(model.getPK_projectId());
		soapModel.setPK_courseId(model.getPK_courseId());
		soapModel.setTextbokTitle(model.getTextbokTitle());
		soapModel.setPublisherName(model.getPublisherName());
		soapModel.setAuthor(model.getAuthor());
		soapModel.setIsbn(model.getIsbn());

		return soapModel;
	}

	public static labDetailedCourseResourcesSoap[] toSoapModels(
		labDetailedCourseResources[] models) {
		labDetailedCourseResourcesSoap[] soapModels = new labDetailedCourseResourcesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static labDetailedCourseResourcesSoap[][] toSoapModels(
		labDetailedCourseResources[][] models) {
		labDetailedCourseResourcesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new labDetailedCourseResourcesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new labDetailedCourseResourcesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static labDetailedCourseResourcesSoap[] toSoapModels(
		List<labDetailedCourseResources> models) {
		List<labDetailedCourseResourcesSoap> soapModels = new ArrayList<labDetailedCourseResourcesSoap>(models.size());

		for (labDetailedCourseResources model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new labDetailedCourseResourcesSoap[soapModels.size()]);
	}

	public labDetailedCourseResourcesSoap() {
	}

	public long getPrimaryKey() {
		return _PK_courseResourceId;
	}

	public void setPrimaryKey(long pk) {
		setPK_courseResourceId(pk);
	}

	public long getPK_courseResourceId() {
		return _PK_courseResourceId;
	}

	public void setPK_courseResourceId(long PK_courseResourceId) {
		_PK_courseResourceId = PK_courseResourceId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getPK_projectId() {
		return _PK_projectId;
	}

	public void setPK_projectId(long PK_projectId) {
		_PK_projectId = PK_projectId;
	}

	public long getPK_courseId() {
		return _PK_courseId;
	}

	public void setPK_courseId(long PK_courseId) {
		_PK_courseId = PK_courseId;
	}

	public String getTextbokTitle() {
		return _textbokTitle;
	}

	public void setTextbokTitle(String textbokTitle) {
		_textbokTitle = textbokTitle;
	}

	public String getPublisherName() {
		return _publisherName;
	}

	public void setPublisherName(String publisherName) {
		_publisherName = publisherName;
	}

	public String getAuthor() {
		return _author;
	}

	public void setAuthor(String author) {
		_author = author;
	}

	public String getIsbn() {
		return _isbn;
	}

	public void setIsbn(String isbn) {
		_isbn = isbn;
	}

	private long _PK_courseResourceId;
	private long _groupId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _PK_projectId;
	private long _PK_courseId;
	private String _textbokTitle;
	private String _publisherName;
	private String _author;
	private String _isbn;
}