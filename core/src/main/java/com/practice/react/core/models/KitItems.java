package com.practice.react.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Model(adaptables = {Resource.class, SlingHttpServletRequest.class},
       defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class KitItems {

    @ValueMapValue
    private String kitImage;

    @ValueMapValue
    private String kitName;

    @ValueMapValue
    private String kitDescription;

    @ChildResource(name = "features")
    private Resource kitFeatures;


    public String getKitImage() {
        return kitImage;
    }

    public String getKitName() {
        return kitName;
    }

    public String getKitDescription() {
        return kitDescription;
    }

    public List<KitFeatures> getFeatures() {
        if (kitFeatures == null) {
            return Collections.emptyList();
        }
        return StreamSupport.stream(kitFeatures.getChildren().spliterator(), false)
                .map(child -> child.adaptTo(KitFeatures.class))
                .collect(Collectors.toList());
    }
}
