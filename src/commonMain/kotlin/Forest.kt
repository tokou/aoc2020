
data class Forest(val size: Pair<Int, Int>, val trees: Set<Pair<Int, Int>>) {

    fun downSlope(slope: Pair<Int, Int> = 3 to 1): List<Pair<Int, Int>> {
        var current = 0 to 0
        val encountered = mutableListOf<Pair<Int, Int>>()
        while (current.second < size.second) {
            if (trees.contains((current.first % size.first) to current.second)) {
                encountered.add(current)
            }
            current = (current.first + slope.first) to (current.second + slope.second)
        }
        return encountered
    }

    companion object {
        fun parse(string: String): Forest {
            val lines = string.split("\n")
            val coords = lines.flatMapIndexed { i, l ->
                l.mapIndexed { j, c -> c to j }
                    .filter { it.first == '#' }
                    .map { it.second to i }
            }.toSet()
            return Forest(lines.first().length to lines.size, coords)
        }
    }
}
