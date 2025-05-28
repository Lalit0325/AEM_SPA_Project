package com.practice.react.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;


import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;


@Model(adaptables = {Resource.class, SlingHttpServletRequest.class},
       resourceType =FooterModel.RESOURCE_TYPE ,
       defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name= ExporterConstants.SLING_MODEL_EXPORTER_NAME,extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class FooterModel implements ComponentExporter {
    public static final String RESOURCE_TYPE="wknd-spa-react/components/footer";

    @ValueMapValue
    private String myText;

    public String getMyText() {
        return myText;
    }

    @Override
    public String getExportedType() {
        return FooterModel.RESOURCE_TYPE;
    }
}
