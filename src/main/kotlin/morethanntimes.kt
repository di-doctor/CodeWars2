fun main() {
    val array = arrayOf(1, 2, 3, 4, 5)
    val array2 = intArrayOf()
    val param = 100
    val array3 = Array<Int>(10) { it + param }.contentToString().also { println(it) }
    println(array.size)
    println(array2.size)




    EnoughIsEnough.deleteNth(array.toIntArray(), 1).toList().also { println(it) }


}

object EnoughIsEnough {
    fun deleteNth(elements: IntArray, maxOcurrences: Int): IntArray {
        if (maxOcurrences < 0) return emptyArray<Int>().toIntArray()
        val elementsList = elements.toList()
        val mutMap: MutableMap<Int, Int> = mutableMapOf()
        val resultArray: MutableList<Int> = mutableListOf()
        elementsList.associateWithTo(mutMap) { maxOcurrences }
        for (item in elementsList) {
            val sizeValue = mutMap[item]
            if (sizeValue == 0) continue
            else {
                resultArray.add(item)
                mutMap[item] = sizeValue!! - 1
            }
        }

        return resultArray.toIntArray()
    }
}