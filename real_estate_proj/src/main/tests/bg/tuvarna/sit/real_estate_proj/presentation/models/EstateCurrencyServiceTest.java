package bg.tuvarna.sit.real_estate_proj.presentation.models;

import bg.tuvarna.sit.real_estate_proj.data.entities.EstateCurrency;
import bg.tuvarna.sit.real_estate_proj.data.entities.EstateType;
import bg.tuvarna.sit.real_estate_proj.service.EstateCurrencyService;
import bg.tuvarna.sit.real_estate_proj.service.EstateTypeService;
import org.junit.jupiter.api.Test;

import java.util.Currency;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EstateCurrencyServiceTest {
    EstateCurrencyService service=EstateCurrencyService.getInstance();
    EstateCurrency currency=new EstateCurrency("USD");
    @Test
    void testCreateEstateCurrency(){
        service.createEstateCurrency(currency);
        EstateCurrency ret=service.getCurrencyByName("USD");
        assertNotNull(ret);
    }

    @Test
    void testGetCurrencyByName(){
        EstateCurrency ret=service.getCurrencyByName("USD");
        assertNotNull(ret);
        assertEquals("USD",ret.getCurrency());
    }
    @Test
    void testGetAll(){
        List<EstateCurrency> currencies=service.getAllCurrency();
        assertNotNull(currencies);
        assertEquals(3,currencies.size());
    }
    @Test
    void testDeleteEstateCurrency(){
        EstateCurrency curr=service.getCurrencyByName("USD");
        service.deleteEstateCurrency(curr);
        EstateCurrency ret=service.getCurrencyByName("USD");
        assertNull(ret);
    }
}
