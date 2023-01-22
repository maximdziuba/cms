import React, { Component } from "react";
import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import CheckButton from "react-validation/build/button";
import CssBaseline from '@mui/material/CssBaseline';
import ResponsiveAppBar from '../Navbar';
import { Grid } from "@mui/material";
import { Paper } from "@mui/material";
import { TextField } from "@mui/material";
import { Button } from "@mui/material";
import { Typography } from "@mui/material";

import { createTheme, ThemeProvider } from '@mui/material/styles';


import AdminAuthService from "../../services/AdminAuthService";

import { withRouter } from "../../with-router";

const theme = createTheme();

const required = value => {
  if (!value) {
    return (
      <div className="alert alert-danger" role="alert">
        This field is required!
      </div>
    );
  }
};

function findElementInArray(elements, name) {
  const el = elements.find((el) => (el.name === name));
  const elementText = el?.text;
  return elementText;
}

class AdminLogin extends Component {
  constructor(props) {
    super(props);
    this.handleLogin = this.handleLogin.bind(this);
    this.onChangeUsername = this.onChangeUsername.bind(this);
    this.onChangePassword = this.onChangePassword.bind(this);

    this.state = {
      username: "",
      password: "",
      loading: false,
      message: "",
      loginPageTitle: "",
      logo: ""
    };
  }

  componentDidMount() {
    fetch("http://localhost:8080/pages/loginPage")
        .then((res) => res.json())
        .then((json) => {
            this.setState({
                loginPageTitle: findElementInArray(json.pageElements, 'login page changed'),
                logo: findElementInArray(json.pageElements, 'logo')
            });
        });
  };

  onChangeUsername(e) {
    this.setState({
      username: e.target.value
    });
  }

  onChangePassword(e) {
    this.setState({
      password: e.target.value
    });
  }

  handleLogin(e) {
    e.preventDefault();

    this.setState({
      message: "",
      loading: true
    });

    this.form.validateAll();

    const data = new FormData(e.currentTarget);
    const email = data.get('email');
    const password = data.get('password');
    
      AdminAuthService.login(email, password).then(
        () => {
          this.props.router.navigate("/home");
          window.location.reload();
        },
        error => {
          const resMessage =
            (error.response &&
              error.response.data &&
              error.response.data.message) ||
            error.message ||
            error.toString();

          this.setState({
            loading: false,
            message: resMessage
          });
        }
      );
  }

  render() {
    return (
      <ThemeProvider theme={theme}>
      <ResponsiveAppBar logo={ this.state.logo } />
      <Grid container component="main" sx={{ height: '100vh' }}>
        <CssBaseline />
        <Grid
          item
          xs={false}
          sm={4}
          md={7}
          sx={{
            backgroundImage: 'url(https://source.unsplash.com/random)',
            backgroundRepeat: 'no-repeat',
            backgroundColor: (t) =>
              t.palette.mode === 'light' ? t.palette.grey[50] : t.palette.grey[900],
            backgroundSize: 'cover',
            backgroundPosition: 'center',
          }}
        />
      <Grid item xs={12} sm={8} md={5} component={Paper} elevation={6} square>
      <Typography component="h1" variant="h5">
              { this.state.loginPageTitle }
        </Typography>
          <Form
            onSubmit={this.handleLogin}
            ref={c => {
              this.form = c;
            }}
          >
            <TextField
                margin="normal"
                required
                fullWidth
                id="email"
                label="Email Address"
                name="email"
                autoComplete="email"
                autoFocus
              />

              <TextField
                margin="normal"
                required
                fullWidth
                name="password"
                label="Password"
                type="password"
                id="password"
                autoComplete="current-password"
              />


            <div className="form-group">
            <Button
                type="submit"
                fullWidth
                variant="contained"
                sx={{ mt: 3, mb: 2 }}
              >
              
                {this.state.loading && (
                  <span className="spinner-border spinner-border-sm"></span>
                )}
                <span>Login</span>
                </Button>
            </div>

            {this.state.message && (
              <div className="form-group">
                <div className="alert alert-danger" role="alert">
                  {this.state.message}
                </div>
              </div>
            )}
          </Form>
        </Grid>
      </Grid>
    </ThemeProvider>
    );
  }
}

export default withRouter(AdminLogin);