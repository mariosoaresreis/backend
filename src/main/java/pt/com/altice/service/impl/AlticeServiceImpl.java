package pt.com.altice.service.impl;

import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import pt.com.altice.BusinessException;
import pt.com.altice.service.AlticeService;

@Service
@PropertySource(ignoreResourceNotFound = false, value = "classpath:bootstrap.yml")
public class AlticeServiceImpl implements AlticeService {
    @Autowired
    private AlticeService self;

    @Override
    @Cacheable(value="numbers", key="#number")
    public Integer getAlticciNumber(Integer number) throws HttpException {
        if (number > 70)
            throw new BusinessException("Number range must be between 0 and 70");
        
        if (number == 0)
            return 0;
        
        if (number ==1 || number == 2) {
            return 1;
        }
        
        return self.getAlticciNumber(number - 2) + self.getAlticciNumber(number -3);
    }
    

    


}
