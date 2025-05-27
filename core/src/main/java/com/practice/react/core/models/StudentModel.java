package com.practice.react.core.models;

import com.adobe.cq.export.json.ComponentExporter;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;

public interface StudentModel extends ComponentExporter {
    String getName();
    int getAge();
    String getImage();
    String[] getSkills();
}
