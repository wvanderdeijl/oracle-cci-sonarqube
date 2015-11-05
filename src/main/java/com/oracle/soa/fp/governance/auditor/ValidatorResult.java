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

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Header">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="SourceDirectory" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="SourceDirectoryMask" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="DisplayLabel" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="AssertionCatalog" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="PoliciesFile" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Policy" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="DateTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="PolicyResult" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="AssertionResult" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="Result" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="ExecutionDetails">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;choice maxOccurs="unbounded" minOccurs="0">
 *                                       &lt;element name="Composite">
 *                                         &lt;complexType>
 *                                           &lt;complexContent>
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                               &lt;sequence>
 *                                                 &lt;element name="Execution" maxOccurs="unbounded" minOccurs="0">
 *                                                   &lt;complexType>
 *                                                     &lt;complexContent>
 *                                                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                                         &lt;sequence>
 *                                                           &lt;element name="ArtifactLocation">
 *                                                             &lt;complexType>
 *                                                               &lt;simpleContent>
 *                                                                 &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                                                   &lt;attribute name="line" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                                                                   &lt;attribute name="col" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                                                                 &lt;/extension>
 *                                                               &lt;/simpleContent>
 *                                                             &lt;/complexType>
 *                                                           &lt;/element>
 *                                                           &lt;element name="ActualMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="ExpectedMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                           &lt;element name="Stack" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                                         &lt;/sequence>
 *                                                         &lt;attribute name="status" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                                                       &lt;/restriction>
 *                                                     &lt;/complexContent>
 *                                                   &lt;/complexType>
 *                                                 &lt;/element>
 *                                               &lt;/sequence>
 *                                               &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                               &lt;attribute name="success" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                                               &lt;attribute name="failed" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                                             &lt;/restriction>
 *                                           &lt;/complexContent>
 *                                         &lt;/complexType>
 *                                       &lt;/element>
 *                                       &lt;element name="Stack" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                     &lt;/choice>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                           &lt;attribute name="priority" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="category" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="failed" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                           &lt;attribute name="total" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                           &lt;attribute name="success" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="LinkedTestSuites" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Depends" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="total" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                 &lt;attribute name="failed" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                 &lt;attribute name="success" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                 &lt;attribute name="notExecuted" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "header", "policyResult" })
@XmlRootElement(name = "ValidatorResult")
public class ValidatorResult {

    @XmlElement(name = "Header", required = true)
    protected ValidatorResult.Header header;
    @XmlElement(name = "PolicyResult")
    protected List<ValidatorResult.PolicyResult> policyResult;

    /**
     * Gets the value of the header property.
     *
     * @return
     *     possible object is
     *     {@link ValidatorResult.Header }
     *
     */
    public ValidatorResult.Header getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     *
     * @param value
     *     allowed object is
     *     {@link ValidatorResult.Header }
     *
     */
    public void setHeader(ValidatorResult.Header value) {
        this.header = value;
    }

    /**
     * Gets the value of the policyResult property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the policyResult property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPolicyResult().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ValidatorResult.PolicyResult }
     *
     *
     */
    public List<ValidatorResult.PolicyResult> getPolicyResult() {
        if (policyResult == null) {
            policyResult = new ArrayList<ValidatorResult.PolicyResult>();
        }
        return this.policyResult;
    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="SourceDirectory" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="SourceDirectoryMask" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="DisplayLabel" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="AssertionCatalog" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="PoliciesFile" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Policy" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="DateTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Version" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "",
             propOrder = { "sourceDirectory", "sourceDirectoryMask", "displayLabel", "assertionCatalog", "policiesFile",
                           "policy", "dateTime", "version" })
    public static class Header {

        @XmlElement(name = "SourceDirectory", required = true)
        protected String sourceDirectory;
        @XmlElement(name = "SourceDirectoryMask", required = true)
        protected String sourceDirectoryMask;
        @XmlElement(name = "DisplayLabel", required = true)
        protected String displayLabel;
        @XmlElement(name = "AssertionCatalog", required = true)
        protected String assertionCatalog;
        @XmlElement(name = "PoliciesFile", required = true)
        protected String policiesFile;
        @XmlElement(name = "Policy", required = true)
        protected String policy;
        @XmlElement(name = "DateTime", required = true)
        protected String dateTime;
        @XmlElement(name = "Version", required = true)
        protected String version;

        /**
         * Gets the value of the sourceDirectory property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getSourceDirectory() {
            return sourceDirectory;
        }

        /**
         * Sets the value of the sourceDirectory property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setSourceDirectory(String value) {
            this.sourceDirectory = value;
        }

        /**
         * Gets the value of the sourceDirectoryMask property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getSourceDirectoryMask() {
            return sourceDirectoryMask;
        }

        /**
         * Sets the value of the sourceDirectoryMask property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setSourceDirectoryMask(String value) {
            this.sourceDirectoryMask = value;
        }

        /**
         * Gets the value of the displayLabel property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getDisplayLabel() {
            return displayLabel;
        }

        /**
         * Sets the value of the displayLabel property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setDisplayLabel(String value) {
            this.displayLabel = value;
        }

        /**
         * Gets the value of the assertionCatalog property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getAssertionCatalog() {
            return assertionCatalog;
        }

        /**
         * Sets the value of the assertionCatalog property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setAssertionCatalog(String value) {
            this.assertionCatalog = value;
        }

        /**
         * Gets the value of the policiesFile property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getPoliciesFile() {
            return policiesFile;
        }

        /**
         * Sets the value of the policiesFile property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setPoliciesFile(String value) {
            this.policiesFile = value;
        }

        /**
         * Gets the value of the policy property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getPolicy() {
            return policy;
        }

        /**
         * Sets the value of the policy property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setPolicy(String value) {
            this.policy = value;
        }

        /**
         * Gets the value of the dateTime property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getDateTime() {
            return dateTime;
        }

        /**
         * Sets the value of the dateTime property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setDateTime(String value) {
            this.dateTime = value;
        }

        /**
         * Gets the value of the version property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getVersion() {
            return version;
        }

        /**
         * Sets the value of the version property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setVersion(String value) {
            this.version = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="AssertionResult" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="Result" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="ExecutionDetails">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;choice maxOccurs="unbounded" minOccurs="0">
     *                             &lt;element name="Composite">
     *                               &lt;complexType>
     *                                 &lt;complexContent>
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                     &lt;sequence>
     *                                       &lt;element name="Execution" maxOccurs="unbounded" minOccurs="0">
     *                                         &lt;complexType>
     *                                           &lt;complexContent>
     *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                                               &lt;sequence>
     *                                                 &lt;element name="ArtifactLocation">
     *                                                   &lt;complexType>
     *                                                     &lt;simpleContent>
     *                                                       &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                                                         &lt;attribute name="line" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                                                         &lt;attribute name="col" type="{http://www.w3.org/2001/XMLSchema}short" />
     *                                                       &lt;/extension>
     *                                                     &lt;/simpleContent>
     *                                                   &lt;/complexType>
     *                                                 &lt;/element>
     *                                                 &lt;element name="ActualMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                 &lt;element name="ExpectedMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                                 &lt;element name="Stack" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                                               &lt;/sequence>
     *                                               &lt;attribute name="status" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                                             &lt;/restriction>
     *                                           &lt;/complexContent>
     *                                         &lt;/complexType>
     *                                       &lt;/element>
     *                                     &lt;/sequence>
     *                                     &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                                     &lt;attribute name="success" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                                     &lt;attribute name="failed" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                                   &lt;/restriction>
     *                                 &lt;/complexContent>
     *                               &lt;/complexType>
     *                             &lt;/element>
     *                             &lt;element name="Stack" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                           &lt;/choice>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *                 &lt;attribute name="priority" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="category" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="failed" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                 &lt;attribute name="total" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                 &lt;attribute name="success" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="LinkedTestSuites" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Depends" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="total" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *       &lt;attribute name="failed" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *       &lt;attribute name="success" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *       &lt;attribute name="notExecuted" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = { "assertionResult", "linkedTestSuites" })
    public static class PolicyResult {

        @XmlElement(name = "AssertionResult")
        protected List<ValidatorResult.PolicyResult.AssertionResult> assertionResult;
        @XmlElement(name = "LinkedTestSuites")
        protected ValidatorResult.PolicyResult.LinkedTestSuites linkedTestSuites;
        @XmlAttribute
        protected String name;
        @XmlAttribute
        protected Byte total;
        @XmlAttribute
        protected Byte failed;
        @XmlAttribute
        protected Byte success;
        @XmlAttribute
        protected Byte notExecuted;

        /**
         * Gets the value of the assertionResult property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the assertionResult property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAssertionResult().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ValidatorResult.PolicyResult.AssertionResult }
         *
         *
         */
        public List<ValidatorResult.PolicyResult.AssertionResult> getAssertionResult() {
            if (assertionResult == null) {
                assertionResult = new ArrayList<ValidatorResult.PolicyResult.AssertionResult>();
            }
            return this.assertionResult;
        }

        /**
         * Gets the value of the linkedTestSuites property.
         *
         * @return
         *     possible object is
         *     {@link ValidatorResult.PolicyResult.LinkedTestSuites }
         *
         */
        public ValidatorResult.PolicyResult.LinkedTestSuites getLinkedTestSuites() {
            return linkedTestSuites;
        }

        /**
         * Sets the value of the linkedTestSuites property.
         *
         * @param value
         *     allowed object is
         *     {@link ValidatorResult.PolicyResult.LinkedTestSuites }
         *
         */
        public void setLinkedTestSuites(ValidatorResult.PolicyResult.LinkedTestSuites value) {
            this.linkedTestSuites = value;
        }

        /**
         * Gets the value of the name property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setName(String value) {
            this.name = value;
        }

        /**
         * Gets the value of the total property.
         *
         * @return
         *     possible object is
         *     {@link Byte }
         *
         */
        public Byte getTotal() {
            return total;
        }

        /**
         * Sets the value of the total property.
         *
         * @param value
         *     allowed object is
         *     {@link Byte }
         *
         */
        public void setTotal(Byte value) {
            this.total = value;
        }

        /**
         * Gets the value of the failed property.
         *
         * @return
         *     possible object is
         *     {@link Byte }
         *
         */
        public Byte getFailed() {
            return failed;
        }

        /**
         * Sets the value of the failed property.
         *
         * @param value
         *     allowed object is
         *     {@link Byte }
         *
         */
        public void setFailed(Byte value) {
            this.failed = value;
        }

        /**
         * Gets the value of the success property.
         *
         * @return
         *     possible object is
         *     {@link Byte }
         *
         */
        public Byte getSuccess() {
            return success;
        }

        /**
         * Sets the value of the success property.
         *
         * @param value
         *     allowed object is
         *     {@link Byte }
         *
         */
        public void setSuccess(Byte value) {
            this.success = value;
        }

        /**
         * Gets the value of the notExecuted property.
         *
         * @return
         *     possible object is
         *     {@link Byte }
         *
         */
        public Byte getNotExecuted() {
            return notExecuted;
        }

        /**
         * Sets the value of the notExecuted property.
         *
         * @param value
         *     allowed object is
         *     {@link Byte }
         *
         */
        public void setNotExecuted(Byte value) {
            this.notExecuted = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         *
         * <p>The following schema fragment specifies the expected content contained within this class.
         *
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="Result" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="ExecutionDetails">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;choice maxOccurs="unbounded" minOccurs="0">
         *                   &lt;element name="Composite">
         *                     &lt;complexType>
         *                       &lt;complexContent>
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                           &lt;sequence>
         *                             &lt;element name="Execution" maxOccurs="unbounded" minOccurs="0">
         *                               &lt;complexType>
         *                                 &lt;complexContent>
         *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                                     &lt;sequence>
         *                                       &lt;element name="ArtifactLocation">
         *                                         &lt;complexType>
         *                                           &lt;simpleContent>
         *                                             &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                                               &lt;attribute name="line" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *                                               &lt;attribute name="col" type="{http://www.w3.org/2001/XMLSchema}short" />
         *                                             &lt;/extension>
         *                                           &lt;/simpleContent>
         *                                         &lt;/complexType>
         *                                       &lt;/element>
         *                                       &lt;element name="ActualMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                       &lt;element name="ExpectedMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                       &lt;element name="Stack" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                                     &lt;/sequence>
         *                                     &lt;attribute name="status" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *                                   &lt;/restriction>
         *                                 &lt;/complexContent>
         *                               &lt;/complexType>
         *                             &lt;/element>
         *                           &lt;/sequence>
         *                           &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                           &lt;attribute name="success" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *                           &lt;attribute name="failed" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *                         &lt;/restriction>
         *                       &lt;/complexContent>
         *                     &lt;/complexType>
         *                   &lt;/element>
         *                   &lt;element name="Stack" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                 &lt;/choice>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *       &lt;attribute name="priority" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="category" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="failed" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *       &lt;attribute name="total" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *       &lt;attribute name="success" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = { "message", "result", "executionDetails" })
        public static class AssertionResult {

            @XmlElement(name = "Message", required = true)
            protected String message;
            @XmlElement(name = "Result", required = true)
            protected String result;
            @XmlElement(name = "ExecutionDetails", required = true)
            protected ValidatorResult.PolicyResult.AssertionResult.ExecutionDetails executionDetails;
            @XmlAttribute
            protected Byte priority;
            @XmlAttribute
            protected String name;
            @XmlAttribute
            protected String category;
            @XmlAttribute
            protected Byte failed;
            @XmlAttribute
            protected Byte total;
            @XmlAttribute
            protected Byte success;

            /**
             * Gets the value of the message property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getMessage() {
                return message;
            }

            /**
             * Sets the value of the message property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setMessage(String value) {
                this.message = value;
            }

            /**
             * Gets the value of the result property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getResult() {
                return result;
            }

            /**
             * Sets the value of the result property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setResult(String value) {
                this.result = value;
            }

            /**
             * Gets the value of the executionDetails property.
             *
             * @return
             *     possible object is
             *     {@link ValidatorResult.PolicyResult.AssertionResult.ExecutionDetails }
             *
             */
            public ValidatorResult.PolicyResult.AssertionResult.ExecutionDetails getExecutionDetails() {
                return executionDetails;
            }

            /**
             * Sets the value of the executionDetails property.
             *
             * @param value
             *     allowed object is
             *     {@link ValidatorResult.PolicyResult.AssertionResult.ExecutionDetails }
             *
             */
            public void setExecutionDetails(ValidatorResult.PolicyResult.AssertionResult.ExecutionDetails value) {
                this.executionDetails = value;
            }

            /**
             * Gets the value of the priority property.
             *
             * @return
             *     possible object is
             *     {@link Byte }
             *
             */
            public Byte getPriority() {
                return priority;
            }

            /**
             * Sets the value of the priority property.
             *
             * @param value
             *     allowed object is
             *     {@link Byte }
             *
             */
            public void setPriority(Byte value) {
                this.priority = value;
            }

            /**
             * Gets the value of the name property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Gets the value of the category property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getCategory() {
                return category;
            }

            /**
             * Sets the value of the category property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setCategory(String value) {
                this.category = value;
            }

            /**
             * Gets the value of the failed property.
             *
             * @return
             *     possible object is
             *     {@link Byte }
             *
             */
            public Byte getFailed() {
                return failed;
            }

            /**
             * Sets the value of the failed property.
             *
             * @param value
             *     allowed object is
             *     {@link Byte }
             *
             */
            public void setFailed(Byte value) {
                this.failed = value;
            }

            /**
             * Gets the value of the total property.
             *
             * @return
             *     possible object is
             *     {@link Byte }
             *
             */
            public Byte getTotal() {
                return total;
            }

            /**
             * Sets the value of the total property.
             *
             * @param value
             *     allowed object is
             *     {@link Byte }
             *
             */
            public void setTotal(Byte value) {
                this.total = value;
            }

            /**
             * Gets the value of the success property.
             *
             * @return
             *     possible object is
             *     {@link Byte }
             *
             */
            public Byte getSuccess() {
                return success;
            }

            /**
             * Sets the value of the success property.
             *
             * @param value
             *     allowed object is
             *     {@link Byte }
             *
             */
            public void setSuccess(Byte value) {
                this.success = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             *
             * <p>The following schema fragment specifies the expected content contained within this class.
             *
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;choice maxOccurs="unbounded" minOccurs="0">
             *         &lt;element name="Composite">
             *           &lt;complexType>
             *             &lt;complexContent>
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                 &lt;sequence>
             *                   &lt;element name="Execution" maxOccurs="unbounded" minOccurs="0">
             *                     &lt;complexType>
             *                       &lt;complexContent>
             *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *                           &lt;sequence>
             *                             &lt;element name="ArtifactLocation">
             *                               &lt;complexType>
             *                                 &lt;simpleContent>
             *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *                                     &lt;attribute name="line" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *                                     &lt;attribute name="col" type="{http://www.w3.org/2001/XMLSchema}short" />
             *                                   &lt;/extension>
             *                                 &lt;/simpleContent>
             *                               &lt;/complexType>
             *                             &lt;/element>
             *                             &lt;element name="ActualMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                             &lt;element name="ExpectedMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                             &lt;element name="Stack" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *                           &lt;/sequence>
             *                           &lt;attribute name="status" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *                         &lt;/restriction>
             *                       &lt;/complexContent>
             *                     &lt;/complexType>
             *                   &lt;/element>
             *                 &lt;/sequence>
             *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" />
             *                 &lt;attribute name="success" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *                 &lt;attribute name="failed" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *               &lt;/restriction>
             *             &lt;/complexContent>
             *           &lt;/complexType>
             *         &lt;/element>
             *         &lt;element name="Stack" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *       &lt;/choice>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             *
             *
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = { "compositeOrStack" })
            public static class ExecutionDetails {

                @XmlElements( { @XmlElement(name = "Stack", type = String.class),
                                @XmlElement(name = "Composite", type =
                                            ValidatorResult.PolicyResult.AssertionResult.ExecutionDetails.Composite.class) })
                protected List<Object> compositeOrStack;

                /**
                 * Gets the value of the compositeOrStack property.
                 *
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the compositeOrStack property.
                 *
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getCompositeOrStack().add(newItem);
                 * </pre>
                 *
                 *
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link String }
                 * {@link ValidatorResult.PolicyResult.AssertionResult.ExecutionDetails.Composite }
                 *
                 *
                 */
                public List<Object> getCompositeOrStack() {
                    if (compositeOrStack == null) {
                        compositeOrStack = new ArrayList<Object>();
                    }
                    return this.compositeOrStack;
                }


                /**
                 * <p>Java class for anonymous complex type.
                 *
                 * <p>The following schema fragment specifies the expected content contained within this class.
                 *
                 * <pre>
                 * &lt;complexType>
                 *   &lt;complexContent>
                 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *       &lt;sequence>
                 *         &lt;element name="Execution" maxOccurs="unbounded" minOccurs="0">
                 *           &lt;complexType>
                 *             &lt;complexContent>
                 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                 *                 &lt;sequence>
                 *                   &lt;element name="ArtifactLocation">
                 *                     &lt;complexType>
                 *                       &lt;simpleContent>
                 *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
                 *                           &lt;attribute name="line" type="{http://www.w3.org/2001/XMLSchema}byte" />
                 *                           &lt;attribute name="col" type="{http://www.w3.org/2001/XMLSchema}short" />
                 *                         &lt;/extension>
                 *                       &lt;/simpleContent>
                 *                     &lt;/complexType>
                 *                   &lt;/element>
                 *                   &lt;element name="ActualMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                   &lt;element name="ExpectedMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                   &lt;element name="Stack" type="{http://www.w3.org/2001/XMLSchema}string"/>
                 *                 &lt;/sequence>
                 *                 &lt;attribute name="status" type="{http://www.w3.org/2001/XMLSchema}byte" />
                 *               &lt;/restriction>
                 *             &lt;/complexContent>
                 *           &lt;/complexType>
                 *         &lt;/element>
                 *       &lt;/sequence>
                 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" />
                 *       &lt;attribute name="success" type="{http://www.w3.org/2001/XMLSchema}byte" />
                 *       &lt;attribute name="failed" type="{http://www.w3.org/2001/XMLSchema}byte" />
                 *     &lt;/restriction>
                 *   &lt;/complexContent>
                 * &lt;/complexType>
                 * </pre>
                 *
                 *
                 */
                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "", propOrder = { "execution" })
                public static class Composite {

                    @XmlElement(name = "Execution")
                    protected List<ValidatorResult.PolicyResult.AssertionResult.ExecutionDetails.Composite.Execution> execution;
                    @XmlAttribute
                    protected String name;
                    @XmlAttribute
                    protected String version;
                    @XmlAttribute
                    protected Byte success;
                    @XmlAttribute
                    protected Byte failed;

                    /**
                     * Gets the value of the execution property.
                     *
                     * <p>
                     * This accessor method returns a reference to the live list,
                     * not a snapshot. Therefore any modification you make to the
                     * returned list will be present inside the JAXB object.
                     * This is why there is not a <CODE>set</CODE> method for the execution property.
                     *
                     * <p>
                     * For example, to add a new item, do as follows:
                     * <pre>
                     *    getExecution().add(newItem);
                     * </pre>
                     *
                     *
                     * <p>
                     * Objects of the following type(s) are allowed in the list
                     * {@link ValidatorResult.PolicyResult.AssertionResult.ExecutionDetails.Composite.Execution }
                     *
                     *
                     */
                    public List<ValidatorResult.PolicyResult.AssertionResult.ExecutionDetails.Composite.Execution> getExecution() {
                        if (execution == null) {
                            execution =
                                    new ArrayList<ValidatorResult.PolicyResult.AssertionResult.ExecutionDetails.Composite.Execution>();
                        }
                        return this.execution;
                    }

                    /**
                     * Gets the value of the name property.
                     *
                     * @return
                     *     possible object is
                     *     {@link String }
                     *
                     */
                    public String getName() {
                        return name;
                    }

                    /**
                     * Sets the value of the name property.
                     *
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *
                     */
                    public void setName(String value) {
                        this.name = value;
                    }

                    /**
                     * Gets the value of the version property.
                     *
                     * @return
                     *     possible object is
                     *     {@link String }
                     *
                     */
                    public String getVersion() {
                        return version;
                    }

                    /**
                     * Sets the value of the version property.
                     *
                     * @param value
                     *     allowed object is
                     *     {@link String }
                     *
                     */
                    public void setVersion(String value) {
                        this.version = value;
                    }

                    /**
                     * Gets the value of the success property.
                     *
                     * @return
                     *     possible object is
                     *     {@link Byte }
                     *
                     */
                    public Byte getSuccess() {
                        return success;
                    }

                    /**
                     * Sets the value of the success property.
                     *
                     * @param value
                     *     allowed object is
                     *     {@link Byte }
                     *
                     */
                    public void setSuccess(Byte value) {
                        this.success = value;
                    }

                    /**
                     * Gets the value of the failed property.
                     *
                     * @return
                     *     possible object is
                     *     {@link Byte }
                     *
                     */
                    public Byte getFailed() {
                        return failed;
                    }

                    /**
                     * Sets the value of the failed property.
                     *
                     * @param value
                     *     allowed object is
                     *     {@link Byte }
                     *
                     */
                    public void setFailed(Byte value) {
                        this.failed = value;
                    }


                    /**
                     * <p>Java class for anonymous complex type.
                     *
                     * <p>The following schema fragment specifies the expected content contained within this class.
                     *
                     * <pre>
                     * &lt;complexType>
                     *   &lt;complexContent>
                     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
                     *       &lt;sequence>
                     *         &lt;element name="ArtifactLocation">
                     *           &lt;complexType>
                     *             &lt;simpleContent>
                     *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
                     *                 &lt;attribute name="line" type="{http://www.w3.org/2001/XMLSchema}byte" />
                     *                 &lt;attribute name="col" type="{http://www.w3.org/2001/XMLSchema}short" />
                     *               &lt;/extension>
                     *             &lt;/simpleContent>
                     *           &lt;/complexType>
                     *         &lt;/element>
                     *         &lt;element name="ActualMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *         &lt;element name="ExpectedMessage" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *         &lt;element name="Stack" type="{http://www.w3.org/2001/XMLSchema}string"/>
                     *       &lt;/sequence>
                     *       &lt;attribute name="status" type="{http://www.w3.org/2001/XMLSchema}byte" />
                     *     &lt;/restriction>
                     *   &lt;/complexContent>
                     * &lt;/complexType>
                     * </pre>
                     *
                     *
                     */
                    @XmlAccessorType(XmlAccessType.FIELD)
                    @XmlType(name = "",
                             propOrder = { "artifactLocation", "actualMessage", "expectedMessage", "stack" })
                    public static class Execution {

                        @XmlElement(name = "ArtifactLocation", required = true)
                        protected ValidatorResult.PolicyResult.AssertionResult.ExecutionDetails.Composite.Execution.ArtifactLocation artifactLocation;
                        @XmlElement(name = "ActualMessage", required = true)
                        protected String actualMessage;
                        @XmlElement(name = "ExpectedMessage", required = true)
                        protected String expectedMessage;
                        @XmlElement(name = "Stack", required = true)
                        protected String stack;
                        @XmlAttribute
                        protected Byte status;

                        /**
                         * Gets the value of the artifactLocation property.
                         *
                         * @return
                         *     possible object is
                         *     {@link ValidatorResult.PolicyResult.AssertionResult.ExecutionDetails.Composite.Execution.ArtifactLocation }
                         *
                         */
                        public ValidatorResult.PolicyResult.AssertionResult.ExecutionDetails.Composite.Execution.ArtifactLocation getArtifactLocation() {
                            return artifactLocation;
                        }

                        /**
                         * Sets the value of the artifactLocation property.
                         *
                         * @param value
                         *     allowed object is
                         *     {@link ValidatorResult.PolicyResult.AssertionResult.ExecutionDetails.Composite.Execution.ArtifactLocation }
                         *
                         */
                        public void setArtifactLocation(ValidatorResult.PolicyResult.AssertionResult.ExecutionDetails.Composite.Execution.ArtifactLocation value) {
                            this.artifactLocation = value;
                        }

                        /**
                         * Gets the value of the actualMessage property.
                         *
                         * @return
                         *     possible object is
                         *     {@link String }
                         *
                         */
                        public String getActualMessage() {
                            return actualMessage;
                        }

                        /**
                         * Sets the value of the actualMessage property.
                         *
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *
                         */
                        public void setActualMessage(String value) {
                            this.actualMessage = value;
                        }

                        /**
                         * Gets the value of the expectedMessage property.
                         *
                         * @return
                         *     possible object is
                         *     {@link String }
                         *
                         */
                        public String getExpectedMessage() {
                            return expectedMessage;
                        }

                        /**
                         * Sets the value of the expectedMessage property.
                         *
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *
                         */
                        public void setExpectedMessage(String value) {
                            this.expectedMessage = value;
                        }

                        /**
                         * Gets the value of the stack property.
                         *
                         * @return
                         *     possible object is
                         *     {@link String }
                         *
                         */
                        public String getStack() {
                            return stack;
                        }

                        /**
                         * Sets the value of the stack property.
                         *
                         * @param value
                         *     allowed object is
                         *     {@link String }
                         *
                         */
                        public void setStack(String value) {
                            this.stack = value;
                        }

                        /**
                         * Gets the value of the status property.
                         *
                         * @return
                         *     possible object is
                         *     {@link Byte }
                         *
                         */
                        public Byte getStatus() {
                            return status;
                        }

                        /**
                         * Sets the value of the status property.
                         *
                         * @param value
                         *     allowed object is
                         *     {@link Byte }
                         *
                         */
                        public void setStatus(Byte value) {
                            this.status = value;
                        }


                        /**
                         * <p>Java class for anonymous complex type.
                         *
                         * <p>The following schema fragment specifies the expected content contained within this class.
                         *
                         * <pre>
                         * &lt;complexType>
                         *   &lt;simpleContent>
                         *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
                         *       &lt;attribute name="line" type="{http://www.w3.org/2001/XMLSchema}byte" />
                         *       &lt;attribute name="col" type="{http://www.w3.org/2001/XMLSchema}short" />
                         *     &lt;/extension>
                         *   &lt;/simpleContent>
                         * &lt;/complexType>
                         * </pre>
                         *
                         *
                         */
                        @XmlAccessorType(XmlAccessType.FIELD)
                        @XmlType(name = "", propOrder = { "value" })
                        public static class ArtifactLocation {

                            @XmlValue
                            protected String value;
                            @XmlAttribute
                            protected Byte line;
                            @XmlAttribute
                            protected Short col;

                            /**
                             * Gets the value of the value property.
                             *
                             * @return
                             *     possible object is
                             *     {@link String }
                             *
                             */
                            public String getValue() {
                                return value;
                            }

                            /**
                             * Sets the value of the value property.
                             *
                             * @param value
                             *     allowed object is
                             *     {@link String }
                             *
                             */
                            public void setValue(String value) {
                                this.value = value;
                            }

                            /**
                             * Gets the value of the line property.
                             *
                             * @return
                             *     possible object is
                             *     {@link Byte }
                             *
                             */
                            public Byte getLine() {
                                return line;
                            }

                            /**
                             * Sets the value of the line property.
                             *
                             * @param value
                             *     allowed object is
                             *     {@link Byte }
                             *
                             */
                            public void setLine(Byte value) {
                                this.line = value;
                            }

                            /**
                             * Gets the value of the col property.
                             *
                             * @return
                             *     possible object is
                             *     {@link Short }
                             *
                             */
                            public Short getCol() {
                                return col;
                            }

                            /**
                             * Sets the value of the col property.
                             *
                             * @param value
                             *     allowed object is
                             *     {@link Short }
                             *
                             */
                            public void setCol(Short value) {
                                this.col = value;
                            }

                        }

                    }

                }

            }

        }


        /**
         * <p>Java class for anonymous complex type.
         *
         * <p>The following schema fragment specifies the expected content contained within this class.
         *
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="Depends" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = { "depends" })
        public static class LinkedTestSuites {

            @XmlElement(name = "Depends")
            protected List<String> depends;

            /**
             * Gets the value of the depends property.
             *
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the depends property.
             *
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getDepends().add(newItem);
             * </pre>
             *
             *
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             *
             *
             */
            public List<String> getDepends() {
                if (depends == null) {
                    depends = new ArrayList<String>();
                }
                return this.depends;
            }

        }

    }

}
