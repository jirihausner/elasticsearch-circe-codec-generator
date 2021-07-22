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

package org.elasticsearch.circecodecs.cluster._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._indices._types.AliasDefinition.{ AliasDefinition }
import org.elasticsearch.circecodecs._indices._types.IndexSettings.{ IndexSettings }
import org.elasticsearch.circecodecs._spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs._types.common.{ IndexName, Metadata, Name, VersionNumber }
import org.elasticsearch.circecodecs._types.mapping.TypeMapping.{ TypeMapping }

@JsonCodec case class ComponentTemplate(
	name: Name, 
	component_template: ComponentTemplateNode
)

@JsonCodec case class ComponentTemplateNode(
	template: ComponentTemplateSummary, 
	version: VersionNumber, 
	_meta: Metadata
)

@JsonCodec case class ComponentTemplateSummary(
	_meta: Metadata, 
	version: VersionNumber, 
	settings: Dictionary[IndexName, IndexSettings], 
	mappings: TypeMapping, 
	aliases: Dictionary[String, AliasDefinition]
)
