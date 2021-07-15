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
/*
 * This file hosts `behaviors`. We use this interfaces that are marked with a `@behavior` JS Doc annotation
 * to signal complicated mappings to the compiler -> canonical json -> client generators.
 *
 * These are problem sets that need a custom client solution.
 */

import { Names } from '@_types/common'
import { Time } from '@_types/Time'

/**
 * In some places in the specification an object consists of the union of a set of known properties
 * and a set of runtime injected properties. Meaning that object should theoretically extend Dictionary but expose
 * a set of known keys and possibly. The object might already be part of an object graph and have a parent class.
 * This puts it into a bind that needs a client specific solution.
 * We therefore document the requirement to behave like a dictionary for unknown properties with this interface.
 * @behavior Defines a trait that any unknown property for the class should be typed to TValue
 */
export interface AdditionalProperties<TKey, TValue> {}

/**
 * Implements a set of common query parameters all API's support.
 * Since these can break the request structure these are listed explicitly as a behavior.
 * Its up to individual clients to define support although `error_trace` and `pretty` are
 * recommended as a minimum.
 * @behavior Defines a common set of query parameters all API's support that alter the overall response.
 */
export interface CommonQueryParameters {
  error_trace?: boolean
  filter_path?: string | string[]
  human?: boolean
  pretty?: boolean
  source_query_string?: string
}

/**
 * Implements a set of common query parameters all Cat API's support.
 * Since these can break the request structure these are listed explicitly as a behavior.
 * @behavior Defines a common set of query parameters all Cat API's support that alter the overall response.
 */
export interface CommonCatQueryParameters {
  format?: string
  h?: Names
  help?: boolean
  local?: boolean
  master_timeout?: Time
  s?: string[]
  v?: boolean
}
