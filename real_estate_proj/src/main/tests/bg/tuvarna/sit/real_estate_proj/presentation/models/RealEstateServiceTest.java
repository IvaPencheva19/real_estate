package bg.tuvarna.sit.real_estate_proj.presentation.models;

import bg.tuvarna.sit.real_estate_proj.data.entities.*;
import bg.tuvarna.sit.real_estate_proj.service.EstateCityService;
import bg.tuvarna.sit.real_estate_proj.service.EstateCurrencyService;
import bg.tuvarna.sit.real_estate_proj.service.EstateTypeService;
import bg.tuvarna.sit.real_estate_proj.service.RealEstateService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RealEstateServiceTest {
    RealEstateService service=RealEstateService.getInstance();
    EstateCityService cityService=EstateCityService.getInstance();
    EstateCurrencyService currencyService=EstateCurrencyService.getInstance();
    EstateTypeService typeService=EstateTypeService.getInstance();
    EstateCity city=cityService.getCityByName("Varna");
    EstateCurrency currency=currencyService.getCurrencyByName("BGN");
    EstateType type=typeService.getTypeByName("Flat");

    RealEstate estate=new RealEstate("Boris Todorov",type,100.0,100000.0,currency,city,"Dubrovnik 1",1,2,"flat", (byte) 1,null);
    @Test
    void testCreateRealEstate(){
        Integer id=estate.getIdEstate();
        service.createRealEstate(estate);

        RealEstate ret=service.getById(id);
        assertNotNull(ret);
    }

    @Test
    void testGetAll(){
        List<RealEstate> estates=service.getAllEstates();
        assertNotNull(estates);
        assertEquals(3,estates.size());
    }
    @Test
    void testDeleteEstateCity(){
        Integer id=estate.getIdEstate();
        RealEstate ret=service.getById(id);
        service.deleteRealEstate(ret);

        assertNull(ret);
    }
}
