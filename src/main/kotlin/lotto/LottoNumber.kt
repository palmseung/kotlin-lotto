package lotto

data class LottoNumber(val number: Int) {
    init {
        require(number in MIN..MAX) { "${number}는 로또 번호가 될 수 없습니다." }
    }

    constructor(input: String): this(input.toInt())

    companion object {
        private const val MIN = 1
        private const val MAX = 45
    }
}
