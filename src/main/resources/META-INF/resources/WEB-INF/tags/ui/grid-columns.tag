<%@ tag language="java" pageEncoding="UTF-8" description="Simple 2 columns grid-row" body-content="scriptless" %>
<%@ attribute name="width" required="true" type="java.lang.String" rtexprvalue="true" %>
<div class="${width} columns">
<jsp:doBody />
</div>

