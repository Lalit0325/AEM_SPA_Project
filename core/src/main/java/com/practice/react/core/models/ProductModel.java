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
       resourceType = ProductModel.RESOURCE_TYPE,
      defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name= ExporterConstants.SLING_MODEL_EXPORTER_NAME,extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class ProductModel implements ComponentExporter {

    public final static String RESOURCE_TYPE ="wknd-spa-react/components/product";

    @ValueMapValue
    private String productName;

    @ValueMapValue
    private String text;


    public String getText() {
        return text;
    }

    public String getProductName() {
        return productName;
    }
    @Override
    public String getExportedType() {
        return ProductModel.RESOURCE_TYPE;
    }
}
