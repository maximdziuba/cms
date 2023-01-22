import axios from "axios";

const API_URL = "http://localhost:8081/";

class AdminAuthService {
  login(email, password) {
    return axios
      .post(API_URL + "auth", {
        email: email,
        password: password
      })
      .then(response => {
        if (response.data.accessToken) {
          localStorage.setItem("jwtToken", JSON.stringify(response.data.jwtToken));
        }

        return response.data.jwtToken;
      });
  }

  logout() {
    localStorage.removeItem("user");
  }

  register(username, email, password) {
    return axios.post(API_URL + "registration", {
      username,
      email,
      password
    });
  }

  getCurrentUser() {
    return JSON.parse(localStorage.getItem('user'));;
  }
}

export default new AdminAuthService();