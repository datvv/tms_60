package framgiavn.project02.web.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String username;
	private String password;
	private String email;
	private String socialId;
	private String avatar;
	private String role;
	private Set<Activity> activities = new HashSet<Activity>(0);
	private Set<UserSubject> userSubjects = new HashSet<UserSubject>(0);
	private Set<UserTask> userTasks = new HashSet<UserTask>(0);
	private Set<UserCourse> userCourses = new HashSet<UserCourse>(0);

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSocialId() {
		return socialId;
	}

	public void setSocialId(String socialId) {
		this.socialId = socialId;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<Activity> getActivities() {
		return activities;
	}

	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}

	public Set<UserSubject> getUserSubjects() {
		return userSubjects;
	}

	public void setUserSubjects(Set<UserSubject> userSubjects) {
		this.userSubjects = userSubjects;
	}

	public Set<UserTask> getUserTasks() {
		return userTasks;
	}

	public void setUserTasks(Set<UserTask> userTasks) {
		this.userTasks = userTasks;
	}

	public Set<UserCourse> getUserCourses() {
		return userCourses;
	}

	public void setUserCourses(Set<UserCourse> userCourses) {
		this.userCourses = userCourses;
	}

}