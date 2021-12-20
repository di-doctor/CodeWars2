fun main(args: Array<String>) {
    val str = "ZNGA 1300 2.0 B, CLH15.NYM 50.0 56.32 S, OWW 1000 11.623 S, OGG 20 580.1 B"
    println(OrdersSummary.balanceStatements(str))

    //"Buy: 100 Sell: 56041; Badly formed 1: ZNGA 1300 2.66 ;"
}

//"ZNGA 1300 2.66 B, CLH15.NYM 50 56.32 B, OWW 1000 11.623 B, OGG 20 580.1 B"
object OrdersSummary {
    fun balanceStatements(lst: String): String {
        val listOfStr: List<String> = lst.split(",\\s+".toRegex())

        val listValid: MutableList<List<String>> = mutableListOf()
        val listError: MutableList<List<String>> = mutableListOf()
        for (str in listOfStr) {
            val listElement = str.split(" ".toRegex())
            if (isValidListElement(listElement))
                listValid.add(listElement)
            else listError.add(listElement)
        }

        //println(listValid)
        //println(listError)

        var sumBuy = 0.0
        var sumSell = 0.0
        for (list in listValid) {
            if (list[3] == "B")
                sumBuy += list[1].toInt() * list[2].toDouble()
            else if (list[3] == "S")
                sumSell += list[1].toInt() * list[2].toDouble()
        }

        var strTotal = "Buy: ${sumBuy.toInt()} Sell: ${sumSell.toInt()}"
        if (listError.isEmpty()){
            return strTotal
        }else{
            strTotal += "; Badly formed ${listError.size}: "
            for (element in listError){
                strTotal+=element
                strTotal+=" ;"
            }
        }
        return strTotal



    }

    private fun isValidListElement(listElement: List<String>): Boolean {
        val a = listElement[1].matches(Regex("\\d+"))
        val b = listElement[2].matches(Regex("\\d+\\.\\d+"))
        return a && b

    }
}