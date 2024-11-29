<?xml version="1.0"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform"> 
<xsl:template match="/">
<html>
<body>
<h1>BOOK INFORMATION</h1>
<TABLE border="1">
<tr>
<th>titleofthebook</th>
<th>Authorname</th>
<th>ISBNnumber</th>
<th>publication</th>
<th>edition</th>
<th>price</th>
</tr>
<xsl:for-each select="book-info/books">
<tr>
<td> <xsl:value-of select="titleofthebook"/> </td>
<td> <xsl:value-of select="Authorname"/> </td>
<td> <xsl:value-of select="ISBNnumber"/> </td>
<td> <xsl:value-of select="publication"/> </td>
<td> <xsl:value-of select="edition"/> </td>
<td> <xsl:value-of select="price"/> </td>
</tr>
</xsl:for-each>
</TABLE>
</body>
</html>
</xsl:template>
</xsl:stylesheet>