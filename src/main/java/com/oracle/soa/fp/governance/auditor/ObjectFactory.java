/*
 * Sonar CCI Plugin
 * Copyright (C) 2015 Whitehorses
 * dev@sonar.codehaus.org
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package com.oracle.soa.fp.governance.auditor;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.oracle.soa.fp.governance.auditor package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.oracle.soa.fp.governance.auditor
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ValidatorResult }
     *
     */
    public ValidatorResult createValidatorResult() {
        return new ValidatorResult();
    }

    /**
     * Create an instance of {@link ValidatorResult.PolicyResult }
     *
     */
    public ValidatorResult.PolicyResult createValidatorResultPolicyResult() {
        return new ValidatorResult.PolicyResult();
    }

    /**
     * Create an instance of {@link ValidatorResult.PolicyResult.AssertionResult }
     *
     */
    public ValidatorResult.PolicyResult.AssertionResult createValidatorResultPolicyResultAssertionResult() {
        return new ValidatorResult.PolicyResult.AssertionResult();
    }

    /**
     * Create an instance of {@link ValidatorResult.PolicyResult.AssertionResult.ExecutionDetails }
     *
     */
    public ValidatorResult.PolicyResult.AssertionResult.ExecutionDetails createValidatorResultPolicyResultAssertionResultExecutionDetails() {
        return new ValidatorResult.PolicyResult.AssertionResult.ExecutionDetails();
    }

    /**
     * Create an instance of {@link ValidatorResult.PolicyResult.AssertionResult.ExecutionDetails.Composite }
     *
     */
    public ValidatorResult.PolicyResult.AssertionResult.ExecutionDetails.Composite createValidatorResultPolicyResultAssertionResultExecutionDetailsComposite() {
        return new ValidatorResult.PolicyResult.AssertionResult.ExecutionDetails.Composite();
    }

    /**
     * Create an instance of {@link ValidatorResult.PolicyResult.AssertionResult.ExecutionDetails.Composite.Execution }
     *
     */
    public ValidatorResult.PolicyResult.AssertionResult.ExecutionDetails.Composite.Execution createValidatorResultPolicyResultAssertionResultExecutionDetailsCompositeExecution() {
        return new ValidatorResult.PolicyResult.AssertionResult.ExecutionDetails.Composite.Execution();
    }

    /**
     * Create an instance of {@link ValidatorResult.Header }
     *
     */
    public ValidatorResult.Header createValidatorResultHeader() {
        return new ValidatorResult.Header();
    }

    /**
     * Create an instance of {@link ValidatorResult.PolicyResult.LinkedTestSuites }
     *
     */
    public ValidatorResult.PolicyResult.LinkedTestSuites createValidatorResultPolicyResultLinkedTestSuites() {
        return new ValidatorResult.PolicyResult.LinkedTestSuites();
    }

    /**
     * Create an instance of {@link ValidatorResult.PolicyResult.AssertionResult.ExecutionDetails.Composite.Execution.ArtifactLocation }
     *
     */
    public ValidatorResult.PolicyResult.AssertionResult.ExecutionDetails.Composite.Execution.ArtifactLocation createValidatorResultPolicyResultAssertionResultExecutionDetailsCompositeExecutionArtifactLocation() {
        return new ValidatorResult.PolicyResult.AssertionResult.ExecutionDetails.Composite.Execution.ArtifactLocation();
    }

}
