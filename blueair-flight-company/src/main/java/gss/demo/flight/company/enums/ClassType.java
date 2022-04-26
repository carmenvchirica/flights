package gss.demo.flight.company.enums;

import lombok.Getter;

@Getter
public enum ClassType {
	ECONOMIC("Economic"),
	ECONOMIC_PREMIUM("Economic Premium"),
	BUSINESS("Business"),
	FIRST("First");
	
	private final String name;
	
	private ClassType(String name) {
		this.name = name;
	}

}
