package com.practice.react.core.models;

import com.adobe.cq.export.json.ComponentExporter;

public interface Author extends ComponentExporter {
    String getName();
    int getAge();
}
