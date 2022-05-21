package bg.tuvarna.sit.real_estate_proj.presentation.models;

import bg.tuvarna.sit.real_estate_proj.data.entities.EstateType;
import bg.tuvarna.sit.real_estate_proj.service.EstateTypeService;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EstateTypeServiceTest {
    EstateTypeService service=EstateTypeService.getInstance();
    EstateType etype=new EstateType("Studio");
    @Test
    void testCreateEstateType(){
        service.createEstateType(etype);
        EstateType ret=service.getTypeByName("Studio");
        assertNotNull(ret);
    }

    @Test
    void testGetEstateTypeByName(){
        EstateType ret=service.getTypeByName("Studio");
        assertNotNull(ret);
        assertEquals("Studio",ret.getType());
    }
    @Test
    void testGetAll(){
        List<EstateType> types=service.getAllTypes();
        assertNotNull(types);
        assertEquals(3,types.size());
    }
    @Test
    void testDeleteEstateType(){
        EstateType etype=service.getTypeByName("Studio");
        service.deleteEstateType(etype);
        EstateType ret=service.getTypeByName("Studio");
        assertNull(ret);
    }
}
