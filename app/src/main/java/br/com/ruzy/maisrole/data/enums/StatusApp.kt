package br.com.arcom.telemetria.data.enums

enum class StatusApp(val descricao: String,
                     val valor: Short) {
    /**
     * 1
     */
    INSTALAR("Instalar", 1),

    /**
     * 2
     */
    ATUALIZAR("Atualizar", 2),

    /**
     * 3
     */
    NAO_INSTALAR("Não Instalar", 3);


    companion object {
        fun from(s: String): StatusApp? = values().find { it.descricao == s }
    }

}
