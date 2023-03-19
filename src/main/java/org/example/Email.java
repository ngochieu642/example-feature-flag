package org.example;

public class Email {
	private String content;
	private String sender;
	private String receiver;
	private float invoice;

	private Email(Builder builder) {
		setContent(builder.content);
		setSender(builder.sender);
		setReceiver(builder.receiver);
		setInvoice(builder.invoice);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public float getInvoice() {
		return invoice;
	}

	public void setInvoice(float invoice) {
		this.invoice = invoice;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private String content;
		private String sender;
		private String receiver;
		private float invoice;

		private Builder() {
		}

		public Builder withContent(String val) {
			content = val;
			return this;
		}

		public Builder withSender(String val) {
			sender = val;
			return this;
		}

		public Builder withReceiver(String val) {
			receiver = val;
			return this;
		}

		public Builder withInvoice(float val) {
			invoice = val;
			return this;
		}

		public Email build() {
			return new Email(this);
		}
	}
}
