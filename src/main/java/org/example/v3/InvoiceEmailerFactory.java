package org.example.v3;

import org.example.EmailEnhancer;
import org.example.InvoiceEmailer;

public class InvoiceEmailerFactory {
	private final EmailEnhancer enhancer;

	public InvoiceEmailerFactory(EmailEnhancer enhancer) {
		this.enhancer = enhancer;
	}

	private InvoiceEmailerFactory(Builder builder) {
		enhancer = builder.enhancer;
	}

	public InvoiceEmailer createInvoiceEmailer() {
		return new InvoiceEmailerImpl(this.enhancer);
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private EmailEnhancer enhancer;

		private Builder() {
		}

		public static Builder builder() {
			return new Builder();
		}

		public Builder withEnhancer(EmailEnhancer val) {
			enhancer = val;
			return this;
		}

		public InvoiceEmailerFactory build() {
			return new InvoiceEmailerFactory(this);
		}
	}
}
