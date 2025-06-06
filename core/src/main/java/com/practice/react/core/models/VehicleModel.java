package com.practice.react.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;

@Model(adaptables = {Resource.class, SlingHttpServletRequest.class},
       resourceType = VehicleModel.RESOURCE_TYPE,
      defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name= ExporterConstants.SLING_MODEL_EXPORTER_NAME,extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class VehicleModel implements ComponentExporter {

    public final static String RESOURCE_TYPE ="wknd-spa-react/components/vehicle";
    public final static String END_CF_PATH="/jcr:content/data/master";
    @ValueMapValue
    private String cfPath;

    @SlingObject
    private ResourceResolver resourceResolver;

    public String getCfPath() {
        return cfPath;
    }

    @PostConstruct
    public void init()
    {
        getVehicleStructuredData();
    }

    private void getVehicleStructuredData() {
        Resource rootCFPath = resourceResolver.getResource(cfPath);
         Iterable<Resource> childResource = rootCFPath.getChildren();
         for(Resource child:childResource)
         {

             String path =child.getPath();
             Resource childCFPath = resourceResolver.getResource(path+END_CF_PATH);
             if(childCFPath!=null) {
                 ValueMap valueMap = childCFPath.getValueMap();
                 String name = valueMap.get("productName", String.class);
                 String productPrice = valueMap.get("productPrice", String.class);
                 String productImage = valueMap.get("productImage", String.class);
//             boolean available = valueMap.get("available", Boolean.class);

             }
         }
        }



    @Override
    public String getExportedType() {
        return VehicleModel.RESOURCE_TYPE;
    }
}
