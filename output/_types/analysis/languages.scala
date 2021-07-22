package com.converted.elasticsearch._types.analysis

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


object Language extends Enumeration {
	type Language = Value

	val arabic = Value(0, "Arabic")
	val armenian = Value(1, "Armenian")
	val basque = Value(2, "Basque")
	val brazilian = Value(3, "Brazilian")
	val bulgarian = Value(4, "Bulgarian")
	val catalan = Value(5, "Catalan")
	val chinese = Value(6, "Chinese")
	val cjk = Value(7, "Cjk")
	val czech = Value(8, "Czech")
	val danish = Value(9, "Danish")
	val dutch = Value(10, "Dutch")
	val english = Value(11, "English")
	val estonian = Value(12, "Estonian")
	val finnish = Value(13, "Finnish")
	val french = Value(14, "French")
	val galician = Value(15, "Galician")
	val german = Value(16, "German")
	val greek = Value(17, "Greek")
	val hindi = Value(18, "Hindi")
	val hungarian = Value(19, "Hungarian")
	val indonesian = Value(20, "Indonesian")
	val irish = Value(21, "Irish")
	val italian = Value(22, "Italian")
	val latvian = Value(23, "Latvian")
	val norwegian = Value(24, "Norwegian")
	val persian = Value(25, "Persian")
	val portuguese = Value(26, "Portuguese")
	val romanian = Value(27, "Romanian")
	val russian = Value(28, "Russian")
	val sorani = Value(29, "Sorani")
	val spanish = Value(30, "Spanish")
	val swedish = Value(31, "Swedish")
	val turkish = Value(32, "Turkish")
	val thai = Value(33, "Thai")
}

implicit val languageDecoder: Decoder[Language.Value] = Decoder.decodeEnumeration(Language)
implicit val languageEncoder: Encoder[Language.Value] = Decoder.encodeEnumeration(Language)

object SnowballLanguage extends Enumeration {
	type SnowballLanguage = Value

	val armenian = Value(0, "Armenian")
	val basque = Value(1, "Basque")
	val catalan = Value(2, "Catalan")
	val danish = Value(3, "Danish")
	val dutch = Value(4, "Dutch")
	val english = Value(5, "English")
	val finnish = Value(6, "Finnish")
	val french = Value(7, "French")
	val german = Value(8, "German")
	val german2 = Value(9, "German2")
	val hungarian = Value(10, "Hungarian")
	val italian = Value(11, "Italian")
	val kp = Value(12, "Kp")
	val lovins = Value(13, "Lovins")
	val norwegian = Value(14, "Norwegian")
	val porter = Value(15, "Porter")
	val portuguese = Value(16, "Portuguese")
	val romanian = Value(17, "Romanian")
	val russian = Value(18, "Russian")
	val spanish = Value(19, "Spanish")
	val swedish = Value(20, "Swedish")
	val turkish = Value(21, "Turkish")
}

implicit val snowballLanguageDecoder: Decoder[SnowballLanguage.Value] = Decoder.decodeEnumeration(SnowballLanguage)
implicit val snowballLanguageEncoder: Encoder[SnowballLanguage.Value] = Decoder.encodeEnumeration(SnowballLanguage)
