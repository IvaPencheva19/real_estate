package bg.tuvarna.sit.real_estate_proj.presentation.models;

import bg.tuvarna.sit.real_estate_proj.data.entities.EstateCity;
import bg.tuvarna.sit.real_estate_proj.data.entities.EstateCurrency;
import bg.tuvarna.sit.real_estate_proj.service.EstateCityService;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EstateCityServiceTest {
    EstateCityService service=EstateCityService.getInstance();
    EstateCity city=new EstateCity("Plovdiv");
    @Test
    void testCreateEstateCity(){
        service.createEstateCity(city);
        EstateCity ret=service.getCityByName("Plovdiv");
        assertNotNull(ret);
    }
    @Test
    void testGetCityByName(){
        EstateCity ret=service.getCityByName("Plovdiv");
        assertNotNull(ret);
        assertEquals("Plovdiv",ret.getCity());
    }
    @Test
    void testGetAll(){
        List<EstateCity> cities=service.getAllCities();
        assertNotNull(cities);
        assertEquals(3,cities.size());
    }
    @Test
    void testDeleteEstateCity(){
        EstateCity retCity=service.getCityByName("Plovdiv");
        service.deleteEstateCity(retCity);
        EstateCity ret=service.getCityByName("Plovdiv");
        assertNull(ret);
    }
}
