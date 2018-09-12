package com.helixz.oauth.demo.enums;

/**
 * 
 * @author Chamith
 *
 */
public enum UserStatus {

	ACTIVE("Active", "A"),
	INACTIVE("Inactive", "I"),
	DELETED("Deleted", "D"),
	CREATED("Created", "C"),
	PENDING_ACTIVATION("Pending Activation", "PEA"),
	TEMP_LOCKED_BAD_CREDENTIALS("Temp Locked Bad Credentials", "TELBC");

	private String label;
	private String value;

	private UserStatus(String label, String value) {
		this.label = label;
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public String getLabel() {
		return label;
	}

	public static UserStatus getEnum(String value) {
		for (UserStatus item : UserStatus.values()) {
			if (item.getValue().equalsIgnoreCase(value)) {
				return item;
			}
		}
		return null;
	}
}
