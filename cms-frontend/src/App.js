import React from 'react';
import './App.css';
import SignInSide from './components/Login.js'


function findElementInArray(elements, name) {
    const el = elements.find((el) => (el.name === name));
    const elementText = el.text;
    return elementText;
}

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
          loginPageElements: [],
        };
    };

    componentDidMount() {
      fetch("http://localhost:8080/pages/loginPage")
          .then((res) => res.json())
          .then((json) => {
              this.setState({
                  loginPageTitle: findElementInArray(json.pageElements, 'loginPageTitle'),
                  logo: findElementInArray(json.pageElements, 'logo')
              });
          });
    };
   
    render() {
        const loginPageTitle = this.state.loginPageTitle;
        const logo = this.state.logo;
        return (
            
            <>
                <SignInSide loginPageTitle={ loginPageTitle } logo={ logo } />
            </>
        );
    }
}

export default App;
