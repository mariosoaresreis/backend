package pt.com.altice.service;

import org.apache.http.HttpException;

public interface AlticeService {  
    Integer getAlticciNumber(Integer number) throws HttpException;
}
