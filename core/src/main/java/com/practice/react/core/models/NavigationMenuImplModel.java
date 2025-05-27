package com.practice.react.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(adaptables = {Resource.class, SlingHttpServletRequest.class},
        resourceType = NavigationMenuImplModel.RESOURCE_TYPE,
        adapters = {NavigationMenuModel.class, ComponentExporter.class},
       defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name=ExporterConstants.SLING_MODEL_EXPORTER_NAME,extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class NavigationMenuImplModel implements NavigationMenuModel{

    public static final String RESOURCE_TYPE="wknd-spa-react/components/navigation_menu";

    @ValueMapValue
    private String logoPath;
    @ValueMapValue
    private String logoAltText;
    @ChildResource(name = "links")
    private List<PageLinksModel> links;


    @Override
    public String getLogoPath() {
        return logoPath;
    }

    @Override
    public String getLogoAltText() {
        return  logoAltText;
    }

    @Override
    public List<PageLinksModel> getLinks() {
        return links;
    }

    @Override
    public String getExportedType() {
        return RESOURCE_TYPE;
    }
}
