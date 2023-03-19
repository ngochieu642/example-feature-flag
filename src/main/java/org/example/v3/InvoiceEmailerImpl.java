package org.example.v3;

import org.example.Email;
import org.example.EmailEnhancer;
import org.example.InvoiceEmailer;

public class InvoiceEmailerImpl implements InvoiceEmailer {

	private final EmailEnhancer emailEnhancer;

	public InvoiceEmailerImpl(EmailEnhancer emailEnhancer) {
		this.emailEnhancer = emailEnhancer;
	}

	@Override
	public Email generateInvoiceEmail(String receiverName, String content, float invoice) {
		Email email = Email.builder()
				.withSender("Test company")
				.withReceiver(receiverName)
				.withContent(content)
				.withInvoice(invoice)
				.build();

		return this.emailEnhancer.enhance(email);
	}
}
