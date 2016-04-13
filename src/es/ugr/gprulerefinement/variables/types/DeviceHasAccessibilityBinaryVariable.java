package es.ugr.gprulerefinement.variables.types;

import es.ugr.gprulerefinement.variables.BinaryVariable;

public class DeviceHasAccessibilityBinaryVariable extends BinaryVariable {

	public DeviceHasAccessibilityBinaryVariable() {
		
		this.name = "device_has_accessibility";
		this.value = this.getRandomValue();
	}

	@Override
	public Object clone() {
		
		DeviceHasAccessibilityBinaryVariable d = new DeviceHasAccessibilityBinaryVariable();
		d.value = this.value;
		
		return d;
	}

}