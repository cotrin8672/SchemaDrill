package io.github.cotrin8672.schemadrill.domain

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
