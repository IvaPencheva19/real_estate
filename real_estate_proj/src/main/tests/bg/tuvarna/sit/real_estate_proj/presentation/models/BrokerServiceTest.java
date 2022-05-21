package bg.tuvarna.sit.real_estate_proj.presentation.models;

import bg.tuvarna.sit.real_estate_proj.data.entities.Broker;
import bg.tuvarna.sit.real_estate_proj.service.BrokerService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BrokerServiceTest {
    BrokerService service=BrokerService.getInstance();
    Broker broker=new Broker("testBroker","123","Petko","Petkov","0882788998","petkov123@gmail.com");
    @Test
    void testCreateBroker(){
        service.createBroker(broker);
        Broker ret=service.getByUsername("testBroker");
        assertNotNull(ret);
    }
    @Test
    void testGetBrokerByUsername(){
        Broker ret=service.getByUsername("testBroker");
        assertNotNull(ret);
        assertEquals("testBroker",ret.getUsername());
    }
    @Test
    void testChangeBrokerEmail(){
        Broker ret=service.getByUsername("testBroker");
        service.changeEmail(ret,"new_petkov@gmail.com");
        assertNotNull(ret);
        assertEquals("new_petkov@gmail.com",ret.getEmail());
    }
    @Test
    void testGetAll(){
        List<Broker> brokers=service.getAllBrokers();
        assertNotNull(brokers);
        assertEquals(3,brokers.size());
    }
    @Test
    void testDeleteEstateCity(){
        Broker retBroker=service.getByUsername("testBroker");
        service.deleteBroker(retBroker);
        Broker ret=service.getByUsername("testBroker");
        assertNull(ret);
    }
}
