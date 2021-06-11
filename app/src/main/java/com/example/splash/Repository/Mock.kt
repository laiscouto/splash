package com.example.splash.Repository

import com.example.splash.Infra.MotivationConstantes
import java.util.*

data class Phrase(val description: String, val category: Int)

class Mock {
    private val ALL = MotivationConstantes.PHRASESFILTER.ALL
    private val SUN = MotivationConstantes.PHRASESFILTER.SUN
    private val DAY = MotivationConstantes.PHRASESFILTER.DAY

    private val mListPhrases: List<Phrase> = listOf(
            Phrase("Um novo dia nasce no horizonte, e com ele, uma nova oportunidade de perder novamente..", DAY),
            Phrase("Você não é derrotado quando perde, você é derrotado em qualquer momento, Bom dia!", DAY),
            Phrase("BOM DIA, Que este dia seja repleto de derrotas.", DAY),
            Phrase("VOCÊ é capaz de TUDO! Até de acreditar nisso.", DAY),
            Phrase(" Sentindo que o mundo não está do seu lado? Você está certo.", DAY),
            Phrase("Um dia você vai parar, olhar para trás, se lembrar de tudo isso que " +
                    "passou e só um pensamento estará em sua mente: Realmente, pior do que está, fica.", DAY),
            Phrase("Você nasceu para sonhar. Conquistar, já é outra história", SUN),
            Phrase("Você não nasceu para ganhar.", SUN),
            Phrase("Não deixe uma vitória te abalar.", SUN),
            Phrase(" Quer um conselho? Nem tente.", SUN)
    )
    fun getPhrases(categoryId: Int): String{
        var filtered = mListPhrases.filter{(it.category == categoryId || categoryId== ALL)}
        val rand = Random().nextInt(filtered.size)
        return filtered[rand].description
    }
}