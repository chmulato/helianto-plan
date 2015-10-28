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
 * Definie resoluções para disposições.
 * 
 * @author Mauricio Fernandes de Castro
 */
public enum DispositionResolution {
	
	/** Néo iniciada */
	IDLE('I'),
	/** Em anélise */
	TODO('T'),
	/** Usar */
	USE('1'),
	/** Retrabalho */
	REWORK('2'),
	/** Rejeição */
	SCRAP('3'),
	/** Improcedente */
	UNFOUNDED('U');
	
	private DispositionResolution(char value) {
		this.value = value;
	}
	
	private char value;
	
	public char getValue() {
		return this.value;
	}

}
