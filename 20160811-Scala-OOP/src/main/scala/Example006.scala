

class Counter(val count: Int) {
  def dec = new Counter(count - 1)
  def inc = new Counter(count + 1)
}


class CounterFast(val count: Int) {
  def dec(amount: Int = 1) = new CounterFast(count - amount)
  def inc(amount: Int = 1) = new CounterFast(count + amount)
}


class CounterFast2(val count: Int) {
  def dec: CounterFast2 = dec()
  def inc: CounterFast2 = inc()
  def dec(amount: Int = 1): CounterFast2 = new CounterFast2(count - amount)
  def inc(amount: Int = 1): CounterFast2 = new CounterFast2(count + amount)
}


object Example006 extends App{
  assert(new Counter(10).inc.dec.inc.inc.count == 12)

  assert(new CounterFast(10).inc().inc(10).count == 21)

  assert(new CounterFast2(10).inc.inc(10).count == 21)
}
