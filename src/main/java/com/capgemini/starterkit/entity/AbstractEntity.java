package com.capgemini.starterkit.entity;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
@EntityListeners(AuditListener.class)
public class AbstractEntity {

	@Id
	@GeneratedValue
	private Long id;
	
	@Version
	private int version;

	private String persistingHistory;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getPersistingHistory() {
		return persistingHistory;
	}

	public void setPersistingHistory(String persistingHistory) {
		this.persistingHistory = persistingHistory;
	}
}
