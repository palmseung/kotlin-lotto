package lotto.model

data class Lotto(private val lottoNumbers: List<LottoNumber>) {
    init {
        require(isUniqueSixNumbers(lottoNumbers)) { "로또 번호는 서로 다른 6개의 숫자여야만 합니다." }
    }

    constructor(numbers: Collection<Int>) : this(numbers.map(::LottoNumber))

    constructor(stringNumbers: String) : this(splitByComma(stringNumbers))

    fun getWinningCount(winningNumbers: List<Int>): Int {
        return lottoNumbers.filter { winningNumbers.contains(it.number) }.count()
    }

    companion object {
        private const val LOTTO_SIZE = 6
        private const val COMMA = ","

        private fun isUniqueSixNumbers(lottoNumbers: List<LottoNumber>): Boolean {
            val size = lottoNumbers.sortedBy { it.number }.toSet().size
            return (size == LOTTO_SIZE)
        }

        private fun splitByComma(stringNumbers: String): List<Int> {
            return stringNumbers
                .split(COMMA)
                .map { it.trim().toInt() }
        }
    }
}
