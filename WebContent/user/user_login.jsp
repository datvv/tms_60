<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div>
	<h1>
		<fmt:message key="msg.login_title"></fmt:message>
	</h1>
	<s:if test="%{#parameters.error != null}">
		<div style="color: red">Invalid User</div>
	</s:if>
	<s:form name="loginForm" action="j_spring_security_check" method="post">
		<s:textfield name="username">
			<s:param name="label">
				<fmt:message key="msg.username"/>
			</s:param>
		</s:textfield>
		<s:password name="password">
			<s:param name="label">
				<fmt:message key="msg.password"/>
			</s:param>
		</s:password>
		<s:submit type="button">
			<s:param name="value">
				<fmt:message key="msg.login"/>
			</s:param>
		</s:submit>
	</s:form>
</div>