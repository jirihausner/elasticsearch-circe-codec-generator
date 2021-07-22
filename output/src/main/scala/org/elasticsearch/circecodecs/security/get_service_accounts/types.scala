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

package org.elasticsearch.circecodecs.security.get_service_accounts

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._security._types.ApplicationPrivileges.{ ApplicationPrivileges }
import org.elasticsearch.circecodecs._security._types.GlobalPrivileges.{ GlobalPrivileges }
import org.elasticsearch.circecodecs._security._types.IndicesPrivileges.{ IndicesPrivileges }
import org.elasticsearch.circecodecs._spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs._spec_utils.UserDefinedValue.{ UserDefinedValue }
import org.elasticsearch.circecodecs._types.common.{ Metadata }

@JsonCodec case class RoleDescriptorWrapper(
	role_descriptor: RoleDescriptor
)

@JsonCodec case class RoleDescriptor(
	cluster: Seq[String], 
	indices: Seq[IndicesPrivileges], 
	global: Seq[GlobalPrivileges], 
	applications: Seq[ApplicationPrivileges], 
	metadata: Metadata, 
	run_as: Seq[String], 
	transient_metadata: Dictionary[String, UserDefinedValue]
)
