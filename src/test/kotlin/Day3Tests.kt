import kotlin.test.Test
import kotlin.test.assertEquals

class Day3Tests {

    private val slopes = listOf(1 to 1, 1 to 3, 1 to 5, 1 to 7, 2 to 1)

    @Test
    fun testExamples() {
        val input = """
            ..##.......
            #...#...#..
            .#....#..#.
            ..#.#...#.#
            .#...##..#.
            ..#.##.....
            .#.#.#....#
            .#........#
            #.##...#...
            #...##....#
            .#..#...#.#
        """.trimIndent()
        val forest = Forest.parse(input)
        assertEquals(7, forest.downSlope().size)
        assertEquals(336, slopes.fold(1) { acc, s -> acc * forest.downSlope(s).size })
    }

    @Test
    fun testInput() {
        val forest = Forest.parse(getInput(3))
        assertEquals(242, forest.downSlope().size)
        assertEquals(2265549792, slopes.fold(1L) { acc, s -> acc * forest.downSlope(s).size })
    }
}
