package com.practice.react.core.models;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(AemContextExtension.class)
class VehicleModelTest {
    
    private final AemContext context = new AemContext();
    private VehicleModel model;

    @BeforeEach
    void setUp() {
        context.addModelsForClasses(VehicleModel.class);
    }

    @Test
    void testValidVehicleData() {
        context.load().json("/com.practice.react.core.models.VehicleModelModel.json", "/content");
        context.currentResource("/content");
        model = context.currentResource().adaptTo(VehicleModel.class);
        assertNotNull(model);
        assertEquals("/content/dam/wknd-spa-react/content-fragments/products", model.getCfPath());
        assertEquals("wknd-spa-react/components/vehicle", model.getExportedType());
        List<VehicleModel.Items> items = model.getListOfVehicles();
        assertNotNull(items);
        assertEquals(2, items.size());
        VehicleModel.Items first = items.get(0);
        assertEquals("KTM Bike", first.getProductName());
        assertEquals("true", first.getAvailable());
        assertEquals("445452.0", first.getProductPrice());
        assertEquals("/content/dam/wknd-spa-react/images/ktm-rc-200.jpg", first.getProductImage());
        assertEquals("KTM Bike description", first.getProductDescription());
        VehicleModel.Items second = items.get(1);
        assertEquals("Tata Nexon", second.getProductName());
        assertEquals("true", second.getAvailable());
        assertEquals("324563.0", second.getProductPrice());
        assertEquals("/content/dam/wknd-spa-react/images/Tata-Nexon.jpg", second.getProductImage());
        assertEquals("Tata Nexon description", second.getProductDescription());
    }

    @Test
    void testNullCfPath() throws Exception {
        model = new VehicleModel();
        injectField(model, "resourceResolver", context.resourceResolver());
        injectField(model, "cfPath", null);
        model.init();
        assertNotNull(model.getListOfVehicles());
        assertTrue(model.getListOfVehicles().isEmpty());
    }

    @Test
    void testNullResourceResolver() throws Exception {
        model = new VehicleModel();
        injectField(model, "cfPath", "/some/path");
        injectField(model, "resourceResolver", null);
        model.init();
        assertNotNull(model.getListOfVehicles());
        assertTrue(model.getListOfVehicles().isEmpty());
    }

    @Test
    void testInvalidCfPath() throws Exception {
        model = new VehicleModel();
        injectField(model, "cfPath", "/non/existing/path");
        injectField(model, "resourceResolver", context.resourceResolver());
        model.init();
        assertNotNull(model.getListOfVehicles());
        assertTrue(model.getListOfVehicles().isEmpty());
    }

//    @Test
//    void testChildExistsButMasterMissing() throws Exception {
//        context.create().resource("/content/vehicles/child1");
//        context.currentResource("/content/vehicles");
//        model = context.request().adaptTo(VehicleModel.class);
//        model.init();
//        assertNotNull(model.getListOfVehicles());
//        assertEquals(0, model.getListOfVehicles().size());
//    }

    private void injectField(Object target, String fieldName, Object value) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

}
