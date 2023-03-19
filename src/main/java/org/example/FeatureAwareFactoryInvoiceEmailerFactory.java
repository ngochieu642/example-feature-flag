package org.example;

public class FeatureAwareFactoryInvoiceEmailerFactory {
	FeatureDecisions featureDecisions;

	static InvoiceEmailerFactory createFeatureAwareFactoryBasedOn(FeatureDecisions featureDecisions) {
		if (featureDecisions.includeOrderCancellationEmail()) {
			EmailEnhancer includeOrderCancelEnhancer = new IncludeOrderCancelEnhancer();
			return InvoiceEmailerFactory.builder()
					.withEnhancer(includeOrderCancelEnhancer)
					.build();
		} else {
			EmailEnhancer doNothingEnhancer = new DoNothingEnhancer();
			return InvoiceEmailerFactory.builder()
					.withEnhancer(doNothingEnhancer)
					.build();
		}
	}
}
