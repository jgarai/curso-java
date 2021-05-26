package keyvalue.model;

import java.time.LocalDateTime;

public class Key {
	private Integer id;
	private Integer setOwnerId;
	private String key;
	private String value;
	private LocalDateTime createdAt;

	public Key() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSetOwnerId() {
		return setOwnerId;
	}

	public void setSetOwnerId(Integer setOwnerId) {
		this.setOwnerId = setOwnerId;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((setOwnerId == null) ? 0 : setOwnerId.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Key other = (Key) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (setOwnerId == null) {
			if (other.setOwnerId != null)
				return false;
		} else if (!setOwnerId.equals(other.setOwnerId))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Key [id=" + id + ", setOwnerId=" + setOwnerId + ", key=" + key + ", value=" + value + "]";
	}

	public Key(Integer id, Integer setOwnerId, String key, String value, LocalDateTime createdAt) {
		this.id = id;
		this.setOwnerId = setOwnerId;
		this.key = key;
		this.value = value;
		this.createdAt = createdAt;
	}

}
