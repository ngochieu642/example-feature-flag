package org.example;

/**
 * This class contain business logic
 * In case a decision was made from multiple flags
 */
public class FeatureDecisionsImpl implements FeatureDecisions {
	public static final String NET_GEN_EMAIL = "net-gen-email";
	ToggleRouter toggleRouter;

	public FeatureDecisionsImpl(ToggleRouter toggleRouter) {
		this.toggleRouter = toggleRouter;
	}

	@Override
	public boolean includeOrderCancellationEmail() {
		return this.toggleRouter.isEnabled(NET_GEN_EMAIL);
	}
}
