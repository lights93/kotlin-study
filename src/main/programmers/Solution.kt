// https://programmers.co.kr/learn/courses/30/lessons/86052
class Solution {
    fun solution(grid: Array<String>): IntArray {
        val answer = mutableListOf<Int>()

        val used = mutableSetOf<Light>()

        for (index in grid.indices) {
            for (j in 0 until grid[index].length) {
                for(direction in 0 until 4) {
                    var size = 0
                    var light = Light(index, j, direction)

                    while (!used.contains(light)) {
                        used.add(light)

                        val newDirection = direction(light.direction, grid.get(light.i)[light.j])

                        var newI = light.i
                        var newJ = light.j
                        if(newDirection == 0) {
                            newI = (newI - 1 + grid.size) % grid.size
                        } else if(newDirection == 1){
                            newJ = (newJ + 1 + grid[newI].length) % grid[newI].length
                        } else if(newDirection == 2) {
                            newI = (newI + 1 + grid.size) % grid.size
                        } else if(newDirection == 3) {
                            newJ = (newJ - 1 + grid[newI].length) % grid[newI].length
                        }

                        light = Light(newI, newJ, newDirection)
                        size++
                    }

                    if(size != 0) {
                        answer.add(size)
                    }
                }
            }
        }

        return answer.sorted().toIntArray()
    }

    private fun direction(direction: Int, letter: Char): Int {
        when (letter) {
            'S' -> return direction
            'L' -> return when (direction) {
                0 -> 3
                1 -> 0
                2 -> 1
                3 -> 2
                else -> -1
            }
            'R' -> return when (direction) {
                0 -> 1
                1 -> 2
                2 -> 3
                3 -> 0
                else -> -1
            }
            else -> return -1
        }
    }
}

class Light(val i: Int, val j: Int, val direction: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Light

        if (i != other.i) return false
        if (j != other.j) return false
        if (direction != other.direction) return false

        return true
    }

    override fun hashCode(): Int {
        var result = i
        result = 31 * result + j
        result = 31 * result + direction
        return result
    }
}
