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
    CONJUNCTION,  //　接続詞
}

sealed interface Morpheme

data object Comma : Morpheme
data object Period : Morpheme
data object Colon : Morpheme

data class PrototypeWord(
    val text: String,
    val pos: PoS,
    val meaning: String,
) : Morpheme

data class VerbWord(
    val prototypeWord: PrototypeWord,
    val form: VerbForm,
) : Morpheme {
    enum class VerbForm {
        PAST_TENSE,
        PAST_PARTICIPLE,
        PRESENT_PARTICIPLE,
    }

    val hasIrregularConjugation: Boolean
        get() = true

    val text: String
        get() = if (form == VerbForm.PRESENT_PARTICIPLE) {
            "${prototypeWord.text}ing"
        } else {
            if (hasIrregularConjugation) {
                "getConjugationFromDatabase"
            } else {
                "${prototypeWord.text}ed"
            }
        }
}

data class Sentence(
    val morphemes: List<Morpheme>,
    val meaning: String,
)
