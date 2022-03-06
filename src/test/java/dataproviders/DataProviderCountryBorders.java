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
                Arguments.of("RUS", Arrays.asList("AZE","BLR","CHN","EST","FIN","GEO","KAZ","PRK","LVA","LTU","MNG","NOR","POL","UKR")
                        , "borders[0]"),
                Arguments.of("AZE", Arrays.asList("ARM","GEO","IRN","RUS","TUR"), "borders[0]"),
                Arguments.of("BLR", Arrays.asList("LVA","LTU","POL","RUS","UKR"), "borders[0]"),
                Arguments.of("CHN", Arrays.asList("AFG","BTN","MMR","HKG","IND","KAZ","PRK","KGZ","LAO",
                        "MAC","MNG","PAK","RUS","TJK","VNM","NPL"), "borders[0]"),
                Arguments.of("EST", Arrays.asList("LVA","RUS"), "borders[0]"),
                Arguments.of("FIN", Arrays.asList("NOR","SWE","RUS"), "borders[0]"),
                Arguments.of("GEO", Arrays.asList("ARM","AZE","RUS","TUR"), "borders[0]"),
                Arguments.of("KAZ", Arrays.asList("CHN","KGZ","RUS","TKM","UZB"), "borders[0]"),
                Arguments.of("PRK", Arrays.asList("CHN","KOR","RUS"), "borders[0]"),
                Arguments.of("LVA", Arrays.asList("BLR","EST","LTU","RUS"), "borders[0]"),
                Arguments.of("LTU", Arrays.asList("BLR","LVA","POL","RUS"), "borders[0]"),
                Arguments.of("MNG", Arrays.asList("CHN","RUS"), "borders[0]"),
                Arguments.of("NOR", Arrays.asList("FIN","SWE","RUS"), "borders[0]"),
                Arguments.of("POL", Arrays.asList("BLR","CZE","DEU","LTU","RUS","SVK","UKR"), "borders[0]"),
                Arguments.of("UKR", Arrays.asList("BLR","HUN","MDA","POL","ROU","RUS","SVK"), "borders[0]")
                );
    }
}
