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
                        , "RUS", "borders[0]"),
                Arguments.of(Arrays.asList("ARM","GEO","IRN","RUS","TUR"), "AZE", "borders[0]"),
                Arguments.of(Arrays.asList("LVA","LTU","POL","RUS","UKR"), "BLR", "borders[0]"),
                Arguments.of(Arrays.asList("AFG","BTN","MMR","HKG","IND","KAZ","PRK","KGZ","LAO",
                        "MAC","MNG","PAK","RUS","TJK","VNM","NPL"), "CHN", "borders[0]"),
                Arguments.of(Arrays.asList("LVA","RUS"), "EST", "borders[0]"),
                Arguments.of(Arrays.asList("NOR","SWE","RUS"), "FIN", "borders[0]"),
                Arguments.of(Arrays.asList("ARM","AZE","RUS","TUR"), "GEO", "borders[0]"),
                Arguments.of(Arrays.asList("CHN","KGZ","RUS","TKM","UZB"), "KAZ", "borders[0]"),
                Arguments.of(Arrays.asList("CHN","KOR","RUS"), "PRK", "borders[0]"),
                Arguments.of(Arrays.asList("BLR","EST","LTU","RUS"), "LVA", "borders[0]"),
                Arguments.of(Arrays.asList("BLR","LVA","POL","RUS"), "LTU", "borders[0]"),
                Arguments.of(Arrays.asList("CHN","RUS"), "MNG", "borders[0]"),
                Arguments.of(Arrays.asList("FIN","SWE","RUS"), "NOR", "borders[0]"),
                Arguments.of(Arrays.asList("BLR","CZE","DEU","LTU","RUS","SVK","UKR"), "POL", "borders[0]"),
                Arguments.of(Arrays.asList("BLR","HUN","MDA","POL","ROU","RUS","SVK"), "UKR", "borders[0]")
                );
    }
}
