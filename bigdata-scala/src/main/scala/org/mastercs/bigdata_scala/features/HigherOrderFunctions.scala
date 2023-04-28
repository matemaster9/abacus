package org.mastercs.bigdata_scala.features

/**
  * Description
  * Author: matemaster
  * Create: 2023-04-06 12:16
  */
object HigherOrderFunctions {

  /**
    * 返回函数的高阶函数
    *
    * @param ssl
    * @param domainName
    * @return
    */
  def urlBuilder(ssl: Boolean,
                 domainName: String): (String, String) => String = {
    val schema = if (ssl) "https://" else "http://"
    (endpoint: String, query: String) =>
      s"$schema$domainName/$endpoint?$query"
  }

  def main(args: Array[String]): Unit = {
    val salaries = Seq(20000, 70000, 40000)
    val doubleSalary = (x: Int) => x * 2
    val newSalaries = salaries.map(doubleSalary) // List(40000, 140000, 80000)

    val salaries2 = Seq(20000, 70000, 40000)
    val newSalaries2 = salaries2.map(x => x * 2) // List(40000, 140000, 80000)

    val domainName = "www.example.com"

    def getURL: (String, String) => String = urlBuilder(ssl = true, domainName)

    val endpoint = "users"
    val query = "id=1"
    val url = getURL(endpoint, query) // "https://www.example.com/users?id=1": String
  }
}

case class WeeklyWeatherForecast(temperatures: Seq[Double]) {

  private def convertCtoF(temp: Double): Double = temp * 1.8 + 32

  def forecastInFahrenheit: Seq[Double] =
    temperatures.map(convertCtoF) // <-- passing the method convertCtoF
}

object SalaryRaiser {

  /**
    * 接受函数的高阶函数
    *
    * @param salaries
    * @param promotionFunction
    * @return
    */
  private def promotion(salaries: List[Double],
                        promotionFunction: Double => Double): List[Double] =
    salaries.map(promotionFunction)

  def smallPromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * 1.1)

  def bigPromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * math.log(salary))

  def hugePromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * salary)
}
