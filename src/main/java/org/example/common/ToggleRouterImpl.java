package org.example.common;

import org.example.ToggleRouter;

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
		var isFeatureEnabled = this.featureConfig.get(featureName);

		if (isFeatureEnabled == null) {
			return false;
		}

		return isFeatureEnabled;
	}
}
