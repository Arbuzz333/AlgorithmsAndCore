package avahidov.com.sorting

import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import java.util.stream.Stream


class ArraysSourceTest: ArgumentsProvider {

    override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
        return Stream.of(
            Arguments.arguments(arrayOf(0, 1, 2, 3, 4, 5), arrayOf(5, 4, 3, 2, 1, 0)),
            Arguments.arguments(arrayOf(0, 1, 5, 20, 44, 44), arrayOf(5, 44, 44, 20, 1, 0)),
            Arguments.arguments(arrayOf(0, 100), arrayOf(100, 0)),
            Arguments.arguments(arrayOf(1, 100), arrayOf(1, 100))
        )
    }
}
