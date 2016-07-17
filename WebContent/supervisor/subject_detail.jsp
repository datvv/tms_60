<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<div class="subjectDetail">
	<div class="subject">
		<h2>
			<s:property value="courseSubject.subject.name" />
		</h2>
	</div>
	<div class="tasks">
		<form action="editTaskStatus" method="post">
			<ul class="list-group">
				<s:iterator value="courseSubject.subject.tasks" status="stat"
					var="task">
					<li class="list-group-item"><span class="badge"></span> <s:property
							value="%{#task.name}" /></li>
				</s:iterator>
			</ul>
		</form>
	</div>
	<div id="finish-subject">
		<s:a href="finishSubject">
			<fmt:message key="msg.finishSubject" />
		</s:a>
	</div>
	<div class="row-content">
		<h2>
			<fmt:message key="msg.basicInfo" />
		</h2>
		<strong><fmt:message key="msg.startDate" /></strong>
		<s:property value="%{courseSubject.subject.startDate}" />
		<br /> <strong><fmt:message key="msg.endDate" /> </strong>
		<s:property value="%{courseSubject.subject.endDate}" />
		<br /> <strong><fmt:message key="msg.status" /> </strong>
		<s:property value="%{courseSubject.status}" />
		<br />
	</div>
	<div class="row-content">
		<h2>
			<fmt:message key="msg.trainees" />
		</h2>
		<div id="trainees">
			<s:iterator value="courseSubject.userSubjects" var="userSubject">
				<s:if test="%{#userSubject.user.role == role_user}">
					<s:a href="abcdef?traineeId=%{#userSubject.user.id}">
						<s:property value="#userSubject.user.username" />
					</s:a>
				</s:if>
			</s:iterator>
		</div>
	</div>
	<div class="row-content">
		<h2>
			<fmt:message key="msg.supervisors" />
		</h2>
		<div id="supervisors">
			<s:iterator value="courseSubject.userSubjects" var="userSubject">
				<s:if test="%{#userSubject.user.role == role_supervisor}">
					<s:a href="abcdef?supervisorId=%{#userSubject.user.id}">
						<s:property value="#userSubject.user.username" />
					</s:a>
				</s:if>
			</s:iterator>
		</div>
	</div>
	<div class="row-content">
		<h2>
			<fmt:message key="msg.instruction" />
			<s:a href="#" id="hideInstruction">
				<fmt:message key="msg.hide" />
			</s:a>
		</h2>
		<div id="instruction">
			<s:property value="%{courseSubject.subject.instruction}" />
		</div>
	</div>
</div>