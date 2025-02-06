package io.github.cotrin8672.schemadrill.domain

enum class PoS {
    NOUN,         // 名詞
    PRONOUN,      // 代名詞
    VERB,         // 動詞
    ADJECTIVE,    // 形容詞
    ADVERB,       // 副詞
    AUXILIARY,    // 助動詞
    PREPOSITION,  // 前置詞
    ARTICLE,      // 冠詞
    INTERJECTION, // 間投詞
    CONJUNCTION,  // 接続詞
    NUMERAL,      // 数詞
}

data class Word(
    val lemma: String,
    val pos: PoS,
    val meaning: String,
)

sealed interface Token {
    val displayedText: String
}

data class WordToken(
    val word: Word,
    override val displayedText: String,
) : Token

sealed class SymbolToken(override val displayedText: String) : Token {
    data object Comma : SymbolToken(",")
    data object Period : SymbolToken(".")
    data object Colon : SymbolToken(":")
    data object Semicolon : SymbolToken(";")
    data object Exclamation : SymbolToken("!")
    data object Question : SymbolToken("?")
}

data class Sentence(
    val tokens: List<Token>,
    val meaning: String,
) {
    override fun toString(): String {
        return tokens.joinToString("") { it.displayedText }
    }
}
