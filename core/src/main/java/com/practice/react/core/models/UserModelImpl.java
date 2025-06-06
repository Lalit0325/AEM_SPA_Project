package com.practice.react.core.models;


import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceUtil;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Model(adaptables = {Resource.class, SlingHttpServletRequest.class},
       adapters = {UserModel.class, ComponentExporter.class},
       resourceType = UserModelImpl.RESOURCE_TYPE,
      defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name= ExporterConstants.SLING_MODEL_EXPORTER_NAME,extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class UserModelImpl implements  UserModel{

    public final static String RESOURCE_TYPE="wknd-spa-react/components/user";
    private final static String RESOURCE_PATH="/jcr:content/data/master";
    private final Logger logger= LoggerFactory.getLogger(UserModelImpl.class);
    @ValueMapValue
    private String userName;

    @ValueMapValue
    private String profilePath;

    @SlingObject
    ResourceResolver resourceResolver;

    private Map<String,String> authorData;

    @PostConstruct
    public void init()
    {
        findData();
    }
    private void findData()
    {
        String path=profilePath+RESOURCE_PATH;
        Resource resource = resourceResolver.getResource(path);
        authorData=new HashMap<>();
        if(resource!=null) {
            ValueMap valueMap = resource.getValueMap();
            String address=resource.getValueMap().get("address",String.class);
            logger.info("My Address "+address);
            String name = valueMap.get("name", String.class);
            logger.info("My Name "+name);
            String age = valueMap.get("age", String.class);
            logger.info("My Age "+age);
            authorData.put("name",name);
            authorData.put("age",age);
            authorData.put("address",address);

        }

    }

    public String getProfilePath() {
        return profilePath;
    }

    public Map<String, String> getAuthorData() {
        return authorData;
    }

    @Override
    public String getUserName() {
        return userName;
    }


    @Override
    public String getExportedType() {
        return UserModelImpl.RESOURCE_TYPE;
    }
}
