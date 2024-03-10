/*
//////////////////////////
Leia o escopo do main para entender o que deverá ser feito na atividade;
//////////////////////////
*/

val materiasENotas = mutableMapOf<String, MutableList<Double>>()

/**
 * Adiciona uma disciplina no dicionário mutável,
 * Recebe um array de notas (opcional)
 * Retorna true se conseguiu, false se não.
 */
fun adicionarDisciplina(materia: String, notas: MutableList<Double>): Boolean {
    return materiasENotas.put(materia, notas) != null
}

/**
 * Adiciona uma nota à lista de notas de uma determinada matéria;
 * Retorna true se conseguiu adicionar, false se não conseguiu.
 */
fun adicionarNota(materia: String, nota: Double): Boolean {
    val notasDaMateria = materiasENotas[materia]

    return if (notasDaMateria != null) {
        notasDaMateria.add(nota)
        true
    } else {
        false
    }
}


/**
 *Mostra na tela todas as notas presentes em uma matéria, no seguinte formato:
 * Materia: {nome da materia}
 * Nota 1: 5.4 \n
 * Nota 2: 7.8 \n
 * ...
 * Nota n: 10.0 \n
 * \n
 * Média:  {5.4 + 7.8 + ... + 10.0 / n} \n [TO DO <////////]
 * \n
 *
 * Caso não encontre a materia no map, mostre:
 * Materia {nome da materia} não encontrada \n
 *
 * Caso não seja possível mostar as notas, mostre:
 * Não foi possível mostrar as notas da matéria {nome da materia} \n
 */
fun mostrarNotas(materia:String){

    if(!materiasENotas.containsKey(materia)){
        println("Materia $materia não encontrada")
    }
    else{
        val listaNotas = materiasENotas[materia]

        if (listaNotas != null) {
            var cont = 1
            for(nota:Double in listaNotas){
                println("Nota ${cont++}: $nota")
            }
        }
        else{
            println("Não foi possível mostrar as notas da matéria ${materia}")
        }

        println()
    }


}

/*Retorna a média obtida apartir de uma lista de notas */
fun calcularMedia(notas: List<Double>): Double {
    return if (notas.isNotEmpty()) {
        notas.sum() / notas.size
    } else {
        0.0
    }
}

/**
 *Adiciona várias notas de uma só vez em uma matéria
 * retorne true se conseguiu adicionar, false se não consegiu.
 * */
fun adicionarVariasNotas(materia:String, vararg notas:Double): Boolean {
    val notasDaMateria = materiasENotas[materia]
    return if (notasDaMateria != null) {
        notasDaMateria.addAll(notas.toList())
        true
    } else {
        false
    }
}


fun main() {
    // 1. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, através de atribuição possicional
    adicionarDisciplina("CE", mutableListOf(8.0, 7.5, 9.0))

    // 2. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, através de atribuição nomeada
    val notasGPS = mutableListOf(6.5, 8.0, 7.0)
    adicionarDisciplina(materia = "GPS", notas = notasGPS)

    // 3. adicionarDisciplinas -> altere a função adicionarDisciplinas para que o parametro notas possua um valor padrão. Dica: utilize mutableListOf()
    fun adicionarDisciplina(materia: String, notas: MutableList<Double> = mutableListOf()): Boolean {
        return materiasENotas.put(materia, notas) != null
    }

    // 4. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, sem atribuir valores a notas
    adicionarDisciplina("PDM")

    // 5. adicionarNota -> adicione 3 notas para as 3 disciplinas
    adicionarNota("PDM", 7.0)
    adicionarNota("PPS", 9.0)
    adicionarNota("PWEB2", 8.0)

    // 6. mostrarNotas -> Mostre as notas das 3 disciplinas
    mostrarNotas("PDM")
    mostrarNotas("PPS")
    mostrarNotas("PWEB2")

    // 7. adicionarDisciplina -> adicione mais 1 disciplina
    adicionarDisciplina("Topicos")

    // 8. adicionarVariasNotas -> implemente o metodo adicionarVariasNotas();
    fun adicionarVariasNotas(materia: String, vararg notas: Double) {
        val notasDaMateria = materiasENotas[materia]
        if (notasDaMateria != null) {
            notasDaMateria.addAll(notas.toList())
        }
    }

    // 9. adicionarVariasNotas -> adicione 3 notas para a disciplina que você acabou de criar
    adicionarVariasNotas("Topicos", 7.0, 8.0, 6.0)

    // 10. mostrarNotas -> mostre as notas da disciplina que você acabou de criar;
    mostrarNotas("Topicos")

    // Bônus: (Não vai ganhar nada, ou melhor mais ganhar mais conhecimento >:O)

    // 11: calcularMedia -> Implemente a função calcularMedia()
    fun calcularMedia(notas: List<Double>): Double {
        return if (notas.isNotEmpty()) {
            notas.sum() / notas.size
        } else {
            0.0
        }
    }

    // 12: calcularMedia -> calcule a media de 2 disciplinas
    val notasPDM = materiasENotas["PDM"]
    val notasPWEB2 = materiasENotas["PWEB2"]

    if (notasPDM != null && notasPWEB2 != null) {
        val mediaPDM = calcularMedia(notasPDM)
        val mediaPWEB2 = calcularMedia(notasPWEB2)

        println("Média de Programação para Dispositivos Móveis: $mediaPDM")
        println("Média de Programação para Web II: $mediaPWEB2")
    } else {
        println("Não foi possível calcular a média. Verifique se as disciplinas existem.")
    }
}

// 13: mostrarNotas -> altere o mostrarNotas() para que ele mostre também a media das disciplinas

// 14: mostrarNotas -> mostre as notas de 1 disciplina

