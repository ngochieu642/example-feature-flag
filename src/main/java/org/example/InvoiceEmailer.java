package org.example;

public interface InvoiceEmailer {
	Email generateInvoiceEmail(String receiverName, String content, float invoice);
}
