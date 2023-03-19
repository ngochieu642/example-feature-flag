# What is this?

- This is the naive way to implement feature flags
 
# Problems you can see with this implementation
- The logic of "enhancing" is tight coupled with the "toggle routers"
 
# Consequences
- [ ] if a feature is combined from multiple feature flag -> You have to use complex if structure
- [ ] Hard-coded string inside this class for feature flag
- [ ] The way to "enhance" is limited inside the class
  - What if you want to add logic to include "Voucher" ? You would need to fix this very class to do that
