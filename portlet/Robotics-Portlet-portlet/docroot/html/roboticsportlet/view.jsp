<%--
/**
* Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
*
* This library is free software; you can redistribute it and/or modify it under
* the terms of the GNU Lesser General Public License as published by the Free
* Software Foundation; either version 2.1 of the License, or (at your option)
* any later version.
*
* This library is distributed in the hope that it will be useful, but WITHOUT
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
* FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
* details.
*/
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>

<portlet:defineObjects />

This is the <b>RoboticsPortlet</b> portlet in View mode.
<br/>
Please insert the values in single decimal.
<br/>
<br/>
<br/>


<portlet:resourceURL var="getResult" id="getResult"></portlet:resourceURL>

<div id="message" style="font-weight: bold;color: blue;">
</div>
<form id="RobotInputForm" name="RobotInputForm">
 
        Distance : <input id="distance" name="distance" /><br/>
        Weight :  <input id="weight"  name="weight" />
        

</form>
<aui:button name="saveButton" type="submit" value="GetData" onClick="getData(document.getElementById('distance').value,document.getElementById('weight').value);" /> 

<script type="text/javascript">
var getResultURL = "<%=getResult%>";
var messageDiv = "#message";


</script>
<script src="/Robotics-Portlet-portlet/js/main.js"></script>


