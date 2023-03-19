package org.example.v1;

import org.example.Email;
import org.example.InvoiceEmailer;
import org.example.ToggleRouter;

public class InvoiceEmailerImpl implements InvoiceEmailer {
	ToggleRouter toggleRoute;

	public InvoiceEmailerImpl(ToggleRouter toggleRoute) {
		this.toggleRoute = toggleRoute;
	}

	public Email generateInvoiceEmail(String receiverName, String content, float invoice) {
		var builder = Email.builder()
				.withSender("Test company")
				.withReceiver(receiverName)
				.withInvoice(invoice);

		if (this.toggleRoute.isEnabled("next-gen-email")) {
			builder.withContent(content + "\n---- Cancel Your Order Here ---");
		} else {
			builder.withContent(content);
		}

		return builder.build();
	}
}
