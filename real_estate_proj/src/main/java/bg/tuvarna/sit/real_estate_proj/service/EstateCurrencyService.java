package bg.tuvarna.sit.real_estate_proj.service;
import bg.tuvarna.sit.real_estate_proj.data.entities.Customer;
import bg.tuvarna.sit.real_estate_proj.data.entities.EstateCity;
import bg.tuvarna.sit.real_estate_proj.data.entities.EstateCurrency;
import bg.tuvarna.sit.real_estate_proj.data.entities.RealEstate;
import bg.tuvarna.sit.real_estate_proj.data.repositories.EstateCurrencyRepository;

import java.util.Currency;
import java.util.List;

public class EstateCurrencyService {
    private final EstateCurrencyRepository repository=EstateCurrencyRepository.getInstance();

    public static EstateCurrencyService getInstance() {
        return EstateCurrencyService.UserHolder.INSTANCE;
    }

    private static class UserHolder {
        public static final EstateCurrencyService INSTANCE = new EstateCurrencyService();
    }
    public void createEstateCurrency(EstateCurrency currency){
        repository.save(currency);
    }
    public void deleteEstateCurrency(EstateCurrency currency){
        repository.delete(currency);
    }
    public void changeCurrency(EstateCurrency currency, String name){
        currency.setCurrency(name);
        repository.update(currency);
    }

    public List<EstateCurrency> getAllCurrency(){
        return repository.getAll();
    }
    public EstateCurrency getCurrencyById(int id){
        EstateCurrency currency=repository.getById(id);
        return currency;
    }
    public EstateCurrency getCurrencyByName(String name){
        EstateCurrency currency=repository.getByName(name);
        return currency;
    }
}
