package com.practice.react.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Model(adaptables = { Resource.class,}, resourceType = VehicleModel.RESOURCE_TYPE, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class VehicleModel implements ComponentExporter {

    public final static String RESOURCE_TYPE = "wknd-spa-react/components/vehicle";
    public final static String END_CF_PATH = "/jcr:content/data/master";
    @ValueMapValue
    private String cfPath;

    @SlingObject
    private ResourceResolver resourceResolver;

    private List<Items> listOfVehicles;

    public String getCfPath() {
        return cfPath;
    }

    @PostConstruct
    public void init() {
        getVehicleStructuredData();
    }

    private void getVehicleStructuredData() {
        listOfVehicles = new ArrayList<>();
        if (cfPath == null || resourceResolver == null)
            return;

        Resource rootCFPath = resourceResolver.getResource(cfPath);
        if (rootCFPath == null)
            return;

        Iterable<Resource> children = rootCFPath.getChildren();
        for (Resource child : children) {
            Resource childCFPath = resourceResolver.getResource(child.getPath() + END_CF_PATH);
            if (childCFPath != null) {
                ValueMap valueMap = childCFPath.getValueMap();
                Items item = new Items(
                        valueMap.get("productName", String.class),
                        valueMap.get("available", String.class),
                        valueMap.get("productPrice", String.class),
                        valueMap.get("productImage", String.class),
                        valueMap.get("productDescription", String.class));
                listOfVehicles.add(item);
            }
        }
    }

    @Override
    public String getExportedType() {
        return VehicleModel.RESOURCE_TYPE;
    }

    @JsonProperty("listOfVehicles")
    public List<Items> getListOfVehicles() {
        return listOfVehicles;
    }

    static class Items {

        private String productName;
        private String available;
        private String productPrice;
        private String productImage;
        private String productDescription;

        public Items() {

        }

        public Items(String productName, String available, String productPrice, String productImage,
                String productDescription) {
            this.productName = productName;
            this.available = available;
            this.productPrice = productPrice;
            this.productImage = productImage;
            this.productDescription = productDescription;
        }

        public String getProductName() {
            return productName;
        }

        public String getAvailable() {
            return available;
        }

        public String getProductPrice() {
            return productPrice;
        }

        public String getProductImage() {
            return productImage;
        }

        public String getProductDescription() {
            return productDescription;
        }

    }
}
