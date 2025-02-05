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

sealed interface Word {
    val text: String
    val pos: PoS
    val meaning: String
}

data class Noun(
    override val text: String,
    override val meaning: String,
) : Word {
    override val pos: PoS = PoS.NOUN
}

data class Verb(
    override val text: String,
    override val meaning: String,
) : Word {
    override val pos: PoS = PoS.VERB
}

data class Adjective(
    override val text: String,
    override val meaning: String,
) : Word {
    override val pos: PoS = PoS.ADJECTIVE
}

data class Adverb(
    override val text: String,
    override val meaning: String,
) : Word {
    override val pos: PoS = PoS.ADVERB
}

sealed interface WordForm<T : Word> {
    sealed interface VerbForm : WordForm<Verb> {
        data object PastTense : VerbForm
        data object PastParticiple : VerbForm
        data object PresentParticiple : VerbForm
    }

    sealed interface NounForm : WordForm<Noun> {
        data object Plural : NounForm
    }

    sealed interface AdjectiveForm : WordForm<Adjective> {
        data object Comparative : AdjectiveForm
        data object Superlative : AdjectiveForm
    }

    sealed interface AdverbForm : WordForm<Adverb> {
        data object Comparative : AdverbForm
        data object Superlative : AdverbForm
    }
}

sealed interface Token {
    val displayedText: String
}

sealed interface WordToken : Token {
    val word: Word
}

data class SimpleWordToken(
    override val word: Word,
    override val displayedText: String,
) : WordToken

data class InflectionWordToken<T : Word>(
    override val word: T,
    val form: WordForm<T>,
    override val displayedText: String,
) : WordToken

enum class SymbolToken : Token {
    Comma {
        override val displayedText = ","
    },
    Period {
        override val displayedText = "."
    },
    Colon {
        override val displayedText = ":"
    },
    SEMICOLON {
        override val displayedText = ";"
    },
    EXCLAMATION {
        override val displayedText = "!"
    },
    QUESTION {
        override val displayedText = "?"
    },
}

data class Sentence(
    val tokens: List<Token>,
    val meaning: String,
) {
    override fun toString(): String {
        return tokens.joinToString("") { it.displayedText }
    }
}
