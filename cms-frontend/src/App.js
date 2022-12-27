import { BrowserRouter, Route, Routes } from 'react-router-dom';
import React from 'react';
import './App.css';
import SignInSide from './components/Login.js'
import MainPage from "./components/MainPage";


class App extends React.Component {

    render() {
    return(
        <BrowserRouter>
        <Routes>
            <Route path="/" element={<SignInSide />} />
            <Route path="/home" element={<MainPage />} />
        </Routes>
            
        </BrowserRouter>
        );
    }
}

export default App;
