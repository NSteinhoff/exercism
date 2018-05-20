case class SpaceAge(val seconds: Long) {
  private val earthYear = 31557600D
  private val scaleYear: Double => Double = factor =>
    BigDecimal(seconds / earthYear / factor)
      .setScale(2, BigDecimal.RoundingMode.HALF_UP)
      .toDouble

  val onEarth: Double = scaleYear(1)
  val onMercury: Double = scaleYear(0.2408467)
  val onVenus: Double = scaleYear(0.61519726)
  val onMars: Double = scaleYear(1.8808158)
  val onJupiter: Double = scaleYear(11.862615)
  val onSaturn: Double = scaleYear(29.447498)
  val onUranus: Double = scaleYear(84.016846)
  val onNeptune: Double = scaleYear(164.79132)
}
