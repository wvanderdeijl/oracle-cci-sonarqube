<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:aud="http://www.oracle.com/soa/fp/governance/auditor">
  <!-- Root template -->
  <xsl:template match="/">
  <profile>
  <name>Sonar way</name>
  <language>cci</language>
  <rules>
   <xsl:for-each select="//aud:Assertion">
      <rule>
       <repositoryKey>grvy</repositoryKey>
       <key>com.oracle.cci.<xsl:value-of select="@name"/></key>
    <xsl:choose>
      <xsl:when test="@priority = 1">
        <priority>BLOCKER</priority>    
      </xsl:when>
      <xsl:when test="@priority = 2">
        <priority>CRITICAL</priority>    
      </xsl:when>
      <xsl:when test="@priority = 3">
        <priority>MAJOR</priority>    
      </xsl:when>
      <xsl:when test="@priority = 4">
        <priority>MINOR</priority>    
      </xsl:when>
      <xsl:when test="@priority = 5">
        <priority>INFO</priority>    
      </xsl:when>
    </xsl:choose>
  </rule>
  </xsl:for-each>
  </rules>
  </profile>
  </xsl:template>
  </xsl:stylesheet>