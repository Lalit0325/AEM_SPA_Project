package com.practice.react.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Model(adaptables = {Resource.class, SlingHttpServletRequest.class},
       adapters = {ComponentExporter.class},
       resourceType = BHKitsModel.RESOURCE_TYPE,
       defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name= ExporterConstants.SLING_MODEL_EXPORTER_NAME,extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class BHKitsModel implements ComponentExporter {

    public static final String RESOURCE_TYPE="wknd-spa-react/components/kits";

    @ChildResource(name = "kits")
    private Resource kitsResource;

    public List<KitItems> getKits() {
        if (kitsResource == null) {
            return Collections.emptyList();
        }
        return StreamSupport.stream(kitsResource.getChildren().spliterator(), false)
                .map(child -> child.adaptTo(KitItems.class))
                .collect(Collectors.toList());
    }
    @Override
    public String getExportedType() {
        return BHKitsModel.RESOURCE_TYPE;
    }
}
