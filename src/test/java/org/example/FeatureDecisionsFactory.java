package org.example;

public class FeatureDecisionsFactory {
	public static FeatureDecisions fromInput(boolean isEnabled) {
		// Let's say I got this by reading environment variable
		ToggleRouter toggleRouter = new ToggleRouterImpl();
		toggleRouter.setFeature(FeatureDecisionsImpl.NET_GEN_EMAIL, isEnabled);
		return new FeatureDecisionsImpl(toggleRouter);
	}
}
