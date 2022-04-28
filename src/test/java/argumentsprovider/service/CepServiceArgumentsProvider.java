package argumentsprovider.service;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class CepServiceArgumentsProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                shouldReturnTrueWhenCepExists(),
                shouldReturnFalseWhenCepNotExists()
        );
    }

    private Arguments shouldReturnTrueWhenCepExists() {
        return Arguments.of(
                asList(
                        "94030210",
                        "90240005",
                        "90610970",
                        "94030140"
                ),
                true
        );
    }

    private Arguments shouldReturnFalseWhenCepNotExists() {
        return Arguments.of(
                asList(
                        "000000001741834184",
                        "111111114132846214"
                ),
                false
        );
    }
}
