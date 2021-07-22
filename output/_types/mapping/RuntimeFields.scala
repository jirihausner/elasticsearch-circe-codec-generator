package com.converted.elasticsearch._types.mapping

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ Field }
import com.converted.elasticsearch._types.Scripting.{ Script }
type RuntimeFields = Dictionary(Field, RuntimeField)

@JsonCodec case class RuntimeField(
	format: String, 
	script: Script, 
	`type`: RuntimeFieldType
)

object RuntimeFieldType extends Enumeration {
	type RuntimeFieldType = Value

	val boolean = Value(0, "boolean")
	val date = Value(1, "date")
	val double = Value(2, "double")
	val geo_point = Value(3, "geo_point")
	val ip = Value(4, "ip")
	val keyword = Value(5, "keyword")
	val long = Value(6, "long")
}

implicit val runtimeFieldTypeDecoder: Decoder[RuntimeFieldType.Value] = Decoder.decodeEnumeration(RuntimeFieldType)
implicit val runtimeFieldTypeEncoder: Encoder[RuntimeFieldType.Value] = Decoder.encodeEnumeration(RuntimeFieldType)
