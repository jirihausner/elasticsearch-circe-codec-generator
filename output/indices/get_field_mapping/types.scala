package com.converted.elasticsearch.indices.get_field_mapping

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ Field }
import com.converted.elasticsearch._types.mapping.meta-fields.{ FieldMapping }

@JsonCodec case class TypeFieldMappings(
	mappings: Dictionary[Field, FieldMapping]
)
