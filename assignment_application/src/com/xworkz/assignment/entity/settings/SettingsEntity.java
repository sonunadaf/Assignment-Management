package com.xworkz.assignment.entity.settings;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "settings")
public class SettingsEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "ID")
	private int auditId;
	@Column(name = "ENTITY")
	private String entity;
	@Column(name = "ENTITY_ID")
	private Integer entityId;
	@Column(name = "PROPERTY")
	private String property;
	@Column(name = "OLD_VALUE")
	private String oldValue;
	@Column(name = "NEW_VALUE")
	private String newValue;
	@Column(name = "DATE")
	private String date;
	@Column(name = "IP_ADDRESS")
	private String ipAddress;

	public int getAuditId() {
		return auditId;
	}

	public void setAuditId(int auditId) {
		this.auditId = auditId;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public Integer getEntityId() {
		return entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public String getOldValue() {
		return oldValue;
	}

	public void setOldValue(String oldValue) {
		this.oldValue = oldValue;
	}

	public String getNewValue() {
		return newValue;
	}

	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "SettingsEntity [auditId=" + auditId + ", entity=" + entity + ", entityId=" + entityId + ", property="
				+ property + ", oldValue=" + oldValue + ", newValue=" + newValue + ", date=" + date + ", ipAddress="
				+ ipAddress + "]";
	}
}
