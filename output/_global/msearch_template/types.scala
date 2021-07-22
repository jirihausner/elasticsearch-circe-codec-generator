package com.converted.elasticsearch._global.msearch_template

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.common.{ Id, Indices }

@JsonCodec case class TemplateItem(
	id: Id, 
	index: Indices, 
	params: Dictionary(String, UserDefinedValue), 
	source: String
)
