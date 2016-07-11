<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<h1><fmt:message key="msg.user"/></h1>
<a href="j_spring_security_logout"><fmt:message key="msg.logout"/></a>

<s:a action="showSubjecDetail"><fmt:message key="msg.subjecPage" /> </s:a>