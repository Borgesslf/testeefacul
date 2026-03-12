fun main() {
    println("--- CADASTRO DA FROTA ---")

    // Configurar o Carro do Gerente
    println("\n[A] Configurar o Carro do Gerente")
    print("Digite a Placa: ")
    val placaCarro = readLine()!!
    print("Combustível Inicial (Litros): ")
    val tanqueCarro = readLine()!!.toDouble()

    val carroGerente: Carro?
    try {
        carroGerente = Carro(placaCarro, tanqueCarro)
        println("Carro registrado com sucesso!")
    } catch (ex: Exception) {
        println("ERRO NO REGISTO: \\${ex.message}")
        return
    }

    // Configurar o Caminhão de Carga
    println("\n[B] Configurar o Caminhão de Carga")
    print("Digite a Placa: ")
    val placaCaminhao = readLine()!!
    print("Combustível Inicial (Litros): ")
    val tanqueCaminhao = readLine()!!.toDouble()
    print("Quantidade de Eixos: ")
    val eixosCaminhao = readLine()!!.toInt()

    val caminhaoCarga: Caminhao?
    try {
        caminhaoCarga = Caminhao(placaCaminhao, tanqueCaminhao, eixosCaminhao)
        println("Caminhão registrado com sucesso!")
    } catch (ex: Exception) {
        println("ERRO NO REGISTO: \\${ex.message}")
        return
    }

    // Simulação da Viagem
    println("\n--- SIMULAÇÃO DE ROTA ---")
    print("Qual a distância do trajeto (Km)? ")
    val distancia = readLine()!!.toDouble()

    if (carroGerente != null) {
        simularViagemPolimorfica(carroGerente, distancia)
    }
    if (caminhaoCarga != null) {
        simularViagemPolimorfica(caminhaoCarga, distancia)
    }

    println("\nSimulação concluída. Pressione ENTER para sair.")
    readLine()
}

fun simularViagemPolimorfica(v: Veiculo, quilometros: Double) {
    try {
        println("\n--- A INICIAR VIAGEM COM O VEÍCULO: \\${v.placa} ---")
        v.viajar(quilometros)
        println("Sucesso! Restou no tanque: \\$${String.format("%.2f", v.tanque)} Litros")
        println("Custo de Portagem (Pedágio): \\$${String.format("%.2f", v.calcularPedagio())}")
        println("Previsão de Revisão na Oficina: \\$${String.format("%.2f", v.calcularCustoRevisao())}")
    } catch (ex: Exception) {
        println("ALERTA NA VIAGEM: \\$${ex.message}")
    }
}