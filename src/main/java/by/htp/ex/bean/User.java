package by.htp.ex.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private String email;
	private Integer userId;
	private String username;
	private String password;
	private String role;
	private List<News> listOfNews;

	public User() {

	}

	public User(String role, Integer userId) {
		this.role = role;
		this.userId = userId;
	}

	public User(String username, String password, String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<News> getListOfNews() {
		return listOfNews;
	}

	public void setListOfNews(List<News> listOfNews) {
		this.listOfNews = listOfNews;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, listOfNews, password, role, userId, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(listOfNews, other.listOfNews)
				&& Objects.equals(password, other.password) && Objects.equals(role, other.role)
				&& Objects.equals(userId, other.userId) && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "NewUserInfo [email=" + email + ", userId=" + userId + ", username=" + username + ", password="
				+ password + ", role=" + role + ", listOfNews=" + listOfNews + "]";
	}
}
