package com.converted.elasticsearch._global.field_caps

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ Indices }

@JsonCodec case class FieldCapability(
	aggregatable: Boolean, 
	indices: Indices, 
	meta: Dictionary(String, Array(String)), 
	non_aggregatable_indices: Indices, 
	non_searchable_indices: Indices, 
	searchable: Boolean, 
	`type`: String
)
