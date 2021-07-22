package com.converted.elasticsearch._types.mapping

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ Metadata, PropertyName }
import com.converted.elasticsearch._types.mapping.{ DynamicMapping, DynamicTemplate }
import com.converted.elasticsearch._types.mapping.{ AllField, FieldNamesField, IndexField, RoutingField, SizeField, SourceField }
import com.converted.elasticsearch._types.mapping.{ Property }
import com.converted.elasticsearch._types.mapping.{ RuntimeField }

@JsonCodec case class TypeMapping(
	all_field: AllField, 
	date_detection: Boolean, 
	dynamic: Boolean | DynamicMapping, 
	dynamic_date_formats: Seq[String], 
	dynamic_templates: Dictionary[String, DynamicTemplate] | Seq[Dictionary[String, DynamicTemplate]], 
	_field_names: FieldNamesField, 
	index_field: IndexField, 
	_meta: Metadata, 
	numeric_detection: Boolean, 
	properties: Dictionary[PropertyName, Property], 
	_routing: RoutingField, 
	_size: SizeField, 
	_source: SourceField, 
	runtime: Dictionary[String, RuntimeField]
)
