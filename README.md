Expansive Energy
================
### Too many cables? Not anymore.

What is it?
-----------
Expansive Energy will be an all-in-one technology mod for Minecraft, designed to work by transferring energy without any cables.


#### TODO: Pretty much everything

#### Note on compatibility:
This mod uses reflection to produce a more dynamic registry system, I'm not entirely sure about how compatible it will be,
although I don't expect there to really be any issues.

Everything handled through the registry is stored in 
`ebkr.expansive.energy.mod.resolver.ResolvedStorage`.

This means all registered classes can be access using
`new ResolvedStorage<CLASS>().get(CLASS.class);`