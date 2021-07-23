/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.circecodecs.security.get_role

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.security.types.ApplicationPrivileges.{ ApplicationPrivileges }
import org.elasticsearch.circecodecs.security.types.IndicesPrivileges.{ IndicesPrivileges }
import org.elasticsearch.circecodecs.types.common.{ Metadata }

@JsonCodec case class Role(
	cluster: Seq[String], 
	indices: Seq[IndicesPrivileges], 
	metadata: Metadata, 
	run_as: Seq[String], 
	transient_metadata: TransientMetadata, 
	applications: Seq[ApplicationPrivileges], 
	role_templates: Seq[RoleTemplate]
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
