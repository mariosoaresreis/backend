package pt.com.altice.host.altice;

import javax.validation.Valid;
import javax.validation.constraints.PositiveOrZero;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import pt.com.altice.BusinessException;
import pt.com.altice.service.AlticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = { pt.com.altice.host.SwaggerConfig.TAG_ALTICCI_NUMBER })
public class AlticeEndpoint {
    
    @Autowired
    private AlticeService alticeService;
    
    private final Logger log = LoggerFactory.getLogger(AlticeEndpoint.class);
    
    
    @ApiOperation(value = "Calculates alticci number.")
    @GetMapping("alticci/{number}")
    public ResponseEntity<Integer> obterSadoDoCartao(@Valid @NonNull @PositiveOrZero @PathVariable Integer number) {       
        try {            
             return new ResponseEntity<>(alticeService.getAlticciNumber(number) , HttpStatus.OK);
        }catch(BusinessException ex) {
            throw new HttpClientErrorException(HttpStatus.UNPROCESSABLE_ENTITY, ex.getMessage());
        }catch(Exception ex) {
            if (log.isErrorEnabled())
                log.error("Error: It was not possible to calculate alticci number ", ex);
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}
