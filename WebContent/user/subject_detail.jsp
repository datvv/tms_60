<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<div class="subjectDetail">
	<div class="tasks">
		<form action="#" method="#">
			<ul class="list-group">
				<s:iterator value="%{taskList}" var="task">
					<li class="list-group-item"><span class="badge"><s:checkbox
								name="#task.status" /></span> <s:property value="#task.name" /></li>
				</s:iterator>
				<s:submit type="button">
					<s:param name="value">
						<fmt:message key="msg.update" />
					</s:param>
				</s:submit>
			</ul>
		</form>
	</div>
</div>

