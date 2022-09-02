fun main(args: Array<String>) {
    val str =  "GOOG 90 160.45, JPMC 67 12.0 S, MYSPACE 24 210.0 B, CITI 50 450.0 B, CSCO 100 55.5 S"
    val str2 = ""
    println(OrdersSummary.balanceStatements(str))

    //"Buy: 100 Sell: 56041; Badly formed 1: ZNGA 1300 2.66 ;"
}

//"ZNGA 1300 2.66 B, CLH15.NYM 50 56.32 B, OWW 1000 11.623 B, OGG 20 580.1 B"
object OrdersSummary {
    fun balanceStatements(lst: String): String {
        if (lst.isEmpty()) return "Buy: 0 Sell: 0"
        val listOfStr: List<String> = lst.split(",\\s+".toRegex())

        val listValid: MutableList<List<String>> = mutableListOf()
        val listError: MutableList<String> = mutableListOf()
        for (str in listOfStr) {
            val listElement = str.split(" ".toRegex())
            if (isValidListElement(listElement))
                listValid.add(listElement)
            else listError.add(str)
        }

        //println(listValid)


        var sumBuy = 0.0
        var sumSell = 0.0
        for (list in listValid) {
            if (list[3] == "B")
                sumBuy += list[1].toInt() * list[2].toDouble()
            else if (list[3] == "S")
                sumSell += list[1].toInt() * list[2].toDouble()
        }

        var strTotal = "Buy: ${Math.round(sumBuy)} Sell: ${Math.round(sumSell)}"
        if (listError.isEmpty()) {
            return strTotal
        } else {
            strTotal += "; Badly formed ${listError.size}: "
            for (element in listError) {
                strTotal += element
                strTotal += " ;"
            }
        }
        return strTotal


    }

    private fun isValidListElement(listElement: List<String>): Boolean {
        if (listElement.size != 4) return false
        val a = listElement[1].matches(Regex("\\d+"))
        val b = listElement[2].matches(Regex("\\d+\\.\\d+"))
        val c = listElement[3].matches(Regex("S|B"))
        return a && b && c

    }
}