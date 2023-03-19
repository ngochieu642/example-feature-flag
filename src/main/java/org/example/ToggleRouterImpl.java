package org.example;

import java.util.HashMap;
import java.util.Map;

public class ToggleRouterImpl implements ToggleRouter {
	Map<String, Boolean> featureConfig;

	public ToggleRouterImpl() {
		this.featureConfig = new HashMap<>();
	}

	public ToggleRouterImpl(Map<String, Boolean> featureConfig) {
		this.featureConfig = featureConfig;
	}

	@Override
	public void setFeature(String feature, boolean isEnabled) {
		this.featureConfig.put(feature, isEnabled);
	}

	@Override
	public boolean isEnabled(String featureName) {
		return this.featureConfig.get(featureName);
	}
}
