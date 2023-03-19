# What is this?

- This is an improvement from v2

# What changed?
- Changed `InvoiceEmailerImpl` code
- Add sample enhancers
- Add [factory class for InvoiceEmailer](./InvoiceEmailerFactory.java)
- Add feature aware factory - [abstract factory pattern](https://refactoring.guru/design-patterns/abstract-factory)

# Consequences
- [x] if a feature is combined from multiple feature flag -> You have to use complex if structure
  - Now the logic is inside [FeatureDecisions](./FeatureDecisions.java) class

- [x] Hard-coded string inside this class for feature flag
  - Now the string moved to [FeatureDecisions](./FeatureDecisionsImpl.java)

- [x] The way to "enhance" is limited inside the class
    - What if you want to add logic to include "Voucher" ? You would need to fix this very class to do that

- The factory ware class allow you to create entire families (InvoiceEmailerFactory) without specifying concreate classes
