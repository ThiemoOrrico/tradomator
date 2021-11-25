import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import {
    BrowserRouter as Router
} from "react-router-dom";
import AuthProvider from "./context/AuthProvider";
import theme from "./styling/theme";
import {ThemeProvider} from "@emotion/react";

ReactDOM.render(
    <React.StrictMode>
        <ThemeProvider theme={theme}>
        <Router>
            <AuthProvider>
                <App/>
            </AuthProvider>
        </Router>
        </ThemeProvider>
    </React.StrictMode>,
    document.getElementById('root')
);

reportWebVitals();
