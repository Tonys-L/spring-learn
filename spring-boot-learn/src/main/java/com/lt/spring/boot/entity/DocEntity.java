package com.lt.spring.boot.entity;

import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-09-13 14:20:18
 * @version：2017 Version：1.0
 * @company：创海科技 Created with IntelliJ IDEA
 */
@Entity(name = "doc")
public class DocEntity {
	private String id;
	private String folderId;
	private String name;
	private Byte type;
	private Timestamp created;
	private Boolean isDeleted;
	private Integer size;
	private Timestamp updated;
	private String updater;

	@Id
	@Column(name = "id", nullable = false, length = 12)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Basic
	@Column(name = "folder_id", nullable = true, length = 12)
	public String getFolderId() {
		return folderId;
	}

	public void setFolderId(String folderId) {
		this.folderId = folderId;
	}

	@Basic
	@Column(name = "name", nullable = false, length = 200)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "type", nullable = false)
	public Byte getType() {
		return type;
	}

	public void setType(Byte type) {
		this.type = type;
	}

	@Basic
	@Column(name = "created", nullable = false)
	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	@Basic
	@Column(name = "is_deleted", nullable = false)
	public Boolean getDeleted() {
		return isDeleted;
	}

	public void setDeleted(Boolean deleted) {
		isDeleted = deleted;
	}

	@Basic
	@Column(name = "size", nullable = false)
	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	@Basic
	@Column(name = "updated", nullable = true)
	public Timestamp getUpdated() {
		return updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	@Basic
	@Column(name = "updater", nullable = true, length = 12)
	public String getUpdater() {
		return updater;
	}

	public void setUpdater(String updater) {
		this.updater = updater;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		DocEntity docEntity = (DocEntity) o;

		if (id != null ? !id.equals(docEntity.id) : docEntity.id != null) return false;
		if (folderId != null ? !folderId.equals(docEntity.folderId) : docEntity.folderId != null) return false;
		if (name != null ? !name.equals(docEntity.name) : docEntity.name != null) return false;
		if (type != null ? !type.equals(docEntity.type) : docEntity.type != null) return false;
		if (created != null ? !created.equals(docEntity.created) : docEntity.created != null) return false;
		if (isDeleted != null ? !isDeleted.equals(docEntity.isDeleted) : docEntity.isDeleted != null) return false;
		if (size != null ? !size.equals(docEntity.size) : docEntity.size != null) return false;
		if (updated != null ? !updated.equals(docEntity.updated) : docEntity.updated != null) return false;
		if (updater != null ? !updater.equals(docEntity.updater) : docEntity.updater != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (folderId != null ? folderId.hashCode() : 0);
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (type != null ? type.hashCode() : 0);
		result = 31 * result + (created != null ? created.hashCode() : 0);
		result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
		result = 31 * result + (size != null ? size.hashCode() : 0);
		result = 31 * result + (updated != null ? updated.hashCode() : 0);
		result = 31 * result + (updater != null ? updater.hashCode() : 0);
		return result;
	}
}
