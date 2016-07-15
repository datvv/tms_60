<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<s:label name="course.name" id="headName" />
<fmt:message key="msg.subjectList" />
<br />
<c:forEach items="${course.subjectList}" var="oneSubject">
	<td>${oneSubject.name}</td>
	<br />
</c:forEach>
<br />
<fmt:message key="msg.instruction" />
<br />
<s:label name="course.instruction" />