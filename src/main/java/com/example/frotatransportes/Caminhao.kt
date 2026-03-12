class Caminhao(placa: String, tanque: Double, val quantidadeEixos: Int) : Veiculo(placa, tanque) {
    override fun viajar(distanciaKm: Double) {
        val consumo = distanciaKm / 4
        if (tanque < consumo) {
            throw InvalidOperationException("Combustível insuficiente para o caminhão.")
        }
        tanque -= consumo
    }

    override fun calcularPedagio(): Double {
        return 8.50 * quantidadeEixos
    }

    override fun calcularCustoRevisao(): Double {
        return 1500.00
    }
}