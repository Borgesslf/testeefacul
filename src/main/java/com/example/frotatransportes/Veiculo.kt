abstract class Veiculo(val placa: String, protected var tanque: Double) : IManutencao {
    init {
        if (tanque < 0) {
            throw IllegalArgumentException("O tanque não pode ser negativo.")
        }
    }
    abstract fun viajar(distanciaKm: Double)
    abstract fun calcularPedagio(): Double
}