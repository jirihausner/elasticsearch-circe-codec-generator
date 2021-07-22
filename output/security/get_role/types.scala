package com.converted.elasticsearch.security.get_role

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._security._types.ApplicationPrivileges.{ ApplicationPrivileges }
import com.converted.elasticsearch._security._types.IndicesPrivileges.{ IndicesPrivileges }
import com.converted.elasticsearch._types.common.{ Metadata }

@JsonCodec case class Role(
	cluster: Array(String), 
	indices: Array(IndicesPrivileges), 
	metadata: Metadata, 
	run_as: Array(String), 
	transient_metadata: TransientMetadata, 
	applications: Array(ApplicationPrivileges), 
	role_templates: Array(RoleTemplate)
)


@JsonCodec case class TransientMetadata(
	enabled: Boolean
)


object TemplateFormat extends Enumeration {
	type TemplateFormat = Value

val string = Value(0, "string")
val json = Value(1, "json")
}

implicit val templateFormatDecoder: Decoder[TemplateFormat.Value] = Decoder.decodeEnumeration(TemplateFormat)
implicit val templateFormatEncoder: Encoder[TemplateFormat.Value] = Decoder.encodeEnumeration(TemplateFormat)


@JsonCodec case class InlineRoleTemplate(
	template: InlineRoleTemplateSource, 
	format: TemplateFormat
)


@JsonCodec case class InlineRoleTemplateSource(
	source: String
)


@JsonCodec case class StoredRoleTemplate(
	template: StoredRoleTemplateId, 
	format: TemplateFormat
)


@JsonCodec case class StoredRoleTemplateId(
	id: String
)


@JsonCodec case class InvalidRoleTemplate(
	template: String, 
	format: TemplateFormat
)

type RoleTemplate = InlineRoleTemplate | StoredRoleTemplate | InvalidRoleTemplate
