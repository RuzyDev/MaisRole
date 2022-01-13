package br.com.arcom.telemetria.data.enums

enum class TipoConfirmacao(val descricao: String,
                           val valor: Short) {
    /**
     * 1
     */
    SMS_TOKEN("SMS Token", 1),

    /**
     * 2
     */
    SENHA_DO_DIA("Senha do Dia", 2);


    companion object {
        fun from(s: String): TipoConfirmacao? = values().find { it.descricao == s }
    }

}
