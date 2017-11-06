package tusla.poc.ToggleFeature;

import org.togglz.core.Feature;
import org.togglz.core.annotation.Label;
import org.togglz.core.context.FeatureContext;

public  enum ToggleFeature implements Feature {

    @Label("AdvertisedTyres")
     AdvertisedTyres;

    public boolean isActive() {
        return FeatureContext.getFeatureManager().isActive(this);
    }

}
