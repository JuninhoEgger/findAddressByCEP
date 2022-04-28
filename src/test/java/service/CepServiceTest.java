package service;

import argumentsprovider.service.CepServiceArgumentsProvider;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static service.CepService.findAddressByCep;

class CepServiceTest {

    @ParameterizedTest
    @ArgumentsSource(CepServiceArgumentsProvider.class)
    void shouldValidateCeps(List<String> ceps, Boolean expected) {
        ceps.forEach(cep -> {
            try {
                boolean actual = findAddressByCep(cep) != null;
                assertEquals(expected, actual, "DEVE VALIDAR OS CEPs");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
