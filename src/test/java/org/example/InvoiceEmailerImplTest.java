package org.example;

import org.example.common.FeatureDecisionsImpl;
import org.example.common.ToggleRouterImpl;
import org.example.v3.FeatureAwareFactoryInvoiceEmailerFactory;
import org.example.v3.InvoiceEmailerFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
	@Test
	@DisplayName("Test that email does include cancellation option when configured to do so")
	void testIncludeOrderCancellation_v3() {
		FeatureDecisions featureDecisions = createFeatureDecisionsNextGenEmail(true);
		InvoiceEmailerFactory invoiceEmailerFactory = FeatureAwareFactoryInvoiceEmailerFactory.createFeatureAwareFactoryBasedOn(featureDecisions);
		InvoiceEmailer invoiceEmailer = invoiceEmailerFactory.createInvoiceEmailer();
		Email email = invoiceEmailer.generateInvoiceEmail("test", "Hi", 10);

		assertTrue(email.getContent().toLowerCase().contains("cancel"));
	}

	@Test
	@DisplayName("Test that email does not include cancellation option when configured not to do so")
	void testNotIncludeOrderCancellation_v3() {
		FeatureDecisions featureDecisions = createFeatureDecisionsNextGenEmail(false);
		InvoiceEmailerFactory invoiceEmailerFactory = FeatureAwareFactoryInvoiceEmailerFactory.createFeatureAwareFactoryBasedOn(featureDecisions);
		InvoiceEmailer invoiceEmailer = invoiceEmailerFactory.createInvoiceEmailer();
		Email email = invoiceEmailer.generateInvoiceEmail("test", "Hi", 10);

		assertFalse(email.getContent().toLowerCase().contains("cancel"));
	}

	@Test
	@DisplayName("Test that email does include cancellation option when configured to do so")
	void testIncludeOrderCancellation_v2() {
		FeatureDecisions featureDecisions = createFeatureDecisionsNextGenEmail(true);
		InvoiceEmailer invoiceEmailer = new org.example.v2.InvoiceEmailerImpl(featureDecisions);
		Email email = invoiceEmailer.generateInvoiceEmail("test", "Hi", 10);

		assertTrue(email.getContent().toLowerCase().contains("cancel"));
	}

	@Test
	@DisplayName("Test that email does not include cancellation option when configured not to do so")
	void testNotIncludeOrderCancellation_v2() {
		FeatureDecisions featureDecisions = createFeatureDecisionsNextGenEmail(false);
		InvoiceEmailer invoiceEmailer = new org.example.v2.InvoiceEmailerImpl(featureDecisions);
		Email email = invoiceEmailer.generateInvoiceEmail("test", "Hi", 10);

		assertFalse(email.getContent().toLowerCase().contains("cancel"));
	}

	@Test
	@DisplayName("Test that email does include cancellation option when configured to do so")
	void testIncludeOrderCancellation_v1() {
		ToggleRouter toggleRouter = new ToggleRouterImpl();
		toggleRouter.setFeature("next-gen-email", true);

		InvoiceEmailer invoiceEmailer = new org.example.v1.InvoiceEmailerImpl(toggleRouter);
		Email email = invoiceEmailer.generateInvoiceEmail("test", "Hi", 10);

		assertTrue(email.getContent().toLowerCase().contains("cancel"));
	}

	@Test
	@DisplayName("Test that email does not include cancellation option when configured not to do so")
	void testNotIncludeOrderCancellation_v1() {
		ToggleRouter toggleRouter = new ToggleRouterImpl();
		toggleRouter.setFeature("next-gen-email", false);

		InvoiceEmailer invoiceEmailer = new org.example.v1.InvoiceEmailerImpl(toggleRouter);
		Email email = invoiceEmailer.generateInvoiceEmail("test", "Hi", 10);

		assertFalse(email.getContent().toLowerCase().contains("cancel"));
	}


	public static FeatureDecisions createFeatureDecisionsNextGenEmail(boolean isEnabled) {
		// Let's say I got this by reading environment variable
		ToggleRouter toggleRouter = new ToggleRouterImpl();
		toggleRouter.setFeature(FeatureDecisionsImpl.NET_GEN_EMAIL, isEnabled);
		return new FeatureDecisionsImpl(toggleRouter);
	}
}
