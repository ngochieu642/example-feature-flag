package org.example.v2;

import org.example.Email;
import org.example.FeatureDecisions;
import org.example.InvoiceEmailer;

public class InvoiceEmailerImpl implements InvoiceEmailer {
	FeatureDecisions featureDecisions;

	public InvoiceEmailerImpl(FeatureDecisions featureDecisions) {
		this.featureDecisions = featureDecisions;
	}

	public Email generateInvoiceEmail(String receiverName, String content, float invoice) {
		var builder = Email.builder().withSender("Test company").withReceiver(receiverName).withInvoice(invoice);

		if (featureDecisions.includeOrderCancellationEmail()) {
			builder.withContent(content + "\n---- Cancel Your Order Here ---");
		} else {
			builder.withContent(content);
		}

		return builder.build();
	}
}
