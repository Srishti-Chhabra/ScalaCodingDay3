class BuyAndSellStock {
  def maxProfit(prices: List[Int]): Int = {
    if (prices.isEmpty) return 0

    def findMaxProfit(ind: Int,prices: List[Int], minPrice: Int, maxProfit: Int): Int = {
      if (ind >= prices.length) maxProfit
      else {
        val currentProfit = prices(ind) - minPrice
        val newMinPrice = Math.min(minPrice, prices(ind))
        val newMaxProfit = Math.max(maxProfit, currentProfit)
        findMaxProfit(ind + 1, prices, newMinPrice, newMaxProfit)
      }
    }

    findMaxProfit(1, prices, prices(0), 0)
  }
}

object  BuyAndSellStock extends App{
  val prices = List(7, 1, 5, 3, 6, 4)
  val buyAndSellStock = new BuyAndSellStock
  println(buyAndSellStock.maxProfit(prices))
}
