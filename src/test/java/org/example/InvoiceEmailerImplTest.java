package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
	@Test
	@DisplayName("Test that email does include cancellation option when configured to do so")
	void testIncludeOrderCancellation() {
		FeatureDecisions featureDecisions = FeatureDecisionsFactory.fromInput(true);
		InvoiceEmailerFactory invoiceEmailerFactory = FeatureAwareFactoryInvoiceEmailerFactory.createFeatureAwareFactoryBasedOn(featureDecisions);
		InvoiceEmailer invoiceEmailer = invoiceEmailerFactory.createInvoiceEmailer();
		Email email = invoiceEmailer.generateInvoiceEmail("test", "Hi", 10);

		assertTrue(email.getContent().toLowerCase().contains("cancel"));
	}

	@Test
	@DisplayName("Test that email does not include cancellation option when configured not to do so")
	void testNotIncludeOrderCancellation() {
		FeatureDecisions featureDecisions = FeatureDecisionsFactory.fromInput(false);
		InvoiceEmailerFactory invoiceEmailerFactory = FeatureAwareFactoryInvoiceEmailerFactory.createFeatureAwareFactoryBasedOn(featureDecisions);
		InvoiceEmailer invoiceEmailer = invoiceEmailerFactory.createInvoiceEmailer();
		Email email = invoiceEmailer.generateInvoiceEmail("test", "Hi", 10);

		assertFalse(email.getContent().toLowerCase().contains("cancel"));
	}
}
