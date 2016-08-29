package es.ugr.gprulerefinement.variables.types;

import es.ugr.gprulerefinement.variables.BinaryVariable;

public class MailHasAttachmentBinaryVariable extends BinaryVariable {

	public MailHasAttachmentBinaryVariable() {
		
		this.name = "mail_has_attachment";
		this.value = this.getRandomValue();
		this.connector = this.getRandomConnector();
		this.negation = this.getRandomNegation();
	}

	@Override
	public Object clone() {
		
		MailHasAttachmentBinaryVariable d = new MailHasAttachmentBinaryVariable();
		d.value = this.value;
		
		return d;
	}

}
