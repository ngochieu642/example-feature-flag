# What is this?

- This is an improvement from v1

# What changed?
- Add `FeatureDecisions` class to separate feature flag with business decisions
- Changed `InvoiceEmailerImpl` code

# Consequences
- [x] if a feature is combined from multiple feature flag -> You have to use complex if structure
  - Now the logic is inside [FeatureDecisions](./FeatureDecisions.java) class

- [x] Hard-coded string inside this class for feature flag
  - Now the string moved to [FeatureDecisions](./FeatureDecisionsImpl.java)

- [ ] The way to "enhance" is limited inside the class
    - What if you want to add logic to include "Voucher" ? You would need to fix this very class to do that
