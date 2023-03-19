package org.example.v3;

import org.example.EmailEnhancer;
import org.example.FeatureDecisions;

public class FeatureAwareFactoryInvoiceEmailerFactory {
	FeatureDecisions featureDecisions;

	public static InvoiceEmailerFactory createFeatureAwareFactoryBasedOn(FeatureDecisions featureDecisions) {
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
