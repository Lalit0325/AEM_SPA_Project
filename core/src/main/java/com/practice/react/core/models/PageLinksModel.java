package com.practice.react.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;


@Model(adaptables = {Resource.class, SlingHttpServletRequest.class},
      defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class PageLinksModel {

    @ValueMapValue
    private String pageTitle;
    @ValueMapValue
    private String pageLink;

    public String getPageTitle() {
        return pageTitle;
    }

    public String getPageLink() {
        return pageLink;
    }
}
