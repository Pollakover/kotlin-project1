import java.util.Scanner

class Expense(var sum: Int, var category: String, var date: String)

class Expenses {

    private val expensesLists : MutableList<Expense> = mutableListOf(
        Expense(200, "Food", "01.05.2024"),
        Expense(150, "Food", "`17.06.2024"),
        Expense(50, "Transport", "20.06.2024"),
        Expense(75, "Food", "23.06.2024"),
        Expense(30, "Transport", "01.07.2024"),
        Expense(300, "Shopping", "10.07.2024"),
        Expense(120, "Entertainment", "03.08.2024"),
        Expense(200, "Entertainment", "18.08.2024"),
        Expense(100, "Shopping", "05.09.20024"),
    )

    fun addExpense(){
        println("Введите сумму: ")
        val scan = Scanner(System.`in`)
        val sum  = scan.nextInt()
        println("Введите категорию: ")
        val category : String = readLine().toString()
        println("Введите дату: ")
        val date : String = readLine().toString()

        val expense = Expense(sum, category, date)
        expensesLists.add(expense)
    }

    fun printExpenses(){
        for (expense in expensesLists) {
            println("${expense.sum} ${expense.category} ${expense.date}")
        }
    }

    fun countExpenses() {
        val categoriesSet: MutableSet<String> = mutableSetOf()
        val categoriesSum : MutableList<Int> = mutableListOf()
        var categorySum = 0

        for (expense in expensesLists) {
            categoriesSet.add(expense.category)
        }

        for (category in categoriesSet) {
            for (expense in expensesLists) {
                if (expense.category == category) {
                    categorySum += expense.sum
                }
            }
            categoriesSum.add(categorySum)
            categorySum = 0
        }

        val categoriesList = categoriesSet.toList()
        for (i in categoriesSet.indices) {
            println("Расходы для категории ${categoriesList[i]}: ${categoriesSum[i]}")
        }
    }
}

fun main() {
    val expenses = Expenses()
    var check: Int
    println("Введите 0 чтобы завершить работу программы.\n" +
            "Введите 1, чтобы добавить новый расход.\n" +
            "Введите 2, чтобы вывести список расходов" +
            "\nВведите 3, чтобы вывести суммы расходов для категорий")

    do {
        val scan = Scanner(System.`in`)
        check  = scan.nextInt()
        if(check == 0) { println("Выход..."); break}
        if(check == 1) expenses.addExpense()
        if(check == 2) expenses.printExpenses()
        if(check == 3) expenses.countExpenses()
    } while (true)
}