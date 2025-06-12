package com.practice.react.core.models;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class NavigationMenuImplModelTest {

    private AemContext context=new AemContext();

    @InjectMocks
    private NavigationMenuImplModel navigationMenuImplModel;

    @BeforeEach
    public void setup()
    {
        context.addModelsForClasses(NavigationMenuImplModel.class);
        context.load().json("/com.practice.react.core.models.NavigationMenuImplModel.json","/content");
        Resource resource = context.currentResource("/content");
        navigationMenuImplModel =  resource.adaptTo(NavigationMenuImplModel.class);
    }

    @Test
    public void testCorrectLogoPath()
    {
        assertNotNull(navigationMenuImplModel);
        assertEquals("/content/dam/wknd-spa-react/images/images.jpeg",navigationMenuImplModel.getLogoPath());
        assertEquals("Brand Logo",navigationMenuImplModel.getLogoAltText());
        assertNotNull(navigationMenuImplModel.getLinks());
        assertEquals("wknd-spa-react/components/navigation_menu",navigationMenuImplModel.getExportedType());
    }

}