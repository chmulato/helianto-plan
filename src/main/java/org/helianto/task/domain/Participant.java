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

package org.helianto.task.domain;

import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.helianto.core.domain.Identity;
import org.helianto.task.internal.AbstractParticipant;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * Participante de uma tarefa.
 * 
 * @author Mauricio Fernandes de Castro
 */
@javax.persistence.Entity
@Table(name="task_participant",
    uniqueConstraints = {@UniqueConstraint(columnNames={"taskId", "identityId"})}
)
public class Participant 
	extends AbstractParticipant {
	
    private static final long serialVersionUID = 1L;
    
    @JsonBackReference 
    @ManyToOne
    @JoinColumn(name="taskId", nullable=true)
    private Report report;
    
    @ManyToOne
    @JoinColumn(name="staffMemberId", nullable=true)
    private StaffMember staffMember;

    /** 
     * Default constructor.
     */
    public Participant() {
    	super();
    }

    /** 
     * Form constructor.
     * 
     * @param report
     */
    public Participant(Report report) {
    	this();
    	setReport(report);
    }

    /** 
     * Key constructor.
     * 
     * @param report
     * @param identity
     */
    public Participant(Report report, Identity identity) {
    	this(report);
    	setIdentity(identity);
    }

    /** 
     * Staff member constructor.
     * 
     * @param report
     * @param staffMember
     */
    public Participant(Report report, StaffMember staffMember) {
    	this(report, staffMember.getIdentity());
    	setStaffMember(staffMember);
    }

    /**
     * Relatório ao qual os participantes pertencem.
     */
    public Report getReport() {
        return this.report;
    }
    public void setReport(Report report) {
        this.report = report;
    }
    
    /**
     * Verdadeiro se o participante é o relator.
     */
//    @Transient
    public boolean isReporter() {
    	if (getReport()!=null && getReport().getReporter()!=null && getReport().getReporter().getId()==getIdentity().getId()) {
    		return true;
    	}
    	return false;
    }
    
    /**
     * Membro da equipe do qual o participante obtém suas propriedades.
     */
    public StaffMember getStaffMember() {
		return staffMember;
	}
    public void setStaffMember(StaffMember staffMember) {
		this.staffMember = staffMember;
	}
    
    /**
     * <<Transient>> Verdadeiro se hé um membro da equipe do qual o participante obtém suas propriedades.
     */
//    @Transient
    public boolean isStaffMemberAvailable() {
		return getStaffMember()!=null;
	}
    
    /**
     * <<Transient>> Mantém a identidade do participante igual a do membro da
     * equipe que o originou.
     */
//    @Transient
    protected Identity getInternalIdentity() {
    	if (isStaffMemberAvailable()) {
    		return getStaffMember().getIdentity();
    	}
    	return super.getInternalIdentity();
    }
    
    /**
     * <<Transient>> Mantém tipo de atribuição do participante igual a do membro da
     * equipe que o originou.
     */
//    @Transient
    protected char getInternalAssignmentType() {
    	if (isStaffMemberAvailable()) {
    		return getStaffMember().getAssignmentType();
    	}
    	return super.getInternalAssignmentType();
    }
    
    /**
     * <<Transient>> Mantém a data de atribuição do participante igual a do membro da
     * equipe que o originou.
     */
//    @Transient
    protected Date getInternalJoinDate() {
    	if (isStaffMemberAvailable()) {
    		return getStaffMember().getJoinDate();
    	}
    	return super.getInternalJoinDate();
    }
    
    /**
     * <<Transient>> Mantém o nível de workflow do participante igual a do membro da
     * equipe que o originou.
     */
//    @Transient
    protected int getInternalWorkflowLevel() {
    	if (isStaffMemberAvailable()) {
    		return getStaffMember().getWorkflowLevel();
    	}
    	return super.getInternalWorkflowLevel();
    }

   /**
    * equals
    */
   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
         if ( (other == null ) ) return false;
         if ( !(other instanceof Participant) ) return false;
         Participant castOther = (Participant) other; 
         
         return ((this.getReport()==castOther.getReport()) || ( this.getReport()!=null && castOther.getReport()!=null && this.getReport().equals(castOther.getReport()) ))
             && ((this.getIdentity()==castOther.getIdentity()) || ( this.getIdentity()!=null && castOther.getIdentity()!=null && this.getIdentity().equals(castOther.getIdentity()) ));
   }
   
   /**
    * hashCode
    */
   public int hashCode() {
         int result = 17;
         result = 37 * result + ( getReport() == null ? 0 : this.getReport().hashCode() );
         result = 37 * result + ( getIdentity() == null ? 0 : this.getIdentity().hashCode() );
         return result;
   }

}
