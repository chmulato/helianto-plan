/* Copyright 2005 I Serv Consultoria Empresarial Ltda.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.helianto.task.def;

/**
 * Identifica como um intervalo de datas é avaliado.
 * 
 * @author Mauricio Fernandes de Castro
 */
public enum RangeType {
	
	/** Usar intervalo completo a partir das datas */
	DATES('D', false, false),
	/** Usar intervalo completo em dias */
	RANGE('R', false, false),
	/** Ignorar inécio em dias */
	RANGE_IGNORE_START('S', true, false),
	/** Ignorar término em dias */
	RANGE_IGNORE_END('E', false, true);
	
	private RangeType(char value, boolean startIgnored, boolean endIgnored) {
		this.value = value;
	}
	
	private char value;
	private boolean startIgnored;
	private boolean endIgnored;
	
	public char getValue() {
		return this.value;
	}

	public boolean isStartIgnored() {
		return startIgnored;
	}

	public boolean isEndIgnored() {
		return endIgnored;
	}

}
