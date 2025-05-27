package com.practice.react.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = SlingHttpServletRequest.class,
      adapters = {StudentModel.class, ComponentExporter.class},
       resourceType = StudentImplModel.RESOURCE_TYPE,
       defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name=ExporterConstants.SLING_MODEL_EXPORTER_NAME,extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class StudentImplModel implements StudentModel{

    public static final String RESOURCE_TYPE="wknd-spa-react/components/student";
    @ValueMapValue
    private String name;

    @ValueMapValue
    private int age;

    @ValueMapValue
    private String image;

    @ValueMapValue
    private String[] skills;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String[] getSkills() {
        return skills;
    }

    @Override
    public String getImage() {
        return image;
    }

    @Override
    public String getExportedType() {
        return StudentImplModel.RESOURCE_TYPE;
    }
}
