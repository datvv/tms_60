<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<div class="subjectDetail">
	<div class="subject">
		<h2>
			<s:property value="subject.name" />
		</h2>
	</div>
	<div class="tasks">
		<form action="editTaskStatus" method="post">
			<ul class="list-group">
				<s:iterator value="taskList" status="stat" var="task">
					<li class="list-group-item"><span class="badge"><s:checkbox
								name="taskList[%{#stat.index}].status" /></span> <s:property
							value="%{#task.name}" /></li>
				</s:iterator>
				<div id="btn">
					<s:submit type="button">
						<s:param name="value">
							<fmt:message key="msg.update" />
						</s:param>
					</s:submit>
				</div>
			</ul>
		</form>
	</div>
	<div class="row-content">
		<h2>
			<fmt:message key="msg.basicInfo" />
		</h2>
		<strong><fmt:message key="msg.startDate" /></strong>
		<s:property value="%{subject.startDate}" />
		<br /> <strong><fmt:message key="msg.endDate" /> </strong>
		<s:property value="%{subject.endDate}" />
		<br /> <strong><fmt:message key="msg.status" /> </strong>
		<s:property value="%{userSubject.status}" />
		<br />
	</div>
	<div class="row-content">
		<h2>
			<fmt:message key="msg.instruction" />
			<s:a href="#" id="hideInstruction">
				<fmt:message key="msg.hide" />
			</s:a>
		</h2>

		<div id="instruction">
			<s:property value="%{subject.instruction}" />
		</div>
	</div>
	<div class="row-content">
		<h2>
			<fmt:message key="msg.activity" />
		</h2>
		<s:iterator value="%{activityList}" var="activity">
			<s:property value="#activity.content" />
			<br />
		</s:iterator>
	</div>

</div>

