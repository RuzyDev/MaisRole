package br.com.arcom.telemetria.data.enums

enum class Months(val descricao: String,
                             val valor: String) {
    /**
     * 1
     */
    JANEIRO("Janeiro", "01"),

    /**
     * 2
     */
    FEVEREIRO("Fevereiro", "02"),

    /**
     * 3
     */
    MARCO("Março", "03"),

    /**
     * 4
     */
    ABRIL("Abril", "04"),

    /**
     * 5
     */
    MAIO("Maio", "05"),


    /**
     * 6
     */
    JUNHO("Junho", "06"),

    /**
     * 7
     */
    JULHO("Julho", "07"),

    /**
     * 8
     */
    AGOSTO("Agosto", "08"),

    /**
     * 9
     */
    SETEMBRO("Setembro", "09"),

    /**
     * 10
     */
    OUTUBRO("Outubro", "10"),
    /**
     * 11
     */
    NOVEMBRO("Novembro", "11"),

    /**
     * 12
     */
    DEZEMBRO("Dezembro", "12");

    companion object {
        fun from(s: String): Months? = values().find { it.descricao == s }
    }

}
