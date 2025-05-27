package com.practice.react.core.models;

import com.adobe.cq.export.json.ComponentExporter;

import java.util.List;

public interface NavigationMenuModel extends ComponentExporter {
    String getLogoPath();
    String getLogoAltText();
    List<PageLinksModel> getLinks();

}
