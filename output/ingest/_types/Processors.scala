package com.converted.elasticsearch.ingest._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._global.search._types.sort.{ SortOrder }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.common.{ Field, Fields, Id, Name }
import com.converted.elasticsearch._types.Geo.{ GeoShapeRelation }
import com.converted.elasticsearch._types.Numeric.{ double, integer, long }
import com.converted.elasticsearch._types.Scripting.{ Script }

@JsonCodec case class ProcessorContainer(
	attachment: AttachmentProcessor, 
	append: AppendProcessor, 
	csv: CsvProcessor, 
	convert: ConvertProcessor, 
	date: DateProcessor, 
	date_index_name: DateIndexNameProcessor, 
	dot_expander: DotExpanderProcessor, 
	enrich: EnrichProcessor, 
	fail: FailProcessor, 
	foreach: ForeachProcessor, 
	json: JsonProcessor, 
	user_agent: UserAgentProcessor, 
	kv: KeyValueProcessor, 
	geoip: GeoIpProcessor, 
	grok: GrokProcessor, 
	gsub: GsubProcessor, 
	join: JoinProcessor, 
	lowercase: LowercaseProcessor, 
	remove: RemoveProcessor, 
	rename: RenameProcessor, 
	script: Script, 
	set: SetProcessor, 
	sort: SortProcessor, 
	split: SplitProcessor, 
	trim: TrimProcessor, 
	uppercase: UppercaseProcessor, 
	urldecode: UrlDecodeProcessor, 
	bytes: BytesProcessor, 
	dissect: DissectProcessor, 
	set_security_user: SetSecurityUserProcessor, 
	pipeline: PipelineProcessor, 
	drop: DropProcessor, 
	circle: CircleProcessor, 
	inference: InferenceProcessor
)


@JsonCodec case class ProcessorBase(
	`if`: String, 
	ignore_failure: Boolean, 
	on_failure: Array(ProcessorContainer), 
	tag: String
)


object UserAgentProperty extends Enumeration {
	type UserAgentProperty = Value

val nAME = Value(0, "NAME")
val mAJOR = Value(1, "MAJOR")
val mINOR = Value(2, "MINOR")
val pATCH = Value(3, "PATCH")
val oS = Value(4, "OS")
val oS_NAME = Value(5, "OS_NAME")
val oS_MAJOR = Value(6, "OS_MAJOR")
val oS_MINOR = Value(7, "OS_MINOR")
val dEVICE = Value(8, "DEVICE")
val bUILD = Value(9, "BUILD")
}

implicit val userAgentPropertyDecoder: Decoder[UserAgentProperty.Value] = Decoder.decodeEnumeration(UserAgentProperty)
implicit val userAgentPropertyEncoder: Encoder[UserAgentProperty.Value] = Decoder.encodeEnumeration(UserAgentProperty)


@JsonCodec case class AppendProcessor(
	field: Field, 
	value: Array(UserDefinedValue), 
	allow_duplicates: Boolean
) extends ProcessorBase


@JsonCodec case class AttachmentProcessor(
	field: Field, 
	ignore_missing: Boolean, 
	indexed_chars: long, 
	indexed_chars_field: Field, 
	properties: Array(String), 
	target_field: Field, 
	resource_name: String
) extends ProcessorBase


@JsonCodec case class GeoIpProcessor(
	database_file: String, 
	field: Field, 
	first_only: Boolean, 
	ignore_missing: Boolean, 
	properties: Array(String), 
	target_field: Field
) extends ProcessorBase


@JsonCodec case class UserAgentProcessor(
	field: Field, 
	ignore_missing: Boolean, 
	options: Array(UserAgentProperty), 
	regex_file: String, 
	target_field: Field
) extends ProcessorBase


@JsonCodec case class BytesProcessor(
	field: Field, 
	ignore_missing: Boolean, 
	target_field: Field
) extends ProcessorBase


@JsonCodec case class CircleProcessor(
	error_distance: double, 
	field: Field, 
	ignore_missing: Boolean, 
	shape_type: ShapeType, 
	target_field: Field
) extends ProcessorBase


object ConvertType extends Enumeration {
	type ConvertType = Value

val integer = Value(0, "integer")
val long = Value(1, "long")
val float = Value(2, "float")
val double = Value(3, "double")
val string = Value(4, "string")
val boolean = Value(5, "boolean")
val auto = Value(6, "auto")
}

implicit val convertTypeDecoder: Decoder[ConvertType.Value] = Decoder.decodeEnumeration(ConvertType)
implicit val convertTypeEncoder: Encoder[ConvertType.Value] = Decoder.encodeEnumeration(ConvertType)


@JsonCodec case class ConvertProcessor(
	field: Field, 
	ignore_missing: Boolean, 
	target_field: Field, 
	`type`: ConvertType
) extends ProcessorBase


@JsonCodec case class CsvProcessor(
	empty_value: UserDefinedValue, 
	description: String, 
	field: Field, 
	ignore_missing: Boolean, 
	quote: String, 
	separator: String, 
	target_fields: Fields, 
	trim: Boolean
) extends ProcessorBase


object DateRounding extends Enumeration {
	type DateRounding = Value

val s = Value(0, "s")
val m = Value(1, "m")
val h = Value(2, "h")
val d = Value(3, "d")
val w = Value(4, "w")
val m = Value(5, "M")
val y = Value(6, "y")
}

implicit val dateRoundingDecoder: Decoder[DateRounding.Value] = Decoder.decodeEnumeration(DateRounding)
implicit val dateRoundingEncoder: Encoder[DateRounding.Value] = Decoder.encodeEnumeration(DateRounding)


@JsonCodec case class DateIndexNameProcessor(
	date_formats: Array(String), 
	date_rounding: String | DateRounding, 
	field: Field, 
	index_name_format: String, 
	index_name_prefix: String, 
	locale: String, 
	timezone: String
) extends ProcessorBase


@JsonCodec case class DateProcessor(
	field: Field, 
	formats: Array(String), 
	locale: String, 
	target_field: Field, 
	timezone: String
) extends ProcessorBase


@JsonCodec case class DissectProcessor(
	append_separator: String, 
	field: Field, 
	ignore_missing: Boolean, 
	pattern: String
) extends ProcessorBase


@JsonCodec case class DotExpanderProcessor(
	field: Field, 
	path: String
) extends ProcessorBase


@JsonCodec case class DropProcessor extends ProcessorBase


@JsonCodec case class EnrichProcessor(
	field: Field, 
	ignore_missing: Boolean, 
	max_matches: integer, 
	`override`: Boolean, 
	policy_name: String, 
	shape_relation: GeoShapeRelation, 
	target_field: Field
) extends ProcessorBase


@JsonCodec case class FailProcessor(
	message: String
) extends ProcessorBase


@JsonCodec case class ForeachProcessor(
	field: Field, 
	ignore_missing: Boolean, 
	processor: ProcessorContainer
) extends ProcessorBase


@JsonCodec case class GrokProcessor(
	field: Field, 
	ignore_missing: Boolean, 
	pattern_definitions: Dictionary(String, String), 
	patterns: Array(String), 
	trace_match: Boolean
) extends ProcessorBase


@JsonCodec case class GsubProcessor(
	field: Field, 
	ignore_missing: Boolean, 
	pattern: String, 
	replacement: String, 
	target_field: Field
) extends ProcessorBase


@JsonCodec case class InferenceProcessor(
	model_id: Id, 
	target_field: Field, 
	field_map: Dictionary(Field, UserDefinedValue), 
	inference_config: InferenceConfig
) extends ProcessorBase


@JsonCodec case class InferenceConfig(
	regression: InferenceConfigRegression
)


@JsonCodec case class InferenceConfigRegression(
	results_field: String
)


@JsonCodec case class JoinProcessor(
	field: Field, 
	separator: String, 
	target_field: Field
) extends ProcessorBase


@JsonCodec case class JsonProcessor(
	add_to_root: Boolean, 
	field: Field, 
	target_field: Field
) extends ProcessorBase


@JsonCodec case class KeyValueProcessor(
	exclude_keys: Array(String), 
	field: Field, 
	field_split: String, 
	ignore_missing: Boolean, 
	include_keys: Array(String), 
	prefix: String, 
	strip_brackets: Boolean, 
	target_field: Field, 
	trim_key: String, 
	trim_value: String, 
	value_split: String
) extends ProcessorBase


@JsonCodec case class LowercaseProcessor(
	field: Field, 
	ignore_missing: Boolean, 
	target_field: Field
) extends ProcessorBase


@JsonCodec case class PipelineProcessor(
	name: Name
) extends ProcessorBase


@JsonCodec case class RemoveProcessor(
	field: Fields, 
	ignore_missing: Boolean
) extends ProcessorBase


@JsonCodec case class RenameProcessor(
	field: Field, 
	ignore_missing: Boolean, 
	target_field: Field
) extends ProcessorBase


@JsonCodec case class ScriptProcessor(
	id: Id, 
	lang: String, 
	params: Dictionary(String, UserDefinedValue), 
	source: String
) extends ProcessorBase


@JsonCodec case class SetProcessor(
	field: Field, 
	`override`: Boolean, 
	value: UserDefinedValue
) extends ProcessorBase


@JsonCodec case class SetSecurityUserProcessor(
	field: Field, 
	properties: Array(String)
) extends ProcessorBase


object ShapeType extends Enumeration {
	type ShapeType = Value

val geo_shape = Value(0, "geo_shape")
val shape = Value(1, "shape")
}

implicit val shapeTypeDecoder: Decoder[ShapeType.Value] = Decoder.decodeEnumeration(ShapeType)
implicit val shapeTypeEncoder: Encoder[ShapeType.Value] = Decoder.encodeEnumeration(ShapeType)


@JsonCodec case class SortProcessor(
	field: Field, 
	order: SortOrder, 
	target_field: Field
) extends ProcessorBase


@JsonCodec case class SplitProcessor(
	field: Field, 
	ignore_missing: Boolean, 
	preserve_trailing: Boolean, 
	separator: String, 
	target_field: Field
) extends ProcessorBase


@JsonCodec case class TrimProcessor(
	field: Field, 
	ignore_missing: Boolean, 
	target_field: Field
) extends ProcessorBase


@JsonCodec case class UppercaseProcessor(
	field: Field, 
	ignore_missing: Boolean, 
	target_field: Field
) extends ProcessorBase


@JsonCodec case class UrlDecodeProcessor(
	field: Field, 
	ignore_missing: Boolean, 
	target_field: Field
) extends ProcessorBase

