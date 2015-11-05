<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:aud="http://www.oracle.com/soa/fp/governance/auditor">
  <!-- Root template -->
  <xsl:template match="/">
  <rules>
   <xsl:for-each select="//aud:Assertion">
      <rule>
    <key>com.oracle.cci.<xsl:value-of select="@name"/></key>
    <xsl:choose>
      <xsl:when test="@priority = 1">
        <severity>BLOCKER</severity>    
      </xsl:when>
      <xsl:when test="@priority = 2">
        <severity>CRITICAL</severity>    
      </xsl:when>
      <xsl:when test="@priority = 3">
        <severity>MAJOR</severity>    
      </xsl:when>
      <xsl:when test="@priority = 4">
        <severity>MINOR</severity>    
      </xsl:when>
      <xsl:when test="@priority = 5">
        <severity>INFO</severity>    
      </xsl:when>
    </xsl:choose>
    <name><xsl:value-of select="@name"/></name>
    <internalKey><xsl:value-of select="@name"/></internalKey>
    <description><xsl:value-of select="@description"/></description>
    <status>READY</status>
  </rule>
  </xsl:for-each>
  </rules>
  </xsl:template>
  </xsl:stylesheet>