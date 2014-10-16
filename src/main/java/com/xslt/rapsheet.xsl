<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
                xmlns:n="http://www.nlets.org/envelope"
                xmlns:r="http://www.nlets.org/formats/rapsheet"
                version="1.0">

<xsl:output indent="yes" />

<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->
<!--                              root                                 -->
<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->

<!--   This template controls formatting of the rap sheet by matching the
       document root.  The second tier of formatting is controlled by the
       /rapSheet template.
-->

<xsl:template match="/">
<HTML>

  <HEAD> 
    <TITLE>
      <xsl:variable name="subject"
                    select="/n:envelope/r:rapSheet/r:introduction/r:rapSheetRequest/r:fullName"/>
      <xsl:choose>
        <xsl:when test="$subject!=''">
           <xsl:text>Rap Sheet for </xsl:text>
           <xsl:value-of select="normalize-space($subject)"/>
        </xsl:when>
        <xsl:otherwise>Rap Sheet for Unnamed Subject</xsl:otherwise>
      </xsl:choose>
    </TITLE>
    <STYLE>
      BODY { background-color: white; color: black;
             font-size: 10pt; font-family: Arial, Helvetica, sans-serif; 
             vertical-align: baseline; }
      H1 { font-size: 2.0em; font-weight:bold; color: #000080; }
      H2 { font-size: 1.6em; font-weight:bold; color: #000080; }
      H3 { font-size: 1.3em; font-weight:normal; }
      H4 { font-size: 1.0em; font-weight:bold; }
      H5 { font-size: 0.9em; font-weight:bold; }
      P  { vertical-align: text-top; }
      TABLE { border: 0pt; }
      TD { vertical-align: text-top; }
    </STYLE>
  </HEAD>

  <BODY>
    <xsl:apply-templates select="/n:envelope/r:rapSheet"/>
  </BODY>

</HTML>

</xsl:template>


<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->
<!--                            rapSheet                               -->
<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->

<!--   This template controls second tier formatting of the rap sheet 
       by generating the top level headings and then calling next tier
       templates for format those sections.
-->

<xsl:template match="/n:envelope/r:rapSheet">

  <CENTER><H1>Criminal History Record</H1></CENTER>

  <H2><A NAME="introduction">Introduction</A></H2>
  <xsl:apply-templates select="r:introduction"/>

  <H2><A NAME="identification">Identification</A></H2>
  <xsl:apply-templates select="r:person"/>

  <BR/><H2><A NAME="history">Criminal History</A></H2>
  <xsl:call-template name="r:cycle"/>

  <BR/><H2><A NAME="index">Index of Agencies</A></H2>
  <xsl:apply-templates select="r:agencyIndex"/>

</xsl:template>


<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->
<!--                          navigation-bar                           -->
<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->

<!--   This template controls formatting of a navigation bar of hyperlinks
       to the various sections.  This allows easy switching from one part
       to another.
       This version is actually null and the real navigation bar is
       generated in the following template.
-->

<xsl:template name="navigation-bar">
</xsl:template>


<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->
<!--                          navigation-bar                           -->
<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->

<!--   This template controls formatting of a navigation bar of hyperlinks
       to the various sections.  This allows easy switching from one part
       to another.
-->

<xsl:template name="navigation-bar-for-real">
  <HR/>
  <TABLE BORDER="0" CELLPADDING="0" WIDTH="100%">
  <TR>
  <TD><A HREF="#introduction"><strong>Introduction</strong></A></TD>
  <TD><A HREF="#identification"><strong>Identification</strong></A></TD>
  <TD><A HREF="#history"><strong>Criminal History</strong></A></TD>
  <TD><A HREF="#index"><strong>Agencies</strong></A></TD>
  </TR>
  </TABLE>
  <HR/>
</xsl:template>


<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->
<!--                           introduction                            -->
<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->

<!--   This template controls formatting of information from the 
       introduction element.  It is called from the /r:rapSheet template.
-->

<xsl:template match="r:introduction">

  <xsl:for-each select="r:rapSheetRequest">
    <TABLE BORDER="0" WIDTH="100%">
      <xsl:if test="position()=1">
        <TR>
          <TD COLSPAN="2">
            <B>This rap sheet was produced in response to 
               the following request:
            </B>
          </TD>
        </TR>
      </xsl:if>

      <xsl:if test="position()>1">
        <TR>
          <TD><BR/><B>Additional Request:</B></TD>
        </TR>
      </xsl:if>

      <TR>
        <TD>Subject Name(s)</TD>
        <TD>
         <xsl:if test="count(./r:fullName)>0">
            <xsl:for-each select="./r:fullName">
              <DIV>
                <xsl:value-of select="normalize-space(.)"/>
              </DIV>
            </xsl:for-each>
          </xsl:if>
        </TD>
      </TR>

      <TR>
        <TD WIDTH="34%">FBI Number</TD>
        <TD WIDTH="66%">
          <xsl:if test="./r:fbiNumber!=''">
            <xsl:value-of select="normalize-space(./r:fbiNumber)"/>
          </xsl:if>
        </TD>
      </TR>

      <TR>
        <TD WIDTH="34%">State ID Number</TD>
        <TD WIDTH="66%">
	   <xsl:if test="./r:stateBureauIDNumber!=''">
            <xsl:value-of select="normalize-space(./r:stateBureauIDNumber)"/>
            <xsl:call-template name="format-attributes">
              <xsl:with-param name="node" select="./r:stateBureauIDNumber"/>
            </xsl:call-template>
	     </xsl:if>
        </TD>
      </TR>

      <TR>
        <TD>Social Security Number</TD>
        <TD>
          <xsl:if test="count(./r:ssn)>0">
            <xsl:for-each select="./r:ssn">
              <DIV><xsl:value-of select="normalize-space(.)"/></DIV>
            </xsl:for-each>
          </xsl:if>
        </TD>
      </TR>

      <TR>
        <TD>Driver&apos;s License Number</TD>
        <TD>
         <xsl:if test="count(./r:dlNumber)>0">
           <xsl:for-each select="./r:dlNumber">
             <DIV>
               <xsl:value-of select="normalize-space(.)"/>
               <xsl:call-template name="format-attributes"/>
             </DIV>
            </xsl:for-each>
          </xsl:if>
        </TD>
      </TR>

      <TR>
        <TD>Miscellaneous Number</TD>
        <TD>
          <xsl:if test="count(./r:personalIDNumber)>0">
            <xsl:for-each select="./r:personalIDNumber">
              <DIV>
              <xsl:value-of select="normalize-space(.)"/>
              <xsl:call-template name="format-attributes"/>
              </DIV>
            </xsl:for-each>
          </xsl:if>
        </TD>
      </TR>

      <TR>
        <TD>Request Id</TD>
          <TD>
            <xsl:if test="./@id!=''">
              <xsl:value-of select="./@id"/>
            </xsl:if>
          </TD>
      </TR>
      <TR>
        <TD>Purpose Code</TD>
        <TD>
          <xsl:if test="./r:purposeCode!=''">
            <xsl:value-of select="normalize-space(./r:purposeCode)"/>
	   </xsl:if>
        </TD>
      </TR>
      <TR>
        <TD>Attention</TD>
        <TD>
          <xsl:if test="./r:attention!=''">
            <xsl:value-of select="normalize-space(./r:attention)"/>
          </xsl:if>
        </TD>
      </TR>
    </TABLE>
  </xsl:for-each>

  <xsl:if test="count(r:caveat)>0">
    <BR/>
    <TABLE BORDER="0" WIDTH="100%">
      <TR>
        <TD><B>The information in this rap sheet is provided subject
        to the following caveats:</B></TD>
      </TR>
      <xsl:for-each select="r:caveat">
      <TR VALIGN="TOP">
        <TD WIDTH="100%">
          <xsl:value-of select="."/>
          <xsl:call-template name="format-attributes"/>
	   <xsl:if test="position() != last()"><BR/><BR/></xsl:if>
          <xsl:if test="position() = last()"><BR/></xsl:if>
        </TD>
      </TR>
      </xsl:for-each>
    </TABLE>
  </xsl:if>

  <xsl:call-template name="navigation-bar"/>

</xsl:template>


<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->
<!--                              person                               -->
<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->

<!--   This template controls formatting of information from the 
       person element.  It is called from the /r:rapSheet template.
-->

<xsl:template match="r:person">

  <H4>Subject Name(s)</H4>

  <B>
    <xsl:for-each select="r:personName">
      <xsl:sort select="concat(r:lastName, ',', r:firstName)"/>
      <DIV>
        <xsl:call-template name="format-personName"/>
      </DIV>
    </xsl:for-each>
  </B>

  <H4>Subject Description</H4>

  <TABLE BORDER="0" WIDTH="100%">
    <TR>
      <TD WIDTH="34%"><B>FBI Number</B></TD>
      <TD WIDTH="33%"><B>State Id Number</B></TD>
      <TD WIDTH="33%"><B>DOC Number</B></TD>
    </TR>
    <TR>
      <TD>
        <xsl:choose>
          <xsl:when test="count(r:personDescription/r:fbiNumber)>0">
            <xsl:for-each select="r:personDescription/r:fbiNumber">
              <DIV><xsl:value-of select="normalize-space(.)"/></DIV>
            </xsl:for-each>
          </xsl:when>
          <xsl:otherwise>
            <xsl:text>Unknown</xsl:text>
          </xsl:otherwise>
        </xsl:choose>
      </TD>
      <TD>
        <xsl:choose>
          <xsl:when test="count(r:personDescription/r:stateBureauIDNumber)>0">
            <xsl:for-each select="r:personDescription/r:stateBureauIDNumber">
              <DIV>
                <xsl:value-of select="normalize-space(.)"/>
                <xsl:call-template name="format-attributes"/>
              </DIV>
            </xsl:for-each>
          </xsl:when>
          <xsl:otherwise>
            <xsl:text>Unknown</xsl:text>
          </xsl:otherwise>
        </xsl:choose>
      </TD>
      <TD>
        <xsl:choose>
          <xsl:when test="count(r:personDescription/r:personalIDNumber[@type='CorrectionalID'])>0">
            <xsl:for-each select="r:personDescription/r:personalIDNumber[@type='CorrectionalID']">
              <DIV>
                <xsl:value-of select="normalize-space(.)"/>
                <xsl:call-template name="format-attributes-no-type"/>
              </DIV>
            </xsl:for-each>
          </xsl:when>
          <xsl:otherwise>
            <xsl:text>Unknown</xsl:text>
          </xsl:otherwise>
        </xsl:choose>
      </TD>
    </TR>
  </TABLE>

  <BR/>

  <TABLE BORDER="0" WIDTH="100%">
    <TR>
      <TD WIDTH="34%"><B>Social Security Number</B></TD>
      <TD WIDTH="33%"><B>Driver&apos;s License Number</B></TD>
      <TD WIDTH="33%"></TD>
    </TR>
    <TR>
      <TD>
        <xsl:choose>
          <xsl:when test="count(r:personDescription/r:ssn)>0">
            <xsl:for-each select="r:personDescription/r:ssn">
              <DIV><xsl:value-of select="normalize-space(.)"/></DIV>
            </xsl:for-each>
          </xsl:when>
          <xsl:otherwise>
            <xsl:text>Unknown</xsl:text>
          </xsl:otherwise>
        </xsl:choose>
      </TD>
      <TD>
        <xsl:choose>
          <xsl:when test="count(r:personDescription/r:dlNumber)>0">
            <xsl:for-each select="r:personDescription/r:dlNumber">
              <DIV>
                <xsl:value-of select="normalize-space(.)"/>
                <xsl:call-template name="format-attributes"/>
              </DIV>
            </xsl:for-each>
          </xsl:when>
          <xsl:otherwise>
            <xsl:text>Unknown</xsl:text>
          </xsl:otherwise>
        </xsl:choose>
      </TD>
      <TD></TD>
    </TR>
  </TABLE>

  <BR/>

  <TABLE BORDER="0" WIDTH="100%">
    <TR>
      <TD WIDTH="34%"><B>Miscellaneous Numbers</B></TD>
      <TD WIDTH="66%"></TD>
    </TR>
    <xsl:choose>
      <xsl:when test="count(r:personDescription/r:personalIDNumber[@type!='CorrectionalID'])>0">
        <TR>
          <TD><B>Number</B></TD>
          <TD><B>Type</B></TD>
        </TR>
        <xsl:for-each select="r:personDescription/r:personalIDNumber[@type!='CorrectionalID']">
          <TR>
            <TD>
              <xsl:value-of select="normalize-space(.)"/>
            </TD>
            <TD>
              <xsl:value-of select="normalize-space(@type)"/>
              <xsl:call-template name="format-attributes-no-type"/>
            </TD>
          </TR>
        </xsl:for-each>
      </xsl:when>
      <xsl:otherwise>
        <TR><TD COLSPAN="2">
          <xsl:text>Unknown</xsl:text>
        </TD></TR>
      </xsl:otherwise>
    </xsl:choose>
  </TABLE>

  <BR/>

  <TABLE BORDER="0" WIDTH="100%">
    <TR>
      <TD WIDTH="34%"><B>Sex</B></TD>
      <TD WIDTH="33%"><B>Race</B></TD>
      <TD WIDTH="33%"><B>Skin Tone</B></TD>
    </TR>
    <TR>
      <TD>
        <xsl:choose>
          <xsl:when test="count(r:personDescription/r:sex)>0">
            <xsl:for-each select="r:personDescription/r:sex">
              <DIV><xsl:value-of select="normalize-space(.)"/></DIV>
            </xsl:for-each>
          </xsl:when>
          <xsl:otherwise>
            <xsl:text>Unknown</xsl:text>
          </xsl:otherwise>
        </xsl:choose>
      </TD>
      <TD>
        <xsl:choose>
          <xsl:when test="count(r:personDescription/r:race)>0">
            <xsl:for-each select="r:personDescription/r:race">
              <DIV><xsl:value-of select="normalize-space(.)"/></DIV>
            </xsl:for-each>
          </xsl:when>
          <xsl:otherwise>
            <xsl:text>Unknown</xsl:text>
          </xsl:otherwise>
        </xsl:choose>
      </TD>
      <TD>
        <xsl:choose>
          <xsl:when test="count(r:personDescription/r:skinTone)>0">
            <xsl:for-each select="r:personDescription/r:skinTone">
              <DIV>
                <xsl:value-of select="normalize-space(.)"/>
              </DIV>
            </xsl:for-each>
          </xsl:when>
          <xsl:otherwise>
            <xsl:text>Unknown</xsl:text>
          </xsl:otherwise>
        </xsl:choose>
      </TD>
    </TR>
  </TABLE>

  <BR/>

  <TABLE BORDER="0" WIDTH="100%">
    <TR>
      <TD WIDTH="34%"><B>Height</B></TD>
      <TD WIDTH="33%"><B>Weight</B></TD>
      <TD WIDTH="33%"><B>Date of Birth</B></TD>
    </TR>
    <TR>
      <TD>
        <xsl:choose>
          <xsl:when test="count(r:personDescription/r:height)>0">
            <xsl:for-each select="r:personDescription/r:height">
              <xsl:sort select="@referenceDate" order="descending"/>
              <DIV>
                <xsl:call-template name="format-height"/>
              </DIV>
            </xsl:for-each>
          </xsl:when>
          <xsl:otherwise>
            <xsl:text>Unknown</xsl:text>
          </xsl:otherwise>
        </xsl:choose>
      </TD>
      <TD>
        <xsl:choose>
          <xsl:when test="count(r:personDescription/r:weight)>0">
            <xsl:for-each select="r:personDescription/r:weight">
              <xsl:sort select="@referenceDate" order="descending"/>
              <DIV>
                <xsl:call-template name="format-weight"/>
              </DIV>
            </xsl:for-each>
          </xsl:when>
          <xsl:otherwise>
            <xsl:text>Unknown</xsl:text>
          </xsl:otherwise>
        </xsl:choose>
      </TD>
      <TD>
        <xsl:choose>
          <xsl:when test="count(r:personDescription/r:birthDate)>0">
            <xsl:for-each select="r:personDescription/r:birthDate">
              <xsl:sort order="descending"/>
              <DIV>
                <xsl:value-of select="normalize-space(.)"/>
              </DIV>
            </xsl:for-each>
          </xsl:when>
          <xsl:otherwise>
            <xsl:text>Unknown</xsl:text>
          </xsl:otherwise>
        </xsl:choose>
      </TD>
    </TR>
  </TABLE>

  <BR/>

  <TABLE BORDER="0" WIDTH="100%">
    <TR>
      <TD WIDTH="34%"><B>Hair Color</B></TD>
      <TD WIDTH="33%"><B>Eye Color</B></TD>
      <TD WIDTH="33%"><B>Fingerprint Pattern</B></TD>
    </TR>
    <TR>
      <TD>
        <xsl:choose>
          <xsl:when test="count(r:personDescription/r:hairColor)>0">
            <xsl:for-each select="r:personDescription/r:hairColor">
              <xsl:sort select="@referenceDate" order="descending"/>
              <DIV>
                <xsl:value-of select="normalize-space(.)"/>
                <xsl:call-template name="format-attributes"/>
              </DIV>
            </xsl:for-each>
          </xsl:when>
          <xsl:otherwise>
            <xsl:text>Unknown</xsl:text>
          </xsl:otherwise>
        </xsl:choose>
      </TD>
      <TD>
        <xsl:choose>
          <xsl:when test="count(r:personDescription/r:eyeColor)>0">
            <xsl:for-each select="r:personDescription/r:eyeColor">
              <xsl:sort select="@referenceDate" order="descending"/>
              <DIV>
                <xsl:value-of select="normalize-space(.)"/>
                <xsl:call-template name="format-attributes"/>
              </DIV>
            </xsl:for-each>
          </xsl:when>
          <xsl:otherwise>
            <xsl:text>Unknown</xsl:text>
          </xsl:otherwise>
        </xsl:choose>
      </TD>
      <TD>
        <xsl:choose>
          <xsl:when test="count(r:personDescription/r:fingerprintPattern)>0">
            <xsl:for-each select="r:personDescription/r:fingerprintPattern">
              <xsl:sort select="@referenceDate" order="descending"/>
              <DIV>
                <xsl:value-of select="normalize-space(.)"/>
                <xsl:call-template name="format-attributes"/>
              </DIV>
            </xsl:for-each>
          </xsl:when>
          <xsl:otherwise>
            <xsl:text>Unknown</xsl:text>
          </xsl:otherwise>
        </xsl:choose>
      </TD>
    </TR>
  </TABLE>

  <BR/>

  <TABLE BORDER="0" WIDTH="100%">
    <TR>
      <TD COLSPAN="2"><B>Scars, Marks, and Tattoos</B></TD>
    </TR>
    <xsl:choose>
      <xsl:when test="count(r:personDescription/r:scarsMarksTattoos)>0">
        <TR>
          <TD WIDTH="34%"><B>Code</B></TD>
          <TD WIDTH="66%"><B>Description, Comments, and Images</B></TD>
        </TR>
        <xsl:for-each select="r:personDescription/r:scarsMarksTattoos">
          <xsl:sort select="@referenceDate" order="descending"/>
          <TR>
            <TD>
              <xsl:call-template name="format-code-source-date">
                <xsl:with-param name="node" 
                                select="./r:scarsMarksTattoosDescription"/>
                <xsl:with-param name="date" 
                                select="normalize-space(@referenceDate)"/>
              </xsl:call-template>
            </TD>
            <TD>
              <xsl:call-template name="format-smt-info"/>
            </TD>
          </TR>
        </xsl:for-each>
      </xsl:when>
      <xsl:otherwise>
        <TR><TD COLSPAN="2">Unknown</TD></TR>
      </xsl:otherwise>
    </xsl:choose>
  </TABLE>

  <BR/>

  <TABLE BORDER="0" WIDTH="100%">
    <TR>
      <TD WIDTH="34%"><B>Blood Type</B></TD>
      <TD WIDTH="66%"><B>Medical Condition</B></TD>
    </TR>
    <TR>
      <TD>
        <xsl:choose>
          <xsl:when test="count(r:personDescription/r:bloodType)>0">
            <xsl:for-each select="r:personDescription/r:bloodType">
              <DIV>
                <xsl:value-of select="normalize-space(.)"/>
              </DIV>
            </xsl:for-each>
          </xsl:when>
          <xsl:otherwise>
            <xsl:text>Unknown</xsl:text>
          </xsl:otherwise>
        </xsl:choose>
      </TD>
      <TD>
        <xsl:choose>
          <xsl:when test="count(r:personDescription/r:medicalCondition)>0">
            <xsl:for-each select="r:personDescription/r:medicalCondition">
              <xsl:sort select="@referenceDate" order="descending"/>
              <xsl:call-template name="format-code-and-source"/>
              <xsl:if test=".!=''">
                <xsl:text> </xsl:text>
                <xsl:value-of select="normalize-space(.)"/>
              </xsl:if>
              <xsl:if test="./@referenceDate!=''">
                <xsl:text> (</xsl:text>
                <xsl:value-of select="normalize-space(./@referenceDate)"/>
                <xsl:text>)</xsl:text>
              </xsl:if>
            </xsl:for-each>
          </xsl:when>
          <xsl:otherwise>
            <xsl:text>Unknown</xsl:text>
          </xsl:otherwise>
        </xsl:choose>
      </TD>
    </TR>
  </TABLE>

  <BR/>

  <TABLE BORDER="0" WIDTH="100%">
    <TR>
      <TD WIDTH="34%"><B>Place of Birth</B></TD>
      <TD WIDTH="33%"><B>Citizenship</B></TD>
      <TD WIDTH="33%"><B>Ethnicity</B></TD>
    </TR>
    <TR>
      <TD>
        <xsl:choose>
          <xsl:when test="count(r:personDescription/r:birthPlace)>0">
            <xsl:for-each select="r:personDescription/r:birthPlace">
              <DIV>
                <xsl:value-of select="normalize-space(./r:birthPlaceData)"/>
              </DIV>
              <DIV>
                <xsl:call-template name="format-physicalLocation-1C">
                  <xsl:with-param name="pl" select="r:physicalLocation"/>
                </xsl:call-template>
              </DIV>
            </xsl:for-each>
          </xsl:when>
          <xsl:otherwise>
            <xsl:text>Unknown</xsl:text>
          </xsl:otherwise>
        </xsl:choose>
      </TD>
      <TD>
        <xsl:choose>
          <xsl:when test="count(r:personDescription/r:citizenship)>0">
            <xsl:for-each select="r:personDescription/r:citizenship">
              <xsl:sort select="@referenceDate" order="descending"/>
              <DIV>
                <xsl:value-of select="normalize-space(.)"/>
                <xsl:call-template name="format-attributes"/>
              </DIV>
            </xsl:for-each>
          </xsl:when>
          <xsl:otherwise>
            <xsl:text>Unknown</xsl:text>
          </xsl:otherwise>
        </xsl:choose>
      </TD>
      <TD>
        <xsl:choose>
          <xsl:when test="count(r:personDescription/r:ethnicity)>0">
            <xsl:for-each select="r:personDescription/r:ethnicity">
              <DIV>
                <xsl:value-of select="normalize-space(.)"/>
              </DIV>
            </xsl:for-each>
          </xsl:when>
          <xsl:otherwise>
            <xsl:text>Unknown</xsl:text>
          </xsl:otherwise>
        </xsl:choose>
      </TD>
    </TR>
  </TABLE>

  <BR/>

  <TABLE BORDER="0" WIDTH="100%">
    <TR>
      <TD WIDTH="34%"><B>Marital Status</B></TD>
      <TD WIDTH="33%"><B>Religion</B></TD>
      <TD WIDTH="33%"><B></B></TD>
    </TR>
    <TR>
      <TD>
        <xsl:choose>
          <xsl:when test="count(r:personDescription/r:maritalStatus)>0">
            <xsl:for-each select="r:personDescription/r:maritalStatus">
              <xsl:sort select="@referenceDate" order="descending"/>
              <DIV>
                <xsl:value-of select="normalize-space(.)"/>
                <xsl:call-template name="format-attributes"/>
              </DIV>
            </xsl:for-each>
          </xsl:when>
          <xsl:otherwise>
            <xsl:text>Unknown</xsl:text>
          </xsl:otherwise>
        </xsl:choose>
      </TD>
      <TD>
        <xsl:choose>
          <xsl:when test="count(r:personDescription/r:religion)>0">
            <xsl:for-each select="r:personDescription/r:religion">
              <xsl:sort select="@referenceDate" order="descending"/>
              <DIV>
                <xsl:value-of select="normalize-space(.)"/>
                <xsl:call-template name="format-attributes"/>
              </DIV>
            </xsl:for-each>
          </xsl:when>
          <xsl:otherwise>
            <xsl:text>Unknown</xsl:text>
          </xsl:otherwise>
        </xsl:choose>
      </TD>
      <TD>
      </TD>
    </TR>
  </TABLE>

  <BR/>

  <TABLE BORDER="0" WIDTH="100%">
    <TR>
      <TD WIDTH="34%"><B>Employment</B></TD>
      <TD WIDTH="66%"></TD>
    </TR>
    <xsl:choose>
      <xsl:when test="count(r:employment)>0">
        <xsl:for-each select="r:employment">
          <xsl:sort select="./@referenceDate" order="descending"/>
          <xsl:if test="position()>1">
            <TR><TD COLSPAN="2"></TD></TR>
          </xsl:if>
          <xsl:if test="./@referenceDate!=''">
            <TR>
              <TD WIDTH="34%">
                <xsl:text>Employment as of</xsl:text>
              </TD>
              <TD WIDTH="66%">
                <xsl:value-of select="normalize-space(./@referenceDate)"/>
              </TD>
            </TR>
          </xsl:if>
          <xsl:if test="./r:occupation!=''">
            <TR>
              <TD WIDTH="34%">
                <xsl:text>Occupation</xsl:text>
              </TD>
              <TD WIDTH="66%">
                <xsl:value-of select="normalize-space(./r:occupation)"/>
              </TD>
            </TR>
          </xsl:if>
          <TR>
            <TD WIDTH="34%">
              <xsl:text>Employer</xsl:text>
            </TD>
            <TD WIDTH="66%">
              <xsl:value-of select="normalize-space(./r:employer)"/>
            </TD>
          </TR>
          <xsl:call-template name="format-physicalLocation-2C">
            <xsl:with-param name="pl" select="./r:physicalLocation"/>
          </xsl:call-template>
        </xsl:for-each>
      </xsl:when>
      <xsl:otherwise>
        <TR><TD COLSPAN="2"><xsl:text>Unknown</xsl:text></TD></TR>
      </xsl:otherwise>
    </xsl:choose>
  </TABLE>

  <BR/>

  <TABLE BORDER="0" WIDTH="100%">
    <TR>
      <TD WIDTH="34%"><B>Residence</B></TD>
      <TD WIDTH="66%"></TD>
    </TR>
    <xsl:choose>
      <xsl:when test="count(r:residence)>0">
        <xsl:for-each select="r:residence">
          <xsl:sort select="./@referenceDate" order="descending"/>
          <xsl:if test="position()>1">
            <TR><TD COLSPAN="2"></TD></TR>
          </xsl:if>
          <xsl:if test="./@referenceDate!=''">
            <TR>
              <TD WIDTH="34%">
                <xsl:text>Residence as of</xsl:text>
              </TD>
              <TD WIDTH="66%">
                <xsl:value-of select="normalize-space(./@referenceDate)"/>
              </TD>
            </TR>
          </xsl:if>
          <xsl:call-template name="format-physicalLocation-2C">
            <xsl:with-param name="pl" select="./r:physicalLocation"/>
          </xsl:call-template>
          <xsl:if test="count(r:telephone)>0">
            <TR>
              <TD WIDTH="34%">
                <xsl:text>Telephone</xsl:text>
              </TD>
              <TD WIDTH="66%">
                <xsl:for-each select="r:telephone">
                  <DIV>
                    <xsl:call-template name="format-telephone"/>
                  </DIV>
                </xsl:for-each>
              </TD>
            </TR>
          </xsl:if>
        </xsl:for-each>
      </xsl:when>
      <xsl:otherwise>
        <TR><TD COLSPAN="2"><xsl:text>Unknown</xsl:text></TD></TR>
      </xsl:otherwise>
    </xsl:choose>
  </TABLE>

  <BR/>

  <TABLE BORDER="0" WIDTH="100%">
    <TR>
      <TD COLSPAN="2"><B>Fingerprint Images</B></TD>
    </TR>
    <xsl:choose>
      <xsl:when test="count(r:fingerPrint)>0">
        <TR>
          <TD WIDTH="34%"><B>Type</B></TD>
          <TD WIDTH="66%"><B>Comments and Images</B></TD>
        </TR>
        <xsl:for-each select="r:fingerPrint">
          <xsl:sort select="@referenceDate" order="descending"/>
          <TR>
            <xsl:call-template name="format-fp-pp-p"/>
          </TR>
        </xsl:for-each>
      </xsl:when>
      <xsl:otherwise>
        <TR><TD COLSPAN="2">Unknown</TD></TR>
      </xsl:otherwise>
    </xsl:choose>
  </TABLE>

  <BR/>

  <TABLE BORDER="0" WIDTH="100%">
    <TR>
      <TD COLSPAN="2"><B>Palmprint Images</B></TD>
    </TR>
    <xsl:choose>
      <xsl:when test="count(r:palmPrint)>0">
        <TR>
          <TD WIDTH="34%"><B>Type</B></TD>
          <TD WIDTH="66%"><B>Comments and Images</B></TD>
        </TR>
        <xsl:for-each select="r:palmPrint">
          <xsl:sort select="@referenceDate" order="descending"/>
          <TR>
            <xsl:call-template name="format-fp-pp-p"/>
          </TR>
        </xsl:for-each>
      </xsl:when>
      <xsl:otherwise>
        <TR><TD COLSPAN="2">Unknown</TD></TR>
      </xsl:otherwise>
    </xsl:choose>
  </TABLE>

  <BR/>

  <TABLE BORDER="0" WIDTH="100%">
    <TR>
      <TD COLSPAN="2"><B>Photo Images</B></TD>
    </TR>
    <xsl:choose>
      <xsl:when test="count(r:photo)>0">
        <TR>
          <TD WIDTH="34%"><B>Type</B></TD>
          <TD WIDTH="66%"><B>Comments and Images</B></TD>
        </TR>
        <xsl:for-each select="r:photo">
          <xsl:sort select="@referenceDate" order="descending"/>
          <TR>
            <xsl:call-template name="format-fp-pp-p"/>
          </TR>
        </xsl:for-each>
      </xsl:when>
      <xsl:otherwise>
        <TR><TD COLSPAN="2">Unknown</TD></TR>
      </xsl:otherwise>
    </xsl:choose>
  </TABLE>

  <BR/>

  <TABLE BORDER="0" WIDTH="100%">
    <TR>
      <TD COLSPAN="2"><B>DNA Data</B></TD>
    </TR>
    <xsl:choose>
      <xsl:when test="count(r:dna)>0">
        <TR>
          <TD WIDTH="34%"><B>Encoding Method</B></TD>
          <TD WIDTH="66%"><B>Data and Comments</B></TD>
        </TR>
        <xsl:for-each select="r:dna">
          <xsl:sort select="@referenceDate" order="descending"/>
          <TR>
            <TD>
              <xsl:choose>
                <xsl:when test="@contentEncoding!=''">
                  <xsl:value-of select="normalize-space(@contentEncoding)"/>
                </xsl:when>
                <xsl:otherwise>
                  <xsl:text>Unknown Code</xsl:text>
                </xsl:otherwise>
              </xsl:choose>
              <xsl:choose>
                <xsl:when test="@referenceDate!=''">
                  <xsl:text> (</xsl:text>
                  <xsl:value-of select="normalize-space(@referenceDate)"/>
                  <xsl:text>)</xsl:text>
                </xsl:when>
                <xsl:otherwise>
                </xsl:otherwise>
              </xsl:choose>
            </TD>
            <TD>
              <xsl:choose>
                <xsl:when test="count(r:dnaLocus)>0">
                    <xsl:text>DNA locus data table follows </xsl:text>
                    <xsl:call-template name="format-agency-list"/>
                    <TABLE BORDER="0" WIDTH="100%">
                      <TR>
                        <TD WIDTH="100"><B>Locus</B></TD><TD><B>Value</B></TD>
                        <TD WIDTH="100"><B>Locus</B></TD><TD><B>Value</B></TD>
                      </TR>
                      <xsl:variable name="data-count" 
                                    select="count(r:dnaLocus)"/>
                      <xsl:for-each select="r:dnaLocus">
                        <xsl:if test="(position() mod 2)=1">
                          <TR>
                            <TD><xsl:value-of select="./@type"/></TD>
                            <TD>
                              <xsl:for-each select="./r:dnaLocusValue">
                                <xsl:if test="position()>1">
                                  <xsl:text>, </xsl:text>
                                </xsl:if>
                                <xsl:value-of select="normalize-space(.)"/>
                              </xsl:for-each>
                            </TD>
                            <xsl:choose>
                              <xsl:when test="(position()+1)>$data-count">
                                <TD></TD><TD></TD>
                              </xsl:when>
                              <xsl:otherwise>
                                <TD><xsl:value-of select="following::r:dnaLocus[1]/@type"/></TD>
                                <TD>
                                  <xsl:for-each select="following::r:dnaLocus[1]/r:dnaLocusValue">
                                    <xsl:if test="position()>1">
                                      <xsl:text>, </xsl:text>
                                    </xsl:if>
                                    <xsl:value-of select="normalize-space(.)"/>
                                  </xsl:for-each>
                                </TD>
                              </xsl:otherwise>
                            </xsl:choose>
                          </TR>
                        </xsl:if>
                      </xsl:for-each>
                    </TABLE>
                </xsl:when>
                <xsl:otherwise>
                  <xsl:text>Contact agency for data </xsl:text>
                  <xsl:call-template name="format-agency-list"/>
                </xsl:otherwise>
              </xsl:choose>
              <xsl:for-each select="r:comment">
                <DIV>
                  <xsl:value-of select="normalize-space(.)"/>
                </DIV>
              </xsl:for-each>
            </TD>
          </TR>
        </xsl:for-each>
      </xsl:when>
      <xsl:otherwise>
        <TR><TD COLSPAN="2">Unknown</TD></TR>
      </xsl:otherwise>
    </xsl:choose>
  </TABLE>

  <BR/>

  <TABLE BORDER="0" CELLPADDING="0" WIDTH="100%">
    <TR>
      <TD COLSPAN="2"><B>Caution Information</B></TD>
    </TR>
    <xsl:if test="r:firearmSalesDisqualified!=''">
      <TR>
        <TD WIDTH="34%">Firearms Disqualified</TD>
        <TD WIDTH="66%">
          <xsl:variable name="d" 
               select="normalize-space(./r:firearmSalesDisqualified)"/>
          <xsl:value-of select="$d"/>
          <xsl:text> - </xsl:text>
          <xsl:choose>
            <xsl:when test="$d='F'">
              <xsl:text>Felony Conviction</xsl:text>
            </xsl:when>
            <xsl:when test="$d='M'">
              <xsl:text>Misdemeanor Conviction</xsl:text>
            </xsl:when>
            <xsl:when test="$d='D'">
              <xsl:text>Disqualified</xsl:text>
            </xsl:when>
            <xsl:when test="$d='C'">
              <xsl:text>Cleared</xsl:text>
            </xsl:when>
            <xsl:otherwise>
              <xsl:text>Status unknown or pending</xsl:text>
            </xsl:otherwise>
          </xsl:choose>
        </TD>
      </TR>
    </xsl:if>
    <xsl:for-each select="./r:caution">
       <xsl:sort select="./@referenceDate" order="descending"/>
       <TR>
         <TD WIDTH="34%">Caution</TD>
         <TD WIDTH="66%">
           <xsl:value-of select="normalize-space(.)"/>
           <xsl:call-template name="format-attributes"/>
         </TD>
       </TR>
    </xsl:for-each>
    <xsl:for-each select="./r:offenderNotice">
       <xsl:sort select="./@referenceDate" order="descending"/>
       <TR>
         <TD WIDTH="34%">Notice</TD>
         <TD WIDTH="66%">
           <xsl:value-of select="normalize-space(.)"/>
           <xsl:call-template name="format-attributes"/>
         </TD>
       </TR>
    </xsl:for-each>
    <xsl:for-each select="./r:comment">
       <xsl:sort select="./@referenceDate" order="descending"/>
       <TR>
         <TD WIDTH="34%">Comment(s)</TD>
         <TD WIDTH="66%">
           <xsl:value-of select="normalize-space(.)"/>
           <xsl:call-template name="format-attributes"/>
         </TD>
       </TR>
    </xsl:for-each>
  </TABLE>


<xsl:call-template name="navigation-bar"/>

</xsl:template>


<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->
<!--                           cycle                             -->
<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->

<!--   This template controls formatting of information from cycle
       elements.  It is called from the /r:rapSheet template.
-->

<xsl:template name="r:cycle">

  <TABLE BORDER="0" WIDTH="100%">
    <xsl:choose>
    <xsl:when test="count(r:cycle)>0">
      <xsl:for-each select="r:cycle">
        <xsl:sort select="r:earliestDate"/>
        <xsl:variable name="cycle-number"
                      select="format-number(position(), '000')"/>
        <TR><TD COLSPAN="2"><BR/></TD></TR>

        <TR>
          <TD COLSPAN="2" ALIGN="CENTER" STYLE="border: solid thin"
              BGCOLOR="#AACCFF">
            <B>
              <xsl:text>Cycle </xsl:text>
              <xsl:value-of select="$cycle-number"/>
            </B>
          </TD>
        </TR>

        <TR><TD COLSPAN="2"><BR/></TD></TR>

        <xsl:if test="count(r:cycleTrackingNumber)>0">
          <TR>
            <TD><B>Tracking Number</B></TD>
            <TD>
              <xsl:value-of select="normalize-space(r:cycleTrackingNumber)"/>
            </TD>
          </TR>
        </xsl:if>

        <xsl:if test="count(r:earliestDate)>0">
          <TR>
            <TD><B>Earliest Event Date</B></TD>
            <TD>
              <xsl:value-of select="normalize-space(r:earliestDate)"/>
            </TD>
          </TR>
        </xsl:if>

        <xsl:choose>
          <xsl:when test="count(r:arrest)>0">
            <TR><TD COLSPAN="2"><HR/></TD></TR>
            <xsl:call-template name="r:arrest">
              <xsl:with-param name="cycle-number" select="$cycle-number"/>
            </xsl:call-template>
          </xsl:when>
          <xsl:otherwise>
            <TR><TD COLSPAN="2"><HR/></TD></TR>
            <TR>
              <TD><B>Arrest</B></TD>
              <TD>No data supplied</TD>
            </TR>
          </xsl:otherwise>
        </xsl:choose>

        <xsl:choose>
          <xsl:when test="count(r:prosecutorDisposition)>0">
            <xsl:for-each select="r:prosecutorDisposition">
              <TR><TD COLSPAN="2"><HR/></TD></TR>
              <xsl:call-template name="r:prosecutorDisposition">
                <xsl:with-param name="cycle-number" select="$cycle-number"/>
              </xsl:call-template>
            </xsl:for-each>
          </xsl:when>
          <xsl:otherwise>
            <TR><TD COLSPAN="2"><HR/></TD></TR>
            <TR>
              <TD><B>Prosecutor Disposition</B></TD>
              <TD>No data supplied</TD>
            </TR>
          </xsl:otherwise>
        </xsl:choose>

        <xsl:choose>
          <xsl:when test="count(r:courtDisposition)>0">
            <xsl:for-each select="r:courtDisposition">
              <TR><TD COLSPAN="2"><HR/></TD></TR>
              <xsl:call-template name="r:courtDisposition">
                <xsl:with-param name="cycle-number" select="$cycle-number"/>
              </xsl:call-template>
            </xsl:for-each>
          </xsl:when>
          <xsl:otherwise>
            <TR><TD COLSPAN="2"><HR/></TD></TR>
            <TR>
              <TD><B>Court Disposition</B></TD>
              <TD>No data supplied</TD>
            </TR>
          </xsl:otherwise>
        </xsl:choose>

        <xsl:choose>
          <xsl:when test="count(r:sentencing)>0">
            <xsl:for-each select="r:sentencing">
              <TR><TD COLSPAN="2"><HR/></TD></TR>
              <xsl:call-template name="r:sentencing">
                <xsl:with-param name="cycle-number" select="$cycle-number"/>
              </xsl:call-template>
            </xsl:for-each>
          </xsl:when>
          <xsl:otherwise>
            <TR><TD COLSPAN="2"><HR/></TD></TR>
            <TR>
              <TD><B>Sentencing</B></TD>
              <TD>No data supplied</TD>
            </TR>
          </xsl:otherwise>
        </xsl:choose>

        <xsl:choose>
          <xsl:when test="count(r:corrections)>0">
            <xsl:for-each select="r:corrections">
              <TR><TD COLSPAN="2"><HR/></TD></TR>
              <xsl:call-template name="r:corrections">
                <xsl:with-param name="cycle-number" select="$cycle-number"/>
              </xsl:call-template>
            </xsl:for-each>
          </xsl:when>
          <xsl:otherwise>
            <TR><TD COLSPAN="2"><HR/></TD></TR>
            <TR>
              <TD><B>Corrections</B></TD>
              <TD>No data supplied</TD>
            </TR>
          </xsl:otherwise>
        </xsl:choose>

      </xsl:for-each>  <!--  cycle element  -->
    </xsl:when>
    <xsl:otherwise>
      <TR>
        <TD COLSPAN="2">
          <B><xsl:text>No cycles in rap sheet. </xsl:text></B>
          <xsl:text>Contact agency. </xsl:text>
        </TD>
      </TR>
    </xsl:otherwise>
    </xsl:choose>
  </TABLE>

<xsl:call-template name="navigation-bar"/>

</xsl:template>


<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->
<!--                              arrest                               -->
<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->

<!--   Formats arrest information  -->

<xsl:template name="r:arrest">
  <xsl:param name="cycle-number"/>

  <TR>
    <TD WIDTH="34%"><B>Arrest </B></TD>
    <TD WIDTH="66%">
      <xsl:text>(Cycle </xsl:text>
      <xsl:value-of select="$cycle-number"/>
      <xsl:text>)</xsl:text>
    </TD>
  </TR>

  <TR>
    <TD WIDTH="34%"><B>Arrest Date</B></TD>
    <TD WIDTH="66%">
      <xsl:value-of select="normalize-space(r:arrest/r:arrestDate)"/>
    </TD>
  </TR>

  <xsl:if test="count(r:arrest/r:arrestCaseNumber)>0">
    <TR>
      <TD><B>Arrest Case Number</B></TD>
      <TD>
        <xsl:value-of select="normalize-space(r:arrest/r:arrestCaseNumber)"/>
      </TD>
    </TR>
  </xsl:if>

  <xsl:if test="count(r:arrest/r:agency)>0">
    <TR>
      <TD><B>Arresting Agency</B></TD>
      <TD>
        <xsl:call-template name="format-agency-list-no-parens">
          <xsl:with-param name="node" select="r:arrest"/>
        </xsl:call-template>
      </TD>
    </TR>
  </xsl:if>

  <xsl:if test="count(r:arrest/r:personName)>0">
  <TR>
    <TD><B>Subject Name(s)</B></TD>
    <TD>
      <xsl:for-each select="r:arrest/r:personName">
        <xsl:sort select="concat(r:lastName, ',', r:firstName)"/>
        <DIV>
          <xsl:call-template name="format-personName"/>
        </DIV>
      </xsl:for-each>
    </TD>
  </TR>
  </xsl:if>

  <xsl:if test="count(r:arrest/r:personalIDNumber)>0">
    <TR>
      <TD ALIGN="RIGHT">Offender ID Number</TD>
      <TD>
        <xsl:value-of select="normalize-space(r:arrest/r:personalIDNumber)"/>
        <xsl:call-template name="format-attributes-no-type">
          <xsl:with-param name="node" select="r:arrest/r:personalIDNumber"/>
        </xsl:call-template>
      </TD>
    </TR>
  </xsl:if>

  <xsl:if test="count(r:arrest/r:arrestType)>0">
    <TR>
      <TD ALIGN="RIGHT">Arrest Type</TD>
      <TD>
        <xsl:value-of select="normalize-space(r:arrest/r:arrestType)"/>
      </TD>
    </TR>
  </xsl:if>

  <xsl:if test="count(r:arrest/r:comment)>0">
    <TR>
      <TD ALIGN="RIGHT">
        <xsl:text>Comment(s)</xsl:text>
      </TD>
      <TD>
        <xsl:for-each select="r:arrest/r:comment">
          <DIV>
            <xsl:value-of select="normalize-space(.)"/>
          </DIV>
        </xsl:for-each>
      </TD>
    </TR>
  </xsl:if>

  <xsl:for-each select="r:arrest/r:charge">
    <xsl:call-template name="format-charge"/>
  </xsl:for-each>

</xsl:template>  <!-- arrest -->


<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->
<!--                     prosecutorDisposition                         -->
<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->

<!--   Formats prosecutor disposition information  -->

<xsl:template name="r:prosecutorDisposition">
  <xsl:param name="cycle-number"/>

  <TR>
    <TD WIDTH="34%"><B>Prosecutor Disposition</B></TD>
    <TD WIDTH="66%">
      <xsl:text>(Cycle </xsl:text>
      <xsl:value-of select="$cycle-number"/>
      <xsl:text>)</xsl:text>
      <xsl:value-of select="r:cycleTrackingNumber"/>
    </TD>
  </TR>

  <xsl:if test="count(r:prosecutorCaseNumber)>0">
    <TR>
      <TD><B>Prosecutor Case Number</B></TD>
      <TD>
        <xsl:value-of select="normalize-space(r:prosecutorCaseNumber)"/>
      </TD>
    </TR>
  </xsl:if>

  <xsl:if test="count(r:agency)>0">
    <TR>
      <TD><B>Prosecutor Agency</B></TD>
      <TD>
        <xsl:call-template name="format-agency-list-no-parens"/>
      </TD>
    </TR>
  </xsl:if>

  <xsl:if test="count(r:personName)>0">
  <TR>
    <TD><B>Subject Name(s)</B></TD>
    <TD>
      <xsl:for-each select="r:personName">
        <xsl:sort select="concat(r:lastName, ',', r:firstName)"/>
        <DIV>
          <xsl:call-template name="format-personName"/>
        </DIV>
      </xsl:for-each>
    </TD>
  </TR>
  </xsl:if>

  <xsl:for-each select="r:charge">
    <xsl:call-template name="format-charge"/>
  </xsl:for-each>

</xsl:template>  <!-- prosecutorDisposition -->


<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->
<!--                        courtDisposition                           -->
<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->

<!--   Formats court disposition information  -->

<xsl:template name="r:courtDisposition">
  <xsl:param name="cycle-number"/>

  <TR>
    <TD WIDTH="34%"><B>Court Disposition</B></TD>
    <TD WIDTH="66%">
      <xsl:text>(Cycle </xsl:text>
      <xsl:value-of select="$cycle-number"/>
      <xsl:text>)</xsl:text>
      <xsl:value-of select="r:cycleTrackingNumber"/>
    </TD>
  </TR>

  <xsl:if test="count(r:courtCaseNumber)>0">
    <TR>
      <TD><B>Court Case Number</B></TD>
      <TD>
        <xsl:value-of select="normalize-space(r:courtCaseNumber)"/>
      </TD>
    </TR>
  </xsl:if>

  <xsl:if test="count(r:agency)>0">
    <TR>
      <TD><B>Court Agency</B></TD>
      <TD>
        <xsl:call-template name="format-agency-list-no-parens"/>
      </TD>
    </TR>
  </xsl:if>

  <xsl:if test="count(r:personName)>0">
  <TR>
    <TD><B>Subject Name(s)</B></TD>
    <TD>
      <xsl:for-each select="r:personName">
        <xsl:sort select="concat(r:lastName, ',', r:firstName)"/>
        <DIV>
          <xsl:call-template name="format-personName"/>
        </DIV>
      </xsl:for-each>
    </TD>
  </TR>
  </xsl:if>

  <xsl:for-each select="r:charge">
    <xsl:call-template name="format-charge"/>
  </xsl:for-each>

</xsl:template>  <!-- courtDisposition -->


<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->
<!--                           sentencing                              -->
<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->

<!--   Formats sentencing information  -->

<xsl:template name="r:sentencing">
  <xsl:param name="cycle-number"/>

  <TR>
    <TD WIDTH="34%"><B>Sentencing</B></TD>
    <TD WIDTH="66%">
      <xsl:text>(Cycle </xsl:text>
      <xsl:value-of select="$cycle-number"/>
      <xsl:text>)</xsl:text>
    </TD>
  </TR>

  <xsl:if test="count(r:agency)>0">
    <TR>
      <TD><B>Sentencing Agency</B></TD>
      <TD>
        <xsl:call-template name="format-agency-list-no-parens"/>
      </TD>
    </TR>
  </xsl:if>

  <xsl:if test="count(r:courtCaseNumber)>0">
    <TR>
      <TD ALIGN="RIGHT">Court Case Number</TD>
      <TD>
        <xsl:value-of select="normalize-space(r:courtCaseNumber)"/>
      </TD>
    </TR>
  </xsl:if>

  <xsl:if test="count(r:chargeNumber)>0">
    <TR>
      <TD ALIGN="RIGHT">Charge Number</TD>
      <TD>
        <xsl:value-of select="normalize-space(r:chargeNumber)"/>
      </TD>
    </TR>
  </xsl:if>

  <xsl:if test="count(r:chargeSequenceNumber)>0">
    <TR>
      <TD ALIGN="RIGHT">Charge Sequence Number</TD>
      <TD>
        <xsl:value-of select="normalize-space(r:chargeSequenceNumber)"/>
      </TD>
    </TR>
  </xsl:if>

  <xsl:if test="count(r:chargeTrackingNumber)>0">
    <TR>
      <TD ALIGN="RIGHT">Charge Tracking Number</TD>
      <TD>
        <xsl:value-of select="normalize-space(r:chargeTrackingNumber)"/>
      </TD>
    </TR>
  </xsl:if>

  <xsl:if test="count(r:sentence)>0">
    <TR>
      <TD ALIGN="RIGHT">Sentence</TD>
      <TD>
        <xsl:for-each select="r:sentence">
          <DIV>
            <xsl:value-of select="normalize-space(.)"/>
            <xsl:call-template name="format-attributes"/>
          </DIV>
        </xsl:for-each>
      </TD>
    </TR>
  </xsl:if>

  <xsl:if test="count(r:comment)>0">
    <TR>
      <TD ALIGN="RIGHT">
        <xsl:text>Comment(s)</xsl:text>
      </TD>
      <TD>
        <xsl:for-each select="r:comment">
          <DIV>
            <xsl:value-of select="normalize-space(.)"/>
          </DIV>
        </xsl:for-each>
      </TD>
    </TR>
  </xsl:if>

</xsl:template>  <!-- sentencing -->


<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->
<!--                           corrections                             -->
<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->

<!--   Formats corrections information  -->

<xsl:template name="r:corrections">
  <xsl:param name="cycle-number"/>

  <TR>
    <TD WIDTH="34%"><B>Corrections</B></TD>
    <TD WIDTH="66%">
      <xsl:text>(Cycle </xsl:text>
      <xsl:value-of select="$cycle-number"/>
      <xsl:text>)</xsl:text>
    </TD>
  </TR>

  <xsl:if test="count(r:agency)>0">
    <TR>
      <TD><B>Corrections Agency</B></TD>
      <TD>
        <xsl:call-template name="format-agency-list-no-parens"/>
      </TD>
    </TR>
  </xsl:if>

  <xsl:if test="count(r:personName)>0">
  <TR>
    <TD><B>Subject Name(s)</B></TD>
    <TD>
      <xsl:for-each select="r:personName">
        <xsl:sort select="concat(r:lastName, ',', r:firstName)"/>
        <DIV>
          <xsl:call-template name="format-personName"/>
        </DIV>
      </xsl:for-each>
    </TD>
  </TR>
  </xsl:if>

  <xsl:if test="count(r:personalIDNumber)>0">
    <TR>
      <TD ALIGN="RIGHT">Correctional Id Number</TD>
      <TD>
        <xsl:value-of select="normalize-space(r:personalIDNumber)"/>
        <xsl:call-template name="format-attributes-no-type">
          <xsl:with-param name="node" select="r:personalIDNumber"/>
        </xsl:call-template>
      </TD>
    </TR>
  </xsl:if>

  <xsl:if test="count(r:courtCaseNumber)>0">
    <TR>
      <TD ALIGN="RIGHT">Court Case Number</TD>
      <TD>
        <xsl:value-of select="normalize-space(r:courtCaseNumber)"/>
      </TD>
    </TR>
  </xsl:if>

  <xsl:if test="count(r:correctionAction)>0">
    <TR>
      <TD ALIGN="RIGHT">Correction Action</TD>
      <TD>
        <xsl:for-each select="r:correctionAction">
          <DIV>
            <xsl:value-of select="normalize-space(.)"/>
            <xsl:call-template name="format-attributes"/>
          </DIV>
        </xsl:for-each>
      </TD>
    </TR>
  </xsl:if>

  <xsl:if test="count(r:comment)>0">
    <TR>
      <TD ALIGN="RIGHT">
        <xsl:text>Comment(s)</xsl:text>
      </TD>
      <TD>
        <xsl:for-each select="r:comment">
          <DIV>
            <xsl:value-of select="normalize-space(.)"/>
          </DIV>
        </xsl:for-each>
      </TD>
    </TR>
  </xsl:if>

</xsl:template>  <!-- corrections -->


<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->
<!--                           agencyIndex                             -->
<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->

<!--   This template controls formatting of information from index
       elements.  It is called from the /r:rapSheet template.
-->

<xsl:template match="r:agencyIndex">

  <TABLE BORDER="0" WIDTH="100%">
    <xsl:for-each select="r:agencyInformation">
      <xsl:if test="position()>1">
        <TR>
          <TD COLSPAN="2"><HR/></TD>
        </TR>
      </xsl:if>

      <TR>
        <TD>Agency</TD>
        <TD>
          <xsl:call-template name="format-agency-list-no-parens"/>
        </TD>
      </TR>

      <xsl:if test="(count(r:contactPerson)+count(r:department))>0">
        <TR>
          <TD WIDTH="34%">Contact</TD>
          <TD WIDTH="66%">
            <xsl:if test="normalize-space(r:department)!=''">
              <DIV>
                <xsl:value-of select="normalize-space(./r:department)"/>
                <xsl:text> Department</xsl:text>
              </DIV>
            </xsl:if>
            <xsl:for-each select="r:contactPerson">
              <DIV>
                <xsl:value-of select="normalize-space(.)"/>
              </DIV>
            </xsl:for-each>
          </TD>
        </TR>
      </xsl:if>

      <xsl:if test="count(r:telephone)>0">
        <TR>
          <TD>
            <xsl:text>Agency Telephone</xsl:text>
          </TD>
          <TD>
            <xsl:for-each select="r:telephone">
              <DIV>
                <xsl:call-template name="format-telephone"/>
              </DIV>
            </xsl:for-each>
          </TD>
        </TR>
      </xsl:if>

      <xsl:if test="count(r:fax)>0">
        <TR>
          <TD>
            <xsl:text>Agency Facsimile</xsl:text>
          </TD>
          <TD>
            <xsl:for-each select="r:fax">
              <DIV>
                <xsl:call-template name="format-telephone">
                  <xsl:with-param name="node" select="r:telephone"/>
                </xsl:call-template>
              </DIV>
            </xsl:for-each>
          </TD>
        </TR>
      </xsl:if>

      <xsl:if test="count(r:email)>0">
        <TR>
          <TD>Agency Email Address</TD>
          <TD>
           <xsl:for-each select="r:email">
             <DIV>
               <xsl:value-of select="normalize-space(.)"/>
             </DIV>
           </xsl:for-each>
         </TD>
        </TR>
      </xsl:if>

      <xsl:if test="count(r:physicalLocation)>0">
        <TR>
          <xsl:call-template name="format-physicalLocation-2C">
            <xsl:with-param name="pl" select="./r:physicalLocation"/>
          </xsl:call-template>
        </TR>
      </xsl:if>

    </xsl:for-each>
  </TABLE>

  <xsl:call-template name="navigation-bar"/>

</xsl:template>


<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->
<!--                        format-personName                         -->
<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->

<!--   Formatting of person names.   -->

<xsl:template name="format-personName">
  <xsl:param name="subject" select="."/>
  <xsl:value-of select="$subject/r:lastName"/>
  <xsl:if test="($subject/r:namePrefix!='') or ($subject/r:firstName!='') or ($subject/r:middleName!='') or ($subject/r:nameSuffix!='')">
    <xsl:text>,</xsl:text>
  </xsl:if>
  <xsl:for-each select="$subject/r:namePrefix">
    <xsl:text> </xsl:text>
    <xsl:value-of select="normalize-space(.)"/>
  </xsl:for-each>
  <xsl:if test="$subject/r:firstName!=''">
    <xsl:text> </xsl:text>
    <xsl:value-of select="normalize-space($subject/r:firstName)"/>
  </xsl:if>
  <xsl:for-each select="$subject/r:middleName">
    <xsl:text> </xsl:text>
    <xsl:value-of select="normalize-space(.)"/>
  </xsl:for-each>
  <xsl:for-each select="$subject/r:nameSuffix">
    <xsl:text> </xsl:text> 
    <xsl:value-of select="normalize-space(.)"/>
  </xsl:for-each>
  <xsl:if test="$subject/@type!=''">
    <xsl:if test="$subject/@type!='Primary'">
       <xsl:text> (</xsl:text>
       <xsl:value-of select="$subject/@type"/>
       <xsl:text>)</xsl:text>
    </xsl:if>
  </xsl:if>
</xsl:template>


<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->
<!--                        prepend-attribute                          -->
<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->

<!--   Prepend an attribute to a list   -->

<xsl:template name="prepend-attribute">
  <xsl:param name="attr"/>
  <xsl:param name="list"/>
  <xsl:variable name="result">
    <xsl:choose>
    <xsl:when test="$list!=''">
      <xsl:choose>
        <xsl:when test="$attr!=''">
          <xsl:value-of select="$attr"/>; <xsl:value-of select="$list"/>
        </xsl:when>
        <xsl:otherwise>
          <xsl:value-of select="$list"/>
        </xsl:otherwise>
      </xsl:choose>
    </xsl:when>
    <xsl:otherwise>
      <xsl:value-of select="$attr"/>
    </xsl:otherwise>
    </xsl:choose>
  </xsl:variable>
  <xsl:value-of select="$result"/>
</xsl:template>


<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->
<!--                        format-attributes                          -->
<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->

<!--   Formatting of a standard set of attributes   -->

<xsl:template name="format-attributes">
  <xsl:param name="node" select="."/>
  <xsl:variable name="r45">
    <xsl:call-template name="prepend-attribute">
      <xsl:with-param name="attr" select="$node/@codeValue"/>
      <xsl:with-param name="list" select="$node/@type"/>
    </xsl:call-template>
  </xsl:variable>
  <xsl:variable name="r345">
    <xsl:call-template name="prepend-attribute">
      <xsl:with-param name="attr" select="$node/@codeSource"/>
      <xsl:with-param name="list" select="$r45"/>
    </xsl:call-template>
  </xsl:variable>
  <xsl:variable name="r2345">
    <xsl:call-template name="prepend-attribute">
      <xsl:with-param name="attr" select="$node/@referenceDate"/>
      <xsl:with-param name="list" select="$r345"/>
    </xsl:call-template>
  </xsl:variable>
  <xsl:variable name="r12345">
    <xsl:call-template name="prepend-attribute">
      <xsl:with-param name="attr" select="$node/@issuingAuthority"/>
      <xsl:with-param name="list" select="$r2345"/>
    </xsl:call-template>
  </xsl:variable>
  <xsl:if test="$r12345!=''">
    <xsl:text> (</xsl:text>
    <xsl:value-of select="$r12345"/>
    <xsl:text>)</xsl:text>
  </xsl:if>
</xsl:template>


<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->
<!--                    format-attributes-no-type                      -->
<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->

<!--   Formatting of a standard set of attributes (but no type)   -->

<xsl:template name="format-attributes-no-type">
  <xsl:param name="node" select="."/>
  <xsl:variable name="r34">
    <xsl:call-template name="prepend-attribute">
      <xsl:with-param name="attr" select="$node/@codeSource"/>
      <xsl:with-param name="list" select="$node/@codeValue"/>
    </xsl:call-template>
  </xsl:variable>
  <xsl:variable name="r234">
    <xsl:call-template name="prepend-attribute">
      <xsl:with-param name="attr" select="$node/@referenceDate"/>
      <xsl:with-param name="list" select="$r34"/>
    </xsl:call-template>
  </xsl:variable>
  <xsl:variable name="r1234">
    <xsl:call-template name="prepend-attribute">
      <xsl:with-param name="attr" select="$node/@issuingAuthority"/>
      <xsl:with-param name="list" select="$r234"/>
    </xsl:call-template>
  </xsl:variable>
  <xsl:if test="$r1234!=''">
    <xsl:text> (</xsl:text>
    <xsl:value-of select="$r1234"/>
    <xsl:text>)</xsl:text>
  </xsl:if>
</xsl:template>


<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->
<!--                     format-code-source-date                       -->
<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->

<!--   Formatting of a standard set of attributes (but no type)   -->

<xsl:template name="format-code-source-date">
  <xsl:param name="node" select="."/>
  <xsl:param name="date" select="./@referenceDate"/>
  <xsl:variable name="code-source">
    <xsl:call-template name="prepend-attribute">
      <xsl:with-param name="attr" select="$node/@codeSource"/>
      <xsl:with-param name="list" select="$date"/>
    </xsl:call-template>
  </xsl:variable>
  <xsl:choose>
    <xsl:when test="normalize-space($node/@codeValue)!=''">
      <xsl:value-of select="normalize-space($node/@codeValue)"/>
    </xsl:when>
    <xsl:otherwise>
      <xsl:text>Unknown Code</xsl:text>
    </xsl:otherwise>
  </xsl:choose>
  <xsl:if test="$code-source!=''">
    <xsl:text> (</xsl:text>
    <xsl:value-of select="$code-source"/>
    <xsl:text>)</xsl:text>
  </xsl:if>
</xsl:template>


<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->
<!--                     format-code-and-source                        -->
<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->

<!--   Another formatting for codeValue and codeSource attributes  -->

<xsl:template name="format-code-and-source">
  <xsl:param name="node" select="."/>
  <xsl:choose>
    <xsl:when test="($node/@codeValue!='') or ($node/@codeSource!='')">
      <xsl:choose>
        <xsl:when test="$node/@codeValue!=''">
          <xsl:value-of select="normalize-space($node/@codeValue)"/>
        </xsl:when>
        <xsl:otherwise>
          <xsl:text>Code Unknown</xsl:text>
        </xsl:otherwise>
      </xsl:choose>
      <xsl:text> (</xsl:text>
      <xsl:choose>
        <xsl:when test="$node/@codeSource!=''">
          <xsl:value-of select="$node/@codeSource"/>
        </xsl:when>
        <xsl:otherwise>
          <xsl:text>Source Unknown</xsl:text>
        </xsl:otherwise>
      </xsl:choose>
      <xsl:text>)</xsl:text>
    </xsl:when>
    <xsl:otherwise>
      <xsl:text>Code Unknown</xsl:text>
    </xsl:otherwise>
  </xsl:choose>
</xsl:template>


<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->
<!--                          format-height                            -->
<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->

<!--   Standard formatting for height  -->

<xsl:template name="format-height">
  <xsl:param name="height" select="."/>
  <xsl:choose>
    <xsl:when test="$height!=''">
      <xsl:choose>
        <xsl:when test="$height/@units='Inches'">
          <xsl:value-of select="floor(($height) div 12)"/>
          <xsl:text>'</xsl:text>
          <xsl:value-of select="($height) mod 12"/>
          <xsl:text>"</xsl:text>
        </xsl:when>
        <xsl:when test="$height/@units='FeetInches'">
          <xsl:value-of select="floor(($height) div 100)"/>
          <xsl:text>'</xsl:text>
          <xsl:value-of select="($height) mod 100"/>
          <xsl:text>"</xsl:text>
        </xsl:when>
        <xsl:otherwise>
          <xsl:value-of select="$height"/>
         <xsl:text> </xsl:text>
         <xsl:value-of select="$height/@units"/>
        </xsl:otherwise>
      </xsl:choose>
      <xsl:call-template name="format-attributes"/>
    </xsl:when>
    <xsl:otherwise>
      <xsl:text>Unknown</xsl:text>
    </xsl:otherwise>
  </xsl:choose>
</xsl:template>


<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->
<!--                          format-weight                            -->
<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->

<!--   Standard formatting for weight  -->

<xsl:template name="format-weight">
  <xsl:param name="weight" select="."/>
  <xsl:choose>
    <xsl:when test="$weight!=''">
      <xsl:value-of select="normalize-space($weight)"/>
      <xsl:if test="$weight/@units!=''">
         <xsl:text> </xsl:text>
         <xsl:value-of select="$weight/@units"/>
      </xsl:if>
      <xsl:call-template name="format-attributes"/>
    </xsl:when>
    <xsl:otherwise>
      <xsl:text>Unknown</xsl:text>
    </xsl:otherwise>
  </xsl:choose>
</xsl:template>


<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->
<!--                   format-agency-list-no-parens                    -->
<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->

<!--   Standard formatting for agency information  -->

<xsl:template name="format-agency-list-no-parens">
  <xsl:param name="node" select="."/>
  <xsl:param name="date"/>
  <xsl:variable name="ori" select="normalize-space($node/r:agency/r:ori)"/>
  <xsl:variable name="r45">
    <xsl:call-template name="prepend-attribute">
      <xsl:with-param name="attr" select="$ori"/>
      <xsl:with-param name="list" select="$date"/>
    </xsl:call-template>
  </xsl:variable>
  <xsl:variable name="r345">
    <xsl:call-template name="prepend-attribute">
      <xsl:with-param name="attr" 
                      select="$node/r:agency/r:entityAbbreviatedName"/>
      <xsl:with-param name="list" select="$r45"/>
    </xsl:call-template>
  </xsl:variable>
  <xsl:variable name="r2345">
    <xsl:call-template name="prepend-attribute">
      <xsl:with-param name="attr" select="$node/r:agency/r:entityName"/>
      <xsl:with-param name="list" select="$r345"/>
    </xsl:call-template>
  </xsl:variable>
  <xsl:variable name="r12345">
    <xsl:call-template name="prepend-attribute">
      <xsl:with-param name="attr" select="$node/r:agency/r:entityAcronym"/>
      <xsl:with-param name="list" select="$r2345"/>
    </xsl:call-template>
  </xsl:variable>
  <xsl:value-of select="$r12345"/>
</xsl:template>


<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->
<!--                       format-agency-list                          -->
<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->

<!--   Standard formatting for agency information  -->

<xsl:template name="format-agency-list">
  <xsl:param name="node" select="."/>
  <xsl:param name="date"/>
  <xsl:variable name="agency-list">
    <xsl:call-template name="format-agency-list-no-parens">
      <xsl:with-param name="node" select="$node"/>
      <xsl:with-param name="date" select="$date"/>
    </xsl:call-template>
  </xsl:variable>
  <xsl:if test="$agency-list!=''">
    <xsl:text> (</xsl:text>
    <xsl:value-of select="$agency-list"/>
    <xsl:text>)</xsl:text>
  </xsl:if>
</xsl:template>


<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->
<!--                          format-image                             -->
<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->

<!--   Standard formatting for image information  -->

<xsl:template name="format-image">
  <xsl:param name="node" select="."/>
  <xsl:variable name="data" select="normalize-space($node/r:imageData)"/>
  <DIV>
  <xsl:choose>
    <xsl:when test="$node/r:imageData/@contentEncoding!=''">
      <A HREF="a-generated-link"><xsl:text>Embedded Image</xsl:text></A>
    </xsl:when>
    <xsl:when test="$node/r:imageData/@href!=''">
      <xsl:choose>
        <xsl:when test="$data!=''">
          <A HREF="{$node/r:imageData/@href}">
            <xsl:value-of select="$data"/>
          </A>
        </xsl:when>
        <xsl:otherwise>
          <A HREF="{$node/r:imageData/@href}">
            <xsl:value-of select="$node/r:imageData/@href"/>
          </A>
        </xsl:otherwise>
      </xsl:choose>
    </xsl:when>
    <xsl:when test="starts-with(translate($data, 'htp', 'HTP'), 'HTTP')">
      <A HREF="{$data}"><xsl:value-of select="$data"/></A>
    </xsl:when>
    <xsl:when test="$data=''">
      <xsl:text>Contact agency for image</xsl:text>
    </xsl:when>
    <xsl:otherwise>
      <xsl:value-of select="$data"/>
    </xsl:otherwise>
  </xsl:choose>
  <xsl:call-template name="format-agency-list">
    <xsl:with-param name="node" select="$node"/>
  </xsl:call-template>
  </DIV>
  <xsl:for-each select="$node/r:comment">
    <DIV>
      <xsl:value-of select="normalize-space(.)"/>
    </DIV>
  </xsl:for-each>
</xsl:template>


<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->
<!--                        format-smt-image                           -->
<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->

<!--   Standard formatting for image information  -->

<xsl:template name="format-smt-image">
  <xsl:param name="node" select="."/>
  <xsl:variable name="data" select="normalize-space($node/r:imageData)"/>
  <DIV>
  <xsl:choose>
    <xsl:when test="$node/r:imageData/@contentEncoding!=''">
      <A HREF="a-generated-link"><xsl:text>Embedded Image</xsl:text></A>
    </xsl:when>
    <xsl:when test="$node/r:imageData/@href!=''">
      <xsl:choose>
        <xsl:when test="$data!=''">
          <A HREF="{$node/r:imageData/@href}">
            <xsl:value-of select="$data"/>
          </A>
        </xsl:when>
        <xsl:otherwise>
          <A HREF="{$node/r:imageData/@href}">
            <xsl:value-of select="$node/r:imageData/@href"/>
          </A>
        </xsl:otherwise>
      </xsl:choose>
    </xsl:when>
    <xsl:when test="starts-with(translate($data, 'htp', 'HTP'), 'HTTP')">
      <A HREF="{$data}"><xsl:value-of select="$data"/></A>
    </xsl:when>
    <xsl:when test="$data=''">
      <xsl:text>Contact agency for image</xsl:text>
    </xsl:when>
    <xsl:otherwise>
      <xsl:value-of select="$data"/>
    </xsl:otherwise>
  </xsl:choose>
  <xsl:call-template name="format-agency-list">
    <xsl:with-param name="node" select="$node"/>
    <xsl:with-param name="date" 
         select="normalize-space($node/@referenceDate)"/>
  </xsl:call-template>
  </DIV>
  <xsl:for-each select="$node/r:comment">
    <DIV>
      <xsl:value-of select="normalize-space(.)"/>
    </DIV>
  </xsl:for-each>
</xsl:template>


<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->
<!--                        format-smt-info                            -->
<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->

<!--   Standard formatting for most smt information  -->

<xsl:template name="format-smt-info">
  <xsl:param name="node" select="."/>
  <DIV>
    <xsl:if test="$node/r:scarsMarksTattoosDescription!=''">
      <xsl:value-of select="normalize-space($node/r:scarsMarksTattoosDescription)"/>
    </xsl:if>
    <xsl:call-template name="format-agency-list"/>
  </DIV>
  <xsl:choose>
    <xsl:when test="count($node/r:image)>0">
      <xsl:for-each select="$node/r:image">
        <xsl:sort select="@referenceDate" order="descending"/>
        <DIV>
          <xsl:call-template name="format-smt-image">
            <xsl:with-param name="node" select="."/>
          </xsl:call-template>
        </DIV>
      </xsl:for-each>
    </xsl:when>
    <xsl:otherwise>
      <xsl:text>Contact agency for image</xsl:text>
    </xsl:otherwise>
  </xsl:choose>
</xsl:template>


<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->
<!--                        format-fp-pp-p                             -->
<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->

<!--   Standard formatting for fingerPrint, palmPrint, and photo  -->

<xsl:template name="format-fp-pp-p">
  <xsl:param name="node" select="."/>
  <TD>
    <xsl:choose>
      <xsl:when test="$node/@type!=''">
        <xsl:value-of select="normalize-space($node/@type)"/>
      </xsl:when>
      <xsl:otherwise>
        <xsl:text>Unknown Code</xsl:text>
      </xsl:otherwise>
    </xsl:choose>
    <xsl:choose>
      <xsl:when test="$node/@referenceDate!=''">
        <xsl:text> (</xsl:text>
        <xsl:value-of select="normalize-space($node/@referenceDate)"/>
        <xsl:text>)</xsl:text>
      </xsl:when>
      <xsl:otherwise>
      </xsl:otherwise>
    </xsl:choose>
  </TD>
  <TD>
    <xsl:call-template name="format-image">
      <xsl:with-param name="node" select="$node"/>
    </xsl:call-template>
  </TD>

</xsl:template>


<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->
<!--                   format-physicalLocation-1C                      -->
<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->

<!--   Standard formatting for physicalLocation in one column  -->

<xsl:template name="format-physicalLocation-1C">
  <xsl:param name="pl" select="."/>
  <xsl:if test="$pl/r:locationType!=''">
    <DIV>
    <xsl:text>Location Type </xsl:text>
    <xsl:value-of select="normalize-space($pl/r:locationType)"/>
    </DIV>
  </xsl:if>
  <xsl:if test="$pl/r:location!=''">
    <xsl:call-template name="format-location">
      <xsl:with-param name="location" select="$pl/r:location"/>
    </xsl:call-template>
  </xsl:if>
  <xsl:if test="($pl/r:location!='') or ($pl/r:postalAddress!='')">
    <DIV/>
  </xsl:if>
  <xsl:if test="$pl/r:postalAddress!=''">
    <DIV>
    <xsl:text>Mailing Address </xsl:text>
    </DIV>
    <DIV>
    <xsl:call-template name="format-postalAddress">
      <xsl:with-param name="location" select="$pl/r:postalAddress"/>
    </xsl:call-template>
    </DIV>
  </xsl:if>
  <xsl:if test="$pl/r:relatedLocation!=''">
    <DIV>
    <xsl:text>Related Location </xsl:text>
    </DIV>
    <DIV>
    <xsl:value-of select="normalize-space($pl/r:relatedLocation)"/>
    </DIV>
  </xsl:if>
</xsl:template>


<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->
<!--                   format-physicalLocation-2C                      -->
<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->

<!--   Standard formatting for physicalLocation in two columns  -->

<xsl:template name="format-physicalLocation-2C">
  <xsl:param name="pl" select="."/>
  <xsl:if test="$pl/r:locationType!=''">
    <TR>
      <TD WIDTH="34%">Location Type</TD>
      <TD WIDTH="66%">
        <xsl:value-of select="normalize-space($pl/r:locationType)"/>
      </TD>
    </TR>
  </xsl:if>
  <xsl:if test="$pl/r:location!=''">
    <TR>
      <TD WIDTH="34%">Address</TD>
      <TD WIDTH="66%">
        <xsl:call-template name="format-location">
          <xsl:with-param name="location" select="$pl/r:location"/>
        </xsl:call-template>
      </TD>
    </TR>
  </xsl:if>
  <xsl:if test="$pl/r:postalAddress!=''">
    <TR>
      <TD WIDTH="34%">Mailing Address</TD>
      <TD WIDTH="66%">
        <xsl:call-template name="format-postalAddress">
          <xsl:with-param name="location" select="$pl/r:postalAddress"/>
        </xsl:call-template>
      </TD>
    </TR>
  </xsl:if>
  <xsl:if test="$pl/r:relatedLocation!=''">
    <TR>
    <TD WIDTH="34%">Related Location</TD>
    <TD WIDTH="66%">
      <xsl:value-of select="normalize-space($pl/r:relatedLocation)"/>
    </TD>
    </TR>
  </xsl:if>
</xsl:template>


<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->
<!--                         format-location                           -->
<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->

<!--   Standard formatting for location within physicalLocation  -->

<xsl:template name="format-location">
  <xsl:param name="location" select="./r:location"/>
  <xsl:for-each select="$location/r:addressLine">
    <DIV>
    <xsl:value-of select="normalize-space(.)"/>
    </DIV>
  </xsl:for-each>
  <xsl:if test="($location/r:streetNumber!='') or ($location/r:streetName!='')">
    <DIV>
    <xsl:if test="$location/r:streetNumber!=''">
      <xsl:value-of select="normalize-space($location/r:streetNumber)"/>
      <xsl:text> </xsl:text>
    </xsl:if>
    <xsl:if test="$location/r:streetDirection!=''">
      <xsl:value-of select="normalize-space($location/r:streetDirection)"/>
      <xsl:text> </xsl:text>
    </xsl:if>
    <xsl:if test="$location/r:streetName!=''">
      <xsl:value-of select="normalize-space($location/r:streetName)"/>
      <xsl:text> </xsl:text>
    </xsl:if>
    <xsl:if test="$location/r:streetType!=''">
      <xsl:value-of select="normalize-space($location/r:streetType)"/>
    </xsl:if>
    </DIV>
  </xsl:if>
  <xsl:if test="($location/r:buildingName!='') or ($location/r:apartmentNumber!='') or ($location/r:suite!='')">
    <DIV>
    <xsl:if test="$location/r:buildingName!=''">
      <xsl:value-of select="normalize-space($location/r:buildingName)"/>
      <xsl:text> Building </xsl:text>
    </xsl:if>
    <xsl:if test="$location/r:apartmentNumber!=''">
      <xsl:text>Apartment </xsl:text>
      <xsl:value-of select="normalize-space($location/r:apartmentNumber)"/>
      <xsl:text> </xsl:text>
    </xsl:if>
    <xsl:if test="$location/r:suite!=''">
      <xsl:text>Suite </xsl:text>
      <xsl:value-of select="normalize-space($location/r:suite)"/>
    </xsl:if>
    </DIV>
  </xsl:if>
  <xsl:if test="$location/r:postOfficeBox!=''">
    <DIV>
    <xsl:text>PO Box </xsl:text>
    <xsl:value-of select="normalize-space($location/r:postOfficeBox)"/>
    </DIV>
  </xsl:if>
  <xsl:if test="$location/r:privateMailBox!=''">
    <DIV>
    <xsl:text>MSC </xsl:text>
    <xsl:value-of select="normalize-space($location/r:privateMailBox)"/>
    </DIV>
  </xsl:if>
  <xsl:if test="$location/r:county!=''">
    <DIV>
    <xsl:value-of select="normalize-space($location/r:county)"/>
    <xsl:text> County</xsl:text>
    </DIV>
  </xsl:if>
  <xsl:if test="($location/r:city!='') or ($location/r:state!='') or ($location/r:postalCode!='') or ($location/r:country!='')">
    <DIV>
    <xsl:if test="$location/r:city!=''">
      <xsl:value-of select="normalize-space($location/r:city)"/>
    </xsl:if>
    <xsl:if test="$location/r:state!=''">
      <xsl:text>, </xsl:text>
      <xsl:value-of select="normalize-space($location/r:state)"/>
    </xsl:if>
    <xsl:if test="$location/r:postalCode!=''">
      <xsl:text> </xsl:text>
      <xsl:value-of select="normalize-space($location/r:postalCode)"/>
    </xsl:if>
    <xsl:if test="$location/r:country!=''">
      <xsl:text> </xsl:text>
      <xsl:value-of select="normalize-space($location/r:country)"/>
    </xsl:if>
    </DIV>
  </xsl:if>
  <xsl:if test="($location/r:latitude!='') or ($location/r:longitude!='')">
    <DIV>
    <xsl:value-of select="normalize-space($location/r:latitude)"/>
    <xsl:text>, </xsl:text>
    <xsl:value-of select="normalize-space($location/r:longitude)"/>
    </DIV>
  </xsl:if>
</xsl:template>


<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->
<!--                      format-postalAddress                         -->
<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->

<!--   Standard formatting for postalAddress within physicalLocation  -->

<xsl:template name="format-postalAddress">
  <xsl:param name="location" select="./r:postalAddress"/>
  <xsl:if test="$location/r:fullAddress!=''">
    <DIV>
    <xsl:value-of select="normalize-space($location/r:fullAddress)"/>
    </DIV>
  </xsl:if>
  <xsl:for-each select="$location/r:addressLine">
    <DIV>
    <xsl:value-of select="normalize-space(.)"/>
    </DIV>
  </xsl:for-each>
  <xsl:if test="$location/r:apartmentNumber!=''">
    <DIV>
    <xsl:text>Apartment </xsl:text>
    <xsl:value-of select="normalize-space($location/r:apartmentNumber)"/>
    </DIV>
  </xsl:if>
  <xsl:if test="$location/r:suite!=''">
    <DIV>
    <xsl:text>Suite </xsl:text>
    <xsl:value-of select="normalize-space($location/r:suite)"/>
    </DIV>
  </xsl:if>
  <xsl:if test="$location/r:privateMailBox!=''">
    <DIV>
    <xsl:text>MSC </xsl:text>
    <xsl:value-of select="normalize-space($location/r:privateMailBox)"/>
    </DIV>
  </xsl:if>
  <xsl:if test="$location/r:county!=''">
    <DIV>
    <xsl:value-of select="normalize-space($location/r:county)"/>
    <xsl:text> County</xsl:text>
    </DIV>
  </xsl:if>
  <xsl:if test="($location/r:city!='') or ($location/r:state!='') or ($location/r:postalCode!='') or ($location/r:country!='')">
    <DIV>
    <xsl:if test="$location/r:city!=''">
      <xsl:value-of select="normalize-space($location/r:city)"/>
    </xsl:if>
    <xsl:if test="$location/r:state!=''">
      <xsl:text>, </xsl:text>
      <xsl:value-of select="normalize-space($location/r:state)"/>
    </xsl:if>
    <xsl:if test="$location/r:postalCode!=''">
      <xsl:text> </xsl:text>
      <xsl:value-of select="normalize-space($location/r:postalCode)"/>
    </xsl:if>
    <xsl:if test="$location/r:country!=''">
      <xsl:text> </xsl:text>
      <xsl:value-of select="normalize-space($location/r:country)"/>
    </xsl:if>
    </DIV>
  </xsl:if>
</xsl:template>


<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->
<!--                          append-number                            -->
<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->

<!--   Append a number to a telephone number sequence   -->

<!--   This is a variation of prepent-attribute but it works in the
       opposite direction and uses hyphens instead of semicolons 
       and spaces
-->

<xsl:template name="append-number">
  <xsl:param name="segment"/>
  <xsl:param name="number"/>
  <xsl:param name="separator">
    <xsl:text>-</xsl:text>
  </xsl:param>
  <xsl:variable name="result">
    <xsl:choose>
    <xsl:when test="$number!=''">
      <xsl:choose>
        <xsl:when test="$segment!=''">
          <xsl:value-of select="$number"/>
          <xsl:value-of select="$separator"/>
          <xsl:value-of select="$segment"/>
        </xsl:when>
        <xsl:otherwise>
          <xsl:value-of select="$number"/>
        </xsl:otherwise>
      </xsl:choose>
    </xsl:when>
    <xsl:otherwise>
      <xsl:value-of select="$segment"/>
    </xsl:otherwise>
    </xsl:choose>
  </xsl:variable>
  <xsl:value-of select="$result"/>
</xsl:template>


<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->
<!--                        format-telephone                           -->
<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->

<!--   Formatting of a telephone number   -->

<xsl:template name="format-telephone">
  <xsl:param name="node" select="."/>
  <xsl:variable name="r45">
    <xsl:call-template name="append-number">
      <xsl:with-param name="segment" select="$node/r:telephonePrefix/r:telephoneCityCode"/>
      <xsl:with-param name="number"  select="$node/r:telephonePrefix/r:telephoneCountryCode"/>
    </xsl:call-template>
  </xsl:variable>
  <xsl:variable name="r345">
    <xsl:call-template name="append-number">
      <xsl:with-param name="segment" select="$node/r:telephonePrefix/r:areaCode"/>
      <xsl:with-param name="number"  select="$r45"/>
    </xsl:call-template>
  </xsl:variable>
  <xsl:variable name="r2345">
    <xsl:call-template name="append-number">
      <xsl:with-param name="segment" select="$node/r:telephoneNumber"/>
      <xsl:with-param name="number"  select="$r345"/>
    </xsl:call-template>
  </xsl:variable>
  <xsl:variable name="r12345">
    <xsl:call-template name="append-number">
      <xsl:with-param name="segment" select="$node/r:telephoneSuffix"/>
      <xsl:with-param name="number"  select="$r2345"/>
      <xsl:with-param name="separator">
        <xsl:text> </xsl:text>
      </xsl:with-param>
    </xsl:call-template>
  </xsl:variable>
  <xsl:value-of select="$r12345"/>
</xsl:template>


<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->
<!--                          format-charge                            -->
<!-- - - - - - - - - - - - - - - - -+- - - - - - - - - - - - - - - - - -->

<!--   Formatting of a charge   -->

<xsl:template name="format-charge">
  <xsl:param name="node" select="."/>

  <TR>
    <TD COLSPAN="2">
      <B>
        <xsl:text>Charge</xsl:text>
        <xsl:if test="r:chargeSequenceNumber!=''">
          <xsl:text> </xsl:text>
          <xsl:value-of select="normalize-space(r:chargeSequenceNumber)"/>
        </xsl:if>
      </B>
    </TD>
  </TR>

  <xsl:if test="r:chargeNumber!=''">
    <TR>
      <TD ALIGN="RIGHT">Charge Number</TD>
      <TD>
        <xsl:value-of select="normalize-space(r:chargeNumber)"/>
      </TD>
    </TR>
  </xsl:if>

  <xsl:if test="r:chargeTrackingNumber!=''">
    <TR>
      <TD ALIGN="RIGHT">Charge Tracking Number</TD>
      <TD>
        <xsl:value-of select="normalize-space(r:chargeTrackingNumber)"/>
      </TD>
    </TR>
  </xsl:if>

  <xsl:if test="count(r:chargeCaseNumber)>0">
    <TR>
      <TD ALIGN="RIGHT">Charge Case Number</TD>
      <TD>
        <xsl:value-of select="normalize-space(r:chargeCaseNumber)"/>
      </TD>
    </TR>
  </xsl:if>

  <xsl:if test="count(r:agency)>0">
    <TR>
      <TD ALIGN="RIGHT" WIDTH="34%">Agency</TD>
      <TD WIDTH="66%">
        <xsl:call-template name="format-agency-list-no-parens"/>
      </TD>
    </TR>
  </xsl:if>

  <xsl:if test="count(r:offenseDate)>0">
    <TR>
      <TD ALIGN="RIGHT">Offense Date</TD>
      <TD>
        <xsl:value-of select="normalize-space(r:offenseDate)"/>
      </TD>
    </TR>
  </xsl:if>

  <xsl:if test="count(r:chargeName)>0">
    <TR>
      <TD ALIGN="RIGHT">Charge Description</TD>
      <TD>
        <xsl:value-of select="normalize-space(r:chargeName)"/>
      </TD>
    </TR>
  </xsl:if>

  <xsl:if test="count(r:chargeStatute)>0">
    <TR>
      <TD ALIGN="RIGHT">Statute</TD>
      <TD>
        <xsl:for-each select="r:chargeStatute">
          <DIV>
          <xsl:value-of select="normalize-space(.)"/>
          <xsl:call-template name="format-attributes"/>
          </DIV>
        </xsl:for-each>
      </TD>
    </TR>
  </xsl:if>

  <xsl:if test="count(r:offenseCode[@codeSource='NCIC'])>0">
    <TR>
      <TD ALIGN="RIGHT">NCIC Offense Code</TD>
      <TD>
        <xsl:for-each select="r:offenseCode[@codeSource='NCIC']">
          <xsl:if test="position()>1">
            <xsl:text>, </xsl:text>
          </xsl:if>
          <xsl:value-of select="normalize-space(.)"/>
        </xsl:for-each>
      </TD>
    </TR>
  </xsl:if>  

  <xsl:if test="count(r:offenseCode[@codeSource!='NCIC'])>0">
    <TR>
      <TD ALIGN="RIGHT">State Offense Code</TD>
      <TD>
        <xsl:for-each select="r:offenseCode[@codeSource!='NCIC']">
          <xsl:if test="position()>1">
            <xsl:text>, </xsl:text>
          </xsl:if>
          <xsl:value-of select="normalize-space(.)"/>
          <xsl:call-template name="format-attributes"/>
        </xsl:for-each>
      </TD>
    </TR>
  </xsl:if>  

  <xsl:if test="count(r:numberOfIdenticalCharges)>0">
    <TR>
      <TD ALIGN="RIGHT">Counts</TD>
      <TD>
        <DIV>
          <xsl:value-of select="normalize-space(r:numberOfIdenticalCharges)"/>
        </DIV>
      </TD>
    </TR>
  </xsl:if>

  <xsl:if test="count(r:chargeSeverity)>0">
    <TR>
      <TD ALIGN="RIGHT">Severity</TD>
      <TD>
        <DIV>
          <xsl:value-of select="normalize-space(r:chargeSeverity)"/>
        </DIV>
      </TD>
    </TR>
  </xsl:if>

  <xsl:if test="count(r:inchoateCharge)>0">
    <TR>
      <TD ALIGN="RIGHT">Inchoate Charge</TD>
      <TD>
        <xsl:for-each select="r:inchoateCharge">
          <xsl:if test="position()>1">
            <xsl:text>, </xsl:text>
          </xsl:if>
          <xsl:value-of select="normalize-space(.)"/>
        </xsl:for-each>
      </TD>
    </TR>
  </xsl:if>  

  <xsl:if test="count(r:chargeEnhancingFactor)>0">
    <TR>
      <TD ALIGN="RIGHT">Enhancing Factor</TD>
      <TD>
        <xsl:for-each select="r:chargeEnhancingFactor">
          <DIV>
          <xsl:value-of select="normalize-space(.)"/>
          </DIV>
        </xsl:for-each>
      </TD>
    </TR>
  </xsl:if>  

  <xsl:if test="count(r:chargeReducingFactor)>0">
    <TR>
      <TD ALIGN="RIGHT">Reducing Factor</TD>
      <TD>
        <xsl:for-each select="r:chargeReducingFactor">
          <DIV>
          <xsl:value-of select="normalize-space(.)"/>
          </DIV>
        </xsl:for-each>
      </TD>
    </TR>
  </xsl:if>  

  <xsl:if test="count(r:chargeDisposition)>0">
    <TR>
      <TD ALIGN="RIGHT">Disposition</TD>
      <TD>
        <xsl:for-each select="r:chargeDisposition">
          <DIV>
          <xsl:value-of select="normalize-space(.)"/>
          <xsl:call-template name="format-attributes"/>
          </DIV>
        </xsl:for-each>
      </TD>
    </TR>
  </xsl:if>  

  <xsl:if test="count(r:comment)>0">
    <TR>
      <TD ALIGN="RIGHT">
        <xsl:text>Comment(s)</xsl:text>
      </TD>
      <TD>
        <xsl:for-each select="r:comment">
          <DIV>
            <xsl:value-of select="normalize-space(.)"/>
          </DIV>
        </xsl:for-each>
      </TD>
    </TR>
  </xsl:if>
</xsl:template>

</xsl:stylesheet>