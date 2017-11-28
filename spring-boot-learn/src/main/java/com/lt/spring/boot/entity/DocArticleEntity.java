package com.lt.spring.boot.entity;

import io.searchbox.annotations.JestId;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 功能：
 *
 * @author：LT(286269159@qq.com)
 * @create：2017-09-13 14:20:19
 * @version：2017 Version：1.0
 * @company：创海科技 Created with IntelliJ IDEA
 */
@Entity(name = "doc_article")
public class DocArticleEntity {
	@JestId
	private String docId;
	private String content;

	@Id
	@Column(name = "doc_id", nullable = false, length = 12)
	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	@Basic
	@Column(name = "content", nullable = true, length = -1)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		DocArticleEntity that = (DocArticleEntity) o;

		if (docId != null ? !docId.equals(that.docId) : that.docId != null) return false;
		if (content != null ? !content.equals(that.content) : that.content != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = docId != null ? docId.hashCode() : 0;
		result = 31 * result + (content != null ? content.hashCode() : 0);
		return result;
	}
}
