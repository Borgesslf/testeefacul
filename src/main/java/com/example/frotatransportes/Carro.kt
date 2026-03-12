class Carro(placa: String, tanque: Double) : Veiculo(placa, tanque) {
    override fun viajar(distanciaKm: Double) {
        val consumo = distanciaKm / 10
        if (tanque < consumo) {
            throw InvalidOperationException("Combustível insuficiente para o carro.")
        }
        tanque -= consumo
    }

    override fun calcularPedagio(): Double {
        return 8.50
    }

    override fun calcularCustoRevisao(): Double {
        return 300.00
    }
}