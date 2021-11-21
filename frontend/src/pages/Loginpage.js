import React, {useContext, useState} from 'react';
import {AuthContext} from "../context/AuthProvider";

const initialState = {
    username: "",
    password: ""
}

export default function Loginpage() {

const [credentials, setCrededtials] = useState(initialState);
const {login} = useContext(AuthContext)


const handleChange = event => {
    setCrededtials({...credentials, [event.target.name] : event.target.value})
}

const handleSubmit = event => {
    event.preventDefault()
    login(credentials)
}

    return (

        <form onSubmit={handleSubmit}>
            <label> Username
                <input
                    type="text"
                    required
                    value={credentials.username}
                    name="username"
                    onChange={handleChange}
                />
            </label>
            <label> Password
                <input
                    type="password"
                    required
                    value={credentials.password}
                    name="password"
                    onChange={handleChange}
                />
            </label>
            <button>Login</button>
        </form>

    )
};

