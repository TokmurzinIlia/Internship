package dataproviders;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.Arrays;
import java.util.stream.Stream;

public class DataProviderCountryBorders implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(Arrays.asList("AZE","BLR","CHN","EST","FIN","GEO","KAZ","PRK","LVA","LTU","MNG","NOR","POL","UKR")
                        , "RUS", "borders[0]"));
    }
}
