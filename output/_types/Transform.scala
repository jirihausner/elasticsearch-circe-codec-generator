package com.converted.elasticsearch._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._watcher._types.Input.{ SearchInputRequestDefinition }
import com.converted.elasticsearch._types.{ Time }

@JsonCodec sealed trait Transform

@JsonCodec case class TransformContainer(
	chain: ChainTransform, 
	script: ScriptTransform, 
	search: SearchTransform
)

@JsonCodec case class ChainTransform(
	transforms: Array[TransformContainer]
)

@JsonCodec case class ScriptTransform(
	lang: String, 
	params: Dictionary[String, UserDefinedValue]
)

@JsonCodec case class SearchTransform(
	request: SearchInputRequestDefinition, 
	timeout: Time
)
