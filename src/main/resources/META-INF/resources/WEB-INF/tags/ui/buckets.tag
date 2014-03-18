<%@ tag language="java" pageEncoding="UTF-8" description="Popup view of a definition" body-content="scriptless" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="proctor" uri="http://tags.indeed.com/proctor" %>
<%@ attribute name="definition" required="true" type="com.indeed.proctor.common.model.TestDefinition" %>
<c:set var="hasPayload" value="${!empty definition.buckets && !empty definition.buckets[0].payload}"/>
<table class="w100 fixed">
    <thead>
    <tr>
        <th class="one">Value</th>
        <th class="two">Name</th>
        <c:if test="${!hasPayload}"><th>Description</th></c:if>
        <c:if test="${hasPayload}"><th class="four">Description</th>
            <th>Payload</th>
        </c:if>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${definition.buckets}" var="bucket">
        <tr>
            <td class="one">${bucket.value}</td>
            <td class="two">${bucket.name}</td>
            <td <c:if test="${hasPayload}">class="four"</c:if> >${bucket.description}</td>
            <c:if test="${hasPayload}">
                <td>${proctor:prettyPrintJSONPayloadContents(bucket.payload)}</td>
            </c:if>
        </tr>
    </c:forEach>
    </tbody>
</table>
